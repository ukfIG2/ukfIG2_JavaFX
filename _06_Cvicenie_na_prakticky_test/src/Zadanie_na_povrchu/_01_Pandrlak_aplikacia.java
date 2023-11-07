package Zadanie_na_povrchu;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class _01_Pandrlak_aplikacia extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,400);
			HBox hbox = new HBox(50);
			
			Button b1 = new Button("LeftHand");
			Button b2 = new Button("RightHand");
			Button b3 = new Button("Drep/Normal");
			Button b4 = new Button("Usmev");
			//hbox.set
			_01_Pandrlak pandrlak = new _01_Pandrlak(50, 50);
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					pandrlak.ZmenLavu();
				}
			});
			
			b2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					pandrlak.ZmenPravu();
				}
			});
			
			b3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					pandrlak.Postavsa_drep();
				}
			});
			
			b4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					pandrlak.zmen_usmev();
				}
			});
			
			hbox.getChildren().addAll(b1, b2, b3, b4);

			root.getChildren().addAll(pandrlak, hbox);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
