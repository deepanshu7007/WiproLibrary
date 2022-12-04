package com.BillOrder.Dao;
import java.util.*;

public class DepartmentObjects {
	private int PROP_ID;
	private String PROP_NAME;
	private ArrayList<ItemObjects> ListOfObjects;
	public int getPROP_ID() {
		return PROP_ID;
	}
	public void setPROP_ID(int pROP_ID) {
		PROP_ID = pROP_ID;
	}
	public String getPROP_NAME() {
		return PROP_NAME;
	}
	public void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}
	public void addItem(ItemObjects item)
	{
		ListOfObjects.add(item);
	}
	public ItemObjects getItem(int pos)
	{
		return ListOfObjects.get(pos);
	}
}
