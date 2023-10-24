package _18_Virtualny_les_Zadanie_02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplikacia_Virtualny_les extends Application {
	
	//Chcel som vymyslet aby nebolo cez okrajme.
	private int randomWidth() {
		int hodnota = (int) (Math.random() * 1100);	
		if (hodnota>=1100-100) {hodnota-=100;}
		return hodnota;
	}
	
	private int randomHeight() {
		int hodnota =  (int) (Math.random() * 800);
		if (hodnota>=800-200) {hodnota-=200;}
		return hodnota;
	}
	public void start(Stage stage) throws Exception{
		Group root = new Group();
		Scene scene = new Scene(root, 1100, 800);
		
		VBox vb = new VBox(20);	//spacing
		
		Button b1 = new Button("Strom");
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				//Strom strom = new Strom(root, Math.random()*scene.getWidth(), Math.random()*scene.getHeight());
				Strom strom = new Strom(root, randomWidth(), randomHeight());
				root.getChildren().add(strom);
				
			}
		});
		
		Button b2 = new Button("Kvet");
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				//Kvet kvet = new Kvet(root, Math.random()*scene.getWidth(), Math.random()*scene.getHeight());
				Kvet kvet = new Kvet(root, randomWidth(), randomHeight());
				root.getChildren().add(kvet);
				
			}
		});
		
		Button b3 = new Button("Krik");
		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				//Krik krik = new Krik(root, Math.random()*scene.getWidth(), Math.random()*scene.getHeight());
				Krik krik = new Krik(root, randomWidth(), randomHeight());
				root.getChildren().add(krik);
				
			}
		});
		vb.getChildren().addAll(b1,b2,b3);
		
		
		
		root.getChildren().add(vb);
		stage.setTitle("Virtualny les");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
}
