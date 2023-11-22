

import java.util.LinkedList;

import javafx.scene.image.Image;

public class Krabica extends Kocka {
	private Image polozena;

	public Krabica(String nazov, int poziciaX, int poziciaY, int velkostKociek) {
		super(nazov, poziciaX, poziciaY, velkostKociek);
		polozena = new Image("krabica_na_bode.png", velkostKociek, velkostKociek, false, false);
	}
	public boolean jeNaBode(LinkedList<Kocka> kocky) {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Bod) {
				if((getLayoutX() == k.getLayoutX()) && (getLayoutY() == k.getLayoutY())) {
					setImage(polozena);
					return true;
				} else {
					setImage(textura);
				}
			}
		}
		return false;
	}
}
