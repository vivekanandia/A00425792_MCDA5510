import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Finalproject {
	static int skipCount ;
	public void walk( String path ) {
		File root  =new File( path );
        File[] list = root.listFiles();
        if (list == null) return;
        Reader in;
        Writer writer;
        try {
			 //writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Admin\\Documents\\consolidated-csv.csv"));
			//CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("First Name", "Last Name","Street Number","Street","City","Province","Postal Code","Country","Phone Number","email Address","Date"));
			PrintWriter pwr = new PrintWriter(new FileOutputStream("/home/student_2018_fall/v_boopathy/consolidated-log.log", true));
			PrintWriter pwr2 = new PrintWriter(new FileOutputStream("/home/student_2018_fall/v_boopathy/consolidated-csv.csv", true));
			for ( File f : list ) {
	            if ( f.isDirectory() ) {
	                walk( f.getAbsolutePath() );
	               // Logger.getAnonymousLogger().log(Level.INFO, "Dir:" + f.getAbsoluteFile() );
	            }
	            else {
	            	in = new FileReader(f.getAbsoluteFile());
	            	//System.out.println(String.valueOf(f.getAbsoluteFile()));
        			//String parts =  String.valueOf(f.getAbsoluteFile());
        			//System.out.println(parts);
        			//String toppings = parts.split("-");
	            	String top1 = String.valueOf(f.getAbsolutePath());
	            	//System.out.println(top1);
	            	int date1 = top1.lastIndexOf( "/");
	            	//System.out.println(date1);
	            	
	            	String top2 = String.valueOf(top1.substring(0,date1));
	            	//System.out.println(top2);
	            	int date2 = top2.lastIndexOf( '/' );
	            	String top3 = String.valueOf(top2.substring(0,date2));
	            	int date3 = top3.lastIndexOf( '/' );
	            	String top4 = String.valueOf(top2.substring(0,date3));
	            	int date4 = top4.lastIndexOf( '/' );
	            	String top5 = String.valueOf(top2.substring(0,date4));
	            	String d =String.valueOf(top2.substring(date2+1,date1));
	            	String m =String.valueOf(top2.substring(date3,date2));
	            	String y =String.valueOf(top2.substring(date4,date3));
	            	//System.out.println(d+m+y);
	            	
	            	
	            	//String[] toppings = top.split("\");
	            	//System.out.println(top1+top2+top3);
        			//System.out.println(top.substring(0, top.lastIndexOf( '\' )));
 //       			String date1 = (parts[parts.length-1]);
        			//String date2 = (parts[parts.length-2]);
        			//String date3 = (parts[parts.length-3]);
        			//System.out.println(date1+"/"+date2+"/"+date3);
        			//String fulldate = date1+"/"+date2+"/"+date3;
	            	Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        			for (CSVRecord record : records) {
        				try {
        				if(record.get(0).isEmpty()||record.get(1).isEmpty()||record.get(2).isEmpty()||record.get(3).isEmpty()||record.get(4).isEmpty()||record.get(5).isEmpty()||record.get(6).isEmpty()||record.get(7).isEmpty()||record.get(8).isEmpty()||record.get(9).isEmpty())
    					{
        					pwr.println(record);
        					
        					//pwr.println(record.get(0)+","+record.get(1)+","+record.get(2)+","+record.get(3)+","+record.get(4)+","+record.get(5).isEmpty()+","+record.get(6)+","+record.get(7)+","+record.get(8)+","+record.get(9));
        					skipCount++;
    					}
        				else
        				{
        					//pwr2.println(record);
        					if (record.get(3).startsWith("Alm-..") )
        							{
        						//System.out.println(record.get(3));
        						pwr2.println(record.get(0)+","+record.get(1)+","+record.get(2)+","+record.get(3)+","+record.get(8)+","+record.get(9)+","+record.get(10)+","+record.get(11)+","+record.get(12)+","+record.get(13)+","+d+m+y);
        						
        							}
        					else {
            					pwr2.println(record.get(0)+","+record.get(1)+","+record.get(2)+","+record.get(3)+","+record.get(4)+","+record.get(5)+","+record.get(6)+","+record.get(7)+","+record.get(8)+","+record.get(9)+","+d+m+y);
        					}
        					 
        				}
        				}
        		        catch ( ArrayIndexOutOfBoundsException e) {
        					
        				}
        			}
        			}
	            }
			//csvPrinter.flush();
			pwr.close();
			pwr2.close();
			//csvPrinter.close();
			}

        
        catch ( IOException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
    	Finalproject fw = new Finalproject();
    	final long startTime = System.currentTimeMillis();
    	fw.walk("/home/student_2018_fall/v_boopathy/Sample Data" );	
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) +" ms"+skipCount);
        try {
            PrintWriter pwr1 = new PrintWriter(new FileOutputStream("/home/student_2018_fall/v_boopathy/skip-log.log", true)); 
            pwr1.println("Skipped rows count : "+skipCount);
            pwr1.println("Total execution time: " + (endTime - startTime) +" ms");
            pwr1.close();
        }
        catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        


        
        
    }
}
