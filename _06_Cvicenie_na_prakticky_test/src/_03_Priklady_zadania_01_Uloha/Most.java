package _03_Priklady_zadania_01_Uloha;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Most extends Canvas{
	boolean hore = false; //false dole  //true hore
	GraphicsContext gc;
	
	public Most() {//600 300
		super(500,200);
		setLayoutX(50); setLayoutY(50);
		gc = getGraphicsContext2D();
		Vykresli();
	}
	
	public void zmen_stav() {
		hore = !hore;
		Vykresli();
	}
	
	private void Vykresli() {
		if(hore == false) {
			gc.clearRect(0, 0, 500, 200);
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(30);
			gc.strokeLine(0, 0, 0, 200);
			gc.strokeLine(500, 0, 500, 200);
			gc.setLineWidth(10);
			gc.strokeLine(0, 95, 500, 95);
		}
		if(hore == true) {
			gc.clearRect(0, 0, 500, 200);
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(30);
			gc.strokeLine(0, 0, 0, 200);
			gc.strokeLine(500, 0, 500, 200);
			gc.setLineWidth(10);
			gc.strokeLine(0, 95, 240, 0);
			gc.strokeLine(500, 95, 260, 0);
		}
	}
	
}
