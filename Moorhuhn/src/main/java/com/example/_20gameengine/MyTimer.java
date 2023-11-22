package com.example._20gameengine;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MyTimer extends AnimationTimer {
    private Game myGame;
    private long lastNanoTime;

    public MyTimer(Game mg) {
        myGame = mg;
        
        RestartTimer();
    }
    public void RestartTimer()
    {
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
    		HelloApplication.timer.setText("Time: " + HelloApplication.t--);
    		if (HelloApplication.t < 0) { myGame.TimeOut(); }
    	}));
    	timeline.setCycleCount(HelloApplication.t + 1);
    	timeline.play();	
    }
    @Override
    public void handle(long now) {
        myGame.update(now - lastNanoTime);
        lastNanoTime = now;
        try {
            Thread.sleep(50);
        } catch (Exception e)  {}
    }

    public void start() {
        lastNanoTime =  System.nanoTime();
        super.start();
    }

}
