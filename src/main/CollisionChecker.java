package main;

import entity.Entity;

public class CollisionChecker {

    public CollisionChecker() {
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GamePanel.tileSize;
        int entityRightCol = entityRightWorldX / GamePanel.tileSize;
        int entityTopRow = entityTopWorldY / GamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / GamePanel.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "up":
                int entityTopRowNew = (entityTopWorldY - entity.speed) / GamePanel.tileSize;
                tileNum1 = Main.gp.tileM.mapTileNum[entityLeftCol][entityTopRowNew];
                tileNum2 = Main.gp.tileM.mapTileNum[entityRightCol][entityTopRowNew];
                entity.collisionOn = (Main.gp.tileM.tile[tileNum1].collision || Main.gp.tileM.tile[tileNum2].collision);
                break;
            case "down":
                int entityBottomRowNew = (entityBottomWorldY + entity.speed) / GamePanel.tileSize;
                tileNum1 = Main.gp.tileM.mapTileNum[entityLeftCol][entityBottomRowNew];
                tileNum2 = Main.gp.tileM.mapTileNum[entityRightCol][entityBottomRowNew];
                entity.collisionOn = (Main.gp.tileM.tile[tileNum1].collision || Main.gp.tileM.tile[tileNum2].collision);
                break;
            case "left":
                int entityLeftColNew = (entityLeftWorldX - entity.speed) / GamePanel.tileSize;
                tileNum1 = Main.gp.tileM.mapTileNum[entityLeftColNew][entityTopRow];
                tileNum2 = Main.gp.tileM.mapTileNum[entityLeftColNew][entityBottomRow];
                entity.collisionOn = (Main.gp.tileM.tile[tileNum1].collision || Main.gp.tileM.tile[tileNum2].collision);
                break;
            case "right":
                int entityRightColNew = (entityRightWorldX + entity.speed) / GamePanel.tileSize;
                tileNum1 = Main.gp.tileM.mapTileNum[entityRightColNew][entityTopRow];
                tileNum2 = Main.gp.tileM.mapTileNum[entityRightColNew][entityBottomRow];
                entity.collisionOn = (Main.gp.tileM.tile[tileNum1].collision || Main.gp.tileM.tile[tileNum2].collision);
                break;
        }
    }
    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for(int i = 0; i < Main.gp.obj.length; i++) {
            if(Main.gp.obj[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                Main.gp.obj[i].solidArea.x = Main.gp.obj[i].worldX + Main.gp.obj[i].solidArea.x;
                Main.gp.obj[i].solidArea.y = Main.gp.obj[i].worldY + Main.gp.obj[i].solidArea.y;

                switch(entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(Main.gp.obj[i].solidArea)) {
                        System.out.println("Up Collision!");
                        if(Main.gp.obj[i].collision == true) {
                            entity.collisionOn = true;
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "down":
                    entity.solidArea.y += entity.speed;
                    if(entity.solidArea.intersects(Main.gp.obj[i].solidArea)) {
                        System.out.println("Down Collision!");
                        if(Main.gp.obj[i].collision == true) {
                            entity.collisionOn = true;
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    if(entity.solidArea.intersects(Main.gp.obj[i].solidArea)) {
                        System.out.println("Left Collision!");
                        if(Main.gp.obj[i].collision == true) {
                            entity.collisionOn = true;
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;
                    if(entity.solidArea.intersects(Main.gp.obj[i].solidArea)) {
                        System.out.println("Right Collision!");
                        if(Main.gp.obj[i].collision == true) {
                            entity.collisionOn = true;
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                Main.gp.obj[i].solidArea.x = Main.gp.obj[i].solidAreaDefaultX;
                Main.gp.obj[i].solidArea.y = Main.gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;

        for(int i = 0; i < target.length; i++) {
            if(target[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch(entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)) {
                        System.out.println("Up Collision!");
                        entity.collisionOn = true;
                        index = i;
                        
                    }
                    break;
                case "down":
                    entity.solidArea.y += entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)) {
                        System.out.println("Down Collision!");
                        entity.collisionOn = true;
                        index = i;
                    }
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)) {
                        System.out.println("Left Collision!");
                        entity.collisionOn = true;
                        index = i;
                    }
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)) {
                        System.out.println("Right Collision!");
                        entity.collisionOn = true;
                        index = i;
                      
                    }
                    break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}