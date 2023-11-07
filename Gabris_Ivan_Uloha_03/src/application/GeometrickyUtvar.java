package application;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public  class GeometrickyUtvar extends Canvas{
	GraphicsContext gc;
	Group group;
	double sirka;
	double vyska;
	public GeometrickyUtvar(Group group, double polohaX, double polohaY,
			double sirka, double vyska) {
		super(100, 100);
		this.group = group; this.sirka=sirka; this.vyska=vyska;
		setLayoutX(polohaX); setLayoutY(polohaY);
		gc= getGraphicsContext2D();
		Vykresli();
		
	}
	
	void Vykresli() {
	gc.setStroke(Color.BLACK);
	gc.strokeRect(0, 0, sirka, vyska);
	}
	
	void zvacsi() {
		sirka*=2;
		vyska*=2;
		Vykresli();
	}

	void zmensi() {
		sirka/=2;
		vyska/=2;
		Vykresli();
	}
}
