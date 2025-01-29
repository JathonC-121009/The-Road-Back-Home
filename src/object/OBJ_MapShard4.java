package object;

import entity.Entity;
import main.GamePanel;
import tile.TileManager;
import tile.Tile;
import java.io.IOException;
import main.UtilityTool;
import java.io.File;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import main.Main;

public class OBJ_MapShard4 extends Entity {
    public boolean pickup = true;  
    public int mapTileNum[][];
    TileManager tileM;
    public Tile[] tile;

    public OBJ_MapShard4(GamePanel gp) {
        super(Main.gp);
        
        tileM = new TileManager(Main.gp);
        
        name = "Map Shard";
        pickup = true;
        down1 = setup("res/objects/mapShard_obj.png");
        description = name + ": \nUse this to\nfind the right\npath to the gold";
        stackable = true;
        
        // Initialize the arrays
        mapTileNum = new int[Main.gp.maxWorldCol][Main.gp.maxWorldRow];
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
            tile[index].image = uTool.scaledImage(tile[index].image, Main.gp.tileSize, Main.gp.tileSize);
            tile[index].collision = collision;
            
        } catch(IOException e) {
            System.out.println("Failed to load tile: " + imageName);
            e.printStackTrace();
        }
    }

    public void drawMap(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        
        while (worldCol < Main.gp.maxWorldCol && worldRow < Main.gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            
            if (tile[tileNum] != null) {  // Check if tile exists
                int worldX = worldCol * Main.gp.tileSize;
                int worldY = worldRow * Main.gp.tileSize;
                int screenX = worldX - Main.gp.player.worldX + Main.gp.player.screenX;
                int screenY = worldY - Main.gp.player.worldY + Main.gp.player.screenY;

                // Only draw if within screen bounds
                if (isOnScreen(worldX, worldY)) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
            }
            
            worldCol++;
            if (worldCol == Main.gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
    
    private boolean isOnScreen(int worldX, int worldY) {
        return worldX + Main.gp.tileSize > Main.gp.player.worldX - Main.gp.player.screenX &&
               worldX - Main.gp.tileSize < Main.gp.player.worldX + Main.gp.player.screenX &&
               worldY + Main.gp.tileSize > Main.gp.player.worldY - Main.gp.player.screenY &&
               worldY - Main.gp.tileSize < Main.gp.player.worldY + Main.gp.player.screenY;
    }
}

