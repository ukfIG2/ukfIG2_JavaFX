package _15_Virtualny_svet_2;

import javafx.scene.paint.Color;

public class Auto extends Dopravny_prostriedok{

	public Auto(int x, int y, int rychlost, Color farba) {
		super(x, y, rychlost, farba);
		// TODO Auto-generated constructor stub
	}
		
	    @Override
	    protected void vykresli() {
	        super.vykresli();
	        gc.setFill(farba);
	        gc.fillRect(2,12,40,10);
	        gc.fillRect(12,7,15,10);
	        gc.setFill(Color.BLACK);
	        gc.fillOval(7+obrazok*2,17,10,10);
	        gc.fillOval(27+obrazok*2,17,10,10);
	    
	}

}
