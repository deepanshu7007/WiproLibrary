package com.Database.Model.Query;
import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.BillOrder.Dao.ItemObjects;

import ConnectionProvider.ConnectionProvider;

public class GetItemDetails {
	private Connection con;
	private Vector<Vector<ItemObjects>> RowsOfItems;
	private ArrayList<ItemObjects> ListOfItems;
	private ArrayList<ItemObjects> ListOfObj;
	public void getItemTable()
	{
		ItemObjects dobj;
		RowsOfItems = new Vector<Vector<ItemObjects>>();
		ListOfObj = new ArrayList<>();
		try {
			ConnectionProvider cp = new ConnectionProvider();
			con = cp.establishConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select ItemID,Item_Name,Qty_To_Less,Sale_Rate,Max_Retail_Price,PROP_ID,PROP_NAME  from packing_belongs_csv order by Item_Name;");
			while(rs.next())
			{
				dobj = new ItemObjects();
				dobj.setItemCode(rs.getInt(1)); 
				dobj.setItemName(rs.getString(2)); 
				dobj.setQtyToRemove(rs.getInt(3));
				dobj.setItemPrice(rs.getDouble(4));
				dobj.setItemMrp(rs.getDouble(5)); 
				ListOfItems.add(dobj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ItemObjects> getItemDetails(boolean sorted)
	{
		ItemObjects dobj;
		RowsOfItems = new Vector<Vector<ItemObjects>>();
		ListOfObj = new ArrayList<>();
		try {
			ConnectionProvider cp = new ConnectionProvider();
			con = cp.establishConnection();
			Statement stmt = con.createStatement();
			ResultSet rs;
			if(sorted==true)
				rs = stmt.executeQuery("select ItemID,Item_Name,Qty_To_Less,Sale_Rate,Max_Retail_Price,PROP_ID,PROP_NAME  from packing_belongs_csv inner join departments order by Item_Name;");
			else
			 rs = stmt.executeQuery("select ItemID,Item_Name,Qty_To_Less,Sale_Rate,Max_Retail_Price,PROP_ID,PROP_NAME  from packing_belongs_csv inner join departments on PROP_ID = Department order by PROP_ID;");
			
			while(rs.next())
			{
				dobj = new ItemObjects();
				dobj.setItemCode(rs.getInt(1)); // for item code
				dobj.setItemName(rs.getString(2)); // for item name
				dobj.setQtyToRemove(rs.getInt(3));
				dobj.setItemPrice(rs.getDouble(4));
				dobj.setItemMrp(rs.getDouble(5)); //for dept price
				dobj.setDeptCode(rs.getInt(6)); //for dept. code
				dobj.setDeptName(rs.getString(7)); //for dept Name
				ListOfObj.add(dobj);
			}
			int count=0;
			Vector<ItemObjects> dptList = new Vector<ItemObjects>();
			for (ItemObjects Item:ListOfObj) {
				
				if (count == 5) {
					count = 0;
					RowsOfItems.add(dptList);
					dptList = new Vector<>();
				}
				dptList.add(Item);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListOfObj;
	}
	public ArrayList<ItemObjects> getItem()
	{
		return ListOfItems;
	}
	public Vector<Vector<ItemObjects>> getItemTableData()
	{
		return RowsOfItems;
	}
	public ArrayList<ItemObjects> getListOfObj() {
		return ListOfObj;
	}
	public void setListOfObj(ArrayList<ItemObjects> listOfObj) {
		ListOfObj = listOfObj;
	}
	public static void main(String[] arhs)
	{
		GetItemDetails gdd = new GetItemDetails();
		
	}
	}
