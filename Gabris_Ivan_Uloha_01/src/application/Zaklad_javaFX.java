package application;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Zaklad_javaFX extends Application{
	
	public double random(double max) {
		return Math.random()*max;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		Auto auto = new Auto(root, 220, 220);
		root.getChildren().add(auto);
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
