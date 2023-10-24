package Kontrola_balonov_05_MB.Balonky.src.application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;


public class Balon extends Canvas{
    GraphicsContext gc;
    Group root;
    Timeline t;
    boolean clicked = false;
    int timer = 60;
    Text counterText;
    Text live;
    int sirka;
    int vyska;
    static int counter = 0;
    static int score = 0;
    static int lives = 5;
    static boolean end = false;

    public Balon(Group root, int sirka, int vyska, Text counterText, Text live) {
        super(17, 25);
        this.counterText = counterText;
        this.root = root;
        this.sirka = sirka;
        this.vyska = vyska;
        this.live = live;
        setLayoutX(Math.random() * (sirka - 40) + 20);
        setLayoutY(vyska);
        counter++;
        gc = this.getGraphicsContext2D();
        timer = (timer - (int) (counter * 1)) - (int) Math.round(Math.random() * 20);
        if(timer < 1) timer = 1;
        t = new Timeline(new KeyFrame(Duration.millis(timer),e->pohyb()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        this.setOnMousePressed(e->onClick());
        vykresli();
   
    }

    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        int farba = (int) Math.round(Math.random() * 5);
        switch(farba) {
        	case 1: gc.setFill(Color.BLACK);
        	break;
        	case 2: gc.setFill(Color.BLUE);
        	break;
        	case 3: gc.setFill(Color.RED);
        	break;
        	case 4: gc.setFill(Color.YELLOW);
        	break;
        	case 5: gc.setFill(Color.ORANGE);
        	break;
        }
        gc.fillOval(1, 0, 15, 21);
        
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeLine(7.5, 21, 7.5, 25);

    }
    
    public void onClick() {
    	clicked = true; 
    	score++;
    	counterText.setText("score: " + Integer.toString(score));
    }

    public void pohyb() {

    	if(clicked) {
    		t.stop();
            root.getChildren().remove(this);
            gc.clearRect(0,0,getWidth(),getHeight());
    	}else if(getLayoutY()<0) {
            t.stop();
            root.getChildren().remove(this);
            gc.clearRect(0,0,getWidth(),getHeight());
            score -= 3;
            if(score < 0) score = 0;
            lives -= 1;
            live.setText("lives: " + Integer.toString(lives));
            if(lives == 0) {
            		end = true;
            	    root.getChildren().clear();
            	    Text gameOverText = new Text("Game Over! Your score: " + score);
            	    
            	    Button button = new Button("Ukončiť hru");
            	    button.setOnAction(e -> {
            	        System.exit(0);
            	    });

            	    gameOverText.setFill(Color.RED);
            	    gameOverText.setLayoutX(sirka / 2 - 100); 
            	    gameOverText.setLayoutY(vyska / 2); 
            	    root.getChildren().addAll(gameOverText, button); 
            	    
            }
            counterText.setText("score: " + Integer.toString(score));
        } else {
            setLayoutY(getLayoutY()-2);
        }
    }

}
