import java.sql.Connection;
//import java.lang.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class Insertclass {
	public boolean insertMethod(Scanner scanner,Connection connection,Logger logger) {
		// TODO Auto-generated method stub
		Transaction trxn = new Transaction();
		MySQLAccess create_Query=new MySQLAccess();
		boolean r = false;
		try {

			System.out.println("-------Creating a Transaction-------");
			System.out.println("Enter ID");
			trxn.setID(scanner.next());
			System.out.println("Enter Name_on_card");
			trxn.setNameOnCard(scanner.next());  
			//trxn.setCardNumber(CardNumber);
			System.out.println("CardNumber");
			String CardNumber  = scanner.next();
			trxn.setCardNumber(CardNumber);
			System.out.println("UnitPrice");
			//String up = scanner.next();
			
			trxn.setUnitPrice(Integer.parseInt(scanner.next()) );
			System.out.println("Quantity");
			trxn.setQuantity(Integer.parseInt(scanner.next()));
			System.out.println("TotalPrice");
			trxn.setTotalPrice(Float.parseFloat(scanner.next()));
			System.out.println("ExpDate");
			String ExpDate = scanner.next();
			
			//System.out.println(ExpDate.length());
			//System.out.println(ExpDate.lastIndexOf("/"));
			int flag =0;
			if (ExpDate.length()== 7 && ExpDate.lastIndexOf("/")==2)
			{
				int MM = Integer.parseInt(ExpDate.substring(0, ExpDate.lastIndexOf("/")));
				int YYYY = Integer.parseInt(ExpDate.substring(ExpDate.lastIndexOf("/")+1,ExpDate.length() ));
				System.out.println(MM);
				System.out.println(YYYY);
				if (MM>0 && YYYY>2015  && YYYY<2032 && MM<13)
				{
					//System.out.println("correct");
				}
				else
				{
					System.out.println("Incorrect Date Format");
					flag = 1;
				}
			}
			else {
				System.out.println("Incorrect Date Format");
				flag = 1;
			}
			trxn.setExpDate(ExpDate);	
			//System.out.println("CreatedOn");
			String CreatedOn = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			trxn.setCreatedOn(CreatedOn);
			//System.out.println("CreatedBy");
			//statement.setString(9, System.getProperty("user.name"));
			trxn.setCreatedBy(System.getProperty("user.name"));
			//System.out.println("Credit card type(1.Visa/2.American Express/3.Mastercard)");
			// String cardtype = scanner.next();
			//
			String cardtype = "Unknown";
			if (CardNumber.length() == 16) {
				if (CardNumber.startsWith("51") || CardNumber.startsWith("52") || CardNumber.startsWith("53")
						|| CardNumber.startsWith("54") || CardNumber.startsWith("55")) {
					cardtype = "Mastercard";

				}
				if (CardNumber.startsWith("4")) {
					cardtype = "Visa";
				}
			} else {
				if (CardNumber.length() == 15 && (CardNumber.startsWith("34") || (CardNumber.startsWith("37")))) {
					cardtype = "American Express";
				}

			}
			trxn.setCardtype(cardtype);
			//System.out.println(trxn);

			
			//statement.setString(10, cardtype);
			
/*			String DisplaysqlID = "select * from transaction where ID ="+ID;
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial1", "root", "root");
			PreparedStatement stmt1 = con1.prepareStatement(DisplaysqlID);	
			System.out.println(DisplaysqlID);
			ResultSet resultSet = stmt1.executeQuery(DisplaysqlID);
			if(resultSet.next())
				flag = 2;
			
			// the validation of fields if empty is taken care by using Scanner.next()
			if (flag == 0)
			{
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted == 1) {
				System.out.println("Your data has been inserted");
			}
			}
			else
			{
				if(flag==2)
					System.out.println("User already exists");
				else
					System.out.println("Please once again check your data");
			}
			//scanner.close();
			con.close();*/
			 r = create_Query.createTransaction(trxn,connection,logger);
		} catch (InputMismatchException e) {
			System.out.println("Enter Valid Input");
			logger.severe(e.getMessage());
		}
		//System.out.println(trxn);
		return r;

	}
}
