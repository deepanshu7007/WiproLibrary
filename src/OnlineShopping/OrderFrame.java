package OnlineShopping;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.BillOrder.Dao.ItemObjects;
import com.testPackages.FieldAction;

import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Insets;

public class OrderFrame extends JFrame {

	public JTable getTable_2() {
		return table_2;
	}

	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}

	private TableRowSorter<TableModel> sorter,sorter_1;
	private double totalAmount = 0.00;
	private JPanel contentPane;
	private JTextField MobileField;
	private JTable table;
	private JTextField CustomerField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField CodeField;
	private JTable table_1;
	private JTable table_2;
	private JLabel TotalAmountField;

	public void setTotalAmountField(JLabel totalAmount) {
		TotalAmountField = totalAmount;
	}

	public JLabel getTotalAmountField() {
		return TotalAmountField;
	}

	private DefaultTableModel DeptTable;
	private DefaultTableModel ItemTable;
	private JTextField SearchNameField;
	private BillTableModel etm;

	public BillTableModel getBillTableModel() {
		return etm;

	}

	public DefaultTableModel getItemTable() {
		return ItemTable;
	}

	public void setItemTable(DefaultTableModel itemTable) {
		ItemTable = itemTable;
	}

	
	public OrderFrame(InitFrame it) {
		DeptTable = new DefaultTableModel(1, 5);
		ItemTable = new DefaultTableModel(1, 5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1091, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(Color.WHITE);
		lblCompanyName.setOpaque(true);
		lblCompanyName.setBackground(Color.BLUE);
		lblCompanyName.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblCompanyName, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 115, 197, 0, 198, 131, 0, 0 };
		gbl_panel.rowHeights = new int[] { 34, 31, 0, 44, 69, 323, 197, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Shop" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);

		MobileField = new JTextField();
		MobileField.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				MobileField.setText("");
			}
		});

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Take Away" }));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 0;
		panel.add(comboBox_1, gbc_comboBox_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] { "Table No." }));
		GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1.gridwidth = 2;
		gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1.gridx = 2;
		gbc_comboBox_1_1.gridy = 0;
		panel.add(comboBox_1_1, gbc_comboBox_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 5;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);

		table_2 = new MultiLineCellTable(DeptTable) {
			public Class getColumnClass(int columnIndex) {
				return String.class;
			}
		};

		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int row = table_2.rowAtPoint(evt.getPoint());
				int col = table_2.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
					dtm.getDataVector().removeAllElements();
					it.initItemList(row, col);
				}

			}
		});

		scrollPane_1.setViewportView(table_2);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 1;
		panel.add(lblMobileNo, gbc_lblMobileNo);
		MobileField.setFont(new Font("Dialog", Font.PLAIN, 25));
		GridBagConstraints gbc_MobileField = new GridBagConstraints();
		gbc_MobileField.fill = GridBagConstraints.HORIZONTAL;
		gbc_MobileField.anchor = GridBagConstraints.NORTH;
		gbc_MobileField.insets = new Insets(0, 0, 5, 5);
		gbc_MobileField.gridx = 1;
		gbc_MobileField.gridy = 1;
		panel.add(MobileField, gbc_MobileField);
		MobileField.setColumns(10);

		JLabel lblCustname = new JLabel("Cust-Name");
		lblCustname.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCustname = new GridBagConstraints();
		gbc_lblCustname.fill = GridBagConstraints.BOTH;
		gbc_lblCustname.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustname.gridx = 2;
		gbc_lblCustname.gridy = 1;
		panel.add(lblCustname, gbc_lblCustname);

		CustomerField = new JTextField();
		CustomerField.setFont(new Font("Dialog", Font.PLAIN, 25));
		CustomerField.setColumns(10);
		GridBagConstraints gbc_CustomerField = new GridBagConstraints();
		gbc_CustomerField.fill = GridBagConstraints.BOTH;
		gbc_CustomerField.insets = new Insets(0, 0, 5, 5);
		gbc_CustomerField.gridx = 3;
		gbc_CustomerField.gridy = 1;
		panel.add(CustomerField, gbc_CustomerField);

		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 2;
		panel.add(lblCode, gbc_lblCode);

		CodeField = new JTextField();
		CodeField.setFont(new Font("Dialog", Font.PLAIN, 25));
		CodeField.setColumns(10);
		GridBagConstraints gbc_CodeField = new GridBagConstraints();
		gbc_CodeField.insets = new Insets(0, 0, 5, 5);
		gbc_CodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CodeField.gridx = 1;
		gbc_CodeField.gridy = 2;
		panel.add(CodeField, gbc_CodeField);

		JLabel lblSearchByName = new JLabel("Search by name");
		lblSearchByName.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSearchByName = new GridBagConstraints();
		gbc_lblSearchByName.anchor = GridBagConstraints.WEST;
		gbc_lblSearchByName.fill = GridBagConstraints.VERTICAL;
		gbc_lblSearchByName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchByName.gridx = 2;
		gbc_lblSearchByName.gridy = 2;
		panel.add(lblSearchByName, gbc_lblSearchByName);
		etm = new BillTableModel();
		table = new JTable(etm);
		sorter = new TableRowSorter<TableModel>();
		table.setRowSorter(sorter);
		
		sorter.setModel(etm);
		SearchNameField = new JTextField();
		SearchNameField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				it.clearTableOfItems();
				it.initTableOfItems();
			}
		});
		SearchNameField.addKeyListener(new KeyAdapter() {
			
		});
		
		SearchNameField.setFont(new Font("Dialog", Font.PLAIN, 25));
		SearchNameField.setColumns(10);
		GridBagConstraints gbc_SearchNameField = new GridBagConstraints();
		gbc_SearchNameField.insets = new Insets(0, 0, 5, 5);
		gbc_SearchNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SearchNameField.gridx = 3;
		gbc_SearchNameField.gridy = 2;
		panel.add(SearchNameField, gbc_SearchNameField);
		FieldAction fa = new FieldAction(it.getIobj());

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);

		table.getColumn("action").setCellRenderer(new ButtonCellRenderer());
		table.getColumn("action").setCellEditor(new ButtonCellEditor());
		table.getColumn("Qty").setCellEditor(new SpinnerEditor());
		table.getColumn("Qty").setCellRenderer(new SpinnerRenderer());

		table.setFont(new Font("Dialog", Font.PLAIN, 23));
		JTableHeader header = table.getTableHeader();

		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(26);
		table.getColumnModel().getColumn(1).setPreferredWidth(26);
		table.getColumnModel().getColumn(2).setPreferredWidth(26);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);

		header.setFont(new Font("Dialog", Font.PLAIN, 25));
		header.setPreferredSize(new Dimension(100, 50));

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 4;
		gbc_scrollPane_2.gridy = 5;
		panel.add(scrollPane_2, gbc_scrollPane_2);

		table_1 = new MultiLineCellTable(ItemTable) {

			public Class getColumnClass(int columnIndex) {
				return String.class;
			}
		};
		
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int row = table_1.rowAtPoint(evt.getPoint());
				int col = table_1.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					it.getListOfItem(row, col);
				}
			}
		});
		
		sorter_1 = new TableRowSorter<>(table_1.getModel());
		table_1.setRowSorter(sorter_1);
		
		SearchNameField.getDocument().addDocumentListener(new DocumentListener() {
	         @Override
	         public void insertUpdate(DocumentEvent e) {
	            search(SearchNameField.getText());
	         }
	         @Override
	         public void removeUpdate(DocumentEvent e) {
	            search(SearchNameField.getText());
	         }
	         @Override
	         public void changedUpdate(DocumentEvent e) {
	            search(SearchNameField.getText());
	         }
	         public void search(String str) {
	            if (str.length() == 0) {
	               sorter_1.setRowFilter(null);
	            } else {
	               sorter_1.setRowFilter(RowFilter.regexFilter(str));
	            }
	         }
	      });
		
