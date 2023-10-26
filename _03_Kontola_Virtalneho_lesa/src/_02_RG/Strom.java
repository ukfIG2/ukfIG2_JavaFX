package _02_RG;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Strom extends Rastlina {

	public Strom(int vek, Color farba) {
		super(vek, farba);
		vykresli();
	}
	
	public void vykresli() {
	    super.vykresli();
	    gc.setFill(farba);
	    for (int i = 0; i < vek; i++) {
	        double x1 = 0;
	        double y1 = 80 - 20 * i;
	        double x2 = 10;
	        double y2 = 60 - 20 * i;
	        double x3 = 20;
	        double y3 = 80 - 20 * i;
	       // double x4 = 30;
	       // double y4 = 80 - 20 * i;

	        double[] x = {x1, x2, x3};//, x4};
	        double[] y = {y1, y2, y3};//, y4};
	        gc.fillPolygon(x, y, 3);
	    }
	}


}
