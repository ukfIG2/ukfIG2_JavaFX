package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stored_box {
	ImageView pc;
	
	public Stored_box(int pos_x, int pos_y, Group root) {
		new Ground(pos_x, pos_y, root);
		Image img = new Image("images/crate_07.png");
		pc = new ImageView(img);
		pc.setLayoutX(pos_x);
		pc.setLayoutY(pos_y);
		root.getChildren().addAll(pc);
	}
	
}
