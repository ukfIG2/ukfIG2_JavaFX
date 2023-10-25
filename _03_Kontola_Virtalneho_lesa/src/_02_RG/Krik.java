package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Krik extends Rastlina {

	public Krik(int vek, Color farba) {
		super(vek, farba);
		vykresli();
	}
	
	public void vykresli() {
			super.vykresli();
			gc.setFill(farba);
			for(int i = 0; i<vek; i++) {
				gc.fillOval(0,80-10*i,35,20);
			}

	}

}
