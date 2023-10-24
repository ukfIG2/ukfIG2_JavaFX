package _02.Vlastne_komponenty;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PostZnacka1 extends Canvas{

	private int sirka,dlzka;
	private Color farba;
	
	public PostZnacka1(int sirka, int dlzka, Color farba) {
		super(sirka,dlzka);
		this.sirka=sirka;	this.dlzka=dlzka;	this.farba=farba;
		GraphicsContext gc = this.getGraphicsContext2D();
		Vykresli(gc);
	}
		
	private void Vykresli(GraphicsContext gc) {
		gc.setStroke(farba);
		gc.strokeRect(0, 0, sirka, dlzka);
		gc.strokeLine(0, 0, sirka, dlzka);
		gc.strokeLine(0, dlzka, sirka, 0);
	}
	
}
