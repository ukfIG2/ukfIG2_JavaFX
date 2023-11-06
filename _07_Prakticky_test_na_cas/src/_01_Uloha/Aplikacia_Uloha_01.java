package _01_Uloha;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Aplikacia_Uloha_01 extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		VBox vbox = new VBox(10);
		root.getChildren().add(vbox);
		
		Button b1 = new Button("Hore");  //V*****ne AWT

		Button b2 = new Button("Dole");
		
		Most most = new Most();
		root.getChildren().add(most);
		
		vbox.getChildren().addAll(b1, b2);
		
		b1.setOnMouseClicked(e -> most.Hore());
		b2.setOnMouseClicked(e -> most.Dole());
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
