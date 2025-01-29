package entity;

import main.GamePanel;
import main.Main;

public class BoyNPC extends Entity{
    
    public BoyNPC(GamePanel gp) {
        super(Main.gp);
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/boy_npc.png");
    }

    public void setDialogue() {

        dialogues[0] = "Hi! I am Joe!";
        dialogues[1] = "Complete quests to get car parts!";
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
    }
}
