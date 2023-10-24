package _06_Casovac_timeline;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Aplikacia_AutoSemafor extends Application{

		public void start(Stage stage) throws Exception{
			AutoSemafor s = new AutoSemafor();

			
			VBox root = new VBox();
			root.getChildren().add(s);
			Scene scene = new Scene(root, 300, 250);
			stage.setScene(scene);
			stage.show();
			
			Timeline timeline = new Timeline(
					new KeyFrame(Duration.seconds(1),e -> s.zmenaStavu()));
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		}
		
		public static void main(String[] args) {
			launch();
		}
}
