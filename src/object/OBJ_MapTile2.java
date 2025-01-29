package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile2 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile2(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 2";
        pickup = true;
        down1 = setup("res/maps/minimap2_tile.png");
        description = name + ":";
        stackable = true;
    }
}
