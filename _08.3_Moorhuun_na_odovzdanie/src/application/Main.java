package application;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{
	//Zobrat a nastavit sirku a vysku sceny
	private static Screen obrazovka = Screen.getPrimary();
	public static final double Sirka_obrazovky = obrazovka.getBounds().getWidth();
    public	static final double Vyska_obrazovky = obrazovka.getBounds().getHeight();
    
    private Pane root;			//Treba inicializovat tuna, inac nebude viditelna pod void start
	
	
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		Scene scene = new Scene(root, Sirka_obrazovky, Vyska_obrazovky);	//Nastavenie sceny
		
		Game game = new Game(root, scene);
		root.getChildren().add(game);

		Image icon = new Image("icon.png");			//Asi to funfuje iba pri spracuvani na .jar executable
		primaryStage.getIcons().add(icon);			//Nastavenie icony pre panel
		
		primaryStage.setTitle("Moorhun GI");
		//primaryStage.setFullScreen(true);			//Nastavy FullScreen mode
		//primaryStage.setResizable(false);			//Znemozny menit velkost okna 
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	
	

	public static void main(String[] args) {
		launch(args);
	}

}
