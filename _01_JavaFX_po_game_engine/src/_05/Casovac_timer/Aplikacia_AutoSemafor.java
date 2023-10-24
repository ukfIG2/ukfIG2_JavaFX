package _05.Casovac_timer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplikacia_AutoSemafor extends Application{

		public void start(Stage stage) throws Exception{
			AutoSemafor s = new AutoSemafor();

			
			VBox root = new VBox();
			root.getChildren().add(s);
			Scene scene = new Scene(root, 300, 250);
			stage.setScene(scene);
			stage.show();
			
			MyTimer timer = new MyTimer(s);
			timer.start();
		}
		
		public static void main(String[] args) {
			launch();
		}
}
