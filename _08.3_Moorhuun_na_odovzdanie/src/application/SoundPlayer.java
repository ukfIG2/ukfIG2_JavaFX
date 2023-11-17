package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class SoundPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        playSound("Zvuky/s0.wav");
    }

    public static void playSound(String soundFileName) {
        // Ensure JavaFX toolkit is initialized
        if (!Platform.isFxApplicationThread()) {
            Platform.startup(() -> playSound(soundFileName));
            return;
        }

        // Load sound file from the same directory as the Java class
        String soundFilePath = new File(soundFileName).toURI().toString();

        // Create MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(soundFilePath));

        // Optional: You can set the volume (0.0 - 1.0)
        mediaPlayer.setVolume(1.0);

        // Play the sound
        mediaPlayer.play();

        // Optional: Stop the sound after 5 seconds
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop());
    }
}
