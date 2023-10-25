package application;



import java.util.Random;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class Drv extends Canvas{
	protected GraphicsContext gc;

	public Drv(int x, int y) {
		super(200,200);
		setLayoutX(x); setLayoutY(y);
		gc = getGraphicsContext2D();
	    
	}
	public void pridajObjekt(Pane pane) {
    	Random random = new Random();
    	Tree b = new Tree(random.nextDouble() * (pane.getWidth() - 100), random.nextDouble() * (pane.getHeight() - 100));
    	pane.getChildren().add(b);  
    	 
    	}
	public void pridajObjekt1(Pane pane) {
    	Random random = new Random();
    	Flower f = new Flower(random.nextDouble() * (pane.getWidth() - 100), random.nextDouble() * (pane.getHeight() - 100));
    	pane.getChildren().add(f);  
    	 
    	}
	public void pridajObjekt2(Pane pane) {
    	Random random = new Random();
    	Bush k = new Bush(random.nextDouble() * (pane.getWidth() - 100), random.nextDouble() * (pane.getHeight() - 100));
    	pane.getChildren().add(k);  
    	 
    	}


}
