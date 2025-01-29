package entity;

import main.Main;
import main.GamePanel;

public class BanditNPC extends Entity {
    
    public BanditNPC(GamePanel gp) {
        super(Main.gp);
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/bandit_NPC.png");
    }

    public void setDialogue() {
        dialogues[0] = "Who are you? \nWhat are you doing here?";
    }

    @Override
    public void speak() {
        super.speak();

        // Teleport the player after the dialogue
        teleportPlayer();
    }

    private void teleportPlayer() {
        // Set new coordinates for the player
        // Replace these values with your desired teleport location
        int teleportX = 126 * Main.gp.tileSize; // Example: teleport to tile (10, 5)
        int teleportY = 45 * Main.gp.tileSize;

        Main.gp.player.worldX = teleportX;
        Main.gp.player.worldY = teleportY;

        System.out.println("Player teleported to: (" + teleportX + ", " + teleportY + ")");
    }
}
