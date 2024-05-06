package deliverySystem.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import deliverySystem.models.admin.MenuItem;

public class MenuCreateView extends JFrame {

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
	private JLabel lblRestaurant;
	private JButton btnSelect;
	private JLabel lblAddItem;
	private JLabel lblItemName;
	private JLabel lblPrice;
	private JTextField txtItemName;
	private JTextField txtPrice;
	private JButton btnAddItem;
	private JLabel lblCreateMenu;
	private JButton btnCreateMenu;
	private JTable tableRestaurants;
	private JList<MenuItem> listMenu;
	private DefaultListModel<MenuItem> listModel;

	public MenuCreateView() {
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

		lblAddItem = new JLabel("Add Item");
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

		btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(new Color(255, 255, 255));
		btnAddItem.setForeground(new Color(0, 0, 0));
		btnAddItem.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		btnAddItem.setBounds(135, 182, 139, 40);
		MenuPane.add(btnAddItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 79, 199, 345);
		contentPane.add(scrollPane);

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

		lblCreateMenu = new JLabel("Create Menu");
		lblCreateMenu.setForeground(new Color(255, 255, 255));
		lblCreateMenu.setBounds(278, 24, 184, 30);
		contentPane.add(lblCreateMenu);
		lblCreateMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 23));
		lblCreateMenu.setHorizontalAlignment(SwingConstants.CENTER);

		btnCreateMenu = new JButton("Create Menu");
		btnCreateMenu.setBounds(531, 435, 199, 40);
		contentPane.add(btnCreateMenu);
		btnCreateMenu.setBackground(new Color(255, 255, 255));
		btnCreateMenu.setForeground(new Color(0, 0, 0));
		btnCreateMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblMenu.setBounds(531, 49, 199, 20);
		contentPane.add(lblMenu);

		listModel = new DefaultListModel<>();
		listMenu = new JList<>(listModel);
		listMenu.setBounds(531, 79, 199, 345);
		contentPane.add(listMenu);

	}
	
	 public DefaultListModel<MenuItem> getListModel() {
	        return listModel;
	    }
	public JList<MenuItem> getListMenu() {
		return listMenu;
	}

	public void setListMenu(JList<MenuItem> listMenu) {
		this.listMenu = listMenu;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}

	public JTable getTableRestaurant() {
		return tableRestaurants;
	}

	public void setTableRestaurant(JTable tableRestaurant) {
		this.tableRestaurants = tableRestaurant;
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

	public JButton getBtnAddItem() {
		return btnAddItem;
	}

	public void setBtnAddItem(JButton btnAddItem) {
		this.btnAddItem = btnAddItem;
	}

	public JButton getBtnCreateMenu() {
		return btnCreateMenu;
	}

	public void setBtnCreateMenu(JButton btnCreateMenu) {
		this.btnCreateMenu = btnCreateMenu;
	}
}
