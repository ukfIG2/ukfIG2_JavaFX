package _17_Zoologicka_cvicenie;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Bylina extends Zviera{

	public Bylina(Group root, int x, int y, int rychlost, Color farba) {
		super(root, x, y, rychlost, farba);
	}
	
	public void posun() {
		setLayoutX(getLayoutX()+rychlost);
	}
	
	public void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
	}
	
	public void prefarby(Color farba) {
		this.farba=farba;
	}

}
