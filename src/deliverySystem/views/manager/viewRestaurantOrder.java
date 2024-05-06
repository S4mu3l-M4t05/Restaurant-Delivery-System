package deliverySystem.views.manager;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JPanel;

public class viewRestaurantOrder extends JFrame{
	private JTextField txt_deliverytime = new JTextField();
	private JTextField txt_hour = new JTextField();
	private JTextField txt_minute = new JTextField();
	private JTextField txt_postalcode = new JTextField() ;
	private JMenuBar menuBar = new JMenuBar();
	private DefaultListModel<String> listModelRestaurant = new DefaultListModel<>();
	private JList list_restaurant = new JList(listModelRestaurant);
	private DefaultListModel<String> listModelRestaurantOrder = new DefaultListModel<>();
	private JList list_restaurantOrders = new JList(listModelRestaurantOrder);
	private JTextArea textArea_mealorder = new JTextArea();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
	private JMenuItem mntmQuit = new JMenuItem("Quit");
	private JMenu mnNewEdit = new JMenu("Edit");
	private JMenuItem mntmRestaurant = new JMenuItem("Restaurant");
	private JMenuItem mntmMenu = new JMenuItem("Menu");
	private JMenu mnOrder = new JMenu("Order");
	private JMenuItem mntmViewrestaurantOrder = new JMenuItem("View restaurants order");
	private JPanel panel = new JPanel();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewRestaurantOrder window = new viewRestaurantOrder();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewRestaurantOrder() {
		getContentPane().setBackground(Color.decode("#28384d"));
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setTitle("Food Ordering Software");
		this.setBounds(100, 100, 1168, 793);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setJMenuBar(menuBar);
		
		panel=new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(), Color.decode("#141c26")));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
		panel.setBounds(59, 35, 1029, 656);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		mnFile.setForeground(Color.BLACK);
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);

		mntmDisconnect.setForeground(Color.BLACK);
		mntmDisconnect.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmDisconnect);
	
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmQuit);
	
		mnNewEdit.setForeground(Color.BLACK);
		mnNewEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewEdit);

		mntmRestaurant.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmRestaurant);

		mntmMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmMenu);

		mnOrder.setForeground(Color.BLACK);
		mnOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnOrder);

		mntmViewrestaurantOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnOrder.add(mntmViewrestaurantOrder);
		this.getContentPane().setLayout(null);
		
	
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setForeground(new Color(255, 255, 255));
		lblRestaurant.setBackground(new Color(255, 255, 255));
		lblRestaurant.setBounds(44, 16, 241, 29);
		panel.add(lblRestaurant);
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 16));
		
		JLabel lblRestaurantsOrders = new JLabel("Restaurant's Orders");
		lblRestaurantsOrders.setForeground(new Color(255, 255, 255));
		lblRestaurantsOrders.setBounds(334, 16, 241, 29);
		panel.add(lblRestaurantsOrders);
		lblRestaurantsOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantsOrders.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 16));
		
		JLabel lblViewOrder = new JLabel("View Order");
		lblViewOrder.setForeground(new Color(255, 255, 255));
		lblViewOrder.setBounds(743, 94, 215, 29);
		panel.add(lblViewOrder);
		lblViewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewOrder.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		
		JLabel lblDeliveryTime = new JLabel("Delivery Time(yyyy/mm/dd):");
		lblDeliveryTime.setForeground(new Color(255, 255, 255));
		lblDeliveryTime.setBounds(610, 161, 241, 29);
		panel.add(lblDeliveryTime);
		lblDeliveryTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryTime.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		txt_deliverytime.setBounds(847, 167, 143, 20);
		panel.add(txt_deliverytime);
		txt_deliverytime.setEditable(false);
		txt_deliverytime.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		txt_deliverytime.setColumns(10);
		
		JLabel lblDeliveryTime_2 = new JLabel("Delivery Time:");
		lblDeliveryTime_2.setForeground(new Color(255, 255, 255));
		lblDeliveryTime_2.setBounds(707, 201, 150, 29);
		panel.add(lblDeliveryTime_2);
		lblDeliveryTime_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryTime_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		txt_hour.setBounds(847, 207, 33, 20);
		panel.add(txt_hour);
		txt_hour.setEditable(false);
		txt_hour.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		txt_hour.setColumns(10);
		
		JLabel lblh = new JLabel("h");
		lblh.setBounds(895, 210, 20, 14);
		panel.add(lblh);
		lblh.setForeground(new Color(255, 255, 255));
		lblh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		txt_minute.setBounds(916, 207, 33, 20);
		panel.add(txt_minute);
		txt_minute.setEditable(false);
		txt_minute.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		txt_minute.setColumns(10);
		
		JLabel lblm = new JLabel("m");
		lblm.setBounds(959, 210, 20, 14);
		panel.add(lblm);
		lblm.setForeground(new Color(255, 255, 255));
		lblm.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		
		JLabel lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setForeground(new Color(255, 255, 255));
		lblPostalCode.setBounds(731, 244, 114, 29);
		panel.add(lblPostalCode);
		lblPostalCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostalCode.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		
		txt_postalcode = new JTextField();
		txt_postalcode.setBounds(847, 250, 86, 20);
		panel.add(txt_postalcode);
		txt_postalcode.setEditable(false);
		txt_postalcode.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		txt_postalcode.setColumns(10);
		
		JLabel lblmealinorder = new JLabel("Meal In order");
		lblmealinorder.setForeground(new Color(255, 255, 255));
		lblmealinorder.setBounds(755, 284, 109, 29);
		panel.add(lblmealinorder);
		lblmealinorder.setHorizontalAlignment(SwingConstants.CENTER);
		lblmealinorder.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 12));
		textArea_mealorder.setBounds(761, 310, 229, 161);
		panel.add(textArea_mealorder);
		textArea_mealorder.setEditable(false);
		list_restaurant.setBounds(44, 56, 251, 590);
		panel.add(list_restaurant);
		list_restaurant.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		list_restaurantOrders.setBounds(324, 56, 251, 590);
		panel.add(list_restaurantOrders);
		list_restaurantOrders.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
	}

	/**
	 * @return the list_restaurant
	 */
	public JList getList_restaurant() {
		return list_restaurant;
	}

	/**
	 * @param list_restaurant the list_restaurant to set
	 */
	public void setList_restaurant(JList list_restaurant) {
		this.list_restaurant = list_restaurant;
	}

	/**
	 * @return the list_restaurantOrders
	 */
	public JList getList_restaurantOrders() {
		return list_restaurantOrders;
	}

	/**
	 * @param list_restaurantOrders the list_restaurantOrders to set
	 */
	public void setList_restaurantOrders(JList list_restaurantOrders) {
		this.list_restaurantOrders = list_restaurantOrders;
	}

	/**
	 * @return the txt_deliverytime
	 */
	public JTextField getTxt_deliverytime() {
		return txt_deliverytime;
	}

	/**
	 * @param txt_deliverytime the txt_deliverytime to set
	 */
	public void setTxt_deliverytime(JTextField txt_deliverytime) {
		this.txt_deliverytime = txt_deliverytime;
	}

	/**
	 * @return the txt_hour
	 */
	public JTextField getTxt_hour() {
		return txt_hour;
	}

	/**
	 * @param txt_hour the txt_hour to set
	 */
	public void setTxt_hour(JTextField txt_hour) {
		this.txt_hour = txt_hour;
	}

	/**
	 * @return the txt_minute
	 */
	public JTextField getTxt_minute() {
		return txt_minute;
	}

	/**
	 * @param txt_minute the txt_minute to set
	 */
	public void setTxt_minute(JTextField txt_minute) {
		this.txt_minute = txt_minute;
	}

	/**
	 * @return the txt_postalcode
	 */
	public JTextField getTxt_postalcode() {
		return txt_postalcode;
	}

	/**
	 * @param txt_postalcode the txt_postalcode to set
	 */
	public void setTxt_postalcode(JTextField txt_postalcode) {
		this.txt_postalcode = txt_postalcode;
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

	/**
	 * @return the textArea_mealorder
	 */
	public JTextArea getTextArea_mealorder() {
		return textArea_mealorder;
	}

	/**
	 * @param textArea_mealorder the textArea_mealorder to set
	 */
	public void setTextArea_mealorder(JTextArea textArea_mealorder) {
		this.textArea_mealorder = textArea_mealorder;
	}

	/**
	 * @return the listModelRestaurant
	 */
	public DefaultListModel<String> getListModelRestaurant() {
		return listModelRestaurant;
	}

	/**
	 * @param listModelRestaurant the listModelRestaurant to set
	 */
	public void setListModelRestaurant(DefaultListModel<String> listModelRestaurant) {
		this.listModelRestaurant = listModelRestaurant;
	}

	/**
	 * @return the listModelRestaurantOrder
	 */
	public DefaultListModel<String> getListModelRestaurantOrder() {
		return listModelRestaurantOrder;
	}

	/**
	 * @param listModelRestaurantOrder the listModelRestaurantOrder to set
	 */
	public void setListModelRestaurantOrder(DefaultListModel<String> listModelRestaurantOrder) {
		this.listModelRestaurantOrder = listModelRestaurantOrder;
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
}
