package Kontrola_balonov_02_TH_.Project.src.application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static final int sirka = 600;
    private static final int vyska = 400;
    private static final int b_sirka = 40;
    private static final int b_vyska = 50;
    private static final int s_dlzka = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> VytvoritBalon(root)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        
        primaryStage.setScene(new Scene(root, sirka, vyska));
        primaryStage.show();
    }

    private void VytvoritBalon(Pane root) {
        Ellipse balon = new Ellipse(b_sirka / 2, b_vyska / 2);
        balon.setFill(farba());
        balon.setCenterX(Math.random() * (sirka - b_sirka) + b_sirka / 2);
        balon.setCenterY(vyska - b_vyska / 2);

        Line s = new Line();
        s.setStartX(balon.getCenterX());
        s.setStartY(balon.getCenterY() + b_vyska / 2);
        s.setEndX(balon.getCenterX());
        s.setEndY(balon.getCenterY() + b_vyska / 2 + s_dlzka);

        root.getChildren().addAll(balon, s);
        
        double b_rychlost = Math.random() * 5 + 1;

        Timeline PohybBalonu = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            balon.setCenterY(balon.getCenterY() - b_rychlost);
            s.setStartY(balon.getCenterY() + b_vyska / 2);
            s.setEndY(balon.getCenterY() + b_vyska / 2 + s_dlzka);

            if (balon.getCenterY() + b_vyska / 2 < 0) {
                root.getChildren().removeAll(balon, s);
            }
        }));
        PohybBalonu.setCycleCount(Timeline.INDEFINITE);
        PohybBalonu.play();

        balon.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                root.getChildren().removeAll(balon, s);
            }
        });
    }

    private Color farba() {
        Color[] colors = {Color.RED, Color.LIGHTSKYBLUE, Color.LIGHTGREEN, Color.ORANGE, Color.PURPLE, Color.DEEPPINK};
        return colors[(int) (Math.random() * colors.length)];
    }
}