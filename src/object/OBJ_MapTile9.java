package object;

import entity.Entity;

public class OBJ_MapTile9 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile9() {

        super();

        name = "Map Tile 9";
        pickup = true;
        down1 = setup("res/maps/minimap9_tile.png");
        description = name + ":";
        stackable = true;
    }
}