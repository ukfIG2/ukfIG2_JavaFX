package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spriites_snimky extends ImageView{
	private Game game;
	private Image[] snimky;
	private int smer; //0-doprava | 1-dolava
	private int AKTsnimok;
	private double Sirka_snimku, Vyska_snimku;
	private int stav;//0-leti | 1-strelena | 2-pada
	
		public Spriites_snimky(Game game, String nazov, int Pocet_snimkov, double poloha_X,
				double poloha_Y, double Sirka_snimku, double Vyska_snimku, int smer) {
			this.game=game; this.smer=smer;  stav=0;
			this.Sirka_snimku=Sirka_snimku; this.Vyska_snimku=Vyska_snimku;
			//Vytvori zoznam
			snimky = new Image[Pocet_snimkov];	
			//Naplnim zoznam
			for(int i=1; i<=Pocet_snimkov; i++) {
				String fy;
				if(i<10) {fy="0";}
				else {fy="";}
				String meno = nazov+fy+i+"-removebg-preview.png";
				//System.out.println(meno);
				snimky[i-1] = new Image(meno);
			}
			setImage(snimky[0]);				//Nastavit fotku
			setX(poloha_X); setY(poloha_Y);		//Nastavit polohu
		}
		
		public void Dalsi_snimok(int stav) {
			if(stav==0) {AKTsnimok = (AKTsnimok+1) % 12;}
			else if(stav==1) {AKTsnimok = 12 + (AKTsnimok+1) % 8;}
			else if(stav==3) {AKTsnimok = 21;}
			System.out.println("Stav = "+stav+" | AKTsnimok = "+AKTsnimok);
		}
		
		private void Vykresli() {
			Dalsi_snimok(stav); //kde zacina stav?
			setImage(snimky[AKTsnimok]);
		}
		
		public void hore(double delta , double maxY) {
			setLayoutY(getLayoutY() - delta);
			if(getLayoutY() < 0) {game.getChildren().remove(this);}
		}
		
		public void dole(double delta , double maxY) {
			setLayoutY(getLayoutY() + delta);
			if(getLayoutY()>Main.Vyska_obrazovky) {game.getChildren().remove(this);}
		}
		
		public void doprava(double delta , double maxY) {
			setLayoutX(getLayoutX() + delta);
			if(getLayoutX() > game.Sirka_hry) {game.getChildren().remove(this);}
		}
		
		public void dolava(double delta , double maxY) {
			setLayoutX(getLayoutX() - delta);
			if(getLayoutX() < 0-Sirka_snimku) {game.getChildren().remove(this);}
		}
}
