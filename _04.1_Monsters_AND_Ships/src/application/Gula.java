package application;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gula extends Canvas{
	GraphicsContext gc;
	Timeline timeline;
	Game game;
	
	int hodnota = 0;
	int hodnotaMax = (int) (10 + (Math.random() * 30));
	
	private static double sirka_gule = 5;
	private static double vyska_gule = 5;
	int smerX = 0;
	int smerY = 0;
	double rychlost = 10;
	
	public Gula(Sprites_snimky AI) {
		super(sirka_gule, vyska_gule);
		gc = getGraphicsContext2D();
		
		this.setLayoutX(AI.getLayoutX() + AI.getWidth()/2);
		this.setLayoutY(AI.getLayoutY() + AI.getHeight()/2);
		
		vykresli();
		this.game = AI.getCurrentGameScript();
		Urci_Smer((int) Math.round(Math.random()*4));
		//System.out.println("Random "+ Math.round(Math.random()*4));
		System.out.println("Get direction "+AI.getDirection());
		timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> Pohyb()));
				timeline.setCycleCount(Animation.INDEFINITE);
				timeline.play();
	}
	
	private void Urci_Smer(int smer) {
		System.out.println("Smer guly "+smer);
		switch(smer) {
		case 0:
			smerY = -1;
			break;
		case 1:
			smerY = 1;
			break;
		case 2:
			smerX = 1;
			break;
		case 3:
			smerX = -1;
			break;
		default:
			smerY = 0;
			smerX = 0;
			break;
		}
	}
	
	private void Pohyb() {
		hodnota++;
		setLayoutX(getLayoutX() + rychlost * smerX);
		setLayoutY(getLayoutY() + rychlost * smerY);
		if(hodnota > hodnotaMax) {DestroyGameObject();}
	}
	
	private void vykresli() {
		gc.setFill(Color.RED);
		gc.fillOval(0, 0, sirka_gule, vyska_gule);
	}
	
	void DestroyGameObject()
	{
		timeline.stop();
		game.guly.remove(this);
		game.getChildren().remove(this);
	}

}
