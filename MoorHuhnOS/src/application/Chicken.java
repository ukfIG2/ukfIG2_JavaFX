package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Chicken extends ImageView {
	
	private Image[] chicken;
    private Image dead;
    double maxWidth;
    double maxHeight;
    int activeImage=0;
    int rychlost = 40;
    boolean lavo;
    int stav = 0;
    private Timeline t;
    private Timeline animation;
    
    public Chicken(String chickensprite, int spritenumber, double w, double h, double maxw, double maxh, boolean lavo ){
        super();
        maxWidth = maxw;
        maxHeight = 700;
        this.lavo = lavo;
        if (lavo) {
            setLayoutX(1200);
        } else {
            setLayoutX(1);
        }
        setLayoutY(100 + (int) (Math.random() * maxHeight));
        chicken = new Image[spritenumber];

        if (lavo) {
            for (int i = 0; i < spritenumber; i++) {
                chicken[i] = new Image(chickensprite + i + "lavo.png", w, h, false, false);
            }
        } else {
            for (int i = 0; i < spritenumber; i++) {
                chicken[i] = new Image(chickensprite + i + ".png", w, h, false, false);
            }
        }
        setImage(chicken[0]);
        t = new Timeline(new KeyFrame(Duration.millis(Math.random()*rychlost), actionEvent -> pohyb()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();


        dead = new Image("dead.png", w, h, false, false);
        setOnMouseClicked(mouseEvent -> {
            hit();
            Score.kill();
        });
        vykresli();
        animation = new Timeline(new KeyFrame(Duration.seconds(0.1),actionEvent -> vykresli() ));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
    
    private void nextImage(){
        activeImage = (activeImage + 1) % 5;
    }
    
    private void pohyb() {
    	if (lavo) {
            if (getLayoutX() < 1) {
                stav = 2;
                vykresli();
            } else {
                setLayoutX(getLayoutX() - 5);
            }
        } else {
            if (getLayoutX() > 1200) {
                stav = 2;
                vykresli();
            } else {
                setLayoutX(getLayoutX() + 5);
            }
        }

        if(stav ==1){
            setLayoutY(getLayoutY()+10);
        }
    }
    
    private void vykresli() {
        nextImage();
        if (stav == 0) setImage(chicken[activeImage]);
        if (stav == 1) setImage(dead);
        if (stav == 2) setImage(null);
    }
    
    private void hit() {
        stav = 1;
        pohyb();
        vykresli();
    }
    
    public double getStav() {
        return stav ;
    }

}
