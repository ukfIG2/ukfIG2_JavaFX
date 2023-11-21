package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Timer extends Canvas {
	
	GraphicsContext gc;
    Timeline t;
    private int sec;

    public Timer(int sec){
        super(150,150);
        setLayoutX(20);
        setLayoutY(5);
        this.sec = sec;
        gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.seconds(1),actionEvent -> casovac()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        casovac();
    }

    public void casovac(){
        sec--;
        if(sec < 0) System.exit(0);
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.BLACK);
        gc.fillText(("Cas :" + " " + sec), 0, 30);
    }

}
