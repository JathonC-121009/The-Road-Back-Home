package entity;

import main.Main;
import main.GamePanel;
import main.KeyHandler;
import object.*;
import main.Sound;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int numBales = 0;
    public int numOil = 0;
    public int numCanes = 0;
    public int numMapShards = 0;
    public static int numCarParts = 0; // Counter for car parts collected
    private boolean isInteracting = false;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(Main.gp);
        this.keyH = keyH;

        screenX = Main.gp.screenWidth / 2 - (Main.gp.tileSize / 2);
        screenY = Main.gp.screenHeight / 2 - (Main.gp.tileSize / 2);

        solidArea.x = 12;
        solidArea.y = 18;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 26;
        solidArea.height = 26;

        setDefaultValues();
        getPlayerImage();
        setItems();
    }

    public void setDefaultValues() {
        worldX = Main.gp.tileSize * 93;
        worldY = Main.gp.tileSize * 2;
        speed = 5;
        direction = "down";

        // Default Player Stats
        gratitudeCounter = 0;
        numCarParts = 0;
        likeabilityCounter = 0;
    }

    public void setItems() {
    }

    public void getPlayerImage() {
        up1 = setup("res/player/boy_up_1.png");
        up2 = setup("res/player/boy_up_2.png");
        right1 = setup("res/player/boy_right_1.png");
        right2 = setup("res/player/boy_right_2.png");
        left1 = setup("res/player/boy_left_1.png");
        left2 = setup("res/player/boy_left_2.png");
        down1 = setup("res/player/boy_down_left.png");
        down2 = setup("res/player/boy_down_right.png");
    }

    public void update() {
        if (isInteracting) return; // Prevent movement during interaction

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) direction = "up";
            else if (keyH.downPressed) direction = "down";
            else if (keyH.leftPressed) direction = "left";
            else if (keyH.rightPressed) direction = "right";

            Main.gp.cChecker.checkTile(this);
            int objIndex = Main.gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            int npcIndex = Main.gp.cChecker.checkEntity(this, Main.gp.npc);
            interactNPC(npcIndex);

            if (direction.equals("up") && !collisionOn) worldY -= speed;
            if (direction.equals("down") && !collisionOn) worldY += speed;
            if (direction.equals("left") && !collisionOn) worldX -= speed;
            if (direction.equals("right") && !collisionOn) worldX += speed;

            spriteCounter++;
            if (spriteCounter > 12) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }


    public void interactNPC(int i) {
        if (i != 999) {
            if (Main.gp.keyH.enterPressed) {
                System.out.println("You are hitting boy_npc");
                Main.gp.gameState = Main.gp.dialogueState; // Correct game state
                Main.gp.npc[i].speak();
                likeabilityCounter++;
            }
        }
        Main.gp.keyH.enterPressed = false;
    }

    public void pickUpObject(int i) {
        if (i != 999) {
            Entity obj = Main.gp.obj[i];
            //Main.gp.playMusic(1);

            // Check for specific objects
            if (obj instanceof OBJ_BrokenCar) {
                interactWithBrokenCar((OBJ_BrokenCar) obj);
            } else if (obj instanceof OBJ_Wheel || obj instanceof OBJ_Window || obj instanceof OBJ_Steering) {
                numCarParts++;
                System.out.println("Car part collected! Total parts: " + numCarParts);
                Main.gp.ui.showMessage("You found a car part!");
                Main.gp.obj[i] = null;
            } else if (obj instanceof OBJ_Oil) {
                numOil++;
                System.out.println("You got oil! Total: " + numOil);
                Main.gp.ui.showMessage("You got oil!");
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_Oil(Main.gp));
            } else if (obj instanceof OBJ_Bale) {
                numBales++;
                System.out.println("You got a haybale! Total: " + numBales);
                Main.gp.ui.showMessage("You got a haybale!");
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_Bale(Main.gp));
            } else if (obj instanceof OBJ_Sugarcane) {
                numCanes++;
                System.out.println("You got sugarcane! Total: " + numCanes);
                Main.gp.ui.showMessage("You got sugarcane!");
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_Sugarcane(Main.gp));
            } else if (obj instanceof OBJ_MapShard) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard(Main.gp));
            } else if (obj instanceof OBJ_MapShard2) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard2(Main.gp));
            } else if (obj instanceof OBJ_MapShard3) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard3(Main.gp));
            } else if (obj instanceof OBJ_MapShard4) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard4(Main.gp));
            } else if (obj instanceof OBJ_MapShard5) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard5(Main.gp));
            } else if (obj instanceof OBJ_MapShard6) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard6(Main.gp));
            } else if (obj instanceof OBJ_MapShard7) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard7(Main.gp));
            } else if (obj instanceof OBJ_MapShard8) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard8(Main.gp));
            } else if (obj instanceof OBJ_MapShard9) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                Main.gp.obj[i] = null;
                Main.gp.player.inventory.add(new OBJ_MapShard9(Main.gp));
            }
        }
    }

    private void interactWithBrokenCar(OBJ_BrokenCar car) {
        System.out.println("Interacting with broken car...");

        isInteracting = true; // Prevent movement during interaction

        if (numCarParts == 3) {
            car.isFunctional = true;

            System.out.println("You assembled the car! It’s functional now.");
            Main.gp.ui.showMessage("Your car is repaired!");

            new Thread(() -> {
                try {
                    // Start fade to black and wait for it to complete
                    int fadeLevel = 0; // Start fade level
                    while (fadeLevel < 255) {
                        fadeLevel += 5;
                        Main.gp.fadeAlpha = fadeLevel; // Update fade effect
                        Main.gp.repaint(); // Trigger repaint for fade effect
                        Thread.sleep(50); // Delay between fade steps
                    }

                    // Once fade is complete, show credits
                    Main.gp.fadeAlpha = 0; // Reset fade for credits
                    Main.gp.repaint();
                    Main.gp.showCredits();

                    isInteracting = false; // Allow movement after credits
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            System.out.println("Not enough car parts.");
            Main.gp.ui.showMessage("You need more parts to repair the car.");
            isInteracting = false;
        }
    }



    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int screenX = worldX - Main.gp.player.worldX + Main.gp.player.screenX;
        int screenY = worldY - Main.gp.player.worldY + Main.gp.player.screenY;

        if (worldX + Main.gp.tileSize > Main.gp.player.worldX - Main.gp.player.screenX &&
                worldX - Main.gp.tileSize < Main.gp.player.worldX + Main.gp.player.screenX &&
                worldY + Main.gp.tileSize > Main.gp.player.worldY - Main.gp.player.screenY &&
                worldY - Main.gp.tileSize < Main.gp.player.worldY + Main.gp.player.screenY) {
            // Draw player sprite based on direction
            switch (direction) {
                case "up" -> image = (spriteNum == 1) ? up1 : up2;
                case "down" -> image = (spriteNum == 1) ? down1 : down2;
                case "left" -> image = (spriteNum == 1) ? left1 : left2;
                case "right" -> image = (spriteNum == 1) ? right1 : right2;
            }

            if (image != null) {
                g2.drawImage(image, screenX, screenY, null);
            }
        }
    }
}
