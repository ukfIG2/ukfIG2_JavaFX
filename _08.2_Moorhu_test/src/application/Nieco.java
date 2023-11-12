package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Nieco extends Application {

    private static final double SCENE_WIDTH = 500;
    private static final double SCENE_HEIGHT = 500;
    private static final double BACKGROUND_WIDTH = 1000;
    private static final double BACKGROUND_HEIGHT = 500;
    private static final double OBJECT_SIZE = 100;

    private Pane root;
    private ImageView background;
    private ImageView movingObject;
    private double objectSpeed = 10;
    Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        

        // Load the larger background image
        Image backgroundImage = new Image("https://via.placeholder.com/1000x500");
        background = new ImageView(backgroundImage);
        background.setFitWidth(BACKGROUND_WIDTH);
        background.setFitHeight(BACKGROUND_HEIGHT);
        root.getChildren().add(background);

        // Load the moving object image
        Image objectImage = new Image("https://via.placeholder.com/100");
        movingObject = new ImageView(objectImage);
        movingObject.setFitWidth(OBJECT_SIZE);
        movingObject.setFitHeight(OBJECT_SIZE);

        // Position the object at the starting point
        movingObject.setX(0);
        movingObject.setY(250);
        root.getChildren().add(movingObject);
        
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e->moveObject()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
       

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Camera Movement Up-Down");
        primaryStage.show();

        // Handle mouse movement to simulate camera movement
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, event -> moveCamera(event.getX(), event.getY()));
        ;
    }

    private void moveCamera(double mouseX, double mouseY) {
        if (mouseX <= 10) {
            // Move the view to the left
            if (root.getTranslateX() < 0) {
                root.setTranslateX(root.getTranslateX() + objectSpeed);
            }
        } else if (mouseX >= SCENE_WIDTH - 10) {
            // Move the view to the right
            if (root.getTranslateX() > SCENE_WIDTH - BACKGROUND_WIDTH) {
                root.setTranslateX(root.getTranslateX() - objectSpeed);
            }
           
        }
        System.out.println("TranslateX root " + root.getTranslateX()+" | TranslatyY root" + root.getTranslateY());
        System.out.println(root.getWidth()+" | "+root.getHeight());
    }

   /* private void moveObject() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(4), movingObject);
        transition.setToX(BACKGROUND_WIDTH - OBJECT_SIZE); // Move to the bottom of the background
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }*/
    
    private void moveObject() {
    	
    	//movingObject.setX(movingObject.getX()+20);
    	if (movingObject.getX()>1000) {movingObject.setX(movingObject.getX()-20);}
    	else {movingObject.setX(movingObject.getX()+20);}
    	System.out.println(movingObject.getX());
    }
    
   
       

    
    public static void main(String[] args) {
        launch(args);
    }
}
