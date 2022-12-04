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
		int counter = 0;
		dptList = new Vector<>();
		gdd = new GetDepartmentDetails();
		of.getDeptTable().removeRow(0);
		for (DepartmentObjects objects : gdd.getListOfObjs()) {
			if (counter == 5) {
				counter = 0;
				of.getDeptTable().addRow(dptList);
				dptList = new Vector<>();
			}
			dptList.add(objects.getPROP_NAME());
			counter += 1;
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

	public void initItemList(int row, int column) {
		of.getItemTable().getDataVector().removeAllElements();
		Vector<String> rowData = new Vector<String>();
		int pos = (row*5) + (column);
		int counter = 0;
		GetDepartmentDetails gd = new GetDepartmentDetails();
		GetItemDetails gi = new GetItemDetails();
		DepartmentObjects dobj = gd.getListOfObjs().get(pos);
		gi.getItemDetails();
		ArrayList<ItemObjects> iobj = gi.getListOfObj();
		for(ItemObjects item: iobj)
		{
			gdd.getMapOfObj().get(item.getDeptCode()).add(item);
		}
		
		
		
		ArrayList<ItemObjects> listOfItems = gdd.getMapOfObj().get(dobj.getPROP_ID());
		for (ItemObjects obj : listOfItems) {
			if (counter == 5) {
				counter = 0;
				of.getItemTable().addRow(rowData);
				rowData = new Vector<String>();
			}
			System.out.println(obj.getItemName());
			rowData.add(obj.getItemName() + "\n" + obj.getItemMrp());
			counter += 1;
		}
		System.out.println(pos+"---");
	}
}
