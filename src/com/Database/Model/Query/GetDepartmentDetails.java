package com.Database.Model.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.BillOrder.Dao.DepartmentObjects;
import com.BillOrder.Dao.ItemObjects;

import ConnectionProvider.ConnectionProvider;

public class GetDepartmentDetails {
private Connection con;
private HashMap<Integer,ArrayList<ItemObjects>> MapOfObj;
public HashMap<Integer,ArrayList<ItemObjects>> getMapOfObj() {
	return this.MapOfObj;
}
private ArrayList<DepartmentObjects> listOfObjs;
public ArrayList<DepartmentObjects> getListOfObjs()
{
return this.listOfObjs;	
}
public GetDepartmentDetails()
{
	DepartmentObjects dobj;
	MapOfObj = new HashMap<>();
	listOfObjs = new ArrayList<DepartmentObjects>();
	try {
		ConnectionProvider cp = new ConnectionProvider();
		con = cp.establishConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select PROP_ID,PROP_NAME from departments order by PROP_ID");
		while(rs.next())
		{
			dobj = new DepartmentObjects();
			dobj.setPROP_ID(rs.getInt(1));
			dobj.setPROP_NAME(rs.getString(2));
			listOfObjs.add(dobj);
			MapOfObj.put(rs.getInt(1), new ArrayList<ItemObjects>());
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
public static void main(String[] arhs)
{
	GetDepartmentDetails gdd = new GetDepartmentDetails();
	ArrayList<DepartmentObjects> list = gdd.getListOfObjs();
	System.out.println((list.size()/5)+1);
	for(DepartmentObjects objs:list)
	{
		System.out.println(objs.getPROP_NAME());
	}
}
}
