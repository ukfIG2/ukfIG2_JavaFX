package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Group root;
    Game g;
    Button b;
    Rectangle overlay;
    Text scoreText, timerText, finalText;
    Button nextLevelButton, tryAgainButton;
    private int level = 0;

    public void start(Stage primaryStage) {
        root = new Group();
        g = new Game(root, this, level);
        Scene scene = new Scene(root, 800, 600);
        Image bg = new Image(getClass().getResourceAsStream("/resources/background.png"), 800, 600, false, false);
        ImageView background = new ImageView(bg);
        root.getChildren().add(background);
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getChildren().add(g);
        hud();
    }

    public void newLevel() {
    	if (level != 4) {
        overlay = new Rectangle(0, 0, 800, 600);
        overlay.setFill(Color.DARKOLIVEGREEN);
        root.getChildren().add(overlay);
        g.gameTimer.stop();
        g.stepsTimer.stop();
        root.getChildren().remove(scoreText);
        root.getChildren().remove(timerText);
        displayFinalText(g.getSteps(),g.getTime());
        tryAgainButton = new Button("Try Again");
        tryAgainButton.setLayoutX(310);
        tryAgainButton.setLayoutY(480);

        nextLevelButton = new Button("Next Level");
        nextLevelButton.setLayoutX(400);
        nextLevelButton.setLayoutY(480);

        root.getChildren().addAll(tryAgainButton, nextLevelButton);
        root.getChildren().remove(b);
        root.getChildren().remove(g);
        tryAgainButton.setOnAction(event -> {
            restart();
            root.getChildren().removeAll(overlay, tryAgainButton, nextLevelButton, finalText);
        });

        nextLevelButton.setOnAction(event -> {
            root.getChildren().removeAll(overlay, tryAgainButton, nextLevelButton, finalText);
            level++;
            g = new Game(root, this, level); 
            g.loadLevel(level);
            root.getChildren().add(g);
            g.drawLevel();
            hud();
        });}else {
    		gameFinished();
    	}
    }

    public void restart() {
        root.getChildren().remove(g);
        root.getChildren().remove(scoreText);
        root.getChildren().remove(timerText);
        root.getChildren().remove(finalText);
        g = new Game(root, this, level); 
        g.loadLevel(level);
        root.getChildren().add(g);
        g.drawLevel();
        hud();
    }

    public void displayFinalText(String steps, String time) {
        finalText = new Text("Congratulations!\nSteps: " + steps + "\nTime: " + time);
        finalText.setLayoutX(280);
        finalText.setLayoutY(250);
        finalText.setFill(Color.WHITE);
        finalText.setStroke(Color.BLACK);
        finalText.setStrokeWidth(1);
        finalText.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
        root.getChildren().add(finalText);
    }
    
    public void gameFinished() {
    	displayFinalText(g.getSteps(),g.getTime());
    	overlay = new Rectangle(0, 0, 800, 600);
        overlay.setFill(Color.DARKOLIVEGREEN);
        root.getChildren().add(overlay);
    	root.getChildren().removeAll(g, tryAgainButton, nextLevelButton, finalText, scoreText, timerText, b);
    	finalText = new Text("You Beat The Game");
        finalText.setLayoutX(190);
        finalText.setLayoutY(300);
        finalText.setFill(Color.WHITE);
        finalText.setStroke(Color.BLACK);
        finalText.setStrokeWidth(2);
        finalText.setFont(Font.font("Raleway", FontWeight.BOLD, 45));
        root.getChildren().add(finalText);
        Timeline exitg = new Timeline(new KeyFrame(Duration.seconds(3), event -> System.exit(0)));
        exitg.play();
    }
    
    public void hud() {
        b = new Button("Restart");
        b.setOnAction(event -> {
            restart();
        });
        root.getChildren().add(b);
        scoreText = g.getStepsText();
        scoreText.setFill(Color.WHITE);
        scoreText.setStroke(Color.BLACK);
        scoreText.setStrokeWidth(2);
        scoreText.setFont(Font.font("Raleway", FontWeight.BOLD, 25));
        root.getChildren().add(scoreText);
        timerText = g.getTimerText();
        timerText.setFill(Color.WHITE);
        timerText.setStroke(Color.BLACK);
        timerText.setStrokeWidth(2);
        timerText.setFont(Font.font("Raleway", FontWeight.BOLD, 25));
        root.getChildren().add(timerText);
        g.getPlayer().requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
