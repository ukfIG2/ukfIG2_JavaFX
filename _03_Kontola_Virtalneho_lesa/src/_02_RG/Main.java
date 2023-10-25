package application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
	Balon b;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox buttony = new VBox(10);
		Button strom = new Button("Strom");
		Button krik = new Button("Krík");
		Button kvet = new Button("Kvet");
		buttony.getChildren().addAll(strom,krik,kvet);
		Group root = new Group();
		Scene scene = new Scene(root,500,500);
		scene.setFill(Color.BISQUE);
		
		 strom.setOnAction(e -> {
				Strom s = new Strom(1, Color.GREEN);
				root.getChildren().addAll(s);
	        });
		 krik.setOnAction(e -> {
				Krik s = new Krik(1, Color.LIME);
				root.getChildren().addAll(s);
	        });
		 kvet.setOnAction(e -> {
				Kvet s = new Kvet(1, Color.RED);
				root.getChildren().addAll(s);
	        });
		
		
		
		root.getChildren().addAll(buttony);
		primaryStage.setTitle("Les");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    public static void main(String[] args) {
        launch(args);
    }

    
}

