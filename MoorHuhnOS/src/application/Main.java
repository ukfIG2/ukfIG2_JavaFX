package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	 MediaPlayer mediaplayer;
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
	        Scene scene = new Scene(root, 1200, 900);
	        //music();
	        
	        Image cross = new Image("sniper.png");
	        ImageCursor cursor = new ImageCursor(cross, cross.getWidth()/2, cross.getHeight()/2);
	        scene.setCursor(cursor);
	        
	        Game game = new Game(1200,900,"background.jpg");
	        root.getChildren().add(game);
	        
	        music();
	        
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//MediaPlayer mediaPlayer;
	//nove
	public void music() {
        String thememusic = "Zdroje/hudba.mp3";
        Media hudba = new Media(new File(thememusic).toURI().toString());
        mediaplayer = new MediaPlayer(hudba);
        mediaplayer.play();
    }
	//original
	/*public void music() {
    String thememusic = "hudba.mp3";
    Media hudba = new Media(new File(thememusic).toURI().toString());
    mediaPlayer = new MediaPlayer(hudba);
    mediaPlayer.play();
}*/
  
	
	public static void main(String[] args) {
		launch(args);
	}
}
