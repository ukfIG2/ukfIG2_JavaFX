package _05.Casovac_timer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AutoSemafor extends Canvas {
	
	private int stav;
	GraphicsContext gc;
	
	public AutoSemafor() {
		super(20,80);	//sirka 20, vyska 80
		gc = getGraphicsContext2D();
		stav = 0;
		vykresli ();		
	}
	
	public void zmenaStavu() {
		stav = (stav + 1) %3;
		vykresli();
	}
	
	public void vykresli() {
		gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 20, 80);
        gc.setStroke(Color.WHITE);
        gc.strokeOval(2, 10, 16, 16);
        gc.strokeOval(2, 30, 16, 16);
        gc.strokeOval(2, 50, 16, 16);
        switch (stav) {
            case 0:
                gc.setFill(Color.RED);
                gc.fillOval(2, 10, 16, 16);
                break;
            case 1:
                gc.setFill(Color.ORANGE);
                gc.fillOval(2, 30, 16, 16);
                break;
            case 2:
                gc.setFill(Color.GREEN);
                gc.fillOval(2, 50, 16, 16);
                break;
        }
	}

}
