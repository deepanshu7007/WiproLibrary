package com.BillOrder.Dao;

public class ItemDao {
	private int id;
	private String item_name;
	private Double Max_Retail_Price;
	private int qty_to_less;
	private int PROP_ID;
	private String Department_Name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Double getMax_Retail_Price() {
		return Max_Retail_Price;
	}
	public void setMax_Retail_Price(double max_Retail_Price) {
		Max_Retail_Price = max_Retail_Price;
	}
	public int getQty_to_less() {
		return qty_to_less;
	}
	public void setQty_to_less(int qty_to_less) {
		this.qty_to_less = qty_to_less;
	}
	public int getPROP_ID() {
		return PROP_ID;
	}
	public void setPROP_ID(int pROP_ID) {
		PROP_ID = pROP_ID;
	}
	public String getDepartment_Name() {
		return Department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}
}
