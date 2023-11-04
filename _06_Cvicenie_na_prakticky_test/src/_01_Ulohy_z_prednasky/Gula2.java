package _01_Ulohy_z_prednasky;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gula2 extends Canvas{
	private Color color;
	private int smerX;//0doprava;1dolava;2hore;3dole
	private int smerY;
	private GraphicsContext gc;
	private double polohaX; private double polohaY;
	private int rychlost = 10;
	protected Group root;
	
	public Gula2(Group root, Color color, int smerX, int smerY, double polohaX, double polohaY) {
		super(50, 50);
		gc = getGraphicsContext2D();
		this.polohaX=polohaX;
		setLayoutX(polohaX);
		this.polohaY=polohaY;
		setLayoutY(polohaY);
		this.color=color;
		this.smerX=smerX;
		this.smerY=smerY;
		this.root=root;
		Vykresli();
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),
				e -> pohyb(this.smerX, this.smerY)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		setOnMouseClicked(e -> klik_na_vertikal());
	}
	
	private void Vykresli() {
		gc.clearRect(0, 0, 500, 500);
		gc.setFill(color);
		gc.fillOval(0, 0, 50, 50);
	}
	
	private void pohyb(int smerX, int smerY) {
		if(smerX==0) {
			setLayoutX(getLayoutX()-rychlost);
			if (getLayoutX()<0) {this.smerX++;}
		}
		if(smerX==1) {
			setLayoutX(getLayoutX()+rychlost);
			if(getLayoutX()>450) {this.smerX--;}
		}
		if(smerY==0) {
			setLayoutY(getLayoutY()-rychlost);
			if (getLayoutY()<0) {this.smerY++;}
		}
		if(smerY==1) {
			setLayoutY(getLayoutY()+rychlost);
			if(getLayoutY()>450) {this.smerY--;}
		}
	}
	
	private void klik_na_vertikal() {
		this.color=Color.GREEN;
		Vykresli();
		System.out.println("klik");
	}
	
}
