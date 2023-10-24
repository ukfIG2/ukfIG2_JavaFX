package _17_Zoologicka_cvicenie;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Zviera extends Canvas{
	protected GraphicsContext gc;
    protected Color farba; // na kontext budeme kresliť farbou
    private Timeline casovac;
    protected int rychlost;
    
    public Zviera(Group root, int x, int y, int rychlost, Color farba) {
    	super(50,50);
    	this.rychlost = rychlost; this.farba=farba;
    	setLayoutX(x); setLayoutY(y);
    	gc = getGraphicsContext2D();
    	
    	casovac = new Timeline(
                new KeyFrame(Duration.millis(100), e -> posun()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();
    	
    }
    
    public void vykresli() {};
    
    public void posun() {};
    
    }

