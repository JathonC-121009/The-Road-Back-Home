package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Oil extends Entity{

    public boolean pickup = true;
    
    public OBJ_Oil(GamePanel gp) {

        super(Main.gp);

        name = "Oil";
        pickup = true;
        down1 = setup("res/objects/oil_obj.png");
        description = name + ": \nReturn this to the\nmechanic to recieve a\nwindow";
        stackable = true;
    }
}
