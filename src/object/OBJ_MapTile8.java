package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile8 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile8(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 8";
        pickup = true;
        down1 = setup("res/maps/minimap8_tile.png");
        description = name + ":";
        stackable = true;
    }
}
