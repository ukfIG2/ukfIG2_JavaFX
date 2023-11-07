package com.example.odrazodokraja;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Bezec extends Canvas {
    GraphicsContext gc;
    int smer;
    Timeline t;

    Bezec() {
        super(20,20);
        setLayoutX(150);
        setLayoutY(100);
        gc = getGraphicsContext2D();
        smer = 2;
        vykresli();
        t = new Timeline(new KeyFrame(Duration.millis(100), e -> pohyb()));
        setOnMouseClicked(e -> vytvorGulicku());
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    private void vytvorGulicku() {
        Gulicka g = new Gulicka(getLayoutX(), getLayoutY());
        Group gr = (Group) getParent();
        gr.getChildren().add(g);
    }

    private void vykresli() {
        gc.setFill(Color.RED);
        gc.fillOval(0,0,20,20);
    }

    public void pohyb() {
        double x = getLayoutX();
        double y = getLayoutY();
        x = x + smer;
        if (x > 300) smer = -2;
        if (x < 20) smer = 2;
        setLayoutX(x);
    }
}
