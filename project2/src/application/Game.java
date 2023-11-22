package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Game extends Group{
    private Group rt;
    private Main main;
    private char[][] level;
    private String input, line;
    char[][] matrix;
    String[] cords;
    char test;
    private int playerposx=0, playerposy=0, crdx, crdy, marginL, marginT, gameTime, numRows, numCols, minutes, seconds;
    Text stepsText, timerText;
    Bricks bricks;
    Spot spot;
    Empty empty;
    Box box;
    Player player;
    Timeline gameTimer, stepsTimer;
    private ArrayList<Box> boxlist; 
//    private ArrayList<GreenBox> greenBoxList;
    private ArrayList<String> spotlist; 
    public Game(Group root,Main main, int levelFileName) {
    	rt = root;
    	this.main = main;
        loadLevel(levelFileName);
        drawLevel();
        timerText = new Text(370, 25, "0:00");
        stepsText = new Text(755, 25, "0");
        gameTimer = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                	gameTime+=1;
                        updateTimerText();
                })
            );
        gameTimer.setCycleCount(Timeline.INDEFINITE);
        gameTimer.play();
        stepsTimer = new Timeline(
                new KeyFrame(Duration.millis(10), event -> {
                        updateStepsText();
                })
            );
        stepsTimer.setCycleCount(Timeline.INDEFINITE);
        stepsTimer.play();
    }
    private void updateTimerText() {
        minutes = gameTime / 60;
        seconds = gameTime % 60;
        String timeString = String.format("%d:%02d", minutes, seconds);
        timerText.setText(timeString);
    }
    private void updateStepsText() {
    	stepsText.setText(Integer.toString(player.getSteps()));
    }
    public Text getStepsText() {
        return stepsText;
    } 
    public Text getTimerText() {
        return timerText;
    }
    public Player getPlayer() {
        return player;
    }
    public String getSteps() {
    	return Integer.toString(player.getSteps());
    }
    public String getTime() {
    	minutes = gameTime / 60;
        seconds = gameTime % 60;
        String timeString = String.format("%d:%02d", minutes, seconds);
        return timeString;
    }
    public void loadLevel(int levelFileName) {
        try {
        	System.out.print(matrix);
        	FileReader fr = new FileReader("levels/level"+levelFileName+".txt");
          	BufferedReader reader = new BufferedReader(fr);
            numRows = Integer.parseInt(reader.readLine());
            numCols = Integer.parseInt(reader.readLine());
            marginL = 400-numCols*20;
            marginT = 300-numRows*20;
            matrix = new char[numRows][numCols];
            boxlist = new ArrayList<>();
            spotlist = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                line = reader.readLine();
                for (int j = 0; j < numCols; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void drawLevel() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                switch(matrix[row][col]) {
                case '#': 
                	bricks = new Bricks(row,col,marginL,marginT);
                	getChildren().addAll(bricks);
                	break;
                case '1': 
                	spot = new Spot(row,col,marginL,marginT);
                	getChildren().addAll(spot);
                	spotlist.add(row+" "+col);
                	break;
                case '0': 
                	empty = new Empty(row,col,marginL,marginT);
                	getChildren().addAll(empty);
                	break;
                case 'B': 
                	empty = new Empty(row,col,marginL,marginT);
                	getChildren().addAll(empty);
                	break;
                case 'P': 
                	playerposx = row;
                	playerposy = col;
                	empty = new Empty(row,col,marginL,marginT);
                	getChildren().addAll(empty);
                	break;
                }
            }
        }
            for (int rows = 0; rows < numRows; rows++) {
                for (int cols = 0; cols < numCols; cols++) {
                	if(matrix[rows][cols]=='B') {
                		box = new Box(rows,cols,marginL,marginT);
                		boxlist.add(box);
                		getChildren().addAll(box);
                }
            }
        }
            for (String s : spotlist) {
                cords = s.split(" ");
                crdx = Integer.valueOf(cords[0]);
                crdy = Integer.valueOf(cords[1]);
//                if (matrix[crdx][crdy] == '1') {
//                    GreenBox greenBox = new GreenBox(crdx, crdy);
//                    greenBoxList.add(greenBox);
//                    getChildren().addAll(greenBox);
//                }
            }
    	player = new Player(playerposx,playerposy, matrix, numRows, numCols, marginL, marginT, this);
    	getChildren().addAll(player);
    	matrix[playerposx][playerposy]='0';
    }
    
    public void update(double deltaTime) {
    }
    
    public void boxMove(int prevRow, int prevCol, int deltaRow, int deltaCol) {
        for (Box box : boxlist) {
            if (box.getRow() == prevRow && box.getCol() == prevCol) {
                boolean onSpot = false;
                for (String s : spotlist) {
                    cords = s.split(" ");
                    crdx = Integer.valueOf(cords[0]);
                    crdy = Integer.valueOf(cords[1]);
                    if (deltaRow == crdx && deltaCol == crdy) {
                        onSpot = true;
                        break;
                    }else {
                    	onSpot = false;
                    }
                }

                if (isValidPosition(deltaRow, deltaCol) && matrix[deltaRow][deltaCol] != 'B' && matrix[deltaRow][deltaCol] != '#') {
                    box.setRow(deltaRow);
                    box.setCol(deltaCol);
                    box.setLayoutX(marginL + deltaCol * 40);
                    box.setLayoutY(marginT + deltaRow * 40);
                    matrix[prevRow][prevCol] = '0';
                    if (onSpot) {
                        box.madeGreen();
                    } else {
                        box.unmadeGreen();
                    }

                    for (String s : spotlist) {
                        cords = s.split(" ");
                        crdx = Integer.valueOf(cords[0]);
                        crdy = Integer.valueOf(cords[1]);
                        if (matrix[crdx][crdy] != 'B') {
                            matrix[crdx][crdy] = '1';
                        }
                    }
                    matrix[deltaRow][deltaCol] = 'B';
                }
                break;
            }
        }

        if (endGame()) {
            System.out.print("YOU WIN");
            main.newLevel();
        }
    }
    private boolean endGame() {
        for (char[] row : matrix) {
            for (char c : row) {
                if (c == '1') {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}