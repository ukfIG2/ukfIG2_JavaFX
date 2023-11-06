package _03_Uloha;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Balon extends Canvas {
	private GraphicsContext gc;
	private Group group;
	private int sirka, dlzka, rychlost, smer;
	
	
	public Balon(Group group, int sirka, int dlzka, int smer, double polohaX, double polohaY, int rychlost) {
		super(sirka, dlzka);
		this.sirka=sirka;
		this.dlzka=dlzka;
		this.smer=smer;
		setLayoutX(polohaX); setLayoutY(polohaY);
		Vykres();
	}

}
