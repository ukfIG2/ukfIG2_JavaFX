package application;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game extends Group {
    final int SPRITESIZE = 70;     // veľkosť obrázka
    final int ENEMYSPEED = 90;      // rýchlosť nepriateľa
    private ImageView background;  // obrázok pozadia
    private ArrayList<MySprite> enemies;
    private double width, height;
    private int score = 0;
    private int ammoLeft = 6;
    private int timeLeft;
    private Text scoreText;
    private Text ammoText;
    private Text time;
    private Timeline spawner;
    private Timeline gameTimer;

    public Game(int w, int h, String pozadie, Text score, Text ammoText, Text time) {
        this.scoreText = score;
        this.ammoText = ammoText;
        this.time = time;
        timeLeft = 60;
        width = w;
        height = h;
        Image bg = new Image(pozadie, w, h, false, false);
        background = new ImageView(bg);
        getChildren().add(background);
        enemies = new ArrayList<>();
        
        spawner = new Timeline( //spawn kacic
                new KeyFrame(Duration.seconds(3), event -> spawn()));
        spawner.setCycleCount(Timeline.INDEFINITE);
        spawner.play();
        time.setText("Time left: " + timeLeft);
        
        gameTimer = new Timeline( //casovac hry
                new KeyFrame(Duration.seconds(1), event -> {
                    timeLeft--;
                    time.setText("Time left: " + timeLeft);
                    if (timeLeft == 0) {
                        endGame();
                    }
                }));
        gameTimer.setCycleCount(60);
        gameTimer.play();

        requestFocus();
        setFocusTraversable(true);
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                shoot();
            }
        });
    }

    
    private void endGame() {
    	gameTimer.stop();
    	System.out.println("Time's up, your score is: "+score);
    	Platform.exit();
    }
    
    void increaseScore(int points) {
        score += points;
        scoreText.setText("Score: " + score);
    }
    
    void shoot() {
    	if (ammoLeft>0) {this.ammoLeft-=1;}
    	ammoText.setText("Ammo: "+ammoLeft);
    }
    
    void reload() {
            ammoLeft = 6;
            ammoText.setText("Ammo: " + ammoLeft);
    }
    

    public int getAmmo() {
    	return ammoLeft;
    }
    
    public void spawn() {
    	double initialY = Math.random()*height;
    	if (initialY > 400) {initialY-=50;}
        double initialX = Math.random() > 0.5 ? 0 : width;
        MySprite ms = new MySprite("duck",  // názov súboru
                8,           // počet obrazkov
                initialX, 
                initialY,
                SPRITESIZE,       
                SPRITESIZE, this);       // výška
        enemies.add(ms);     // pridanie do zoznamu
        getChildren().add(ms); // pridanie na scénu
        if (initialX == 0) {
            initialX = -50;
            ms.setDirection(MySprite.Direction.RIGHT); // doprava
        } else {
            ms.setDirection(MySprite.Direction.LEFT); // dolava
        }
    }

    public void update(double deltaTime) {
        for (MySprite enemy : enemies) {
            if (enemy.getDirection() == MySprite.Direction.LEFT) {
                enemy.dolava(deltaTime / 1000000000 * ENEMYSPEED, width);
            } else if (enemy.getDirection() == MySprite.Direction.RIGHT) {
                enemy.doprava(deltaTime / 1000000000 * ENEMYSPEED, width);
            }
        }
    }
}
