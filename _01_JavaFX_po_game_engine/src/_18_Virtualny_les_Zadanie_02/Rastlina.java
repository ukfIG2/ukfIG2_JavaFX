package _18_Virtualny_les_Zadanie_02;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public abstract class Rastlina extends Canvas{
	protected GraphicsContext gc;
	protected Group group;
	protected Timeline casovac; 
	protected int stav_max = 5;
	protected int stav = 1;
	protected int zem = 20;
	
	
	public Rastlina(Group group, double x, double y) {
		super(100,200);
		gc = getGraphicsContext2D();
		this.group=group;
		setLayoutX(x); setLayoutY(y);
		casovac = new Timeline(
				new KeyFrame(Duration.seconds(1),e -> ZmenaStavu()));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
	}
	
	void ZmenaStavu(){
		if (stav >= stav_max) { stav = 1; }
		else 				  { stav++; }
		vykresli();
	}
	
	protected abstract void vykresli();


	

}
