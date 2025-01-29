package entity;

import main.Main;
import main.GamePanel;
import object.OBJ_Wheel;
import object.OBJ_Window;

public class BakerNPC extends Entity{
    
    public BakerNPC(GamePanel gp) {
        super(Main.gp);
        
        getImage();
        setDialogue();
        setItems();
    }
    
    public void getImage() {
        down1 = setup("res/npc/baker_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "Hi! I am the Baker!";
        dialogues[1] = "I want to make a cake tonight for dinner\nbut I can't seem to find the sugar";
        dialogues[2] = "I think the merchant might have sugar";
        dialogues[3] = "If you bring me the sugar \nI will lend you my spare wheel";
    
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
        Main.gp.gameState = Main.gp.tradeState;
        Main.gp.ui.npc = this;
    }

    public void setItems() {
        inventory.add(new OBJ_Wheel(Main.gp));
    }
}
