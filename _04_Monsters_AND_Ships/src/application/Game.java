package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game extends Group{
	
	private int zivot = 3;
	private int skore = 0;
	public ArrayList<Projektil> projektil = new ArrayList<Projektil>();

	final int velkost_obrazka = 30;
	final int rychlost_hraca = 80;
	final int rychlost_AI = 50;
	private ImageView pozadie;
	private ArrayList<Sprites_obrazky> zoznam_AI;
	private Sprites_obrazky Hrac;
	private String input = "";	//stlacenie klavesy
	private double sirka, vyska;
	
	public boolean immortal = false;
    int timeSinceLastEnemyDirChange = 0;
    int timeSinceProjectileHit = 0;
    int timeToChange = 5;
    int immortalTime = 3;
	
	public Game(int sirka, int vyska, String Spozadie, int pocet_AI) {
		this.sirka = sirka; this.vyska = vyska;
		Image obrazok_background = new Image(Spozadie, this.sirka, this.vyska, false, false);
		pozadie = new ImageView(obrazok_background);
		getChildren().add(pozadie);
		setOnKeyPressed(evt -> input = evt.getCode().toString());
		
		zoznam_AI = new ArrayList<Sprites_obrazky>(); //mozzno_vymazat
		for(int i=0; i< pocet_AI; i++) {
			Sprites_obrazky So = new Sprites_obrazky("monster", 8, Math.random() * sirka,
					Math.random() * vyska, velkost_obrazka, velkost_obrazka, this);
			zoznam_AI.add(So);
			getChildren().add(So);
		}
		
		Hrac = new Sprites_obrazky("ship", 8, Math.random() * sirka, Math.random() * vyska, velkost_obrazka, velkost_obrazka, this);
		getChildren().add(Hrac);
		
		setFocusTraversable(true);
		setFocused(true);
	}
	
	public void update(double deltaTime) {
		//spracuj vstupy
		switch(input) {
		case "LEFT":
			Hrac.dolava(deltaTime / 1000000000 * rychlost_hraca, sirka);
			break;
		case "UP":
			Hrac.hore(deltaTime / 1000000000 * rychlost_hraca, vyska);
			break;
		case "RIGHT":
			Hrac.doprava(deltaTime / 1000000000 * rychlost_hraca, sirka);
			break;
		case "DOWN":
			Hrac.dole(deltaTime / 1000000000 * rychlost_hraca, vyska);
			break;
		}
		input = "";
		
		for(int i = 0; i<zoznam_AI.size(); i++) {
			Sprites_obrazky AI = zoznam_AI.get(i);
			if(Math.random() > 0.5) {AI.doprava(deltaTime / 1000000000 * rychlost_AI, sirka);}
			else {AI.dolava(deltaTime / 1000000000 * rychlost_AI, sirka);}
			if(Math.random() > 0.5) {AI.hore(deltaTime / 1000000000 * rychlost_AI, vyska);}
			else {AI.dole(deltaTime / 1000000000 * rychlost_AI, vyska);}
		}
		
		for(int i=0; i < zoznam_AI.size(); i++) {
			if(Hrac.kolizia_obrazkov(zoznam_AI.get(i))) {
				getChildren().remove(zoznam_AI.get(i));
				zoznam_AI.remove(zoznam_AI.get(i));
			}
		}
		
		if (timeSinceLastEnemyDirChange > timeToChange)
        {
	        // zmena polohy Enemies – pohnem všetkými naraz
	        for (int i = 0; i < zoznam_AI.size(); i++) {
	            Sprites_obrazky enemy = zoznam_AI.get(i); // vezmem i-teho
	            if (Math.random() > 0.5) // ak viac ako 0.5, pohyb po X else Y
	            {
	            	if (Math.random() > 0.5) // podla nah cisla pohnem doprava alebo dolava
	                {
	                    enemy.doprava(deltaTime / 1000000000 * rychlost_AI, sirka);
	                } else {
	                    enemy.dolava(deltaTime / 1000000000 * rychlost_AI, sirka);
	                }
	            }
	            else {
		            if (Math.random() > 0.5) { // podla nah cisla pohnem hore alebo dole
		                enemy.hore(deltaTime / 1000000000 * rychlost_AI, vyska);
		            } else {
		                enemy.dole(deltaTime / 1000000000 * rychlost_AI, vyska);
		            }
	            }
	    	}
	        timeSinceLastEnemyDirChange = 0;
        }
        if (immortal)
        {
        	timeSinceProjectileHit++;
        	if (timeSinceProjectileHit > immortalTime) { immortal = false; timeSinceProjectileHit = 0; }
        }
        // identifikuj kolizie a zareaguj podla nich
        if (Hrac.intersectWithProjectile(projektil))
        {
    		immortal = true;
    		zivot--; 
    		Aplikacia_SaM.zivot_text.setText("Health: " + zivot + "/3");
    		if (zivot <= 0)
        	{
        		zivot = 3;
        		skore = 0;
        		Aplikacia_SaM.zivot_text.setText("Health: " + zivot + "/3");
        		Aplikacia_SaM.skore_text.setText("Score: " + skore);
        		System.out.print("Restart Level");
        	}
        }
		
		
	}
	
	
}
