package entity;

public class OldManNPC extends Entity{
    
    public OldManNPC() {
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/oldman_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "Hi! I am the Merchant!";
        dialogues[1] = "What do you need?";
        dialogues[2] = "You: Cane Sugar";
        dialogues[3] = "Oh, I'm sorry only the Herbalist has sugar\n You should go to the Herbalist, \nhe will have cane sugar";
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
    }
}