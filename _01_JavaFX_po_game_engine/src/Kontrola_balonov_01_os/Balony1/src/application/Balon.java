package Kontrola_balonov_01_os.Balony1.src.application;




import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Balon extends Canvas {
	GraphicsContext gc;
	Timeline casovac;
	int r;
	
	
	
	public Balon(int w, int h, double x, double y, int r){
		super(w,h);
		gc = getGraphicsContext2D();
		setLayoutX(x);setLayoutY(y); this.r=r;
		casovac = new Timeline(new KeyFrame(Duration.millis(50), e -> posun()));	//vymaze sa casovac???
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
		//po kliknut� na bal�n, bal�n praskne
		setOnMouseClicked(e -> praskni());
		vykresli();
		
		}
	
	private void vykresli() {
		//r�znej farby (m��ete strieda� napr. 5 r�znych)
		if (r == 1) gc.setFill(Color.RED);
		if (r == 2) gc.setFill(Color.BLUE);
		if (r == 3) gc.setFill(Color.GREEN);
		if (r == 4) gc.setFill(Color.YELLOW);
		if (r == 5) gc.setFill(Color.PURPLE);
		gc.fillOval(1, 1, 40, 80);
	}
	
	private void posun() {
		//bud� sa r�znou r�chlos�ou pohybova� smerom nahor
		setLayoutY(getLayoutY()-r);
		//po dosiahnut� horn�ho okraja sa stratia
		if(getLayoutY()<0) praskni();
	}
	private void praskni() {
		gc.clearRect(0,0,getHeight(),getWidth());
		casovac.stop();		//alternativa k remove(this); ???
	}
}
