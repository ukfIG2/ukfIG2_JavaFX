package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	public double random(double max) {
		return Math.random()*max;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		HBox hbox = new HBox(10);
		root.getChildren().add(hbox);
		
		Button b1 = new Button("Vytvor stvorec");
		hbox.getChildren().add(b1);
		b1.setOnMouseClicked(e -> {Stvorec stvorec = new Stvorec(root, random(500), random(500), 100, 100); root.getChildren().add(stvorec);});
		
		
		Button b2 = new Button("Vytvor kruh");
		hbox.getChildren().add(b2);
		b2.setOnMouseClicked(e -> {Kruh kruh = new Kruh(root, random(500), random(500), 100, 100); root.getChildren().add(kruh);});
		
		Button b3 = new Button("Vytvor kriz");
		hbox.getChildren().add(b3);
		b3.setOnMouseClicked(e -> {Kriz kriz = new Kriz(root, random(500), random(500), 100, 100); root.getChildren().add(kriz);} );
		
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
