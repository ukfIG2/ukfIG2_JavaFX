package _10_Animacia_01;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Helicopter extends Canvas {
	private GraphicsContext gc;
	Timeline casovac;
	private int obrazok = 0;
	int rychlost = 2;
	
	public Helicopter() {
		super(30,20);
		this.setLayoutX(10);	this.setLayoutY(100);
		gc = getGraphicsContext2D();
		vykresli();
		casovac = new Timeline(
				new KeyFrame(Duration.millis(100),e -> spracuj()));
		casovac.setCycleCount(Animation.INDEFINITE);
	}
	
	public void startuj() {
		casovac.play();
	}
	
	public void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
		gc.setFill(Color.BLUE);
		gc.setStroke(Color.BLUE);
		gc.fillOval(4, 8, 15, 7);
		gc.fillRect(13, 10, 10, 3);
		gc.fillRect(20, 8, 8, 2);
		if(obrazok==1) gc.strokeLine(3, 6, 20, 6);
		else		   gc.strokeLine(10, 6, 6, 6);	
	}
	private void spracuj() {
		obrazok = (obrazok+1) %2;
		posun();
		vykresli();
	}
	
	private void posun() {
		if (getLayoutX()<10)	setLayoutX(300);
		else	setLayoutX(getLayoutX()-rychlost);
	}
	
}
