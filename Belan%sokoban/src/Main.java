
	

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			int sirkaSceny = 1280;
			int vyskaSceny = 720;
			Scene scene = new Scene(root, sirkaSceny, vyskaSceny);
			Hra sokoban = new Hra(sirkaSceny, vyskaSceny);
			root.getChildren().add(sokoban);
			primaryStage.setTitle("Sokoban");
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
