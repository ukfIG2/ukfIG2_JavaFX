package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Naboj extends ImageView {
	private Image[] sprites;
	private Image vystreleny;
	private double x, y, maxWidth, maxHeight, rychlost;
	private int actImage = 0;
	private boolean jeVystreleny = false;
	private int stav = 0;
	public Naboj(String nazovSpritu, int pocetSpritov, double w, double h, int posX,int posY) {
		super();

		this.sprites = new Image[pocetSpritov];

		for (int i = 0; i < pocetSpritov; i++) {
			
			sprites[i] = new Image(nazovSpritu+".png",w,h,false,false);
	
		}

		this.setLayoutX(390+posX);
		this.setLayoutY(posY);
	
		
	}
	public void zmena(int pozX) {
		
		vykresli();
	}
	

	private void vykresli() {
			
			if (jeVystreleny == false) {
				setImage(sprites[0]);
				
			}
			if (jeVystreleny == true) {

				setImage(null);
			}
			if (this.stav == 1) {
				setImage(null);
			}

			
	}
	public void setStav() {
		this.stav = 1;
		vykresli();
	}
	public double getStav() {
		return this.stav;
	}
	public boolean getVystreleny() {
		return this.jeVystreleny;
		
	}
	public void setVystreleny() {
		this.jeVystreleny = true;
		vykresli();
	}

}
