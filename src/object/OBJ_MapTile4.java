package object;

import entity.Entity;

public class OBJ_MapTile4 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile4() {

        super();

        name = "Map Tile 4";
        pickup = true;
        down1 = setup("res/maps/minimap4_tile.png");
        description = name + ":";
        stackable = true;
    }
}