package Kontrola_balonov_01_os.Balony1.src.application;
	

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;



public class Main extends Application {
	
	int min = 1;
	int max = 5;
	int range = max - min +1;
	
	
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,300,500);
			
			//na spodnom okraji sc�ny (okna) vznika� bal�ny ka�d� sekundu
			Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
				Double x = Math.random()*scene.getWidth()-25;
				int random = (int)(Math.random()*range)+min;
				Balon balon = new Balon(100,100,x,scene.getHeight()-40,random);
		        
				root.getChildren().add(balon);
			}));
	       
			t.setCycleCount(Animation.INDEFINITE);
	        t.play();

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
