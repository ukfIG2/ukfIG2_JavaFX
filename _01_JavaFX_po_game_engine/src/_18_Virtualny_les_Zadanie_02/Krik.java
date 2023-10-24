package _18_Virtualny_les_Zadanie_02;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Krik extends Rastlina{

	public Krik(Group group, double x, double y) {
		super(group, x, y);
		// TODO Auto-generated constructor stub
	}

	protected void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
		//zem
		gc.setFill(Color.BLACK);
		gc.fillRect(0, getHeight()-zem, getWidth(), zem);
		//krik
		gc.setFill(Color.GREEN);
		gc.fillRect(getWidth()/2-(stav*10), getHeight()-zem-(stav*40), stav*20, stav*40);	
	}
}
