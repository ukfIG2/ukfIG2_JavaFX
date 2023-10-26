package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sprites_obrazky extends ImageView {
	private Game game;
	private Image[] sprites;	//zoznam obrazkov
	private int smer = 0; // -1 - bez smeru, 0 - hore, 1 - dole, 2 - doprava, 3 - dolava
	private int aktualny_image = 0;
	private double sirka_image, vyska_image;
	Timeline timeline;
	
	public Sprites_obrazky(String nazov, int pocetSpritov, 
			double x, double y, double sirka_image, double vyska_image, Game game) {
		super();	//zdedime konstruktor triedy ImageView
		this.game = game;
		this.sirka_image=sirka_image; this.vyska_image=vyska_image; //Nastavime sirka, dlzku
		sprites = new Image[pocetSpritov]; //Vytvorime prazdne  pole
		for(int i=0; i < pocetSpritov; i++) {
			sprites[i] = new Image(nazov+i+".png", sirka_image, vyska_image, false, false); //Zobereme obrazok do pola
		}
		setImage(sprites[0]); 	//nastavime default obrazok
		setLayoutX(x);			//na poziciu x
		setLayoutY(y);			//na poziciu y
		
		if (nazov == "monster")
        {
	        timeline = new Timeline(new KeyFrame(Duration.seconds(1+(Math.random()*10)), evt -> Vystrel()));
	        timeline.setCycleCount(Animation.INDEFINITE);
	        timeline.play();
        }
	}
	
	public double get_sirka_image() {
		return sirka_image;
	}
	
	public double get_vyska_image() {
		return vyska_image;
	}
	
	public void hore(double delta, double max_vyska_sceny) {
		setLayoutY(getLayoutY() - delta);
		if(getLayoutY()<=0) setLayoutY(1);  //ja som nastavil, ze nebudem prechadzat hore dole
		smer = 0;	vykresli();
	}
	
	public void dole(double delta, double max_vyska_sceny) {
		setLayoutY(getLayoutY() + delta);
		if (getLayoutY() > max_vyska_sceny - vyska_image) setLayoutY(max_vyska_sceny - vyska_image);
		smer = 1;	vykresli();
	}
	
	public void dolava(double delta, double max_sirka_sceny) {
		setLayoutX(getLayoutX() - delta);
		if(getLayoutX() <=0) setLayoutX(1);
		smer = 2;	vykresli();
	}
	
	public void doprava(double delta, double max_sirka_sceny) {
		setLayoutX(getLayoutX() + delta);
		if(getLayoutX() > max_sirka_sceny - sirka_image) setLayoutX(max_sirka_sceny - sirka_image);
		smer = 3; vykresli();
	}
	
	public void nextImage() {
		if (smer == 0) {aktualny_image = (aktualny_image + 1 ) % 2;}
		if (smer == 1) {aktualny_image = 2 + (aktualny_image +1 ) % 2;}
		if (smer == 2) {aktualny_image = 4 + (aktualny_image +1 ) % 2;}
		if (smer == 3) {aktualny_image = 6 + (aktualny_image +1 ) % 2;}
	}
	
	private void vykresli() {
		nextImage();	//podla pohybu vyberie ktory stav pouzije
		setImage(sprites[aktualny_image]);	//nastavy obrazok podla stavu
	}
	
	//kolizia
	public boolean kolizia_obrazkov(Sprites_obrazky cudzi_obraz) {
		double d1 = getLayoutX() - cudzi_obraz.getLayoutX();	//ak pozicia 250 - 255 < 30 true
		double d2 = getLayoutY() - cudzi_obraz.getLayoutY();
		if( (Math.abs(d1)<get_sirka_image()) && (Math.abs(d2) < get_vyska_image()) ){
			return true;}
		else {return false;}
		
	}
	
	public boolean intersectWithProjectile(ArrayList<Projektil> projectilles)
    {
    	if (!game.immortal)
    	{
	    	for (Projektil p : projectilles)
	    	{
	    		double d1 = getLayoutX() - p.getLayoutX();
	            double d2 = getLayoutY() - p.getLayoutY();
	            if (((Math.abs(d1)<get_sirka_image()) && Math.abs(d2)<get_vyska_image())) { p.DestroyGameObject();  return true; }
	    	}
    	}
    	return false;
    }
  

	 public Game getCurrentGameScript() {
	    	return game;
	    }
	 
	    public int getSmer() {
	    	return smer;
	    }
	    
	    private void Vystrel(){	    
	    	Projektil projectille = new Projektil(this);
	    	game.projektil.add(projectille);
	    	game.getChildren().add(projectille);
}
	    }
