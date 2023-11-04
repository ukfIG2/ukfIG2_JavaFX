package com.example.jablko;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        VBox tlacidla = new VBox();
        Button b1 = new Button("Nove jablko");
        Button b2 = new Button("posun");
        tlacidla.getChildren().addAll(b1,b2);
        root.getChildren().add(tlacidla);
        b1.setOnAction(e->{Jablko j = new Jablko(); root.getChildren().add(j);});
        b2.setOnAction(e->posunJablka());
        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    void posunJablka() {

    }

    public static void main(String[] args) {
        launch();
    }
}