import java.util.Collections;
import java.util.ArrayList;

public class Stats {
	
	int rows;
	int cols;
	String[][] sheet;

	public Stats(int rows, int cols, String[][] data) {
		this.rows = rows;
		this.cols = cols;
		this.sheet = data;
		this.greatestValue();
	}

	public void greatestValue() {
		
		sheet[rows][0] = "Greatest";
		sheet[rows][1] = "Value";
		
		for (int col = 2; col < cols; col++) {
			ArrayList<Integer> taskArrayList = new ArrayList<Integer>();
			for(int row = 0; row < rows; row++) 
				taskArrayList.add(Integer.valueOf(sheet[row][col]));
			Collections.sort(taskArrayList);
			sheet[rows][col] = Integer.toString(taskArrayList.get(taskArrayList.size()-1));
		}
	}

	public void writeData(int rows2, int cols2, String[][] data) {
		
		for (String[] row: sheet) {
			for (String col: row) {
				System.out.print(col);
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
