package main;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.awt.GradientPaint;

import entity.Entity;
import entity.GameState;
import entity.Player;
import object.OBJ_Bale;
import object.OBJ_MapTile;
import object.OBJ_MapTile2;
import object.OBJ_MapTile3;
import object.OBJ_MapTile4;
import object.OBJ_MapTile5;
import object.OBJ_MapTile6;
import object.OBJ_MapTile7;
import object.OBJ_MapTile8;
import object.OBJ_MapTile9;

public class UI {

    Graphics2D g2;
    Font novaNook;
    BufferedImage hayBaleImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; //0: Title 2: Controls
    public int playerSlotCol = 0;
    public int playerSlotRow = 0;
    public static BufferedImage image;
    public int npcSlotCol = 0;
    public int npcSlotRow = 0;
    int substate = 0;
    public Entity npc;
    public static boolean vPressed = false;  
    public int maxInventorySize;
    public static boolean mapVisible = false;
    BufferedImage[] mapShardImages = new BufferedImage[10];
    public KeyHandler keyH;
    static int itemIndex;
    static int slotCol;
    static int slotRow;
 
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public UI() {
        this.keyH = new KeyHandler();
    
        Path path = Paths.get("res/fonts/ChailceNogginRegular-2OXoW.ttf");
        try (InputStream is = Files.newInputStream(path)) {
            novaNook = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        OBJ_Bale bale = new OBJ_Bale();
        hayBaleImage = bale.down1; // Ensure this is not null

    }
    

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;
        g2.setFont(novaNook);
        g2.setColor(Color.white);

        if (messageOn == true) {

            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, GamePanel.tileSize/2, GamePanel.tileSize*3);

            messageCounter++;

            if (messageCounter > 90) {
                messageCounter = 0;
                messageOn = false; 
            }
        }

