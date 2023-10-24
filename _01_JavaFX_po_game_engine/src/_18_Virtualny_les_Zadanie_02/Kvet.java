package _18_Virtualny_les_Zadanie_02;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Kvet extends Rastlina{

	public Kvet(Group group, double x, double y) {
		super(group, x, y);
	}
	
	protected void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
		//zem
		gc.setFill(Color.BLACK);
		gc.fillRect(0, getHeight()-zem, getWidth(), zem);
		//stonka
		gc.setFill(Color.GREEN);
		gc.fillRect(getWidth()/2-(stav*5/2), getHeight()-zem-(stav*20/2), stav*10/2, stav*20/2);
		//kvet
		gc.setFill(Color.RED);
		gc.fillOval(getWidth()/2-(stav*5/2)-(stav*5/2), getHeight()-zem-(stav*10/2)-stav*20/2, stav*20/2, stav*20/2);
		//vnutro
		gc.setFill(Color.YELLOW);
		gc.fillOval(getWidth()/2-(stav*5/4)-(stav*5/4), getHeight()-zem-(stav*10/4)-stav*20/2, stav*5, stav*5);
	}
	

}
