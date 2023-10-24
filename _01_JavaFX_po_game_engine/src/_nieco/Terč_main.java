package _nieco;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Terč_main extends Application {

@Override
public void start(Stage primaryStage) {
// Create the center circle
	int borer_width = 1;

Circle whiteCircle1 = new Circle(250, 250, 200);
whiteCircle1.setFill(Color.WHITE);
whiteCircle1.setStroke(Color.BLACK);
whiteCircle1.setStrokeWidth(borer_width);

Circle whiteCircle2 = new Circle(250, 250, 180);
whiteCircle2.setFill(Color.WHITE);
whiteCircle2.setStroke(Color.BLACK);
whiteCircle2.setStrokeWidth(borer_width);

Circle blackCircle1 = new Circle(250, 250, 160);
blackCircle1.setFill(Color.BLACK);
blackCircle1.setStroke(Color.WHITE);
blackCircle1.setStrokeWidth(borer_width);

Circle blackCircle2 = new Circle(250, 250, 140);
blackCircle2.setFill(Color.BLACK);
blackCircle2.setStroke(Color.WHITE);
blackCircle2.setStrokeWidth(borer_width);

Circle blueCircle1 = new Circle(250, 250, 120);
blueCircle1.setFill(Color.BLUE);
blueCircle1.setStroke(Color.BLACK);
blueCircle1.setStrokeWidth(borer_width);

Circle blueCircle2 = new Circle(250, 250, 100);
blueCircle2.setFill(Color.BLUE);
blueCircle2.setStroke(Color.BLACK);
blueCircle2.setStrokeWidth(borer_width);

Circle redCircle1 = new Circle(250, 250, 80);
redCircle1.setFill(Color.RED);
redCircle1.setStroke(Color.BLACK);
redCircle1.setStrokeWidth(borer_width);

Circle redCircle2 = new Circle(250, 250, 60);
redCircle2.setFill(Color.RED);
redCircle2.setStroke(Color.BLACK);
redCircle2.setStrokeWidth(borer_width);

Circle yelowCircle1 = new Circle(250, 250, 40);
yelowCircle1.setFill(Color.YELLOW);
yelowCircle1.setStroke(Color.BLACK);
yelowCircle1.setStrokeWidth(borer_width);

Circle yelowCircle2 = new Circle(250, 250, 20);
yelowCircle2.setFill(Color.YELLOW);
yelowCircle2.setStroke(Color.BLACK);
yelowCircle2.setStrokeWidth(borer_width);

Circle yelowCircle3 = new Circle(250, 250, 10);
yelowCircle3.setFill(Color.YELLOW);
yelowCircle3.setStroke(Color.BLACK);
yelowCircle3.setStrokeWidth(borer_width);

Text text = new Text("+");
text.setFont(Font.font("Arial",20));
text.setFill(Color.BLACK);
text.setTranslateX(244);
text.setTranslateY(257);

Text text2 = new Text("100");
text2.setFont(Font.font("Arial",10));
text2.setFill(Color.BLACK);
text2.setTranslateX(242);
text2.setTranslateY(225);

Text text3 = new Text("80");
text3.setFont(Font.font("Arial",10));
text3.setFill(Color.BLACK);
text3.setTranslateX(245);
text3.setTranslateY(185);

Text text4 = new Text("60");
text4.setFont(Font.font("Arial",10));
text4.setFill(Color.BLACK);
text4.setTranslateX(245);
text4.setTranslateY(145);

Text text5 = new Text("40");
text5.setFont(Font.font("Arial",10));
text5.setFill(Color.WHITE);
text5.setTranslateX(245);
text5.setTranslateY(105);

Text text6 = new Text("20");
text6.setFont(Font.font("Arial",10));
text6.setFill(Color.BLACK);
text6.setTranslateX(245);
text6.setTranslateY(65);

// Create a group and add the circles to it
Group group = new Group(whiteCircle1, whiteCircle2, blackCircle1, blackCircle2,
						blueCircle1, blueCircle2, redCircle1, redCircle2,
						yelowCircle1, yelowCircle2, yelowCircle3,
						text, text2, text3, text4, text5, text6);

// Create the scene and add the group to it
Scene scene = new Scene(group, 500, 500);

// Set the title of the stage and show the scene
primaryStage.setTitle("Circle Target");
primaryStage.setScene(scene);
primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}
}