package application;

import javafx.animation.AnimationTimer;

public class MyTimer extends AnimationTimer{
	private Game game;
	
	private long lastNanoTime;
	public MyTimer(Game game) {
		this.game = game;
		
	}

	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		this.game.update(now  - lastNanoTime);
		
		this.lastNanoTime = now;
		try {
	         Thread.sleep(20);
	         
	        } catch (Exception e)  {}

	}

	public void start() {
		lastNanoTime = System.nanoTime();
		super.start();
	}
}