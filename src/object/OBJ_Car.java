package object;

import entity.Entity;

public class OBJ_Car extends Entity{

    public boolean pickup = false;

    public OBJ_Car() {

        super();
        
        name = "Car";
        pickup = false;
        down1 = setup("res/objects/car_obj.png");
        collision = true;
    }
}