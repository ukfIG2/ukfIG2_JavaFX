package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Rastlina extends Canvas {
	protected Color farba;
	protected GraphicsContext gc;
	protected int vek;
	protected Timeline casovac;
	
	public Rastlina(int vek, Color farba) {
		super(200,200);
		this.vek = vek;
		this.farba = farba;
		this.gc = getGraphicsContext2D();
		setLayoutX(generujPolohu());
		setLayoutY(generujPolohu()+50);
		
		this.casovac = new Timeline(new KeyFrame(Duration.seconds(1),e -> zvysVek()));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
	}
	
	public void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight());
	}
	
	public int generujPolohu() {
		Random random = new Random();
	    int cislo = random.nextInt(450);
		return cislo;
	}
	
    public void zvysVek() {
        vek++;
        if (vek > 5) {
            vek = 1;
        }
        vykresli();
    }
	
}
	