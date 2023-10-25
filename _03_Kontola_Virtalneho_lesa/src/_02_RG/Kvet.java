package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Kvet extends Rastlina {

	public Kvet(int vek, Color farba) {
		super(vek, farba);
		vykresli();
	}
	
	public void vykresli() {
			super.vykresli();
			gc.setFill(farba);
			for(int i = 0; i<vek; i++) {
				gc.fillOval(0,40-i*10,10+i,10+i);
			}

	}

}
