package object;

import entity.Entity;

public class OBJ_Pump extends Entity{

    public boolean pickup = true;
    
    public OBJ_Pump() {

        super();

        name = "Pump";
        pickup = true;
        down1 = setup("res/objects/pump_obj.png");
        description = name + ": \nhelp the biker\ninflate his bike\n to recieve a car\npiece";
        stackable = true;
    }
}