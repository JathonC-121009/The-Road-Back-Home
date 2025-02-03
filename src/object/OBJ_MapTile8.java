package object;

import entity.Entity;

public class OBJ_MapTile8 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile8() {

        super();

        name = "Map Tile 8";
        pickup = true;
        down1 = setup("res/maps/minimap8_tile.png");
        description = name + ":";
        stackable = true;
    }
}