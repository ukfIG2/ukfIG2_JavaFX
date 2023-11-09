package _13_Baloniky_Zadanie_01;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Balon extends Canvas{
	private Color color;
	private GraphicsContext gc;
	private Timeline casovac;
	private Group root;
	
	public int random() {
		int a =  (int) (Math.random()*30);
		return a;
	}
	
	public Balon(Group g, Color cr, int x, int y) {
		super(100,100);
		this.setLayoutX(x); this.setLayoutY(y);
		//g=this.g;
		root = g;
		color = cr; 
		gc = getGraphicsContext2D();
		vykresli();
		//Pohyb balonikov
		casovac = new Timeline(
				new KeyFrame(Duration.millis(100),e -> pohyb()));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
		setOnMouseClicked(evt->prask());
	}

	private void vykresli() {
		gc.setFill(color);
		gc.fillOval(30, 15, 40, 70);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeLine(30+20, 15+70, 60, 100);
	}

	/*public void pohyb() {
		int r = random(); 
		if (r%2==0) setLayoutX(getLayoutX()-random());			//nahodne do lava
		else setLayoutX(getLayoutX()+random());					//nahodne do prava
		setLayoutY(getLayoutY()-random());						//nahodne hore
		//vykresli();	//zbytocne to tam je, lebo iba hybem objektom, nerobim animaciu
		if(getLayoutY()<-50) root.getChildren().remove(this);	//ak sa dostane hore zmizne
		// Ak újdu moc do lava|prava
		if(getLayoutX()<-100) root.getChildren().remove(this);	
		if(getLayoutX()>1200) root.getChildren().remove(this);
	}
	
	public void prask() {
		root.getChildren().remove(this);  //remove.this nezastavi casovac
	}*/
	
	public void pohyb() {
		int r = random(); 
		if (r%2==0) setLayoutX(getLayoutX()-random());			//nahodne do lava
		else setLayoutX(getLayoutX()+random());					//nahodne do prava
		setLayoutY(getLayoutY()-random());						//nahodne hore
		//vykresli();	//zbytocne to tam je, lebo iba hybem objektom, nerobim animaciu
		if(getLayoutY()<-50) prask();	//ak sa dostane hore zmizne
		// Ak újdu moc do lava|prava
		if(getLayoutX()<-100) prask();	
		if(getLayoutX()>1200) prask();
	}
	
	public void prask() {
		root.getChildren().remove(this);
		casovac.stop();				//Aj ChatGPT hovori ze treba tam stop.
	}
	
	
}
