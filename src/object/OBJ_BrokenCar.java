package object;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import main.EventManager;
import main.Main;

public class OBJ_BrokenCar extends Entity {
    public boolean isFunctional = false;
    EventManager eventManager;

    public OBJ_BrokenCar(GamePanel gp, EventManager eventManager) {
        super(Main.gp);
        this.eventManager = eventManager; // Assign the passed reference
        name = "Broken Car";
        down1 = setup("res/objects/broken_car_obj.png");
    }

    public void interact() {
        if (isFunctional) {
            Main.gp.ui.showMessage("The car is ready to go!");
            return;
        }

        if (Player.numCarParts == 3) {
            Player.numCarParts = 0; // Reset car parts count
            isFunctional = true;
            Main.gp.ui.showMessage("You assembled the car! It’s functional now.");

            // Use the provided EventManager instance
            eventManager.triggerDelayedEvent(() -> {
                Main.gp.ui.showMessage("Your car is repaired! Time to escape.");
                Main.gp.startFadeToBlack();
                Main.gp.showCredits();
            }, 1000);
        } else {
            Main.gp.ui.showMessage("You need more parts to repair the car.");
        }
    }
}
