package OnlineShopping;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import com.BillOrder.Dao.ItemObjects;

public class ItemTableModel extends AbstractTableModel {
	private double totalAmount;
	protected Double TempValue;

	public Vector<Vector<ItemObjects>> getDataEntryList() {
		return DataEntryList;
	}
	public void setDataEntryList(Vector<Vector<ItemObjects>> dataEntryList) {
		DataEntryList = dataEntryList;
	}

	private Vector<Vector<ItemObjects>> DataEntryList;
	
	
	public ItemTableModel() {
		this.DataEntryList = new Vector<Vector<ItemObjects>>();
	}
	
	public ItemTableModel(Vector<Vector<ItemObjects>> itemObjects) {
		this.DataEntryList = itemObjects;
	}

	private final String[] columnNames = new String[] { "A", "B","C" ,"D", "E"};

	private final Class[] columnClass = new Class[] { String.class, String.class,String.class,String.class,String.class};

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
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemObjects row = DataEntryList.get(rowIndex).get(columnIndex);
		return row;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        @SuppressWarnings("unchecked")
	        ItemObjects rowVector = DataEntryList.get(rowIndex).get(columnIndex);
	        
	        fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void removeRow(int row) {
		DataEntryList.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	public void addRow(Vector<ItemObjects> al) {
		DataEntryList.add(al);
		fireTableDataChanged();
	}
	
}


