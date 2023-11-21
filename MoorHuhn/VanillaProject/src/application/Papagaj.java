package application;

public class Papagaj extends Zviera{

	public Papagaj(String nazovSpritu, int pocetSpritov, double w, double h, double maxw, double maxh,
			double rychlost) {
		
		super(nazovSpritu, pocetSpritov, w, h, maxw, maxh, rychlost);
		// TODO Auto-generated constructor stub
		if(this.rychlost < 0) {
			this.rychlost -= 30;
		} else if(this.rychlost > 0) {
			this.rychlost += 30;
		}
		
	}

	
	
	@Override
	public void nextImage() {
		
		// TODO Auto-generated method stub
		this.actImage++;
		this.actImage %= 9;
	}
	
	@Override
	protected void vykresli() {
		// TODO Auto-generated method stub
		if (stav == 0) {
			if(this.rychlost>0) {
				setImage(sprites[actImage]);

			}else {
				setImage(sprites[actImage+9]);

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
	
	
}
