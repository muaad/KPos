package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Muaad
 */
public class SalesPanel extends javax.swing.JFrame {

	JPanel SalesPanel;
	JButton buttonAdd;
	JButton buttonSave;
	JComboBox comboName;
	JComboBox comboQuantity;
	JPanel jPanel3;
	JPanel jPanel4;
	JPanel jPanel6;
	JScrollPane jScrollPane1;
	JLabel lblBalance;
	JLabel lblName;
	JLabel lblPaid;
	JLabel lblQuantity;
	JLabel lblShowBalance;
	JLabel lblShowTotal;
	JLabel lblTotal;
	JTable tblItems;
	JTextField txtPaid;
	JPopupMenu popup;
	JMenuItem menuRemove, menuEdit, menuCancel, menuView;
	DefaultTableModel tblModel;
	EventHandler eHandler = new EventHandler();
	Vector<String> elements = null;
	List<String> products = new ArrayList<String>();
	MursalDB db = new MursalDB();
	String user = null, pass = null;

	public void createSalesPanel() {
		SalesPanel = new JPanel();
		jPanel3 = new JPanel();
		lblName = new JLabel();
		comboName = new JComboBox();
		lblQuantity = new JLabel();
		comboQuantity = new JComboBox();
		buttonAdd = new JButton();
		jPanel4 = new JPanel();
		jScrollPane1 = new JScrollPane();
		tblItems = new JTable();
		jPanel6 = new JPanel();
		lblTotal = new JLabel();
		lblShowTotal = new JLabel();
		lblPaid = new JLabel();
		txtPaid = new JTextField();
		lblBalance = new JLabel();
		lblShowBalance = new JLabel();
		buttonSave = new JButton();
		
		popup = new JPopupMenu();
		menuEdit = new JMenuItem(" Edit record ");
	    menuEdit.addActionListener(eHandler);
		//menuEdit.setToolTipText("You can edit the quantity field only. Other fields will get adjusted accordingly.");
	    popup.add(menuEdit);
	    popup.addSeparator();
		menuRemove = new JMenuItem(" Remove record ");
	    menuRemove.addActionListener(eHandler);
	    popup.add(menuRemove);
	    popup.addSeparator();
		menuCancel = new JMenuItem(" Cancel transaction ");
		menuCancel.addActionListener(eHandler);
	    popup.add(menuCancel); 
	    popup.addSeparator();
		menuView = new JMenuItem(" View sales table");
		menuView.addActionListener(eHandler);
		menuView.setToolTipText("This will let you edit/delete records not in this view");
	    popup.add(menuView); 
	    

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		SalesPanel.setBackground(new java.awt.Color(153, 204, 255));

		jPanel3.setBackground(new java.awt.Color(0, 51, 102));
		jPanel3.setBorder(new LineBorder(new java.awt.Color(153, 153, 255), 1,
				true));

		txtPaid.addActionListener(eHandler);
		//final StringBuffer paid = new StringBuffer();
		//txtPaid.setInputVerifier(new BlankFieldVerifier());
		final char numbers[] = {'0','1','2','3','4','5','6','7','8','9'};
		final char notAllowed[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
        		'/','"','!','@','#','$','%','*','&','^','(',')','`','~',',','.'};
		
		txtPaid.addKeyListener(new KeyListener() {
			StringBuffer paid = new StringBuffer();
			@Override
			public void keyTyped(KeyEvent e) {
				txtPaid.setText(paid.toString());
				try {
					int a = Integer.parseInt(txtPaid.getText()) / 2;
				} catch (NumberFormatException e2) {
					txtPaid.setText(paid.toString());
				}
				for (int i = 0; i < numbers.length; i++) {
					if(e.getKeyChar() == numbers[i]) {
						paid.append(e.getKeyChar());
						System.out.println(paid.toString());
						lblShowBalance.setText(Integer.parseInt(paid.toString()) - Integer.parseInt(lblShowTotal.getText())+"");
					}
					
					/*for (int j = 0; j < notAllowed.length; j++) {
						if(e.getKeyChar() == notAllowed[j]) {
							try {
								txtPaid.setText(txtPaid.getText().substring(0, txtPaid.getText().length() - 1));
								txtPaid.setText("");
								JOptionPane.showMessageDialog(null, "Oops!");
								txtPaid.setText(paid.toString());
							} catch (StringIndexOutOfBoundsException e1) {
								txtPaid.setText("");
							}
						}
					}*/
					
					
				}
				for (int j = 0; j < notAllowed.length; j++) {
					try {
						if(e.getKeyChar() == notAllowed[j]) {
							txtPaid.setText("");
							txtPaid.setText(paid.toString());
						}
						//txtPaid.setText(paid.toString());
					}
					catch (StringIndexOutOfBoundsException s1) {}
					
				}
				boolean alien = false;
				if(e.getKeyChar() == 8) {
					for (int j = 0; j < notAllowed.length; j++) {
						if((e.getKeyChar() == notAllowed[j])) {
							alien = true;
						}
						else {
							alien = false;
						}
												
					}
						
					if(alien) {
						if (paid.length() > 0 ) {
							try {
								System.out.println(paid.length());
								//paid.deleteCharAt(paid.length() - 1);
								//lblShowBalance.setText(Integer.parseInt(paid.toString()) - Integer.parseInt(lblShowTotal.getText())+"");
							}
							catch (StringIndexOutOfBoundsException e1) {}
							catch (NumberFormatException e1) {
								lblShowBalance.setText("-"+lblShowTotal.getText());
							}
						}
						else {
							
						}
					
					
					}
					else {
						lblShowBalance.setText(Integer.parseInt(paid.toString()) - Integer.parseInt(lblShowTotal.getText())+"");
						try {
							paid.deleteCharAt(paid.length() - 1);
						} catch (StringIndexOutOfBoundsException e1) {}
					}
				
				if (paid.length() == 0) {
					txtPaid.setText(paid.toString());
					txtPaid.setText("");
					lblShowBalance.setText("-"+lblShowTotal.getText());
				}
			}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println(e.getKeyChar());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.getKeyChar());
			}
		});
		
