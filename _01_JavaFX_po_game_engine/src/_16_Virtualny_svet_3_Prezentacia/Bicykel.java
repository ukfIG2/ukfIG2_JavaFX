package _16_Virtualny_svet_3_Prezentacia;

import javafx.scene.paint.Color;

public class Bicykel extends DopravnyProstriedok {

    public Bicykel(int x, int y, int r, Color f) {
        super(x, y, r, f);
    }

    @Override
    protected void vykresli() {
        super.vykresli();
        gc.setStroke(farba);
        gc.strokeLine(12,12,30,10);
        gc.setStroke(Color.BLACK); // kolesa
        gc.strokeOval(17+obrazok*2,17,10,10);
        gc.strokeOval(27-obrazok*2,17,10,10);
    }
}

