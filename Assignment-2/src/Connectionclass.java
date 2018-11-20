import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class Connectionclass {
	private static Connectionclass Connectionobj;
	private Connectionclass(){}
	public static Connectionclass getInstance()
	{
		if (Connectionobj == null)
		{
			Connectionobj = new Connectionclass();
		}
		return Connectionobj;
	}
	public Connection setupConnection() throws Exception {
		
		Connection connection = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB

			connection = DriverManager.getConnection("jdbc:mysql://localhost/tutorial1?" // DTP
																							// I
																							// spelled
																							// transactoins
																							// wrong
																							// oops
					+ "user=root&password=root" // Creds
					+ "&useSSL=false" // b/c localhost
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone

		} catch (Exception e) {
			throw e;
			//logger.info(e.getMessage());
		} finally {

		}
		return connection;
	}
}
