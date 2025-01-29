package object;

import main.GamePanel;
import entity.Entity;
import main.Main;

public class OBJ_Wheel extends Entity {
    public boolean pickup = false;

    public OBJ_Wheel(GamePanel gp) {

        super(Main.gp);
        
        name = "Wheel";
        pickup = false;
        down1 = setup("res/objects/wheel_obj.png");
        description = name + ": Your\n missing wheel.";
        price = 5;
    }
}
