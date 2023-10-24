package Kontrola_balonov_04_AP.Baloniky.src.application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		int sceneX = 500;
		int sceneY = 500;
		
		Group root = new Group();
		Scene scene = new Scene(root, sceneX, sceneY);

		TimeHandling(root, sceneX, sceneY);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	void AddBalloon(Group root, int sceneX, int sceneY)
	{
		Balon b = new Balon(sceneX, sceneY, 40, 60, root);
		root.getChildren().add(b);
	}
	void TimeHandling(Group root, int sceneX, int sceneY)
	{
		Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(1), e -> AddBalloon(root, sceneX, sceneY)));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
