package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import java.io.File;

public class Sound {

    private Clip[] soundClip = new Clip[30];
    private FloatControl fc;
    public int volumeScale = 3; // Default volume scale
    private float volume;

    public void setFile(int index, String filePath) {
        try {
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                System.out.println("Sound file not found: " + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            soundClip[index] = AudioSystem.getClip();
            soundClip[index].open(audioStream);
    
            // Set the volume control for this specific clip
            FloatControl fc = (FloatControl) soundClip[index].getControl(FloatControl.Type.MASTER_GAIN);
            setVolumeForClip(fc); // Use a helper method to adjust the volume
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolumeForClip(FloatControl fc) {
        if (fc != null) {
            switch (volumeScale) {
                case 0: fc.setValue(-80f); break;
                case 1: fc.setValue(-20f); break;
                case 2: fc.setValue(-12f); break;
                case 3: fc.setValue(-5f); break;
                case 4: fc.setValue(1f); break;
                case 5: fc.setValue(6f); break;
            }
        }
    }

    public void setVolumeScale(int scale) {
        volumeScale = Math.max(0, Math.min(scale, 5)); // Ensure volumeScale is between 0 and 5
        // Apply volume changes to all clips
        for (Clip clip : soundClip) {
            if (clip != null) {
                FloatControl fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                setVolumeForClip(fc); // Adjust volume for each clip
            }
        }
    }

    public void play(int i) {
        if (soundClip[i] != null) {
            soundClip[i].setFramePosition(0); // Reset playback position to the start
            soundClip[i].start();
        } else {
            System.out.println("Clip not initialized at index: " + i);
        }
    }

    public void loop(int i) {
        if (soundClip[i] != null) {
            soundClip[i].loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            System.out.println("Clip not initialized at index: " + i);
        }
    }

    public void stop(int i) {
        if (soundClip[i] != null) {
            soundClip[i].stop();
        } else {
            System.out.println("Clip not initialized at index: " + i);
        }
    }

    public void checkVolume() {
        switch (volumeScale) {
            case 0: volume = -80f; break;
            case 1: volume = -20f; break;
            case 2: volume = -12f; break;
            case 3: volume = -5f; break;
            case 4: volume = 1f; break;
            case 5: volume = 6f; break;
        }
        if (fc != null) {
            fc.setValue(volume); // Apply volume adjustment
        }
    }

    // New method to check if a clip is playing
    public boolean isPlaying(int i) {
        return soundClip[i] != null && soundClip[i].isRunning();
    }
}