package _14_Virtualny_svet;

import javafx.scene.paint.Color;

public class Bicykel extends Dopravny_prostriedok{
	
	public Bicykel(int x, int y, int rychlost, Color farba) {
		super(x, y, rychlost, farba);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void vykresli() {
	       gc.clearRect(0,0,getWidth(),getHeight());
	        gc.setStroke(farba);
	        gc.strokeLine(12,12,30,10);
	        gc.setStroke(Color.BLACK); // kolesa
	        gc.strokeOval(17+obrazok*2,17,10,10);
	        gc.strokeOval(27-obrazok*2,17,10,10);
	}
}
