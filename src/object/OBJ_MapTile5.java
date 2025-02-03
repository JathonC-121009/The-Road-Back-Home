package object;

import entity.Entity;

public class OBJ_MapTile5 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile5() {

        super();

        name = "Map Tile 5";
        pickup = true;
        down1 = setup("res/maps/minimap5_tile.png");
        description = name + ":";
        stackable = true;
    }
}