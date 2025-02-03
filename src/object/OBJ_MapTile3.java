package object;

import entity.Entity;

public class OBJ_MapTile3 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile3() {

        super();

        name = "Map Tile 3";
        pickup = true;
        down1 = setup("res/maps/minimap3_tile.png");
        description = name + ":";
        stackable = true;
    }
}