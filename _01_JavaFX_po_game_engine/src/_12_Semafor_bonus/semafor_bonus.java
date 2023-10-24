package _12_Semafor_bonus;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class semafor_bonus extends Canvas {
	private int stav;
	GraphicsContext gc;
	//pomocne vypocty pre vysky
	private int vcervena = 50+25/2;
	private int voranzova = vcervena+25+75;
	private int vzelena = voranzova+25+75;
	private double vchcervena = vcervena+25+36.5-18.75;
	private double vchzelena = vchcervena+75+36.5;
	
	public semafor_bonus() {
		super(300,400);
		gc = getGraphicsContext2D();
		stav = 0;
		vykresli();
	}
	
	public void zmenaStavu() {
		stav = (stav + 1) %4;
		vykresli();
	} 
	
	public void vykresli() {
		gc.setFill(Color.GREY);
        gc.fillRect(50, 50, 100, 300);
        gc.fillRect(150, 50, 100, 300);
        gc.setFill(Color.BLACK);
        gc.fillOval(62.5, vcervena, 75, 75);
        gc.fillOval(62.5, voranzova, 75, 75);
        gc.fillOval(62.5, vzelena, 75, 75);
        gc.fillOval(150+12.5, vchcervena, 75, 75);//prava strana
        gc.fillOval(150+12.5, vchzelena, 75, 75);
        gc.setStroke(Color.BLACK);
		gc.setLineWidth(2.5);				//border
		gc.strokeRect(50, 50, 100, 300);
		gc.strokeRect(150, 50, 100, 300);
		
		/*
		gc.setStroke(Color.WHITE);
		gc.strokeOval(150+7.5+75/2, vchcervena+6, 10, 10);										//HLAVA
		gc.strokeLine(150+12.5+75/2, vchcervena+6+10, 150+12.5+75/2, vchcervena+16+30);			//TELO
		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2-5, vchcervena+16+20);		//LR
		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2+5, vchcervena+16+20);		//PR
		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2-5, vchcervena+16+30+20);	//LN
		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2+5, vchcervena+16+30+20);	//PN
		
		gc.strokeOval(150+7.5+75/2, vchzelena+6, 10, 10);										//HLAVA
		gc.strokeLine(150+12.5+75/2, vchzelena+6+10, 150+12.5+75/2, vchzelena+16+30);			//TELO
		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2-3, vchzelena+16+20);		//LR
		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2+10, vchzelena+16+20);		//PR
		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2-3, vchzelena+16+30+20);		//LN
		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2+10, vchzelena+16+30+20);		//PN
		*/

        switch (stav) {
            case 0:
                gc.setFill(Color.RED);
                gc.fillOval(62.5, vcervena, 75, 75);
                
                gc.setStroke(Color.WHITE);
        		gc.strokeOval(150+7.5+75/2, vchcervena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10, 150+12.5+75/2, vchcervena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2-5, vchcervena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2+5, vchcervena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2-5, vchcervena+16+30+20);	//LN
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2+5, vchcervena+16+30+20);	//PN
        		gc.setStroke(Color.GREEN);
        		gc.strokeOval(150+7.5+75/2, vchzelena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10, 150+12.5+75/2, vchzelena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2-3, vchzelena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2+10, vchzelena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2-3, vchzelena+16+30+20);		//LN
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2+10, vchzelena+16+30+20);		//PN
                break;
            case 1:
            	gc.setFill(Color.RED);
                gc.fillOval(62.5, vcervena, 75, 75);
                gc.setFill(Color.ORANGE);
                gc.fillOval(62.5, voranzova, 75, 75);
                
                gc.setStroke(Color.RED);
        		gc.strokeOval(150+7.5+75/2, vchcervena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10, 150+12.5+75/2, vchcervena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2-5, vchcervena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2+5, vchcervena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2-5, vchcervena+16+30+20);	//LN
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2+5, vchcervena+16+30+20);	//PN
        		gc.setStroke(Color.WHITE);
        		gc.strokeOval(150+7.5+75/2, vchzelena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10, 150+12.5+75/2, vchzelena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2-3, vchzelena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2+10, vchzelena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2-3, vchzelena+16+30+20);		//LN
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2+10, vchzelena+16+30+20);		//PN
                break;
            case 2:
                gc.setFill(Color.GREEN);
                gc.fillOval(62.5, vzelena, 75, 75);
                
                gc.setStroke(Color.RED);
        		gc.strokeOval(150+7.5+75/2, vchcervena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10, 150+12.5+75/2, vchcervena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2-5, vchcervena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2+5, vchcervena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2-5, vchcervena+16+30+20);	//LN
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2+5, vchcervena+16+30+20);	//PN
        		gc.setStroke(Color.WHITE);
        		gc.strokeOval(150+7.5+75/2, vchzelena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10, 150+12.5+75/2, vchzelena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2-3, vchzelena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2+10, vchzelena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2-3, vchzelena+16+30+20);		//LN
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2+10, vchzelena+16+30+20);		//PN
                break;
            case 3:
            	gc.setFill(Color.ORANGE);
                gc.fillOval(62.5, voranzova, 75, 75);
                
                gc.setStroke(Color.RED);
        		gc.strokeOval(150+7.5+75/2, vchcervena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10, 150+12.5+75/2, vchcervena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2-5, vchcervena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchcervena+6+10+3, 150+12.5+75/2+5, vchcervena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2-5, vchcervena+16+30+20);	//LN
        		gc.strokeLine(150+12.5+75/2, vchcervena+16+30, 150+12.5+75/2+5, vchcervena+16+30+20);	//PN
        		gc.setStroke(Color.WHITE);
        		gc.strokeOval(150+7.5+75/2, vchzelena+6, 10, 10);										//HLAVA
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10, 150+12.5+75/2, vchzelena+16+30);			//TELO
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2-3, vchzelena+16+20);		//LR
        		gc.strokeLine(150+12.5+75/2, vchzelena+6+10+3, 150+12.5+75/2+10, vchzelena+16+20);		//PR
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2-3, vchzelena+16+30+20);		//LN
        		gc.strokeLine(150+12.5+75/2, vchzelena+16+30, 150+12.5+75/2+10, vchzelena+16+30+20);		//PN
        		break;
	}
	}
}
