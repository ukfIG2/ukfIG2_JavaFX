

import java.util.LinkedList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Kocka extends ImageView {
	protected Image textura;
	protected int startX, startY, poziciaX, poziciaY, velkostKociek;

	public Kocka(String nazov, int poziciaX, int poziciaY, int velkostKociek) {
		this.startX = poziciaX;
		this.startY = poziciaY;
		this.poziciaX = poziciaX;
		this.poziciaY = poziciaY;
		this.velkostKociek = velkostKociek;
		
		textura = new Image(nazov, velkostKociek, velkostKociek, false, false);
		setImage(textura);
		
		setLayoutX(velkostKociek*(2+poziciaX));
		setLayoutY(velkostKociek*(2+poziciaY));
	}
	public boolean moznoDolava(LinkedList<Kocka> kocky, boolean siHrac) {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Krabica) {
				if((getLayoutX()-velkostKociek == k.getLayoutX()) && (getLayoutY() == k.getLayoutY())) {
					if(k.moznoDolava(kocky, false)) {
						if(siHrac) {
							k.dolava();
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			if(k instanceof Stena) {
				if((getLayoutX()-velkostKociek == k.getLayoutX()) && (getLayoutY() == k.getLayoutY())) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean moznoDoprava(LinkedList<Kocka> kocky, boolean siHrac) {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Krabica) {
				if((getLayoutX()+velkostKociek == k.getLayoutX()) && (getLayoutY() == k.getLayoutY())) {
					if(k.moznoDoprava(kocky, false)) {
						if(siHrac) {
							k.doprava();
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			if(k instanceof Stena) {
				if((getLayoutX()+velkostKociek == k.getLayoutX()) && (getLayoutY() == k.getLayoutY())) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean moznoHore(LinkedList<Kocka> kocky, boolean siHrac) {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Krabica) {
				if((getLayoutX() == k.getLayoutX()) && (getLayoutY()-velkostKociek == k.getLayoutY())) {
					if(k.moznoHore(kocky, false)) {
						if(siHrac) {
							k.hore();
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			if(k instanceof Stena) {
				if((getLayoutX() == k.getLayoutX()) && (getLayoutY()-velkostKociek == k.getLayoutY())) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean moznoDole(LinkedList<Kocka> kocky, boolean siHrac) {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Krabica) {
				if((getLayoutX() == k.getLayoutX()) && (getLayoutY()+velkostKociek == k.getLayoutY())) {
					if(k.moznoDole(kocky, false)) {
						if(siHrac) {
							k.dole();
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			if(k instanceof Stena) {
				if((getLayoutX() == k.getLayoutX()) && (getLayoutY()+velkostKociek == k.getLayoutY())) {
					return false;
				}
			}
		}
		return true;
	}
	public void dolava() {
		setLayoutX(getLayoutX()-velkostKociek);
	}
	public void doprava() {
		setLayoutX(getLayoutX()+velkostKociek);
	}
	public void hore() {
		setLayoutY(getLayoutY()-velkostKociek);
	}
	public void dole() {
		setLayoutY(getLayoutY()+velkostKociek);
	}
	public int getStartX() {
		return startX;
	}
	public int getStartY() {
		return startY;
	}
}
