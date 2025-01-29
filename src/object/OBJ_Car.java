package object;

import entity.Entity;
import main.Main;
import main.GamePanel;

public class OBJ_Car extends Entity{

    public boolean pickup = false;

    public OBJ_Car(GamePanel gp) {

        super(Main.gp);
        
        name = "Car";
        pickup = false;
        down1 = setup("res/objects/car_obj.png");
        collision = true;
    }
}
