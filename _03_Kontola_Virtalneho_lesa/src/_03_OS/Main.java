package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group  root = new Group();

	        VBox buttons = new VBox(5);

	        Button strom = new Button("Storm");
	        Button kvet = new Button("Kvet");
	        Button krik = new Button("Krik");
	        buttons.getChildren().addAll(strom,kvet,krik);
			
	        strom.setOnAction(e -> pridajStrom(root));
	        kvet.setOnAction(e -> pridajKvet(root));
	        krik.setOnAction(e -> pridajKrik(root));

	        root.getChildren().add(buttons);

			
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("Virtualny les");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void pridajStrom(Group root){
        Strom a = new Strom((int)(100+Math.random()*400),(int)(50+Math.random()*250));
        root.getChildren().add(a);
    }
    private void pridajKvet(Group root){
        Kvet b = new Kvet((int)(100+Math.random()*400),(int)(50+Math.random()*250));
        root.getChildren().add(b);
    }
    private void pridajKrik(Group root){
        Krik c = new Krik((int)(100+Math.random()*400),(int)(50+Math.random()*250));
        root.getChildren().add(c);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
