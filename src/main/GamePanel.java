package main;

import javax.swing.JPanel;

import entity.Entity;
import entity.GameState;
import entity.Player;
import tile.TileManager;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{
    //Screen Settings
    final static int originalTileSize = 16;
    // Scaling Tiles
    final static int scale = 3;
    public static final int tileSize = originalTileSize * scale;
    // Horizontal and Vertical tile size
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow = 12;
    //maxScreenCol/Row * tileSize
    public static final int screenWidth = tileSize * maxScreenCol;
    public static final int screenHeight = tileSize * maxScreenRow;
    // World Settings
    public static final int maxWorldCol = 200;
    public static final int maxWorldRow = 200;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager();
    // Size = 576 x 768 pixels
    //creates keyH object from class keyHandler
    public KeyHandler keyH = new KeyHandler();
    public Image image = null;
    // Time Loop
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker();
    Sound sound = new Sound();
    public Player player = new Player(keyH);
    public Entity obj[] = new Entity[50];
    ArrayList<Entity> entityList = new ArrayList<>();

    public UI ui = new UI();
    public Entity npc[] = new Entity[50];
    EventManager eventManager;
    
    public GameState gameState;
    // public final int titleState = 0;
    // public final int playState = 1;
    // public final int pauseState = 2;
    // public final int dialogueState = 3;
    // public final int statsState = 4;
    // public final int optionsState = 5;
    // public final int tradeState = 6;
    // public final int creditsState = 7;
    // public final int introductionState = 8;
    // public final int mapState = 9; 
    public int fadeAlpha = 0;
    private int fadeLevel = 0;

        
    //sets backround
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);  
        this.addKeyListener(keyH);
        this.keyH = new KeyHandler();
        this.setFocusable(true);
        this.eventManager = new EventManager();
    }

    public void setUpGame() {
        AssetSetter.setObject();
        sound.setFile(0, "res/sound/Background Music.wav");
        sound.setFile(1, "res/sound/title_music.wav");
        sound.setFile(2, "res/sound/cave_music.wav");
        sound.setFile(3, "res/sound/ending_music.wav");
        playMusic(1);
        AssetSetter.setNPC();
        gameState = GameState.titleState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        tileM.loadMap("res/maps/world_map.txt");

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (fadeAlpha > 0) {
                Graphics g = getGraphics(); // Get the graphics object
                if (g != null) { // Ensure it's not null
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(new Color(0, 0, 0, fadeAlpha));
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    g2.dispose(); // Always dispose after use
                }
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        
        if (gameState == GameState.playState) {
            if (!sound.isPlaying(0)) {
                playMusic(0); // Start music if not already playing
                System.out.println("In playState statement");
                sound.stop(1);
            }
        } else if (gameState == GameState.creditsState) {
            if(!sound.isPlaying(3)) {
                playMusic(3);
                System.out.println("In creditsState statement");
                sound.stop(3);
            }
        } else if (gameState == GameState.titleState) {
            // Stop music during the title screen
            if (!sound.isPlaying(1)) {
                playMusic(1);
                System.out.println("In titleState statement");
                sound.stop(0);
            }
        }
        if(gameState == GameState.playState) {
            player.update();
        }
        if(gameState == GameState.titleState) {
            player.update();
        }
        if(gameState == GameState.pauseState) {
            // Nothing as the game is paused
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == GameState.titleState) {
            ui.draw(g2);
        } 
        else if (gameState == GameState.creditsState) {

            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(30f));
            g2.drawString("Your car is now working, you can return home", 50, 50);
            g2.drawString("Credits:", 50, 100);
            g2.drawString("Developer: Owen Liu, Jathon Chen", 50, 150);
            g2.drawString("Music - The Legend of Zelda 2 - Adventure of Link", 50, 200);
            g2.drawString("Art - Pixilart.com", 50, 250);
            g2.drawString("Thank you for playing!", 50, 300);
            g2.drawString("Your Final Score:", 50, 350);
            g2.drawString(String.valueOf(Player.likeabilityCounter), 50, 400);

            if (Player.likeabilityCounter < 10) {
                g2.drawString("The villagers don't really know you.", 50, 450);
            }
            else if (Player.likeabilityCounter >= 10 && Player.likeabilityCounter < 20) {
                g2.drawString("The villagers are now you friends!", 50, 450);
            }
            else if(Player.likeabilityCounter >= 20 && Player.likeabilityCounter < 40) {
                g2.drawString("You became very good friends with the villagers!", 50, 450);
            }
            else if(Player.likeabilityCounter >= 40) {
                g2.drawString("You are now best friends with the villagers!", 50, 500);
            }

        } else if (gameState == GameState.introductionState) {
            int x = 10;
            int y = 40;
            int width = screenWidth - (tileSize - 10);
            int height = tileSize * 10;

            ui.drawSubWindow(x, y, width, height);
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(30f));
            g2.drawString("You are on your way to thanksgiving dinner", 30, 50);
            g2.drawString("But, your car slips and you crash into a tree", 30, 100);
            g2.drawString("You faint and wake up", 30, 150);
            g2.drawString("And realize that multiple pieces of your car is missing", 30, 200);
            g2.drawString("You then see a path leading into the forest", 30, 250);
            g2.drawString("And go down the path to find your missing car parts", 30, 300);
        
        }
        else {
  
            tileM.draw(g2);

            entityList.add(player);
            for (Entity npcEntity : npc) {
                if (npcEntity != null) entityList.add(npcEntity);
            }
            for (Entity objectEntity : obj) {
                if (objectEntity != null) entityList.add(objectEntity);
            }
            entityList.sort(Comparator.comparingInt(e -> e.worldY));

            for (Entity entity : entityList) {
                entity.draw(g2);
            }

            entityList.clear(); 

            ui.draw(g2);

            if (fadeAlpha > 0) {
                g2.setColor(new Color(0, 0, 0, fadeAlpha));
                g2.fillRect(0, 0, getWidth(), getHeight());
            }

            g2.dispose();
        }
    }

    public void playMusic(int i) {
        sound.play(i);
        sound.loop(i);
    }

    // Stop the sound playing at a specific index
    public void stopMusic(int i) {
        sound.stop(i);
    }

    public void startFadeToBlack() {
        new Thread(() -> {
            try {
                fadeLevel = 0;
                while (fadeLevel < 255) {
                    fadeLevel += 5;
                    if (fadeLevel > 255) fadeLevel = 255;
                    repaint(); 
                    Thread.sleep(200); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public void showCredits() {
        gameState = GameState.creditsState;
        fadeAlpha = 255;

        new Thread(() -> {
            while (fadeAlpha > 0) {
                fadeAlpha -= 5;
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void startIntroductionTimer() {
        new Thread(() -> {
            try {
                Thread.sleep(10000); // Wait for 10 seconds (10,000 ms)
                gameState = GameState.playState; // Transition to play state
                playMusic(0); // Start background music
                stopMusic(1);
                repaint(); // Trigger a screen update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void drawMinimapInGame(Graphics2D g2) {
        if (keyH.mapVisible && keyH.image != null) {
            int scaleFactor = 25;
            int scaledWidth = keyH.image.getWidth() * scaleFactor;
            int scaledHeight = keyH.image.getHeight() * scaleFactor;
            g2.drawImage(keyH.image, 188, 80, scaledWidth, scaledHeight, null);
        }
    }


}