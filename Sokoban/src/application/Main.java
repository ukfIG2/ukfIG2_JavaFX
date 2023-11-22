package application;
	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Main extends Application {
	private int block_size = 64;
    private int map_height = 1; //pocet riadkov
    private int map_width;  //pocet stlpcov
    
	///////////////////////////////////////////////////////////////
	////KED STLACIS V HRE R, TAK SA VRATIS O KROK DOZADU
	/////////////////////////////////////////////////////////////////	
    
	private String level = "/levels/level1";   // PREPIS level1 NA level2 PRE ZMENU LEVELU
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			/////////////////////////////////////
			//nacitanie velkosti pola
			try {
			    URL resource = Game.class.getResource(level);
			    String filePath = resource.getPath();
			    BufferedReader reader = new BufferedReader(new FileReader(filePath));

			    String riadok = reader.readLine();
	            map_width = riadok.split("").length;
	            
	            while ((riadok = reader.readLine()) != null) {
	            	String[] check = riadok.split("");
	            	 if(check.length == map_width) {
	            		 map_height++;
	            	 }	
	            }

	            
			    reader.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}

			
			new Game(root, map_width, map_height, level);
	
			////////////////////////////////////
			Scene scene = new Scene(root,block_size * map_width, block_size * map_height);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
