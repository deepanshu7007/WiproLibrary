package com.Database.Model.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionProvider.ConnectionProvider;

public class RetrieveBillSettings {
	int maxBillNo;
	public void getBillNo()
	{
		ConnectionProvider cp = new ConnectionProvider();
		Connection con = cp.establishConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT max(Bill_No) from bill_master");
			rs.next();
			maxBillNo = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getMaxBillNo() {
		return maxBillNo;
	}
	public void setMaxBillNo(int maxBillNo) {
		this.maxBillNo = maxBillNo;
	}
}
