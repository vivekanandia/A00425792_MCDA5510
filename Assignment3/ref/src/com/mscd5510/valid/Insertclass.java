package com.mscd5510.valid;

import com.mscd5510.entity.*;
import com.mscd5510.connect.*;
import com.mscd5510.dao.*;
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
	public boolean insertMethod(String ID, String NAME, String CARDNO, String UNITPRICE, String QUANTITY,
			String TOTALPRICE, String EXPDATE) {
		/*
		 * Transaction trxn = new Transaction(); MySQLAccess create_Query=new
		 * MySQLAccess(); boolean r = false; trxn.setID(ID); try { Connection conn =
		 * Connectionclass.setupConnection(); r =
		 * create_Query.createTransaction(trxn,conn); } catch (Exception e) {
		 * e.printStackTrace(); //System.out.println("Enter Valid Input"); }
		 */
		Transaction trxn = new Transaction();
		MySQLAccess create_Query = new MySQLAccess();
		boolean r = false;
		try {

			trxn.setID(ID);
			trxn.setNameOnCard(NAME);
			String CardNumber = CARDNO;
			trxn.setCardNumber(CardNumber);
			trxn.setUnitPrice(Integer.parseInt(UNITPRICE));
			trxn.setQuantity(Integer.parseInt(QUANTITY));
			trxn.setTotalPrice(Float.parseFloat(TOTALPRICE));
			String ExpDate = EXPDATE;
			int flag = 0;

			if (ExpDate.length() == 7 && ExpDate.lastIndexOf("/") == 2) {
				int MM = Integer.parseInt(ExpDate.substring(0, ExpDate.lastIndexOf("/")));
				int YYYY = Integer.parseInt(ExpDate.substring(ExpDate.lastIndexOf("/") + 1, ExpDate.length()));
				System.out.println(MM);
				System.out.println(YYYY);
				if (MM > 0 && YYYY > 2015 && YYYY < 2032 && MM < 13) {
					// System.out.println("correct");
				} else {
					System.out.println("Incorrect Date Format");
					flag = 1;
				}
			} else {
				System.out.println("Incorrect Date Format");
				flag = 1;
			}

			trxn.setExpDate(ExpDate);
			String CreatedOn = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			trxn.setCreatedOn(CreatedOn);
			trxn.setCreatedBy(System.getProperty("user.name"));
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
			// System.out.println(trxn);

			try {
				Connection conn = Connectionclass.setupConnection();
				r = create_Query.createTransaction(trxn, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// statement.setString(10, cardtype);*/

			/*
			 * String DisplaysqlID = "select * from transaction where ID ="+ID; Connection
			 * con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial1",
			 * "root", "root"); PreparedStatement stmt1 =
			 * con1.prepareStatement(DisplaysqlID); System.out.println(DisplaysqlID);
			 * ResultSet resultSet = stmt1.executeQuery(DisplaysqlID); if(resultSet.next())
			 * flag = 2;
			 * 
			 * // the validation of fields if empty is taken care by using Scanner.next() if
			 * (flag == 0) { int rowsInserted = statement.executeUpdate(); if (rowsInserted
			 * == 1) { System.out.println("Your data has been inserted"); } } else {
			 * if(flag==2) System.out.println("User already exists"); else
			 * System.out.println("Please once again check your data"); } //scanner.close();
			 * con.close();
			 */

		} catch (InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		return r;

	}
}
