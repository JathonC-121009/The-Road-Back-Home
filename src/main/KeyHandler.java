package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import tile.Tile;
import tile.TileManager;


public class KeyHandler implements KeyListener {
    Graphics2D g2;
    TileManager tileM;
    public int mapTileNum[][];
    public Tile[] tile;
    public boolean vPressed = false;
    public boolean mapVisible = false;
    public BufferedImage image;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    private int h = 0;
    private int width;
    private int height;
    

    public KeyHandler(GamePanel gp) {
        tileM = new TileManager(gp);
        tileM.loadMap("res/maps/map_test.txt");
        this.width = gp.getWidth();
        this.height = gp.getHeight();
        
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (Main.gp.gameState == Main.gp.titleState) {
            titleState(code);
        } else if (Main.gp.gameState == Main.gp.playState) {
            playState(code);
        } else if (Main.gp.gameState == Main.gp.pauseState) {
            pauseState(code);
        } else if (Main.gp.gameState == Main.gp.dialogueState) {
            dialogueState(code);
        } else if (Main.gp.gameState == Main.gp.statsState) {
            Graphics g = Main.gp.getGraphics();
            statsState(code, (Graphics2D)g); 
        } else if (Main.gp.gameState == Main.gp.optionsState) {
            optionsState(code);
        } else if (Main.gp.gameState == Main.gp.tradeState) {
            tradeState(code);
        } else if (Main.gp.gameState == Main.gp.creditsState) {
            creditsState(code);
        }
    }

