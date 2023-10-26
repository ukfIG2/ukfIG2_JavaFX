package application;

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

public class Projectil extends Canvas{
	
	GraphicsContext gc;
	Game game;
	MySprite enemyObject;
	Timeline timeLine;
	
	double sizeX;
	double sizeY;
	int directionX = 0;
	int directionY = 0;
	double speed = 10;
	
	int value = 0;
	double valueToDestoy = 5 + Math.random() * 20;
	
	public Projectil(MySprite enemy)
	{
		super(enemy.getWidth()/5, enemy.getHeight()/5);
		sizeX = enemy.getWidth()/5;
		sizeY = enemy.getHeight()/5;
		
		this.setLayoutX(enemy.getLayoutX() + enemy.getWidth()/2);
		this.setLayoutY(enemy.getLayoutY() + enemy.getHeight()/2);
		gc = getGraphicsContext2D();
		this.game = enemy.getCurrentGameScript();
		this.enemyObject = enemy;
		Vykresli();
		
		//setOnMouseClicked(evt -> DestroyGameObject());
		SetDirection(enemy.getDirection());
		
		timeLine = new Timeline(new KeyFrame(Duration.millis(50), e -> Moving()));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}
	void Vykresli()
	{
		gc.setFill(Color.RED);
		gc.fillOval(0, 0, sizeX, sizeY);
	}
	void SetDirection(int direction)
	{
		switch(direction)
		{
			case 0:
				directionY = 1;
				break;
			case 1:
				directionY = -1;
				break;
			case 2:
				directionX = -1;
				break;
			case 3:
				directionX = 1;
				break;
			default:
				directionX = 0;
				directionY = 0;
				break;
		}
	}
	void Moving()
	{
		value++;
		gc.clearRect(0, 0, sizeX, sizeY);
		setLayoutX(getLayoutX() + speed * directionX);
		setLayoutY(getLayoutY() + speed * directionY);
		Vykresli();
		if (value > valueToDestoy) { DestroyGameObject(); }
	}
	void DestroyGameObject()
	{
		timeLine.stop();
		game.projectilles.remove(this);
		game.getChildren().remove(this);
	}
}