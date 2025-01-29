package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile9 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile9(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 9";
        pickup = true;
        down1 = setup("res/maps/minimap9_tile.png");
        description = name + ":";
        stackable = true;
    }
}
