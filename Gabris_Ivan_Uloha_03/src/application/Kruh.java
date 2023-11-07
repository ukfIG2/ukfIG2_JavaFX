package application;

import javafx.scene.Group;

public class Kruh extends GeometrickyUtvar {

	public Kruh(Group group, double polohaX, double polohaY, double sirka, double vyska) {
		super(group, polohaX, polohaY, sirka, vyska);
		// TODO Auto-generated constructor stub
	}
	
	void Vykresli() {
		super.Vykresli();
		gc.strokeOval(0, 0, sirka, vyska);
	}

}
