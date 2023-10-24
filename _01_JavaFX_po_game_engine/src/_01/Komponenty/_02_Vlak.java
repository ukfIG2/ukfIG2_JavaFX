package _01.Komponenty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class _02_Vlak extends Application{
	
	private void vozen(Group g,int x,int y,Color c) {
		  Rectangle r = new Rectangle(x,y,40,20);
		  r.setFill(c);
		  Circle c1 =new Circle(x+6,y+20,5); c1.setFill(Color.BLACK);
		  Circle c2 =new Circle(x+34,y+20,5);c2.setFill(Color.BLACK);
		  //g.getChildren().add(r);
		  g.getChildren().addAll(r,c1,c2);
	}
	
	private void lokomotiva(Group g, int x,int y,Color c) {
		   Rectangle ka = new Rectangle(x+20,y-10,20,10);
		   Rectangle ko = new Rectangle(x+5,y-15,6,15);
		       
		   ka.setFill(c);
		   ko.setFill(c);
		   ka.setFill(c);
		   ko.setFill(c);
		   vozen(g,x,y,c);
		   g.getChildren().addAll(ka,ko);
		}

	public void start(Stage primaryStage) throws Exception{
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		
		Button button = new Button("Vozne");
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for(int i=1;	i<=10;	i++) {
					if(i%2==0) {
					vozen(root,i*50+50, 100, Color.RED);
					} else {
					vozen(root,  i*50+50, 100, Color.BLUE);
					}}
					lokomotiva(root, 50, 100, Color.GREEN);
			}
			});
		
		
		primaryStage.setTitle("Vlacik");
		
		root.getChildren().addAll(button);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
