package _10_Animacia_01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Aplikacia_Animacia_01 extends Application{
	
	public void start(Stage stage) throws Exception{
		Group root = new Group();
		HBox tlacidla = new HBox(10);
		Button b1 = new Button("Startuj");
		tlacidla.getChildren().addAll(b1);
		
		Helicopter heli = new Helicopter();
		b1.setOnAction(evt -> heli.startuj());
		
		root.getChildren().addAll(tlacidla,heli);
		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
