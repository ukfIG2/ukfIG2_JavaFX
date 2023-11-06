package _02_Uloha;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplikacia_Uloha_02 extends Application{
	
	private double random(int max) {
		return Math.random() * max;
	}
	private double rychlost = 10;
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		TextField text1 = new TextField();	
		Button b1 = new Button("Odosli rychlost");
		Text text = new Text("Doprava A, Dolava D");
		root.getChildren().add(text);
		b1.setLayoutX(200);
		root.getChildren().addAll(text1, b1);
		text.setLayoutY(50);
		
		Lietadlo lietadlo = new Lietadlo(root, random(400), random(450), rychlost);
		root.getChildren().add(lietadlo);
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				rychlost = Double.parseDouble(text1.getText());	
				lietadlo.zmenRychlost(rychlost);
			}
		});
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
