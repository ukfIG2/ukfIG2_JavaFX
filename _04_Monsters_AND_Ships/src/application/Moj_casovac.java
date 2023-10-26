package application;

import javafx.animation.AnimationTimer;

public class Moj_casovac extends AnimationTimer{
	private Game mojaHra;
	private long lastNanoTime;
	
	public Moj_casovac(Game mH) {
		mojaHra = mH;
	}
	public void handle(long now) {
		mojaHra.update(now - lastNanoTime);
		lastNanoTime = now;
		try {
			Thread.sleep(50);
		} catch (Exception e) {}
	}
	
	public void start() {
		lastNanoTime = System.nanoTime();
		super.start();
	}

}
