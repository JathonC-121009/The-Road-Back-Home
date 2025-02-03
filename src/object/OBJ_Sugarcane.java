package object;

import entity.Entity;

public class OBJ_Sugarcane extends Entity{

    public boolean pickup = true;
    
    public OBJ_Sugarcane() {

        super();

        name = "Sugarcane";
        pickup = true;
        down1 = setup("res/objects/sugarcane_obj.png");
        description = name + ": \nReturn this to the\nbaker to recieve a\n wheel";
        stackable = true;
    }
}