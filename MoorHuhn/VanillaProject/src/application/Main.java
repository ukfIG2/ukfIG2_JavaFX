package application;
	
import java.io.File;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {
	Group root = new Group();
	Canvas canvas = new Canvas(600, 60);
	Game game = new Game(600,600,"pozadie4.jpg");
	
	GraphicsContext gc = canvas.getGraphicsContext2D();
	@Override
	public void start(Stage primaryStage) {
		try {
			

			primaryStage.setTitle("Menu Screen");

	        
	        TextArea rulesTextArea = new TextArea();
	        rulesTextArea.setEditable(false);
	        rulesTextArea.setWrapText(true);
	        rulesTextArea.setPrefRowCount(11);
	        rulesTextArea.setText( "V tejto hre mame stage a skore "
	        		+ "cim vyssi stage tym rychlejsie sa budu objekty hybat\n"
	        		+ "ak objekt preleti za okraj tak sa odpocitava skore\n"
	        		+ "ak objekt trafite pripocitava sa skore\n"
	        		+ " hra trva az dokym skore nie je mensie ako 0\n"
	        		+ "cielom hry je mat co najvacsi stage\n"+
	                "1. Zasiahnuty papagaj = +20 skore\n" +
	                "2. Nezasiahnuty papagaj = -20 skore\n" +
	                "3. Zasiahnuty vtak = +10 skore\n" +
	                "4. Nezasiahnuty vtak = -10 skore\n" +
	                "5. Zasiahnuta kacka = +100 skore\n" +
	                "6. Prebitie = R\n" 
	                
	        );

	      
	        Button playButton = new Button("Play");
	        playButton.setOnAction(e -> startApp(primaryStage));

	       
	        VBox layout = new VBox(20);
	        layout.getChildren().addAll(rulesTextArea, playButton);

	      
	        Scene scene = new Scene(layout, 500, 400);
	        primaryStage.setScene(scene);

	        primaryStage.show();
			
			
			
			
			
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void startApp(Stage primaryStage) {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root,600,600);
	
		root.getChildren().addAll(game,canvas);
		
		Image zbran = new Image("zbranupravena.png", 250,250,false,false);
		ImageView zb = new ImageView(zbran);
		
		zb.setY(350);
		zb.setX(250);
		MyTimer timer = new MyTimer(game);
		timer.start();
		
		 Timeline timeline = new Timeline(new KeyFrame(
	             Duration.millis(100), 
	             event -> updateText() 
	         ));
	         timeline.setCycleCount(Timeline.INDEFINITE); 
	         timeline.play();
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	private void updateText() {

        int skore = game.getSkore();
        
        int stage = (int)game.getStage()/10 ;
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 
        gc.setFont(javafx.scene.text.Font.font(10));
        gc.setFill(Color.WHITE);
        gc.fillText("Zasiahnuty papagaj = +20 skore", 440, 10); 
        gc.fillText("Nezasiahnuty papagaj = -20 skore" , 440, 20); 
        gc.fillText("Zasiahnuty vtak = +10 skore" , 440, 30); 
        gc.fillText("Nezasiahnuty vtak = -10 skore", 440, 40); 
        gc.fillText("Zasiahnuta kacka = +100 skore", 440, 50); 
        gc.fillText("Prebitie = R", 440, 60);
        gc.setFont(javafx.scene.text.Font.font(20));
        gc.fillText("STAGE " + stage, 10, 20); 
        gc.fillText("Tvoje skore je " + skore, 10, 40);
        
        if(game.stavHry()) {
        	
        	System.out.println("Hra skoncila uz ti neostali body do dalsieho kola");
        	System.out.println("Dostal si sa do " + stage + " kola");
        	javafx.application.Platform.exit();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
