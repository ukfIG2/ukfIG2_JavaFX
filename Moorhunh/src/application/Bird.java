package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bird extends ImageView {
	
	private Image[] sprites;
	private Image[] killed;
	double screenWidth, screenHeight, speed, range;
	int direction;
	int actImage = 0;
	int state = 0;
	int value = 10;
	boolean hasAmmo;
	
	public Bird(String spriteName, int spriteCount, double screenWidth, double screenHeight,
			double w, double h) {
		super();
		this.screenWidth = screenWidth; this.screenHeight = screenHeight; 
		sprites = new Image[spriteCount];
		killed = new Image[2];
		
		range = (int) (Math.random() * (4 - 1) + 1);
		
		do {
			speed = (int)(-5 + Math.random() * 11) * 30;
		} while (speed == 0);
		
		if (speed < 0) {
			setLayoutX(screenWidth);
			direction = 1;
		}
		else {
			setLayoutX(1);
			direction = 0;
		}
		setLayoutY(100 + (int) (Math.random() * screenHeight));
		 
		if (direction == 0) {
			for(int i = 0; i < spriteCount; i++) { 
				sprites[i] = new Image(spriteName + (i + 1) + ".png", w/range, h/range, false, false);
			}
			
			for(int i = 0; i < 2; i++) { 
				killed[i] = new Image("killed" + (i + 1) + ".png", w/range, h/range, false, false);
			}
		}else {
			for(int i = 0; i < spriteCount; i++) { 
				sprites[i] = new Image(spriteName + (i + 1) + "_r.png", w/range, h/range, false, false);
			}
			
			for(int i = 0; i < 2; i++) { 
				killed[i] = new Image("killed" + (i + 1) + "_r.png", w/range, h/range, false, false);
			}
		}
		
		
		setImage(sprites[0]); 
		
		value = value * (int) range;
		
		setOnMousePressed(evt -> onClick());
	}
	
	public void canBeShot(boolean hasAmmo) {
		this.hasAmmo = hasAmmo;
	}
	
	public int giveValue() {
		int x = value;
		value = 0;
		return x;
	}

	private void onClick() {
		if (hasAmmo) state = 1;
	}
	
	public void change(double deltaTime) {
		if (state == 0) {
		   setLayoutX(getLayoutX() + speed * deltaTime);
		   setLayoutY(getLayoutY() - 5 + (int)(Math.random() * 11));
		   if ((getLayoutX() < 0) || (getLayoutX() > screenWidth)) state = 2;
		} else if (state == 1) {
			setLayoutX(getLayoutX() + speed * deltaTime);
			if (speed > 0) setLayoutY(getLayoutY() + (speed*3) * deltaTime);
			else setLayoutY(getLayoutY() - (speed*3) * deltaTime);
			if (getLayoutY() > screenHeight) state = 2;
		}
		vykresli();
	}

	private void nextImage(){
	    actImage += 1;
	    if (state == 0) actImage = actImage % 8;
	    if (state == 1) actImage = actImage % 2;
	}

	private void vykresli() {
	  nextImage();
	  if (state == 0) setImage(sprites[actImage]);  
	  if (state == 1) setImage(killed[actImage]);
	  if (state == 2) setImage(null);
	}

	public double getStav() {
        return state;
	}

}
