package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Dazdnik extends Canvas{
	GraphicsContext gc;
	int stav; //0zatvvoreny 1 otvoreny 2 pokaeny
	
	public Dazdnik() {
		super(400, 400);
		gc = getGraphicsContext2D();
		setLayoutX(50); setLayoutY(50);
		stav=0;
		Vykresli();
	}
	
	private void Vykresli() {
		gc.clearRect(0, 0, 400, 400);
		if(stav==1) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(10);
		gc.strokeLine(200, 0, 200, 400);
		gc.strokeLine(200, 0, 50, 50);
		gc.strokeLine(200, 0, 350, 50);
		}
		if(stav==0) {
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(10);
			gc.strokeLine(200, 0, 200, 400);
			gc.strokeLine(200, 0, 100, 100);
			gc.strokeLine(200, 0, 300, 100);
		}
		if(stav==2) {
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(10);
			gc.strokeLine(200, 100, 200, 400);
			gc.strokeLine(200, 100, 50, -50);
			gc.strokeLine(200, 100, 350, -50);
		}
	}
	
	void zmenstav(int stav) {
		this.stav = stav;
		System.out.print(this.stav);
		Vykresli();
		if(this.stav==2) {System.exit(stav);} //Ak sa zatvorí aplikácia, už nezmeníte stav.
	}
	
	
	
}
