package _18_Virtualny_les_Zadanie_02;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Strom extends Rastlina{//100 200

	public Strom(Group group, double x, double y) {		//100 200
		super(group, x, y);
		
	}
	
	protected void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
		//zem
		gc.setFill(Color.BLACK);
		gc.fillRect(0, getHeight()-zem, getWidth(), zem);
		//kmen
		gc.setFill(Color.BROWN);
		gc.fillRect(getWidth()/2-(stav*5), getHeight()-zem-(stav*20), stav*10, stav*20);
		//koruna
		gc.setFill(Color.GREEN);
		gc.fillOval(getWidth()/2-(stav*5)-(stav*5), getHeight()-zem-(stav*10)-stav*20, stav*20, stav*20);
	}

}
