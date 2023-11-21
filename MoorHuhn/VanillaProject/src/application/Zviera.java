package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Zviera extends ImageView{
	
	protected Image[] sprites;
	protected Image killed;
	protected Image vystrel;
	
	protected double x, y, maxWidth, maxHeight, rychlost,w,h;
	protected int actImage = 0;
	protected int stav = 0;
	
	private Timeline t;
	private Random rand;
	private int trafena = 0;
	public Zviera(String nazovSpritu, int pocetSpritov, double w, double h, double maxw, double maxh, double rychlost) {
		super();
		this.maxWidth = maxw;
		this.maxHeight = maxh;
		this.w = w;
		this.h = h;
		this.sprites = new Image[pocetSpritov];
		this.rand = new Random();
		this.rychlost = rychlost;
		for (int i = 0; i < pocetSpritov; i++) {
			
			sprites[i] = new Image(nazovSpritu+i+".png",w,h,false,false);
	
		}
		killed = new Image("dead.png",w,h,false,false);
		
		this.x = rand.nextInt(10) - 5;		
		if (x < 0) {
			this.rychlost *= -1;
			this.setLayoutX(maxWidth);
			
		} else {
			setLayoutX(1);
		}

		this.setLayoutY((rand.nextInt(250)+100));

		
		

		this.t = new Timeline(
				new KeyFrame(Duration.millis(100), e ->nextImage() )
				);
		t.setCycleCount(Animation.INDEFINITE);
		t.play();
	}
	
	public void zmena(double deltaTime) {
		setLayoutX(getLayoutX() + (rychlost/15) );
		if( (getLayoutX() < 0) || (getLayoutX() > maxWidth) || getLayoutY()> maxHeight) {
			this.stav = 2;
			t.stop();
			
		}
		if(this.getStav() == 1) {

			this.setLayoutY(this.getLayoutY() + 15);
		}

		vykresli();
		
	}
	
	public void nextImage() {
		
		this.actImage++;
		this.actImage %= 2;
		
	}
	
	protected void vykresli() {
		if (stav == 0) {
			setImage(sprites[actImage]);
			if(this.actImage == 1) {
				this.setLayoutY(this.getLayoutY() +1);
			} else {
				this.setLayoutY(this.getLayoutY() - 1);
				
			}
		}
		if (stav == 1 ) {
			setImage(killed);
		}
		if (stav == 2) {
			setImage(null);
		}
		if (stav == 3) {
			setImage(killed);
		}
	}
	
	public void zvysRychlost() {
		if(this.rychlost < 0) {
			this.rychlost -= 2;
		} else if(this.rychlost < 0) {
			this.rychlost += 2;
		}
	}
	

	public void onClick(double clickX, double clickY) {
		if (clickX >= this.getLayoutX() && clickX <= this.getLayoutX() + this.w&&
	            clickY >= this.getLayoutY() && clickY <= this.getLayoutY() + this.h) {

			this.stav = 1;
			this.trafena = 1;
		
	        }
	}
	
	public int getTrafena() {
		return this.trafena;
	}
	
	public double getStav() {
		return this.stav;
	}
	
	
}
