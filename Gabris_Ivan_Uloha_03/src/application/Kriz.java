package application;

import javafx.scene.Group;

public class Kriz extends GeometrickyUtvar{

	public Kriz(Group group, double polohaX, double polohaY, double sirka, double vyska) {
		super(group, polohaX, polohaY, sirka, vyska);
		// TODO Auto-generated constructor stub
	}
	

	void Vykresli() {
		super.Vykresli();
		gc.strokeLine(0, 0, sirka, vyska);
		gc.strokeLine(0, vyska, sirka, 0);
	}

}
