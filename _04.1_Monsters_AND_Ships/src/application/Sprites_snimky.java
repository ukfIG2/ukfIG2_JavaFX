package application;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprites_snimky extends ImageView {
	//private Game game;
	private Image[] snimky; //Zoznam snimkov
	// -1 - bez smeru, 0 - hore, 1 - dole, 2 - doprava, 3 - dolava
	private int smer = 0;
	private int Aktualny_Snimok = 0;
	private double Sirka_snimku, Vyska_snimku;
	//private double Sirka_Sceny, Vyska_Sceny;
	//Timeline timeline; //???
	
	public Sprites_snimky(String nazov, int Pocet_Snimkov, 
			double poloha_x, double poloha_y, double Sirka_snimku, 
			double Vyska_snimku ) {
		super(); this.Sirka_snimku = Sirka_snimku; this.Vyska_snimku=Vyska_snimku;
		snimky = new Image[Pocet_Snimkov];
		for(int i=0; i<Pocet_Snimkov; i++) {
			snimky[i] = new Image(nazov+i+".png", Sirka_snimku, Vyska_snimku,
					false, false);
		}
		setImage(snimky[0]);
		setLayoutX(poloha_x);
		setLayoutY(poloha_y);
	}
	
	public double getWidth() {
		return Sirka_snimku;
	}
	
	public double getHeight() {
		return Vyska_snimku;
	}
	
	public void hore(double delta, double maxY) {
		setLayoutY(getLayoutY() - delta);
		if(getLayoutY() < 0) {setLayoutY(0);}
		smer = 0;	vykresli();
	}
	
	public void dole(double delta, double maxY) {
		setLayoutY(getLayoutY() + delta);
		if(getLayoutY() > maxY - Vyska_snimku) {setLayoutY(maxY - Vyska_snimku);}
		smer = 1;	vykresli();
	}
	
	public void dolava(double delta, double maxX) {
		setLayoutX(getLayoutX() - delta);
		if(getLayoutX() < 0) {setLayoutX(0);}
		smer = 2;	vykresli();
	}
	
	public void doprava(double delta, double maxX) {
		setLayoutX(getLayoutX() + delta);
		if(getLayoutX() > maxX - Sirka_snimku) {setLayoutX(maxX - Sirka_snimku);}
		smer = 3;	vykresli();
	}
	
	public boolean kolizia_snimkov(Sprites_snimky iny_snimok) {
		double d1 = getLayoutX() - iny_snimok.getLayoutX();
		double d2 = getLayoutY() - iny_snimok.getLayoutY();
		if((Math.abs(d1)<getWidth()) && Math.abs(d2)< getHeight()) {
			return true;
		}
		else {return false;}		
	}
	
	public void Dalsi_Snimok() {
		if (smer == 0) Aktualny_Snimok =     (Aktualny_Snimok + 1) % 2;
		if (smer == 1) Aktualny_Snimok = 2 + (Aktualny_Snimok + 1) % 2;
		if (smer == 2) Aktualny_Snimok = 4 + (Aktualny_Snimok + 1) % 2;
		if (smer == 3) Aktualny_Snimok = 6 + (Aktualny_Snimok + 1) % 2;
	}
	
	private void vykresli() {
		Dalsi_Snimok();
		setImage(snimky[Aktualny_Snimok]);
	}
	

}
