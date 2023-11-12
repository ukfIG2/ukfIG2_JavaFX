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
    //Nastavit sirku hry
    private static final double Sirka_hry = 3000;
    //Premenne pre pozadie
    private ImageView pozadie_oblaky;
    private ImageView pozadie_dedinka;
    
    private double rychlost_sceny = 10;
    
    private Pane root;			//Treba inicializovat tuna, inac nebude viditelna pod void start
	
	
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		Scene scene = new Scene(root, Sirka_obrazovky, Vyska_obrazovky);	//Nastavenie sceny
		
		//Nastavenie pozadi
		Image Pozadie_Oblaky = new Image("cloud.gif");
		pozadie_oblaky = new ImageView(Pozadie_Oblaky);
		pozadie_oblaky.setFitWidth(Sirka_obrazovky);
		pozadie_oblaky.setFitHeight(Vyska_obrazovky);
		root.getChildren().add(pozadie_oblaky);
		
		Image Pozadie_Dedinka = new Image("parallaxbackground.GIF");
		//System.out.println(Pozadie_Dedinka.getHeight());
		pozadie_dedinka = new ImageView(Pozadie_Dedinka);
		//System.out.println(pozadie_dedinka.getFitHeight());
		pozadie_dedinka.setFitHeight(Vyska_obrazovky);
		//System.out.println(pozadie_dedinka.getFitHeight());
		pozadie_dedinka.setY(Vyska_obrazovky-pozadie_dedinka.getFitHeight());
		root.getChildren().add(pozadie_dedinka);
		
		
		
		
		
		
		Image icon = new Image("icon.png");			//Asi to funfuje iba pri spracuvani na .jar executable
		primaryStage.getIcons().add(icon);			//Nastavenie icony pre panel
		
		primaryStage.setTitle("Moorhun GI");
		//rimaryStage.setFullScreen(true);			//Nastavy FullScreen mode
		//primaryStage.setResizable(false);			//Znemozny menit velkost okna 
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Nastavenie udalosti pohubu mysi
		scene.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> pohniKamerou(event.getX(), event.getY()));
	}
	
	private void  pohniKamerou(double mouseX, double mouseY) {
		if (mouseX <= 50) {
            // Move the view to the left
            if (root.getTranslateX() < 0) {
                root.setTranslateX(root.getTranslateX() + rychlost_sceny);
            }
        } else if (mouseX >= Sirka_obrazovky - 50) {
            // Move the view to the right
            if (root.getTranslateX() > Sirka_obrazovky - Sirka_hry) {
                root.setTranslateX(root.getTranslateX() - rychlost_sceny);
            }
        }
	}

	public static void main(String[] args) {
		launch(args);
	}

}