    public void titleState(int code) {
        if (Main.gp.ui.titleScreenState == 0) {
            if (code == KeyEvent.VK_W) {
                Main.gp.ui.commandNum--;
                if (Main.gp.ui.commandNum < 0) {
                    Main.gp.ui.commandNum = 2;
                }
            }

            if (code == KeyEvent.VK_S) {
                Main.gp.ui.commandNum++;
                if (Main.gp.ui.commandNum > 2) {
                    Main.gp.ui.commandNum = 0;
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if (Main.gp.ui.commandNum == 0) {
                    if (Main.gp.ui.commandNum == 0) {
                    Main.gp.gameState = Main.gp.introductionState; 
                    Main.gp.startIntroductionTimer(); 
                }

                }
                if (Main.gp.ui.commandNum == 1) {
                    Main.gp.ui.titleScreenState = 1;
                }
                if (Main.gp.ui.commandNum == 2) {
                    System.exit(0);
                }
            }
        }

        if (Main.gp.ui.titleScreenState == 1) {
            if (code == KeyEvent.VK_W) {
                Main.gp.ui.commandNum--;
                if (Main.gp.ui.commandNum < 0) {
                    Main.gp.ui.commandNum = 1; 
                }
            }

            if (code == KeyEvent.VK_S) {
                Main.gp.ui.commandNum++;
                if (Main.gp.ui.commandNum > 1) {
                    Main.gp.ui.commandNum = 0; 
                }
            }

            if (code == KeyEvent.VK_ENTER && Main.gp.ui.commandNum == 0) {
                Main.gp.ui.titleScreenState = 0;
            }
        }
    }

    public void optionsState(int code) {
        if (code == KeyEvent.VK_ESCAPE) {
            Main.gp.gameState = Main.gp.playState;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        int maxCommandNum = 3;
        switch (Main.gp.ui.substate) {
            case 0: maxCommandNum = 3; break;
            case 3: maxCommandNum = 1; break;
        }
        if (code == KeyEvent.VK_W) {
            Main.gp.ui.commandNum--; 
            if (Main.gp.ui.commandNum < 0) {
                Main.gp.ui.commandNum = maxCommandNum;
            }
        }
        if (code == KeyEvent.VK_S) {
            Main.gp.ui.commandNum++; 
            if (Main.gp.ui.commandNum > maxCommandNum) {
                Main.gp.ui.commandNum = 0;
            }
        }

        if (Main.gp.ui.commandNum == 0) {
            if (code == KeyEvent.VK_A && Main.gp.sound.volumeScale > 0) {
                Main.gp.sound.setVolumeScale(Main.gp.sound.volumeScale - 1);
            }
            if (code == KeyEvent.VK_D && Main.gp.sound.volumeScale < 5) {
                Main.gp.sound.setVolumeScale(Main.gp.sound.volumeScale + 1);
            }
        }
    }

    public void playState(int code) {
        if (code == KeyEvent.VK_W) upPressed = true;
        if (code == KeyEvent.VK_S) downPressed = true;
        if (code == KeyEvent.VK_A) leftPressed = true;
        if (code == KeyEvent.VK_D) rightPressed = true;
        if (code == KeyEvent.VK_P) Main.gp.gameState = Main.gp.pauseState;
        if (code == KeyEvent.VK_C) Main.gp.gameState = Main.gp.statsState;
        if (code == KeyEvent.VK_ENTER) enterPressed = true;
        if (code == KeyEvent.VK_ESCAPE) Main.gp.gameState = Main.gp.optionsState;
        
    }
    
    public void pauseState(int code) {
        if (code == KeyEvent.VK_P) {
            Main.gp.gameState = Main.gp.playState;
        }
    }

    public void dialogueState(int code) {
        if (code == KeyEvent.VK_ENTER) {
            Main.gp.gameState = Main.gp.playState;
        }
    }

    public void statsState(int code, Graphics2D g2) {
        if (code == KeyEvent.VK_C) {
            Main.gp.gameState = Main.gp.playState;
        }

        if (code == KeyEvent.VK_V) {
            UI.vIsPressed();
        }

        playerInventory(code);
    }

    public void tradeState(int code) {
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if(Main.gp.ui.substate == 0) {
            if(code == KeyEvent.VK_W) {
                Main.gp.ui.commandNum--;
                if(Main.gp.ui.commandNum < 0) {
                    Main.gp.ui.commandNum = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
                Main.gp.ui.commandNum++;
                if(Main.gp.ui.commandNum > 1) {
                    Main.gp.ui.commandNum = 0;
                }
            }
        }
        if(Main.gp.ui.substate == 1) {
            NPCInventory(code);
            if(code == KeyEvent.VK_ESCAPE) {
                Main.gp.ui.substate = 0;
            }
        }
    }

    public void creditsState(int code) {
        if (code == KeyEvent.VK_ENTER) {
            Main.gp.gameState = Main.gp.titleState; 
        }
    }

    public void playerInventory(int code) {
        if (code == KeyEvent.VK_W) {
            if(Main.gp.ui.playerSlotRow != 0) {
                Main.gp.ui.playerSlotRow--;
            }
        }
        if (code == KeyEvent.VK_A) {
            if(Main.gp.ui.playerSlotCol != 0) {
                Main.gp.ui.playerSlotCol--;
            }
        }
        if (code == KeyEvent.VK_S) {
            if(Main.gp.ui.playerSlotRow != 4) {
                Main.gp.ui.playerSlotRow++;
            }
        }
        if (code == KeyEvent.VK_D) {
            if(Main.gp.ui.playerSlotCol != 5) {
                Main.gp.ui.playerSlotCol++;
            }
        }
    }

    public void NPCInventory(int code) {
        if (code == KeyEvent.VK_W) {
            if(Main.gp.ui.npcSlotRow != 0) {
                Main.gp.ui.npcSlotRow--;
            }
        }
        if (code == KeyEvent.VK_A) {
            if(Main.gp.ui.npcSlotCol != 0) {
                Main.gp.ui.npcSlotCol--;
            }
        }
        if (code == KeyEvent.VK_S) {
            if(Main.gp.ui.npcSlotRow != 4) {
                Main.gp.ui.npcSlotRow++;
            }
        }
        if (code == KeyEvent.VK_D) {
            if(Main.gp.ui.npcSlotCol != 5) {
                Main.gp.ui.npcSlotCol++;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) upPressed = false;
        if (code == KeyEvent.VK_S) downPressed = false;
        if (code == KeyEvent.VK_A) leftPressed = false;
        if (code == KeyEvent.VK_D) rightPressed = false;
    }
}


