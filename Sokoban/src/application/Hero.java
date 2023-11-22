package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Hero extends Group {
	ImageView pc;
	
	public Hero(int pos_x, int pos_y, Group root, boolean endpoint) {
		if(endpoint) new Endpoint(pos_x, pos_y, root);
		else new Ground(pos_x, pos_y, root);
		Image img = new Image("images/player_23.png");
		pc = new ImageView(img);
		pc.setLayoutX(pos_x);
		pc.setLayoutY(pos_y);
		root.getChildren().addAll(pc);

	}
	
	

}
