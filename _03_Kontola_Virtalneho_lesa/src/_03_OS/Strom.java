package _03_OS;

import javafx.scene.paint.Color;

public class Strom extends Rastlina {


    public Strom(int x, int y) {
        super(x, y);
    }

    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.BROWN);
        gc.fillRect(55 - obrazok, 60 - obrazok, 10 + obrazok, 65 + obrazok);
        gc.setFill(Color.GREEN);
        gc.fillOval(30 - obrazok, 10 - obrazok * 2, 60 + obrazok * 2, 60 + obrazok * 2);

        if (obrazok == 4) {
            gc.setFill(Color.BROWN);
            gc.fillRect(55 - obrazok, 60 - obrazok, 10 + obrazok, 65 + obrazok);
            gc.setFill(Color.GREEN);
            gc.fillOval(30 - obrazok, 10 - obrazok * 2, 60 + obrazok * 2, 60 + obrazok * 2);
            gc.setFill(Color.RED);
            gc.fillOval(40, 20, 10, 10);
            gc.fillOval(70, 20, 10, 10);
            gc.fillOval(60, 40, 10, 10);
        }
    }
}
