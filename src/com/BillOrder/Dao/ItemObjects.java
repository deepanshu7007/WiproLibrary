package com.BillOrder.Dao;

public class ItemObjects {
private String ItemName;
private int ItemCode;
private Double ItemMrp;
private Double ItemPrice;
private int QtyToRemove;
private String DeptName;
private int DeptCode;
public String getItemName() {
	return ItemName;
}

public Double getItemPrice() {
	return ItemPrice;
}

public void setItemPrice(Double itemPrice) {
	ItemPrice = itemPrice;
}

public void setItemMrp(Double itemMrp) {
	ItemMrp = itemMrp;
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
public Double getItemMrp() {
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
public void copyObjects(ItemObjects toBeCopies) {
	this.ItemCode = toBeCopies.ItemCode;
	this.ItemName = toBeCopies.ItemName;
	this.ItemMrp = toBeCopies.ItemMrp;
	this.ItemPrice = toBeCopies.ItemPrice;
	this.QtyToRemove = toBeCopies.QtyToRemove;
	this.DeptCode = toBeCopies.DeptCode;
	this.DeptName = toBeCopies.DeptName;
}
}
