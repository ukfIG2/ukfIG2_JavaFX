import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplikacia_strom_jablko extends Application{
	private ArrayList<Jablko> jablka;
	
	public double random(double min, double max) {
		return min + (Math.random() * max-min);
	}
	public static Text text = new Text("0");
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 400, 600);
		
		Strom strom = new Strom(root);
		root.getChildren().add(strom);
		
		text.setLayoutX(250); text.setLayoutY(25);
		root.getChildren().add(text);
		
		/*Jablko jablko = new Jablko(root, random(100, 300), random(100, 200));
		root.getChildren().add(jablko);*/
		
		for(int i=0; i<5; i++) {
			Jablko jablko = new Jablko(root, random(100, 300), random(100, 200), 50, 60);
			root.getChildren().add(jablko);
		}
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
