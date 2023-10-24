package _08_Auto;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aplikacia_Auto extends Application {
	
	public void start(Stage primaryStage) throws Exception{
		Group root = new Group();
		
        HBox tlacidla = new HBox(10);
        Button b1 = new Button("štartuj");
        Button b2 = new Button("<");
        Button b3 = new Button(">");
        Button b4 = new Button("vypni");
        tlacidla.getChildren().addAll(b1,b2,b3,b4);
        
        Auto auto = new Auto(10, 100, Color.RED, 5);
        b1.setOnAction(evt -> auto.nastartuj());
        b2.setOnAction(evt -> auto.dolava());
        b3.setOnAction(evt -> auto.doprava());
        b4.setOnAction(evt -> auto.vypniMotor());
        
        root.getChildren().addAll(tlacidla,auto);
        Scene scene = new Scene(root,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
