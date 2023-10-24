package _14_Virtualny_svet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Aplikacia_Virtualny_svet extends Application{
	
	private int random() {
		int a = (int) (5+Math.random()*10);
		return a;
	}
	
	private void pridaObjekt(Group root) {	//preco root tunak??
		Lod b = new Lod(20, 50, random(), Color.RED);
		Auto a = new Auto(20, 100, random(), Color.BLUE);
		root.getChildren().addAll(a,b);
	}
	
	public void start(Stage stage) throws Exception{
	Group root = new Group();
	Scene scene = new Scene(root, 500, 250);
	HBox tlacidla = new HBox(10);	//spacing(10)
	Button b1 = new Button("Pridaj");
	tlacidla.getChildren().add(b1);
	//Auto a = new Auto(20, 100, random(), Color.BLUE);
	//root.getChildren().add(a);	//auto funguje
	b1.setOnAction(evt -> pridaObjekt(root));
	root.getChildren().add(tlacidla);
	
	//Scene scene = new Scene(root, 500, 250);
	stage.setScene(scene);
	stage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
