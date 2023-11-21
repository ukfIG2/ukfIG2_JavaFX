package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Text scoreText = new Text(10, 20, "Score: 0");
        scoreText.setLayoutX(900);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Text ammo = new Text(10, 40, "Ammo: 6");
        ammo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        ammo.setLayoutX(900);
        Text time = new Text(10,20,"Time left:");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        time.setLayoutX(400);
        Game g = new Game(1024, 500, "pozadie.jpg", scoreText, ammo, time);
        Button reload = new Button("Reload");
        reload.setPrefWidth(200);
        reload.setPrefHeight(50);
        reload.setOnAction(e -> g.reload());
        reload.setLayoutX(400);
        reload.setLayoutY(450);

        root.getChildren().addAll(g, scoreText, ammo,reload,time);

        Scene scene = new Scene(root, 1024, 500);
        scene.setOnMouseEntered(e -> scene.setCursor(Cursor.CROSSHAIR) );
        stage.setScene(scene);
        stage.show();
        MyTimer t = new MyTimer(g);
        t.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
