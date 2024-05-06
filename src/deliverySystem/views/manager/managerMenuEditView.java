package deliverySystem.views.manager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class managerMenuEditView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar AdminMenuBar;
	private JPanel MenuPane;
	private JPanel RestaurantPane;
	private JLabel lblRestaurant;
	private JLabel lblAddItem;
	private JLabel lblItemName;
	private JLabel lblPrice;
	private JTextField txtItemName;
	private JTextField txtPrice;
	private JButton btnAddItem;
	private JLabel lblEditMenu;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
	private JMenuItem mntmQuit = new JMenuItem("Quit");
	private JMenu mnNewEdit = new JMenu("Edit");
	private JMenuItem mntmRestaurant = new JMenuItem("Restaurant");
	private JMenuItem mntmMenu = new JMenuItem("Menu");
	private JMenu mnOrder = new JMenu("Order");
	private JMenuItem mntmViewrestaurantOrder = new JMenuItem("View restaurants order");
	private JList listRestaurant;
	private JList listMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerMenuEditView frame = new managerMenuEditView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public managerMenuEditView() {
		setTitle("Food Ordering Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 564);

		AdminMenuBar = new JMenuBar();
		setJMenuBar(AdminMenuBar);

		mnFile = new JMenu("File");
		mnFile.setForeground(Color.BLACK);
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		AdminMenuBar.add(mnFile);

		mntmDisconnect = new JMenuItem("Disconnect");
		mntmDisconnect.setForeground(Color.BLACK);
		mntmDisconnect.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmDisconnect);

		mntmQuit = new JMenuItem("Quit");
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmQuit);

		mnNewEdit = new JMenu("Edit");
		mnNewEdit.setForeground(Color.BLACK);
		mnNewEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		AdminMenuBar.add(mnNewEdit);

		mntmRestaurant = new JMenuItem("Restaurant");
		mntmRestaurant.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmRestaurant);

		mntmMenu = new JMenuItem("Menu");
		mntmMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmMenu);

		mnOrder = new JMenu("Order");
		mnOrder.setForeground(Color.BLACK);
		mnOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		AdminMenuBar.add(mnOrder);

		mntmViewrestaurantOrder = new JMenuItem("View restaurants order");
		mntmViewrestaurantOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnOrder.add(mntmViewrestaurantOrder);
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

		btnAddItem = new JButton("Save Changes");
		btnAddItem.setBackground(new Color(255, 255, 255));
		btnAddItem.setForeground(new Color(0, 0, 0));
		btnAddItem.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		btnAddItem.setBounds(135, 182, 139, 40);
		MenuPane.add(btnAddItem);

		lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setForeground(new Color(255, 255, 255));
		lblRestaurant.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblRestaurant.setBounds(10, 49, 199, 20);
		contentPane.add(lblRestaurant);
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);

		lblEditMenu = new JLabel("Edit Menu");
		lblEditMenu.setForeground(new Color(255, 255, 255));
		lblEditMenu.setBounds(278, 24, 184, 30);
		contentPane.add(lblEditMenu);
		lblEditMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 23));
		lblEditMenu.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		lblMenu.setBounds(531, 49, 199, 20);
		contentPane.add(lblMenu);

		listRestaurant = new JList();
		listRestaurant.setBounds(10, 79, 199, 396);
		contentPane.add(listRestaurant);

		listMenu = new JList();
		listMenu.setBounds(525, 79, 210, 396);
		contentPane.add(listMenu);
	}

	/**
	 * @return the restaurantPane
	 */
	public JPanel getRestaurantPane() {
		return RestaurantPane;
	}

	/**
	 * @param restaurantPane the restaurantPane to set
	 */
	public void setRestaurantPane(JPanel restaurantPane) {
		RestaurantPane = restaurantPane;
	}

	public JList getListRestaurant() {
		return listRestaurant;
	}

	public void setListRestaurant(JList listRestaurant) {
		this.listRestaurant = listRestaurant;
	}

	public JList getListMenu() {
		return listMenu;
	}

	public void setListMenu(JList listMenu) {
		this.listMenu = listMenu;
	}

	/**
	 * @return the txtItemName
	 */
	public JTextField getTxtItemName() {
		return txtItemName;
	}

	/**
	 * @param txtItemName the txtItemName to set
	 */
	public void setTxtItemName(JTextField txtItemName) {
		this.txtItemName = txtItemName;
	}

	/**
	 * @return the txtPrice
	 */
	public JTextField getTxtPrice() {
		return txtPrice;
	}

	/**
	 * @param txtPrice the txtPrice to set
	 */
	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

	/**
	 * @return the btnAddItem
	 */
	public JButton getBtnAddItem() {
		return btnAddItem;
	}

	/**
	 * @param btnAddItem the btnAddItem to set
	 */
	public void setBtnAddItem(JButton btnAddItem) {
		this.btnAddItem = btnAddItem;
	}

	/**
	 * @return the mnFile
	 */
	public JMenu getMnFile() {
		return mnFile;
	}

	/**
	 * @param mnFile the mnFile to set
	 */
	public void setMnFile(JMenu mnFile) {
		this.mnFile = mnFile;
	}

	/**
	 * @return the mntmDisconnect
	 */
	public JMenuItem getMntmDisconnect() {
		return mntmDisconnect;
	}

	/**
	 * @param mntmDisconnect the mntmDisconnect to set
	 */
	public void setMntmDisconnect(JMenuItem mntmDisconnect) {
		this.mntmDisconnect = mntmDisconnect;
	}

	/**
	 * @return the mntmQuit
	 */
	public JMenuItem getMntmQuit() {
		return mntmQuit;
	}

	/**
	 * @param mntmQuit the mntmQuit to set
	 */
	public void setMntmQuit(JMenuItem mntmQuit) {
		this.mntmQuit = mntmQuit;
	}

	/**
	 * @return the mnNewEdit
	 */
	public JMenu getMnNewEdit() {
		return mnNewEdit;
	}

	/**
	 * @param mnNewEdit the mnNewEdit to set
	 */
	public void setMnNewEdit(JMenu mnNewEdit) {
		this.mnNewEdit = mnNewEdit;
	}

	/**
	 * @return the mntmRestaurant
	 */
	public JMenuItem getMntmRestaurant() {
		return mntmRestaurant;
	}

	/**
	 * @param mntmRestaurant the mntmRestaurant to set
	 */
	public void setMntmRestaurant(JMenuItem mntmRestaurant) {
		this.mntmRestaurant = mntmRestaurant;
	}

	/**
	 * @return the mntmMenu
	 */
	public JMenuItem getMntmMenu() {
		return mntmMenu;
	}

	/**
	 * @param mntmMenu the mntmMenu to set
	 */
	public void setMntmMenu(JMenuItem mntmMenu) {
		this.mntmMenu = mntmMenu;
	}

	/**
	 * @return the mnOrder
	 */
	public JMenu getMnOrder() {
		return mnOrder;
	}

	/**
	 * @param mnOrder the mnOrder to set
	 */
	public void setMnOrder(JMenu mnOrder) {
		this.mnOrder = mnOrder;
	}

	/**
	 * @return the mntmViewrestaurantOrder
	 */
	public JMenuItem getMntmViewrestaurantOrder() {
		return mntmViewrestaurantOrder;
	}

	/**
	 * @param mntmViewrestaurantOrder the mntmViewrestaurantOrder to set
	 */
	public void setMntmViewrestaurantOrder(JMenuItem mntmViewrestaurantOrder) {
		this.mntmViewrestaurantOrder = mntmViewrestaurantOrder;
	}
}
