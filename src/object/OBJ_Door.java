package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Door extends Entity{

    public boolean pickup = false;

    public OBJ_Door(GamePanel gp) {

        super(Main.gp);

        name = "Door";
        pickup = false;
        down1 = setup("res/objects/door_tile.png");

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
