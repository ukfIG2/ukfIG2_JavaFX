package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MySprite extends ImageView {
	private Game game;
    private Image[] sprites;  // zoznam obrazkov
    private int smer = 0; // -1 - bez smeru, 0 - hore, 1 - dole, 2 - doprava, 3 - dolava
    private int actImage = 0;
    private double width, height;
    private double sceneWidth, sceneHeight;
    Timeline timeline;

    // zadavame nazov suborov s obrazkami, pocet obrazkov, polohu
    // v ramci hracej plochy a rozmery, na ktore sa obrazky upravia
    public MySprite(String nazov, int pocetSpritov, double xx,
                    double yy, double w, double h, Game game) {
        super(); width = w; height = h; // zapamatame si rozmery
        sceneWidth = xx; sceneHeight = yy;
        this.game = game;
        sprites = new Image[pocetSpritov]; // vytvorime pole
        // do kazdeho prvky pola vytvorime obrazok na zaklade udajov
        // zo suboru a nastavime mu velkost,
        for(int i = 0; i < pocetSpritov; i++) {
            sprites[i] = new Image(nazov+i+".png", w, h, false, false);
        }
        for(int i = 0; i < pocetSpritov; i++) {
            sprites[i] = new Image(nazov+i+".png", w, h, false, false);
        }
        setImage(sprites[0]);
        setLayoutX(xx);
        setLayoutY(yy);
        
        if (nazov == "monster")
        {
	        timeline = new Timeline(new KeyFrame(Duration.seconds(SetRandomTime()), evt -> Vystrel()));
	        timeline.setCycleCount(Animation.INDEFINITE);
	        timeline.play();
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public int getDirection() {
    	return smer;
    }
    public Game getCurrentGameScript() {
    	return game;
    }
    double SetRandomTime()
    {
    	double randomTime = 1 + Math.random() * 2;
    	return randomTime;
    }

    public void hore(double delta, double maxy) {
        setLayoutY(getLayoutY() - delta);
        if (getLayoutY() < 20) setLayoutY(maxy - 20);
        smer = 0;   vykresli();
    }

    public void dole(double delta, double maxy) {
        setLayoutY(getLayoutY() + delta);
        if (getLayoutY() > maxy - 20) setLayoutY(20);
        smer = 1;  vykresli();
    }

    public void dolava(double delta, double maxx) {
        setLayoutX(getLayoutX() - delta);
        if (getLayoutX() < 20) setLayoutX(maxx - 20);
        smer = 2;  vykresli();
    }

    public void doprava(double delta, double maxx) {
        setLayoutX(getLayoutX() + delta);
        if (getLayoutX() > maxx - 20) setLayoutX(20);
        smer = 3;  vykresli();
    }

    public boolean intersectsSprite(MySprite otherSprite) {
        double d1 = getLayoutX() - otherSprite.getLayoutX();
        double d2 = getLayoutY() - otherSprite.getLayoutY();
        if (((Math.abs(d1)<getWidth()) && Math.abs(d2)<getHeight()))
        return true;
           else
        return false;
    }
    public boolean intersectWithProjectile(ArrayList<Projectil> projectilles)
    {
    	if (!game.immortal)
    	{
	    	for (Projectil p : projectilles)
	    	{
	    		double d1 = getLayoutX() - p.getLayoutX();
	            double d2 = getLayoutY() - p.getLayoutY();
	            if (((Math.abs(d1)<getWidth()) && Math.abs(d2)<getHeight())) { p.DestroyGameObject();  return true; }
	    	}
    	}
    	return false;
    }

    public void nextImage(){
        if (smer == 0) actImage = (actImage + 1) % 2;
        if (smer == 1) actImage = 2+(actImage + 1) % 2;
        if (smer == 2) actImage = 4+(actImage + 1) % 2;
        if (smer == 3) actImage = 6+(actImage + 1) % 2;
    }

    private void vykresli() {
        nextImage();
        setImage(sprites[actImage]);
    }
    int position = 0;
    private void Vystrel()
    {
    	Projectil projectille = new Projectil(this);
    	game.projectilles.add(projectille);
    	game.getChildren().add(projectille);
    }
    public void StopTimeline()
    {
    	timeline.stop();
    }

}
