package com.testPackages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Vector;

import com.BillOrder.Dao.ItemObjects;

import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;


public class FieldAction implements ActionListener{
	ArrayList<ItemObjects> listOfObjects;
	SearchTableModel stmModel;
	public FieldAction(ArrayList<ItemObjects> listOfObjects)
	{
		this.listOfObjects = listOfObjects;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
