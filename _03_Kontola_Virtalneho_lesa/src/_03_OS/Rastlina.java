package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class Rastlina extends Canvas {
    protected GraphicsContext gc;
    protected int obrazok = 0;
    private Timeline t;

    public Rastlina(int x, int y){
        super(100,100);
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.seconds(1),e -> rasti()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }
    private void rasti() {
        obrazok = (obrazok+1) % 5;
        vykresli();
    }
    protected void vykresli() {};
}