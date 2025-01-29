package main;

import entity.BoyNPC;
import entity.FarmerNPC;
import object.OBJ_Bale;
import object.OBJ_Chest;
import object.OBJ_Door; 
import entity.BanditNPC;
import entity.FakeBanditNPC;
import object.OBJ_MapShard;
//import object.OBJ_MapShard2;
import object.OBJ_MapShard3;
import object.OBJ_MapShard4;
import object.OBJ_MapShard5;
import object.OBJ_MapShard6;
import object.OBJ_MapShard7;
import object.OBJ_MapShard8;
import object.OBJ_MapShard9;
import object.OBJ_BrokenCar;
import entity.MechanicNPC;
import entity.BakerNPC;
import object.OBJ_Window;
import entity.WandererNPC2;
import entity.OldManNPC;
import entity.WandererNPC;
import object.OBJ_Sugarcane;
import object.OBJ_Oil;

public class AssetSetter {

    public AssetSetter(GamePanel gp) {
    }
    
    public void setObject() {

        Main.gp.obj[1] = new OBJ_Door(Main.gp);
        Main.gp.obj[1].worldX = 91 * Main.gp.tileSize;
        Main.gp.obj[1].worldY = 65 * Main.gp.tileSize;

        Main.gp.obj[2] = new OBJ_Door(Main.gp);
        Main.gp.obj[2].worldX = 109 * Main.gp.tileSize;
        Main.gp.obj[2].worldY = 72 * Main.gp.tileSize;

        Main.gp.obj[3] = new OBJ_Door(Main.gp);
        Main.gp.obj[3].worldX = 83 * Main.gp.tileSize;
        Main.gp.obj[3].worldY = 76 * Main.gp.tileSize;

        Main.gp.obj[4] = new OBJ_Door(Main.gp);
        Main.gp.obj[4].worldX = 108 * Main.gp.tileSize;
        Main.gp.obj[4].worldY = 82 * Main.gp.tileSize;

        Main.gp.obj[5] = new OBJ_Door(Main.gp);
        Main.gp.obj[5].worldX = 84 * Main.gp.tileSize;
        Main.gp.obj[5].worldY = 86 * Main.gp.tileSize;

        Main.gp.obj[6] = new OBJ_Door(Main.gp);
        Main.gp.obj[6].worldX = 107 * Main.gp.tileSize;
        Main.gp.obj[6].worldY = 93 * Main.gp.tileSize;

        Main.gp.obj[7] = new OBJ_Door(Main.gp);
        Main.gp.obj[7].worldX = 87 * Main.gp.tileSize;
        Main.gp.obj[7].worldY = 96 * Main.gp.tileSize;

        Main.gp.obj[8] = new OBJ_Door(Main.gp);
        Main.gp.obj[8].worldX = 103 * Main.gp.tileSize;
        Main.gp.obj[8].worldY = 114 * Main.gp.tileSize;

        Main.gp.obj[9] = new OBJ_Door(Main.gp);
        Main.gp.obj[9].worldX = 104 * Main.gp.tileSize;
        Main.gp.obj[9].worldY = 114 * Main.gp.tileSize;

        Main.gp.obj[10] = new OBJ_Bale(Main.gp);
        Main.gp.obj[10].worldX = 129 * Main.gp.tileSize;
        Main.gp.obj[10].worldY = 139 * Main.gp.tileSize;

        Main.gp.obj[11] = new OBJ_Bale(Main.gp);
        Main.gp.obj[11].worldX = 111 * Main.gp.tileSize;
        Main.gp.obj[11].worldY = 134 * Main.gp.tileSize;

        Main.gp.obj[12] = new OBJ_Bale(Main.gp);
        Main.gp.obj[12].worldX = 147 * Main.gp.tileSize;
        Main.gp.obj[12].worldY = 136 * Main.gp.tileSize;

        Main.gp.obj[13] = new OBJ_Bale(Main.gp);
        Main.gp.obj[13].worldX = 144 * Main.gp.tileSize;
        Main.gp.obj[13].worldY = 151 * Main.gp.tileSize;

        Main.gp.obj[14] = new OBJ_Bale(Main.gp);
        Main.gp.obj[14].worldX = 117 * Main.gp.tileSize;
        Main.gp.obj[14].worldY = 148 * Main.gp.tileSize;

        Main.gp.obj[15] = new OBJ_Bale(Main.gp);
        Main.gp.obj[15].worldX = 147 * Main.gp.tileSize;
        Main.gp.obj[15].worldY = 159 * Main.gp.tileSize;

        Main.gp.obj[16] = new OBJ_Bale(Main.gp);
        Main.gp.obj[16].worldX = 137 * Main.gp.tileSize;
        Main.gp.obj[16].worldY = 161 * Main.gp.tileSize;

        Main.gp.obj[17] = new OBJ_Bale(Main.gp);
        Main.gp.obj[17].worldX = 111 * Main.gp.tileSize;
        Main.gp.obj[17].worldY = 160 * Main.gp.tileSize;

        Main.gp.obj[18] = new OBJ_Bale(Main.gp);
        Main.gp.obj[18].worldX = 138 * Main.gp.tileSize;
        Main.gp.obj[18].worldY = 173 * Main.gp.tileSize;

        Main.gp.obj[19] = new OBJ_Bale(Main.gp);
        Main.gp.obj[19].worldX = 122 * Main.gp.tileSize;
        Main.gp.obj[19].worldY = 172 * Main.gp.tileSize;

        Main.gp.obj[20] = new OBJ_BrokenCar(Main.gp, Main.gp.eventManager);
        Main.gp.obj[20].worldX = 91 * Main.gp.tileSize;
        Main.gp.obj[20].worldY = 1 * Main.gp.tileSize;

        Main.gp.obj[21] = new OBJ_BrokenCar(Main.gp, Main.gp.eventManager);
        Main.gp.obj[21].worldX = 82 * Main.gp.tileSize;
        Main.gp.obj[21].worldY = 87 * Main.gp.tileSize;

        Main.gp.obj[22] = new OBJ_Oil(Main.gp);
        Main.gp.obj[22].worldX = Main.gp.tileSize * 122;
        Main.gp.obj[22].worldY = Main.gp.tileSize * 30;

        Main.gp.obj[23] = new OBJ_Sugarcane(Main.gp);
        Main.gp.obj[23].worldX = Main.gp.tileSize * 21;
        Main.gp.obj[23].worldY = Main.gp.tileSize * 22;

        Main.gp.obj[24] = new OBJ_Sugarcane(Main.gp);
        Main.gp.obj[24].worldX = Main.gp.tileSize * 20;
        Main.gp.obj[24].worldY = Main.gp.tileSize * 22;

        Main.gp.obj[25] = new OBJ_Sugarcane(Main.gp);
        Main.gp.obj[25].worldX = Main.gp.tileSize * 32;
        Main.gp.obj[25].worldY = Main.gp.tileSize * 22;

        Main.gp.obj[26] = new OBJ_Sugarcane(Main.gp);
        Main.gp.obj[26].worldX = Main.gp.tileSize * 26;
        Main.gp.obj[26].worldY = Main.gp.tileSize * 13;

        Main.gp.obj[27] = new OBJ_Sugarcane(Main.gp);
        Main.gp.obj[27].worldX = Main.gp.tileSize * 27;
        Main.gp.obj[27].worldY = Main.gp.tileSize * 13;

        Main.gp.obj[28] = new OBJ_MapShard(Main.gp);
        Main.gp.obj[28].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[28].worldY = Main.gp.tileSize * 3;

        Main.gp.obj[29] = new OBJ_MapShard7(Main.gp);
        Main.gp.obj[29].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[29].worldY = Main.gp.tileSize * 4;

        Main.gp.obj[30] = new OBJ_MapShard3(Main.gp);
        Main.gp.obj[30].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[30].worldY = Main.gp.tileSize * 5;

        Main.gp.obj[31] = new OBJ_MapShard4(Main.gp);
        Main.gp.obj[31].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[31].worldY = Main.gp.tileSize * 6;

        Main.gp.obj[32] = new OBJ_MapShard5(Main.gp);
        Main.gp.obj[32].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[32].worldY = Main.gp.tileSize * 7;

        Main.gp.obj[33] = new OBJ_MapShard6(Main.gp);
        Main.gp.obj[33].worldX = Main.gp.tileSize * 91;
        Main.gp.obj[33].worldY = Main.gp.tileSize * 8;
    }

