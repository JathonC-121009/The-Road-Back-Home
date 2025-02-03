package main;

import entity.BoyNPC;
import entity.FarmerNPC;
import object.OBJ_Bale;
import object.OBJ_Door; 
import object.OBJ_MapShard;
//import object.OBJ_MapShard2;
import object.OBJ_MapShard3;
import object.OBJ_MapShard4;
import object.OBJ_MapShard5;
import object.OBJ_MapShard6;
import object.OBJ_MapShard7;
import object.OBJ_BrokenCar;
import entity.MechanicNPC;
import entity.BakerNPC;
import entity.WandererNPC2;
import entity.OldManNPC;
import entity.WandererNPC;
import object.OBJ_Sugarcane;
import object.OBJ_Oil;

public class AssetSetter {

    public AssetSetter() {
    }
    
    public static void setObject() {

        Main.gp.obj[1] = new OBJ_Door();
        Main.gp.obj[1].worldX = 91 * GamePanel.tileSize;
        Main.gp.obj[1].worldY = 65 * GamePanel.tileSize;

        Main.gp.obj[2] = new OBJ_Door();
        Main.gp.obj[2].worldX = 109 * GamePanel.tileSize;
        Main.gp.obj[2].worldY = 72 * GamePanel.tileSize;

        Main.gp.obj[3] = new OBJ_Door();
        Main.gp.obj[3].worldX = 83 * GamePanel.tileSize;
        Main.gp.obj[3].worldY = 76 * GamePanel.tileSize;

        Main.gp.obj[4] = new OBJ_Door();
        Main.gp.obj[4].worldX = 108 * GamePanel.tileSize;
        Main.gp.obj[4].worldY = 82 * GamePanel.tileSize;

        Main.gp.obj[5] = new OBJ_Door();
        Main.gp.obj[5].worldX = 84 * GamePanel.tileSize;
        Main.gp.obj[5].worldY = 86 * GamePanel.tileSize;

        Main.gp.obj[6] = new OBJ_Door();
        Main.gp.obj[6].worldX = 107 * GamePanel.tileSize;
        Main.gp.obj[6].worldY = 93 * GamePanel.tileSize;

        Main.gp.obj[7] = new OBJ_Door();
        Main.gp.obj[7].worldX = 87 * GamePanel.tileSize;
        Main.gp.obj[7].worldY = 96 * GamePanel.tileSize;

        Main.gp.obj[8] = new OBJ_Door();
        Main.gp.obj[8].worldX = 103 * GamePanel.tileSize;
        Main.gp.obj[8].worldY = 114 * GamePanel.tileSize;

        Main.gp.obj[9] = new OBJ_Door();
        Main.gp.obj[9].worldX = 104 * GamePanel.tileSize;
        Main.gp.obj[9].worldY = 114 * GamePanel.tileSize;

        Main.gp.obj[10] = new OBJ_Bale();
        Main.gp.obj[10].worldX = 129 * GamePanel.tileSize;
        Main.gp.obj[10].worldY = 139 * GamePanel.tileSize;

        Main.gp.obj[11] = new OBJ_Bale();
        Main.gp.obj[11].worldX = 111 * GamePanel.tileSize;
        Main.gp.obj[11].worldY = 134 * GamePanel.tileSize;

        Main.gp.obj[12] = new OBJ_Bale();
        Main.gp.obj[12].worldX = 147 * GamePanel.tileSize;
        Main.gp.obj[12].worldY = 136 * GamePanel.tileSize;

        Main.gp.obj[13] = new OBJ_Bale();
        Main.gp.obj[13].worldX = 144 * GamePanel.tileSize;
        Main.gp.obj[13].worldY = 151 * GamePanel.tileSize;

        Main.gp.obj[14] = new OBJ_Bale();
        Main.gp.obj[14].worldX = 117 * GamePanel.tileSize;
        Main.gp.obj[14].worldY = 148 * GamePanel.tileSize;

        Main.gp.obj[15] = new OBJ_Bale();
        Main.gp.obj[15].worldX = 147 * GamePanel.tileSize;
        Main.gp.obj[15].worldY = 159 * GamePanel.tileSize;

        Main.gp.obj[16] = new OBJ_Bale();
        Main.gp.obj[16].worldX = 137 * GamePanel.tileSize;
        Main.gp.obj[16].worldY = 161 * GamePanel.tileSize;

        Main.gp.obj[17] = new OBJ_Bale();
        Main.gp.obj[17].worldX = 111 * GamePanel.tileSize;
        Main.gp.obj[17].worldY = 160 * GamePanel.tileSize;

        Main.gp.obj[18] = new OBJ_Bale();
        Main.gp.obj[18].worldX = 138 * GamePanel.tileSize;
        Main.gp.obj[18].worldY = 173 * GamePanel.tileSize;

        Main.gp.obj[19] = new OBJ_Bale();
        Main.gp.obj[19].worldX = 122 * GamePanel.tileSize;
        Main.gp.obj[19].worldY = 172 * GamePanel.tileSize;

        Main.gp.obj[20] = new OBJ_BrokenCar(Main.gp.eventManager);
        Main.gp.obj[20].worldX = 91 * GamePanel.tileSize;
        Main.gp.obj[20].worldY = 1 * GamePanel.tileSize;

        Main.gp.obj[21] = new OBJ_BrokenCar(Main.gp.eventManager);
        Main.gp.obj[21].worldX = 82 * GamePanel.tileSize;
        Main.gp.obj[21].worldY = 87 * GamePanel.tileSize;

        Main.gp.obj[22] = new OBJ_Oil();
        Main.gp.obj[22].worldX = GamePanel.tileSize * 122;
        Main.gp.obj[22].worldY = GamePanel.tileSize * 30;

        Main.gp.obj[23] = new OBJ_Sugarcane();
        Main.gp.obj[23].worldX = GamePanel.tileSize * 21;
        Main.gp.obj[23].worldY = GamePanel.tileSize * 22;

        Main.gp.obj[24] = new OBJ_Sugarcane();
        Main.gp.obj[24].worldX = GamePanel.tileSize * 20;
        Main.gp.obj[24].worldY = GamePanel.tileSize * 22;

        Main.gp.obj[25] = new OBJ_Sugarcane();
        Main.gp.obj[25].worldX = GamePanel.tileSize * 32;
        Main.gp.obj[25].worldY = GamePanel.tileSize * 22;

        Main.gp.obj[26] = new OBJ_Sugarcane();
        Main.gp.obj[26].worldX = GamePanel.tileSize * 26;
        Main.gp.obj[26].worldY = GamePanel.tileSize * 13;

        Main.gp.obj[27] = new OBJ_Sugarcane();
        Main.gp.obj[27].worldX = GamePanel.tileSize * 27;
        Main.gp.obj[27].worldY = GamePanel.tileSize * 13;

        Main.gp.obj[28] = new OBJ_MapShard();
        Main.gp.obj[28].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[28].worldY = GamePanel.tileSize * 3;

        Main.gp.obj[29] = new OBJ_MapShard7();
        Main.gp.obj[29].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[29].worldY = GamePanel.tileSize * 4;

        Main.gp.obj[30] = new OBJ_MapShard3();
        Main.gp.obj[30].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[30].worldY = GamePanel.tileSize * 5;

        Main.gp.obj[31] = new OBJ_MapShard4();
        Main.gp.obj[31].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[31].worldY = GamePanel.tileSize * 6;

        Main.gp.obj[32] = new OBJ_MapShard5();
        Main.gp.obj[32].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[32].worldY = GamePanel.tileSize * 7;

        Main.gp.obj[33] = new OBJ_MapShard6();
        Main.gp.obj[33].worldX = GamePanel.tileSize * 91;
        Main.gp.obj[33].worldY = GamePanel.tileSize * 8;
    }

