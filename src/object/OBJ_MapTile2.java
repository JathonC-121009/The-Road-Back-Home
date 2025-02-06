
package object;

import entity.Entity;

public class OBJ_MapTile2 extends Entity{

    public boolean pickup = true;
    
    public OBJ_MapTile2() {

        super();

        name = "Map Tile 2";
        pickup = true;
        down1 = setup("res/maps/minimap2_tile.png");
        description = name + ":";
        stackable = true;
    }
}