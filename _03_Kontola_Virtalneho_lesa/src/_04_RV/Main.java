package application;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Button buttonTree = new Button("Pridať strom");
        Button buttonFlower = new Button("Pridať kvet");
        Button buttonBush = new Button("Pridať krík");

        
        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(buttonTree, buttonFlower, buttonBush);
        Tree tr = new Tree(0,0);
        
        buttonTree.setOnAction(evt -> tr.pridajObjekt(pane));
        
        buttonFlower.setOnAction(evt -> tr.pridajObjekt1(pane));
        
        buttonBush.setOnAction(evt -> tr.pridajObjekt2(pane));
        
        pane.getChildren().addAll(buttonBox);
        Scene scene = new Scene(pane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

}