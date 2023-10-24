package _12_Semafor_bonus;

import javafx.animation.AnimationTimer;

public class MyTimer_bonus extends AnimationTimer{
	
	semafor_bonus AS;
	int pocitadlo;
	
	public MyTimer_bonus(semafor_bonus sem) {
		AS = sem;
		pocitadlo = 0;
	}
	
	public void handle(long now) {
		pocitadlo = (pocitadlo + 1) % 60;
		if (pocitadlo ==0) AS.zmenaStavu();
	}

}
