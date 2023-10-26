package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplikacia_SaM extends Application{
	private int sirka = 1100;
	private int vyska = 500;
	
	public static Text zivot_text = new Text(50,50, "Zivot: 3/3");
    public static Text skore_text = new Text(50, 50, "Skore: 0");
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, sirka, vyska);
		VBox texts = new VBox();
		
		Game g = new Game(sirka, vyska, "pozadie.png", 10);
		root.getChildren().add(g);
		texts.getChildren().addAll(zivot_text, skore_text);
		root.getChildren().add(texts);
		
		
		primaryStage.setTitle("Monsters__AND__Ships");

		primaryStage.setScene(scene);
		primaryStage.show();
		
		Moj_casovac t = new Moj_casovac(g);
		t.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}

