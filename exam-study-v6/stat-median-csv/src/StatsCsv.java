// StatsCsv.java -- add greatest values to spreadsheet
//
// This is NOT a working program. This is a "skeleton" that
// should be modified and extended to meet the specifications.

import java.io.IOException;

import java.util.Arrays;

import com.csvreader.CsvReader;


public class StatsCsv {
    
    private static final int MAXROW = 16;
    private static final int MAXCOL = 16;
    private int rowsUsed = 0;
    private int colsUsed = 0;
    private static final String inFile = "Data01.csv";
    private static final String outFile = "Data02.csv"; 
   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	private String[] header;
    
    public static void main(String[] args) throws IOException {

        StatsCsv a = new StatsCsv();
        a.readSheet();
        // a.getRows() is the row count before adding medians
        Stats s = new Stats(a.getRows(), a.getCols(), a.getData());
        a.setRows(a.getRows() + 1); // because we added a row of medians
        a.writeSheet();
    }
    
    public void writeSheet() throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
    	CsvWriter outData = new CsvWriter(outFile);
    	
    	outData.setRecordDelimiter(',');
    	outData.setRecordDelimiter('\r');
    	outData.writeRecord(header);
    	
    	for(String[] row : sheet) {
    		outData.writeRecord(row);
        }
    	outData.close();
    }
    

    public void readSheet( ) throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
    	CsvReader inData = new CsvReader(inFile, ',');
    	
    	inData.readHeaders();
    	header = inData.getHeaders();
   
    	int row = 0;
    	while (inData.readRecord()) {
    		int colCount = inData.getColumnCount();
    		for (int col=0; col < colCount; col++) {
    			sheet[row][col] = inData.get(col);
    		}
        	this.colsUsed = colCount;
    		row++;
    	}
    	
    	this.setRows(row);
    }

    public int getRows(){
    	return rowsUsed;
    }
    
    public int setRows(int r) {
        rowsUsed = r;
        return rowsUsed;
    }

    public int getCols() {
    	return colsUsed;
    }
    
    public String[][] getData() {
    	return sheet;
    }
}
