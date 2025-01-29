package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile";
        pickup = true;
        down1 = setup("res/maps/minimap_tile.png");
        description = name + ":";
        stackable = true;
    }
}