    public void setNPC() {

        Main.gp.npc[0] = new BoyNPC(Main.gp);
        Main.gp.npc[0].worldX = Main.gp.tileSize * 98;
        Main.gp.npc[0].worldY = Main.gp.tileSize * 64;

        Main.gp.npc[1] = new FarmerNPC(Main.gp);
        Main.gp.npc[1].worldX = Main.gp.tileSize * 101;
        Main.gp.npc[1].worldY = Main.gp.tileSize * 111;
        /*
        Main.gp.npc[2] = new BanditNPC(Main.gp);
        Main.gp.npc[2].worldX = Main.gp.tileSize * 126;
        Main.gp.npc[2].worldY = Main.gp.tileSize * 39;

        Main.gp.npc[3] = new BanditNPC(Main.gp);
        Main.gp.npc[3].worldX = Main.gp.tileSize * 125;
        Main.gp.npc[3].worldY = Main.gp.tileSize * 29;

        Main.gp.npc[5] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[5].worldX = Main.gp.tileSize * 123;
        Main.gp.npc[5].worldY = Main.gp.tileSize * 22;

        Main.gp.npc[6] = new BanditNPC(Main.gp);
        Main.gp.npc[6].worldX = Main.gp.tileSize * 132;
        Main.gp.npc[6].worldY = Main.gp.tileSize * 31;

        Main.gp.npc[7] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[7].worldX = Main.gp.tileSize * 140;
        Main.gp.npc[7].worldY = Main.gp.tileSize * 35;

        Main.gp.npc[8] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[8].worldX = Main.gp.tileSize * 135;
        Main.gp.npc[8].worldY = Main.gp.tileSize * 24;

        Main.gp.npc[9] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[9].worldX = Main.gp.tileSize * 139;
        Main.gp.npc[9].worldY = Main.gp.tileSize * 29;

        Main.gp.npc[11] = new BanditNPC(Main.gp);
        Main.gp.npc[11].worldX = Main.gp.tileSize * 119;
        Main.gp.npc[11].worldY = Main.gp.tileSize * 31;

        Main.gp.npc[12] = new BanditNPC(Main.gp);
        Main.gp.npc[12].worldX = Main.gp.tileSize * 137;
        Main.gp.npc[12].worldY = Main.gp.tileSize * 23;

        Main.gp.npc[13] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[13].worldX = Main.gp.tileSize * 122;
        Main.gp.npc[13].worldY = Main.gp.tileSize * 27;
        */
        Main.gp.npc[14] = new MechanicNPC(Main.gp);
        Main.gp.npc[14].worldX = Main.gp.tileSize * 82;
        Main.gp.npc[14].worldY = Main.gp.tileSize * 86;
        /*
        Main.gp.npc[15] = new BanditNPC(Main.gp);
        Main.gp.npc[15].worldX = Main.gp.tileSize * 120;
        Main.gp.npc[15].worldY = Main.gp.tileSize * 28;
        
        Main.gp.npc[16] = new BanditNPC(Main.gp);
        Main.gp.npc[16].worldX = Main.gp.tileSize * 124;
        Main.gp.npc[16].worldY = Main.gp.tileSize * 32;

        Main.gp.npc[17] = new BanditNPC(Main.gp);
        Main.gp.npc[17].worldX = Main.gp.tileSize * 121;
        Main.gp.npc[17].worldY = Main.gp.tileSize * 32;

        Main.gp.npc[18] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[18].worldX = Main.gp.tileSize * 115;
        Main.gp.npc[18].worldY = Main.gp.tileSize * 26;

        Main.gp.npc[19] = new BanditNPC(Main.gp);
        Main.gp.npc[19].worldX = Main.gp.tileSize * 128;
        Main.gp.npc[19].worldY = Main.gp.tileSize * 30;

        Main.gp.npc[20] = new BanditNPC(Main.gp);
        Main.gp.npc[20].worldX = Main.gp.tileSize * 141;
        Main.gp.npc[20].worldY = Main.gp.tileSize * 24;

        Main.gp.npc[21] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[21].worldX = Main.gp.tileSize * 117;
        Main.gp.npc[21].worldY = Main.gp.tileSize * 29;

        Main.gp.npc[22] = new BanditNPC(Main.gp);
        Main.gp.npc[22].worldX = Main.gp.tileSize * 120;
        Main.gp.npc[22].worldY = Main.gp.tileSize * 41;

        Main.gp.npc[23] = new BanditNPC(Main.gp);
        Main.gp.npc[23].worldX = Main.gp.tileSize * 133;
        Main.gp.npc[23].worldY = Main.gp.tileSize * 34;

        Main.gp.npc[24] = new BanditNPC(Main.gp);
        Main.gp.npc[24].worldX = Main.gp.tileSize * 128;
        Main.gp.npc[24].worldY = Main.gp.tileSize * 38;

        Main.gp.npc[25] = new BanditNPC(Main.gp);
        Main.gp.npc[25].worldX = Main.gp.tileSize * 116;
        Main.gp.npc[25].worldY = Main.gp.tileSize * 33;

        Main.gp.npc[26] = new BanditNPC(Main.gp);
        Main.gp.npc[26].worldX = Main.gp.tileSize * 130;
        Main.gp.npc[26].worldY = Main.gp.tileSize * 24;

        Main.gp.npc[27] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[27].worldX = Main.gp.tileSize * 129;
        Main.gp.npc[27].worldY = Main.gp.tileSize * 22;

        Main.gp.npc[28] = new BanditNPC(Main.gp);
        Main.gp.npc[28].worldX = Main.gp.tileSize * 127;
        Main.gp.npc[28].worldY = Main.gp.tileSize * 24;

        Main.gp.npc[29] = new BanditNPC(Main.gp);
        Main.gp.npc[29].worldX = Main.gp.tileSize * 125;
        Main.gp.npc[29].worldY = Main.gp.tileSize * 25;

        Main.gp.npc[30] = new BanditNPC(Main.gp);
        Main.gp.npc[30].worldX = Main.gp.tileSize * 115;
        Main.gp.npc[30].worldY = Main.gp.tileSize * 28;

        Main.gp.npc[31] = new BanditNPC(Main.gp);
        Main.gp.npc[31].worldX = Main.gp.tileSize * 130;
        Main.gp.npc[31].worldY = Main.gp.tileSize * 32;

        Main.gp.npc[32] = new BanditNPC(Main.gp);
        Main.gp.npc[32].worldX = Main.gp.tileSize * 124;
        Main.gp.npc[32].worldY = Main.gp.tileSize * 24;
        */
        Main.gp.npc[33] = new BakerNPC(Main.gp);
        Main.gp.npc[33].worldX = Main.gp.tileSize * 111;
        Main.gp.npc[33].worldY = Main.gp.tileSize * 73;

        Main.gp.npc[34] = new WandererNPC2(Main.gp);
        Main.gp.npc[34].worldX = Main.gp.tileSize * 81;
        Main.gp.npc[34].worldY = Main.gp.tileSize * 77;

        Main.gp.npc[35] = new OldManNPC(Main.gp);
        Main.gp.npc[35].worldX = Main.gp.tileSize * 110;
        Main.gp.npc[35].worldY = Main.gp.tileSize * 92;

        Main.gp.npc[36] = new WandererNPC(Main.gp);
        Main.gp.npc[36].worldX = Main.gp.tileSize * 85;
        Main.gp.npc[36].worldY = Main.gp.tileSize * 95;
    }
}
