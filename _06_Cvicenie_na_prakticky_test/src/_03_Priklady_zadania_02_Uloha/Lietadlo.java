package _03_Priklady_zadania_02_Uloha;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Lietadlo extends Canvas{ //600 300
	private GraphicsContext gc;
	private double polohaX;
	private double polohaY;
	private Timeline timeline;
	private int rychlost;
	private int smer;
	private double _1[]= {80,80,100};
	private double _2[]= {0,50,25};
	private double _3[]= {0,20,20};
	private double _4[]= {25,0,50};
	private Group root;
	
	public Lietadlo(Group root, double polohaX, double polohaY, int rychlost) {
		super(100,50);
		gc = getGraphicsContext2D();
		this.root=root;
		this.polohaX=polohaX; setLayoutX(polohaX);
		this.polohaY=polohaY; setLayoutY(polohaY);
		this.rychlost=rychlost;
		smer=1;
		Vykres();
		setFocusTraversable(true); //focus default;
        //setOnMouseClicked(e->requestFocus());
        setOnKeyPressed(e->spracujKlaves(e));

	}
	
	private void Vykres(){
		//gc.clearRect(0, 0, 100, 50);
		if(smer==0) {
			gc.clearRect(0, 0, 100, 50);
			gc.setFill(Color.YELLOW);
			gc.fillOval(0, 0, 80, 50);
			gc.setFill(Color.BLACK);
			gc.fillPolygon(_1, _2, 3);
			}
		if(smer==1) {
			gc.clearRect(0, 0, 100, 50);
			gc.setFill(Color.YELLOW);
			gc.fillOval(20, 0, 80, 50);
			gc.setFill(Color.BLACK);
			gc.fillPolygon(_3, _4, 3);
		}
	}
		
	private void posun(int smer) {
		if(smer==0) {
			setLayoutX(getLayoutX() + rychlost);
			if(getLayoutX()>500) {setLayoutX(0); }
			}
		if(smer==1) {
			setLayoutX(getLayoutX() - rychlost);
			if(getLayoutX()<0) {setLayoutX(500);}
			}
	}
	
	private void spracujKlaves(KeyEvent evt) {
		KeyCode keycode = evt.getCode();
		if(keycode==keycode.LEFT) {smer=1;	posun(1);	Vykres();}
		else if(keycode==keycode.RIGHT) {smer=0;	posun(0);	Vykres();}
		else if(keycode==keycode.SPACE) {Raketa raketa = new Raketa(root, getLayoutX(), getLayoutY(), 10);
		root.getChildren().add(raketa);}
	}
	
	}
	

