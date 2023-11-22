package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Player extends ImageView {
	int x, y, numRows, numCols;
	private String input = ""; 
	char[][] matrix;
	Game game;
	int currentimg;
	int marginL,marginT;
	public int steps = 0;
    public Player(int y, int x,char[][] matrix,int numRows,int numCols,int marginL, int marginT, Game game) {
        super();
        this.game = game;
        this.x = x;
        this.y = y;
        this.marginL = marginL;
        this.marginT = marginT;
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrix = matrix;
        changeImage(0);
        setFitWidth(40);
        setFitHeight(40);
        setPreserveRatio(false);
        setFocusTraversable(true);
        setFocused(true);
        requestFocus();
        setOnKeyPressed(evt -> { 
            input = evt.getCode().toString();
            update(0);});
        setLayoutX(marginL+x*40);
        setLayoutY(marginT+y*40);
    }
    private void changeImage(int img) {
    	this.currentimg  = img;
    	Image image1 = new Image(getClass().getResourceAsStream("/resources/player"+img+".png"), 100,100,false,false);
        setImage(image1);
    }
    private int change() {
    	if (currentimg != 1) {
    		return 1;
    	}else {
    		return 2;
    	}
    }
    public int getSteps() {
    	return steps;
    }
    public void update(double deltaTime) {
        switch(input) {
            case "A":
            	if (matrix[y][x-1]!='#') {
            		if (matrix[y][x-1]=='B' && matrix[y][x-2]!='B' && matrix[y][x-2]!='#') {
            			game.boxMove(y, x-1, y, x-2);
            			x -= 1;
                		setLayoutX(marginL+x * 40);
                		changeImage(change());
                		steps+=1;
            		}else if(matrix[y][x-1]!='B'){
            			x -= 1;
                		setLayoutX(marginL+x * 40);
                		changeImage(change());
                		steps+=1;
            		}	
                }
                break;
            case "D": 
            	if (matrix[y][x+1]!='#') {
            		if (matrix[y][x+1]=='B' && matrix[y][x+2]!='B' && matrix[y][x+2]!='#') {
            			game.boxMove(y, x+1, y, x+2);
            			x += 1;
                		setLayoutX(marginL+x * 40);
                		changeImage(change());
                		steps+=1;
            		}else if(matrix[y][x+1]!='B'){
            			x += 1;
                		setLayoutX(marginL+x * 40);
                		changeImage(change());
                		steps+=1;
            		}	
                }
                break;
            case "S":
            	if (matrix[y+1][x]!='#') {
            		if (matrix[y+1][x]=='B' && matrix[y+2][x]!='B' && matrix[y+2][x]!='#') {
            			game.boxMove(y+1, x, y+2, x);
            			y += 1;
                		setLayoutY(marginT+y * 40);
                		changeImage(change());
                		steps+=1;
            		}else if(matrix[y+1][x]!='B'){
            			y += 1;
                		setLayoutY(marginT+y * 40);	
                		changeImage(change());
                		steps+=1;
            		}	
                }
                break;
            case "W": 
            	changeImage(3);
            	if (matrix[y-1][x]!='#') {
            		if (matrix[y-1][x]=='B' && matrix[y-2][x]!='B' && matrix[y-2][x]!='#') {
            			game.boxMove(y-1, x, y-2, x);
            			y -= 1;
                		setLayoutY(marginT+y * 40);
                		steps+=1;
            		}else if(matrix[y-1][x]!='B'){
            			y -= 1;
                		setLayoutY(marginT+y * 40);
                		steps+=1;
            		}	
                }
                break;
        }
    }
}