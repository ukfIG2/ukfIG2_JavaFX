package application;

import java.io.File;

import javafx.scene.media.AudioClip;

public class Sound {
	
	AudioClip clip;

    public Sound(String url){
        try {
            clip = new AudioClip(new File(url).toURI().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){clip.play();}

}
