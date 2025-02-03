package object;

import entity.Entity;

public class OBJ_Wheel extends Entity {
    public boolean pickup = false;

    public OBJ_Wheel() {

        super();
        
        name = "Wheel";
        pickup = false;
        down1 = setup("res/objects/wheel_obj.png");
        description = name + ": Your\n missing wheel.";
        price = 5;
    }
}