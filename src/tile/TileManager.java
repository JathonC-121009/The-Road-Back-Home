package tile;

import main.GamePanel;
import main.UtilityTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import main.Main;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class TileManager {
    
    public Tile[] tile;
    public int mapTileNum[][];
    GamePanel gp;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        // Removed loadMap from constructor
    }
    
    public void getTileImage() {
        /*
         0 = grass
         1 = brick 
         2 = blueberryshadow 
         3 = path
         4 = new_tree
         5 = rock
         6 = wheat
         7 = road
         8 = blueberry
         9 = stone
         10 = water
        */

        setup(0, "grass_tile", false);
        setup(1, "brick_tile", true);
        setup(2, "blueberryshadow_tile", true);
        setup(3, "path_tile", false);
        setup(4, "new_tree_tile", true);
        setup(5, "rock_tile", true);
        setup(6, "wheat_tile", false);
        setup(7, "road_tile", false);
        setup(8, "blueberry_tile", true);
        setup(9, "stone_tile", false);
        setup(10, "water_tile", true);
        // Uncomment and setup more tiles as needed
        /*
        setup(11, "lava_tile", true);
        setup(12, "firstCave_tile", false);
        setup(13, "secondCave_tile", false);
        setup(14, "thirdCave_tile", false);
        setup(15, "goldOre_tile", false);
        setup(16, "sand_tile", false);
        setup(17, "flower_tile", false);
        */
    }

    public void setup(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            File file = new File("res/tiles/" + imageName + ".png");
            if (!file.exists()) {
                System.out.println("File not found: " + file.getPath());
                return;
            }
            tile[index].image = ImageIO.read(file);
            tile[index].image = uTool.scaledImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch(IOException e) {
            System.out.println("Failed to load tile: " + imageName);
            e.printStackTrace();
            tile[index] = null;
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            while(row < gp.maxWorldRow) {
                String line = br.readLine();
                if(line == null) break; // End of file

                String[] numbers = line.split(" ");
                for(int col = 0; col < gp.maxWorldCol; col++) {
                    if(col < numbers.length) {
                        int num = Integer.parseInt(numbers[col]);
                        mapTileNum[col][row] = num;
                    } else {
                        mapTileNum[col][row] = 0; // Default tile if not enough numbers
                    }
                }
                row++;
            }
            br.close();
        } catch(Exception e) {
            System.out.println("Error loading map: " + filePath);
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                if(tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
