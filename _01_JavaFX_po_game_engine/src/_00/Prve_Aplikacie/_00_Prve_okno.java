package _00.Prve_Aplikacie;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class _00_Prve_okno extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		
		Group root = new Group();
		
		Scene scene = new Scene(root, 600, 300);
		
		scene.setFill(Color.BLUE);
		
		primaryStage.setTitle("Moja FX aplikacia");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}
