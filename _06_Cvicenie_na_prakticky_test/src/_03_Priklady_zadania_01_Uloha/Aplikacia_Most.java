package _03_Priklady_zadania_01_Uloha;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Aplikacia_Most extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 300);
		
		Button b1 = new Button("Dole/Hore");
		root.getChildren().add(b1);		
		
		
		Most most = new Most();
		root.getChildren().add(most);
		
		b1.setOnMouseClicked(e -> most.zmen_stav());
		
		primaryStage.setTitle("Most");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
