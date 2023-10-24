package _16_Virtualny_svet_3_Prezentacia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
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
        Button b2 = new Button("Farba");
        Button b3 = new Button("Posun");
        tlacidla.getChildren().addAll(b1,b2,b3);
        b1.setOnAction(evt -> pridajObjekt(root));
        b2.setOnAction(evt -> zmenaFarby(root));
        b3.setOnAction(evt -> posunObjekty(root));

        root.getChildren().addAll(tlacidla);

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void zmenaFarby(Group root) {
        // prejdenm po zozname vsetkych prvkov v kontajneri
        for(int i = 0; i<root.getChildren().size(); i++) {
            // precitam i-ty prvok
            Node my = root.getChildren().get(i);
            if (my instanceof Lod) ((Lod)my).zmenaFarby(Color.RED);
        }
    }

    private void posunObjekty(Group root) {
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node my = root.getChildren().get(i);
            if (my instanceof DopravnyProstriedok)
                ((DopravnyProstriedok) my).posunHore();
        }
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