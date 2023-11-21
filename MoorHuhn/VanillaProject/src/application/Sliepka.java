package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sliepka extends Zviera{

	
	public Sliepka(String nazovSpritu, int pocetSpritov, double w, double h, double maxw, double maxh,double rychlost) {

		super(nazovSpritu, pocetSpritov, w, h, maxw, maxh, rychlost);
		if(this.rychlost < 0) {
			this.rychlost -= 15;
		} else if(this.rychlost > 0) {
			this.rychlost += 15;
		}
	}

	@Override
	public void nextImage() {
		// TODO Auto-generated method stub
		this.actImage++;
		this.actImage %= 5;
	}

	@Override
	protected void vykresli() {
		// TODO Auto-generated method stub
		if (stav == 0) {
			if(this.rychlost>0) {
				setImage(sprites[actImage]);

			}else {
				setImage(sprites[actImage+5]);

			}
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
