package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Bale extends Entity{

    public boolean pickup = true;
    
    public OBJ_Bale(GamePanel gp) {

        super(Main.gp);

        name = "Haybale";
        pickup = true;
        down1 = setup("res/objects/haybile_tile.png");
        description = name + ": \nCollect 10 haybales \nto get a car piece.";
        stackable = true;
    }
}
