package entity;

import main.GamePanel;
import object.OBJ_Window;
import main.Main;

public class MechanicNPC extends Entity{
    
    public MechanicNPC(GamePanel gp) {
        super(Main.gp);
        
        getImage();
        setItems();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/mechanic_NPC.png");
    }

    public void setDialogue() {
        dialogues[0] = "Hi! I am the mechanic!";
        dialogues[1] = "My car is broken, and those sneaky \nlittle bandits stole my wheels!";
        dialogues[2] = "I'll make a bargain. \nIf you find my wheels, \nI will reward you with my spare window";
        dialogues[3] = "A path unknown, where few dare tread, \nBeyond the village, where secrets are spread. \nFollow the road, but turn away,\nFind the hidden trail where shadows play.";
    
    }

    public void setAction() {
        
    }

    public void speak() {
        super.speak();
        Main.gp.gameState = Main.gp.tradeState;
        Main.gp.ui.npc = this;
    }

    public void setItems() {
        inventory.add(new OBJ_Window(Main.gp));
    }
}
