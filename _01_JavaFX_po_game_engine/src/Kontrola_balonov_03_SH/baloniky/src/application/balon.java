package Kontrola_balonov_03_SH.baloniky.src.application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class balon extends Canvas{
	protected GraphicsContext gc;
	Timeline casovac;
	protected int obrazok = 0;
	public int rychlost = 2;
	protected Group root;
	
	public balon(Group rt) {
		super(60, 40);		//Toto je velkost objektu balon.
		root = rt;
		this.setLayoutX(50);	//setLayoutX() sa nastavuje, kde sa bude v scene o velkosti x=360 nastavovat poloha objektu balon, pozicia x=0
		this.setLayoutY(300);   //setLayoutY() sa nastavuje, kde sa bude v scene o velkosti Y=420 nastavovat poloha objektu balon, pozicia y=0
		gc = getGraphicsContext2D();
		vykresli();
		casovac = new Timeline(
				new KeyFrame(
						Duration.millis(250), e -> spracuj()  ) );
		casovac.setCycleCount(Animation.INDEFINITE);
		setOnMousePressed(evt -> pop(evt));
		
	}
	
	public void pop(MouseEvent evt) {
		if (getLayoutX()<10) {
            setLayoutX(300);
            System.out.println("Na zaciatku");		//DEBUG
		}
	}
	
	public void startuj() {
		casovac.play();
		System.out.println("Nastartovane");	//DEBUG
	}
	//Original
	/*protected void vykresli() {
		gc.clearRect(0, 0, getWidth(), getHeight() );
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.fillOval(50, 50, 50, 50);
		gc.strokeLine(75, 75, 75, 150);
		System.out.println("Vykreslene"); //DEBUG
	}*/
	//Fungujje to
	protected void vykresli() {
		//gc.clearRect(0, 0, getWidth(), getHeight() ); //Toto netreba lebo to budeme mazat cez remove.
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.fillOval(0, 0, 30, 30);		//polohaX, polohaY,DlzkaX,DlzkaY
		gc.strokeLine(15, 30, 30, 45);	//Prva_polohaX
		System.out.println("Vykreslene");	//DEBUG
	}
	
	protected void spracuj() {
		//obrazok = (obrazok + 1) % 2;    //animaciu teraz nerobis.  //Ani to nikde nepouzivas.
		posun();
		//vykresli();			//Netreba
			System.out.println("Spracovane");	//DEBUG
	}
	//Original
	/*protected void posun() {
		if (getLayoutY()<5){setLayoutY(360);}	//posun skoro dobre, ale uloha bola aby pri narazeni na vrch sa objekt odstranil.
		else setLayoutY(getLayoutY()-rychlost);	//dobre, ale zapamataj si, ze hybes s obektom po scene.
	}*/
	//Funguje to
	protected void posun() {
		setLayoutY(getLayoutY()-rychlost);
		if(getLayoutY()<-50) root.getChildren().remove(this);	//ak sa dostane hore vymaze sa

	}
}
