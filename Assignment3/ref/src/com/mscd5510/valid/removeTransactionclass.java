package com.mscd5510.valid;

import com.mscd5510.entity.*;
import com.mscd5510.connect.Connectionclass;
import com.mscd5510.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Logger;

public class removeTransactionclass {
	public Boolean removeTransaction(String ID) {
		boolean rowsDeletedBoolean = false;
		try {
			Transaction del_Tran = new Transaction();
			MySQLAccess del_user = new MySQLAccess();
			del_Tran.setID(ID);
			Connection conn = Connectionclass.setupConnection();
			rowsDeletedBoolean = del_user.removeTransaction(del_Tran, conn);

		} catch (Exception e) {
			System.out.println(e);
		}
		return rowsDeletedBoolean;
	}

}
