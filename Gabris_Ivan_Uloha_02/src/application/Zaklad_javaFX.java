package application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Zaklad_javaFX extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		VBox vbox = new VBox(20);
		root.getChildren().add(vbox);
		
		Dazdnik dazdnik = new Dazdnik();
		root.getChildren().add(dazdnik);
		
		Button b1 = new Button("Zatvorit");
		vbox.getChildren().add(b1);
		b1.setOnMouseClicked(e -> dazdnik.zmenstav(0) );
		
		
		Button b2 = new Button("Otvorit");
		vbox.getChildren().add(b2);
		b2.setOnMouseClicked(e -> dazdnik.zmenstav(1));
		
		Button b3 = new Button("Pokazit");
		vbox.getChildren().add(b3);
		b3.setOnMouseClicked(e -> dazdnik.zmenstav(2));
		

		
		
		primaryStage.setTitle("Moja FX aplikacia");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
