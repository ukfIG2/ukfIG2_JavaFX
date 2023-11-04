package _03_Priklady_zadania_03_Uloha;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Aplikacia_Balon extends Application{
	
	private double random(double max) {
		return Math.random() * max;
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		HBox hbox = new HBox(10);
		root.getChildren().add(hbox);
		
		Button b1 = new Button("Novy maly balon");
		b1.setOnMouseClicked(e -> {Maly_Balon mb = new Maly_Balon(root, random(500-50), random(500-50), 10, Color.RED, 50, 50, 1); root.getChildren().add(mb);});
		hbox.getChildren().add(b1);
		
		Button b2 = new Button("Novy Velky balon");
		b2.setOnMouseClicked(e -> {Velky_Balon vb = new Velky_Balon(root, random(500-100), random(500-100), 10, Color.GREEN, 100, 100, 0); root.getChildren().add(vb);});
		hbox.getChildren().add(b2);
		
		Button b3 = new Button("Prerfarbi vsetky balony");
		b3.setOnMouseClicked(e -> zmen_farby(root));
		hbox.getChildren().add(b3);
		
		Button b4 = new Button("Posun doprava");
		b4.setOnMouseClicked(e -> posunDoprava(root));
		hbox.getChildren().add(b4);
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void  zmen_farby(Group grupa) {
		for(int i=0; i<grupa.getChildren().size(); i++) {
			Node my = grupa.getChildren().get(i);
			//System.out.println(my);
			//((Balon)my).zmenFarbu();
			if (my instanceof Velky_Balon) ((Velky_Balon)my).zmenFarbu();

		}
	}
	
	private void posunDoprava(Group grupa) {
		for(int i=0; i<grupa.getChildren().size(); i++) {
			Node my = grupa.getChildren().get(i);
			if(my instanceof Balon) ((Balon)my).posunDoprava();
			//((Balon)my).posunDoprava();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
