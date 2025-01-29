package object;

import main.GamePanel;
import entity.Entity;
import main.Main;

public class OBJ_Steering extends Entity {
    public boolean pickup = false;

    public OBJ_Steering(GamePanel gp) {

        super(Main.gp);
        
        name = "Steering Wheel";
        pickup = false;
        down1 = setup("res/objects/steering_tile.png");
        description = name + ": Your\n missing steering \nwheel.";
        price = 10;
    }
}
