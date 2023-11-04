package _01_Ulohy_z_prednasky;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aplikacia_Gulicky extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		Gula gula = new Gula(root, Color.RED, 0, 150, 100);
		root.getChildren().add(gula);
		
		primaryStage.setTitle("Gulicky");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
