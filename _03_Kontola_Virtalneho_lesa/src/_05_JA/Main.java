package application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			Group root = new Group();
			Scene scene = new Scene(root,900,700);
			VBox tlacidla=new VBox(10);
			
			Button b1= new Button("Strom");
			Button b2= new Button("Krik");
			Button b3= new Button("Kvet");
			b1.setOnAction(e->Strom(root));
			b2.setOnAction(e->Krik(root));
			b3.setOnAction(e->Kvet(root));
			tlacidla.getChildren().addAll(b1,b2,b3);
			root.getChildren().addAll(tlacidla);
			
			primaryStage.setScene(scene);
			primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		private void Strom(Group root){
		int x=(int)(40+Math.random()*800); int y=(int)(40+Math.random()*600);
		strom strom=new strom(x,y);
		root.getChildren().add(strom);
	}
		private void Krik(Group root){
		int x=(int)(40+Math.random()*800);
		int y=(int)(40+Math.random()*600);
		krik Krik=new krik(x,y);
		root.getChildren().add(Krik);
	}
	
		private void Kvet(Group root){
		int x=(int)(20+Math.random()*580);
		int y=(int)(20+Math.random()*550);
		kvet Kvetina=new kvet(x,y);
		root.getChildren().add(Kvetina);
	}
	
	
	
}
