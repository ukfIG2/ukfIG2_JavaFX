package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game_Moorhun extends Group{
	private ImageView pozadie1, pozadie2;
	private double sirka, vyska;

	public Game_Moorhun(double sirka, double vyska, String pozadie1, String pozadie2) {
		this.sirka=sirka; this.vyska=vyska;
		/*Image obrazok_pozadie1 = new Image(pozadie1);
		this.pozadie1 = new ImageView(obrazok_pozadie1);
		//this.pozadie1.setw
		getChildren().add(this.pozadie1);*/
		
		Image obrazok_pozadie2 = new Image(pozadie2);
		this.pozadie2 = new ImageView(obrazok_pozadie2);
		getChildren().add(this.pozadie2);
		
		
	}
}
