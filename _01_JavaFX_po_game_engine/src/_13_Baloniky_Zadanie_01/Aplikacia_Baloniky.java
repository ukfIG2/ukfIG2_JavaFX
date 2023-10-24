package _13_Baloniky_Zadanie_01;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Aplikacia_Baloniky extends Application{
	Timeline casovac2;
	
	Color farby[]  = {Color.RED, Color.YELLOW, Color.ORANGE, Color.BLACK, Color.BLUE,
					  Color.CRIMSON, Color.WHEAT, Color.HOTPINK, Color.PLUM, Color.SILVER};
	
	public int random() {
		int a =  (int) (Math.random()*1100);
		return a;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 1100, 800 );
		
		//Vytvaranie balonikov
		casovac2 = new Timeline(
				new KeyFrame(Duration.seconds(1),e -> novy(root)));
		casovac2.setCycleCount(Animation.INDEFINITE);
		casovac2.play();
		
		primaryStage.setTitle("Baloniky");
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		
	public void novy(Group root){
		Balon bn = new Balon(root, farby[random()%10], random(), 750);
		root.getChildren().add(bn);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
	