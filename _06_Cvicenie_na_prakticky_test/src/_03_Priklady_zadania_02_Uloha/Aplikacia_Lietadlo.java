package _03_Priklady_zadania_02_Uloha;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplikacia_Lietadlo extends Application{
	
	private double random(double max) {
		return Math.random()*max;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 300);
		
		Lietadlo lietadlo = new Lietadlo(root, random(500), random(300), 10);
		root.getChildren().add(lietadlo);
		
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
