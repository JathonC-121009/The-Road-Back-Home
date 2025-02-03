package entity;

public class WandererNPC extends Entity{
    
    public WandererNPC() {
        super();
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("res/npc/wanderer_npc.png");
    }

    public void setDialogue() {
        dialogues[0] = "Are you looking for the bandits?";
        dialogues[1] = "I know where they are";
        dialogues[2] = "They are located in the right side \nof the great forest where the rock arrow are found";
        dialogues[3] = "To get to the center you have to\nfind the fake bandits, they will let you pass\nbut the real ones will kick you out";
    
    }

    public void setAction() {
        
    }

    public void speak() {

        super.speak();
    }
}