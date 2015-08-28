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
		computeMedians();
	}

	public void computeMedians() {
		
		sheet[rows][0] = "";
		sheet[rows][1] = "Median";
		
		for (int col = 2; col < cols; col++) {
			ArrayList<Integer> taskArrayList = new ArrayList<Integer>();
			for(int row = 0; row < rows; row++) 
				taskArrayList.add(Integer.valueOf(sheet[row][col]));
			Collections.sort(taskArrayList);
			if (rows % 2 ==0) //even
				sheet[rows][col] = 	Integer.toString((int) Math.ceil((double)(taskArrayList.get(rows/2) + taskArrayList.get(rows/2 +1))/2));
			else //odd
				sheet[rows][col] = Integer.toString(taskArrayList.get(rows/2));
				
		}
		
		/*for (String[] row: sheet) {
			for (String col: row)
				System.out.print(col);
			System.out.print(" ");
		}*/

	}

}
