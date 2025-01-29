package object;

import main.GamePanel;
import entity.Entity;
import main.Main;

public class OBJ_Window extends Entity {
    public boolean pickup = false;

    public OBJ_Window(GamePanel gp) {

        super(Main.gp);
        
        name = "Window";
        pickup = false;
        down1 = setup("res/objects/window_tile.png");
        description = name + ": Your\n missing steering \nwindow.";
        price = 1;
    }
}
