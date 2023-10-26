package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprites_obrazky extends ImageView {
	private Image[] sprites;	//zoznam obrazkov
	private int smer = 0; // -1 - bez smeru, 0 - hore, 1 - dole, 2 - doprava, 3 - dolava
	private int aktualny_image = 0;
	private double sirka_image, vyska_image;
	
	public Sprites_obrazky(String nazov, int pocetSpritov, 
			double x, double y, double sirka_image, double vyska_image) {
		super();	//zdedime konstruktor triedy ImageView
		this.sirka_image=sirka_image; this.vyska_image=vyska_image; //Nastavime sirka, dlzku
		sprites = new Image[pocetSpritov]; //Vytvorime prazdne  pole
		for(int i=0; i < pocetSpritov; i++) {
			sprites[i] = new Image(nazov+i+".png", sirka_image, vyska_image, false, false); //Zobereme obrazok do pola
		}
		setImage(sprites[0]); 	//nastavime default obrazok
		setLayoutX(x);			//na poziciu x
		setLayoutY(y);			//na poziciu y
	}
	
	public double get_sirka_image() {
		return sirka_image;
	}
	
	public double get_vyska_image() {
		return vyska_image;
	}
	
	public void hore(double delta, double max_vyska_sceny) {
		setLayoutY(getLayoutY() - delta);
		if(getLayoutY()<vyska_image) setLayoutY(vyska_image);  //ja som nastavil, ze nebudem prechadzat hore dole
		smer = 0;	vykresli();
	}
	
	public void dole(double delta, double max_vyska_sceny) {
		setLayoutY(getLayoutY() + delta);
		if (getLayoutY() > max_vyska_sceny - vyska_image) setLayoutY(max_vyska_sceny - vyska_image);
		smer = 1;	vykresli();
	}
	
	public void dolava(double delta, double max_sirka_sceny) {
		setLayoutX(getLayoutX() - delta);
		if(getLayoutX() < sirka_image) setLayoutY(sirka_image);
		smer = 2;	vykresli();
	}
	
	public void doprava(double delta, double max_sirka_sceny) {
		setLayoutX(getLayoutX() - delta);
		if(getLayoutX() > max_sirka_sceny - sirka_image) setLayoutX(max_sirka_sceny - sirka_image);
		smer = 3; vykresli();
	}

}
