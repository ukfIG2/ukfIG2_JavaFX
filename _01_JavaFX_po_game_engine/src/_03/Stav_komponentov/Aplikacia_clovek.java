package _03.Stav_komponentov;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplikacia_clovek extends Application{
	
	public void start(Stage stage) throws Exception {
		
        Button b1 = new Button("Pravá ruka");
        Button b2 = new Button("Ľavá ruka");
        Button b3 = new Button("Drep");
        Button b4 = new Button("Postav");
        Clovek clovek1 = new Clovek();
        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clovek1.ZmenPravu();
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clovek1.ZmenLavu();
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clovek1.doDrepu();
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clovek1.postavSa();
            }
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(b1,b2,b3,b4,clovek1);
        
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
		
	}
	
	public static void main(String [] args) {
		launch();
	}

}
