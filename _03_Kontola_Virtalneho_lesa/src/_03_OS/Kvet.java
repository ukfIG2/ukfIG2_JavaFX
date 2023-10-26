package _03_OS;

import javafx.scene.paint.Color;

public class Kvet extends Rastlina{
    public Kvet(int x, int y) {
        super(x, y);
    }
    protected void vykresli(){
        gc.clearRect(0,0,getWidth(), getHeight());

        switch (obrazok){
            case 0 :gc.setStroke(Color.GREEN);
                    gc.setLineWidth(3);
                    gc.strokeLine(50,75,50,90);
                    gc.setFill(Color.GREEN);
                    gc.fillOval(42,55,15,20); break;

            case 1 :gc.setStroke(Color.GREEN);
                    gc.setLineWidth(3.5);
                    gc.strokeLine(50,65,50,90);
                    gc.strokeLine(50,90,45,80);
                    gc.strokeLine(50,90,55,80);
                    gc.setFill(Color.GREEN);
                    gc.fillOval(42,45,15,20); break;

            case 2 :gc.setStroke(Color.GREEN);
                    gc.setLineWidth(3.5);
                    gc.strokeLine(50,55,50,90);
                    gc.strokeLine(50,90,45,70);
                    gc.strokeLine(50,90,55,70);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(42,35,15,20); break;

            case 3 :gc.setStroke(Color.GREEN);
                    gc.setLineWidth(3.5);
                    gc.strokeLine(50,45,50,90);
                    gc.strokeLine(50,90,45,60);
                    gc.strokeLine(50,90,55,60);
                    gc.setFill(Color.ORANGE);
                    gc.fillOval(40,20,20,25); break;

            case 4 :gc.setStroke(Color.GREEN);
                    gc.setLineWidth(3.5);
                    gc.strokeLine(50,35,50,90);
                    gc.strokeLine(50,90,40,50);
                    gc.strokeLine(50,90,60,50);
                    gc.setFill(Color.RED);
                    gc.fillOval(40,35,20,20);
                    gc.fillOval(34,20,20,20);
                    gc.fillOval(48,20,20,20);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(45,32,10,10); break;
        }
    }
}
