package _15_Virtualny_svet_2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Aplikacia_Virtualny_svet2 extends Application{
	
	private int random() {
		int a = (int) (5+Math.random()*10);
		return a;
	}
	
	private void pridaObjekt(Group root) {	//preco root tunak??
		int y = (int)(Math.random() * 200 + 10);
        if (y > 160) {
            Bicykel b = new Bicykel((int)(Math.random() * 200 + 50),
                    y, -10+(int)(Math.random()*21),
                    Color.RED);
            root.getChildren().add(b);
        } else if (y > 80) {
            Lod l = new Lod((int)(Math.random()*200 + 50), y,
                    -10+(int)(Math.random()*21),Color.BLUE);
            root.getChildren().add(l);
        } else {
            Auto a = new Auto((int)(Math.random()*200 + 50), y,
                    -10+(int)(Math.random()*21),Color.CYAN);
            root.getChildren().add(a);
        }
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
