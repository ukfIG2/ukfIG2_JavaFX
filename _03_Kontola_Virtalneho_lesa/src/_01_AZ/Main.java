package application;
	

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main extends Application {

    private final Random random = new Random();
    private final List<Rastlina> rastliny = new ArrayList<>();
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 650;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        Button stromButton = new Button("Pridať strom");
        stromButton.setOnAction(event -> {
            Strom strom = new Strom(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            rastliny.add(strom);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        gc.clearRect(0, 0, WIDTH, HEIGHT);
                        strom.increaseSizeLevel();
                        for (Rastlina rastlina : rastliny) {
                            rastlina.vizualnyVzhlad(gc);
                        }
                    })
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        Button kvetButton = new Button("Pridať kvet");
        kvetButton.setOnAction(event -> {
            Kvet kvet = new Kvet(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            rastliny.add(kvet);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        gc.clearRect(0, 0, WIDTH, HEIGHT);
                        kvet.increaseSizeLevel();
                        for (Rastlina rastlina : rastliny) {
                            rastlina.vizualnyVzhlad(gc);
                        }
                    })
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        Button krikButton = new Button("Pridať krik");
        krikButton.setOnAction(event -> {
            Krik krik = new Krik(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            rastliny.add(krik);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        gc.clearRect(0, 0, WIDTH, HEIGHT);
                        krik.increaseSizeLevel();
                        for (Rastlina rastlina : rastliny) {
                            rastlina.vizualnyVzhlad(gc);
                        }
                    })
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        vBox.getChildren().addAll(stromButton, kvetButton, krikButton);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}