package _15_Virtualny_svet_2_Prezentacia._17VirtualnySvet02_focus.src.main.java.com.example._17virtualnysvet02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        HBox tlacidla = new HBox(10);
        Button b1 = new Button("Pridaj");
        tlacidla.getChildren().addAll(b1);
        b1.setOnAction(evt -> pridajObjekt(root));
        root.getChildren().add(tlacidla);

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void pridajObjekt(Group root) {
        int y = (int)(Math.random() * 200 + 10);
        if (y > 160) {
            Bicykel b = new Bicykel((int)(Math.random() * 200 + 50),
                    y, -10+(int)(Math.random()*21),
                    Color.RED);
            root.getChildren().add(b);
        } else if (y > 80) {
            Lod l = new Lod((int)(Math.random()*200 + 50), y,
                    -10+(int)(Math.random()*21),Color.BLUE);
            root.getChildren().add(l);
        } else {
            Auto a = new Auto((int)(Math.random()*200 + 50), y,
                    -10+(int)(Math.random()*21),Color.CYAN);
            root.getChildren().add(a);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}