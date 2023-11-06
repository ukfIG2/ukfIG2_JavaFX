package _02_Uloha;

import javax.swing.RootPaneContainer;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Lietadlo extends Canvas{
	private GraphicsContext gc;
	private double polohaX, polohaY;
	private double rychlost;
	private double _01[] = {80, 80, 100};
	private double _02[] = {0, 50, 25};
	private double _03[] = {0, 20, 20};
	private double _04[] = {25, 0, 50};
	private int smer;
	private Group group;
	private Timeline timeline;

	public Lietadlo(Group group, double polohaX, double polohaY, double rychlost) {
	super(100, 50);
	this.polohaX=polohaX; setLayoutX(polohaX);
	this.polohaY=polohaY; setLayoutY(polohaY);
	gc = getGraphicsContext2D(); this.group=group;
	smer=0;
	this.rychlost=rychlost;
	Vykresli();
	setFocusTraversable(true);
	setOnKeyPressed(e -> spracujKlaves(e));
	}
	
	private void Vykresli() {
			if(smer==0) {
				gc.setFill(Color.RED);
				gc.fillRect(0, 0, 80, 50);
				gc.setFill(Color.YELLOW);
				gc.fillPolygon(_01, _02, 3);
			}
			else if(smer==1) {
				gc.setFill(Color.RED);
				gc.fillRect(20, 0, 80, 50);
				gc.setFill(Color.YELLOW);
				gc.fillPolygon(_03, _04, 3);
			}
	}
	
	public void zmenRychlost(double rychlost) {
		this.rychlost=rychlost;
	}
	
	private void spracujKlaves(KeyEvent evt) {
		KeyCode keycode = evt.getCode();
		if(keycode==keycode.A) {smer=1; posun(1); Vykresli();}
		else if(keycode==keycode.D) {smer=0; posun(0); Vykresli();}
		else if(keycode==keycode.SPACE) {Raketa raketa = new Raketa(group, getLayoutX(), getLayoutY(), 10); group.getChildren().add(raketa);}
	}
	
	private void posun(int smer) {
		if(smer==0) {
			setLayoutX(getLayoutX()+rychlost);
			if(getLayoutX()>400) {setLayoutX(0);}
			System.out.println(getLayoutX()+" "+rychlost);
		}
		if(smer==1) {
			setLayoutX(getLayoutX()-rychlost);
			if(getLayoutX()<0) {setLayoutX(400);}
			System.out.print("Dolava");
		}
	}
	
}
