package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

	public static Text healthText = new Text(20,40, "Health: 3/3");
    public static Text scoreText = new Text(20, 40, "Score: 0");

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        VBox texts = new VBox();
        
        texts.getChildren().addAll(healthText, scoreText);
        
        Game g = new Game(1024, 500, "pozadie.png", 10);
        
        root.getChildren().addAll(g, texts);

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