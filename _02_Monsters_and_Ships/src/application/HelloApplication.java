package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Game g = new Game(1024, 500, "pozadie.png", 10);
        root.getChildren().add(g);

        Scene scene = new Scene(root, 1024, 500);
        stage.setScene(scene);
        stage.show();
        MyTimer t = new MyTimer(g);
        t.start();
    }

    public static void main(String[] args) {
        launch();
    }
}