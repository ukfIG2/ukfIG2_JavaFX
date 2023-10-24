package _07_Mouse_handler;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplikacia_Editor extends Application{

	public void start(Stage primaryStage) throws Exception{
		Group root = new Group();
		Editor grEd = new Editor(30, 30, 100, 100);
		root.getChildren().addAll(grEd);
		
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
