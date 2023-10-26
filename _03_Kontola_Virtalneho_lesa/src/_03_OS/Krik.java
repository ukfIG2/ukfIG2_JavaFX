package _03_OS;

import javafx.scene.paint.Color;

public class Krik extends Rastlina{
    public Krik(int x, int y) {
        super(x, y);
    }
    @Override 
    protected void vykresli() {
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(Color.GREEN);
        gc.fillOval(30-obrazok,80-obrazok*2,40+obrazok*2,20+obrazok*2);
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(2);
        gc.strokeLine(50,100,50,90-obrazok*2);
        gc.strokeLine(50,95,40-obrazok,90-obrazok*2);
        gc.strokeLine(50,95,60+obrazok,90-obrazok*2);

    }
}
