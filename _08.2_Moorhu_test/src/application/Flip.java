package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Flip extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Load the image
        Image originalImage = new Image("ammo.gif"); // Replace with the path to your image
        ImageView imageView = new ImageView(originalImage);

        // Create a StackPane to hold the image
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        // Create the scene
        Scene scene = new Scene(root, 300, 250);

        // Set up the stage
        primaryStage.setTitle("Image Flip Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Flip the image horizontally
        flipImageHorizontally(imageView);
    }

    private void flipImageHorizontally(ImageView imageView) {
        // Flip the image horizontally
        imageView.setScaleX(-1);
    }
}
