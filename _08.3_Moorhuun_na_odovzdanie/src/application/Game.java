package application;

import java.util.LinkedList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game extends Group{
	int o = 0;
	private Pane pane;
	private Scene scene;
	//Nacirat pozadia
    private Image Pozadie_Oblaky = new Image("cloud.gif");
    private Image Pozadie_Dedinka = new Image("parallaxbackground.GIF");
    //Nastavit sirku hry
    public double Sirka_hry = Pozadie_Dedinka.getWidth()*2 ;	//sirka Snimky/parallaxbackground.GIF *2
    //Premenne pre pozadie
    private ImageView pozadie_oblaky;
    private ImageView pozadie_dedinka;
    //Lisr pre normalne Sliepky
    private LinkedList<Spriites_snimky> AI = new LinkedList<Spriites_snimky>();
    //Nejake cisla
    private int Max_pocet_normalnych_sliepok = 100;
    private int Aktulny_pocet_normalnych_sliepok;
    Timeline vznik_sliepok;
    
    private double rychlost_sceny = 40;
    private int smer; 
    
    public Game(Pane pane, Scene scene) {
    	this.scene=scene;
    	this.pane=pane;
    	Nastav_Pozadie();
		vznik_sliepok = new Timeline(new KeyFrame(Duration.seconds(3+random(2, 3)), e -> VytvorSliepku()));
		vznik_sliepok.setCycleCount(Animation.INDEFINITE);
		vznik_sliepok.play();
    	
	}
    
    public void update(double deltatime) {
    	this.Aktulny_pocet_normalnych_sliepok = AI.size();
    	System.out.println("Akt = "+Aktulny_pocet_normalnych_sliepok);
    	for(int i=0; i<AI.size(); i++) {
    		Spriites_snimky ai = AI.get(i);
    		
    		
    	}
    	
    	
    }
    
    private void Nastav_Pozadie() {
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
		double priestor_aktivity = 500;
		if (mouseX <= priestor_aktivity) {			
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
		//System.out.println(pane.getTranslateX());
	}
	private double random(double min, double max) {
		return min + (Math.random() * max);
	}
	private double smerSliepky() {
		double a = random(0,1);
		if(a<0.5) {smer=1; return 0;}
		else {smer=0; return Sirka_hry-152;}
	}
	private void VytvorSliepku() {
		if(Aktulny_pocet_normalnych_sliepok<Max_pocet_normalnych_sliepok) {
		for(int i=0; i<=9; i++) {
		Spriites_snimky nieco = new Spriites_snimky(this, "Sliepka/Sliepka", 21, 
    			smerSliepky(), random(0, Main.Vyska_obrazovky-152), 
    			142, 152, smer);
		AI.add(nieco);
		pane.getChildren().add(nieco);
		}
		}

	}
}	
	
	
	
	