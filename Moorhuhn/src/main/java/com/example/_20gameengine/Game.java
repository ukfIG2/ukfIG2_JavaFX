package com.example._20gameengine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class Game extends Group {
	int score = 0;
	int highestScore = 0;

	final int maxAmmonition = 5;
	int currentAmmonition;
	final int ammoSize = 40;
	ImageView crosshair;
	final int crosshairSize = 40;
	final int enemiesMultiplication = 2;
    final int spriteSize = 30;
    final int enemySpeed = 20;
    //GAME
    //Image shellImage = new Image("shell.png"); ///ORIGINAL
    Image shellImage = new Image("Shell.png"); ////NIE shell ale Shell
    Image crossImage = new Image("cross.png");
    private ImageView background;  // obrázok pozadia
    public ArrayList<MySprite> enemies = new ArrayList<>();
    ArrayList<ImageView> ammonition = new ArrayList<>();
    private double width, height;
    
    boolean enemiesMoving = true;

    MyTimer timerScript;

    public Game(int w, int h, String pozadie) {
        width = w;
        height = h;
        Image bg = new Image(pozadie, w, h, false, false);
        background = new ImageView(bg);
        getChildren().add(background);
        SetCross();
        AddingEnemies();
        // urobime focusovatelny cely group
        setFocusTraversable(true);
        setFocused(true);
        Reload();
        AddShells();
    }
    void AddShells()
    {
    	int shellsAdded = 1;
    	for (ImageView shell : ammonition)
    	{
    		getChildren().remove(shell);
    	}
    	ammonition.clear();
    	for (int i = 0; i < currentAmmonition; i++)
    	{
    		ImageView shell = new ImageView(shellImage);
    		shell.setFitWidth(ammoSize/2);
    		shell.setFitHeight(ammoSize);
    		
    		shell.setLayoutX(width - (ammoSize * shellsAdded));
    		shell.setLayoutY(height - ammoSize);
    		shellsAdded++;
    		
    		ammonition.add(shell);
    		getChildren().add(shell);
    	}
    }
    void AddingEnemies()
    {
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1 * enemiesMultiplication), e -> AddEnemy()));
    	timeline.setCycleCount((HelloApplication.t) / enemiesMultiplication);
    	timeline.play();
    }
    void AddEnemy()
    {
    	double sideSpawn = Math.random() * width;				//nahodna hodnota medzi 0 a width
    	sideSpawn = (sideSpawn > (width/2)) ? width : -spriteSize; 	//spawnovanie buď v lavom alebo pravom okraji
        MySprite ms = new MySprite("enemy",
                3,           					// pocet obrazkov
                sideSpawn, 						// poloha x
                spriteSize + (Math.random() * height - (spriteSize*2)), // poloha y
                this);							// Game script
        enemies.add(ms);     	// pridanie do zoznamu
        getChildren().add(ms); 	// pridanie na scenu
    }
    void SetCross()
    {
    	crosshair = new ImageView(crossImage);
    	crosshair.setFitWidth(crosshairSize);
    	crosshair.setFitHeight(crosshairSize);
    	getChildren().add(crosshair);
    	setOnMouseMoved(e -> UpdateCrosshairPosition(e));
    	setOnMouseClicked(e -> Shoot(e));
    	setOnKeyPressed(e -> { if(e.getCode().toString().equals("SPACE")) { Reload(); }});
    }
    void UpdateCrosshairPosition(javafx.scene.input.MouseEvent event)
    {
    	crosshair.setLayoutX(event.getX() - crosshair.getBoundsInLocal().getWidth() / 2);
    	crosshair.setLayoutY(event.getY() - crosshair.getBoundsInLocal().getHeight() / 2);
    }
    void Reload()
    {
    	if(enemiesMoving) {	//if is playing
	    	System.out.println("reloading...");
	    	currentAmmonition = maxAmmonition;
	    	AddShells();
    	}
    }

    public void update(double deltaTime) {
        
        // zmena polohy Enemies – pohnem všetkými naraz
        if (enemiesMoving) {
	        for (int i = 0; i < enemies.size(); i++) {
	            MySprite enemy = enemies.get(i); // vezmem i-teho
	            enemy.Move(deltaTime / 1000000000 * enemySpeed);
	        }
        }
    }
    public void AddScore(int amount)
    {
    	score += amount;
    	HelloApplication.scoreText.setText("Score: " + score);
    }
    void Shoot(MouseEvent event)
    {
    	if (currentAmmonition <= 0) { System.out.println("Out of shells, press SPACE to reload!"); return; }
    	else if (!enemiesMoving) 	{ System.out.println("Restart level if you want to play!"); return; }
    	
    	Iterator<MySprite> iterator = enemies.iterator();
    	while(iterator.hasNext()) {
    		MySprite enemy = iterator.next();
    		if (crosshair.getBoundsInParent().intersects(enemy.getBoundsInParent()))
    		{
    			iterator.remove();
    			enemy.DestroySelf();
    		}
    	}
    	currentAmmonition--;
    	AddShells();
    }
    public void TimeOut()
    {
    	enemiesMoving = false;
    	RestartGraphics();
    }
    void RestartGraphics()
    {
    	double frameWidth = width/5;
        double frameHeight = height/5;
        double cornerRadius = 10;

        Rectangle frame = new Rectangle(width / 2 - frameWidth / 2, height / 2 - frameHeight / 1.5, frameWidth, frameHeight); //BACKGROUND FRAME
        frame.setFill(Color.BLACK);
        frame.setStroke(Color.GRAY);
        frame.setStrokeWidth(2);
        frame.setArcWidth(cornerRadius * 2);
        frame.setArcHeight(cornerRadius * 2);
        
        double restartRectWidth = width/10;
        double restartRectHeight = height/20;
        
        Rectangle restartFrame = new Rectangle(width / 2 - restartRectWidth / 2, height / 2 - restartRectHeight / 2, restartRectWidth , restartRectHeight); //RESTART FRAME
        restartFrame.setFill(Color.GREEN);
        restartFrame.setStroke(Color.BLACK);
        restartFrame.setStrokeWidth(2);
        restartFrame.setArcWidth(cornerRadius * 2);
        restartFrame.setArcHeight(cornerRadius * 2);
        
        Text scoreText = new Text("Score: " + score); 										//SCORE TEXT
        scoreText.setStroke(Color.WHITE);
    	scoreText.setFont(Font.font(20));
    	scoreText.setX(width / 2 - scoreText.getLayoutBounds().getWidth() / 2);
        scoreText.setY(height / 2 - frameHeight / 2);
        
        Text highestScoreText = new Text("Your Highest Score: " + highestScore); 						//HIGHEST SCORE TEXT
        highestScoreText.setStroke(Color.WHITE);
    	highestScoreText.setFont(Font.font(20));
    	highestScoreText.setX(width / 2 - highestScoreText.getLayoutBounds().getWidth() / 2);
        highestScoreText.setY(height / 2 - frameHeight / 4);
        
    	Text restartText = new Text("Restart"); 										//RESTART TEXT
    	restartText.setFont(Font.font(20));
    	restartText.setX(width / 2 - restartText.getLayoutBounds().getWidth() / 2);
        restartText.setY(height / 2 + restartText.getLayoutBounds().getHeight() / 4);
    	
    	this.getChildren().addAll(frame, restartFrame, scoreText, highestScoreText, restartText);			//ADDING OBJECTS

    	restartText.setOnMouseClicked(e -> {											//RESTART ON CLICK
    		RestartLVL();
        	this.getChildren().removeAll(frame, restartFrame, scoreText, highestScoreText, restartText);
    	});
    }
    void RestartLVL()
    {
    	if (score > highestScore) { highestScore = score; } 					//SET HIGHEST SCORE
    	// Create a copy of the enemies list to avoid ConcurrentModificationException
    	ArrayList<MySprite> enemiesCopy = new ArrayList<>(enemies);
    	
    	for (MySprite enemy : enemiesCopy) { enemy.DestroySelf(); }
    	
    	score = 0;
		HelloApplication.t = HelloApplication.time;
		HelloApplication.scoreText.setText("Score: " + score);
		HelloApplication.timer.setText("Score: " + score);
		
		timerScript.RestartTimer();
		AddingEnemies();
		enemiesMoving = true;
		Reload();
    }
    
    public double GetWidth() 	{ return width; }
    public double GetHeight() 	{ return height; }
    public void SetTimer(MyTimer timer) { this.timerScript = timer; }
}
