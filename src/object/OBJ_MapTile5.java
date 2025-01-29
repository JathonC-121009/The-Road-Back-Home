package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile5 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile5(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 5";
        pickup = true;
        down1 = setup("res/maps/minimap5_tile.png");
        description = name + ":";
        stackable = true;
    }
}
