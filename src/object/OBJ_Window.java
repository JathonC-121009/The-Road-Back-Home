package object;

import entity.Entity;

public class OBJ_Window extends Entity {
    public boolean pickup = false;

    public OBJ_Window() {

        super();
        
        name = "Window";
        pickup = false;
        down1 = setup("res/objects/window_tile.png");
        description = name + ": Your\n missing steering \nwindow.";
        price = 1;
    }
}