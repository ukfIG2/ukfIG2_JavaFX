package com.example.jablko;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Jablko extends Canvas {
    GraphicsContext gc;
    int stav = 0;
    Timeline t;

    Jablko() {
        super(20,20);
        setLayoutX(Math.random()*200+20);
        setLayoutY(Math.random()*200+20);
        gc = getGraphicsContext2D();
        setFocusTraversable(true);
        requestFocus();
        setOnMouseClicked(e->requestFocus());
        setOnKeyPressed(e->spracujKlaves(e));
        t = new Timeline(new KeyFrame(Duration.millis(500), e -> zmena()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    private void zmena() {
        if (stav == 0) {vykresli(); stav = 1;return;}
        if (stav == 1) {vykresli(); stav = 0;return;}
        if (stav == 3) {
            if (getLayoutY() < 250) {
                setLayoutY(getLayoutY() + 5);
            } else {
                stav = 4;
            }
        }
        if (stav == 4) {
            Group gr  = (Group) getParent();
            gr.getChildren().remove(this);
        }
    }

    void vykresli() {
        if (stav == 0) gc.setFill(Color.RED);
        if (stav == 1) gc.setFill(Color.ORANGE);
        gc.fillOval(0,0,20,20);
    }

    void spracujKlaves(KeyEvent evt) {
        KeyCode code = evt.getCode();
        if (code == KeyCode.SPACE) {
            stav = 3;
        }
    }
}
