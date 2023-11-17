package application;

import javafx.animation.AnimationTimer;

public class MyTimer extends AnimationTimer {
    private Game game;
    private long lastNanoTime;

    public MyTimer(Game game) {
    	this.game=game;
    }

    @Override
    public void handle(long now) {
        game.update(now - lastNanoTime);
        lastNanoTime = now;
        try {
            Thread.sleep(40);
        } catch (Exception e)  {}

    }

    public void start() {
        lastNanoTime =  System.nanoTime();
        super.start();
    }

}
