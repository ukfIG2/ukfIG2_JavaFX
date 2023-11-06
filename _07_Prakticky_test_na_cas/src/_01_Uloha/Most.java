package _01_Uloha;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Most extends Canvas{
	private GraphicsContext gc;
	private int stav;
	
	public Most() {
		super(400, 400);
		setLayoutX(50); setLayoutY(50);
		stav = 0;
		gc = getGraphicsContext2D();
		Vykresli();
	}
	
	private void Vykresli(){
		gc.clearRect(0, 0, 400, 400);
		if (stav==0) {
//			gc.clearRect(0, 0, 400, 400);
			gc.setStroke(Color.RED);
			gc.setLineWidth(10);
			gc.strokeLine(0, 0, 0, 400);
			gc.strokeLine(400, 0, 400, 400);
			gc.strokeLine(0, 200, 400, 200);
			}
		else if(stav==1) {
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(10);
			gc.strokeLine(0, 0, 0, 400);
			gc.strokeLine(400, 0, 400, 400);
			gc.strokeLine(0, 200, 190, 10);
			gc.strokeLine(210, 10, 400, 200);
		}
	}
	
	public void Hore() {
		stav = 1;
		Vykresli();
	}
	
	public void Dole() {
		stav = 0;
		Vykresli();
	}
}
