package _06_Casovac_timeline;

import javafx.animation.AnimationTimer;

public class MyTimer extends AnimationTimer{
	
	AutoSemafor AS;
	int pocitadlo;
	
	public MyTimer(AutoSemafor sem) {
		AS = sem;
		pocitadlo = 0;
	}
	
	public void handle(long now) {
		pocitadlo = (pocitadlo + 1) % 60;
		if (pocitadlo ==0) AS.zmenaStavu();
	}

}
