package _12_Semafor_bonus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class aplikacia extends Application{
	
	public void start(Stage stage) throws Exception{
		VBox root = new VBox();
		Scene scene = new Scene(root, 300, 460);
		
		semafor_bonus semaforv = new semafor_bonus();
		MyTimer_bonus timer = new MyTimer_bonus(semaforv);
		timer.start();
		
		Button b1 = new Button("Manual");
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				timer.stop();
				semaforv.zmenaStavu();
			}
		});
		
		Button b2 = new Button("Automatic");
		b2.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				timer.start();
			}
		});
		
		root.getChildren().add(semaforv);
		root.getChildren().add(b1);
		root.getChildren().add(b2);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