		lblName.setBackground(new java.awt.Color(153, 153, 255));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblName.setForeground(new java.awt.Color(0, 0, 204));
		lblName.setText("Enter item name");
		lblName.setBorder(new LineBorder(new java.awt.Color(102, 102, 255), 2,
				true));
		lblName.setFocusable(false);
		lblName.setOpaque(true);

		comboName.setBackground(new java.awt.Color(153, 153, 255));
		comboName.setEditable(true);
		final char [] alphaNumeric = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
        		'/','"','!','@','#','$','%','*','&','^','(',')','`','~',',','.',
        		'0','1','2','3','4','5','6','7','8','9',' '};
        comboName.getEditor().getEditorComponent().addKeyListener(new KeyListener() {
			
        	StringBuffer search = new StringBuffer();
        	List<String> l;
			@Override
			public void keyTyped(KeyEvent e) {
				for(int i = 0; i < alphaNumeric.length; i++) {
					if(e.getKeyChar() == alphaNumeric[i]) {	
						search.append(e.getKeyChar());
						//db.readProducts(search.toString());
						l = new ArrayList<String>();
						/*for (int k = 0; k < list.size(); k++) {
							if (compareStrings(search.toString(), list.get(k))) {
								l.add(list.get(k));
							}
						}*/
						for(String x : products) {
							containsIgnoreCase(x, search.toString(), l);
						}
						comboName.setModel(new javax.swing.DefaultComboBoxModel(l.toArray()));
						comboName.setSelectedItem(search.toString().substring(0, search.toString().length() - 1));
					}
				}
				if(((int)e.getKeyChar() == 8)) {
					if(search.length() > 0) {
						search.deleteCharAt(search.length() - 1);
						//db.readProducts(search.toString());
						l = new ArrayList<String>();
						/*for (int k = 0; k < list.size(); k++) {
							if (compareStrings(search.toString(), list.get(k))) {
								l.add(list.get(k));
							}
						}*/
						for(String x : products) {
							containsIgnoreCase(x, search.toString(), l);
						}
						if(search.length() == 0) {
							comboName.setModel(new javax.swing.DefaultComboBoxModel(products.toArray()));
						}
						else {
							comboName.setModel(new javax.swing.DefaultComboBoxModel(l.toArray()));
						}
				        comboName.setSelectedItem(search.toString());
					}
				}
				comboName.showPopup();
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		lblQuantity.setBackground(new java.awt.Color(153, 153, 255));
		lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblQuantity.setForeground(new java.awt.Color(0, 0, 204));
		lblQuantity.setText("Quantity");
		lblQuantity.setBorder(new LineBorder(new java.awt.Color(102, 102, 255),
				2, true));
		lblQuantity.setFocusable(false);
		lblQuantity.setOpaque(true);

		comboQuantity.setBackground(new java.awt.Color(153, 153, 255));
		comboQuantity.setEditable(true);
		comboQuantity.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10" }));

		buttonAdd.setBackground(new java.awt.Color(255, 153, 51));
		buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 12));
		buttonAdd.setText("Add");
		buttonAdd.addActionListener(eHandler);

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 165,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(comboName, GroupLayout.PREFERRED_SIZE,
								195, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE,
								85, GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addComponent(comboQuantity,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(42, 42, 42)
						.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE,
								101, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(92, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanel3Layout
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(lblName)
										.addComponent(comboName,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantity)
										.addComponent(comboQuantity,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonAdd))
						.addContainerGap()));

		jPanel4.setBackground(new java.awt.Color(0, 51, 102));
		jPanel4.setBorder(new LineBorder(new java.awt.Color(153, 153, 255), 1,
				true));

		/*
		 * tblItems.setAutoCreateRowSorter(true); tblItems.setBackground(new
		 * java.awt.Color(153, 153, 255)); tblItems.setBorder(new LineBorder(new
		 * java.awt.Color(153, 153, 255), 3, true)); tblItems.setFont(new
		 * java.awt.Font("Tahoma", 0, 14));
		 */

		tblModel = new DefaultTableModel();
		tblItems = new JTable(tblModel);
		tblModel.addColumn("Item name");
		tblModel.addColumn("Quantity");
		tblModel.addColumn("Price");
		tblModel.addColumn("Total");
	    MouseListener popupListener = new PopupListener(popup);
	    tblItems.addMouseListener(popupListener);


		jScrollPane1.setViewportView(tblItems);

		jPanel6.setBackground(new java.awt.Color(0, 51, 102));
		jPanel6.setBorder(new LineBorder(new java.awt.Color(153, 153, 255), 1,
				true));

		lblTotal.setBackground(new java.awt.Color(153, 153, 255));
		lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblTotal.setForeground(new java.awt.Color(0, 0, 204));
		lblTotal.setText("Total amount");
		lblTotal.setBorder(new LineBorder(new java.awt.Color(102, 102, 255), 2,
				true));
		lblTotal.setFocusable(false);
		lblTotal.setOpaque(true);

		lblShowTotal.setBackground(new java.awt.Color(153, 153, 255));
		lblShowTotal.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblShowTotal.setForeground(new java.awt.Color(0, 0, 204));
		lblShowTotal.setBorder(new LineBorder(
				new java.awt.Color(102, 102, 255), 2, true));
		lblShowTotal.setFocusable(false);
		lblShowTotal.setOpaque(true);

		lblPaid.setBackground(new java.awt.Color(153, 153, 255));
		lblPaid.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblPaid.setForeground(new java.awt.Color(0, 0, 204));
		lblPaid.setText("Amount paid");
		lblPaid.setBorder(new LineBorder(new java.awt.Color(102, 102, 255), 2,
				true));
		lblPaid.setFocusable(false);
		lblPaid.setOpaque(true);

		lblBalance.setBackground(new java.awt.Color(153, 153, 255));
		lblBalance.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblBalance.setForeground(new java.awt.Color(0, 0, 204));
		lblBalance.setText("Balance");
		lblBalance.setBorder(new LineBorder(new java.awt.Color(102, 102, 255),
				2, true));
		lblBalance.setFocusable(false);
		lblBalance.setOpaque(true);

		lblShowBalance.setBackground(new java.awt.Color(153, 153, 255));
		lblShowBalance.setFont(new java.awt.Font("Tahoma", 1, 14));
		lblShowBalance.setForeground(new java.awt.Color(0, 0, 204));
		lblShowBalance.setBorder(new LineBorder(new java.awt.Color(102, 102,
				255), 2, true));
		lblShowBalance.setFocusable(false);
		lblShowBalance.setOpaque(true);

		buttonSave.setBackground(new java.awt.Color(255, 153, 51));
		buttonSave.setFont(new java.awt.Font("Tahoma", 1, 12));
		buttonSave.setText("Save Transaction");
		buttonSave.addActionListener(eHandler);

		GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE,
								105, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblShowTotal, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 101,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtPaid, GroupLayout.PREFERRED_SIZE, 111,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE,
								65, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblShowBalance,
								GroupLayout.PREFERRED_SIZE, 106,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE,
								152, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addGap(17, 17, 17)
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																lblShowBalance,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																buttonSave)
														.addGroup(
																jPanel6Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addComponent(
																				lblShowTotal,
																				GroupLayout.PREFERRED_SIZE,
																				31,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				jPanel6Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								lblBalance,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtPaid,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblPaid,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				lblTotal,
																				GroupLayout.PREFERRED_SIZE,
																				31,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(19, Short.MAX_VALUE)));

		jPanel6Layout.linkSize(SwingConstants.VERTICAL,
				new java.awt.Component[] { lblPaid, lblShowTotal, txtPaid });

		jPanel6Layout.linkSize(SwingConstants.VERTICAL,
				new java.awt.Component[] { buttonSave, lblShowBalance });

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel4Layout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanel4Layout
										.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
										.addComponent(jPanel6,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jScrollPane1))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
								400, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		GroupLayout SalesPanelLayout = new GroupLayout(SalesPanel);
		SalesPanel.setLayout(SalesPanelLayout);
		SalesPanelLayout
				.setHorizontalGroup(SalesPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								SalesPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												SalesPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel3,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.PREFERRED_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel4,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.PREFERRED_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		SalesPanelLayout.setVerticalGroup(SalesPanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				SalesPanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
	}
	
	private void containsIgnoreCase(String s, String a, List<String> l) {
    	int aHash = 0, sHash = 0;
		StringBuffer sb = new StringBuffer();
		for(String x : a.split("")) {
			aHash = x.hashCode();
			for(String y : s.split("")) {
				sHash = y.hashCode();
				if(sHash - aHash == 32) {
					x = x.toLowerCase();
				}
				else if(aHash - sHash == 32) {
					x = x.toUpperCase();
				}
				
			}
			sb.append(x);
		}
		if(s.contains(sb.toString())) {
			l.add(s);
		}
	}
	
	class PopupListener extends MouseAdapter {
        JPopupMenu popup;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
    }
	
	/*JDesktopPane desktop;
	
	protected void createFrame() {
		PostInternalFrame frame = new PostInternalFrame();
		frame.setVisible(true); //necessary as of 1.3
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}*/
	
	List<Integer> quantityB4 = new LinkedList<Integer>();
	
	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonAdd) {
				try {
					elements = new Vector<String>(3);

					db.name = (String) comboName.getSelectedItem();
					db.enteredQuantity = Integer.parseInt(comboQuantity.getSelectedItem().toString());
					// sd.total = sd.price *
					// Integer.parseInt(String.valueOf(comboQuantity.getSelectedItem()));
					db.user = user;
					db.pass = pass;
					db.connect();
					db.updateRecords();
					if(db.quantity <= 0) {
						db.replenishInventory();
					}
					elements.add((String) db.name);
					elements.add(String.valueOf(db.enteredQuantity));
					elements.add((int) db.price + "");
					elements.add(((int) db.price * Integer.parseInt(String
							.valueOf(comboQuantity.getSelectedItem()))) + "");
					db.recordSales();
					//System.out.println(db.time);

					tblModel.addRow(elements);
					/*for (int i = 0; i < tblModel.getRowCount(); i++) {
						quantityB4.add(Integer.parseInt(tblModel.getValueAt(i, 1).toString()));
					}System.out.println(quantityB4);*/
					//tblItems.setFillsViewportHeight(true);
					//tblItems.setShowGrid(true);
					tblItems.setRowSelectionAllowed(true);
					tblItems.setAutoCreateRowSorter(true);
					tblItems.setBackground(new Color(153,204,255));
					//tblItems.setBorder(new LineBorder(new Color(153, 153, 255),3, true));
					tblItems.setFont(new Font("Tahoma", 0, 14));
					int grandTotal = 0;
					for (int i = 0; i < tblModel.getRowCount(); i++) {
						grandTotal += Integer.parseInt(tblModel.getValueAt(i,3).toString());
						
					}
					lblShowTotal.setText(grandTotal+"");
					db.total = grandTotal;
					/*
					 * if(db.quantity <= 1000) {
					 * lblWarning.setText("Stock Low!!"); } else {
					 * lblWarning.setText(""); }
					 */
				} catch (SQLException se) {
					se.printStackTrace();
				}

				txtPaid.setText("");
				txtPaid.requestFocus();
				lblShowBalance.setText("");
			}
			
			if(e.getSource() == menuRemove) {
				if(tblItems.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a row!!", "Remove", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					int grandTotal = 0;
					//System.out.println(grandTotal);
					int row = tblItems.getSelectedRow();
					try {
						db.dateToDelete = db.time.get(row);
						db.time.remove(row);
						db.deleteSalesRecord();
					}
					catch (IndexOutOfBoundsException e1) {}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					try {
						db.name = (String) tblModel.getValueAt(row, 0);
						db.enteredQuantity = Integer.parseInt(tblModel.getValueAt(row, 1).toString());
					} catch (ArrayIndexOutOfBoundsException e2) {}
					//System.out.println(db.name+" "+db.enteredQuantity);
					try {
						db.updateInventoryAfterDelete();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						tblModel.removeRow(row);
					} catch (IndexOutOfBoundsException e2) {}
					try {
						for (int i = 0; i < tblModel.getRowCount(); i++) {
							grandTotal += Integer.parseInt(tblModel.getValueAt(i,3).toString());							
						}
						lblShowTotal.setText(grandTotal +"");
					} catch (ArrayIndexOutOfBoundsException e1) {}
					
					if(tblModel.getRowCount() == 0) {
						db.total = 0;
					}
					/*int [] records = tblItems.getSelectedRows();
					for (int i = records.length - 1; i < 0; i--) {
						tblModel.removeRow(i);
					}
					for (int i = 0; i < records.length; i++) {
						int row = records[i];
						db.dateToDelete = db.time.get(row);
						try {
							db.deleteSalesRecord();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							db.name = (String) tblModel.getValueAt(row, 0);
							db.enteredQuantity = Integer.parseInt(tblModel.getValueAt(row, 1).toString());
						} catch (ArrayIndexOutOfBoundsException e2) {}
						System.out.println(db.name);
						try {
							db.updateSalesAfterDelete();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tblModel.removeRow(row);
						if(row == records.length - 1)
						tblModel.removeRow(records[records.length - 2]);
						int grandTotal = 0;
						for (int j = 0; j < tblModel.getRowCount(); j++) {
							grandTotal += Integer.parseInt(tblModel.getValueAt(i,3).toString());
						}
						try {
							totalRemoved = totalRemoved + Integer.parseInt(tblModel.getValueAt(row, 3).toString());
						} catch (ArrayIndexOutOfBoundsException e1) {}*/
						//lblShowTotal.setText(grandTotal +"");
						//grandTotal = 0;
					//}
					//grandTotal = 0;
					//totalRemoved = 0;
					/*for (int i = records.length - 1; i < 0; i--) {
						tblModel.removeRow(i);
					}*/
				}
			}
			
			if(e.getSource() == menuEdit) {
				int row = tblItems.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Double click the cell you want to edit, press ENTER after editing,\n" +
							"right click again and click EDIT. If you want to make wholesale changes to a row, \nconsider just removing it and adding a\n" +
							"new one.");
				}
				else {
					try {
						db.mapProductToPrice();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						db.dateToEdit = db.time.get(row);
					} catch (IndexOutOfBoundsException e2) {}
					db.enteredQuantity = Integer.parseInt(tblModel.getValueAt(row, 1).toString());
					//db.newTotal = db.enteredQuantity * db.priceMap.get(tblModel.getValueAt(row, 0).toString());
					//System.out.println(db.newTotal);
					//tblModel.setValueAt(db.priceMap.get(tblModel.getValueAt(row, 0).toString()), row, 2);
					db.newTotal = Integer.parseInt(tblModel.getValueAt(row, 2).toString()) * db.enteredQuantity;
					tblModel.setValueAt(db.productMap.get(db.time.get(row)), row, 0);
					tblModel.setValueAt(db.enteredQuantity, row, 1);
					tblModel.setValueAt(db.newTotal, row, 3);
					int grandTotal = 0;
					try {
						for (int i = 0; i < tblModel.getRowCount(); i++) {
							grandTotal += Integer.parseInt(tblModel.getValueAt(i,3).toString());							
						}
						lblShowTotal.setText(grandTotal +"");
					} catch (ArrayIndexOutOfBoundsException e1) {}
					try {
						db.updateInventoryAfterEdit();
						db.editSalesRecord(Integer.parseInt(tblModel.getValueAt(row, 2).toString()));
						db.enteredQuantity = Integer.parseInt(tblModel.getValueAt(row,1).toString());
						db.updateRecords();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*try {
						db.time.remove(row);
					} catch (IndexOutOfBoundsException e1) {}*/
				}
			}
			
			if(e.getSource() == menuCancel) {
				cancelTransaction();
			}
			
			if (e.getSource() == buttonSave || e.getSource() == txtPaid) {
				db.total = 0;
				for (int i = 0; i < tblModel.getRowCount(); i++) {	
					db.total = db.total + Integer.parseInt(tblItems.getValueAt(i, 3).toString());
				}
				recordTransaction();
			}
		}
	}
	
	public void cancelTransaction() {
		for (int i = 0; i < db.time.size(); i++) {
			db.dateToDelete = db.time.get(i);
			try {
				db.deleteSalesRecord();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			for (int i = 0; i < tblModel.getRowCount(); i++) {
				db.name = (String) tblModel.getValueAt(i, 0);
				db.enteredQuantity = Integer.parseInt(tblModel.getValueAt(i, 1)
						.toString());
				try {
					db.updateInventoryAfterDelete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e2) {}
		//System.out.println(db.name+" "+db.enteredQuantity);
		
		for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
			tblModel.removeRow(i);
		}
		txtPaid.setText("");
		lblShowBalance.setText("");
		lblShowTotal.setText("");
	}
	
	public void recordTransaction() {
		try {		
			db.amount_paid = Integer.parseInt(txtPaid.getText());
			db.balance = db.amount_paid - db.total;
			lblShowBalance.setText(db.balance + "");
			if(db.total > 0) {
				if (db.balance >= 0) {
					try {
						db.recordTransaction();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					db.total = 0;
					for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
						tblModel.removeRow(i);
					}
				}
				else {
					int choice = JOptionPane.showConfirmDialog(null, "You are still owed "+String.valueOf(db.balance).substring(1)+
							" Kshs! Do you want to give it as discount?", "Discount", JOptionPane.YES_NO_OPTION);
					if(choice == 0) {
						db.discount = db.balance * -1;
						try {
							db.recordTransaction();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						db.total = 0;
						for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
							tblModel.removeRow(i);
						}
					}
					else {
						Object[] options = { "Request for more money", "Cancel transaction", "Add to a postpaid account" };
						int option = JOptionPane.showOptionDialog(null, "What do you want to do next?", "Now... What next?",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, options, options[2]);
						if(option == 0) {
							txtPaid.setText("");
							lblShowBalance.setText("");
							txtPaid.requestFocus();
						}
						else if(option == 1) {
							cancelTransaction();
						}
						else {
							post.createGUI();
						}
					}
				}
			}
			else {
				txtPaid.setText("");
				lblShowBalance.setText("");
				JOptionPane.showMessageDialog(null, "You haven't sod anything yet.", "Not allowed", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "Input amount paid first!");
			txtPaid.requestFocus();
			txtPaid.setText("");
		}

		// OR.....

		/*
		 * while(tblModel.getRowCount() > 0) { tblModel.removeRow(0); }
		 */

		// OR..... though not working yet.

		// tblModel.getDataVector().removeAllElements();

	}
	

	
	private class BlankFieldVerifier extends InputVerifier {

	       public boolean verify(JComponent comp) {
	           JTextField fld = (JTextField) comp;
	           String content = fld.getText();

	           boolean isValid = true;
	           if (content.length() == 0) {
	               JOptionPane.showMessageDialog(null, "Field cannot be blank.");
	               isValid = false;
	           }

	           return isValid;
	       }

	       public boolean shouldYieldFocus(JComponent input) {
	           boolean valid = super.shouldYieldFocus(input);

	           if (!valid) {
	               //sp.getToolkit().beep();
	           }
	           return valid;
	       }

	   }
	
	PostPaidDialod post = new PostPaidDialod();
	
	class PostPaidDialod {
		JLabel addressLabel, balanceLabel, currentLabel, dueLabel, idLabel, limitLabel, nameLabel, paidLabel, totalLabel;
	    JButton cancelButton, saveButton;
	    JComboBox comboID;
	    JPanel contPanel, topPanel;
	    JTextField txtAddress, txtBalance, txtCurrent, txtDue, txtLimit, txtName, txtPaid, txtTotal;
	    JDialog dialog;
	    
	    void createGUI() {
	    	dialog = new JDialog();
	        topPanel = new javax.swing.JPanel();
	        contPanel = new javax.swing.JPanel();
	        idLabel = new javax.swing.JLabel();
	        txtName = new javax.swing.JTextField();
	        paidLabel = new javax.swing.JLabel();
	        nameLabel = new javax.swing.JLabel();
	        txtAddress = new javax.swing.JTextField();
	        comboID = new javax.swing.JComboBox();
	        txtLimit = new javax.swing.JTextField();
	        currentLabel = new javax.swing.JLabel();
	        txtTotal = new javax.swing.JTextField();
	        txtDue = new javax.swing.JTextField();
	        txtCurrent = new javax.swing.JTextField();
	        txtPaid = new javax.swing.JTextField();
	        balanceLabel = new javax.swing.JLabel();
	        addressLabel = new javax.swing.JLabel();
	        dueLabel = new javax.swing.JLabel();
	        limitLabel = new javax.swing.JLabel();
	        totalLabel = new javax.swing.JLabel();
	        txtBalance = new javax.swing.JTextField();
	        saveButton = new javax.swing.JButton();
	        cancelButton = new javax.swing.JButton();
	        
	        dialog.setIconImage(new ImageIcon("F:\\POSWorkspace\\POS\\sale.png").getImage());
	        dialog.setTitle("Add to Postpaid Account");
	        dialog.setModal(true);	
	        
	        topPanel.setBackground(new java.awt.Color(0, 51, 102));

	        contPanel.setBackground(new java.awt.Color(153, 204, 255));

	        idLabel.setBackground(new java.awt.Color(153, 153, 255));
	        idLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        idLabel.setForeground(new java.awt.Color(0, 0, 204));
	        idLabel.setText("ID number");
	        idLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        idLabel.setOpaque(true);

	        paidLabel.setBackground(new java.awt.Color(153, 153, 255));
	        paidLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        paidLabel.setForeground(new java.awt.Color(0, 0, 204));
	        paidLabel.setText("Paid");
	        paidLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        paidLabel.setOpaque(true);

	        nameLabel.setBackground(new java.awt.Color(153, 153, 255));
	        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        nameLabel.setForeground(new java.awt.Color(0, 0, 204));
	        nameLabel.setText("Full name");
	        nameLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        nameLabel.setOpaque(true);

	        comboID.setEditable(true);
	        comboID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        currentLabel.setBackground(new java.awt.Color(153, 153, 255));
	        currentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        currentLabel.setForeground(new java.awt.Color(0, 0, 204));
	        currentLabel.setText("Current transaction");
	        currentLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        currentLabel.setOpaque(true);

	        txtTotal.setEditable(false);
	        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
	        
			post.txtPaid.setText(Integer.parseInt(lblShowTotal.getText()) + db.balance +"");
			post.txtCurrent.setText(lblShowTotal.getText());
			post.txtBalance.setText(String.valueOf(db.balance).substring(1));

	        balanceLabel.setBackground(new java.awt.Color(153, 153, 255));
	        balanceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        balanceLabel.setForeground(new java.awt.Color(0, 0, 204));
	        balanceLabel.setText("Balance owing");
	        balanceLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        balanceLabel.setOpaque(true);

	        addressLabel.setBackground(new java.awt.Color(153, 153, 255));
	        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        addressLabel.setForeground(new java.awt.Color(0, 0, 204));
	        addressLabel.setText("Address");
	        addressLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        addressLabel.setOpaque(true);

	        dueLabel.setBackground(new java.awt.Color(153, 153, 255));
	        dueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        dueLabel.setForeground(new java.awt.Color(0, 0, 204));
	        dueLabel.setText("Due date");
	        dueLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        dueLabel.setOpaque(true);

	        limitLabel.setBackground(new java.awt.Color(153, 153, 255));
	        limitLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        limitLabel.setForeground(new java.awt.Color(0, 0, 204));
	        limitLabel.setText("Limit");
	        limitLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        limitLabel.setOpaque(true);

	        totalLabel.setBackground(new java.awt.Color(153, 153, 255));
	        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        totalLabel.setForeground(new java.awt.Color(0, 0, 204));
	        totalLabel.setText("Toal owing");
	        totalLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
	        totalLabel.setOpaque(true);

	        saveButton.setBackground(new java.awt.Color(255, 153, 51));
	        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
	        saveButton.setText("Save Transaction");
	        saveButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 102), 1, true));
	        saveButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					db.user = user;
					db.pass = pass;
					
					db.natID = Integer.parseInt(comboID.getSelectedItem().toString());
					db.customerName = txtName.getText();
					db.address = txtAddress.getText();
					db.limit = Double.parseDouble(txtLimit.getText());
					db.dueDate = txtDue.getText();
					
					db.registerPostpaidCustomer();
					
				}
			});

	        cancelButton.setBackground(new java.awt.Color(255, 153, 51));
	        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
	        cancelButton.setText("Cancel");
	        cancelButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 102), 1, true));

	        javax.swing.GroupLayout contPanelLayout = new javax.swing.GroupLayout(contPanel);
	        contPanel.setLayout(contPanelLayout);
	        contPanelLayout.setHorizontalGroup(
	            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(contPanelLayout.createSequentialGroup()
	                        .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(currentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(limitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(dueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(paidLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(balanceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(comboID, 0, 185, Short.MAX_VALUE)
	                            .addComponent(txtName)
	                            .addComponent(txtAddress)
	                            .addComponent(txtLimit)
	                            .addComponent(txtDue)
	                            .addComponent(txtCurrent)
	                            .addComponent(txtPaid)
	                            .addComponent(txtTotal)
	                            .addComponent(txtBalance))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(contPanelLayout.createSequentialGroup()
	                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        contPanelLayout.setVerticalGroup(
	            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(comboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(limitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(dueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(currentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(paidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(cancelButton))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        contPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, saveButton});

	        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
	        topPanel.setLayout(topPanelLayout);
	        topPanelLayout.setHorizontalGroup(
	            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(topPanelLayout.createSequentialGroup()
	                .addGap(49, 49, 49)
	                .addComponent(contPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(56, Short.MAX_VALUE))
	        );
	        topPanelLayout.setVerticalGroup(
	            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(topPanelLayout.createSequentialGroup()
	                .addGap(29, 29, 29)
	                .addComponent(contPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGap(24, 24, 24))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(dialog.getContentPane());
	        dialog.getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );
	        
	        center(dialog);
	        dialog.pack();
	        dialog.setVisible(true);
	    
		}
	    
	    private void center( Window window ) {

	        // Get the size of the screen
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	        // Determine the new location of the window
	        int w = window.getSize().width;
	        int h = window.getSize().height;
	        int x = (dim.width - w) / 5;
	        int y = ((dim.height - h) / (dim.height - h)) + 35;

	        // Move the window
	        window.setLocation(x, y);
	    }
	}
}