package application;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class Bush extends Drv {
    private double x;
    private double y;
    private double currentSize = 10;
    private double growthRate = 0.5;
    private int state = 0;
    private int maxStates = 5;
    double[] berryX = {Math.random() * 50 + 80, Math.random() * 50 + 80, Math.random() * 50 + 80, Math.random() * 50 + 80, Math.random() * 50 + 80};
    double[] berryY = {Math.random() * 30 + 40, Math.random() * 30 + 40, Math.random() * 30 + 40, Math.random() * 30 + 40, Math.random() * 30 + 40};

    public Bush(double x, double y) {
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
                drawBush();
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

    private void drawBush() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        if (state == 0) {
            double stemWidth = currentSize / 4;
            gc.setFill(Color.GREEN);
            gc.fillOval(75, 60,stemWidth +5, stemWidth+5);
        } else if (state == 1) {
        	double stemWidth = currentSize / 4;
        	gc.setFill(Color.GREEN);
            gc.fillOval(75, 60,stemWidth+15, stemWidth+15);
            gc.fillOval(90, 60,stemWidth+15, stemWidth+15);
        }else if (state == 2) {
        	double stemWidth = currentSize / 4;
        	gc.setFill(Color.GREEN);
            gc.fillOval(75, 60,stemWidth+20, stemWidth+20);
            gc.fillOval(90, 60,stemWidth+20, stemWidth+20);
            gc.fillOval(82, 40,stemWidth+20, stemWidth+20);
        }else if (state == 3) {
        	double stemWidth = currentSize / 4;
        	gc.setFill(Color.GREEN);
            gc.fillOval(75, 60,stemWidth+25, stemWidth+25);
            gc.fillOval(90, 60,stemWidth+25, stemWidth+25);
            gc.fillOval(82, 40,stemWidth+25, stemWidth+25);
            gc.fillOval(97, 40,stemWidth+25, stemWidth+25);
            gc.fillOval(105, 60,stemWidth+25, stemWidth+25);
        }else if (state == 4) {
            double stemWidth = currentSize / 4;
            gc.setFill(Color.GREEN);
            gc.fillOval(75, 60, stemWidth + 30, stemWidth + 30);
            gc.fillOval(90, 60, stemWidth + 30, stemWidth + 30);
            gc.fillOval(82, 40, stemWidth + 30, stemWidth + 30);
            gc.fillOval(97, 40, stemWidth + 30, stemWidth + 30);
            gc.fillOval(105, 60, stemWidth + 30, stemWidth + 30);
            gc.fillOval(112, 40, stemWidth + 30, stemWidth + 30);
            gc.fillOval(120, 60, stemWidth + 30, stemWidth + 30);

            gc.setFill(Color.RED);
            for (int i = 0; i < 5; i++) {
                gc.fillOval(berryX[i], berryY[i], 10, 10);
            }
            
        }

        
    }
}

