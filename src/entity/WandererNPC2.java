package entity;

import main.GamePanel;
import main.Main;

public class WandererNPC2 extends Entity{
    
    public WandererNPC2(GamePanel gp) {
        super(Main.gp);
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/wanderer_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "Hi!";
        dialogues[1] = "What do you need?";
        dialogues[2] = "You:\nCane Sugar";
        dialogues[3] = "Hear let me see...";
        dialogues[4] = "Here, if you go to the pond to the north, \nthere will be cane sugar there";
        dialogues[5] = "There is a trail leading to the pond \n through a small forest at the bottom\n of the village.";
    
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
    }
}
