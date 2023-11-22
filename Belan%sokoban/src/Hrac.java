

import javafx.scene.image.Image;

public class Hrac extends Kocka {
	private Image[] smerHraca;
	
	public Hrac(String nazov, int poziciaX, int poziciaY, int velkostKociek) {
		super(nazov, poziciaX, poziciaY, velkostKociek);
		smerHraca = new Image[4];
		for(int i = 0; i <= 3; i++) {
			smerHraca[i] = new Image("hrac"+(i+1)+".png", velkostKociek, velkostKociek,  false, false);
		}
	}
	public void resetSmerHraca() {
		setImage(smerHraca[0]);
	}
	public void dolava() {
		super.dolava();
		setImage(smerHraca[2]);
	}
	public void doprava() {
		super.doprava();
		setImage(smerHraca[3]);
	}
	public void hore() {
		super.hore();
		setImage(smerHraca[1]);
	}
	public void dole() {
		super.dole();
		setImage(smerHraca[0]);
	}
}
