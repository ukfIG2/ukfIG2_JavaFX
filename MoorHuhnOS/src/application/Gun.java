package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Gun extends Canvas {
	
	GraphicsContext gc;
    private int naboj;
    //Sound shot = new Sound("gunshot.wav");
    //Sound reload = new Sound("reload.wav");

    public Gun(int naboj){
    	super(300,300);
        setLayoutX(950);
        setLayoutY(5);
        this.naboj = naboj;
        gc = getGraphicsContext2D();
        this.setOnKeyPressed(event -> reload(event));
        this.setFocusTraversable(true);
        this.requestFocus();
        shot();

    }

    //public void vystrel(){shot.play();}

    //public void reload(){reload.play();}


    public void reload(KeyEvent evt){
        KeyCode k = evt.getCode();
        if(k==KeyCode.R) {
            //reload();
            naboj =5;
            gc.clearRect(0, 0, getWidth(), getHeight());
            gc.setFill(Color.BLACK);
            gc.fillText(("Náboje :" + " "+ naboj), 0, 30);

        }
    }

	public void shot() {
		naboj--;
        if (naboj <=0){
            gc.clearRect(0, 0, getWidth(), getHeight());
            gc.setFill(Color.RED);
            gc.fillText(("Náboje :" + " Stlac R"), 0, 30);
        }else{
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.BLACK);
        gc.fillText(("Náboje :" + " " + naboj), 0, 30);}
		
	}

}
