package Kontrola_balonov_05_MB.Balonky.src.application;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.io.IOException;
import javafx.scene.Group;


public class MainApp extends Application {
	protected int sirka = 700;
	protected int vyska = 500;
    Text counterText;
    Text live;
	 
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        
        counterText = new Text("score: 0");
        live = new Text("lives: 5");
        counterText.setLayoutX(10); 
        counterText.setLayoutY(30);
        root.getChildren().addAll(counterText, live);
        live.setLayoutX(10); 
        live.setLayoutY(50);
 
        Scene scene = new Scene(root, sirka, vyska);
        scene.setFill(Color.LIGHTBLUE);

        Balon balon = new Balon(root, sirka, vyska, counterText, live);
        root.getChildren().add(balon);
       
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Balónky");
        stage.show(); 
        
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
            new KeyFrame(Duration.seconds(1), e -> {
            	if (balon.end) {
                    timeline.stop();
                }else {
                Balon novyBalon = new Balon(root, sirka, vyska, counterText, live);
                root.getChildren().add(novyBalon);
                }
                
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public static void main(String[] args) {
        launch();
    }
    
    public void startNewStage(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


