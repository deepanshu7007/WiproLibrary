package com.testPackages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.BillOrder.Dao.BillDetailsDao;
import com.BillOrder.Dao.BillMasterDao;
import com.BillOrder.Dao.BillTaxDao;

import ConnectionProvider.ConnectionProvider;

public class ButtonActionsFrame {
	private int billSerial;
	public int getBillSerial() {
		return billSerial;
	}

	public void setBillSerial(int billSerial) {
		this.billSerial = billSerial;
	}

	public int SaveBillMaster(BillMasterDao bmd)
	{
		ConnectionProvider cp = new ConnectionProvider();
		
		Connection con = cp.establishConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Bill_No) from bill_master_csv");
			rs.next();
			billSerial = rs.getInt(1);
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO bill_master_csv (Bill_Prefix,Bill_No,BillNoWPrefix,Bill_Date,Customer_ID,Customer_Name,Bill_Value) VALUES (?,?,?,?,?,?,?)");
			pstmt.setString(1,"AC");
			pstmt.setInt(2,billSerial+1);
			pstmt.setString(3,"AC-"+billSerial);
			pstmt.setString(4,bmd.getBill_Date());
			pstmt.setString(5,bmd.getCustomer_Id());
			pstmt.setString(6,bmd.getCustomer_Name());
			pstmt.setDouble(7,bmd.getBill_Value());
			pstmt.executeUpdate();
			System.out.print("statement executed successfully.");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	public int SaveBillDetails(ArrayList<BillTaxDao> bmd)
	{
		ConnectionProvider cp = new ConnectionProvider();
		
		Connection con = cp.establishConnection();
		try {
			con.setAutoCommit(false);
			String insertEmployeeSQL = "INSERT INTO BillTax_Detail_csv(Bill_Prefix,Bill_No,BillNoWPrefix,Bill_Date,Item_Code,Item_Name,MRP,Rate,Qty,Amount) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(insertEmployeeSQL);			
			for(BillTaxDao bmds:bmd)
			{
				pstmt.setString(1, "AC");
				pstmt.setInt(2, this.billSerial+1);
				pstmt.setString(3, "AC-"+this.billSerial+1);
				pstmt.setString(4, bmds.getDate());
				pstmt.setInt(5, bmds.getItem_Code());
				pstmt.setString(6, bmds.getItem_Name());
				pstmt.setDouble(7, bmds.getMRP());
				pstmt.setDouble(8, bmds.getRate());
				pstmt.setDouble(9, bmds.getQtyToRemove());
				pstmt.setDouble(10, bmds.getAmount());
				pstmt.executeUpdate();
			}
			con.commit();
			System.out.print("Statement executed successfully.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
}
