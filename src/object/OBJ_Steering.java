package object;

import entity.Entity;

public class OBJ_Steering extends Entity {
    public boolean pickup = false;

    public OBJ_Steering() {

        super();
        
        name = "Steering Wheel";
        pickup = false;
        down1 = setup("res/objects/steering_tile.png");
        description = name + ": Your\n missing steering \nwheel.";
        price = 10;
    }
}