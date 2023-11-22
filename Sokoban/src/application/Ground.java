package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ground {
	ImageView pc;
	
	public Ground(int pos_x, int pos_y, Group root) {
		Image img = new Image("images/ground_06.png");
		pc = new ImageView(img);
		pc.setLayoutX(pos_x);
		pc.setLayoutY(pos_y);
		root.getChildren().addAll(pc);
	}
}
