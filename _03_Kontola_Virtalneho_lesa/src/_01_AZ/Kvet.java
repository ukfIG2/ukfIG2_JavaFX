package application;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;


class Kvet extends Rastlina {

    public Kvet(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public void vizualnyVzhlad(GraphicsContext gc) {
        int size = getBaseSize() * getCurrentSizeLevel() / 2;

        double[] hviezdaX = new double[14];
        double[] hviezdaY = new double[14];

        for (int i = 0; i < 14; i++) {
            double uholRad = Math.toRadians(i * 360.0 / 7 - 90);
            if (i % 2 == 0) {
                hviezdaX[i] = x + (35 + size) * Math.cos(uholRad);
                hviezdaY[i] = y + (35 + size) * Math.sin(uholRad);
            } else {
                hviezdaX[i] = x + (20 + size) * Math.cos(uholRad);
                hviezdaY[i] = y + (20 + size) * Math.sin(uholRad);
            }
        }

        gc.setFill(Color.ORANGE);
        gc.fillPolygon(hviezdaX, hviezdaY, 14);
    }
}

