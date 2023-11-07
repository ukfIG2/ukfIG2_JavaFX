package com.example.odrazodokraja;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gulicka extends Canvas {
    int smerx = 1;
    int smery = 1;
    int rychlost = 1;
    GraphicsContext gc;
    Timeline t;
    Color farba = Color.BLUE;

    Gulicka (double x, double y) {
        super(10,10);
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();
        setOnMouseClicked(e-> {farba = Color.GREEN; vykresli();});
        t = new Timeline(new KeyFrame(Duration.millis(100), e -> pohyb()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    private void vykresli() {
        gc.setFill(farba);
        gc.fillOval(0,0,10,10);
    }

    private void pohyb() {
        if (getLayoutX() > 320) smerx = -2;
        if (getLayoutX() < 20) smerx = 1;
        if (getLayoutY() < 20) smery = 1;
        if (getLayoutY() > 220) smery = -1;
        setLayoutX(getLayoutX() + smerx * rychlost);
        setLayoutY(getLayoutY() + smery * rychlost);
    }
}
