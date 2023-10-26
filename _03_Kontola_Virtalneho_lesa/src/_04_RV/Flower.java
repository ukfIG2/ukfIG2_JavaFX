package _04_RV;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;



public class Flower extends Drv {
    private double x;
    private double y;
    private double currentSize = 10;
    private double growthRate = 0.5;
    private int state = 0;
    private int maxStates = 5;

    
    public Flower(double x, double y) {
        super(0, 0);
        this.x = x;
        this.y = y;
        setLayoutX(this.x);
        setLayoutY(this.y);
        startGrowing();
    }

    public void startGrowing() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                currentSize += growthRate;
                drawFlower();
                if (currentSize >= 30) {
                    currentSize = 10;
                    state++;
                    if (state == maxStates) {
                        state = 0;
                    }
                }
            }
        };
        timer.start();
    }

    private void drawFlower() {
    	
        gc.clearRect(0, 0, getWidth(), getHeight());
        
        
        if (state == 0) {
            double stemHeight = 2 * currentSize;
            double stemWidth = currentSize / 10;
            gc.setFill(Color.GREEN);
            gc.fillRect((getWidth() - stemWidth) / 2, getHeight() - stemHeight +20, stemWidth, stemHeight);

            gc.setFill(Color.GREEN);
            gc.fillOval((getWidth() - currentSize +20) / 2, getHeight() - stemHeight - currentSize +30, currentSize-20, currentSize-10);
        } else if (state == 1) {
        	double stemWidth = currentSize / 10;
        	gc.setFill(Color.GREEN);
            gc.fillRect((getWidth() - 3) / 2, getHeight() - 60 +20, 3, 60);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +30, 30-20, 30-10);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +55,stemWidth+ 1, 15);
            gc.fillOval((getWidth() - 30 +25) / 2, getHeight() - 60 - 30 +60,stemWidth+ 1, 15);
        }else if (state == 2) {
        	double stemWidth = currentSize / 10;
        	gc.setFill(Color.GREEN);
            gc.fillRect((getWidth() - 3) / 2, getHeight() - 60 +20, 3, 60);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +30, 30-20, 30-10);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +55,4, 15);
            gc.fillOval((getWidth() - 30 +25) / 2, getHeight() - 60 - 30 +60,4 , 15);
            gc.fillOval((getWidth() - 30 +30) / 2, getHeight() - 60 - 30 +75,stemWidth+ 1, 15);
            gc.fillOval((getWidth() - 30 +33) / 2, getHeight() - 60 - 30 +70,stemWidth+ 1 , 15);
        }else if (state == 3) {
        	gc.setFill(Color.GOLD);
        	gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +30, 30-20, 30-10);
            gc.setFill(Color.GREEN);
            gc.fillRect((getWidth() - 3) / 2, getHeight() - 60 +20, 3, 60);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +55,4, 15);
            gc.fillOval((getWidth() - 30 +25) / 2, getHeight() - 60 - 30 +60,4 , 15);
            gc.fillOval((getWidth() - 30 +30) / 2, getHeight() - 60 - 30 +75,4, 15);
            gc.fillOval((getWidth() - 30 +33) / 2, getHeight() - 60 - 30 +70,4 , 15);
            
        }else if (state == 4) {
        	double stemWidth = currentSize / 3;
        	double stemWidth1 = (currentSize) / 2;
        	gc.setFill(Color.GOLD);
        	gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +30, 30-20, 30-10);
        	gc.fillOval((getWidth() - 30 +30) / 2, getHeight() - 60 ,stemWidth , stemWidth1);
        	gc.fillOval((getWidth() - 30 +20 - stemWidth) / 2, getHeight() - 60,stemWidth , stemWidth1);
            gc.setFill(Color.GREEN);
            gc.fillRect((getWidth() - 3) / 2, getHeight() - 60 +20, 3, 60);
            gc.fillOval((getWidth() - 30 +20) / 2, getHeight() - 60 - 30 +55,4, 15);
            gc.fillOval((getWidth() - 30 +25) / 2, getHeight() - 60 - 30 +60,4 , 15);
            gc.fillOval((getWidth() - 30 +30) / 2, getHeight() - 60 - 30 +75,4, 15);
            gc.fillOval((getWidth() - 30 +33) / 2, getHeight() - 60 - 30 +70,4 , 15);
        }
    }
}
