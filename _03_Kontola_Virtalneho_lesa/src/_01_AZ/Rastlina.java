package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

class Rastlina {
    private int currentSizeLevel;
    private final int maxSizeLevel = 5;
    private int baseSize = 30;
    protected double x;
    protected double y;

    public Rastlina() {
        this.currentSizeLevel = 1;
    }

    public int getCurrentSizeLevel() {
        return currentSizeLevel;
    }

    public void increaseSizeLevel() {
        currentSizeLevel = (currentSizeLevel % maxSizeLevel) + 1;
    }

    public int getBaseSize() {
        return baseSize;
    }

    public void vizualnyVzhlad(GraphicsContext gc) {
    }
}
