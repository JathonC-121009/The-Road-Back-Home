package entity;

import main.Main;

public class BikerNPC extends Entity{
    
    public BikerNPC() {
        super();
        
        getImage();
        setDialogue();
        setItems();
    }
    
    public void getImage() {
        down1 = setup("res/npc/biker_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "Hi! I am the Biker!";
        dialogues[1] = "It seems that my bike has\nbroken down";
        dialogues[2] = "Will you be so kind as to retrieve my pump?";
        dialogues[3] = "If you help me pump the bike, I will\ngive you a pedal";
    
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
        Main.gp.gameState = GameState.preTradeState;
        // Main.gp.ui.trade_select();
        Main.gp.ui.npc = this;
    }

    public void setItems() {
        //inventory.add(new OBJ_Pedal(Main.gp));
    }
}