package _03.Stav_komponentov;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Clovek extends Canvas {
	
	private boolean PRhore;
	private boolean LRHore;
	private boolean drep;
	GraphicsContext gc;
	
	public Clovek() {
		super(35,130);
		PRhore = false;
		LRHore = false;
		drep   = false;
		gc = this.getGraphicsContext2D();
		Vykresli();
	}
	
	public void ZmenPravu() {
		PRhore = !PRhore;
		Vykresli();
	}
	
	public void ZmenLavu() {
		LRHore = !LRHore;
		Vykresli();
	}
	
	public void doDrepu () {
        drep = true;
        Vykresli();
    }

    public void postavSa () {
        drep = false;
        Vykresli();
    }
    
    public void Vykresli() {
    	gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeOval(20, 1, 10, 10);      // hlava
        gc.strokeLine(25, 11, 25, 50);     // telo
        if (drep) {			    // nohy
            gc.strokeLine(25, 50, 35, 70);   // prva pokrcena
            gc.strokeLine(35, 70, 35, 90);
            gc.strokeLine(25, 50, 15, 70);   // druha pokrcena
            gc.strokeLine(15, 70, 15, 90);
        } else {
            gc.strokeLine(25, 50, 30, 120);   // rovne nohy
            gc.strokeLine(25, 50, 20, 120);
        }
        if (LRHore) gc.strokeLine(25, 20, 35, 1); // LR dvihnuta
        else  gc.strokeLine(25, 20, 35, 45);  // LR dole
        if (PRhore) gc.strokeLine(25, 20, 15, 1); // PR detto
        else  gc.strokeLine(25, 20, 15, 45);
    	
    }
	
}
