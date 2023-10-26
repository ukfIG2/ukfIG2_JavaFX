package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Game extends Group {
	
	int health = 3;
	int score = 0;
	public ArrayList<Projectil> projectilles = new ArrayList<>();
	
    final int SPRITESIZE = 30;     // veľkosť obrázka
    final int HEROSPEED = 80;      // rýchlosť hráča
    final int ENEMYSPEED = 100;      // rýchlosť nepriateľa
    private ImageView background;  // obrázok pozadia
    private ArrayList<MySprite> enemies;
    private MySprite hero;
    private String input = ""; // stlaceny klaves
    private double width, height;
    
    int timeSinceLastEnemyDirChange = 0;
    int timeSinceProjectileHit = 0;
    int timeToChange = 5;
    int immortalTime = 3;
    
    public boolean immortal = false;
    
    public Game(int w, int h, String pozadie, int enem) {
        width = w;
        height = h;
        // nech je roztiahnuty, aby sme nezdrziavali pri vykreslovani
        Image bg = new Image(pozadie, w, h, false, false);
        // obrazok umiestnime na ImageView, ktory bude pod ostatnymi
        background = new ImageView(bg);
        // kedze ho pridame ako prvy bude sa aj vykreslovat prvy
        getChildren().add(background);
        // na stlacenie klavesu zareagujeme jeho zapamatanim
        // budeme ho vyhodnocovat az v update
        setOnKeyPressed(evt -> input = evt.getCode().toString());
        
        enemies = new ArrayList<>(); // vytvorenie prazdneho zoznamu
        for (int i = 0; i < enem; i++) {
            MySprite ms = new MySprite("monster",   // nazov suboru
                    8,           // pocet obrazkov
                    Math.random() * w, // poloha x
                    Math.random() * h, // poloha y
                    SPRITESIZE,       // sirka
                    SPRITESIZE,		// vyska
                    this);       //root
            enemies.add(ms);     // pridanie do zoznamu
            getChildren().add(ms); // pridanie na scenu
        }
        hero = new MySprite("ship", 8, Math.random() * w,
                Math.random() * h, SPRITESIZE, SPRITESIZE, this);
        getChildren().add(hero); // pridanie hraca na scenu

        // urobime focusovatelny cely group
        setFocusTraversable(true);
        setFocused(true);
    }

    public void update(double deltaTime) {
    	timeSinceLastEnemyDirChange++;
        // spracuj vstupy a zareaguj podla nich
        switch (input) { // bol naplnený pri stlačení klávesu
            case "LEFT":
                hero.dolava(deltaTime / 1000000000 * HEROSPEED, width);
                break;
            case "UP":
                hero.hore(deltaTime / 1000000000 * HEROSPEED, height);
                break;
            case "RIGHT":
                hero.doprava(deltaTime / 1000000000 * HEROSPEED, width);
                break;
            case "DOWN":
                hero.dole(deltaTime / 1000000000 * HEROSPEED, height);
                break;
        }

        // ak klaves precitame a zareagujeme nan,
        // tak ho uz viac spracovat nechceme
        input = "";

        if (timeSinceLastEnemyDirChange > timeToChange)
        {
	        // zmena polohy Enemies – pohnem všetkými naraz
	        for (int i = 0; i < enemies.size(); i++) {
	            MySprite enemy = enemies.get(i); // vezmem i-teho
	            if (Math.random() > 0.5) // ak viac ako 0.5, pohyb po X else Y
	            {
	            	if (Math.random() > 0.5) // podla nah cisla pohnem doprava alebo dolava
	                {
	                    enemy.doprava(deltaTime / 1000000000 * ENEMYSPEED, width);
	                } else {
	                    enemy.dolava(deltaTime / 1000000000 * ENEMYSPEED, width);
	                }
	            }
	            else {
		            if (Math.random() > 0.5) { // podla nah cisla pohnem hore alebo dole
		                enemy.hore(deltaTime / 1000000000 * ENEMYSPEED, height);
		            } else {
		                enemy.dole(deltaTime / 1000000000 * ENEMYSPEED, height);
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
        if (hero.intersectWithProjectile(projectilles))
        {
    		immortal = true;
    		health--; 
    		HelloApplication.healthText.setText("Health: " + health + "/3");
    		if (health <= 0)
        	{
        		health = 3;
        		score = 0;
        		HelloApplication.healthText.setText("Health: " + health + "/3");
        		HelloApplication.scoreText.setText("Score: " + score);
        		System.out.print("Restart Level");
        	}
        }
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (hero.intersectsSprite(enemies.get(i))) { // ak kolízia
                enemies.get(i).StopTimeline();
                getChildren().remove(enemies.get(i)); // vymaž zo scény
                enemies.remove(enemies.get(i)); // aj zo zoznamu
                score += 10;
                HelloApplication.scoreText.setText("Score: " + score);
            }
        }
    }

}
