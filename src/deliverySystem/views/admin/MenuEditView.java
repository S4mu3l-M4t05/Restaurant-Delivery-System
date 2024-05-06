package deliverySystem.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuEditView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar AdminMenuBar;
	private JMenu mnFile;
	private JMenu mnRestaurant;
	private JMenu mnMenu;
	private JMenu mnDeliveryMan;
	private JMenuItem mntmDisconnect;
	private JMenuItem mntmQuit;
	private JMenuItem mntmRestaurantCreate;
	private JMenuItem mntmRestaurantEdit;
	private JMenuItem mntmMenuCreate;
	private JMenuItem mntmMenuEdit;
	private JMenuItem mntmDeliverymanCreate;
	private JMenuItem mntmDeliverymanEdit;
	private JPanel MenuPane;
	private JPanel RestaurantPane;
	private JLabel lblRestaurant;
	private JButton btnSelect;
	private JLabel lblAddItem;
	private JLabel lblItemName;
	private JLabel lblPrice;
	private JTextField txtItemName;
	private JTextField txtPrice;
	private JButton btnAddItem;
	private JLabel lblEditMenu;
	private JButton btnEditMenu;
	private JList listMenu;
	private JScrollPane scrollPane;
	private JTable tableRestaurants;

	public MenuEditView() {
		setTitle("Food Ordering Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 564);

		AdminMenuBar = new JMenuBar();
		setJMenuBar(AdminMenuBar);

		mnFile = new JMenu("File");
		AdminMenuBar.add(mnFile);

		mntmDisconnect = new JMenuItem("Disconnect");
		mnFile.add(mntmDisconnect);

		mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);

		mnRestaurant = new JMenu("Restaurant");
		AdminMenuBar.add(mnRestaurant);

		mntmRestaurantCreate = new JMenuItem("Create");
		mnRestaurant.add(mntmRestaurantCreate);

		mntmRestaurantEdit = new JMenuItem("Edit/Delete");
		mnRestaurant.add(mntmRestaurantEdit);

		mnMenu = new JMenu("Menu");
		AdminMenuBar.add(mnMenu);

		mntmMenuCreate = new JMenuItem("Create");
		mnMenu.add(mntmMenuCreate);

		mntmMenuEdit = new JMenuItem("Edit/Delete");
		mnMenu.add(mntmMenuEdit);

		mnDeliveryMan = new JMenu("Delivery Man");
		AdminMenuBar.add(mnDeliveryMan);

		mntmDeliverymanCreate = new JMenuItem("Create");
		mnDeliveryMan.add(mntmDeliverymanCreate);

		mntmDeliverymanEdit = new JMenuItem("Edit/Delete");
		mnDeliveryMan.add(mntmDeliverymanEdit);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(),
						Color.decode("#141c26")));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		MenuPane = new JPanel();
		MenuPane.setBackground(Color.decode("#28384d"));
		MenuPane.setBounds(231, 79, 284, 396);
		contentPane.add(MenuPane);
		MenuPane.setLayout(null);

		lblAddItem = new JLabel("Change Item");
		lblAddItem.setForeground(new Color(255, 255, 255));
		lblAddItem.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblAddItem.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAddItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddItem.setBounds(58, 18, 165, 30);
		MenuPane.add(lblAddItem);

		lblItemName = new JLabel("Item  :");
		lblItemName.setForeground(new Color(255, 255, 255));
		lblItemName.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblItemName.setBounds(33, 90, 82, 14);
		MenuPane.add(lblItemName);

		lblPrice = new JLabel("Price :");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblPrice.setBounds(33, 128, 82, 30);
		MenuPane.add(lblPrice);

		txtItemName = new JTextField();
		txtItemName.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		txtItemName.setBounds(135, 82, 139, 30);
		MenuPane.add(txtItemName);
		txtItemName.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		txtPrice.setBounds(135, 128, 139, 30);
		MenuPane.add(txtPrice);
		txtPrice.setColumns(10);

		btnAddItem = new JButton("Save Changes");
		btnAddItem.setBackground(new Color(255, 255, 255));
		btnAddItem.setForeground(new Color(0, 0, 0));
		btnAddItem.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAddItem.setBounds(135, 182, 139, 40);
		MenuPane.add(btnAddItem);

		lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setForeground(new Color(255, 255, 255));
		lblRestaurant.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblRestaurant.setBounds(10, 49, 199, 20);
		contentPane.add(lblRestaurant);
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);

		btnSelect = new JButton("Select");
		btnSelect.setBackground(new Color(255, 255, 255));
		btnSelect.setForeground(new Color(0, 0, 0));
		btnSelect.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		btnSelect.setBounds(10, 435, 199, 40);
		contentPane.add(btnSelect);

		lblEditMenu = new JLabel("Edit Menu");
		lblEditMenu.setForeground(new Color(255, 255, 255));
		lblEditMenu.setBounds(278, 24, 184, 30);
		contentPane.add(lblEditMenu);
		lblEditMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 23));
		lblEditMenu.setHorizontalAlignment(SwingConstants.CENTER);

		btnEditMenu = new JButton("Update");
		btnEditMenu.setBounds(531, 435, 199, 40);
		contentPane.add(btnEditMenu);
		btnEditMenu.setBackground(new Color(255, 255, 255));
		btnEditMenu.setForeground(new Color(0, 0, 0));
		btnEditMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblMenu.setBounds(531, 49, 199, 20);
		contentPane.add(lblMenu);

		listMenu = new JList();
		listMenu.setBounds(531, 79, 199, 351);
		contentPane.add(listMenu);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 200, 351);
		contentPane.add(scrollPane);

		tableRestaurants = new JTable();
		String[] columnNames = { "ID", "Name" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableRestaurants = new JTable();
		tableRestaurants.setModel(tableModel);
		tableRestaurants.setCellSelectionEnabled(false);
		tableRestaurants.setRowSelectionAllowed(true);
		tableRestaurants.setColumnSelectionAllowed(false);
		tableRestaurants.setShowHorizontalLines(false);
		tableRestaurants.setShowVerticalLines(false);
		tableRestaurants.setShowGrid(false);
		tableRestaurants.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TableColumnModel columnModel = tableRestaurants.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(25);
		columnModel.getColumn(1).setPreferredWidth(200);
		scrollPane.setViewportView(tableRestaurants);
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}

	public JTable getTableRestaurants() {
		return tableRestaurants;
	}

	public void setTableRestaurants(JTable tableRestaurants) {
		this.tableRestaurants = tableRestaurants;
	}

	public JList getListMenu() {
		return listMenu;
	}

	public void setListMenu(JList listMenu) {
		this.listMenu = listMenu;
	}

	public JButton getBtnAddItem() {
		return btnAddItem;
	}

	public void setBtnAddItem(JButton btnAddItem) {
		this.btnAddItem = btnAddItem;
	}

	public JButton getBtnEditMenu() {
		return btnEditMenu;
	}

	public void setBtnEditMenu(JButton btnEditMenu) {
		this.btnEditMenu = btnEditMenu;
	}

	public JTextField getTxtItemName() {
		return txtItemName;
	}

	public void setTxtItemName(JTextField txtItemName) {
		this.txtItemName = txtItemName;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}
	
	

}
