package object;

import entity.Entity;
import main.GamePanel;
import main.Main;

public class OBJ_Sugarcane extends Entity{

    public boolean pickup = true;
    
    public OBJ_Sugarcane(GamePanel gp) {

        super(Main.gp);

        name = "Sugarcane";
        pickup = true;
        down1 = setup("res/objects/sugarcane_obj.png");
        description = name + ": \nReturn this to the\nbaker to recieve a\n wheel";
        stackable = true;
    }
}
