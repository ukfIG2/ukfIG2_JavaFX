package application;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

class Strom extends Rastlina {
    private final Random random = new Random();

    public Strom(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public void vizualnyVzhlad(GraphicsContext gc) {
        int size = getBaseSize() * getCurrentSizeLevel() / 3;

        gc.setFill(Color.SIENNA);
        gc.fillRect(x - 5, y, 10, 40 + size);

        gc.setFill(Color.DARKGREEN);
        double[] xPoints = {x, x - 30 - size, x + 30 + size};
        double[] yPoints = {y - 40 - size, y + 10, y + 10};
        gc.fillPolygon(xPoints, yPoints, 3);
    }
}
