package Zadanie_na_povrchu;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class _01_Pandrlak extends Canvas{
	GraphicsContext gc;
	private int x;
	private int y;
	private boolean PRhore;
	private boolean LRhore;
	private boolean drep_normal;
	private boolean usmev;
	
	public _01_Pandrlak(int x, int y) {
		super(300,300);
		gc = getGraphicsContext2D();
		this.x=x; this.y=y;
		setLayoutX(x); setLayoutY(y);
		PRhore = false;
		LRhore =  false;
		drep_normal = false;
		usmev = false;
		Vykresli();
	}
	
	public void ZmenLavu() {
		LRhore = !LRhore;
		Vykresli();
	}
	
	public void ZmenPravu() {
		PRhore = !PRhore;
		Vykresli();
	}
	
	public void Postavsa_drep() {
		drep_normal = !drep_normal;
		Vykresli();
	}
	
	public void zmen_usmev() {
		usmev = !usmev;
	}
	
	private void Vykresli() {
		gc.clearRect(0, 0, 300, 300);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(0, 0, 300, 300);	//ram
		gc.strokeOval(100, 0, 100, 100);//hlava
		gc.strokeLine(50+100, 100, 150, 225);//telo
		if(LRhore) {gc.strokeLine(150, 125, 75, 100);}
		else {gc.strokeLine(150, 125, 75, 150);}
		if(PRhore) {gc.strokeLine(150, 125, 225, 100);}
		else {gc.strokeLine(150, 125, 225, 150);}
		if(drep_normal) {
			gc.strokeLine(150, 225, 100, 200);
			gc.strokeLine(100, 200, 75, 250);
			gc.strokeLine(150, 225, 200, 200);
			gc.strokeLine(200, 200, 225, 250);
		}
		else {
			gc.strokeLine(150, 225, 75, 300);
			gc.strokeLine(150, 225, 225, 300);
		}
		if(usmev) {gc.bezierCurveTo(125, 75, 150, 100, 175, 75);}
		else {/*gc.strokeLine(125, 75, 175, 75);*/}
		
		
	}
	
}
