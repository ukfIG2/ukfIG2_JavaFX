package _03_Priklady_zadania_02_Uloha;

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
		private Timeline timeline;
		private int rychlost;
		private int smer;
		private double _1[]= {25,0,50};
		private double _2[]= {0,20,20};
		private Group group;
		
		public Raketa(Group group, double polohaX, double polohaY, int rychlost) {
			super(50,100);
			gc = getGraphicsContext2D();
			this.group=group;
			this.polohaX=polohaX+35; setLayoutX(this.polohaX);
			this.polohaY=polohaY+50; setLayoutY(this.polohaY);
			this.rychlost=rychlost;
			Vykres();
			timeline = new Timeline(new KeyFrame(Duration.seconds(0.25),
					e -> posun()));
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		}
		
		private void Vykres() {
			gc.setFill(Color.RED);
			gc.fillRect(0, 20, 50, 80);
			gc.setFill(Color.YELLOW);
			gc.fillPolygon(_1, _2, 3);
		}
		
		private void posun() {
			setLayoutY(getLayoutY()-rychlost);
			if(getLayoutY()<0) {group.getChildren().remove(this); timeline.stop();}
		}
}
