package object;

import entity.Entity;

public class OBJ_Chest extends Entity{

    public boolean pickup = false;

    public OBJ_Chest() {

        super();
        
        name = "Chest";
        pickup = false;
        down1 = setup("res/objects/chest_tile.png");
        collision = true;
    }
}