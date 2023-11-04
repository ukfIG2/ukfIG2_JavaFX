package _03_Priklady_zadania_03_Uloha;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Balon extends Canvas{
	protected GraphicsContext gc;
	protected double polohaX;
	protected double prva_polohaX;
	protected double polohaY;
	protected double prva_polohaY;
	protected Group group;
	protected int rychlost;
	protected Timeline timeline;
	protected int smer;
	protected double sirka;
	protected double vyska;
	protected Color color;
	protected Color farba[] = {Color.RED, Color.BLACK, Color.BLUE};
	protected int farba_i = 0;
	
	public Balon(Group group, double polohaX, double polohaY, int rychlost, Color color, int sirka, int vyska, int smer) {
		super(sirka, vyska);
		gc = getGraphicsContext2D();
		this.polohaX = polohaX; setLayoutX(this.polohaX); prva_polohaX = polohaX;
		this.polohaY = polohaY; setLayoutY(this.polohaY); prva_polohaY = polohaY;
		this.sirka=sirka; this.vyska=vyska; this.smer=smer;
		this.color=color; this.rychlost=rychlost;
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> posun(this.smer)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		Vykres();
	}
	
	protected void posun(int smer) {
		if(smer==0) {
			setLayoutY(getLayoutY()+rychlost);
			//System.out.println(getLayoutY()+"  "+ rychlost +" Vyyska_"+ vyska);
			if(getLayoutY()>400) setLayoutY(prva_polohaY);
			//System.out.println("Pohyb dole");
		}
		else if(smer==1) {
			setLayoutY(getLayoutY()-rychlost);
			//System.out.println(getLayoutY()+"  "+ rychlost);
			if(getLayoutY()<0) setLayoutY(prva_polohaY);
			//System.out.println("Pohyb hore");
		}
	}
	
	protected void Vykres() {
		gc.clearRect(0, 0, sirka, vyska);
		gc.setFill(color);
		gc.fillOval(0, 0, sirka, vyska-20);
		gc.setStroke(Color.BLACK);
		gc.strokeLine(sirka/2, vyska-20, sirka, vyska);
	}
	
	public void zmenFarbu() {
		color = farba[farba_i%3];
		farba_i++;
		System.out.print(color+" "+farba_i);
		Vykres();
	}
	
	public void posunDoprava() {
		setLayoutX(getLayoutX()+rychlost);
	}
	
	
	

}
