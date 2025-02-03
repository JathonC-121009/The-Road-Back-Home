package object;

import entity.Entity;

public class OBJ_Gold extends Entity{

    public boolean pickup = true;
    
    public OBJ_Gold() {

        super();

        name = "Gold";
        pickup = true;
        down1 = setup("res/objects/gold_obj.png");
        description = name + ": \nReturn this to the\nminer to recieve a\npedal";
        stackable = true;
    }
}