package Kontrola_balonov_03_SH.baloniky.src.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Group root = new Group();
			Scene scena = new Scene(root, 360, 420);
			
			HBox tlacidla = new HBox(10);
			Button bt1 = new Button("Štartuj");
			tlacidla.getChildren().addAll(bt1);
			
			balon bl = new balon(root);		//Vytori sa iba jeden objekt.
			bt1.setOnAction(evt -> bl.startuj() );
			
			root.getChildren().addAll(bt1, bl);
			stage.setTitle("Balóny");
			stage.setScene(scena);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
