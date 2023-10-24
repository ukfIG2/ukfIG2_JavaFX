package _04.Semafor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplikacia_Semafor extends Application{

		public void start(Stage stage) throws Exception{
			Semafor s = new Semafor();
			s.setOnMouseClicked((jozo_mrkvicka) -> s.zmenaStavu());
			
			VBox root = new VBox();
			root.getChildren().add(s);
			Scene scene = new Scene(root, 300, 250);
			stage.setScene(scene);
			stage.show();
		}
		
		public static void main(String[] args) {
			launch();
		}
}
