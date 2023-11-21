package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Game g = new Game(1280, 780, "background.png", 10);
			root.getChildren().add(g);
			
			Scene scene = new Scene(root, 1280, 780);
			primaryStage.setScene(scene);
			primaryStage.show();
			MyTimer t = new MyTimer(g);
			t.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
