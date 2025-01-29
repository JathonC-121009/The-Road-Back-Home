package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Gold extends Entity{

    public boolean pickup = true;
    
    public OBJ_Gold(GamePanel gp) {

        super(Main.gp);

        name = "Gold";
        pickup = true;
        down1 = setup("res/objects/gold_obj.png");
        description = name + ": \nReturn this to the\nminer to recieve a\npedal";
        stackable = true;
    }
}
