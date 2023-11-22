package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tarakan extends ImageView {
	private String input = "";
	private map map;
	private Group root;
	private int x, y;
	private  Image D, L, R, U;
	public Tarakan (int x, int y,Group root,map map)
	{
		super();
		this.root = root;
		this.x = x;
		this.y = y;
		this.map = map;
		D = new Image("file:src/img/clovekD.png",30, 30, false, false);
		L = new Image("file:src/img/clovekL.png",30, 30, false, false);
		R = new Image("file:src/img/clovekR.png",30, 30, false, false);
		U = new Image("file:src/img/clovekU.png",30, 30, false, false);
		setImage(D);
		setFocusTraversable(true);
	    setFocused(true);
	    requestFocus();
	    setOnKeyPressed(evt -> {
	    	input = evt.getCode().toString();
	    	update();
	     });
	    setLayoutX(x*30);
	    setLayoutY(y*30);
	    
	}
	public void left() {
//		System.out.println("left");
//		setLayoutX(getLayoutX()-30);
		setImage(L);
		if((map.matrix[x-1][y] == ' ' || map.matrix[x-1][y] == '.' ) && map.boxlist[x-1][y] != 1 )
		{
			
			setLayoutX(getLayoutX()-30);
			x--;
		}
		else if (map.boxlist[x-1][y] == 1 &&(map.matrix[x-2][y] == ' ' || map.matrix[x-2][y] == '.' ) && map.boxlist[x-2][y] != 1  ) 
		{
			 
			String URI ;
			if(map.matrix[x-2][y] == '.' )
			 {
			 URI = "file:src/img/BoxX.png";
			 }
		 else 
		 {
			 URI = "file:src/img/BoxB.png";
			 }
			 root.getChildren().remove(map.bx[x-1][y]);
			map.bx[x-2][y] = new square(URI,(x-2)*30, (y)*30,root);
			 root.getChildren().add(map.bx[x-2][y]); 
			setLayoutX(getLayoutX()-30);
						
			map.boxlist[x-1][y] = 0;
			map.boxlist[x-2][y] = 1;
			x--;

		}
	}
	public void right() {
		setImage(R);
		if((map.matrix[x+1][y] == ' ' || map.matrix[x+1][y] == '.' ) && map.boxlist[x+1][y] != 1 )
		{
			
			setLayoutX(getLayoutX()+30);
			x++;
		}
	else if (map.boxlist[x+1][y] == 1 &&(map.matrix[x+2][y] == ' ' || map.matrix[x+2][y] == '.' ) && map.boxlist[x+2][y] != 1  ) 
	{
		 
		String URI ;
		if(map.matrix[x+2][y] == '.' )
		 {
		 URI = "file:src/img/BoxX.png";
		 }
	 else 
	 {
		 URI = "file:src/img/BoxB.png";
		 }
		 root.getChildren().remove(map.bx[x+1][y]);
		map.bx[x+2][y] = new square(URI,(x+2)*30, (y)*30,root);
		 root.getChildren().add(map.bx[x+2][y]); 
		setLayoutX(getLayoutX()+30);
					
		map.boxlist[x+1][y] = 0;
		map.boxlist[x+2][y] = 1;
		x++;

	}
	}
	public void up() {
		setImage(U);
				
		if((map.matrix[x][y-1] == ' ' || map.matrix[x][y-1] == '.' ) && map.boxlist[x][y-1] != 1 )
			{
				setLayoutY(getLayoutY()-30);
				y--;
			}
		else if (map.boxlist[x][y-1] == 1 &&(map.matrix[x][y-2] == ' ' || map.matrix[x][y-2] == '.' ) && map.boxlist[x][y-2] != 1  ) 
		{
			 
			String URI ;
			if(map.matrix[x][y-2] == '.' )
			 {
			 URI = "file:src/img/BoxX.png";
			 }
		 else 
		 {
			 URI = "file:src/img/BoxB.png";
			 }
			 root.getChildren().remove(map.bx[x][y-1]);
			map.bx[x][y-2] = new square(URI,x*30, (y-2)*30,root);
			 root.getChildren().add(map.bx[x][y-2]); 
			setLayoutY(getLayoutY()-30);
						
			map.boxlist[x][y-1] = 0;
			map.boxlist[x][y-2] = 1;
			y--;
		}
	}
	public void down() {
		setImage(D);
		
		if((map.matrix[x][y+1] == ' ' || map.matrix[x][y+1] == '.' ) && map.boxlist[x][y+1] != 1 )
		{
			
			setLayoutY(getLayoutY()+30);
			y++;
		}
	else if (map.boxlist[x][y+1] == 1 &&(map.matrix[x][y+2] == ' ' || map.matrix[x][y+2] == '.' ) && map.boxlist[x][y+2] != 1  ) 
	{
		 
		String URI ;
		if(map.matrix[x][y+2] == '.' )
		 {
		 URI = "file:src/img/BoxX.png";
		 }
	 else 
	 {
		 URI = "file:src/img/BoxB.png";
		 }
		 root.getChildren().remove(map.bx[x][y+1]);
		map.bx[x][y+2] = new square(URI,x*30, (y+2)*30,root);
		 root.getChildren().add(map.bx[x][y+2]); 
		setLayoutY(getLayoutY()+30);
					
		map.boxlist[x][y+1] = 0;
		map.boxlist[x][y+2] = 1;
		y++;

	}
		
	}
	
	public void update() {
		switch(input) {
			case "LEFT":
				left();
				break;
			case "RIGHT":
				right();
				break;
			case "UP":
				up();
				break;
			case "DOWN":
				down();
				break;
				
		}
	}
}
