package object;

import entity.Entity;

public class OBJ_MapTile6 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile6() {

        super();

        name = "Map Tile 6";
        pickup = true;
        down1 = setup("res/maps/minimap6_tile.png");
        description = name + ":";
        stackable = true;
    }
}