package _00.Prve_Aplikacie;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class _02_Obytna_cast extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		Group root = new Group();
		Scene scene = new Scene(root, 600, 400); 
		
		scene.setFill(Color.WHITE);
		
		Rectangle dom = new Rectangle(100, 100, 200, 200);
		dom.setFill(Color.BLUE);
		
		Polygon strecha = new Polygon();
		strecha.getPoints().addAll(
				new Double[] {100.0,100.0, 300.0,100.0, 200.0,25.0});
		strecha.setFill(Color.RED);
		
		Line plot1 = new Line(300,190, 500,190);
		Line plot2 = new Line(300,290, 500,290);
		
		Line lata;
		for(int i=300;	i<=500;	i+=10) {
			lata = new Line(i,180, i,300);
			root.getChildren().add(lata);
		}
		
		Text text = new Text(125, 350, "Gábriš Ivan");
		text.setFont(new Font("Tahoma",25));
		text.setStroke(Color.GREEN);
		text.setFill(Color.RED);
		
		root.getChildren().addAll(dom,strecha,plot1,plot2,text);
				
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
