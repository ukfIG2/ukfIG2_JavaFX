package application;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Gula extends Canvas{
	GraphicsContext gc;
	
	double sirka_gule;
	double vyska_gule;
	
	public Gula(Sprites_snimky AI) {
		super(15,15);
		gc = getGraphicsContext2D();
		
		vykresli();
	}
	
	private void vykresli() {
		gc.setFill(Color.RED);
		//gc.fillOval(0, 0);
	}

}
