import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Finalproject {
	static int skipCount;
	static int ValidCount;

	public void walk(String path) {
		File root = new File(path);
		File[] list = root.listFiles();
		if (list == null)
			return;
		Reader in;
		try {

			PrintWriter pwr = new PrintWriter(
					new FileOutputStream("/home/student_2018_fall/v_boopathy/Sample/UNVALID_RECORDS_CSV.log", true));
			PrintWriter pwr2 = new PrintWriter(
					new FileOutputStream("/home/student_2018_fall/v_boopathy/Sample/VALID_RECORDS_CSV.csv", true));
			for (File f : list) {
				if (f.isDirectory()) {
					walk(f.getAbsolutePath());
				} else {
					in = new FileReader(f.getAbsoluteFile());
					String top1 = String.valueOf(f.getAbsolutePath());
					int date1 = top1.lastIndexOf("/");
					String top2 = String.valueOf(top1.substring(0, date1));
					int date2 = top2.lastIndexOf('/');
					String top3 = String.valueOf(top2.substring(0, date2));
					int date3 = top3.lastIndexOf('/');
					String top4 = String.valueOf(top2.substring(0, date3));
					int date4 = top4.lastIndexOf('/');
					String top5 = String.valueOf(top2.substring(0, date4));
					String d = String.valueOf(top2.substring(date2 + 1, date1));
					String m = String.valueOf(top2.substring(date3, date2));
					String y = String.valueOf(top2.substring(date4, date3));

					Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
					for (CSVRecord record : records) {
						try {
							//System.out.println(records.toString());
							if (record.get(0).isEmpty() || record.get(1).isEmpty() || record.get(2).isEmpty()
									|| record.get(3).isEmpty() || record.get(4).isEmpty() || record.get(5).isEmpty()
									|| record.get(6).isEmpty() || record.get(7).isEmpty() || record.get(8).isEmpty()
									|| record.get(9).isEmpty()) {
								pwr.println(record);
								skipCount++;
							} else {
								ValidCount++;
								{
									pwr2.println(record.get(0) + "," + record.get(1) + "," + record.get(2) + ","
											+ record.get(3) + "," + record.get(4) + "," + record.get(5) + ","
											+ record.get(6) + "," + record.get(7) + "," + record.get(8) + ","
											+ record.get(9) + "," + d + m + y);
								}

							}
						} catch (ArrayIndexOutOfBoundsException e) {
							pwr.println(e);
						}
					}
				}
			}
			pwr.close();
			pwr2.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Finalproject fw = new Finalproject();
		final long startTime = System.currentTimeMillis();
		fw.walk("/home/student_2018_fall/v_boopathy/Sample Data");
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + " ms" + skipCount);
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;
		try {
			fh = new FileHandler("/home/student_2018_fall/v_boopathy/Sample/Skip-info.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info("Skipped rows count : " + skipCount);
			logger.info("Valid rows count : " + ValidCount);
			logger.info("Total execution time: " + (endTime - startTime) + " ms");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}

	}
}
