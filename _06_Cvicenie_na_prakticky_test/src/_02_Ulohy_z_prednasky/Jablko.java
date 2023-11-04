package _02_Ulohy_z_prednasky;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Jablko extends Canvas{
	private GraphicsContext gc;
	private Color color;
	private double polohaX;
	private double polohaY;
	Timeline timeline;
	Group group;
	
	public Jablko(Group group, double polohaX, double polohaY) {
		super(100, 100);
		gc = getGraphicsContext2D();
		this.polohaX=polohaX; setLayoutX(polohaX);
		this.polohaY=polohaY; setLayoutY(polohaY);
		this.color=Color.RED;
		Vykresli();
		timeline = new Timeline(new KeyFrame(Duration.seconds(1), e-> zmen_farbu()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
        setFocusTraversable(false); //focus default;
        setOnMouseClicked(e->requestFocus());
        setOnKeyPressed(e->spracujKlaves(e));
        this.group=group; 
	}
	
	private void zmen_farbu() {
		gc.clearRect(0, 0, 100, 100);
		if(color==Color.RED) {color=Color.ORANGE;}
		else if(color==Color.ORANGE) {color=Color.RED;}
		Vykresli();
	}
	
	private void Vykresli() {
		gc.setStroke(Color.BLACK);
		//gc.strokeRect(0, 0, 100, 100);
		gc.setFill(color);
		gc.fillOval(0, 20, 100, 80);
		gc.setLineWidth(5);
		gc.strokeLine(50, 20, 50, 0);
	}
	
    private void spracujKlaves(KeyEvent evt) {
        KeyCode code = evt.getCode();
        if (code == KeyCode.SPACE) {
        	Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(0.25), e ->
        	posun()));
            timeline2.setCycleCount(Animation.INDEFINITE);
            timeline2.play();
        }
    }
    
    private void posun() {
    	setLayoutY(getLayoutY()+30);
    	if(getLayoutY()>250) {group.getChildren().remove(this);}
    }
    
        
}
