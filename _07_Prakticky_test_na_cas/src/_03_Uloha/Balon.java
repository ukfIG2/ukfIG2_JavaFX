package _03_Uloha;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Balon extends Canvas {
	private GraphicsContext gc;
	private Group group;
	private int sirka, dlzka, rychlost, smer;
	private Color color;
	
	
	public Balon(Group group, int sirka, int dlzka, int smer, double polohaX, double polohaY, int rychlost, Color color) {
		super(sirka, dlzka);
		this.sirka=sirka;
		this.dlzka=dlzka;
		this.smer=smer;
		setLayoutX(polohaX); setLayoutY(polohaY);
		gc = getGraphicsContext2D();	this.color=color;
		this.group=group;
		this.rychlost=rychlost;
		Vykres();
	}
		private void Vykres() {
			gc.setFill(color);
			gc.fillOval(0, 0, sirka, dlzka);
		}
		
		private void posun() {
			if(smer ==0) {
				setLayoutY(getLayoutY()+rychlost);
				if()
			}
		}
}
