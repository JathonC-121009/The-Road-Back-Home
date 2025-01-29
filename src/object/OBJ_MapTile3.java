package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile3 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile3(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 3";
        pickup = true;
        down1 = setup("res/maps/minimap3_tile.png");
        description = name + ":";
        stackable = true;
    }
}
