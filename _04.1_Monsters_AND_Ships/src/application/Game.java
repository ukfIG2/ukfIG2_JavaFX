package application;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game extends Group{
	
	private int Zivot = 5;
	private int Skore = 0;
	public ArrayList<Gula> guly = new ArrayList<Gula>();
	
	private final int Velkost_snimku = 30;
	private final int Rychlost_hraca = 100;
	private final int Rychlost_AI = 50;
	private ImageView Pozadie;
	private ArrayList<Sprites_snimky> AI;
	private Sprites_snimky Hrac;
	private String input = "";
	private double sirka_hry, vyska_hry;
	
	public Game(double sirka_hry, double vyska_hry, String pozadie, int pocet_AI) {
		this.sirka_hry = sirka_hry;
		this.vyska_hry = vyska_hry;
		//Roztiahnut obrazok na cele
		Image bg = new Image(pozadie, sirka_hry, vyska_hry, false, false);
		Pozadie = new ImageView(bg);
		getChildren().add(Pozadie);
        // na stlacenie klavesu zareagujeme jeho zapamatanim
        // budeme ho vyhodnocovat az v update
		setOnKeyPressed(evt -> input = evt.getCode().toString());
		
		AI = new ArrayList<Sprites_snimky>();
		for(int i=0; i<pocet_AI; i++) {
			Sprites_snimky Ss = new Sprites_snimky("monster", 8, Math.random() * sirka_hry,
					Math.random() * vyska_hry, Velkost_snimku, Velkost_snimku, this); 
			AI.add(Ss);
			getChildren().add(Ss);
		}
		Hrac = new Sprites_snimky("ship", 8, Math.random() * sirka_hry, Math.random() * vyska_hry, 
				Velkost_snimku, Velkost_snimku, this);
		getChildren().add(Hrac);
		
		// urobime focusovatelny cely group
		setFocusTraversable(true);
		setFocused(true);
		
	}
	
	public void update(double deltaTime) {
		// spracuj vstupy a zareaguj podla nich
		switch(input) {
		case "LEFT":
			Hrac.dolava(deltaTime / 1000000000 * Rychlost_hraca, sirka_hry);
			break;
		case "UP":
			Hrac.hore(deltaTime / 1000000000 * Rychlost_hraca, vyska_hry);
			break;
		case "RIGHT":
			Hrac.doprava(deltaTime / 1000000000 * Rychlost_hraca, sirka_hry);
			break;
		case "DOWN":
			Hrac.dole(deltaTime / 1000000000 * Rychlost_hraca, vyska_hry);
			break;
		}
	
    	// ak klaves precitame a zareagujeme nan,
    	// tak ho uz viac spracovat nechceme
    	input = "";
		
    	// zmena polohy Enemies – pohnem všetkými naraz
    	for(int i=0; i<AI.size(); i++) {
    		Sprites_snimky ai = AI.get(i);
    		if(Math.random() > 0.5) {	
    			ai.doprava(deltaTime / 1000000000 *Rychlost_AI, sirka_hry);
    		}
    		else {ai.dolava(deltaTime / 1000000000 *Rychlost_AI, sirka_hry);}
    		if(Math.random() > 0.5) {
    			ai.hore(deltaTime / 1000000000 *Rychlost_AI, vyska_hry);
    			}
    		else {ai.dole(deltaTime / 1000000000 *Rychlost_AI, vyska_hry);}
    	}
    	// identifikuj kolizie a zareaguj podla nich
    	for(int i=AI.size() - 1; i>=0; i--) {
    		if(Hrac.kolizia_snimkov(AI.get(i))) { 
    			AI.get(i).StopTimeline();//ak kolízia
    			getChildren().remove(AI.get(i));	// vymaž zo scény
    			AI.remove(AI.get(i));			// aj zo zoznamu
    		}
    	}
    	if(AI.size()==0) {System.exit(0);}
    	System.out.println(AI.size());
        //System.out.println(1+(Math.random()*5));
        //System.out.println(AI.)
		
	if (Hrac.intersectWithProjectile(guly)){
		Zivot--; 
		Aplikacia_MaS_TATO.zivot.setText("Health: " + Zivot + "/5");
		if (Zivot <= 0){
    		System.out.print("Si skoncil.");
    		System.exit(0);
    	}
	}
}
}




