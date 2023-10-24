package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Game extends Group {
    final int SPRITESIZE = 30;     // veľkosť obrázka
    final int HEROSPEED = 80;      // rýchlosť hráča
    final int ENEMYSPEED = 5;      // rýchlosť nepriateľa
    private ImageView background;  // obrázok pozadia
    private ArrayList<MySprite> enemies;
    private MySprite hero;
    private String input = ""; // stlaceny klaves
    private double width, height;

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
            MySprite ms = new MySprite("enemy",   // nazov suboru
                    8,           // pocet obrazkov
                    Math.random() * w, // poloha x
                    Math.random() * h, // poloha y
                    SPRITESIZE,       // sirka
                    SPRITESIZE);       // vyska
            enemies.add(ms);     // pridanie do zoznamu
            getChildren().add(ms); // pridanie na scenu
        }
        hero = new MySprite("boy", 8, Math.random() * w,
                Math.random() * h, SPRITESIZE, SPRITESIZE);
        getChildren().add(hero); // pridanie hraca na scenu

        // urobime focusovatelny cely group
        setFocusTraversable(true);
        setFocused(true);
    }

    public void update(double deltaTime) {
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

        // zmena polohy Enemies – pohnem všetkými naraz
        for (int i = 0; i < enemies.size(); i++) {
            MySprite enemy = enemies.get(i); // vezmem i-teho
            if (Math.random() > 0.5) // podla nah cisla pohnem doprava alebo dolava
                enemy.doprava(deltaTime / 1000000000 * ENEMYSPEED, width);
            else
                enemy.dolava(deltaTime / 1000000000 * ENEMYSPEED, width);

            if (Math.random() > 0.5) // podla nah cisla pohnem hore alebo dole
                enemy.hore(deltaTime / 1000000000 * ENEMYSPEED, height);
            else
                enemy.dole(deltaTime / 1000000000 * ENEMYSPEED, height);
        }

        // identifikuj kolizie a zareaguj podla nich
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (hero.intersectsSprite(enemies.get(i))) { // ak kolízia
                getChildren().remove(enemies.get(i)); // vymaž zo scény
                enemies.remove(enemies.get(i)); // aj zo zoznamu
            }
        }

        // skontroluj zivot hraca

        // aktualizuj vypisy
    }

}
