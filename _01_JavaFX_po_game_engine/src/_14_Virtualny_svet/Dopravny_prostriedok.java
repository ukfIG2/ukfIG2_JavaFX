package _14_Virtualny_svet;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Dopravny_prostriedok extends Canvas {
	protected GraphicsContext gc;
	protected Color farba;
	protected int obrazok;
	private int rychlost;
	private Timeline casovac;
	
	public Dopravny_prostriedok(int x, int y, int rychlost, Color farba) {
		super(40, 40);
		this.rychlost = rychlost;	this.farba = farba;
		setLayoutX(x); setLayoutY(y);
		gc = getGraphicsContext2D();
		casovac = new Timeline(
				new KeyFrame(Duration.seconds(0.1),e -> posun()));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
	}
	
	private void posun() {
		if(getLayoutX()>500 || (getLayoutX()<10))
			rychlost = -rychlost;
		setLayoutX(getLayoutX() + rychlost);
		obrazok = (obrazok +1) %2;
		vykresli();	//lebo robime animaciu
	}
	
	protected abstract void vykresli() ;
}
