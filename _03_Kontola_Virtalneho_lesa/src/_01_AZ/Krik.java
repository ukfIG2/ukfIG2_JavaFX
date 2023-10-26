package _01_AZ;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;


class Krik extends Rastlina {

    public Krik(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public void vizualnyVzhlad(GraphicsContext gc) {
        int size = getBaseSize() * getCurrentSizeLevel() / 2;

        QuadCurve curve = new QuadCurve();
        curve.setStartX(x - 25 - size);
        curve.setStartY(y + 10 + size);
        curve.setEndX(x + 25 + size);
        curve.setEndY(y + 10 + size);
        curve.setControlX(x);
        curve.setControlY(y - 20 - size);

        gc.setFill(Color.LIGHTGREEN);
        gc.fillOval(x - 25 - size, y - 10 - size, 50 + size, 20 + size);
        gc.fillOval(x - 15 - size, y - 20 - size, 30 + size, 20 + size);
        gc.fillOval(x, y - 20 - size, 30 + size, 20 + size);
        gc.fillOval(x - 5 - size, y - 30 - size, 40 + size, 20 + size);
        gc.fillOval(x - 10 - size, y - 20 - size, 30 + size, 20 + size);
        gc.fillOval(x + 5 + size, y - 30 - size, 40 + size, 20 + size);
        gc.fillOval(x - 10 - size, y - 30 - size, 20 + size, 20 + size);
        gc.fillOval(x + 10 + size, y - 30 - size, 20 + size, 20 + size);
    }
}