import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Logger;

public class removeTransactionclass {
	public Boolean removeTransaction(Scanner scanIn,Connection connection,Logger logger)
	{
		boolean rowsDeletedBoolean = false;
		try {
			Transaction del_Tran=new Transaction();
			MySQLAccess del_user= new MySQLAccess();
		    String sWhatever;
		    System.out.println("-------Delete the Transaction-------");
		    System.out.println("Enter the id to be deleted");
		    sWhatever = scanIn.next();
		    del_Tran.setID(sWhatever);
		    rowsDeletedBoolean = del_user.removeTransaction(del_Tran,connection,logger);
		    
//		    
//			String Deletesql = "DELETE  FROM transaction WHERE ID= ?";
//			PreparedStatement statement  = connection.prepareStatement(Deletesql);
//			statement.setString(1,sWhatever);
//			int rowsDeleted = statement.executeUpdate();
//			rowsDeletedBoolean = (rowsDeleted != 0);
			
			
		}
			catch (Exception e) {
			System.out.println(e);
			logger.severe(e.getMessage());
		}
		return rowsDeletedBoolean;
	}

}
