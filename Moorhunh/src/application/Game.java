package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Game extends Group {
	
	final int SPRITESIZE = 30;
    final int MAXBIRD = 10;
    private ImageView background;
    private ArrayList<Bird> array;
    private double maxWidth, maxHeight;
    private boolean end = false;
    private Text text1 = new Text("Score: 0");
    private Text text2 = new Text("Ammo: 0");
    private int score;
    private int ammo = 6;
    private boolean hasAmmo = true;
        
    public Game(int w, int h, String back, int enem) {
       maxWidth = w; maxHeight = h;
       Image bg = new Image(back, w, h, false, false);
       background = new ImageView(bg);
       array = new ArrayList<>();
       
       text1.setText("Score: " + score);
       text1.setLayoutX(20);
       text1.setLayoutY(20);
       text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
       text2.setText("Ammo: " + ammo);
       text2.setLayoutX(w - 120);
       text2.setLayoutY(20);
       text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
       getChildren().addAll(background, text1, text2); 
       
       setOnMousePressed(evt -> onClick());
       setOnKeyPressed(evt -> process(evt));
       setFocusTraversable(true);
       requestFocus();
    }
    
    public void onClick() {
    	if (ammo > 0) {
    		ammo --;
    		if (ammo == 0) hasAmmo = false;
    	}
    	text2.setText("Ammo: " + ammo);
    	if (!hasAmmo) text2.setText("Ammo: " + ammo + "\nReload!");
    }
    
    public void process(KeyEvent evt) {
		KeyCode k = evt.getCode();
		if (k == KeyCode.SPACE) reload();
		text2.setText("Ammo: " + ammo);
	}
    
    public void reload() {
    	ammo = 6;
    	hasAmmo = true;
    }
    
    public boolean checkAmmo() {
    	return hasAmmo;
    }

    public void update(double deltaTime) {
        newBird();
        process(deltaTime/1000000000);
          deleteBird();
        updateScene();
   }
    
    private void updateScene() {
		// TODO Auto-generated method stub
	}

	private void newBird() {
    	   if (array.size() < MAXBIRD)
    		   if (Math.random() < 0.3) {
    			   Bird mine = new Bird("bird", 8, maxWidth, maxHeight, 74, 72);
    			   array.add(mine);
    			   getChildren().add(mine);
    		   }
    }
    
    private void process(double delta) {
    	  for(int i = 0;i < array.size(); i++){                             
    	     Bird element = (Bird)(array.get(i));
    	     element.change(delta);
    	     element.canBeShot(hasAmmo);
    	     if (element.state == 1) {
     			score += element.giveValue();
     		}
    	    text1.setText("Score: " + score);
    	  }
    }
    
    private void deleteBird() {
    	  for(int i = 0; i < array.size(); i++){                               
    	    Bird prvok = array.get(i);
    	    if (prvok.getStav() == 2) {
    	        array.remove(i);
    	        getChildren().remove(prvok);
    	    }
    	 } 
    }

	public boolean getEnd() {
		return end;

	}
	
}
