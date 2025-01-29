package main;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    public static JFrame window;
    public static GamePanel gp;

    public static void main(String[] args) {

        // Window
        window = new JFrame(); // Assign to the class-level variable
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("The Road Back Home");

        setIcon(); // Call the static setIcon method

        // Uses GamePanel.java
        gp = new GamePanel();
        window.add(gp);

        // Packs Window
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.setUpGame();
        // Calls game thread
        gp.startGameThread();
    }

    public static void setIcon() {
        try {
            ImageIcon icon = new ImageIcon(
                ImageIO.read(new File("res/tiles/road_tile.png"))
            );
            window.setIconImage(icon.getImage());
        } catch (IOException e) {
            System.err.println("Error loading icon: " + e.getMessage());
        }
    }
}
