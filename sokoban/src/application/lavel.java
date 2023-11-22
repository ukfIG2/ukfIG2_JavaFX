package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import javafx.scene.Group;

public class lavel extends Group{
	public Character[][][] matrix;
	public int[][][] boxes;
	public int current;
	public int x,y;
	private String vypis ;
	private int linecnt = 0;
	boolean isplayer = true;
	public lavel() {
		
	}
	public void mn()
	{
		try {
			FileReader cita = new FileReader("src/maps.txt");
			BufferedReader br = new BufferedReader(cita);			
			String line;
			int s  = 0;
			int i  = 0;
			matrix = new Character[39][100][100];
			boxes = new int[39][100][100];
					while ((line = br.readLine()) != null)
				{
						
					if(line.charAt(0) == '#' || line.charAt(0) == '!')
					{
						linecnt += 1;
						for(int j=0; j <line.length(); j++) 
						{
							matrix[s][j][i] = line.charAt(j); 
						}
					}
					else if (line.equals("MAPBREAK"))
					{
						i = -1;
						s++;	
						isplayer = true;
						linecnt = 0;
					}
					else
					{
						
							String[] kletk = line.split(" ");
							int  strka = Integer.parseInt(kletk[0]);
							
							int stlp = linecnt-Integer.parseInt(kletk[1])-1;
							if (isplayer) {
								boxes[s][strka][stlp]=2;
								isplayer = false;
							}else {
								boxes[s][strka][stlp]=1;
							}
					}
					i++;				
					}
				
			
		
		}catch(Exception E) {
			System.out.println(E);
		}
		
	}
	public void start()
	{
		current = (int) (Math.random()*39);
		returnSize();	
	}
	public void restart (int cur)
	{
		
	}
	
	public void returnSize ()
	{
		int a = 0;
		int b = 0;
		while ( a < 100)
		{
			b = 0;
			while ( b < 100)
			{
				if (matrix[current][a][b] == null && b == 0)
				{
					x = a+1;
					b = 100;
					a = 100;
				}
				else if ( matrix[current][a][b] == null )
				{
					y = b+1;
					b = 100;
				}
				b++;
			}
			a++;
		}
	}
	public Character[][] getLavel(int s){
		return matrix[s];
	}
	public int[][] getBoxes(int s){
		return boxes[s];
	}
}