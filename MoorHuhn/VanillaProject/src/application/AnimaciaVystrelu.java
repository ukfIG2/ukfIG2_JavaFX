package application;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AnimaciaVystrelu extends ImageView{
	private Image vystrel;
//	private Timeline t;
	private boolean stav = false;
	private boolean mozemZobrazitImage = true;
	private PauseTransition pause;
	public AnimaciaVystrelu(int w , int h, String nazov) {
		super();
		this.vystrel =new Image(nazov+".png",35,35,false,false);
//		setLayoutX(235);
//		setLayoutY(430);
		setLayoutX(w);
		setLayoutY(h);
		pause = new PauseTransition(Duration.millis(150));
	}
	
	public void zmena() {
		pause.setOnFinished(e -> this.toggleStav());
		pause.play();
        
       
	}
	
	public void vykresli() {
		if(stav) {
			this.setImage(vystrel);
			pause.setOnFinished(e -> this.toggleStav());
			pause.play();
			
		} else {
			this.setImage(null);
		}
	}
	
	public void toggleStav() {
		
		if (this.getZobrazitImage()) {
		this.stav = !this.stav;
		
		vykresli();
		}
		
	}
	public void nastavSuradnice(double pozX, double pozY) {
		
		
			this.setLayoutX(pozX-18);
			this.setLayoutY(pozY-18);
			
			
			vykresli();
			
	}
	
	public void setZobrazitImage(boolean stav) {
		this.mozemZobrazitImage = stav;
	}
	public boolean getZobrazitImage() {
		return this.mozemZobrazitImage;
	}
	
	

}
