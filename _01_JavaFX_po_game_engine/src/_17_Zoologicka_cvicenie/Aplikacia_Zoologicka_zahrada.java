package _17_Zoologicka_cvicenie;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Aplikacia_Zoologicka_zahrada extends Application {

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 300);
		HBox hb = new HBox(10);
		
		Button b1 = new Button("Bylinkar");
		Button b2 = new Button("Klobaskar");
		
		hb.getChildren().addAll(b1,b2);
		
		root.getChildren().addAll(hb);
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
