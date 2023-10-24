package _11_Animacia_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplikacia_oblak extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        HBox tlacidla = new HBox(10);
        Button b1 = new Button("štartuj");
        tlacidla.getChildren().addAll(b1);

        Oblak obl = new Oblak(root);
        b1.setOnAction(evt -> obl.startuj());

        root.getChildren().addAll(tlacidla,obl);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}