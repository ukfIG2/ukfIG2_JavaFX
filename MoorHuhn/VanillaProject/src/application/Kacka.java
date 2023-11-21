package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Kacka extends Zviera{
	


	
	
	public Kacka(String nazovSpritu, int pocetSpritov, double w, double h, double maxw, double maxh, double rychlost) {
		super(nazovSpritu, pocetSpritov, w, h, maxw, maxh, rychlost);
		this.rychlost = -10;//TU robi nahodny spawn pretoze ak pojde smerom dolava tak ronvo zanikne
									
	}

	@Override
	public void nextImage() {
		// TODO Auto-generated method stub
		this.actImage++;
		this.actImage %= 8;
	}

	@Override
	protected void vykresli() {
		// TODO Auto-generated method stub
		if (stav == 0) {
			setImage(sprites[actImage]);

		}
		if (stav == 1 ) {
			setImage(killed);
		}
		if (stav == 2) {
			setImage(null);
		}
		if (stav == 3) {
			setImage(killed);
		}
	}
	
	
	
	
	
}
