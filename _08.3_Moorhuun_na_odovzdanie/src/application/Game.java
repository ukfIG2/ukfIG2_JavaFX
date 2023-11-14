package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Game extends Group{
	Pane pane;
	Scene scene;
	//Nacirat pozadia
    Image Pozadie_Oblaky = new Image("cloud.gif");
    Image Pozadie_Dedinka = new Image("parallaxbackground.GIF");
    //Nastavit sirku hry
    private double Sirka_hry = Pozadie_Dedinka.getWidth()*2 ;	//sirka Snimky/parallaxbackground.GIF *2
    //Premenne pre pozadie
    private ImageView pozadie_oblaky;
    private ImageView pozadie_dedinka;
    
    private double rychlost_sceny = 10;
    
    public Game(Pane pane, Scene scene) {
    	this.scene=scene;
    	this.pane=pane;
    	
    	//Nastavenie pozadi
    			pozadie_oblaky = new ImageView(Pozadie_Oblaky);
    			pozadie_oblaky.setFitWidth(Sirka_hry);
    			pozadie_oblaky.setFitHeight(Main.Vyska_obrazovky);
    			pane.getChildren().add(pozadie_oblaky);
    			
    			pozadie_dedinka = new ImageView(Pozadie_Dedinka);
    			pozadie_dedinka.setFitHeight(Main.Vyska_obrazovky);
    			pozadie_dedinka.setFitWidth(Sirka_hry);
    			pozadie_dedinka.setY(Main.Vyska_obrazovky-pozadie_dedinka.getFitHeight());
    			pane.getChildren().add(pozadie_dedinka);
    			
    			//Nastavenie udalosti pohybu mysi
    			scene.addEventHandler(MouseEvent.MOUSE_MOVED, event -> pohniKamerou(event.getX()));
	}
    
    private void  pohniKamerou(double mouseX) {
		//System.out.println(mouseX);
		//System.out.println(root.getTranslateX());
		double priestor_aktivity = 200;
		if (mouseX <= priestor_aktivity) {			//Preco 200? Lebo.
            // Pohyb dolava
            if (pane.getTranslateX() < 0) {
                pane.setTranslateX(pane.getTranslateX() + rychlost_sceny);
            }
        } else if (mouseX >= Main.Sirka_obrazovky - priestor_aktivity) {
            // Pohyb doprava
            if (pane.getTranslateX() > Main.Sirka_obrazovky - Sirka_hry) {
                pane.setTranslateX(pane.getTranslateX() - rychlost_sceny);
            }
        }
		System.out.println(pane.getTranslateX());
	}

}
