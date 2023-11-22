package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spot extends ImageView {
    private int row, col;

    public Spot(int row, int col, int marginL, int marginR) {
        super();
        this.row = row;
        this.col = col;

        Image image1 = new Image(getClass().getResourceAsStream("/resources/spot.png"), 100, 100, false, false);
        setImage(image1);
        setFitWidth(40);
        setFitHeight(40);
        setPreserveRatio(false);
        setLayoutX(marginL + col * 40);
        setLayoutY(marginR + row * 40);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
