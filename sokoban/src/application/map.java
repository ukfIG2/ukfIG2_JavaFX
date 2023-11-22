package application;

import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class map extends Group{
	public square[][] img;
	public square[][] bx;
	private Group root;
	String URI;
	private String input="";
	Tarakan tr;
	public int[][] boxlist;
	private int X,Y;
	public Character[][] matrix; 
	public map () {
	}
	public void start (Character[][] matrix,int[][] boxlist,int X,int Y,Group root)
	{
		this.matrix = matrix;
		this.boxlist = boxlist;
		this.root = root;
		this.X = X;
		this.Y = Y;
		int a =0 ;
	    img = new square[X][Y];
	     bx = new square[X][Y];
			while (a < X-1)
			{
				int b = 0;
				while (b < Y-1)
				{
					URI=""; 
						switch (matrix[a][b].toString()) {
					case "#": {
						
						 URI = "file:src/img/wall.png";
						break;
					}case " ": {
						
						 URI = "file:src/img/floor0.png";
						break;
					}case ".": {
						
						 URI = "file:src/img/floor1.png";
						break;
					}case "!": {
						
						 URI = "file:src/img/wall.png";
						break;
					}
					default:
						 URI = "file:src/img/wall.png";
					} ;
					
					
					img[a][b] = new square(URI,a*30, b*30,root);
					 root.getChildren().add(img[a][b]);
					
					b++;
				}
			
				a++;
			}
			
			
		for(int i=0;i<X;i++) {
			for(int j=0;j<Y;j++) {
				if(boxlist[i][j]==1) {
				
					 if(matrix[i][j] == '.' )
						 {
						 URI = "file:src/img/BoxX.png";
						 }
					 else 
					 {
						 URI = "file:src/img/BoxB.png";
						 }
						 
					 bx[i][j] = new square(URI,i*30, j*30,root);
					 root.getChildren().add(bx[i][j]); 
				}else if(boxlist[i][j]==2) {
					tr = new Tarakan(i, j,root,this);
					root.getChildren().add(tr);
					 setFocusTraversable(true);
				     setFocused(true);
				}
			}
		}		
	}
	public void returnWall(int x,int y)
	{
		Image wall = new Image("file:src/img/wall.png",30,30,false,false);
		setLayoutX(x);
	    setLayoutY(y);
	    ImageView w = new ImageView(wall);
	    getChildren().add(w);
	}
	public void returnboxx(int x,int y)
	{
		Image boxx = new Image("file:src/img/BoxX.png",30,30,false,false);
		setLayoutX(x);
	    setLayoutY(y);
	    ImageView bx = new ImageView(boxx);
	    getChildren().add(bx);
	}
	public void returnbox(int x,int y)
	{
		Image box = new Image("file:src/img/BoxB.png",30,30,false,false);
		setLayoutX(x);
	    setLayoutY(y);
	    ImageView b = new ImageView(box);
	    getChildren().add(b);
	}
	public void floor (int x,int y)
	{
		Image floor = new Image("file:src/img/floor0.png",30,30,false,false);
		setLayoutX(x);
	    setLayoutY(y);
	    ImageView f= new ImageView(floor);
	    getChildren().add(f);
	}
	public void floorfl (int x,int y)
	{
		Image floorfl = new Image("file:src/img/floor1.png",30,30,false,false);
		setLayoutX(x);
	    setLayoutY(y);
	    ImageView ffl= new ImageView(floorfl);
	    getChildren().add(ffl);
	}
}