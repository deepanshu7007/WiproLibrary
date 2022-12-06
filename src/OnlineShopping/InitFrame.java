package OnlineShopping;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.BillOrder.Dao.DepartmentObjects;
import com.BillOrder.Dao.ItemObjects;
import com.Database.Model.Query.GetDepartmentDetails;
import com.Database.Model.Query.GetItemDetails;

public class InitFrame {
	OrderFrame of;
	GetDepartmentDetails gdd;
	Vector<String> dptList;

	InitFrame() {
		this.of = new OrderFrame(this);
		of.getItemTable().removeRow(0);
		DepartmentObjects objects;
		gdd = new GetDepartmentDetails();
//		for(int i=0;i<(gdd.getListOfObjs().size()/5)+1;i++)
//		{				
			int count=0;
			of.getDeptTable().getDataVector().removeAllElements();
			dptList = new Vector<>();
			for (int i=0;i< gdd.getListOfObjs().size();i++) 
			{
			objects = gdd.getListOfObjs().get(i);
				if(count==5) 
				{
					count=0;
					of.getDeptTable().addRow(dptList);
					dptList = new Vector<>();
				}	
				dptList.add(objects.getPROP_NAME());
				count++;
			}
			if(!dptList.isEmpty())
			{
				of.getDeptTable().addRow(dptList);
			}
		of.setVisible(true);
	}

	public GetDepartmentDetails getGdd() {
		return gdd;
	}

	public void setGdd(GetDepartmentDetails gdd) {
		this.gdd = gdd;
	}

	public Vector<String> getDptList() {
		return dptList;
	}

	public void setDptList(Vector<String> dptList) {
		this.dptList = dptList;
	}
	private ArrayList<ItemObjects> listOfItems;
	public void getListOfItem(int row,int col)
	{
		int pos = (row * 5) + (col);
		ItemObjects object = listOfItems.get(pos);
		of.getBillTableModel().InsertRow(object);
	}
	
	public void initItemList(int row, int column) {
//		System.out.println("List is Printed");
		Vector<String> rowData = new Vector<String>();
		int pos = (row * 5) + (column);
		int counter = 0;
		gdd = new GetDepartmentDetails();
		GetItemDetails gi = new GetItemDetails();
		DepartmentObjects dobj = gdd.getListOfObjs().get(pos);
		gi.getItemDetails();
		ArrayList<ItemObjects> iobj = gi.getListOfObj();
		for (ItemObjects item : iobj) {
			gdd.getMapOfObj().get(item.getDeptCode()).add(item);
		}
		listOfItems = gdd.getMapOfObj().get(dobj.getPROP_ID());
		for (ItemObjects obj : listOfItems) 
		{
			if (counter == 5) 
			{
				counter = 0;
				of.getItemTable().addRow(rowData);
				rowData = new Vector<>();
			}
			rowData.add(obj.getItemName() + "\n ₹:" + obj.getItemMrp());
			counter += 1;
		}
		if(!rowData.isEmpty())
		{
			of.getItemTable().addRow(rowData);
		}
	}
}
