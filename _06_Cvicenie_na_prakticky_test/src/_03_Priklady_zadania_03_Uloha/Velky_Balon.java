package _03_Priklady_zadania_03_Uloha;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Velky_Balon extends Balon {
	
	public Velky_Balon(Group group, double polohaX, double polohaY, int rychlost, Color color, int sirka, int vyska, int smer) {
		super(group, polohaX, polohaY, rychlost, color, sirka, vyska, smer);
		//System.out.println("Velky Baalon");
	}
}
