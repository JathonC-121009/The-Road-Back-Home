package object;

import entity.Entity;

public class OBJ_Oil extends Entity{

    public boolean pickup = true;
    
    public OBJ_Oil() {

        super();

        name = "Oil";
        pickup = true;
        down1 = setup("res/objects/oil_obj.png");
        description = name + ": \nReturn this to the\nmechanic to recieve a\nwindow";
        stackable = true;
    }
}