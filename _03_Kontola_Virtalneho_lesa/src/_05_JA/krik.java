package _05_JA;

import javafx.scene.paint.Color;


public class krik extends rastlina {
	
	public krik(int x, int y) {
		super(x, y);
		
	}
	
	protected void vykresli(){
		switch(velkost){
		case 0:
		gc.setStroke(Color.BROWN);
		gc.strokeLine(0,20,50,30);
		gc.strokeLine(50,20,50,30);
		gc.strokeLine(100,20,50,30);
		break;
		case 1:
			gc.setStroke(Color.BROWN);
		gc.strokeLine(0,20,50,30);
		gc.strokeLine(50,20,50,30);
		gc.strokeLine(100,20,50,30);
		gc.strokeLine(50,25,100,15);
		gc.strokeLine(0,15,50,25);
		break;
		case 2:
			gc.setStroke(Color.BROWN);
			gc.strokeLine(0,20,50,30);
			gc.strokeLine(50,20,50,30);
			gc.strokeLine(100,20,50,30);
			gc.strokeLine(50,25,100,15);
			gc.strokeLine(0,15,50,25);
			gc.strokeLine(50,20,100,10);
			gc.strokeLine(0,10,50,20);
			gc.strokeLine(50,15,50,20);
			break;
		case 3:
			gc.setStroke(Color.BROWN);
			gc.strokeLine(0,20,50,30);
			gc.strokeLine(50,20,50,30);
			gc.strokeLine(100,20,50,30);
			gc.strokeLine(50,25,100,15);
			gc.strokeLine(0,15,50,25);
			gc.strokeLine(50,20,100,10);
			gc.strokeLine(0,10,50,20);
			gc.strokeLine(50,15,50,20);
			gc.strokeLine(50,15,100,5);
			gc.strokeLine(0,5,50,15);
			gc.strokeLine(50,10,50,15);
			
			break;
		case 4:
			gc.setStroke(Color.BROWN);
			gc.strokeLine(0,20,50,30);
			gc.strokeLine(50,20,50,30);
			gc.strokeLine(100,20,50,30);
			gc.strokeLine(50,25,100,15);
			gc.strokeLine(0,15,50,25);
			gc.strokeLine(50,20,100,10);
			gc.strokeLine(0,10,50,20);
			gc.strokeLine(50,15,50,20);
			gc.strokeLine(50,15,100,5);
			gc.strokeLine(0,5,50,15);
			gc.strokeLine(50,10,50,15);
			gc.strokeLine(50,10,100,0);
			gc.strokeLine(0,0,50,10);
			gc.strokeLine(50,5,50,10);
			break;
		}

	}

}
