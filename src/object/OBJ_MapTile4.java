package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile4 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile4(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 4";
        pickup = true;
        down1 = setup("res/maps/minimap4_tile.png");
        description = name + ":";
        stackable = true;
    }
}
