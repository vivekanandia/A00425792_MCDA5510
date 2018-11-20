package com.mscd5510.web.service;

import com.mscd5510.entity.*;

import java.sql.Connection;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.mscd5510.connect.*;
import com.mscd5510.dao.*;
import com.mscd5510.valid.*;

public class Servicemain {

	public boolean insertValue(String Id, String Name, String Cardno, String UnitPrice, String Quantity,
			String TotalPrice, String ExpDate)

	{
		Insertclass ic = new Insertclass();
		boolean i = ic.insertMethod(Id, Name, Cardno, UnitPrice, Quantity, TotalPrice, ExpDate);
		System.out.println(i);
		return (i);

	}

	public boolean removeValue(String Id) {
		removeTransactionclass rc = new removeTransactionclass();
		boolean r = rc.removeTransaction(Id);
		System.out.println(r);
		return r;

	}

	public boolean updateValue(String Id, String Field, String New_value) {
		Updateclass uc = new Updateclass();
		MySQLAccess select_id = new MySQLAccess();
		boolean u = false;
		try {

			Connection conn = Connectionclass.setupConnection();
			Transaction idtrxn = new Transaction();
			idtrxn = select_id.getIDTransactions(conn, Integer.parseInt(Id));
			u = uc.updateTransaction(idtrxn, Integer.parseInt(Field), New_value, conn);

		} catch (Exception e) {
			// e.printStackTrace();
			return u;
		}

		return u;

	}

	public String getValues() {
		MySQLAccess msa = new MySQLAccess();
		String finalstr = "";
		try {

			Connection conn = Connectionclass.setupConnection();
			Collection<Transaction> trxns = msa.getAllTransactions(conn);
			for (Transaction trxn : trxns) {
				finalstr = finalstr + trxn.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(finalstr);
		return finalstr;

	}
}
