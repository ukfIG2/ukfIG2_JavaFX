package Kontrola_balonov_04_AP.Baloniky.src.application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Balon extends Canvas{
	
	GraphicsContext gc;
	Group root;
	
	double randomSpeed = 1 + Math.random() * 6;
	
	public Balon(int sceneEndPointX, int sceneEndPointY, int sizeX, int sizeY, Group root)
	{
		super(sizeX, sizeY);
		this.setLayoutX((int)(Math.random() * sceneEndPointX + 1));
		this.setLayoutY(sceneEndPointY);
		gc = getGraphicsContext2D();
		this.root = root;
		
		setOnMouseClicked(evt -> DestroyGameObject());
		
		Vykresli();
		Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(50), e -> RandomSpeedUp()));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}
	void Vykresli()
	{
		Balon();
	}
	void Balon()
	{
		gc.setFill(SetColor());
		gc.fillOval(0, 0, getWidth() / 2.5, getHeight() / 2);
		
		gc.setLineWidth(2.0);

		double balonCenterX = (getWidth() / 2.5) / 2;
		double balonEndY = (getHeight() / 2);
		
        // Starting point (x1, y1)
        double x1 = balonCenterX;
		double y1 = balonEndY;
		
        // Ending point (x2, y2)
        double x2 = balonCenterX;
        double y2 = balonEndY * 2;
		
        // Control point for the first curve (cx1, cy1)
        double cx1 = balonCenterX - (balonCenterX / 5);
        double cy1 = balonEndY * 1.3;

        // Control point for the second curve (cx2, cy2)
        double cx2 = balonCenterX + (balonCenterX / 5);
        double cy2 = balonEndY * 1.6;
		
        gc.beginPath();
        gc.moveTo(x1, y1);
        gc.bezierCurveTo(cx1, cy1, cx2, cy2, x2, y2);
        gc.stroke();
	}
	Color SetColor()
	{
		Color randomColor;
		
		double randomRed = Math.random();
		double randomGreen = Math.random();
		double randomBlue = Math.random();
		
		randomColor = new Color(randomRed, randomGreen, randomBlue, 1);
		
		return randomColor;
	}
	void RandomSpeedUp()
	{
		if (getLayoutY() <= 0) 	{ DestroyGameObject(); }
		else 					{ setLayoutY(getLayoutY() - randomSpeed); }
	}
	void DestroyGameObject()
	{
		root.getChildren().remove(this);
	}
}