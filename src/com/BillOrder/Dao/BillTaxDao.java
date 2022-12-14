package com.BillOrder.Dao;

public class BillTaxDao {
	private String Bill_Prefix;
	private int Bill_No;
	private String BillNoWPrefix;
	private int Item_Code;
	private String Date;
	private String Item_Name;
	private int QtyToRemove;
	private double MRP;
	private double Rate;
	private double Amount;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getBill_Prefix() {
		return Bill_Prefix;
	}
	public int getQtyToRemove() {
		return QtyToRemove;
	}
	public void setQtyToRemove(int qtyToRemove) {
		QtyToRemove = qtyToRemove;
	}
	public void setBill_Prefix(String bill_Prefix) {
		Bill_Prefix = bill_Prefix;
	}
	public int getBill_No() {
		return Bill_No;
	}
	public void setBill_No(int bill_No) {
		Bill_No = bill_No;
	}
	public String getBillNoWPrefix() {
		return BillNoWPrefix;
	}
	public void setBillNoWPrefix(String billNoWPrefix) {
		BillNoWPrefix = billNoWPrefix;
	}
	public int getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(int item_Code) {
		Item_Code = item_Code;
	}
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public double getMRP() {
		return MRP;
	}
	public void setMRP(double mRP) {
		MRP = mRP;
	}
	public double getRate() {
		return Rate;
	}
	public void setRate(double rate) {
		Rate = rate;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
}
