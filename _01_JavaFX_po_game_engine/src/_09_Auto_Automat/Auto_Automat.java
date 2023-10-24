package _09_Auto_Automat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto_Automat extends Canvas{
	private GraphicsContext gc;
	private int rychlost;
	private boolean nastartovanie;
	private Color farba;
	Timeline casovac;
	private int smer = 1;
	
	public Auto_Automat(float x, float y, Color f, int r) {
		super(50,40);
		this.setLayoutX(x);
		this.setLayoutY(y);
		farba = f;
		rychlost = r;
		nastartovanie = false;
		gc = getGraphicsContext2D();
		vykresli();
		casovac = new Timeline(
				new KeyFrame(Duration.millis(100), e -> spracuj()));
		casovac.setCycleCount(Animation.INDEFINITE);
	}
	
	public void nastartuj() {
		nastartovanie = true;
		vykresli ();
		casovac.play();
	}
	
	public void vypniMotor() {
		nastartovanie = false;
		vykresli();
		casovac.stop();
	}
	
	public void doprava() {
		if (nastartovanie)
			this.setLayoutX(this.getLayoutX() + rychlost);
	}
	
	public void dolava() {
		if (nastartovanie)
			this.setLayoutX(this.getLayoutX() - rychlost);
	}

	private void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());	//vymaze auto
		gc.setFill(Color.BLACK);						//kudol dymu na cierno
		if(nastartovanie)
			gc.strokeOval(1, 30, 10, 4);
		gc.setFill(farba);
		gc.fillRect(11, 25, 30, 10);
		gc.fillOval(14, 20, 15, 10);
		gc.setFill(Color.BLACK);
		gc.fillOval(30, 31, 10, 10);
		gc.fillOval(12, 31, 10, 10);
		
	}
	
	public void spracuj() {
		if(smer ==1) doprava();
		else dolava();
		
		if(getLayoutX() > 300-50) smer = -1;
		if(getLayoutX() <0) smer = 1;
		
	}
	
}
