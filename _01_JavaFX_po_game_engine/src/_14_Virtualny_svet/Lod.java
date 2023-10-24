package _14_Virtualny_svet;

import javafx.scene.paint.Color;

public class Lod extends Dopravny_prostriedok{

	public Lod(int x, int y, int rychlost, Color farba) {
		super(x, y, rychlost, farba);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    protected void vykresli() {
        gc.clearRect(0,0,
                getWidth(),getHeight());
        double[] x = {2,6,21,25,2};
        double[] y = {6,11,11,6,6};
        gc.setFill(farba);
        gc.fillPolygon(x, y, x.length);
        gc.fillRect(10, 1, 10, 6);
        if (obrazok == 0) // nakresli dym
            gc.fillOval(4,0,5,5);
    }

}
