package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class square extends ImageView {
	
	public square (String URI,int x, int y,Group root)
	{
		super();
		
		Image im = new Image(URI, 30, 30, false, false);
	 	
 setLayoutX(x);
	    setLayoutY(y);
		  setImage(im);	
		  System.out.println(getLayoutX());
	  // ImageView imag = new ImageView(img);
	
	 // root.getChildren().add(im);
	  
	}
	public void up ()
	{
		
	}
	public void down ()
	{
		
	}
	public void left ()
	{
		
	}
	public void right ()
	{
		
	}

}
