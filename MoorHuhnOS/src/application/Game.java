package application;

import java.util.LinkedList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Game extends Group {
	
	private ImageView pozadie;
	private LinkedList<Chicken> chickenlist;
	private Timeline t;
    private Timer casovac;
    final int size = 100;
    final int maxChicken = 160;
    private double maxWidth, maxHeight;
    private Score score ;
    private Gun shotgun;
    
    public Game(int w, int h, String background) {
        maxWidth = w;
        maxHeight = h;
        Image bg = new Image(background, w, h, false, false);
        pozadie = new ImageView(bg);
        getChildren().add(pozadie);
        casovac = new Timer(60);
        shotgun = new Gun(5);
        score = new Score(0);
        getChildren().addAll(casovac,shotgun,score);
        chickenlist = new LinkedList<>();
        t = new Timeline(new KeyFrame(Duration.seconds(0.5), actionEvent -> spawnChicken()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        removeChicken();
        setOnMouseClicked(mouseEvent -> {
            shotgun.shot();
            //shotgun.vystrel();
        });
    }
    
    private void spawnChicken() {
        if (chickenlist.size() < maxChicken) {
            boolean lavo = false;
            if (Math.random() > 0.5) {
                lavo = true;
            }

            Chicken ch = new Chicken("sliepka", 5, size, size, maxWidth, maxHeight, lavo);
            chickenlist.add(ch); 
            getChildren().add(ch); 
        }

    }
    
    private void removeChicken() {
    	for(int i = 0;i < chickenlist.size(); i++){
            Chicken prvok = chickenlist.get(i);
            if (prvok.getStav() == 2) {
                chickenlist.remove(i); 		   
                getChildren().remove(prvok); 
            }
        }
    }

}
