package com.BillOrder.Dao;

public class BillMasterDao {
private String Bill_Prefix;
private int Bill_No;
private String BillPrefixNo;
private String Customer_Id;
private String Customer_Name;
private double Bill_Value;
private String Bill_Mode;
private double Cash_Amount;
private String Bill_Date;
public String getBill_Date() {
	return Bill_Date;
}
public void setBill_Date(String bill_Date) {
	Bill_Date = bill_Date;
}
public String getBill_Prefix() {
	return Bill_Prefix;
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
public String getBillPrefixNo() {
	return BillPrefixNo;
}
public void setBillPrefixNo(String billPrefixNo) {
	BillPrefixNo = billPrefixNo;
}
public String getCustomer_Id() {
	return Customer_Id;
}
public void setCustomer_Id(String customer_Id) {
	Customer_Id = customer_Id;
}
public String getCustomer_Name() {
	return Customer_Name;
}
public void setCustomer_Name(String customer_Name) {
	Customer_Name = customer_Name;
}
public double getBill_Value() {
	return Bill_Value;
}
public void setBill_Value(double bill_Value) {
	Bill_Value = bill_Value;
}
public String getBill_Mode() {
	return Bill_Mode;
}
public void setBill_Mode(String billMode) {
	Bill_Mode = billMode;
}
public double getCash_Amount() {
	return Cash_Amount;
}
public void setCash_Amount(double cash_Amount) {
	Cash_Amount = cash_Amount;
}
public double getCredit_Amount() {
	return Credit_Amount;
}
public void setCredit_Amount(double credit_Amount) {
	Credit_Amount = credit_Amount;
}
public double getCrCard_Amount() {
	return CrCard_Amount;
}
public void setCrCard_Amount(double crCard_Amount) {
	CrCard_Amount = crCard_Amount;
}
private double Credit_Amount;
private double CrCard_Amount;

}
