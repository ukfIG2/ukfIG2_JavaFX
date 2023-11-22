package application;

public class Save_map {
	    private String[][] data;

	    public Save_map(String[][] data, int map_height, int map_width) {
	        this.data = new String[map_height][map_width];
	        for(int i = 0; i < map_height; i++) {
				for(int j = 0; j < map_width; j++) {
	    	        this.data[i][j] = data[i][j];
	    	    }
	    	}
	    }

	    public String[][] getMap() {
	        return data;
	    }

}
