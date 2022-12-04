package OnlineShopping;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


/**
 * @version 1.0 11/09/98
 */
public class MultiLineCellTable extends JTable {
	public boolean isCellEditable(int row,int col)
	{
		return false;
	}
  MultiLineCellTable() {
	  
	  DefaultTableModel dm = new DefaultTableModel(new Object[][] {{"1"},{"2"},{"3"}},new Object[] {"","",""}) {
      public Class getColumnClass(int columnIndex) {
        return String.class;
      }
    };
    dm.setDataVector(new Object[][] { { "RASGULLA\n500.00", "GULABJAMUN\n600.00", "GULABJAMUN\n600.00","GULABJAMUN\n600.00","GULABJAMUN\n600.00","GULABJAMUN\n600.00","GULABJAMUN\n600.00" },
        { "GULABJAMUN\n600.00", "GULABJAMUN\n600.00", "GULABJAMUN\n600.00" } }, new Object[] { "1", "2", "3","4","5","6","7"});
    setModel(dm);

    
    setCellSelectionEnabled(true);
    int lines = 2;

    setRowHeight(getRowHeight() * lines+50);
    Dimension dim = new Dimension(10,2);
    setIntercellSpacing(new Dimension(dim));
    setFont(new Font("Dialog", Font.PLAIN, 12));
    setDefaultRenderer(String.class, new MultiLineCellRenderer());
    setShowGrid(false);
  }
  MultiLineCellTable(DefaultTableModel dtm)
  {
	    setCellSelectionEnabled(true);
	    int lines = 2;
	    setModel(dtm);
	    setRowHeight(getRowHeight() * lines+50);
	    Dimension dim = new Dimension(10,2);
	    setIntercellSpacing(new Dimension(dim));
	    setFont(new Font("Dialog", Font.PLAIN, 15));
	    setDefaultRenderer(String.class, new MultiLineCellRenderer());
	    setShowGrid(false);
  }
}


/**
 * @version 1.0 11/09/98
 */

class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

  public MultiLineCellRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(Color.WHITE);
      setBackground(Color.GRAY);
    }
    setFont(table.getFont());
    if (hasFocus) {
      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      if (table.isCellEditable(row, column)) {
        setForeground(UIManager.getColor("Table.focusCellForeground"));
        setBackground(UIManager.getColor("Table.focusCellBackground"));
      }
    } else {
      setBorder(new EmptyBorder(1, 2, 1, 2));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}


class ColumnColorRenderer extends DefaultTableCellRenderer {
	   Color backgroundColor, foregroundColor;
	   public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
	      super();
	      this.backgroundColor = backgroundColor;
	      this.foregroundColor = foregroundColor;
	   }
	   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
	      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	      cell.setBackground(backgroundColor);
	      cell.setForeground(foregroundColor);
	      return cell;
	   }
	}

