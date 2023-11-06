package Strom_jablko;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Strom extends Canvas{
	private GraphicsContext gc;
	private static double sirka=300, dlzka=400;	
	Group group;
	
	public double random(double min, double max) {
		return min + (Math.random() * max-min);
	}
	
	public Strom(Group group){
		super(sirka, dlzka);//400 600
		gc = getGraphicsContext2D();
		this.group=group;
		setLayoutX(50); setLayoutY(50);
		Vykresli();
		/*Jablko jablko = new Jablko(group, random(100, 300), random(100, 200));
		group.getChildren().add(jablko);*/
	}
	
	private void Vykresli(){
		gc.setFill(Color.BROWN);
		gc.fillRect(100, 100, 100, 300);
		gc.setFill(Color.GREEN);
		gc.fillOval(0, 0, 300, 200);
	}
}
