package _15_Virtualny_svet_2_Prezentacia._17VirtualnySvet02_focus.src.main.java.com.example._17virtualnysvet02;

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

