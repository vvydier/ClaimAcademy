import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;

public class WriteHtml {
    public static final String inFileName = "input.csv";
    public static final String outFileName = "output.html";

    public static void main(String[] args) {
        // ... insert code here ...
    	//  Do not change the signature of this method.
    	
    	BufferedWriter output;
    	try {
    		output = new BufferedWriter(new FileWriter(outFileName));
	    } catch (IOException ex) {
	    	System.out.println("File IO Error opening " + outFileName);
	    	ex.printStackTrace();
	    	return;
	    }	    
    	
    	try {
			output.write("<html>" + "\n" + "<head>" + "\n" + "<title>" + "\n");
	    	output.write(outFileName + "\n");
	    	output.write("</title>" + "\n" + "</head>" + "\n" + "<body>" + "\n");
	    	output.write("<table style=\" text-align: left;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">"  + "\n" + "<tbody>"  + "\n");
			
	    	CsvReader inData = new CsvReader(inFileName, ',');
	   
	    	while (inData.readRecord()) {
	    		int colCount = inData.getColumnCount();
	    		output.write("<tr>" + "\n");
	    		String cellText = null;
				for (int col=0; col < colCount; col++) {
	    			output.write("<td>");
	    			cellText = EscapeHTML.stringToHTMLString(inData.get(col));
	    			output.write(cellText);
	    			output.write("<br>" + "\n" + "</td>" + "\n");
	    		}
				output.write("</tr>" + "\n");
	    	}
	    	output.write("</tbody>" + "\n" + "</table>" + "\n" + "<br>" +  "\n" + "</body>" + "\n" + "</html>");
	   
    	} catch (IOException e) {
			System.out.println("File IO Error encountered.");
			e.printStackTrace();
		}
    	
    	try {
	       	output.close();
	    } catch (IOException ex) {
	    	// assume an earlier error caused this and was already reported
	    }
    	
    }
}
