package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_MapTile7 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile7(GamePanel gp) {

        super(Main.gp);

        name = "Map Tile 7";
        pickup = true;
        down1 = setup("res/maps/minimap7_tile.png");
        description = name + ":";
        stackable = true;
    }
}
