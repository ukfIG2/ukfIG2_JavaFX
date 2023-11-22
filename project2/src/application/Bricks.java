package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Bricks extends ImageView {
    public Bricks(int row, int col,int marginL, int marginT) {
        super();
        Image image1 = new Image(getClass().getResourceAsStream("/resources/bricks.png"), 100,100,false,false);
        setImage(image1);
        setFitWidth(40);
        setFitHeight(40);
        setPreserveRatio(false);
        setLayoutX(marginL+col*40);
        setLayoutY(marginT+row*40);
    }
}