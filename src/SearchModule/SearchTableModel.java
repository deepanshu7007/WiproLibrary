package SearchModule;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import com.BillOrder.Dao.ItemObjects;

public class SearchTableModel extends AbstractTableModel {

	private ArrayList<ItemObjects> DataEntryList;
	protected Double TempValue;
//	private Object bValue;

	public SearchTableModel(ArrayList<ItemObjects> ItemList) {
		this.DataEntryList = ItemList;
	}

	private final String[] columnNames = new String[] { "Item Name", "Item Code" };

	private final Class[] columnClass = new Class[] { String.class, String.class};

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
				if (0 == columnIndex) {
			return row.getItemName();
		} else if (1 == columnIndex) {
			return row.getItemCode();
		} 
				return row;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        @SuppressWarnings("unchecked")
	        ItemObjects rowVector = DataEntryList.get(rowIndex);
	        if(columnIndex==1)
	        {
	        	rowVector.setItemName(aValue.toString());
	        }
	        if(columnIndex==0)
	        	rowVector.setItemName(aValue.toString());
	        fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void removeRow(int row) {
		DataEntryList.remove(row);
		fireTableRowsDeleted(row, row);
	}

	public void addRow(ItemObjects al) {
		DataEntryList.add(al);
		fireTableDataChanged();
	}
	
}

