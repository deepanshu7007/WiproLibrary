package com.Database.Model.Query;

import java.util.ArrayList;

import com.BillOrder.Dao.DepartmentObjects;
import com.BillOrder.Dao.ItemObjects;

public class DepartmentPersist {
	ArrayList<DepartmentObjects> dobj;
	ArrayList<ItemObjects> iobj;

	public ArrayList<DepartmentObjects> getDobj() {
		return dobj;
	}

	public void setDobj(ArrayList<DepartmentObjects> dobj) {
		this.dobj = dobj;
	}

	public ArrayList<ItemObjects> getIobj() {
		return iobj;
	}

	public void setIobj(ArrayList<ItemObjects> iobj) {
		this.iobj = iobj;
	}

	public void assignDepartments() {
		GetItemDetails gi = new GetItemDetails();
		GetDepartmentDetails gd = new GetDepartmentDetails();
		dobj = gd.getListOfObjs();
		gi.getItemDetails();
		iobj = gi.getListOfObj();
		for (ItemObjects item : iobj) {
//			System.out.println(item.getDeptCode());
			gd.getMapOfObj().get(item.getDeptCode()).add(item);
		}
		
//		ArrayList<ItemObjects> items = 	gd.getMapOfObj().get(26);
//		?for(ItemObjects item : items)
//		System.out.println(item.getDeptCode()+"---"+item.getDeptName()+"---"+"---"+item.getItemName());
	}

	public static void main(String... args) {
		DepartmentPersist dp = new DepartmentPersist();
		dp.assignDepartments();
	}
}
