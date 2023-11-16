package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spriites_snimky extends ImageView{
	private Game game;
	//private Image[] snimky;
	private ImageView[] snimky;
	private int smer; //0-doprava | 1-dolava
	private int AKTsnimok;
	private double Sirka_snimku, Vyska_snimku;
	private int stav;//0-leti | 1-strelena | 2-pada
	private double maxY = Main.Vyska_obrazovky;
	private double maxX;
	public boolean prec=false;
	public double rychlost_sliepky;
	
		public Spriites_snimky(Game game, String nazov, int Pocet_snimkov, double poloha_X,
				double poloha_Y, double Sirka_snimku, double Vyska_snimku, int smer, double rychlost_sliepky) {
			this.game=game; this.smer=smer;  stav=0;
			this.Sirka_snimku=Sirka_snimku; this.Vyska_snimku=Vyska_snimku;
			maxX=game.Sirka_hry; this.rychlost_sliepky=rychlost_sliepky;
			snimky = new ImageView[Pocet_snimkov];
			//Vytvori zoznam
			//Naplnim zoznam
			for(int i=1; i<=Pocet_snimkov; i++) {
				String fy;
				if(i<10) {fy="0";}
				else {fy="";}
				String meno = nazov+fy+i+"-removebg-preview.png";
				//System.out.println(meno);
				Image snimok = new Image(meno);	
				System.out.println(meno);
				ImageView images = new ImageView(snimok);
				snimky[i-1] = images;
			}

			//setImage(snimky[0]);				//Nastavit fotku
			setImage(snimky[0].getImage());
			setX(poloha_X); setY(poloha_Y);		//Nastavit polohu
		}
		
		public void Dalsi_snimok(int stav) {
			if(stav==0) {AKTsnimok = (AKTsnimok+1) % 12;}
			else if(stav==1) {AKTsnimok = 12 + (AKTsnimok+1) % 8;}
			else if(stav==3) {AKTsnimok = 21;}
			//System.out.println("Stav = "+stav+" | AKTsnimok = "+AKTsnimok);
		}
		
		private void Vykresli() {
			Dalsi_snimok(stav); //kde zacina stav?
		    setImage(snimky[AKTsnimok].getImage());

		    // Check if smer is 1 (dolava) and apply horizontal flip
		    if (smer == 1) {
		        setScaleX(-1);
		    } else {
		        setScaleX(1); // Reset to the original scale if smer is not 1
		    }
		}
		
		public void pohyb(double delta) {
			if(smer==1) {//doprava
				setLayoutX(getLayoutX() + delta);
				if(getLayoutX() > game.Sirka_hry) {prec=true;}
				Vykresli();
				//System.out.println("Doprava "+getLayoutX()+" game "+ game.Sirka_hry+" s "+prec);
			}
			
			else if(smer==0) {//dolava
				setLayoutX(getLayoutX() - delta);
				if(getLayoutX() < (-game.Sirka_hry-Sirka_snimku)) {prec=true;}
				Vykresli();
				//System.out.println("Dolava "+getLayoutX()+" game "+ (-game.Sirka_hry-Sirka_snimku)+" s "+prec);
			}
			
			
		}
		
		/*public void hore(double delta , double maxY) {
			setLayoutY(getLayoutY() - delta);
			if(getLayoutY() < 0) {game.getChildren().remove(this);}
		}
		
		public void dole(double delta , double maxY) {
			setLayoutY(getLayoutY() + delta);
			if(getLayoutY()>Main.Vyska_obrazovky) {game.getChildren().remove(this);}
		}
		
		public void doprava(double delta , double maxY, int smer) {
			setLayoutX(getLayoutX() + delta);
			if(getLayoutX() > game.Sirka_hry) {game.getChildren().remove(this);}
		}
		
		public void dolava(double delta , double maxY) {
			setLayoutX(getLayoutX() - delta);
			if(getLayoutX() < 0-Sirka_snimku) {game.getChildren().remove(this);}
		}*/
}
