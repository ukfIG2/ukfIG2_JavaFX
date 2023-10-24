package _09_Auto_Automat;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aplikacia_Auto_Automat extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		Group root = new Group();
		HBox tlacidla = new HBox(10);
		Button b1 = new Button("Startuj");
		Button b2 = new Button("Vypni");
		tlacidla.getChildren().addAll(b1,b2);
		
		Auto_Automat auto = new Auto_Automat(10, 100, Color.RED, 5);
		b1.setOnAction(evt -> auto.nastartuj());
		b2.setOnAction(evt -> auto.vypniMotor());
		
		root.getChildren().addAll(tlacidla, auto);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
