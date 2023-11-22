package com.example._20gameengine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
	final int sceneWidth = 1024;
	final int sceneHeight = 800;
	public static final int time = 60;
	public static int t;
	public static Text scoreText = new Text(20, 40, "Score: 0");
	public static Text timer = new Text(20, 60, "Time: " + t);
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        t = time;
        Game g = new Game(sceneWidth, sceneHeight, "pozadie.jpg");
        root.getChildren().addAll(g, scoreText, timer);

        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.show();
        MyTimer t = new MyTimer(g);
        g.SetTimer(t);
        t.start();
    }

    public static void main(String[] args) {
        launch();
    }
}