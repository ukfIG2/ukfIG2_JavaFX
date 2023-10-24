package _01.Komponenty;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class _01_Scitanie_dvoch_cisiel_GridPane extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 500,500);
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		
		Button b1 = new Button("Spocitaj");
		Label l1 = new Label("--Vysledok tunaka--");
		
		root.setPadding(new Insets(10,10,10,10));
		
		root.setConstraints(t1, 0, 0);
		root.setConstraints(t2, 1, 1);
		root.setConstraints(b1, 2, 2);
		root.setConstraints(l1, 3, 3);
		
		root.getChildren().addAll(t1,t2, b1,l1);
		
		primaryStage.setTitle("Scitanie dvoh cisiel");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
