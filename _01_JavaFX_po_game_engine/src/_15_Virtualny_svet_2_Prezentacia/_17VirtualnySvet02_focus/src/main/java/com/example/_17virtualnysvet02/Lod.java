package _15_Virtualny_svet_2_Prezentacia._17VirtualnySvet02_focus.src.main.java.com.example._17virtualnysvet02;

import javafx.scene.paint.Color;

public class Lod extends DopravnyProstriedok {

    public Lod(int x, int y, int r, Color f) {
        super(x, y, r, f);
    }

    @Override
    protected void vykresli() {
        super.vykresli();
        double[] x = {2,6,21,25,2};
        double[] y = {6,11,11,6,6};
        gc.setFill(farba);
        gc.fillPolygon(x, y, x.length);
        gc.fillRect(10, 1, 10, 6);
        if (obrazok == 0) // nakresli dym
            gc.fillOval(4,0,5,5);
    }

}
