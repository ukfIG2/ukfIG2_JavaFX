package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Box extends ImageView {
	private int row, col;
    public Box(int row, int col, int marginL, int marginT) {
        super();
        this.row = row;
        this.col = col;
        Image image1 = new Image(getClass().getResourceAsStream("/resources/box.png"), 100,100,false,false);
        setImage(image1);
        setFitWidth(40);
        setFitHeight(40);
        setPreserveRatio(false);
        setLayoutX(marginL+col*40);
        setLayoutY(marginT+row*40);
    }
    public void madeGreen() {
    	Image image1 = new Image(getClass().getResourceAsStream("/resources/green_box.png"), 100,100,false,false);
        setImage(image1);
    }
    public void unmadeGreen() {
    	Image image1 = new Image(getClass().getResourceAsStream("/resources/box.png"), 100,100,false,false);
        setImage(image1);
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}