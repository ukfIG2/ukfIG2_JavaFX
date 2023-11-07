package Strom_jablko;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Jablko extends Canvas{
	private GraphicsContext gc;
	private Timeline timeline;
	private Timeline timeline2;
	private double Sirka, Dlzka;
	private Group group;
	private int sekund =2;
	
	public Jablko(Group group, double PolohaX, double PolohaY, double Sirka, double Dlzka) {
		super(Sirka, Dlzka);
		this.group=group;
		gc = getGraphicsContext2D();
		setLayoutX(PolohaX); setLayoutY(PolohaY);
		this.Sirka=Sirka; this.Dlzka=Dlzka;
		/*Strom strom = new Strom(group);
		group.getChildren().add(strom);*/
		Vykres();
		setOnMouseClicked(e -> pad());
		
	}
	
	private void pad() {
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> posun()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void Vykres() {
		gc.clearRect(0, 0, 50, 60);
	gc.setFill(Color.RED);
	gc.fillOval(0, 10, Sirka, Dlzka-10);
	gc.setStroke(Color.BLACK);
	gc.setLineWidth(3);
	gc.strokeLine(25, 10, 50, 0);
	//System.out.print("Ano");
	gc.setFill(Color.BLACK);
	gc.fillText("Nieco", 50, 60);
	}
	
	private void posun() {
		setLayoutY(getLayoutY()+10);
		if(getLayoutY()>500) {
			timeline.stop();
			timeline2 = new Timeline(new KeyFrame(Duration.seconds(2),e -> hnit()));
			timeline2.setCycleCount(Animation.INDEFINITE);
			timeline2.play();
		}
		
	}
	
	private void hnit() {
		Sirka=Sirka-10;
		Dlzka=Dlzka-10;
		System.out.println(Sirka+"   "+ Dlzka);
		System.out.print("Hnije");
		Vykres();
		Aplikacia_strom_jablko.text.setText(Integer.toString(sekund));
		sekund+=2;
		if(Dlzka<=0) {group.getChildren().remove(this); timeline2.stop();}
		
	}
	
}
