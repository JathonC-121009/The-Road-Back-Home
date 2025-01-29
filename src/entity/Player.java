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
    private GamePanel gp;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp  = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

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
        worldX = gp.tileSize * 93;
        worldY = gp.tileSize * 2;
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

            gp.cChecker.checkTile(this);
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
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
            if (gp.keyH.enterPressed) {
                System.out.println("You are hitting boy_npc");
                gp.gameState = gp.dialogueState; // Correct game state
                gp.npc[i].speak();
                likeabilityCounter++;
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void pickUpObject(int i) {
        if (i != 999) {
            Entity obj = gp.obj[i];
            //gp.playMusic(1);

            // Check for specific objects
            if (obj instanceof OBJ_BrokenCar) {
                interactWithBrokenCar((OBJ_BrokenCar) obj);
            } else if (obj instanceof OBJ_Wheel || obj instanceof OBJ_Window || obj instanceof OBJ_Steering) {
                numCarParts++;
                System.out.println("Car part collected! Total parts: " + numCarParts);
                gp.ui.showMessage("You found a car part!");
                gp.obj[i] = null;
            } else if (obj instanceof OBJ_Oil) {
                numOil++;
                System.out.println("You got oil! Total: " + numOil);
                gp.ui.showMessage("You got oil!");
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_Oil(gp));
            } else if (obj instanceof OBJ_Bale) {
                numBales++;
                System.out.println("You got a haybale! Total: " + numBales);
                gp.ui.showMessage("You got a haybale!");
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_Bale(gp));
            } else if (obj instanceof OBJ_Sugarcane) {
                numCanes++;
                System.out.println("You got sugarcane! Total: " + numCanes);
                gp.ui.showMessage("You got sugarcane!");
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_Sugarcane(gp));
            } else if (obj instanceof OBJ_MapShard) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard(gp));
            } else if (obj instanceof OBJ_MapShard2) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard2(gp));
            } else if (obj instanceof OBJ_MapShard3) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard3(gp));
            } else if (obj instanceof OBJ_MapShard4) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard4(gp));
            } else if (obj instanceof OBJ_MapShard5) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard5(gp));
            } else if (obj instanceof OBJ_MapShard6) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard6(gp));
            } else if (obj instanceof OBJ_MapShard7) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard7(gp));
            } else if (obj instanceof OBJ_MapShard8) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard8(gp));
            } else if (obj instanceof OBJ_MapShard9) {
                numMapShards++;
                System.out.println("You got a HAWK TUAH! Total: " + numMapShards);
                gp.obj[i] = null;
                gp.player.inventory.add(new OBJ_MapShard9(gp));
            }
        }
    }

    private void interactWithBrokenCar(OBJ_BrokenCar car) {
        System.out.println("Interacting with broken car...");

        isInteracting = true; // Prevent movement during interaction

        if (numCarParts == 3) {
            car.isFunctional = true;

            System.out.println("You assembled the car! It’s functional now.");
            gp.ui.showMessage("Your car is repaired!");

            new Thread(() -> {
                try {
                    // Start fade to black and wait for it to complete
                    int fadeLevel = 0; // Start fade level
                    while (fadeLevel < 255) {
                        fadeLevel += 5;
                        gp.fadeAlpha = fadeLevel; // Update fade effect
                        gp.repaint(); // Trigger repaint for fade effect
                        Thread.sleep(50); // Delay between fade steps
                    }

                    // Once fade is complete, show credits
                    gp.fadeAlpha = 0; // Reset fade for credits
                    gp.repaint();
                    gp.showCredits();

                    isInteracting = false; // Allow movement after credits
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            System.out.println("Not enough car parts.");
            gp.ui.showMessage("You need more parts to repair the car.");
            isInteracting = false;
        }
    }



    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
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
