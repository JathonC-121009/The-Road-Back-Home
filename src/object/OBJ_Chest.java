package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Chest extends Entity{

    public boolean pickup = false;

    public OBJ_Chest(GamePanel gp) {

        super(Main.gp);
        
        name = "Chest";
        pickup = false;
        down1 = setup("res/objects/chest_tile.png");
        collision = true;
    }
}
