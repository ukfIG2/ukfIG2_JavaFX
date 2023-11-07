package application;


import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Auto extends Canvas{
	GraphicsContext gc;
	Group group;
	int smer;// 0doprava // 1 dolava
	int rychlost;
	
	public Auto(Group group, double polohaX, double polohaY) {
		super(100, 100);
		this.group=group; gc = getGraphicsContext2D();
		setLayoutX(polohaX); setLayoutY(polohaY);
		smer=1; rychlost=10;
		Vykresli();
		setFocusTraversable(true);

        setOnKeyPressed(e->spracujKlaves(e));
	}
	
	private void Vykresli() {
		gc.clearRect(0, 0, 100, 100);
		if (smer==0) {
		gc.setFill(Color.BLUE);
		gc.fillRect(10, 0, 90, 80);
		gc.setFill(Color.BLACK);
		gc.fillOval(10, 80, 20, 20);
		gc.fillOval(70, 80, 20, 20);
		gc.fillOval(0, 70, 10, 10);
		}
		else if(smer==1) {
			gc.setFill(Color.BLUE);
			gc.fillRect(0, 0, 80, 80);
			gc.setFill(Color.BLACK);
			gc.fillOval(0, 80, 20, 20);
			gc.fillOval(60, 80, 20, 20);
			gc.fillOval(100, 60, 10, 10);
			
		}
	}
		public void posun(int smer) {
			if(smer==0) {
				setLayoutX(getLayoutX()+rychlost);
				if(getLayoutX()>400) {setLayoutX(0);}
			}
			if(smer==1) {
				setLayoutX(getLayoutX()-rychlost);
				if(getLayoutX()<0) {setLayoutX(400);}
			}
		}
	
		private void spracujKlaves(KeyEvent evt) {
			KeyCode keycode = evt.getCode();
			if(keycode==keycode.LEFT) {smer=1;	posun(1);	Vykresli();}
			else if(keycode==keycode.RIGHT) {smer=0;	posun(0);	Vykresli();}
		
		}
	
}