//		table_1.getColumnModel().getColumn(0).setCellRenderer(renderer);
		scrollPane_2.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 69, 77, 80, 73, 0 };
		gbl_panel_1.rowHeights = new int[] { 24, 19, 10, 19, 2, 53, 53, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Remarks:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("2");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);

		JLabel lblLastBill = new JLabel("Last Bill:");
		lblLastBill.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblLastBill = new GridBagConstraints();
		gbc_lblLastBill.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLastBill.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastBill.gridx = 0;
		gbc_lblLastBill.gridy = 1;
		panel_1.add(lblLastBill, gbc_lblLastBill);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_1.add(textField_2, gbc_textField_2);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAmount.anchor = GridBagConstraints.NORTH;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 2;
		gbc_lblAmount.gridy = 1;
		panel_1.add(lblAmount, gbc_lblAmount);

		JLabel lblAmount_1 = new JLabel("0.00");
		lblAmount_1.setForeground(Color.RED);
		lblAmount_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAmount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_1 = new GridBagConstraints();
		gbc_lblAmount_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAmount_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAmount_1.gridx = 3;
		gbc_lblAmount_1.gridy = 1;
		panel_1.add(lblAmount_1, gbc_lblAmount_1);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.WEST;
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 4;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panel_1.add(separator, gbc_separator);

		JLabel lblNewLabel_1 = new JLabel("Date and Time:");
		lblNewLabel_1.setForeground(Color.RED);

		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		int timeDelay = 1000;
		ActionListener time;
		time = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {

			}
		};

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridwidth = 4;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 4;
		panel_1.add(separator_1, gbc_separator_1);

		JButton btnNewButton = new JButton("-250");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1_1_1_1 = new JButton("+250");
		btnNewButton_1_1_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_1_1.gridx = 1;
		gbc_btnNewButton_1_1_1_1.gridy = 5;
		panel_1.add(btnNewButton_1_1_1_1, gbc_btnNewButton_1_1_1_1);

		JButton btnNewButton_1_1_1_2 = new JButton("-500");
		btnNewButton_1_1_1_2.setBackground(Color.CYAN);
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1_1_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_1_2.gridx = 2;
		gbc_btnNewButton_1_1_1_2.gridy = 5;
		panel_1.add(btnNewButton_1_1_1_2, gbc_btnNewButton_1_1_1_2);

		JButton btnNewButton_1_1_1 = new JButton("+500");
		btnNewButton_1_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1_1.gridx = 3;
		gbc_btnNewButton_1_1_1.gridy = 5;
		panel_1.add(btnNewButton_1_1_1, gbc_btnNewButton_1_1_1);

		JButton btnNewButton_2 = new JButton("(F12)HOLD");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 6;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_2_2_1_1 = new JButton("(F11)UNHOLD");
		btnNewButton_2_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_2_1_1.setBackground(Color.BLUE);
		btnNewButton_2_2_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_2_1_1 = new GridBagConstraints();
		gbc_btnNewButton_2_2_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2_2_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2_2_1_1.gridx = 1;
		gbc_btnNewButton_2_2_1_1.gridy = 6;
		panel_1.add(btnNewButton_2_2_1_1, gbc_btnNewButton_2_2_1_1);

		JButton btnNewButton_2_2_1_2 = new JButton("(F2)REFRESH");
		btnNewButton_2_2_1_2.setForeground(Color.WHITE);
		btnNewButton_2_2_1_2.setBackground(Color.BLUE);
		btnNewButton_2_2_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_2_1_2 = new GridBagConstraints();
		gbc_btnNewButton_2_2_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_2_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2_2_1_2.gridx = 2;
		gbc_btnNewButton_2_2_1_2.gridy = 6;
		panel_1.add(btnNewButton_2_2_1_2, gbc_btnNewButton_2_2_1_2);

		JButton btnNewButton_2_2_1 = new JButton("(F6)CALCULATE");
		btnNewButton_2_2_1.setForeground(Color.WHITE);
		btnNewButton_2_2_1.setBackground(Color.BLUE);
		btnNewButton_2_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_2_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_2_1.gridx = 3;
		gbc_btnNewButton_2_2_1.gridy = 6;
		panel_1.add(btnNewButton_2_2_1, gbc_btnNewButton_2_2_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.RED, 2, true));
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1_1.gridx = 4;
		gbc_panel_1_1.gridy = 6;
		panel.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[] { 90, 82, 0, 82, 0 };
		gbl_panel_1_1.rowHeights = new int[] { 22, 21, 35, 22, 40, 30, 0 };
		gbl_panel_1_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1_1.setLayout(gbl_panel_1_1);

		JLabel lblAmount_2 = new JLabel("Amount");
		lblAmount_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2 = new GridBagConstraints();
		gbc_lblAmount_2.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2.gridx = 0;
		gbc_lblAmount_2.gridy = 0;
		panel_1_1.add(lblAmount_2, gbc_lblAmount_2);

		TotalAmountField = new JLabel("200");
		TotalAmountField.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_TotalAmount = new GridBagConstraints();
		gbc_TotalAmount.insets = new Insets(0, 0, 5, 5);
		gbc_TotalAmount.gridx = 1;
		gbc_TotalAmount.gridy = 0;
		panel_1_1.add(TotalAmountField, gbc_TotalAmount);

		JLabel lblAmount_2_1 = new JLabel("Discount");
		lblAmount_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1 = new GridBagConstraints();
		gbc_lblAmount_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1.gridx = 0;
		gbc_lblAmount_2_1.gridy = 1;
		panel_1_1.add(lblAmount_2_1, gbc_lblAmount_2_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_1_1.add(textField_4, gbc_textField_4);

		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 1;
		panel_1_1.add(label_1, gbc_label_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 1;
		panel_1_1.add(textField_5, gbc_textField_5);

		JLabel lblAmount_2_1_1 = new JLabel("GST Amount");
		lblAmount_2_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1.gridx = 0;
		gbc_lblAmount_2_1_1.gridy = 2;
		panel_1_1.add(lblAmount_2_1_1, gbc_lblAmount_2_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("0.00");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 2;
		panel_1_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		JLabel lblAmount_2_1_1_1 = new JLabel("Delivery Charges");
		lblAmount_2_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1_1.gridx = 0;
		gbc_lblAmount_2_1_1_1.gridy = 3;
		panel_1_1.add(lblAmount_2_1_1_1, gbc_lblAmount_2_1_1_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 3;
		panel_1_1.add(textField_6, gbc_textField_6);

		JLabel lblAmount_2_1_1_1_1_1 = new JLabel("Net Amount");
		lblAmount_2_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1_1_1_1.gridx = 0;
		gbc_lblAmount_2_1_1_1_1_1.gridy = 4;
		panel_1_1.add(lblAmount_2_1_1_1_1_1, gbc_lblAmount_2_1_1_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("200");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel_1_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("200");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3_1.gridx = 1;
		gbc_lblNewLabel_3_1.gridy = 5;
		panel_1_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(Color.RED, 2, true));
		GridBagConstraints gbc_panel_1_1_1 = new GridBagConstraints();
		gbc_panel_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1_1.gridx = 5;
		gbc_panel_1_1_1.gridy = 6;
		panel.add(panel_1_1_1, gbc_panel_1_1_1);
		GridBagLayout gbl_panel_1_1_1 = new GridBagLayout();
		gbl_panel_1_1_1.columnWidths = new int[] { 129, 0, 0 };
		gbl_panel_1_1_1.rowHeights = new int[] { 47, 0, 0, 0, 0, 0 };
		gbl_panel_1_1_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1_1_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1_1_1.setLayout(gbl_panel_1_1_1);

		JButton btnNewButton_1_1 = new JButton("(F11)SAVE & PRINT");
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1.gridx = 0;
		gbc_btnNewButton_1_1.gridy = 0;
		panel_1_1_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);

		JButton CashSaveButton = new JButton("SAVE ONLY");
		GridBagConstraints gbc_CashSaveButton = new GridBagConstraints();
		gbc_CashSaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_CashSaveButton.insets = new Insets(0, 0, 5, 5);
		gbc_CashSaveButton.gridx = 0;
		gbc_CashSaveButton.gridy = 1;
		panel_1_1_1.add(CashSaveButton, gbc_CashSaveButton);
		CashSaveButton.setActionCommand("SAVE");
		CashSaveButton.addActionListener(it);

		JButton btnNewButton_1_1_2_1_1 = new JButton("(F8)CREDIT CARD");
		GridBagConstraints gbc_btnNewButton_1_1_2_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_2_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_2_1_1.gridx = 0;
		gbc_btnNewButton_1_1_2_1_1.gridy = 2;
		panel_1_1_1.add(btnNewButton_1_1_2_1_1, gbc_btnNewButton_1_1_2_1_1);

		JButton btnNewButton_1_1_2_1_1_1_1 = new JButton("(F4) CREDIT");
		GridBagConstraints gbc_btnNewButton_1_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_2_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_2_1_1_1_1.gridx = 0;
		gbc_btnNewButton_1_1_2_1_1_1_1.gridy = 3;
		panel_1_1_1.add(btnNewButton_1_1_2_1_1_1_1, gbc_btnNewButton_1_1_2_1_1_1_1);

		JButton btnNewButton_1_1_2_1_1_1_1_1_1 = new JButton("(F7) ONLINE PAYMENT");
		GridBagConstraints gbc_btnNewButton_1_1_2_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_2_1_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1_2_1_1_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1_1_2_1_1_1_1_1_1.gridx = 0;
		gbc_btnNewButton_1_1_2_1_1_1_1_1_1.gridy = 4;
		panel_1_1_1.add(btnNewButton_1_1_2_1_1_1_1_1_1, gbc_btnNewButton_1_1_2_1_1_1_1_1_1);

		table.getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				BillTableModel model = (BillTableModel) table.getModel();
				totalAmount = model.getTotalAmount();
				TotalAmountField.setText(String.valueOf(totalAmount));
			}
		});
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public JTextField getMobileField() {
		return MobileField;
	}

	public void setMobileField(JTextField mobileField) {
		MobileField = mobileField;
	}

	public JTextField getCustomerField() {
		return CustomerField;
	}

	public void setCustomerField(JTextField customerField) {
		CustomerField = customerField;
	}

	public DefaultTableModel getDeptTable() {
		return DeptTable;
	}

	public void setDeptTable(DefaultTableModel deptTable) {
		DeptTable = deptTable;
	}

	public static class ButtonCellRenderer extends JButton implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Icon icon;
			if (value != null) {
				icon = new ImageIcon("/home/deepanshu/Desktop/trash.png");

				setIcon(icon);
			} else {
				icon = new ImageIcon("/home/deepanshu/Desktop/trash.png");

				setIcon(icon);
			}
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			return this;
		}
	}

	public static class SpinnerRenderer extends JSpinner implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value != null) {
				setValue(value);
				setFont(new Font("Dialog", Font.BOLD, 20));
			} else {
				setValue(value);
				setFont(new Font("Dialog", Font.BOLD, 20));
			}
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			return this;
		}

	}

	public static class SpinnerEditor extends DefaultCellEditor implements ChangeListener {
		private JSpinner spinner;
		private JTable table;

		public SpinnerEditor() {
			super(new JTextField());
			spinner = new JSpinner(new SpinnerNumberModel(1, -100, 100, 1));
			spinner.addChangeListener(this);
			spinner.setBorder(null);
			spinner.setFont(new Font("Dialog", Font.BOLD, 20));
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			spinner.setValue(value);
			return spinner;
		}

		public Object getCellEditorValue() {
			return spinner.getValue();
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			int qty = (int) spinner.getValue();
			BillTableModel model = (BillTableModel) table.getModel();
			model.setTotalAmount(model.getTotalAmount()
					- Double.parseDouble(table.getValueAt(table.getSelectedRow(), 3).toString()));
			double totalAmount = qty * Double.parseDouble(table.getValueAt(table.getSelectedRow(), 2).toString());
			model.increaseAmount(totalAmount);
//			System.out.println(totalAmount);
			table.setValueAt(totalAmount, table.getSelectedRow(), 3);

//			Double amount = qty*price;
////			
//			System.out.println(amount);
////			
//			
//			System.out.println(qty);

		}
	}

	public static class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

		private JButton editor;
		private Object value;
		private int row;
		private JTable table;

		public ButtonCellEditor() {
			editor = new JButton();
			editor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//                    System.out.println("Total Row Count"+table.getRowCount());
					if (table != null) {
						fireEditingStopped();
						TableModel model = table.getModel();
						if (model instanceof BillTableModel) {
							((BillTableModel) model).removeRow(row);
						}
					}
				}
			});
		}

		@Override
		public boolean isCellEditable(EventObject e) {
			return true;
		}

		@Override
		public Object getCellEditorValue() {
			return value;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.value = value;
			if (value != null) {
				editor.setText("Delete row " + value.toString());
			} else {
				editor.setText("Delete Me");
			}
			if (isSelected) {
				editor.setForeground(table.getSelectionForeground());
				editor.setBackground(table.getSelectionBackground());
			} else {
				editor.setForeground(table.getForeground());
				editor.setBackground(UIManager.getColor("Button.background"));
			}
			return editor;
		}
	}
}

