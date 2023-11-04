package _01_Ulohy_z_prednasky;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gula extends Canvas{
	private Color color;
	private int smer;	//0doprava;1dolava;2hore;3dole
	private GraphicsContext gc;
	private double polohaX; private double polohaY;
	private int rychlost = 10;
	protected Group root;
	
	public Gula(Group root, Color color, int smer, double polohaX, double polohaY) {
		super(100, 100);
		gc = getGraphicsContext2D();
		this.polohaX=polohaX;
		setLayoutX(polohaX);
		this.polohaY=polohaY;
		setLayoutY(polohaY);
		this.color=color;
		this.smer=smer;
		this.root=root;
		Vykresli();
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),
				e -> pohyb(this.smer)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		setOnMouseClicked(e -> klik_na_horizont());
	}
	
	private void Vykresli() {
		gc.setFill(color);
		gc.fillOval(0, 0, 100, 100);
	}
	
	private void pohyb(int smer) {
		if(smer==0) {setLayoutX(getLayoutX()+rychlost); if(getLayoutX()>500-100) {this.smer++;}}
		if(smer==1) {setLayoutX(getLayoutX()-rychlost); if(getLayoutX()<0) {this.smer--;}}
		if(smer==2) {setLayoutY(getLayoutY()-rychlost); if(getLayoutY()<0) {this.smer++;}}
		if(smer==3) {setLayoutY(getLayoutY()+rychlost); if(getLayoutY()>500-100) {this.smer--;}}
		//System.out.println(getLayoutX()+" "+ getLayoutY());
	}
	
	private void klik_na_horizont() {
		Gula2 gula_ = new Gula2(root, Color.BLUE, 0, 0, getLayoutX(), getLayoutY());
		root.getChildren().add(gula_);
	}
	
}
