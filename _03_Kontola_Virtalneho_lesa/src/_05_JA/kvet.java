package application;

import javafx.scene.paint.Color;

public class kvet extends rastlina {

		public kvet(int x, int y) {
			super(x, y);
		}

		protected void vykresli(){
			switch(velkost){
			case 0:	
			gc.setFill(Color.YELLOW);
			gc.fillOval(40,20,20,40);
			break;
			case 1:
			gc.setFill(Color.YELLOW);
			gc.fillOval(40,20,20,40);	
			gc.fillOval(40,40,40,20);
			break;
			case 2:
				gc.setFill(Color.YELLOW);
				gc.fillOval(40,20,20,40);	
				gc.fillOval(40,40,40,20);	
				gc.fillOval(40,40,20,40);
			break;
			case 3:
				gc.setFill(Color.YELLOW);
				gc.fillOval(40,20,20,40);	
				gc.fillOval(40,40,40,20);	
				gc.fillOval(40,40,20,40);
				gc.fillOval(20, 40, 40, 20);
				break;
			case 4:
				gc.setFill(Color.YELLOW);
				gc.fillOval(40,20,20,40);	
				gc.fillOval(40,40,40,20);	
				gc.fillOval(40,40,20,40);
				gc.fillOval(20, 40, 40, 20);
			gc.setFill(Color.GREY);
			gc.fillOval(40,40,20,20);
				break;
			
			}
			
		}
		
}