    public static void setNPC() {

        Main.gp.npc[0] = new BoyNPC();
        Main.gp.npc[0].worldX = GamePanel.tileSize * 98;
        Main.gp.npc[0].worldY = GamePanel.tileSize * 64;

        Main.gp.npc[1] = new FarmerNPC();
        Main.gp.npc[1].worldX = GamePanel.tileSize * 101;
        Main.gp.npc[1].worldY = GamePanel.tileSize * 111;
        /*
        Main.gp.npc[2] = new BanditNPC(Main.gp);
        Main.gp.npc[2].worldX = GamePanel.tileSize * 126;
        Main.gp.npc[2].worldY = GamePanel.tileSize * 39;

        Main.gp.npc[3] = new BanditNPC(Main.gp);
        Main.gp.npc[3].worldX = GamePanel.tileSize * 125;
        Main.gp.npc[3].worldY = GamePanel.tileSize * 29;

        Main.gp.npc[5] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[5].worldX = GamePanel.tileSize * 123;
        Main.gp.npc[5].worldY = GamePanel.tileSize * 22;

        Main.gp.npc[6] = new BanditNPC(Main.gp);
        Main.gp.npc[6].worldX = GamePanel.tileSize * 132;
        Main.gp.npc[6].worldY = GamePanel.tileSize * 31;

        Main.gp.npc[7] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[7].worldX = GamePanel.tileSize * 140;
        Main.gp.npc[7].worldY = GamePanel.tileSize * 35;

        Main.gp.npc[8] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[8].worldX = GamePanel.tileSize * 135;
        Main.gp.npc[8].worldY = GamePanel.tileSize * 24;

        Main.gp.npc[9] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[9].worldX = GamePanel.tileSize * 139;
        Main.gp.npc[9].worldY = GamePanel.tileSize * 29;

        Main.gp.npc[11] = new BanditNPC(Main.gp);
        Main.gp.npc[11].worldX = GamePanel.tileSize * 119;
        Main.gp.npc[11].worldY = GamePanel.tileSize * 31;

        Main.gp.npc[12] = new BanditNPC(Main.gp);
        Main.gp.npc[12].worldX = GamePanel.tileSize * 137;
        Main.gp.npc[12].worldY = GamePanel.tileSize * 23;

        Main.gp.npc[13] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[13].worldX = GamePanel.tileSize * 122;
        Main.gp.npc[13].worldY = GamePanel.tileSize * 27;
        */
        Main.gp.npc[14] = new MechanicNPC();
        Main.gp.npc[14].worldX = GamePanel.tileSize * 82;
        Main.gp.npc[14].worldY = GamePanel.tileSize * 86;
        /*
        Main.gp.npc[15] = new BanditNPC(Main.gp);
        Main.gp.npc[15].worldX = GamePanel.tileSize * 120;
        Main.gp.npc[15].worldY = GamePanel.tileSize * 28;
        
        Main.gp.npc[16] = new BanditNPC(Main.gp);
        Main.gp.npc[16].worldX = GamePanel.tileSize * 124;
        Main.gp.npc[16].worldY = GamePanel.tileSize * 32;

        Main.gp.npc[17] = new BanditNPC(Main.gp);
        Main.gp.npc[17].worldX = GamePanel.tileSize * 121;
        Main.gp.npc[17].worldY = GamePanel.tileSize * 32;

        Main.gp.npc[18] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[18].worldX = GamePanel.tileSize * 115;
        Main.gp.npc[18].worldY = GamePanel.tileSize * 26;

        Main.gp.npc[19] = new BanditNPC(Main.gp);
        Main.gp.npc[19].worldX = GamePanel.tileSize * 128;
        Main.gp.npc[19].worldY = GamePanel.tileSize * 30;

        Main.gp.npc[20] = new BanditNPC(Main.gp);
        Main.gp.npc[20].worldX = GamePanel.tileSize * 141;
        Main.gp.npc[20].worldY = GamePanel.tileSize * 24;

        Main.gp.npc[21] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[21].worldX = GamePanel.tileSize * 117;
        Main.gp.npc[21].worldY = GamePanel.tileSize * 29;

        Main.gp.npc[22] = new BanditNPC(Main.gp);
        Main.gp.npc[22].worldX = GamePanel.tileSize * 120;
        Main.gp.npc[22].worldY = GamePanel.tileSize * 41;

        Main.gp.npc[23] = new BanditNPC(Main.gp);
        Main.gp.npc[23].worldX = GamePanel.tileSize * 133;
        Main.gp.npc[23].worldY = GamePanel.tileSize * 34;

        Main.gp.npc[24] = new BanditNPC(Main.gp);
        Main.gp.npc[24].worldX = GamePanel.tileSize * 128;
        Main.gp.npc[24].worldY = GamePanel.tileSize * 38;

        Main.gp.npc[25] = new BanditNPC(Main.gp);
        Main.gp.npc[25].worldX = GamePanel.tileSize * 116;
        Main.gp.npc[25].worldY = GamePanel.tileSize * 33;

        Main.gp.npc[26] = new BanditNPC(Main.gp);
        Main.gp.npc[26].worldX = GamePanel.tileSize * 130;
        Main.gp.npc[26].worldY = GamePanel.tileSize * 24;

        Main.gp.npc[27] = new FakeBanditNPC(Main.gp);
        Main.gp.npc[27].worldX = GamePanel.tileSize * 129;
        Main.gp.npc[27].worldY = GamePanel.tileSize * 22;

        Main.gp.npc[28] = new BanditNPC(Main.gp);
        Main.gp.npc[28].worldX = GamePanel.tileSize * 127;
        Main.gp.npc[28].worldY = GamePanel.tileSize * 24;

        Main.gp.npc[29] = new BanditNPC(Main.gp);
        Main.gp.npc[29].worldX = GamePanel.tileSize * 125;
        Main.gp.npc[29].worldY = GamePanel.tileSize * 25;

        Main.gp.npc[30] = new BanditNPC(Main.gp);
        Main.gp.npc[30].worldX = GamePanel.tileSize * 115;
        Main.gp.npc[30].worldY = GamePanel.tileSize * 28;

        Main.gp.npc[31] = new BanditNPC(Main.gp);
        Main.gp.npc[31].worldX = GamePanel.tileSize * 130;
        Main.gp.npc[31].worldY = GamePanel.tileSize * 32;

        Main.gp.npc[32] = new BanditNPC(Main.gp);
        Main.gp.npc[32].worldX = GamePanel.tileSize * 124;
        Main.gp.npc[32].worldY = GamePanel.tileSize * 24;
        */
        Main.gp.npc[33] = new BakerNPC();
        Main.gp.npc[33].worldX = GamePanel.tileSize * 111;
        Main.gp.npc[33].worldY = GamePanel.tileSize * 73;

        Main.gp.npc[34] = new WandererNPC2();
        Main.gp.npc[34].worldX = GamePanel.tileSize * 81;
        Main.gp.npc[34].worldY = GamePanel.tileSize * 77;

        Main.gp.npc[35] = new OldManNPC();
        Main.gp.npc[35].worldX = GamePanel.tileSize * 110;
        Main.gp.npc[35].worldY = GamePanel.tileSize * 92;

        Main.gp.npc[36] = new WandererNPC();
        Main.gp.npc[36].worldX = GamePanel.tileSize * 85;
        Main.gp.npc[36].worldY = GamePanel.tileSize * 95;
    }
}