package _02.Vlastne_komponenty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Aplikacia extends Application {
	
	public void start(Stage stage) throws Exception{
		VBox root = new VBox();
		Button b1 = new Button("Klikni sem");
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				PostZnacka1 pst = new PostZnacka1(60, 40, Color.GREEN);
				root.getChildren().add(pst);
			}
		});
		root.getChildren().add(b1);
		
		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
