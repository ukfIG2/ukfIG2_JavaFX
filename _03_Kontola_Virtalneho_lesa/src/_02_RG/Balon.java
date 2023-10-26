package _02_RG;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Balon extends Canvas {
	protected GraphicsContext gc;
	protected Color farba;
	private double rychlost;
	private Timeline casovac;
	
	
	public Balon() {
		super(100,100);
		int x = generujPolohu();
		int y = 500;
		rychlost = generujRychlost();
		gc = getGraphicsContext2D();
		if (rychlost<=0) {this.rychlost = 1;}
		setLayoutX(x); setLayoutY(y);
		vykresli();
		spusti();
		
		setOnMouseClicked(e -> {
			casovac.stop();
			vymaz();
		});
	}
	
	public void vykresli() {
		gc.setStroke(Color.BLACK);
		gc.strokeLine(37.5, 30, 37.5, 100);
		gc.strokeOval(25, 25, 25, 40);
		gc.setFill(Color.rgb(generujFarbu(),generujFarbu(),generujFarbu()));
		gc.fillOval(25, 25, 25, 40);
	}
	
	public void let(double rychlost) {
		double y = getLayoutY();
		if (y <501 && y>-75) {
		setLayoutY(y-rychlost);}
		else vymaz();
	}
	
    public void vymaz() {
        Group parent = (Group) getParent();
        parent.getChildren().remove(this);
        casovac.stop();
    }
	
	public void spusti() {
		casovac = new Timeline(new KeyFrame(Duration.millis(1), e -> let(rychlost)));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
	}
	
	public int generujFarbu() {
		Random random = new Random();
	    int cislo = random.nextInt(255);
	    return cislo;
	}
	public double generujRychlost() {
		Random random = new Random();
	    double cislo = random.nextDouble(0.6);
		return 0.05+(cislo);
	}
	public int generujPolohu() {
		Random random = new Random();
	    int cislo = random.nextInt(300);
		return cislo;
	}
	
	
}
