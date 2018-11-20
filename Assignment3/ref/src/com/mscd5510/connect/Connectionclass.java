package com.mscd5510.connect;

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
	private static Connection connection = null;

	private Connectionclass() {

	}

	public  static Connection setupConnection() throws Exception {

		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_boopathy?" // DTP
																								// I
																								// spelled
																								// transactoins
																								// wrong
																								// oops
						+ "user=v_boopathy&password=A00425792" // Creds
						+ "&useSSL=false" // b/c localhost
						+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			} // timezone

		} catch (Exception e) {
			throw e;
			// logger.info(e.getMessage());
		} finally {

		}
		return connection;
	}
}
