package entity;

import main.Main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    public boolean collisionOn = false;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction = "down";

    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;

    // Item Prices
    public int price;
    public boolean stackable = false;
    public int amount = 1;

    public BufferedImage image;
    public String name;
    public boolean collision = false;

    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int inventorySize = 30;

    //Player Stats
    public int gratitudeCounter;
    public static int numCarParts;
    public static int likeabilityCounter;
    public GamePanel gp;

    public String description = "";

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void speak() {
        if(dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }

    public void setAction() {

    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
    
        // Check if the entity is an NPC (or any other specific type you want to exclude from the red rectangle)
        if (this instanceof BoyNPC) {
            // For NPCs, always draw them even if the image is null
            if (down1 != null) {
                g2.drawImage(down1, screenX, screenY, gp.tileSize, gp.tileSize, null);
            } else {
                // If NPC image is null, draw a placeholder (e.g., a blue square)
                g2.setColor(Color.BLUE);
                g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
            }
            return;  // Skip the red rectangle and other logic for NPCs
        }
    
        // For all other entities (non-NPCs), check if down1 is null and draw the red rectangle
        if (down1 != null) {
            g2.drawImage(down1, screenX, screenY, gp.tileSize, gp.tileSize, null);
        } else {
            // If down1 is null, draw a red rectangle (except for NPCs)
            g2.setColor(Color.RED);
            g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
        }
    }
    
    

    public BufferedImage setup(String imageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(imageName));
            if (image == null) {
                // System.out.println("Image is null for: " + imageName); // Debug if the image is null
            } else {
                // System.out.println("Image loaded successfully: " + imageName); // Debug if image is loaded
            }
            image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
            if (gp == null) {
            throw new NullPointerException("GamePanel (gp) is null in OBJ_BrokenCar constructor!");
            }

        } catch (IOException e) {
            // System.out.println("Error loading image: " + imageName); // Debug any loading errors
            e.printStackTrace();
        }
        return image;
    }

    public void setCollision(boolean state) {
        this.collision = state;
    }


}
