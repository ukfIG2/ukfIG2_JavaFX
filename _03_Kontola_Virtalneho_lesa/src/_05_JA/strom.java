package _05_JA;
import javafx.scene.paint.Color;


public class strom extends rastlina {

	public strom(int x, int y) {
		super(x, y);
		
	}
	
	protected void vykresli(){		
		switch (velkost) {
	    case 0:
	        gc.setFill(Color.BROWN);
	        gc.fillRect(14, 50, 20, 40);
	        break;
	    case 1:
	    	gc.setFill(Color.BROWN);
	    	gc.fillRect(14,30,20,60);
	    	
	    	break;
	    case 2:
	    	gc.setFill(Color.BROWN);
	    	gc.fillRect(14,30,20,60);
	    	gc.setFill(Color.DARKGREEN);
	    	gc.fillOval(9,10,30,30);
	    	break;
	    case 3:
	    	gc.setFill(Color.BROWN);
	    	gc.fillRect(14,30,20,60);
	    	gc.setFill(Color.DARKGREEN);
	    	gc.fillOval(5,8,40,40);
	    	break;
	    case 4:
	    	gc.setFill(Color.BROWN);
	    	gc.fillRect(14,30,20,60);
	    	gc.setFill(Color.DARKGREEN);
	    	gc.fillOval(3,6,50,50);
	    	break; 	
	    	


	}
	

}
}
