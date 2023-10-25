package application;




import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class Tree extends Drv{
	
    
    
	private double x;
	private double y;
	private double currentSize = 10;  
	private double growthRate = 0.5;
	private int state = 0; 
	private int maxStates = 5;

		public Tree(double x, double y) {
			super(0, 0);
			this.x=x;
			this.y=y;
			setLayoutX(this.x);
		    setLayoutY(this.y);
		    startGrowing();
		}

		public void startGrowing() {
	        AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	                currentSize += growthRate;
	                drawTree();
	                if (currentSize >= 30) {
	                    currentSize = 10;
	                    state++;
	                    if (state == maxStates) {
	                        state = 0; 
	                    }
	                }
	                
	            }
	        };
	        timer.start();
	    }
		private void drawTree() {
	        gc.clearRect(0, 0, getWidth(), getHeight());

	        if (state == 0) {
	        	double trunkHeight = currentSize * 2;
	            double trunkWidth = currentSize / 2;
	        	gc.setFill(Color.BROWN);
	            gc.fillRect((getWidth() - trunkWidth + 10) / 2, getHeight() - trunkHeight, trunkWidth, trunkHeight);
	            gc.setFill(Color.GREEN);
	            gc.fillOval((getWidth() - currentSize - 10) / 2, getHeight() - trunkHeight - currentSize, 50, 50);
	        } else if (state == 1) {
	        	double trunkHeight = 70;
	            double trunkWidth = 15;
	            double trunkHeight1 = (currentSize + 40) * 2 -5;
	        	gc.setFill(Color.BROWN);
	        	gc.fillRect((getWidth() - trunkWidth) / 2, getHeight() - trunkHeight, trunkWidth, trunkHeight);
	        	gc.setFill(Color.GREEN);
	            gc.fillOval(75, getHeight()- trunkHeight1, 50, 50);
	            gc.fillOval(65, getHeight()- trunkHeight1 +20, 50, 50);
	            gc.fillOval(85, getHeight()- trunkHeight1 +20, 50, 50);
	        } else if (state == 2) {
	            double trunkWidth = currentSize  / 2;
	            double trunkWidth1 = currentSize  ;
	            double trunkWidth2 = currentSize /4;
	        	gc.setFill(Color.BROWN);
	        	gc.fillRect(95, 100, trunkWidth + 10, 150);
	        	gc.setFill(Color.GREEN);
	            gc.fillOval(65 -trunkWidth2, 60- trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(65-trunkWidth2, 80- trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(85-trunkWidth2, 80 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(85-trunkWidth2, 60 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	        } else if (state == 3) {
	        	double trunkWidth = currentSize  / 2;
	        	double trunkWidth2 = currentSize /4;
	        	double trunkWidth1 = currentSize  ;
	        	gc.setFill(Color.BROWN);
	        	gc.fillRect(95, 100, 25, 150);
	        	gc.setFill(Color.GREEN);
	            gc.fillOval(57-trunkWidth2, 80- trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(100-trunkWidth2, 80 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(57-trunkWidth2, 50- trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(100-trunkWidth2, 50 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(85-trunkWidth2, 30 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	        } else if (state == 4) {
	        	double trunkWidth = currentSize  / 2;
	        	double trunkWidth2 = currentSize /4;
	        	double trunkWidth1 = currentSize  ;
	        	gc.setFill(Color.BROWN);
	        	gc.fillRect(95, 100, trunkWidth +  25, 150);
	        	gc.setFill(Color.GREEN);
	            gc.fillOval(50-trunkWidth2, 75- trunkWidth,trunkWidth1+ 70,trunkWidth1+ 70);
	            gc.fillOval(95-trunkWidth2, 75 - trunkWidth,trunkWidth1+ 70,trunkWidth1+ 70);
	            gc.fillOval(50-trunkWidth2, 45- trunkWidth,trunkWidth1+ 70,trunkWidth1+ 70);
	            gc.fillOval(95-trunkWidth2, 45 - trunkWidth,trunkWidth1+ 70,trunkWidth1+ 70);
	            gc.fillOval(80-trunkWidth2, 25 - trunkWidth,trunkWidth1+ 70,trunkWidth1+ 70);
	            gc.fillOval(30-trunkWidth2, 60 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(130-trunkWidth2, 60 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(120-trunkWidth2, 25 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	            gc.fillOval(50-trunkWidth2, 25 - trunkWidth,trunkWidth1+ 50,trunkWidth1+ 50);
	        }
	    }
	 
}
