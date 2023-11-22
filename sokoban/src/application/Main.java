package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	private Character[][] saved_matrix;
	private int[][] saved_boxes;
	private int saved_x;
	private int saved_y;
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			lavel lavel = new lavel();
			lavel.mn();
			lavel.start();
			saved_matrix = lavel.matrix[lavel.current];
			saved_boxes = lavel.boxes[lavel.current];
			saved_x = lavel.x;
			saved_y = lavel.y;
			Scene scene = new Scene(root,lavel.x*30-30, lavel.y*30-30);
			game game = new game(lavel.x*30, lavel.y*30, root);
            Rectangle bg = new Rectangle(lavel.x*30, lavel.y*30);
            bg.setFill(Color.GREEN);
            root.getChildren().add(bg);
            map Maps = new map();
			Maps.start(saved_matrix, saved_boxes,saved_x,saved_y, root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
