
/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class MySQLAccess {

	public Collection<Transaction> getAllTransactions(Connection connection,Logger logger) {
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = null;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transaction");
			results = createTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.severe(e.getMessage());
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;

	}
	public Transaction getIDTransactions(Connection connection,int iddel) {
		//Statement statement = null;
		ResultSet resultSet = null;
		Transaction idrestrxn = new Transaction();
		//Collection<Transaction> results = null;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			String Deletesql = "SELECT * FROM transaction WHERE ID= ?";
			PreparedStatement statement  = connection.prepareStatement(Deletesql);
			statement.setInt(1,iddel);
			//System.out.println(statement);
			resultSet = statement.executeQuery();
			
			//if(!resultSet.next())
			//{
			//	throw new SQLException("No such ID");
			//}
			if(resultSet.next())
			//System.out.println(resultSet.getString(1));
			{
			idrestrxn.setCardNumber(resultSet.getString("cardNumber"));
			idrestrxn.setID(resultSet.getString("ID"));
			idrestrxn.setNameOnCard(resultSet.getString("nameOnCard"));
			idrestrxn.setUnitPrice(resultSet.getFloat("UnitPrice"));
			idrestrxn.setQuantity(resultSet.getInt("Quantity"));
			idrestrxn.setTotalPrice(resultSet.getFloat("TotalPrice"));
			idrestrxn.setCreatedBy(resultSet.getString("CreatedBy"));
			idrestrxn.setCardtype(resultSet.getString("Cardtype"));
			idrestrxn.setCreatedOn(resultSet.getString("CreatedOn"));
			idrestrxn.setExpDate(resultSet.getString("ExpDate"));
			}
			else
			{
				throw new SQLException("No such ID");
			}
			//System.out.println(resSet.next());
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong id");
			//logger.info("Enter the correct info");
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.info("Enter the correct info");
		} 

		finally {
			//statement = null;
			resultSet = null;
		}
		return idrestrxn;

	}
	public boolean removeTransaction(Transaction deltrxn,Connection connection,Logger logger)
	{
		boolean rowsDeletedBoolean =false;
		try {
		String Deletesql = "DELETE  FROM transaction WHERE ID= ?";
		PreparedStatement statement  = connection.prepareStatement(Deletesql);
		statement.setString(1,deltrxn.getID());
		int rowsDeleted = statement.executeUpdate();
		rowsDeletedBoolean = (rowsDeleted != 0);
		}
		catch (Exception e) {
			System.out.println(e);
			logger.severe(e.getMessage());
		}
		return rowsDeletedBoolean;
		
	}
	public boolean updateTransaction(Transaction updtrxn,Connection connection,String ID,Logger logger)
	{
		boolean rowsUpdatedBoolean =false;
		try {
		String Updatesql = "UPDATE transaction SET NameOnCard=?,CardNumber=?,UnitPrice=?,Quantity=?,TotalPrice=?,ExpDate=?,CreatedOn=?,CreatedBy=?,Cardtype=? WHERE id =?";
		PreparedStatement statement  = connection.prepareStatement(Updatesql);
		statement.setString(1,updtrxn.getNameOnCard());
		statement.setString(2,updtrxn.getCardNumber());
		statement.setFloat(3,updtrxn.getUnitPrice());
		statement.setFloat(4,updtrxn.getQuantity());
		statement.setFloat(5,updtrxn.getTotalPrice());
		statement.setString(6,updtrxn.getExpDate());
		statement.setString(7,updtrxn.getCreatedOn());
		statement.setString(8,updtrxn.getCreatedBy());
		statement.setString(9,updtrxn.getCardtype());
		statement.setString(10,ID);
				
		
		int rowsUpdated = statement.executeUpdate();
		rowsUpdatedBoolean = (rowsUpdated != 0);
		
		}
		catch (Exception e) {
			System.out.println(e);
			logger.severe(e.getMessage());
		}
		return rowsUpdatedBoolean;
	}
	public boolean createTransaction(Transaction insertrxn,Connection connection,Logger logger)
	{
		boolean b = false;
		try {
		System.out.println("DAO insert");
		String Insertsql = "INSERT INTO transaction(ID, NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreatedBy,cardtype) VALUES (?,?,?,?,?,?,?,?,?,?)";
		Statement statement1 = connection.createStatement();
		
		ResultSet results=statement1.executeQuery("select * from transaction where id='"+insertrxn.getID()+"'");
		
		if(!results.next())
		{		
		PreparedStatement statement = connection.prepareStatement(Insertsql);
		statement.setString(1, insertrxn.getID());
		statement.setString(2, insertrxn.getNameOnCard());
		statement.setString(3, insertrxn.getCardNumber());
		statement.setFloat(4, insertrxn.getUnitPrice());
		statement.setFloat(5, insertrxn.getQuantity());
		statement.setFloat(6, insertrxn.getTotalPrice());
		statement.setString(7, insertrxn.getExpDate());
		statement.setString(8, insertrxn.getCreatedOn());
		
		statement.setString(9, insertrxn.getCreatedBy());
		statement.setString(10, insertrxn.getCardtype());
		int rowsInserted = statement.executeUpdate();
		b = (rowsInserted != 0);
		}
		}
		catch (SQLException e) {
			//System.out.println(e);
			logger.severe(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e);
			logger.severe(e.getMessage());
		}
		return b;
	}

	private Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			Transaction trxn = new Transaction();
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			trxn.setUnitPrice(resultSet.getFloat("UnitPrice"));
			trxn.setQuantity(resultSet.getInt("Quantity"));
			trxn.setTotalPrice(resultSet.getFloat("TotalPrice"));
			trxn.setCreatedOn(resultSet.getString("CreatedOn"));
			trxn.setExpDate(resultSet.getString("ExpDate"));
			trxn.setCreatedBy(resultSet.getString("CreatedBy"));
			trxn.setCardtype(resultSet.getString("Cardtype"));
			results.add(trxn);

			// TODO
			/*
			 * String ID = resultSet.getString("ID"); String ExpDate =
			 * resultSet.getString("ExpDate"); String UnitPrice =
			 * resultSet.getString("UnitPrice"); Integer qty =
			 * resultSet.getInt("Quantity"); String totalPrice =
			 * resultSet.getString("TotalPrice"); Date createdOn =
			 * resultSet.getDate("CreatedOn"); String createdBy =
			 * resultSet.getString("CreatedBy");
			 */

		}

		return results;

	}
	
/*	public void del_ID(Transaction tran_Obj)
	{
		System.out.println(tran_Obj.getID());

//		String Deletesql = "DELETE  FROM transaction WHERE ID= ?";
//		PreparedStatement statement  = connection.prepareStatement(Deletesql);
//		statement.setString(1,sWhatever);
//		int rowsDeleted = statement.executeUpdate();
//		rowsDeletedBoolean = (rowsDeleted != 0);
		
	}
*/

}
