package entity;

import main.GamePanel;
import object.OBJ_Steering;
import main.Main;

public class FarmerNPC extends Entity{
    
    public FarmerNPC(GamePanel gp) {
        super(Main.gp);
        
        getImage();
        setDialogue();
        setItems();
    }
    
    public void getImage() {
        down1 = setup("res/npc/farmer_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "My name is Bob! You need a steering wheel?\n I can give you one if you bring me\n all 10 haybales from my blueberry maze.";
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
        Main.gp.gameState = Main.gp.tradeState;
        Main.gp.ui.npc = this;
    }

    public void setItems() {
        inventory.add(new OBJ_Steering(Main.gp));
    }
}
