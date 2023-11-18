package application;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	//Zobrat a nastavit sirku a vysku sceny
	private static Screen obrazovka = Screen.getPrimary();
	public static final double Sirka_obrazovky = obrazovka.getBounds().getWidth();
    public	static final double Vyska_obrazovky = obrazovka.getBounds().getHeight();
    
    private Pane root;			//Treba inicializovat tuna, inac nebude viditelna pod void start
	private MyTimer timer;
	private Button n1;
	Timeline stopGame;
	public static Button n2;
	public Game game;
	
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		Scene scene = new Scene(root, Sirka_obrazovky, Vyska_obrazovky);	//Nastavenie sceny
		
		game = new Game(root, scene);
		root.getChildren().add(game);
				
		timer = new MyTimer(game);
		//timer.start();
		
		n1 = new Button("Poďme na sliepky. Cas 1 minuta.");
		n1.setLayoutX(Sirka_obrazovky/2);
		n1.setLayoutY(Vyska_obrazovky/2);
		n1.setPrefWidth(1000);
		n1.setPrefHeight(200);
		Font font = new Font(50);
		n1.setFont(font);
		root.getChildren().add(n1);
		n1.setOnMouseClicked(e -> start());

		Image icon = new Image("icon.png");			//Asi to funfuje iba pri spracuvani na .jar executable
		primaryStage.getIcons().add(icon);			//Nastavenie icony pre panel
		
		primaryStage.setTitle("Moorhun GI");
		//primaryStage.setFullScreen(true);			//Nastavy FullScreen mode
		//primaryStage.setResizable(false);			//Znemozny menit velkost okna 
		primaryStage.setScene(scene);
		primaryStage.show();

		stopGame = new Timeline(new KeyFrame(Duration.seconds(60), e-> stopgame()));
	}
	
	private void start() {
		timer.start();
		Game.vznik_sliepok.play();
		root.getChildren().remove(n1);
		stopGame.play();
	}
	
	private void stopgame() {
		timer.stop();
		Game.vznik_sliepok.stop();
		n2 = new Button("Stihol si zastrelit:");
		n2.setLayoutX(Sirka_obrazovky/2-500);
		n2.setLayoutY(Vyska_obrazovky/2);
		n2.setPrefWidth(game.Sirka_hry/2);
		n2.setPrefHeight(200);
		Font font = new Font(50);
		n2.setFont(font);
		root.getChildren().add(n2);
		 double result = (double) game.Pocet_zasiahnutych_sliepok/game.Pocet_vytvorenych_sliepok*100;
		    double roundedResult = Math.round(result * 100.0) / 100.0;
		    Main.n2.setText("Zastrelil si "+game.Pocet_zasiahnutych_sliepok+" z "+game.Pocet_vytvorenych_sliepok+"; "+roundedResult+"%.");
		    n2.setOnMouseClicked(e -> System.exit(0));
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
