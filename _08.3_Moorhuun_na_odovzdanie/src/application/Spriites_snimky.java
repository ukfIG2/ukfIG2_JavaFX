package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spriites_snimky extends ImageView{
	private Game game;
	private Image[] snimky;
	private int smer; //0-doprava | 1-dolava
	private int AKTsnimok;
	private double Sirka_snimku, Vyska_snimku;
	
		public Spriites_snimky(Game game, String nazov, int Pocet_snimkov, double poloha_X,
				double poloha_Y, double Sirka_snimku, double Vyska_snimku, int smer) {
			this.game=game; this.smer=smer;
			snimky = new Image[Pocet_snimkov];
			for(int i=1; i<=Pocet_snimkov; i++) {
				String fy;
				if(i<10) {fy="0";}
				else {fy="";}
				String meno = nazov+fy+i+"-removebg-preview.png";
				//System.out.println(meno);
				snimky[i-1] = new Image(meno);
			}
			
		
			
			setImage(snimky[0]);
			setX(poloha_X); setY(poloha_Y);
		}
}
