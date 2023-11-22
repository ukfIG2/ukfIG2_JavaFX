package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Game extends Group {
    private String riadok;
    private Hero h;
    private String level;
    Group root;
    private int pocet_krabic;
    private int hero_pos_y;
    private int hero_pos_x;
    private int[][] end_poz;
    private String[][] map;
    private String[] check;
    private int map_height; //pocet riadkov
    private int map_width;  //pocet stlpcov
    private ArrayList<Save_map> moves; 
    
    public Game(Group root, int map_width, int map_height, String level) {
    	this.root = root;
    	this.map_height = map_height;
    	this.map_width = map_width;
    	this.level = level;
    	moves = new ArrayList<>();
    	nacitaj_level();
    	vykresli_mapu();
    	h.setOnKeyPressed(e -> pohyb(e));
    	h.setFocusTraversable(true);

    }
    
    private void pohyb(KeyEvent e) {
	    KeyCode key = e.getCode();
	    
	    if(key == KeyCode.R) {
	    	if(moves.size() > 1) {
	    	map = moves.get(moves.size()-1).getMap();
	    	moves.remove(moves.size()-1);
	    	}
	    	
	    	vykresli_mapu();
	    }else if (key == KeyCode.UP && !(map[hero_pos_y-1][hero_pos_x].equals("X"))) {
	    	uloz_tah();
	    	if(map[hero_pos_y-1][hero_pos_x].equals("B")  || map[hero_pos_y-1][hero_pos_x].equals("S")) {
	    		if(map[hero_pos_y-2][hero_pos_x].equals("N")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y-1][hero_pos_x] = "H";
	    			if(end_poz[hero_pos_y-2][hero_pos_x] == 1) map[hero_pos_y-2][hero_pos_x] = "S";
	    			else map[hero_pos_y-2][hero_pos_x] = "B";
	    		}else if(map[hero_pos_y-2][hero_pos_x].equals("E")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y-1][hero_pos_x] = "H";
	    			map[hero_pos_y-2][hero_pos_x] = "S";
	    		}
	    	}else{
	    		map[hero_pos_y][hero_pos_x] = "N";
    			map[hero_pos_y- 1][hero_pos_x] = "H";
	    	}
	    } else if (key == KeyCode.DOWN && !(map[hero_pos_y+1][hero_pos_x].equals("X"))) { 
	    	uloz_tah();
	    	if(map[hero_pos_y+1][hero_pos_x].equals("B") || map[hero_pos_y+1][hero_pos_x].equals("S")) {
	    		if(map[hero_pos_y+2][hero_pos_x].equals("N")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y+1][hero_pos_x] = "H";
	    			if(end_poz[hero_pos_y+2][hero_pos_x] == 1) map[hero_pos_y+2][hero_pos_x] = "S";
	    			else map[hero_pos_y+2][hero_pos_x] = "B";
	    		}else if(map[hero_pos_y+2][hero_pos_x].equals("E")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y+1][hero_pos_x] = "H";
	    			map[hero_pos_y+2][hero_pos_x] = "S";
	    		}
	    	}else{
	    		map[hero_pos_y][hero_pos_x] = "N";
    			map[hero_pos_y+1][hero_pos_x] = "H";
	    	}
	    	
	    	
	    } else if (key == KeyCode.LEFT && !(map[hero_pos_y][hero_pos_x-1].equals("X"))) {
	    	uloz_tah();
	    	if(map[hero_pos_y][hero_pos_x-1].equals("B") || map[hero_pos_y][hero_pos_x-1].equals("S")) { // ak je krabica
	    		if(map[hero_pos_y][hero_pos_x-2].equals("N")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y][hero_pos_x-1] = "H";
	    			if(end_poz[hero_pos_y][hero_pos_x-2] == 1) map[hero_pos_y][hero_pos_x-2] = "S";
	    			else map[hero_pos_y][hero_pos_x-2] = "B";
	    		}else if(map[hero_pos_y][hero_pos_x-2].equals("E")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y][hero_pos_x-1] = "H";
	    			map[hero_pos_y][hero_pos_x-2] = "S";
	    		}
	    	}else{ 
	    		map[hero_pos_y][hero_pos_x] = "N";
    			map[hero_pos_y][hero_pos_x-1] = "H";
	    	}
	    }else if (key == KeyCode.RIGHT && !(map[hero_pos_y][hero_pos_x+1].equals("X"))) {
	    	uloz_tah();
	    	if(map[hero_pos_y][hero_pos_x+1].equals("B")  || map[hero_pos_y][hero_pos_x+1].equals("S")) { // ak je krabica
	    		if(map[hero_pos_y][hero_pos_x+2].equals("N")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y][hero_pos_x+1] = "H";
	    			if(end_poz[hero_pos_y][hero_pos_x+2] == 1) map[hero_pos_y][hero_pos_x+2] = "S";
	    			else map[hero_pos_y][hero_pos_x+2] = "B";
	    		}else if(map[hero_pos_y][hero_pos_x+2].equals("E")) {
	    			map[hero_pos_y][hero_pos_x] = "N";
	    			map[hero_pos_y][hero_pos_x+1] = "H";
	    			map[hero_pos_y][hero_pos_x+2] = "S";
	    		}
	    	}else{ 
	    		map[hero_pos_y][hero_pos_x] = "N";
    			map[hero_pos_y][hero_pos_x+1] = "H";
	    	}
	    }
	    
	    vykresli_mapu();
	}
    
    //funkcia ktora vykresli mapu
    private void vykresli_mapu() {
    	root.getChildren().removeAll();
    	int ulozene = 0;
		for(int i = 0; i < map_height; i++) {
			for(int j = 0; j < map_width; j++) {
				
			if(map[i][j].equals("X")) {
				
				new Wall(j*64, i*64, root);
				
			}else if(map[i][j].equals("H")) {	
				if(end_poz[i][j] == 1)  h = new Hero(j*64, i*64, root, true);
				else h = new Hero(j*64, i*64, root, false);		
				root.getChildren().add(h);
				hero_pos_y = i;
				hero_pos_x = j;
				
			}else if(map[i][j].equals("B")) {
				new Box(j*64, i*64, root);
				
			}else if(map[i][j].equals("E")) {
				new Endpoint(j*64, i*64, root);
				
			}else if(map[i][j].equals("S")) {
				ulozene++;
				new Stored_box(j*64, i*64, root);
				
			}else{
				if(end_poz[i][j] == 1) new Endpoint(j*64, i*64, root);
				else new Ground(j*64, i*64, root);
				
			}
			}
		}
		
		//ukonecnie hry, ked su krabice ulozene na mieste
		if(ulozene == pocet_krabic) {
			root.getChildren().clear();

		    Text gameOverText = new Text("Vyhral si!\nPocet tahov: " + moves.size());
		    gameOverText.setFill(Color.RED);
		    gameOverText.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		    gameOverText.setStyle("-fx-font-style: italic;");
		    gameOverText.setLayoutX(32*map_height - (gameOverText.getLayoutBounds().getWidth() / 2) - 64);
		    gameOverText.setLayoutY(32*map_width - gameOverText.getLayoutBounds().getHeight() / 2);
		    
		    Button button = new Button("Ukončiť hru");
		    button.setOnAction(e -> {
		        System.exit(0);
		    });


		    root.getChildren().addAll( gameOverText, button);
		}
		
	}

	//funkcia ktora nacita mapu zo suboru
    private void nacitaj_level() {
    	//NACITANIE SUBORU  
    	//N=NIC, X=STENA, H=HERO, B=BOX, E=ENDPOINT, S=STORED_BOX (N,X,H,B,E,S)
        try {
        	URL resource = Game.class.getResource(level);
	    	String filePath = resource.getPath();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

			map = new String[map_height][map_width];
			end_poz = new int[map_height][map_width];
			
					
			int line_counter = 0;
			
            while ((riadok = reader.readLine()) != null) {
            	
            	 check = riadok.split("");
            	 
            	 if(check.length == map_width) {
            	 map[line_counter] = riadok.split("");      
            	 line_counter++;	
            	 }	
            }

            moves.add(new Save_map(map, map_height, map_width));
          //cyklusi pre nacitanie endpointov do end_poz
			for(int i = 0; i < map_height; i++) {
				for(int j = 0; j < map_width; j++) {	
					if(map[i][j].equals("E") || map[i][j].equals("S")) {
						end_poz[i][j] = 1;
						pocet_krabic++;
					}
				}
			}
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //funkcia ktora uklada predchadzajuce tahy. 
    private void uloz_tah() {
    	moves.add(new Save_map(map, map_height, map_width));
    }
    
    
}
