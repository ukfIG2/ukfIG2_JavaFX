package _01.Komponenty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01_Scitanie_dvoch_cisiel extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		VBox root = new VBox();
		Scene scene = new Scene(root, 500,500);
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		
		Button b1 = new Button("Spocitaj");
		Label l1 = new Label("--Vysledok tunaka--");
		
		root.setSpacing(10);
		root.setMargin(t1, new Insets(0,20,0,0));
		root.setMargin(t2, new Insets(0,0,0,20));
		
		root.setAlignment(Pos.CENTER);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int a = Integer.parseInt(t1.getText());
				int b = Integer.parseInt(t2.getText());
				l1.setText(""+(a+b));
			}
		});
		
		l1.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
			l1.setScaleX(1.5);
			l1.setScaleY(1.5);
			}
		});
		
		
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