        if(Main.gp.gameState == GameState.titleState) {
            drawTitleScreen();
        }
        if(Main.gp.gameState == GameState.playState) {

        }
        if(Main.gp.gameState == GameState.pauseState) {
            drawPauseScreen();
        }
        if(Main.gp.gameState == GameState.dialogueState) {
            drawDialogueScreen();
        }
        //stats state
        if(Main.gp.gameState == GameState.statsState) {
            drawStatsScreen();
            drawInventory(Main.gp.player, true);
        }
        //thumb map state
        if(Main.gp.gameState == GameState.thumbState) {
            drawThumbMap();
            drawInventory(Main.gp.player, true);
        }
        if (Main.gp.gameState == GameState.optionsState) {
            drawOptionsScreen();
        }
        if (Main.gp.gameState == GameState.tradeState) {
            drawTradeScreen();
        }
    }

    public void drawThumbMap() {
        try {
            image = getMapShardImageName();
            if (image == null) return;

            int scaleFactor = 6;
            int scaledWidth = image.getWidth() * scaleFactor;
            int scaledHeight = image.getHeight() * scaleFactor;

            g2.drawImage(image, 0, 282, scaledWidth, scaledHeight, null);

            // Main.gp.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void drawTitleScreen() {  
        if(titleScreenState == 0) {
            // Thanksgiving-Themed Gradient Background
            Color color1 = new Color(205, 92, 92); // Warm reddish-brown
            Color color2 = new Color(255, 165, 0); // Pumpkin orange
            Color color3 = new Color(218, 165, 32); // Golden yellow
    
            // Multi-stop gradient effect
            int midHeight = GamePanel.screenHeight / 2;
            GradientPaint gradientTop = new GradientPaint(0, 0, color1, 0, midHeight, color2);
            g2.setPaint(gradientTop);
            g2.fillRect(0, 0, GamePanel.screenWidth, midHeight);

            GradientPaint gradientBottom = new GradientPaint(0, midHeight, color2, 0, GamePanel.screenHeight, color3);
            g2.setPaint(gradientBottom);
            g2.fillRect(0, midHeight, GamePanel.screenWidth, GamePanel.screenHeight);

            // Title Text
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
            String titleText = "The Road Back Home";
            int x = getXforCenteredText(titleText);
            int y = GamePanel.tileSize * 3;

            // Shaded effect for title
            g2.setColor(new Color(139, 69, 19, 180)); // Transparent dark brown for shadow
            g2.drawString(titleText, x + 5, y + 5); // Shadow offset
            g2.setColor(new Color(255, 255, 255)); // Bright white for main text
            g2.drawString(titleText, x, y);

            // Subtitle or tagline
            g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 40F));
            String tagline = "An Adventure Awaits...";
            x = getXforCenteredText(tagline);
            y += GamePanel.tileSize;
            g2.setColor(new Color(255, 223, 186, 200)); // Light creamy white
            g2.drawString(tagline, x, y);

            // Menu Options
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 48F));
            String[] options = { "NEW GAME", "CONTROLS", "QUIT" };
            y += GamePanel.tileSize * 2;

            for (int i = 0; i < options.length; i++) {
                String option = options[i];
                x = getXforCenteredText(option);

                // Highlight selected option
                if (commandNum == i) {
                    g2.setColor(new Color(0, 0, 0)); // Bright orange for the highlight
                    g2.drawString(">", x - GamePanel.tileSize, y); // Highlight marker
                }
                g2.setColor(Color.white);
                g2.drawString(option, x, y);
                y += GamePanel.tileSize * 2; // Spacing between options
            }

            // Footer
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
            String footer = "Press ENTER to select";
            x = getXforCenteredText(footer);
            y = GamePanel.screenHeight - GamePanel.tileSize;
            g2.setColor(Color.white);
            g2.drawString(footer, x, y);
        }
        else if(titleScreenState == 1) {
            // Background - Thanksgiving Gradient
            Color color1 = new Color(205, 92, 92); // Warm reddish-brown
            Color color2 = new Color(255, 165, 0); // Pumpkin orange
            GradientPaint gradient = new GradientPaint(0, 0, color1, 0, GamePanel.screenHeight, color2);
            g2.setPaint(gradient);
            g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);

            // Title: Controls
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            String text = "Controls";
            int x = getXforCenteredText(text);
            int y = GamePanel.tileSize * 2;

            // Shadow effect for title
            g2.setColor(new Color(139, 69, 19, 180)); // Transparent dark brown for shadow
            g2.drawString(text, x + 5, y + 5); // Shadow offset
            g2.setColor(Color.white); // Main title color
            g2.drawString(text, x, y);

            // Controls list
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
            String[] controls = {
                "W: Move Up",
                "A: Move Left",
                "S: Move Down",
                "D: Move Right",
                "P: Pause Game",
                "Enter: Interact"
            };

            y += GamePanel.tileSize * 2; // Spacing after title
            for (String control : controls) {
                x = getXforCenteredText(control);
                g2.setColor(Color.white);
                g2.drawString(control, x, y);
                y += GamePanel.tileSize; // Line spacing
            }

            // Back Option
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
            text = "BACK";
            x = getXforCenteredText(text);
            y += GamePanel.tileSize;

            // Highlight for "Back" option
            if (commandNum == 0) {
                g2.setColor(new Color(0, 0, 0)); // Bright orange highlight
                g2.drawString(">", x - GamePanel.tileSize, y);
            }
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
        }

        
    }
    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String pauseText = "PAUSED";

        int x = getXforCenteredText(pauseText);;
        int y = GamePanel.screenHeight/2;

        g2.drawString(pauseText, x, y);
    }

    public void drawDialogueScreen() {
        int x = GamePanel.tileSize * 3;
        int y = GamePanel.tileSize/2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 6);
        int height = GamePanel.tileSize * 4;

        drawSubWindow(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
        
    }
    
    public void drawStatsScreen() {
        //Subwindow
        final int frameX = GamePanel.tileSize * 0;
        final int frameY = GamePanel.tileSize * 6;
        final int frameWidth = GamePanel.tileSize * 7;
        final int frameHeight = GamePanel.tileSize * 6;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        
        //Text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + GamePanel.tileSize;
        final int lineHeight = 32;

        g2.drawString("Likeability:", textX, textY);
        textY += lineHeight * 3;
        g2.drawString("Car Parts:", textX, textY);
        textY += lineHeight * 3;

        //Add Values
        int tailX = (frameX + frameWidth) - 30;
        //Reset
        textY = frameY + GamePanel.tileSize;
        String value;

        value = String.valueOf(Entity.likeabilityCounter);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight * 3;

        value = String.valueOf(Player.numCarParts);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight * 2;
    }

    public static boolean isHoveringOverMapShard() {
        slotCol = Main.gp.ui.playerSlotCol;
        slotRow = Main.gp.ui.playerSlotRow; 
        int itemIndex = Main.gp.ui.getItemIndexOnSlot(slotCol, slotRow);

        if (itemIndex >= 0 && itemIndex < Main.gp.player.inventory.size()) {
            Entity selectedItem = Main.gp.player.inventory.get(itemIndex);
            return selectedItem.name.startsWith("Map Shard");
        }
        return false; 
    }

    public static BufferedImage getMapShardImageName() {
        int slotCol = Main.gp.ui.playerSlotCol;
        int slotRow = Main.gp.ui.playerSlotRow;
        int itemIndex = Main.gp.ui.getItemIndexOnSlot(slotCol, slotRow);

        System.out.println("SlotCol: " + slotCol + ", SlotRow: " + slotRow);
        System.out.println("ItemIndex: " + itemIndex);

        if (itemIndex >= 0 && itemIndex < Main.gp.player.inventory.size()) {
            Entity selectedItem = Main.gp.player.inventory.get(itemIndex);
            System.out.println("Selected Item: " + selectedItem.name);
            System.out.println("vPressed: " + vPressed);

            switch (selectedItem.name) {
                case "Map Shard":
                    image = new OBJ_MapTile().down1;
                    break;
                case "Map Shard 2":
                    image = new OBJ_MapTile2().down1;
                    break;
                case "Map Shard 3":
                    image = new OBJ_MapTile3().down1;
                    break;
                case "Map Shard 4":
                    image = new OBJ_MapTile4().down1;
                    break;
                case "Map Shard 5":
                    image = new OBJ_MapTile5().down1;
                    break;
                case "Map Shard 6":
                    image = new OBJ_MapTile6().down1;
                    break;
                case "Map Shard 7":
                    image = new OBJ_MapTile7().down1;
                    break;
                case "Map Shard 8":
                    image = new OBJ_MapTile8().down1;
                    break;
                case "Map Shard 9":
                    image = new OBJ_MapTile9().down1;
                    break;
                default:
                    System.out.println("No matching map shard found.");
                    return image;
                }
        } else {
            System.out.println("No item found in inventory slot.");
        }
        return image;
    }

    public void drawInventory(Entity entity, boolean cursor) {

        int frameX = 0;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;
        maxInventorySize = 30;


        if(entity == Main.gp.player) {
            frameX = GamePanel.tileSize*9;
            frameY = GamePanel.tileSize*0;
            frameWidth = GamePanel.tileSize * 7;
            frameHeight = GamePanel.tileSize * 6;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;
        }
        else {
            frameX = GamePanel.tileSize*0;
            frameY = GamePanel.tileSize*0;
            frameWidth = GamePanel.tileSize * 7;
            frameHeight = GamePanel.tileSize * 6;
            slotCol = npcSlotCol;
            slotRow = npcSlotRow;
        }

        //Frame
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        
        //Slot
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = GamePanel.tileSize + 3;

        //Draw Player Items
        for(int i = 0; i < entity.inventory.size(); i++) {
            g2.drawImage(entity.inventory.get(i).down1, slotX, slotY, null);
            slotX += slotSize;

            // Display Amount
            if(entity.inventory.get(i).amount > 1) {
                g2.setFont(g2.getFont().deriveFont(32f));
                int amountx;
                int amounty;

                String s = "" + entity.inventory.get(i).amount;
                amountx = getXforAlignToRightText(s, slotX + 3);
                amounty = slotY + GamePanel.tileSize;

                g2.setColor(new Color(60, 60, 60));
                g2.drawString(s, amountx, amounty);

                g2.setColor(Color.white);
                g2.drawString(s, amountx - 3, amounty - 3);
            }

            if(i == 5 || i == 11 || i == 17 || i == 23) {
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //Cursor
        if(cursor == true) {
            int cursorX = slotXstart + (slotSize * slotCol);
            int cursorY = slotYstart + (slotSize * slotRow);
            int cursorWidth = GamePanel.tileSize;
            int cursorHeight = GamePanel.tileSize;
        
            //Draw cursor
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

            //Description frame
            int dFrameX = frameX;
            int dFrameY = frameY + frameHeight;
            int dFrameWidth = frameWidth;
            int dFrameHeight = GamePanel.tileSize*6;

            //Description Text
            int textX = dFrameX + 20;
            int textY = dFrameY + GamePanel.tileSize;
            g2.setFont(g2.getFont().deriveFont(28F));

            int itemIndex = getItemIndexOnSlot(slotCol, slotRow);

            if(itemIndex < entity.inventory.size()) {
                drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);
                for(String line: entity.inventory.get(itemIndex).description.split("\n")) {
                    g2.drawString(line, textX, textY);
                    textY += 32;
                }
            }
        }
        
    }

    public void toggleMapDisplay() {
        mapVisible = !mapVisible;
    }

    public void drawOptionsScreen() {
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        // Sub Window
        int frameX = GamePanel.tileSize * 4;
        int frameY = GamePanel.tileSize;
        int frameWidth = GamePanel.tileSize * 8;
        int frameHeight = GamePanel.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // Check substate to determine which screen to draw
        switch (substate) {
            case 0:
                options_top(frameX, frameY); // Main options menu
                break;
            case 1:
                options_control(frameX, frameY); // Controls submenu
                break;
            case 2:
                options_endGameConfirmation(frameX, frameY); // Confirmation screen
                break;
        }
    }
    public void drawTradeScreen() {
        switch(substate) {
            case 0: trade_select(); break;
            case 1: trade_buy(); break;
            case 2: trade_sell(); break;
        }
    
        // Reset enterPressed flag only after action has been taken
        if (Main.gp.keyH.enterPressed) {
            Main.gp.keyH.enterPressed = false;  // Reset only after action
        }
    }
    
    public void trade_select() {
        drawDialogueScreen();
    
        int x = GamePanel.tileSize * 10;
        int y = GamePanel.tileSize * 5;
        int width = GamePanel.tileSize * 3;
        int height = (int)(GamePanel.tileSize * 3.5);
    
        drawSubWindow(x, y, width, height);
    
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;
        g2.drawString("Trade?", x, y);
        if(commandNum == 0) {
            g2.drawString(">", x-24, y);
            if(Main.gp.keyH.enterPressed == true) {
                substate = 1;  // Proceed to trade_buy
                Main.gp.keyH.enterPressed = false;  // Reset to avoid fast updating
            }
        }
        y += GamePanel.tileSize;
        g2.drawString("Leave", x, y);
        if(commandNum == 1) {
            g2.drawString(">", x-24, y);
            if(Main.gp.keyH.enterPressed == true) {
                Main.gp.gameState = GameState.playState;
                Main.gp.keyH.enterPressed = false;  // Reset after leaving
            }
        }
    }
    
    public void trade_buy() {

        // Player Inventory
        drawInventory(Main.gp.player, false);
        // NPC Inventory
        drawInventory(npc, true);
        
        int x = GamePanel.tileSize * 10;
        int y = GamePanel.tileSize * 10;
        int width = GamePanel.tileSize * 6;
        int height = GamePanel.tileSize * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] Back", x + 24, y + 60);
        
        // Ensure that Enter triggers the buy logic
    
        // Buy
        if (Main.gp.keyH.enterPressed == true) {
            if (npc.inventory.get(itemIndex).price == 10) {
                if (npc.inventory.get(itemIndex).price > Main.gp.player.numBales) {
                    substate = 1;
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "You need more haybales!";
                    drawDialogueScreen();
                } else if (Main.gp.player.inventory.size() == maxInventorySize) {
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "Your inventory is full!";
                    drawDialogueScreen();
                } else {
                    // Deduct haybales from player's inventory
                    Main.gp.player.numBales -= npc.inventory.get(itemIndex).price;
                    
                    // Add the purchased item to the player's inventory
                    Main.gp.player.inventory.add(npc.inventory.get(itemIndex));
                    
                    // Clear NPC's inventory
                    npc.inventory.clear();
                    
                    // Loop through and remove cost items from player's inventory
                    for (int i = 0; i < Main.gp.player.inventory.size(); i++) {
                        if (Main.gp.player.inventory.get(i).name.equals("Haybale")) {
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                        }
                    }
                    
                    substate = 0;
                    entity.Player.numCarParts++;
                    System.out.println("Car part collected! Total parts: " + entity.Player.numCarParts);
                    Main.gp.ui.showMessage("You found a car part!");
                    
                    // Increment likeability counter
                    for (int j = 0; j < 5; j++) {
                        Player.likeabilityCounter++;
                    }
                }

                Main.gp.keyH.enterPressed = false;
            } else if (npc.inventory.get(itemIndex).price == 1) {
                if (npc.inventory.get(itemIndex).price > Main.gp.player.numOil) {
                    substate = 1;
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "You need some oil!";
                    drawDialogueScreen();
                } else if (Main.gp.player.inventory.size() == maxInventorySize) {
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "Your inventory is full!";
                    drawDialogueScreen();
                } else {
                    // Deduct oil from player's inventory
                    Main.gp.player.numOil -= npc.inventory.get(itemIndex).price;
    
                    // Add the purchased item to the player's inventory
                    Main.gp.player.inventory.add(npc.inventory.get(itemIndex));
    
                    // Clear NPC's inventory
                    npc.inventory.clear();
    
                    // Loop through and remove cost items from player's inventory
                    for (int i = 0; i < Main.gp.player.inventory.size(); i++) {
                        if (Main.gp.player.inventory.get(i).name.equals("Oil")) {
                            Main.gp.player.inventory.remove(i);
                            break; // exit the loop after removing one instance of the item
                        }
                    }
    
                    substate = 0;
                    entity.Player.numCarParts++;
                    System.out.println("Car part collected! Total parts: " + entity.Player.numCarParts);
                    Main.gp.ui.showMessage("You found a car part!");
                    
                    // Increment likeability counter
                    for (int j = 0; j < 5; j++) {
                        Player.likeabilityCounter++;
                    }
                }

                Main.gp.keyH.enterPressed = false;
            } else if (npc.inventory.get(itemIndex).price == 5) {
                if (npc.inventory.get(itemIndex).price > Main.gp.player.numCanes) {
                    substate = 1;
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "You need more sugarcane!";
                    drawDialogueScreen();
                } else if (Main.gp.player.inventory.size() == maxInventorySize) {
                    Main.gp.gameState = GameState.dialogueState;
                    currentDialogue = "Your inventory is full!";
                    drawDialogueScreen();
                } else {
                    // Deduct sugarcane from player's inventory
                    for (int i = 0; i < 5; i++) {
                        Main.gp.player.numCanes -= npc.inventory.get(itemIndex).price;
                    }
    
                    // Add the purchased item to the player's inventory
                    Main.gp.player.inventory.add(npc.inventory.get(itemIndex));
    
                    // Clear NPC's inventory
                    npc.inventory.clear();
    
                    // Loop through and remove cost items from player's inventory
                    for (int i = 0; i < Main.gp.player.inventory.size(); i++) {
                        if (Main.gp.player.inventory.get(i).name.equals("Sugarcane")) {
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                            Main.gp.player.inventory.remove(i);
                        }
                    }
    
                    substate = 0;
                    entity.Player.numCarParts++;
                    System.out.println("Car part collected! Total parts: " + entity.Player.numCarParts);
                    Main.gp.ui.showMessage("You found a car part!");
                    
                    // Increment likeability counter
                    for (int j = 0; j < 5; j++) {
                        Player.likeabilityCounter++;
                    }
                }

                Main.gp.keyH.enterPressed = false;
            }
        }
    }
    
    public void trade_sell() {

        // Draw player inventory
        drawInventory(Main.gp.player, true);

        int x;
        int y;
        int width;
        int height;

        x = GamePanel.tileSize * 10;
        y = GamePanel.tileSize * 10;
        width = GamePanel.tileSize * 6;
        height = GamePanel.tileSize * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] Back", x+24, y+60);

        // Sell
        if(Main.gp.keyH.enterPressed == true) {
            
        }
    }

    public void options_top(int frameX, int frameY) {
        // int frameWidth = GamePanel.tileSize * 8;
        int textX = getXforAlignToLeftText("", frameX); // Positioning from left of frame
        int textY;
        int sliderX = textX + GamePanel.tileSize * 4; // Position slider a bit right of the text
        int sliderWidth = GamePanel.tileSize * 2; // Set the width of the slider bar
        int maxVolumeScale = 5; // 0-5 volume scale levels

        String text = "Options";
        textY = frameY + GamePanel.tileSize;
        g2.drawString(text, textX, textY);

        // Music Option
        textY += GamePanel.tileSize * 2;
        g2.drawString("Music", textX, textY);

        if (commandNum == 0) { // Check if Music option is selected
            // Draw the cursor for the selected option
            g2.drawString(">", textX-25, textY);

            // Draw the music slider bar
            g2.setColor(Color.gray);
            g2.fillRect(sliderX, textY - GamePanel.tileSize / 4, sliderWidth, GamePanel.tileSize / 4);

            // Draw the slider handle based on the current volume scale
            int handlePosition = sliderX + (Main.gp.sound.volumeScale * sliderWidth / maxVolumeScale);
            g2.setColor(Color.white);
            g2.fillRect(handlePosition - 5, textY - GamePanel.tileSize / 4, 10, GamePanel.tileSize / 4);
        }

        // Control Option
        textY += GamePanel.tileSize * 2;
        g2.drawString("Controls", textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX-25, textY);
            if (Main.gp.keyH.enterPressed) {
                substate = 1; // Switch to controls submenu
                commandNum = 0; // Reset command number to 0 when entering submenu
                Main.gp.keyH.enterPressed = false; // Reset the enter key press to avoid multiple presses
            }
        }

        // Quit Game Option
        textY += GamePanel.tileSize * 2;
        g2.drawString("Quit Game", textX, textY);
        if (commandNum == 2) {
            g2.drawString(">", textX-25, textY);
            if (Main.gp.keyH.enterPressed) {
                substate = 2;
                commandNum = 0;
            }
        }

        // Back Option
        textY += GamePanel.tileSize * 2;
        g2.drawString("Back", textX, textY);
        if (commandNum == 3) {
            g2.drawString(">", textX-25, textY);
            if(Main.gp.keyH.enterPressed) {
                // Reset state and commandNum when exiting the options menu
                Main.gp.gameState = GameState.playState;
                commandNum = 0;
                substate = 0;
                Main.gp.keyH.enterPressed = false; // Reset enter press
            }
        }
    }



    public void options_control(int frameX, int frameY) {
        int textX;
        int textY;

        String text = "Controls";
        textX = getXforCenteredText(text);
        textY = frameY + GamePanel.tileSize;
        g2.drawString(text, textX, textY);

        textX = frameX + GamePanel.tileSize;
        textY += GamePanel.tileSize*1.5;
        g2.drawString("Move", textX, textY); textY += GamePanel.tileSize*1.25;
        g2.drawString("Interact", textX, textY); textY+=GamePanel.tileSize*1.25;
        g2.drawString("Inventory", textX, textY); textY+=GamePanel.tileSize*1.25;
        g2.drawString("Pause", textX, textY); textY +=GamePanel.tileSize*1.25;
        g2.drawString("Options", textX, textY); textY+=GamePanel.tileSize*1.25;

        textX = frameX + GamePanel.tileSize*5;
        textY = (int) (frameY + GamePanel.tileSize*2.5);
        g2.drawString("WASD", textX, textY); textY += GamePanel.tileSize*1.25;
        g2.drawString("ENTER", textX, textY); textY += GamePanel.tileSize*1.25;
        g2.drawString("C", textX, textY); textY += GamePanel.tileSize*1.25;
        g2.drawString("P", textX, textY); textY += GamePanel.tileSize*1.25;
        g2.drawString("ESC", textX, textY); textY += GamePanel.tileSize*1.25;

        // "Back" option for returning to the previous menu
        textX = frameX + GamePanel.tileSize;
        textY = frameY + GamePanel.tileSize*9;
        g2.drawString("Back", textX, textY);
    
        if (commandNum == 0) {
            g2.drawString(">", textX-25, textY);
            if (Main.gp.keyH.enterPressed) {
                substate = 0; // Return to the main options menu
                Main.gp.keyH.enterPressed = false; // Reset enter key press to avoid multiple presses
            }
        }
    }

    public void options_endGameConfirmation(int frameX, int frameY) {
        System.exit(0);
    }


    public int getItemIndexOnSlot(int slotCol, int slotRow) {
        itemIndex = slotCol + (slotRow*6);
        return itemIndex;
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    public int getXforCenteredText(String pauseText) { 
        int length = (int)g2.getFontMetrics().getStringBounds(pauseText, g2).getWidth();
        int x = GamePanel.screenWidth/2 - length/2;
        return x;
    }
    public int getXforAlignToRightText(String text, int tailX) { 
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

    public int getXforAlignToLeftText(String text, int frameX) { 
    // Set left margin to align text within the subwindow
        int margin = 48; // Adjust this value as needed for more/less spacing
        return frameX + margin;
    }
}