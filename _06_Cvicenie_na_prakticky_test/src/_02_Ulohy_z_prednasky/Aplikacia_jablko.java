package _02_Ulohy_z_prednasky;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplikacia_jablko extends Application{
	
	private double random(double max) {
		return Math.random() * max;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		Jablko jablko = new Jablko(root, random(400), random(150));
		root.getChildren().add(jablko);
		
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
