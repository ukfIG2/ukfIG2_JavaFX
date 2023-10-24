package _16_Virtualny_svet_3_Prezentacia;

import javafx.scene.paint.Color;

public class Auto extends DopravnyProstriedok {

    public Auto(int x, int y, int r, Color f) {
        super(x, y, r, f);
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
