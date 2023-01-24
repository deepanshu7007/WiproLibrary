package OnlineShopping;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.BillOrder.Dao.BillMasterDao;
import com.BillOrder.Dao.BillTaxDao;
import com.BillOrder.Dao.DepartmentObjects;
import com.BillOrder.Dao.ItemObjects;
import com.Database.Model.Query.GetDepartmentDetails;
import com.Database.Model.Query.GetItemDetails;
import com.testPackages.ButtonActionsFrame;

public class InitFrame implements ActionListener {
	private Vector<Vector<ItemObjects>> itemTableData;
	private OrderFrame of;
	private GetItemDetails gtd;
	private GetDepartmentDetails gdd;
	private Vector<String> dptList;
	private ArrayList<ItemObjects> iobj;
	
	public ArrayList<ItemObjects> getIobj() {
		return iobj;
	}

	public void setIobj(ArrayList<ItemObjects> iobj) {
		this.iobj = iobj;
	}
public InitFrame() {
		gtd = new GetItemDetails();
		iobj = gtd.getItemDetails(false);
		this.of = new OrderFrame(this);
		of.getItemTable().removeRow(0);
		DepartmentObjects objects;
		gdd = new GetDepartmentDetails();
		
		int count = 0;
		of.getDeptTable().getDataVector().removeAllElements();
		dptList = new Vector<>();
		itemTableData = gtd.getItemTableData();
		for (int i = 0; i < gdd.getListOfObjs().size(); i++) {
			objects = gdd.getListOfObjs().get(i);
			if (count == 5) {
				count = 0;
				of.getDeptTable().addRow(dptList);
				dptList = new Vector<>();
			}
			dptList.add(objects.getPROP_NAME());
			count++;
		}
		if (!dptList.isEmpty()) {
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

	public void getListOfItem(int row, int col) {
		
		ItemObjects object = new ItemObjects();
		object.copyObjects(itemTableData.get(row).get(col));
		of.getBillTableModel().addRow(object);
	}
	

	public void initItemList(int row, int column) {
		Vector<String> rowData = new Vector<String>();
		int pos = (row * 5) + (column);
		int counter = 0;
		gdd = new GetDepartmentDetails();
		GetItemDetails gi = new GetItemDetails();
		DepartmentObjects dobj = gdd.getListOfObjs().get(pos);
		iobj = gi.getItemDetails(false);
		
		for (ItemObjects item : iobj) {
			gdd.getMapOfObj().get(item.getDeptCode()).add(item);
		}
		listOfItems = gdd.getMapOfObj().get(dobj.getPROP_ID());
		for (ItemObjects obj : listOfItems) {
			if (counter == 5) {
				counter = 0;
				of.getItemTable().addRow(rowData);
				rowData = new Vector<>();
			}
			rowData.add(obj.getItemName() + "\n ₹:" + obj.getItemMrp());
			counter += 1;
		}
		if (!rowData.isEmpty()) {
			of.getItemTable().addRow(rowData);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "SAVE") {
			java.text.SimpleDateFormat currentDate = new java.text.SimpleDateFormat("yyyy/MM/dd");
			BillMasterDao bmd = new BillMasterDao();
			bmd.setCustomer_Name(of.getCustomerField().getText());
			bmd.setCustomer_Id(of.getCustomerField().getText());
			String currentTime = currentDate.format(new Date());
			bmd.setBill_Date(currentTime);
			bmd.setBill_Mode("CASH");
			bmd.setBill_Value(Double.parseDouble(of.getTotalAmountField().getText()));
			ButtonActionsFrame baf = new ButtonActionsFrame();
			baf.SaveBillMaster(bmd);
			
			int billSerial = baf.getBillSerial();
			BillTaxDao btd = new BillTaxDao();
			ArrayList<BillTaxDao> listOfBill = new ArrayList<BillTaxDao>();
			ArrayList<ItemObjects> listOfItems = of.getBillTableModel().getDataEntryList();
			for(ItemObjects objects:listOfItems)
			{
				btd = new BillTaxDao();
				btd.setBill_Prefix("AC");
				btd.setBill_No(billSerial+1);
	 		btd.setBillNoWPrefix("AC-"+billSerial+1);
				btd.setItem_Code(objects.getItemCode());
				btd.setItem_Name(objects.getItemName());
				btd.setDate(currentTime);
				btd.setQtyToRemove(objects.getQtyToRemove());
				btd.setMRP(objects.getItemPrice());
				btd.setRate(objects.getItemPrice());
				btd.setAmount(objects.getItemMrp());
				listOfBill.add(btd);
			}
			baf.SaveBillDetails(listOfBill);
		}

	}

	public void clearTableOfItems() {
		of.getItemTable().getDataVector().clear();
		of.getItemTable().fireTableDataChanged();
	}

	public void initTableOfItems() {
		int counter=0;
		listOfItems = gtd.getItemDetails(true);
		Vector<String> rowData = new Vector<String>();
		for (ItemObjects obj : iobj) {
			if (counter == 5) {
				counter = 0;
				of.getItemTable().addRow(rowData);
				rowData = new Vector<>();
			}
			rowData.add(obj.getItemName() + "\n ₹:" + obj.getItemMrp());
			counter += 1;
		}
		if (!rowData.isEmpty()) {
			of.getItemTable().addRow(rowData);
		}
	}
}

