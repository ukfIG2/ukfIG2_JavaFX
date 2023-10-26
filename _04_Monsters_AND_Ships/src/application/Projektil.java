package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Projektil extends Canvas{
	GraphicsContext gc;
	Game game;
	Sprites_obrazky nepratelsky_objekt;
	Timeline timeline;
	
	
	private int smerX = 0;
	private int smerY = 0;
	private double sirka_projektilu, vvyska_projektilu;
	private final int rychlost_proektilu = 10;
	
	private int value = 0;
	private double valueToDestroy = 5 + Math.random() * 30;
	
	public Projektil(Sprites_obrazky AI) {
		super(AI.get_sirka_image()/5, AI.get_vyska_image()/5);
		gc = getGraphicsContext2D();
		sirka_projektilu = AI.get_sirka_image()/5;
		vvyska_projektilu = AI.get_vyska_image()/5;
		
		this.setLayoutX(AI.getLayoutX() + AI.get_sirka_image()/2);
		this.setLayoutY(AI.getLayoutY() + AI.get_vyska_image()/2);
		this.game = AI.getCurrentGameScript();
		this.nepratelsky_objekt = AI;
		Vykresli();
		
		SetSmer(AI.getSmer());
		
		timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> Moving()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}
	
	private void Vykresli() {
		gc.setFill(Color.RED);
		gc.fillOval(0, 0, sirka_projektilu, vvyska_projektilu);
	}
	
	private void Moving()
	{
		value++;
		gc.clearRect(0, 0, sirka_projektilu, vvyska_projektilu);
		setLayoutX(getLayoutX() + rychlost_proektilu * smerX);
		setLayoutY(getLayoutY() + rychlost_proektilu * smerY);
		Vykresli();
		if (value > valueToDestroy) { DestroyGameObject(); }
	}
	
	void DestroyGameObject()
	{
		timeline.stop();
		game.projektil.remove(this);
		game.getChildren().remove(this);
	}
	
	private void SetSmer(int smer) {
		switch(smer)
		{
			case 0:
				smerY = 1;
				break;
			case 1:
				smerY = -1;
				break;
			case 2:
				smerX = -1;
				break;
			case 3:
				smerX = 1;
				break;
			default:
				smerX = 0;
				smerY = 0;
				break;
	}
}
}
