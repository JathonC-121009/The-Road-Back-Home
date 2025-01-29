package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile6 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile6(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 6";
        pickup = true;
        down1 = setup("res/maps/minimap6_tile.png");
        description = name + ":";
        stackable = true;
    }
}
