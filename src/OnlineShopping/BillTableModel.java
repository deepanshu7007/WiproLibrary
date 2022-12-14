package OnlineShopping;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.BillOrder.Dao.ItemObjects;

public class BillTableModel extends AbstractTableModel {
	private double totalAmount;

	public ArrayList<ItemObjects> getDataEntryList() {
		return DataEntryList;
	}
	public void setDataEntryList(ArrayList<ItemObjects> dataEntryList) {
		DataEntryList = dataEntryList;
	}

	private ArrayList<ItemObjects> DataEntryList;
	
	protected Double TempValue;
	
	public BillTableModel() {
		this.DataEntryList = new ArrayList<>();
		totalAmount = 0.00;
	}
	
	public BillTableModel(ArrayList<ItemObjects> itemObjects) {
		this.DataEntryList = itemObjects;
		totalAmount = 0.00;
	}

	private final String[] columnNames = new String[] { "Name", "Qty","Price" ,"Amount", "action"};

	private final Class[] columnClass = new Class[] { String.class, Integer.class,Double.class,Double.class,Integer.class};

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return DataEntryList.size();
	}
	
	public ItemObjects GetRowData(int rowNumber)
	{
		return DataEntryList.get(rowNumber);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemObjects row = DataEntryList.get(rowIndex);
		if(columnIndex == 0)
			return row.getItemName();
		if(columnIndex == 1)
			return row.getQtyToRemove();
		else if(columnIndex == 3)
			return row.getItemMrp();
		else if(columnIndex == 2)
			return row.getItemPrice();
		else if(columnIndex == 4)
			return rowIndex;
		return row;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 1)
			return true;
		else if(columnIndex == 4)
			return true;
		else
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        @SuppressWarnings("unchecked")
	        ItemObjects rowVector = DataEntryList.get(rowIndex);
	        if(columnIndex==1)
	        	rowVector.setQtyToRemove((Integer)aValue);
	        else if(columnIndex==0)
	        	rowVector.setItemName(aValue.toString());
	        else if(columnIndex == 2)
	        	rowVector.setItemPrice(Double.parseDouble(aValue.toString()));
	        else if(columnIndex == 3)
	        	rowVector.setItemMrp(Double.parseDouble(aValue.toString()));
	        fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void removeRow(int row) {
		totalAmount = totalAmount - DataEntryList.remove(row).getItemMrp();
		fireTableRowsDeleted(row, row);
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void addRow(ItemObjects al) {
		DataEntryList.add(al);
		totalAmount = totalAmount + al.getItemMrp();
		fireTableDataChanged();
	}
	public void increaseAmount(double tamt)
	{
		totalAmount = totalAmount + tamt;
	}
}

