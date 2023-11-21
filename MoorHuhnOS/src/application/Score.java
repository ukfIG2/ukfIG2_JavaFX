package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Score extends Canvas {
	
	static GraphicsContext gc;
    private static int score;
    
    public Score(int score){
    	super(300,300);
        setLayoutX(500);setLayoutY(5);
        this.score = score;
        gc = getGraphicsContext2D();
        vykresli();
    }
    
    public void vykresli(){
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.BLACK);
        gc.fillText(("Score :" + " " + score), 0, 30);
    }
    public static void kill(){
        score +=5;
        gc.clearRect(0,0,300,300);
        gc.setFill(Color.BLACK);
        gc.fillText(("Score :" + " " + score), 0, 30);
    }

}
