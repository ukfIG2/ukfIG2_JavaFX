package application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplikacia_MaS_TATO extends Application{
	private int sirka = 1920/2;
	private int vyska = 1080/2;
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, sirka, vyska);
		
		Game game = new Game(sirka, vyska, "pozadie.png", 20);
		root.getChildren().add(game);
		
		Text zivot = new Text("Zivot: 5");
		Text skore = new Text("Skore: 0");
		zivot.setLayoutX(5); skore.setLayoutX(60);
		zivot.setLayoutY(20); skore.setLayoutY(20);
		root.getChildren().addAll(zivot, skore);
		
		
		MyTimer t = new MyTimer(game);
		t.start();
			
		primaryStage.setTitle("Monsters and Ships");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
