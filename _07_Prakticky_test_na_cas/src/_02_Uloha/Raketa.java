package _02_Uloha;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Raketa extends Canvas{
	private GraphicsContext gc;
	private double polohaX;
	private double polohaY;
	private double rychlost;
	private Group group;	
	private Timeline timeline;
	private double _01[]= {0, 25, 50};
	private double _02[]= {20, 0, 20};
	
	public Raketa(Group group, double polohaX, double polohaY, double rychlost) {
		super(50, 100);
		gc = getGraphicsContext2D();
		this.polohaX = polohaX; this.polohaY=polohaY;
		setLayoutX(polohaX); setLayoutY(polohaY);
		Vykresli();
		this.rychlost=rychlost;
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e-> posun()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		}
	
		private void Vykresli() {
			gc.setFill(Color.RED);
			gc.fillRect(0, 20, 50, 100);
			gc.fillPolygon(_01, _02, 3);
		}
		
		private void posun() {
			setLayoutY(getLayoutY()-rychlost);
			if(getLayoutY()>400) {group.getChildren().remove(this); timeline.stop();}
		}
		
	}

