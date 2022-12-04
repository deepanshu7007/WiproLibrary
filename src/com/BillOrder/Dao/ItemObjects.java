package com.BillOrder.Dao;

public class ItemObjects {
private String ItemName;
private int ItemCode;
private double ItemMrp;
private int QtyToRemove;
private String DeptName;
private int DeptCode;
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public int getItemCode() {
	return ItemCode;
}
public void setItemCode(int itemCode) {
	ItemCode = itemCode;
}
public double getItemMrp() {
	return ItemMrp;
}
public void setItemMrp(double itemMrp) {
	ItemMrp = itemMrp;
}
public int getQtyToRemove() {
	return QtyToRemove;
}
public void setQtyToRemove(int qtyToRemove) {
	QtyToRemove = qtyToRemove;
}
public String getDeptName() {
	return DeptName;
}
public void setDeptName(String deptName) {
	DeptName = deptName;
}
public int getDeptCode() {
	return DeptCode;
}
public void setDeptCode(int deptCode) {
	DeptCode = deptCode;
}
}
