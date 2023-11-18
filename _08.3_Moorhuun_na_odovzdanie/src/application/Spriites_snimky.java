package application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
	//Optimalizacia. Caching snimok.
	//private static Map<String, Image> imageCache = new HashMap<>();
	private static Map<String, Image> imageCache = new LinkedHashMap<>();
	private boolean zastralena=false;
	private boolean hit = false;
	
	
		public Spriites_snimky(Game game, String nazov, int Pocet_snimkov, double poloha_X,
				double poloha_Y, double Sirka_snimku, double Vyska_snimku, int smer, double rychlost_sliepky) {
			this.game=game; this.smer=smer;  stav=0;
			this.Sirka_snimku=Sirka_snimku; this.Vyska_snimku=Vyska_snimku;
			maxX=game.Sirka_hry; this.rychlost_sliepky=rychlost_sliepky;
			snimky = new ImageView[Pocet_snimkov];
			AKTsnimok=0;
			//Naplnim zoznam
			for(int i=1; i<=Pocet_snimkov; i++) {
				//Ten Isty zapis
				/*
				String fy;
				if(i<10) {fy="0";}
				else {fy="";}
				*/
				String fy = (i < 10) ? "0" : "";
				String meno = nazov+fy+i+"-removebg-preview.png";
				////////Image snimok = new Image(meno);  //Original
				Image snimok = imageCache.computeIfAbsent(meno, Image::new); //Vyrazna optimalizacia. Prestalo sekat pri nacitani noych sliepok.
				ImageView images = new ImageView(snimok);
				snimky[i-1] = images;
			}
			setImage(snimky[0].getImage());		//Nastavit fotku
			setX(poloha_X); setY(poloha_Y);		//Nastavit polohu
		}


		public void Dalsi_snimok() {
		    if (zastralena) {
		        if (stav == 1) {
		            AKTsnimok = 13 + (AKTsnimok + 1) % 8;
		            if (AKTsnimok == 20) {
		                stav = 2; // Transition to state 3 after reaching the last image in state 2
		            }
		        } else if (stav == 2) {
		            // Stay on the last image in state 3
		            AKTsnimok = 20;
		            // You can add more logic here if needed
		        }
		    } else {
		        if (stav == 0) {
		            AKTsnimok = (AKTsnimok + 1) % 13;
		        }
		    }
		}
		
		private void Vykresli() {
			Dalsi_snimok(); 
		    setImage(snimky[AKTsnimok].getImage());
		    // Check if smer is 1 (dolava) and apply horizontal flip
		    if (smer == 1) {
		        setScaleX(-1);
		    } else {
		        setScaleX(1); // Reset to the original scale if smer is not 1
		    }
		}
		
		public void pohyb(double delta) {
			if(stav==0) {
			double hore_dole = Math.random();
			if(smer==1) {//doprava
				setLayoutX(getLayoutX() + delta);
				if(getLayoutX() > maxX) {prec=true;}
				Vykresli();
			}
			
			else if(smer==0) {//dolava
				setLayoutX(getLayoutX() - delta);
				if(getLayoutX() < (-maxX-Sirka_snimku)) {prec=true;}
				Vykresli();
			}
			
			if(hore_dole<0.3) {//dole
				setY(getY() + delta);
				if(getY() + Vyska_snimku > maxY) {prec=true;}
			}
			
			else if(hore_dole<0.6 && hore_dole>=0.3) {
				setY(getY() - delta);//hore
				if(getY() < 0 - Vyska_snimku ) {prec=true;}
			}
			
			else {} //Nic teda rovno
		}
			else {setY(getY() + delta);
			if(getY() + Vyska_snimku > maxY) {prec=true;}
			stav=2;	zastralena=true; rychlost_sliepky=500;		Vykresli();}
		}
		
	    public void Zastrelena() {
	        if (!hit) { // Check if the AI has not been hit before
	            hit = true; // Set the flag indicating that the AI has been hit
	            zastralena = true;
	            stav = 1;
                Game.playSound((int) (1 + Math.random() * 3));
                game.Pocet_zasiahnutych_sliepok++;
	            
	        }
	    }
}
