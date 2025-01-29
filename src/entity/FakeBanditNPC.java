package entity;

import main.GamePanel;
import main.Main;

public class FakeBanditNPC extends Entity{
    
    public FakeBanditNPC(GamePanel gp) {
        super(Main.gp);
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/bandit_NPC.png");
    }

    public void setDialogue() {
        dialogues[0] = "I am an insider. You need a wheel? \nI think there's one in the compound.";
    }


    @Override
    public void speak() {
        super.speak();

        // Disable collision for the Bandit NPC
        this.collision = false;

        this.solidArea.width = 0;
        this.solidArea.height = 0;

        // Debugging: Check if collision is set to false
        System.out.println("Collision for Bandit NPC set to: " + this.collision);
    }

}
