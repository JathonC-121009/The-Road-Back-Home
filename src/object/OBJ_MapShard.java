package object;

import entity.Entity;
import tile.TileManager;
import tile.Tile;
import java.io.IOException;
import main.UtilityTool;
import java.io.File;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import main.Main;
import main.GamePanel;

public class OBJ_MapShard extends Entity {
    public boolean pickup = true; 
    public int mapTileNum[][];
    TileManager tileM;
    public Tile[] tile;

    public OBJ_MapShard() {
        super();
        
        tileM = new TileManager();
        
        name = "Map Shard";
        pickup = true;
        down1 = setup("res/objects/mapShard_obj.png");
        description = name + ": \nUse this to\nfind the right\npath to the gold";
        stackable = true;
        
        // Initialize the arrays
        mapTileNum = new int[GamePanel.maxWorldCol][GamePanel.maxWorldRow];
        tile = new Tile[20]; // Adjust size based on your total tiles
        
        getTileImage();
        tileM.loadMap("res/maps/map_test.txt");
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        
        if (Main.gp.keyH.mapVisible) {
            drawMap(g2);
        }
    }

    public void getTileImage() {
        // Initialize all tiles
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
        }

        /*
         0 = grass
         1 = brick 
         2 = water
         3 = path
         4 = tree
         5 = rock
         6 = wheat
         7 = road
         8 = blueberry bush
         9 = stone tile
        */

        setupTile(0, "grass_tile", false);
        setupTile(1, "brick_tile", true);
        setupTile(2, "blueberryshadow_tile", true);
        setupTile(3, "path_tile", false);
        setupTile(4, "new_tree_tile", true);
        setupTile(5, "rock_tile", true);
        setupTile(6, "wheat_tile", false);
        setupTile(7, "road_tile", false);
        setupTile(8, "blueberry_tile", true);
        setupTile(9, "stone_tile", false);
        setupTile(10, "water_tile", true);
    }

    private void setupTile(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            File file = new File("res/tiles/" + imageName + ".png");
            if (!file.exists()) {
                System.out.println("File not found: " + file.getPath());
                return;
            }
            tile[index].image = ImageIO.read(file);
            tile[index].image = uTool.scaledImage(tile[index].image, GamePanel.tileSize, GamePanel.tileSize);
            tile[index].collision = collision;
            
        } catch(IOException e) {
            System.out.println("Failed to load tile: " + imageName);
            e.printStackTrace();
        }
    }

    public void drawMap(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        
        while (worldCol < GamePanel.maxWorldCol && worldRow < GamePanel.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            
            if (tile[tileNum] != null) {  // Check if tile exists
                int worldX = worldCol * GamePanel.tileSize;
                int worldY = worldRow * GamePanel.tileSize;
                int screenX = worldX - Main.gp.player.worldX + Main.gp.player.screenX;
                int screenY = worldY - Main.gp.player.worldY + Main.gp.player.screenY;

                // Only draw if within screen bounds
                if (isOnScreen(worldX, worldY)) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
            }
            
            worldCol++;
            if (worldCol == GamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
    
    private boolean isOnScreen(int worldX, int worldY) {
        return worldX + GamePanel.tileSize > Main.gp.player.worldX - Main.gp.player.screenX &&
               worldX - GamePanel.tileSize < Main.gp.player.worldX + Main.gp.player.screenX &&
               worldY + GamePanel.tileSize > Main.gp.player.worldY - Main.gp.player.screenY &&
               worldY - GamePanel.tileSize < Main.gp.player.worldY + Main.gp.player.screenY;
    }
}