package com.example._20gameengine;

import java.io.File;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.AudioClip;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MySprite extends ImageView {
    Image[] sprites;
    double size;
    int sizeMultiplication;
    int smer; // 1 ak vpravo, -1 ak vlavo
    int actImage = 0;
    double sceneX;
    double sceneY;
    boolean upMove = false;
    int yMoveCounter = 0;
    int maxYmoves = 10;
    
    double maxSpeedMultiplication = 4;
    double currentSpeedMultiplication;
    
    Game gameScript;
    
    AudioClip clip = null;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;

    public MySprite(String nazov, int pocetSpritov, double positionX, double positionY, Game g) {
        super(); 
        sizeMultiplication = 1 + (int)(Math.random() * 3);
        size = g.spriteSize * sizeMultiplication;
        this.sceneX = g.GetWidth();
        this.sceneY = g.GetHeight();
        sprites = new Image[pocetSpritov];
        for(int i = 0; i < pocetSpritov; i++) {
            sprites[i] = new Image(nazov+i+".png", size, size, false, false);
        }
        gameScript = g;
        setImage(sprites[0]);
        setLayoutX(positionX);
        setLayoutY(positionY);
        currentSpeedMultiplication = 1 + (Math.random() * maxSpeedMultiplication);
        
        smer = (positionX < 0) ? 1 : -1;
        this.setScaleX(smer);
    }

    public double GetWidth() 	{ return size; }
    public double GetHeight() 	{ return size; }
    
    public void Move(double delta)
    {
    	HeightMove(delta);
        SideMove(delta);
        Vykresli();
    }

    void Vykresli() {
    	if (actImage >= sprites.length) { actImage = 0; }
    	setImage(sprites[actImage]);
    	actImage++;
    }
    
    void SideMove(double delta)
    {
    	if (smer > 0) 	{ setLayoutX(getLayoutX() + (delta * currentSpeedMultiplication)); } //DOPRAVA
    	else 			{ setLayoutX(getLayoutX() - (delta * currentSpeedMultiplication)); } //DOLAVA
    	
    	if (this.getLayoutX() > sceneX || this.getLayoutX() < -size) //ak je na okraji sceny -> 
    	{ ChangeDirection(); }
    }
    void HeightMove(double delta)
    {
    	if (yMoveCounter <= 0) 
    	{ 
    		yMoveCounter = (int) (Math.random() * maxYmoves);
    		upMove = (upMove) ? false : true;
    	} 
    	if (upMove) { setLayoutY(getLayoutY() - (delta * currentSpeedMultiplication)); } //HORE
    	else 		{ setLayoutY(getLayoutY() + (delta * currentSpeedMultiplication)); } //DOLE
    	
    	if (getLayoutY() <= 0) { upMove = false; }
    	else if (getLayoutY() >= (gameScript.GetHeight() - size)) { upMove = true; }
    	
    	yMoveCounter--;
    }
    
    void ChangeDirection()
    {
    	smer = -smer;
    	this.setScaleX(smer);
    }
    void DestroySelf()
    {
    	gameScript.AddScore(30 / sizeMultiplication);
    	gameScript.enemies.remove(this);
    	gameScript.getChildren().remove(this);
    	/*
    	try {
			    	Media sound = new Media(getClass().getResource("duck_dying.mp3").toExternalForm());
			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
			        MediaView mediaView = new MediaView(mediaPlayer);
			        gameScript.getChildren().add(mediaView);
			        mediaPlayer.play();
    		String soundFilePath = new File("duck_dying.mp3").toURI().toString();
    		MediaPlayer mediaPlayer = new MediaPlayer(new Media(soundFilePath));
    		mediaPlayer.setVolume(1.0); // Set volume to maximum (1.0)
    		mediaPlayer.setMute(false); // Ensure mute is set to false
    		mediaPlayer.play();
    	}
    	catch (Exception e)
    	{
    		System.out.println("nefunguje zvuk bohuzial");
    	}*/
    	//MySprite
    	try {
    	    // ...
    	    String soundFilePath = new File("src/main/resources/duck_dying.mp3").toURI().toString();
    	    mediaPlayer = new MediaPlayer(new Media(soundFilePath));
    	    mediaPlayer.setVolume(1.0);
    	    mediaPlayer.setMute(false);
    	    mediaPlayer.play();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    System.out.println("Error loading media: " + e.getMessage());
    	}


    	playFeatherAnimation();
    }
    void playFeatherAnimation() {
        for (int i = 5; i < 12; i++) {  // You can adjust the number of feathers as needed
            Image featherImage = new Image("feather.png");
            ImageView feather = new ImageView(featherImage);
            feather.setFitWidth(20);  // Adjust the size of the feathers
            feather.setFitHeight(20);

            // Set the initial position of the feather
            feather.setLayoutX(this.getLayoutX());
            feather.setLayoutY(this.getLayoutY());
            feather.setRotate(Math.random() * 360);

            // Create a TranslateTransition for the feather
            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), feather);

            // Set the random direction for each feather
            translate.setByX(Math.random() * 100 - 50);
            translate.setByY(Math.random() * 100 - 50);

            // Create a FadeTransition to make the feather disappear
            FadeTransition fade = new FadeTransition(Duration.seconds(0.5), feather);
            fade.setToValue(0);

            // Combine translate and fade transitions
            translate.setOnFinished(event -> gameScript.getChildren().remove(feather));
            translate.play();
            fade.play();

            gameScript.getChildren().add(feather);
        }
    }
}