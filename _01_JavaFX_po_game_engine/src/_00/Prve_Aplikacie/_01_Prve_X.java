package _00.Prve_Aplikacie;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class _01_Prve_X extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 300);
		scene.setFill(Color.YELLOW);
		
		Line line1 = new Line(10, 10, 100, 100);
		
		Line line2 = new Line();
		line2.setStartX(100.0);
		line2.setStartY(10.0);
		line2.setEndX(10.0);
		line2.setEndY(100.0);
		
		line2.setStroke(Color.RED);
		line2.setStrokeWidth(5);
		
		root.getChildren().add(line1);
		root.getChildren().add(line2);
		
		primaryStage.setTitle("Prve X ");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
