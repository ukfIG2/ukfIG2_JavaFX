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
	private static final double Sirka_obrazovky = obrazovka.getBounds().getWidth();
    private	static final double Vyska_obrazovky = obrazovka.getBounds().getHeight();
    //Nacirat pozadia
    Image Pozadie_Oblaky = new Image("cloud.gif");
    Image Pozadie_Dedinka = new Image("parallaxbackground.GIF");
    //Nastavit sirku hry
    private double Sirka_hry = Pozadie_Dedinka.getWidth()*2 ;	//sirka Snimky/parallaxbackground.GIF *2
    //Premenne pre pozadie
    private ImageView pozadie_oblaky;
    private ImageView pozadie_dedinka;
    
    private double rychlost_sceny = 10;
    
    private Pane root;			//Treba inicializovat tuna, inac nebude viditelna pod void start
	
	
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		Scene scene = new Scene(root, Sirka_obrazovky, Vyska_obrazovky);	//Nastavenie sceny
		
		//Nastavenie pozadi
		pozadie_oblaky = new ImageView(Pozadie_Oblaky);
		pozadie_oblaky.setFitWidth(Sirka_hry);
		pozadie_oblaky.setFitHeight(Vyska_obrazovky);
		root.getChildren().add(pozadie_oblaky);
		
		pozadie_dedinka = new ImageView(Pozadie_Dedinka);
		pozadie_dedinka.setFitHeight(Vyska_obrazovky);
		pozadie_dedinka.setFitWidth(Sirka_hry);
		pozadie_dedinka.setY(Vyska_obrazovky-pozadie_dedinka.getFitHeight());
		root.getChildren().add(pozadie_dedinka);
		
		
		
		
		
		
		Image icon = new Image("icon.png");			//Asi to funfuje iba pri spracuvani na .jar executable
		primaryStage.getIcons().add(icon);			//Nastavenie icony pre panel
		
		primaryStage.setTitle("Moorhun GI");
		//primaryStage.setFullScreen(true);			//Nastavy FullScreen mode
		//primaryStage.setResizable(false);			//Znemozny menit velkost okna 
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Nastavenie udalosti pohybu mysi
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, event -> pohniKamerou(event.getX()));
	}
	
	private void  pohniKamerou(double mouseX) {
		//System.out.println(mouseX);
		//System.out.println(root.getTranslateX());
		double priestor_aktivity = 200;
		if (mouseX <= priestor_aktivity) {			//Preco 200? Lebo.
            // Pohyb dolava
            if (root.getTranslateX() < 0) {
                root.setTranslateX(root.getTranslateX() + rychlost_sceny);
            }
        } else if (mouseX >= Sirka_obrazovky - priestor_aktivity) {
            // Pohyb doprava
            if (root.getTranslateX() > Sirka_obrazovky - Sirka_hry) {
                root.setTranslateX(root.getTranslateX() - rychlost_sceny);
            }
        }
		System.out.println(root.getTranslateX());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
