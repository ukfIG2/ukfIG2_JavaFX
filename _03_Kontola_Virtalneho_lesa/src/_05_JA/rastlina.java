package application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class rastlina extends Canvas {
	protected Timeline t;
	protected int velkost;
	GraphicsContext gc;
	
	
	public rastlina(int x,int y){
		super(100,100);this.velkost=0;
		gc=getGraphicsContext2D();
		setLayoutY(y);setLayoutX(x);
		t=new Timeline(new KeyFrame(Duration.seconds(1),e->start()));
		t.setCycleCount(Animation.INDEFINITE);
		t.play();
	}
	
	public void start(){
		gc.clearRect(0, 0, 100, 100);
		vykresli();
		if(velkost == 4){
			this.velkost=0;
		}else{
			velkost++;
			} 
	}
	
	protected void vykresli() {
	}
}
