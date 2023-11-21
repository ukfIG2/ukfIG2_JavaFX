package application;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class MySprite extends ImageView {
    private Image[] sprites;
    private int smer = 0; 
    private int actImage = 0;
    private double width, height;
  
    
    public MySprite(String nazov, int pocetSpritov, double xx,
                    double yy, double w, double h, Game g) {
        super(); width = w; height = h; 
        sprites = new Image[pocetSpritov];
        
        
        for(int i = 0; i < pocetSpritov; i++) {
            sprites[i] = new Image(nazov+i+".png", w, h, false, false);
        }

        setImage(sprites[0]);
        setLayoutX(xx);
        setLayoutY(yy);
        
        setOnMouseClicked(event -> { //vymaz a pridaj body 
        	if (g.getAmmo()>0) {
        	
            if (event.getButton() == MouseButton.PRIMARY) {
            	g.getChildren().remove(this);
            	g.increaseScore(10);
            }};
        });
        
        
        
    }
    
    //--------------------------------------------------------------------------------
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

    
    public void nextImage() { //prehod psrite
        actImage = (actImage + 1) % 8;
    }
    
    private void vykresli() { 
        nextImage();
        Image currentImage = sprites[actImage];
        Image flippedImage = currentImage;
        if (direction == Direction.RIGHT) {
            flippedImage = new Image(currentImage.getUrl(), currentImage.getWidth(), currentImage.getHeight(), false, false);
            flippedImage = flipImageHorizontally(flippedImage);
        }
        setImage(flippedImage);
    }

    private Image flipImageHorizontally(Image image) { //otoc sprite
        ImageView imageView = new ImageView(image);
        imageView.setScaleX(-1);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage flippedImage = imageView.snapshot(params, null);
        return flippedImage;
    }

    public enum Direction {
        NONE, LEFT, RIGHT
    }
    
    private Direction direction = Direction.NONE;
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }

}
