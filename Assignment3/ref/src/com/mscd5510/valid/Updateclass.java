package com.mscd5510.valid;

import com.mscd5510.entity.*;
import com.mscd5510.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Updateclass {
	public boolean updateTransaction(Transaction updtrxn, int field, String New_value, Connection connection) {
		MySQLAccess update_Query = new MySQLAccess();
		switch (field) {
		case 1:
			updtrxn.setNameOnCard(New_value);
			break;
		case 2:
			updtrxn.setCardNumber(New_value);
			System.out.println("sfdfdfsfsf");
			break;
		case 3:
			updtrxn.setUnitPrice(Float.parseFloat(New_value));
			break;
		case 4:
			updtrxn.setQuantity(Integer.parseInt(New_value));
			break;
		case 5:
			updtrxn.setTotalPrice(Float.parseFloat(New_value));
			break;
		case 6:
			updtrxn.setExpDate(New_value);
			break;
		}
		// idtrxn.setCardtype(New_value);
		String IDS = updtrxn.getID();
		return update_Query.updateTransaction(updtrxn, connection, IDS);
	}

	public void update(Scanner scanIn, Connection connection, Logger logger) {
		MySQLAccess update_Query = new MySQLAccess();
		Transaction idtrxn = new Transaction();
		String ID = "";
		try {
			String yorn = "N";
			// Scanner scanIn = new Scanner(System.in);

			String updatefield, sWhatever1, sWhatever2;

			System.out.println("-------Update the Transaction-------");

			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial1", "root",
			// "root");
			// System.out.println("Enter the no of field to be updated \r\n" +
			// "1.NameOnCard \r\n" +
			// "2.CardNumber \r\n" +
			// "3.UnitPrice \r\n" +
			// "4.Quantity \r\n" +
			// "5.TotalPrice \r\n" +
			// "6.ExpDate \r\n" );
			// System.out.println("clean");
			// String[] fields =
			// {"","NameOnCard","CardNumber","UnitPrice","Quantity","TotalPrice","ExpDate"};

			// updatefieldindex = scanIn.nextInt();
			// System.out.println("code");
			// updatefield = fields[updatefieldindex];
			// System.out.println(updatefield);
			System.out.println("Enter the ID");
			ID = scanIn.next();
			MySQLAccess select_id = new MySQLAccess();
			idtrxn = select_id.getIDTransactions(connection, Integer.parseInt(ID));
			// System.out.println(idtrxn);
			System.out.println("Do you want to change NameonCard(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setNameOnCard(scanIn.next());
			}
			System.out.println("Do you want to change cardNumber(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setCardNumber(scanIn.next());
			}
			System.out.println("Do you want to change UnitPrice(y/n)");

			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setUnitPrice(scanIn.nextFloat());
			}
			System.out.println("Do you want to change Quantity(y/n)");

			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setQuantity(scanIn.nextInt());
			}
			System.out.println("Do you want to change TotalPrice(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setTotalPrice(scanIn.nextFloat());
			}
			System.out.println("Do you want to change ExpDate(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setExpDate(scanIn.next());
			}
			System.out.println("Do you want to change CreatedOn(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setCreatedOn(scanIn.next());
			}
			System.out.println("Do you want to change CreatedBy(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setCreatedBy(scanIn.next());
			}
			System.out.println("Do you want to change Cardtype(y/n)");
			if (scanIn.next().equals("y")) {
				System.out.println("Enter the updated value");
				idtrxn.setCardtype(scanIn.next());
			}

			// int newID = scanIn.nextInt();
			// idtrxn.setUnitPrice(newID);
			// System.out.println(idtrxn,ID);

		}
		/*
		 * System.out.println("Enter the updated value"); sWhatever1 = scanIn.next();
		 * String updatesql = "UPDATE transaction SET "+updatefield+" =? WHERE ID=?";
		 * PreparedStatement statement = con.prepareStatement(updatesql);
		 * statement.setString(1, sWhatever1); statement.setString(2, sWhatever2);
		 * //statement.setString(3, sWhatever2); System.out.println(statement); int
		 * rowsUpdated = statement.executeUpdate(); System.out.println(rowsUpdated);
		 * System.out.println("Do you want to update any other field (Y/N)"); yorn =
		 * scanIn.next(); System.out.println(yorn); con.close();
		 */
		// catch (SQLException e) {
		// System.out.println("not a valid input");
		// logger.severe(e.getMessage());
		// }
		catch (Exception e) {
			System.out.println("Enter valid input");
			// logger.severe(e.getMessage());
		}

		// return update_Query.updateTransaction(idtrxn,connection,ID,logger);
		// TODO Auto-generated method stub

	}

}
