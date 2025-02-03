package object;

import entity.Entity;

public class OBJ_MapTile extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile() {

        super();

        name = "Map Tile";
        pickup = true;
        down1 = setup("res/maps/minimap_tile.png");
        description = name + ":";
        stackable = true;
    }
}