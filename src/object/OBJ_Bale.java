package object;

import entity.Entity;

public class OBJ_Bale extends Entity{

    public boolean pickup = true;
    
    public OBJ_Bale() {

        super();

        name = "Haybale";
        pickup = true;
        down1 = setup("res/objects/haybile_tile.png");
        description = name + ": \nCollect 10 haybales \nto get a car piece.";
        stackable = true;
    }
}