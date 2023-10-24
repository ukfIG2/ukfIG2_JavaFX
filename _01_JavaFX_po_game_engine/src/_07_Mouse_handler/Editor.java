package _07_Mouse_handler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Editor extends Canvas{
	GraphicsContext gc;
	double oldx, oldy;
	
	public Editor(int x,int y, int s,int v) {
		super(s, v);
		setLayoutX(x); setLayoutY(y); //pozicia komponentu
		gc = getGraphicsContext2D();
		gc.setFill(Color.YELLOW);
		gc.fillRect(0, 0, getWidth(), getHeight());
		gc.setStroke(Color.RED);
		
		setOnMouseDragged(evt -> kresli(evt));
		setOnMousePressed(evt ->startKreslenia(evt));
	}
	
	private void kresli(MouseEvent evt) {
		double x = evt.getX();
		double y = evt.getY();
		//gc.strokeOval(x, y, 5, 5);
		gc.strokeLine(oldx, oldy, x, y);
		oldx = x;
		oldy = y;		
	}
	
	private void startKreslenia(MouseEvent evt) {
		oldx = evt.getX();
		oldy = evt.getY();
	}
	
}
