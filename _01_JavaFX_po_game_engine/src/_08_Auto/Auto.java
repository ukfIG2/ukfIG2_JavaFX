package _08_Auto;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Auto extends Canvas{
	private GraphicsContext gc;
	private int rychlost;
	private boolean nastartovanie;
	private Color farba;
	
	public Auto(float x, float y, Color f, int r) {
		super(50,40);
		this.setLayoutX(x);
		this.setLayoutY(y);
		farba = f;
		rychlost = r;
		nastartovanie = true;
		gc = getGraphicsContext2D();
		vykresli();
		setOnKeyPressed(evt -> spracuj(evt));
		setFocusTraversable(true);
		requestFocus();
	}
	
	public void nastartuj() {
		nastartovanie = true;
		vykresli ();
	}
	
	public void vypniMotor() {
		nastartovanie = false;
		vykresli();
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
	
	public void spracuj(KeyEvent evt) {
		KeyCode k = evt.getCode();
		if (k == KeyCode.LEFT) 	dolava();
		if (k == KeyCode.RIGHT) doprava();
		if (k == KeyCode.UP)	nastartuj();
		if (k == KeyCode.DOWN)	vypniMotor();
		
	}
	
}
