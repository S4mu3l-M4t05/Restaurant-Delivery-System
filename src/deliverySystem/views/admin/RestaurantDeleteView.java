package deliverySystem.views.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RestaurantDeleteView extends JFrame {
	private JTextField txt_restaurantname = new JTextField();
	private JTextField txt_restaurantaddress = new JTextField();
	private JTextField txtphonenum = new JTextField();
	private JTextField txtdeliveryarea = new JTextField();
	private JComboBox comboBoxSU1 = new JComboBox();
	private JComboBox comboBoxSU2 = new JComboBox();
	private JComboBox comboBoxSU3 = new JComboBox();
	private JComboBox comboBoxSU4 = new JComboBox();
	private JComboBox comboBoxMO1 = new JComboBox();
	private JComboBox comboBoxMO2 = new JComboBox();
	private JComboBox comboBoxMO3 = new JComboBox();
	private JComboBox comboBoxMO4 = new JComboBox();
	private JComboBox comboBoxTU1 = new JComboBox();
	private JComboBox comboBoxTU2 = new JComboBox();
	private JComboBox comboBoxTU3 = new JComboBox();
	private JComboBox comboBoxTU4 = new JComboBox();
	private JComboBox comboBoxWE1 = new JComboBox();
	private JComboBox comboBoxWE2 = new JComboBox();
	private JComboBox comboBoxWE3 = new JComboBox();
	private JComboBox comboBoxWE4 = new JComboBox();
	private JComboBox comboBoxTH1 = new JComboBox();
	private JComboBox comboBoxTH2 = new JComboBox();
	private JComboBox comboBoxTH3 = new JComboBox();
	private JComboBox comboBoxTH4 = new JComboBox();
	private JComboBox comboBoxFR1 = new JComboBox();
	private JComboBox comboBoxFR2 = new JComboBox();
	private JComboBox comboBoxFR3 = new JComboBox();
	private JComboBox comboBoxFR4 = new JComboBox();
	private JComboBox comboBoxSA1 = new JComboBox();
	private JComboBox comboBoxSA2 = new JComboBox();
	private JComboBox comboBoxSA3 = new JComboBox();
	private JComboBox comboBoxSA4 = new JComboBox();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenu = new JMenu("New menu");
	private JButton btnmodifytimes = new JButton("Modify all times at once\r\n");
	private JButton btnAddDeliveryArea = new JButton("Add Delivery Area");
	private JButton btnDeleteDeliveryArea = new JButton("Delete Delivery Area");
	private JTable restauranttable;
	private JButton btnDelete = new JButton("Delete");
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JList<String> deliveryAreaList = new JList(listModel);
	JMenu mnFile = new JMenu("File");
	JMenuItem mntmFileDisconnect = new JMenuItem("Disconnect");
	JMenuItem mntmFileQuit = new JMenuItem("Quit");
	JMenu mnRestaurant = new JMenu("Restaurant");
	JMenuItem mntmRestaurantCreate = new JMenuItem("Create");
	JMenuItem mntmRestaurantEdit = new JMenuItem("Edit");
	JMenuItem mntmRestaurantDelete = new JMenuItem("Delete");
	JMenu mnMenu = new JMenu("Menu");
	JMenuItem mntmMenuCreate = new JMenuItem("Create");
	JMenuItem mntmMenuEdit = new JMenuItem("Edit");
	JMenuItem mntmMenuDelete = new JMenuItem("Delete");
	JMenu mnDeliveryMan = new JMenu("Delivery Man");
	JMenuItem mntmCreateDeliveryGuy = new JMenuItem("Create");
	JMenuItem mntmEditDeliveryGuy = new JMenuItem("Edit");
	JMenuItem mntmDeleteDeliveryGuy = new JMenuItem("Delete");
	private final JLabel lblRestaurant = new JLabel("Restaurant");

	/**
	 * Create the application.
	 */
	public RestaurantDeleteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant delete");
		this.setBounds(100, 100, 1043, 856);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		txt_restaurantname.setForeground(Color.BLACK);
		txt_restaurantname.setColumns(10);
		txt_restaurantname.setBounds(413, 83, 243, 20);
		this.getContentPane().add(txt_restaurantname);

		txtphonenum.setColumns(10);
		txtphonenum.setBounds(413, 143, 119, 20);
		this.getContentPane().add(txtphonenum);

		txtdeliveryarea.setColumns(10);
		txtdeliveryarea.setBounds(592, 651, 51, 20);
		this.getContentPane().add(txtdeliveryarea);

		txt_restaurantaddress.setColumns(10);
		txt_restaurantaddress.setBounds(413, 112, 243, 20);
		this.getContentPane().add(txt_restaurantaddress);

		JLabel lblDelete = new JLabel("Restaurant Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelete.setBounds(376, 41, 302, 25);
		this.getContentPane().add(lblDelete);

		menuBar.setBounds(0, 0, 1027, 22);
		this.getContentPane().add(menuBar);

		menuBar.add(mnFile);

		mnFile.add(mntmFileDisconnect);

		mnFile.add(mntmFileQuit);

		menuBar.add(mnRestaurant);

		mnRestaurant.add(mntmRestaurantCreate);

		mnRestaurant.add(mntmRestaurantEdit);

		mnRestaurant.add(mntmRestaurantDelete);

		menuBar.add(mnMenu);

		mnMenu.add(mntmMenuCreate);

		mnMenu.add(mntmMenuEdit);

		mnMenu.add(mntmMenuDelete);

		menuBar.add(mnDeliveryMan);

		mnDeliveryMan.add(mntmCreateDeliveryGuy);

		mnDeliveryMan.add(mntmEditDeliveryGuy);

		mnDeliveryMan.add(mntmDeleteDeliveryGuy);

		JLabel lblrestaurantName = new JLabel("Restaurant Name:");
		lblrestaurantName.setHorizontalAlignment(SwingConstants.LEFT);
		lblrestaurantName.setForeground(Color.BLACK);
		lblrestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrestaurantName.setBounds(287, 77, 138, 29);
		this.getContentPane().add(lblrestaurantName);

		JLabel lblrestaurantAddress = new JLabel("Restaurant Address:");
		lblrestaurantAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblrestaurantAddress.setForeground(Color.BLACK);
		lblrestaurantAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrestaurantAddress.setBounds(269, 106, 144, 29);
		this.getContentPane().add(lblrestaurantAddress);

		JLabel lblrestaurantphoneNum = new JLabel("Phone Number:");
		lblrestaurantphoneNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblrestaurantphoneNum.setForeground(Color.BLACK);
		lblrestaurantphoneNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrestaurantphoneNum.setBounds(304, 137, 113, 29);
		this.getContentPane().add(lblrestaurantphoneNum);

		JLabel lblOpenningtime = new JLabel("Openning Time");
		lblOpenningtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenningtime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOpenningtime.setBounds(428, 194, 215, 29);
		this.getContentPane().add(lblOpenningtime);

		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(Color.BLACK);
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDay.setBounds(316, 230, 33, 14);
		this.getContentPane().add(lblDay);

		JLabel lblOpenningTime = new JLabel("Openning Time");
		lblOpenningTime.setForeground(Color.BLACK);
		lblOpenningTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpenningTime.setBounds(417, 231, 109, 14);
		this.getContentPane().add(lblOpenningTime);

		JLabel lblClosingTime = new JLabel("Closing Time");
		lblClosingTime.setForeground(Color.BLACK);
		lblClosingTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClosingTime.setBounds(595, 230, 92, 14);
		this.getContentPane().add(lblClosingTime);

		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setForeground(Color.BLACK);
		lblSunday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSunday.setBounds(316, 259, 51, 14);
		this.getContentPane().add(lblSunday);

		comboBoxSU1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxSU1.setBounds(417, 256, 62, 22);
		this.getContentPane().add(comboBoxSU1);

		JLabel lblSUh = new JLabel("h");
		lblSUh.setForeground(Color.BLACK);
		lblSUh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSUh.setBounds(488, 260, 20, 14);
		this.getContentPane().add(lblSUh);

		comboBoxSU2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxSU2.setBounds(511, 256, 51, 22);
		this.getContentPane().add(comboBoxSU2);

		comboBoxSU3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxSU3.setBounds(581, 256, 62, 22);
		this.getContentPane().add(comboBoxSU3);

		JLabel lblSUh2 = new JLabel("h");
		lblSUh2.setForeground(Color.BLACK);
		lblSUh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSUh2.setBounds(653, 260, 20, 14);
		this.getContentPane().add(lblSUh2);

		comboBoxSU4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxSU4.setBounds(674, 255, 51, 22);
		this.getContentPane().add(comboBoxSU4);

		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setForeground(Color.BLACK);
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMonday.setBounds(316, 292, 51, 14);
		this.getContentPane().add(lblMonday);

		comboBoxMO1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxMO1.setBounds(417, 289, 62, 22);
		this.getContentPane().add(comboBoxMO1);

		JLabel lblMOh = new JLabel("h");
		lblMOh.setForeground(Color.BLACK);
		lblMOh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMOh.setBounds(488, 293, 20, 14);
		this.getContentPane().add(lblMOh);

		comboBoxMO2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxMO2.setBounds(511, 289, 51, 22);
		this.getContentPane().add(comboBoxMO2);

		comboBoxMO3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxMO3.setBounds(581, 289, 62, 22);
		this.getContentPane().add(comboBoxMO3);

		JLabel lblMOh2 = new JLabel("h");
		lblMOh2.setForeground(Color.BLACK);
		lblMOh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMOh2.setBounds(653, 293, 20, 14);
		this.getContentPane().add(lblMOh2);

		comboBoxMO4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxMO4.setBounds(674, 288, 51, 22);
		this.getContentPane().add(comboBoxMO4);

		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setForeground(Color.BLACK);
		lblTuesday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuesday.setBounds(316, 326, 51, 14);
		this.getContentPane().add(lblTuesday);

		comboBoxTU1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxTU1.setBounds(417, 322, 62, 22);
		this.getContentPane().add(comboBoxTU1);

		JLabel lblTU1 = new JLabel("h");
		lblTU1.setForeground(Color.BLACK);
		lblTU1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTU1.setBounds(488, 327, 20, 14);
		this.getContentPane().add(lblTU1);

		comboBoxTU2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxTU2.setBounds(511, 323, 51, 22);
		this.getContentPane().add(comboBoxTU2);

		comboBoxTU3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxTU3.setBounds(581, 322, 62, 22);
		this.getContentPane().add(comboBoxTU3);

		JLabel lblTUh2 = new JLabel("h");
		lblTUh2.setForeground(Color.BLACK);
		lblTUh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTUh2.setBounds(653, 327, 20, 14);
		this.getContentPane().add(lblTUh2);

		comboBoxTU4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxTU4.setBounds(674, 323, 51, 22);
		this.getContentPane().add(comboBoxTU4);

		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setForeground(Color.BLACK);
		lblWednesday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWednesday.setBounds(316, 356, 72, 14);
		this.getContentPane().add(lblWednesday);

		comboBoxWE1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxWE1.setBounds(417, 355, 62, 22);
		this.getContentPane().add(comboBoxWE1);

		JLabel lblWEh = new JLabel("h");
		lblWEh.setForeground(Color.BLACK);
		lblWEh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWEh.setBounds(488, 357, 20, 14);
		this.getContentPane().add(lblWEh);

		comboBoxWE2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxWE2.setBounds(511, 356, 51, 22);
		this.getContentPane().add(comboBoxWE2);

		comboBoxWE3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxWE3.setBounds(581, 355, 62, 22);
		this.getContentPane().add(comboBoxWE3);

		JLabel lblWEh2 = new JLabel("h");
		lblWEh2.setForeground(Color.BLACK);
		lblWEh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWEh2.setBounds(653, 357, 20, 14);
		this.getContentPane().add(lblWEh2);

		comboBoxWE4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxWE4.setBounds(674, 353, 51, 22);
		this.getContentPane().add(comboBoxWE4);

		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setForeground(Color.BLACK);
		lblThursday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThursday.setBounds(316, 390, 72, 14);
		this.getContentPane().add(lblThursday);

		comboBoxTH1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxTH1.setBounds(417, 387, 62, 22);
		this.getContentPane().add(comboBoxTH1);

		JLabel lblTHh = new JLabel("h");
		lblTHh.setForeground(Color.BLACK);
		lblTHh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTHh.setBounds(488, 391, 20, 14);
		this.getContentPane().add(lblTHh);

		comboBoxTH2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxTH2.setBounds(511, 387, 51, 22);
		this.getContentPane().add(comboBoxTH2);

		comboBoxTH3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxTH3.setBounds(581, 388, 62, 22);
		this.getContentPane().add(comboBoxTH3);

		JLabel lblTHh2 = new JLabel("h");
		lblTHh2.setForeground(Color.BLACK);
		lblTHh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTHh2.setBounds(653, 391, 20, 14);
		this.getContentPane().add(lblTHh2);

		comboBoxTH4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxTH4.setBounds(674, 387, 51, 22);
		this.getContentPane().add(comboBoxTH4);

		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setForeground(Color.BLACK);
		lblFriday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFriday.setBounds(316, 423, 72, 14);
		this.getContentPane().add(lblFriday);

		comboBoxFR1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxFR1.setBounds(417, 420, 62, 22);
		this.getContentPane().add(comboBoxFR1);

		JLabel lblFRh = new JLabel("h");
		lblFRh.setForeground(Color.BLACK);
		lblFRh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFRh.setBounds(488, 424, 20, 14);
		this.getContentPane().add(lblFRh);

		comboBoxFR2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxFR2.setBounds(511, 420, 51, 22);
		this.getContentPane().add(comboBoxFR2);

		comboBoxFR3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxFR3.setBounds(581, 420, 62, 22);
		this.getContentPane().add(comboBoxFR3);

		JLabel lblFRh2 = new JLabel("h");
		lblFRh2.setForeground(Color.BLACK);
		lblFRh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFRh2.setBounds(653, 424, 20, 14);
		this.getContentPane().add(lblFRh2);

		comboBoxFR4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxFR4.setBounds(674, 420, 51, 22);
		this.getContentPane().add(comboBoxFR4);

		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setForeground(Color.BLACK);
		lblSaturday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSaturday.setBounds(316, 455, 72, 14);
		this.getContentPane().add(lblSaturday);

		comboBoxSA1.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxSA1.setBounds(417, 453, 62, 22);
		this.getContentPane().add(comboBoxSA1);

		JLabel lblSAh = new JLabel("h");
		lblSAh.setForeground(Color.BLACK);
		lblSAh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSAh.setBounds(488, 456, 20, 14);
		this.getContentPane().add(lblSAh);

		comboBoxSA2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxSA2.setBounds(511, 452, 51, 22);
		this.getContentPane().add(comboBoxSA2);

		comboBoxSA3.setModel(new DefaultComboBoxModel(
				new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
		comboBoxSA3.setBounds(581, 453, 62, 22);
		this.getContentPane().add(comboBoxSA3);

		JLabel lblSAh2 = new JLabel("h");
		lblSAh2.setForeground(Color.BLACK);
		lblSAh2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSAh2.setBounds(653, 456, 20, 14);
		this.getContentPane().add(lblSAh2);

		comboBoxSA4.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		comboBoxSA4.setBounds(674, 453, 51, 22);
		this.getContentPane().add(comboBoxSA4);

		btnmodifytimes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnmodifytimes.setBounds(417, 486, 318, 38);
		this.getContentPane().add(btnmodifytimes);

		JLabel lblDeliveryArea_1 = new JLabel("Delivery Area");
		lblDeliveryArea_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryArea_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeliveryArea_1.setBounds(463, 535, 215, 29);
		this.getContentPane().add(lblDeliveryArea_1);

		JLabel lblDeliveryArea = new JLabel("Delivery Area:");
		lblDeliveryArea.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeliveryArea.setForeground(Color.BLACK);
		lblDeliveryArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeliveryArea.setBounds(488, 645, 98, 29);
		this.getContentPane().add(lblDeliveryArea);

		btnAddDeliveryArea.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAddDeliveryArea.setBounds(654, 645, 138, 29);
		this.getContentPane().add(btnAddDeliveryArea);

		btnDeleteDeliveryArea.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDeleteDeliveryArea.setBounds(549, 683, 157, 29);
		this.getContentPane().add(btnDeleteDeliveryArea);

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(26, 772, 236, 38);
		this.getContentPane().add(btnDelete);

		restauranttable = new JTable();
		restauranttable.setBounds(26, 86, 236, 675);
		this.getContentPane().add(restauranttable);
		deliveryAreaList.setVisibleRowCount(4);
		deliveryAreaList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		deliveryAreaList.setBounds(454, 565, 252, 75);

		getContentPane().add(deliveryAreaList);
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRestaurant.setBounds(36, 50, 215, 29);

		getContentPane().add(lblRestaurant);

	}

	/**
	 * @return the txt_restaurantname
	 */
	public JTextField getTxt_restaurantname() {
		return txt_restaurantname;
	}

	/**
	 * @param txt_restaurantname the txt_restaurantname to set
	 */
	public void setTxt_restaurantname(JTextField txt_restaurantname) {
		this.txt_restaurantname = txt_restaurantname;
	}

	/**
	 * @return the txt_restaurantaddress
	 */
	public JTextField getTxt_restaurantaddress() {
		return txt_restaurantaddress;
	}

	/**
	 * @param txt_restaurantaddress the txt_restaurantaddress to set
	 */
	public void setTxt_restaurantaddress(JTextField txt_restaurantaddress) {
		this.txt_restaurantaddress = txt_restaurantaddress;
	}

	/**
	 * @return the txtphonenum
	 */
	public JTextField getTxtphonenum() {
		return txtphonenum;
	}

	/**
	 * @param txtphonenum the txtphonenum to set
	 */
	public void setTxtphonenum(JTextField txtphonenum) {
		this.txtphonenum = txtphonenum;
	}

	/**
	 * @return the txtdeliveryarea
	 */
	public JTextField getTxtdeliveryarea() {
		return txtdeliveryarea;
	}

	/**
	 * @param txtdeliveryarea the txtdeliveryarea to set
	 */
	public void setTxtdeliveryarea(JTextField txtdeliveryarea) {
		this.txtdeliveryarea = txtdeliveryarea;
	}

	/**
	 * @return the comboBoxSU1
	 */
	public JComboBox getComboBoxSU1() {
		return comboBoxSU1;
	}

	/**
	 * @param comboBoxSU1 the comboBoxSU1 to set
	 */
	public void setComboBoxSU1(JComboBox comboBoxSU1) {
		this.comboBoxSU1 = comboBoxSU1;
	}

	/**
	 * @return the comboBoxSU2
	 */
	public JComboBox getComboBoxSU2() {
		return comboBoxSU2;
	}

	/**
	 * @param comboBoxSU2 the comboBoxSU2 to set
	 */
	public void setComboBoxSU2(JComboBox comboBoxSU2) {
		this.comboBoxSU2 = comboBoxSU2;
	}

	/**
	 * @return the comboBoxSU3
	 */
	public JComboBox getComboBoxSU3() {
		return comboBoxSU3;
	}

	/**
	 * @param comboBoxSU3 the comboBoxSU3 to set
	 */
	public void setComboBoxSU3(JComboBox comboBoxSU3) {
		this.comboBoxSU3 = comboBoxSU3;
	}

	/**
	 * @return the comboBoxSU4
	 */
	public JComboBox getComboBoxSU4() {
		return comboBoxSU4;
	}

	/**
	 * @param comboBoxSU4 the comboBoxSU4 to set
	 */
	public void setComboBoxSU4(JComboBox comboBoxSU4) {
		this.comboBoxSU4 = comboBoxSU4;
	}

	/**
	 * @return the comboBoxMO1
	 */
	public JComboBox getComboBoxMO1() {
		return comboBoxMO1;
	}

	/**
	 * @param comboBoxMO1 the comboBoxMO1 to set
	 */
	public void setComboBoxMO1(JComboBox comboBoxMO1) {
		this.comboBoxMO1 = comboBoxMO1;
	}

	/**
	 * @return the comboBoxMO2
	 */
	public JComboBox getComboBoxMO2() {
		return comboBoxMO2;
	}

	/**
	 * @param comboBoxMO2 the comboBoxMO2 to set
	 */
	public void setComboBoxMO2(JComboBox comboBoxMO2) {
		this.comboBoxMO2 = comboBoxMO2;
	}

	/**
	 * @return the comboBoxMO3
	 */
	public JComboBox getComboBoxMO3() {
		return comboBoxMO3;
	}

	/**
	 * @param comboBoxMO3 the comboBoxMO3 to set
	 */
	public void setComboBoxMO3(JComboBox comboBoxMO3) {
		this.comboBoxMO3 = comboBoxMO3;
	}

	/**
	 * @return the comboBoxMO4
	 */
	public JComboBox getComboBoxMO4() {
		return comboBoxMO4;
	}

	/**
	 * @param comboBoxMO4 the comboBoxMO4 to set
	 */
	public void setComboBoxMO4(JComboBox comboBoxMO4) {
		this.comboBoxMO4 = comboBoxMO4;
	}

	/**
	 * @return the comboBoxTU1
	 */
	public JComboBox getComboBoxTU1() {
		return comboBoxTU1;
	}

	/**
	 * @param comboBoxTU1 the comboBoxTU1 to set
	 */
	public void setComboBoxTU1(JComboBox comboBoxTU1) {
		this.comboBoxTU1 = comboBoxTU1;
	}

	/**
	 * @return the comboBoxTU2
	 */
	public JComboBox getComboBoxTU2() {
		return comboBoxTU2;
	}

	/**
	 * @param comboBoxTU2 the comboBoxTU2 to set
	 */
	public void setComboBoxTU2(JComboBox comboBoxTU2) {
		this.comboBoxTU2 = comboBoxTU2;
	}

	/**
	 * @return the comboBoxTU3
	 */
	public JComboBox getComboBoxTU3() {
		return comboBoxTU3;
	}

	/**
	 * @param comboBoxTU3 the comboBoxTU3 to set
	 */
	public void setComboBoxTU3(JComboBox comboBoxTU3) {
		this.comboBoxTU3 = comboBoxTU3;
	}

	/**
	 * @return the comboBoxTU4
	 */
	public JComboBox getComboBoxTU4() {
		return comboBoxTU4;
	}

	/**
	 * @param comboBoxTU4 the comboBoxTU4 to set
	 */
	public void setComboBoxTU4(JComboBox comboBoxTU4) {
		this.comboBoxTU4 = comboBoxTU4;
	}

	/**
	 * @return the comboBoxWE1
	 */
	public JComboBox getComboBoxWE1() {
		return comboBoxWE1;
	}

	/**
	 * @param comboBoxWE1 the comboBoxWE1 to set
	 */
	public void setComboBoxWE1(JComboBox comboBoxWE1) {
		this.comboBoxWE1 = comboBoxWE1;
	}

	/**
	 * @return the comboBoxWE2
	 */
	public JComboBox getComboBoxWE2() {
		return comboBoxWE2;
	}

	/**
	 * @param comboBoxWE2 the comboBoxWE2 to set
	 */
	public void setComboBoxWE2(JComboBox comboBoxWE2) {
		this.comboBoxWE2 = comboBoxWE2;
	}

	/**
	 * @return the comboBoxWE3
	 */
	public JComboBox getComboBoxWE3() {
		return comboBoxWE3;
	}

	/**
	 * @param comboBoxWE3 the comboBoxWE3 to set
	 */
	public void setComboBoxWE3(JComboBox comboBoxWE3) {
		this.comboBoxWE3 = comboBoxWE3;
	}

	/**
	 * @return the comboBoxWE4
	 */
	public JComboBox getComboBoxWE4() {
		return comboBoxWE4;
	}

	/**
	 * @param comboBoxWE4 the comboBoxWE4 to set
	 */
	public void setComboBoxWE4(JComboBox comboBoxWE4) {
		this.comboBoxWE4 = comboBoxWE4;
	}

	/**
	 * @return the comboBoxTH1
	 */
	public JComboBox getComboBoxTH1() {
		return comboBoxTH1;
	}

	/**
	 * @param comboBoxTH1 the comboBoxTH1 to set
	 */
	public void setComboBoxTH1(JComboBox comboBoxTH1) {
		this.comboBoxTH1 = comboBoxTH1;
	}

	/**
	 * @return the comboBoxTH2
	 */
	public JComboBox getComboBoxTH2() {
		return comboBoxTH2;
	}

	/**
	 * @param comboBoxTH2 the comboBoxTH2 to set
	 */
	public void setComboBoxTH2(JComboBox comboBoxTH2) {
		this.comboBoxTH2 = comboBoxTH2;
	}

	/**
	 * @return the comboBoxTH3
	 */
	public JComboBox getComboBoxTH3() {
		return comboBoxTH3;
	}

	/**
	 * @param comboBoxTH3 the comboBoxTH3 to set
	 */
	public void setComboBoxTH3(JComboBox comboBoxTH3) {
		this.comboBoxTH3 = comboBoxTH3;
	}

	/**
	 * @return the comboBoxTH4
	 */
	public JComboBox getComboBoxTH4() {
		return comboBoxTH4;
	}

	/**
	 * @param comboBoxTH4 the comboBoxTH4 to set
	 */
	public void setComboBoxTH4(JComboBox comboBoxTH4) {
		this.comboBoxTH4 = comboBoxTH4;
	}

	/**
	 * @return the comboBoxFR1
	 */
	public JComboBox getComboBoxFR1() {
		return comboBoxFR1;
	}

	/**
	 * @param comboBoxFR1 the comboBoxFR1 to set
	 */
	public void setComboBoxFR1(JComboBox comboBoxFR1) {
		this.comboBoxFR1 = comboBoxFR1;
	}

	/**
	 * @return the comboBoxFR2
	 */
	public JComboBox getComboBoxFR2() {
		return comboBoxFR2;
	}

	/**
	 * @param comboBoxFR2 the comboBoxFR2 to set
	 */
	public void setComboBoxFR2(JComboBox comboBoxFR2) {
		this.comboBoxFR2 = comboBoxFR2;
	}

	/**
	 * @return the comboBoxFR3
	 */
	public JComboBox getComboBoxFR3() {
		return comboBoxFR3;
	}

	/**
	 * @param comboBoxFR3 the comboBoxFR3 to set
	 */
	public void setComboBoxFR3(JComboBox comboBoxFR3) {
		this.comboBoxFR3 = comboBoxFR3;
	}

	/**
	 * @return the comboBoxFR4
	 */
	public JComboBox getComboBoxFR4() {
		return comboBoxFR4;
	}

	/**
	 * @param comboBoxFR4 the comboBoxFR4 to set
	 */
	public void setComboBoxFR4(JComboBox comboBoxFR4) {
		this.comboBoxFR4 = comboBoxFR4;
	}

	/**
	 * @return the comboBoxSA1
	 */
	public JComboBox getComboBoxSA1() {
		return comboBoxSA1;
	}

	/**
	 * @param comboBoxSA1 the comboBoxSA1 to set
	 */
	public void setComboBoxSA1(JComboBox comboBoxSA1) {
		this.comboBoxSA1 = comboBoxSA1;
	}

	/**
	 * @return the comboBoxSA2
	 */
	public JComboBox getComboBoxSA2() {
		return comboBoxSA2;
	}

	/**
	 * @param comboBoxSA2 the comboBoxSA2 to set
	 */
	public void setComboBoxSA2(JComboBox comboBoxSA2) {
		this.comboBoxSA2 = comboBoxSA2;
	}

	/**
	 * @return the comboBoxSA3
	 */
	public JComboBox getComboBoxSA3() {
		return comboBoxSA3;
	}

	/**
	 * @param comboBoxSA3 the comboBoxSA3 to set
	 */
	public void setComboBoxSA3(JComboBox comboBoxSA3) {
		this.comboBoxSA3 = comboBoxSA3;
	}

	/**
	 * @return the comboBoxSA4
	 */
	public JComboBox getComboBoxSA4() {
		return comboBoxSA4;
	}

	/**
	 * @param comboBoxSA4 the comboBoxSA4 to set
	 */
	public void setComboBoxSA4(JComboBox comboBoxSA4) {
		this.comboBoxSA4 = comboBoxSA4;
	}

	/**
	 * @return the mnNewMenu
	 */
	public JMenu getMnNewMenu() {
		return mnNewMenu;
	}

	/**
	 * @param mnNewMenu the mnNewMenu to set
	 */
	public void setMnNewMenu(JMenu mnNewMenu) {
		this.mnNewMenu = mnNewMenu;
	}

	/**
	 * @return the btnmodifytimes
	 */
	public JButton getBtnmodifytimes() {
		return btnmodifytimes;
	}

	/**
	 * @param btnmodifytimes the btnmodifytimes to set
	 */
	public void setBtnmodifytimes(JButton btnmodifytimes) {
		this.btnmodifytimes = btnmodifytimes;
	}

	/**
	 * @return the btnAddDeliveryArea
	 */
	public JButton getBtnAddDeliveryArea() {
		return btnAddDeliveryArea;
	}

	/**
	 * @param btnAddDeliveryArea the btnAddDeliveryArea to set
	 */
	public void setBtnAddDeliveryArea(JButton btnAddDeliveryArea) {
		this.btnAddDeliveryArea = btnAddDeliveryArea;
	}

	/**
	 * @return the btnDeleteDeliveryArea
	 */
	public JButton getBtnDeleteDeliveryArea() {
		return btnDeleteDeliveryArea;
	}

	/**
	 * @param btnDeleteDeliveryArea the btnDeleteDeliveryArea to set
	 */
	public void setBtnDeleteDeliveryArea(JButton btnDeleteDeliveryArea) {
		this.btnDeleteDeliveryArea = btnDeleteDeliveryArea;
	}

	/**
	 * @return the restauranttable
	 */
	public JTable getRestauranttable() {
		return restauranttable;
	}

	/**
	 * @param restauranttable the restauranttable to set
	 */
	public void setRestauranttable(JTable restauranttable) {
		this.restauranttable = restauranttable;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	/**
	 * @return the listModel
	 */
	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	/**
	 * @param listModel the listModel to set
	 */
	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	/**
	 * @return the deliveryAreaList
	 */
	public JList<String> getDeliveryAreaList() {
		return deliveryAreaList;
	}

	/**
	 * @param deliveryAreaList the deliveryAreaList to set
	 */
	public void setDeliveryAreaList(JList<String> deliveryAreaList) {
		this.deliveryAreaList = deliveryAreaList;
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
	 * @return the mntmFileDisconnect
	 */
	public JMenuItem getMntmFileDisconnect() {
		return mntmFileDisconnect;
	}

	/**
	 * @param mntmFileDisconnect the mntmFileDisconnect to set
	 */
	public void setMntmFileDisconnect(JMenuItem mntmFileDisconnect) {
		this.mntmFileDisconnect = mntmFileDisconnect;
	}

	/**
	 * @return the mntmFileQuit
	 */
	public JMenuItem getMntmFileQuit() {
		return mntmFileQuit;
	}

	/**
	 * @param mntmFileQuit the mntmFileQuit to set
	 */
	public void setMntmFileQuit(JMenuItem mntmFileQuit) {
		this.mntmFileQuit = mntmFileQuit;
	}

	/**
	 * @return the mnRestaurant
	 */
	public JMenu getMnRestaurant() {
		return mnRestaurant;
	}

	/**
	 * @param mnRestaurant the mnRestaurant to set
	 */
	public void setMnRestaurant(JMenu mnRestaurant) {
		this.mnRestaurant = mnRestaurant;
	}

	/**
	 * @return the mntmRestaurantCreate
	 */
	public JMenuItem getMntmRestaurantCreate() {
		return mntmRestaurantCreate;
	}

	/**
	 * @param mntmRestaurantCreate the mntmRestaurantCreate to set
	 */
	public void setMntmRestaurantCreate(JMenuItem mntmRestaurantCreate) {
		this.mntmRestaurantCreate = mntmRestaurantCreate;
	}

	/**
	 * @return the mntmRestaurantEdit
	 */
	public JMenuItem getMntmRestaurantEdit() {
		return mntmRestaurantEdit;
	}

	/**
	 * @param mntmRestaurantEdit the mntmRestaurantEdit to set
	 */
	public void setMntmRestaurantEdit(JMenuItem mntmRestaurantEdit) {
		this.mntmRestaurantEdit = mntmRestaurantEdit;
	}

	/**
	 * @return the mntmRestaurantDelete
	 */
	public JMenuItem getMntmRestaurantDelete() {
		return mntmRestaurantDelete;
	}

	/**
	 * @param mntmRestaurantDelete the mntmRestaurantDelete to set
	 */
	public void setMntmRestaurantDelete(JMenuItem mntmRestaurantDelete) {
		this.mntmRestaurantDelete = mntmRestaurantDelete;
	}

	/**
	 * @return the mnMenu
	 */
	public JMenu getMnMenu() {
		return mnMenu;
	}

	/**
	 * @param mnMenu the mnMenu to set
	 */
	public void setMnMenu(JMenu mnMenu) {
		this.mnMenu = mnMenu;
	}

	/**
	 * @return the mntmMenuCreate
	 */
	public JMenuItem getMntmMenuCreate() {
		return mntmMenuCreate;
	}

	/**
	 * @param mntmMenuCreate the mntmMenuCreate to set
	 */
	public void setMntmMenuCreate(JMenuItem mntmMenuCreate) {
		this.mntmMenuCreate = mntmMenuCreate;
	}

	/**
	 * @return the mntmMenuEdit
	 */
	public JMenuItem getMntmMenuEdit() {
		return mntmMenuEdit;
	}

	/**
	 * @param mntmMenuEdit the mntmMenuEdit to set
	 */
	public void setMntmMenuEdit(JMenuItem mntmMenuEdit) {
		this.mntmMenuEdit = mntmMenuEdit;
	}

	/**
	 * @return the mntmMenuDelete
	 */
	public JMenuItem getMntmMenuDelete() {
		return mntmMenuDelete;
	}

	/**
	 * @param mntmMenuDelete the mntmMenuDelete to set
	 */
	public void setMntmMenuDelete(JMenuItem mntmMenuDelete) {
		this.mntmMenuDelete = mntmMenuDelete;
	}

	/**
	 * @return the mnDeliveryMan
	 */
	public JMenu getMnDeliveryMan() {
		return mnDeliveryMan;
	}

	/**
	 * @param mnDeliveryMan the mnDeliveryMan to set
	 */
	public void setMnDeliveryMan(JMenu mnDeliveryMan) {
		this.mnDeliveryMan = mnDeliveryMan;
	}

	/**
	 * @return the mntmCreateDeliveryGuy
	 */
	public JMenuItem getMntmCreateDeliveryGuy() {
		return mntmCreateDeliveryGuy;
	}

	/**
	 * @param mntmCreateDeliveryGuy the mntmCreateDeliveryGuy to set
	 */
	public void setMntmCreateDeliveryGuy(JMenuItem mntmCreateDeliveryGuy) {
		this.mntmCreateDeliveryGuy = mntmCreateDeliveryGuy;
	}

	/**
	 * @return the mntmEditDeliveryGuy
	 */
	public JMenuItem getMntmEditDeliveryGuy() {
		return mntmEditDeliveryGuy;
	}

	/**
	 * @param mntmEditDeliveryGuy the mntmEditDeliveryGuy to set
	 */
	public void setMntmEditDeliveryGuy(JMenuItem mntmEditDeliveryGuy) {
		this.mntmEditDeliveryGuy = mntmEditDeliveryGuy;
	}

	/**
	 * @return the mntmDeleteDeliveryGuy
	 */
	public JMenuItem getMntmDeleteDeliveryGuy() {
		return mntmDeleteDeliveryGuy;
	}

	/**
	 * @param mntmDeleteDeliveryGuy the mntmDeleteDeliveryGuy to set
	 */
	public void setMntmDeleteDeliveryGuy(JMenuItem mntmDeleteDeliveryGuy) {
		this.mntmDeleteDeliveryGuy = mntmDeleteDeliveryGuy;
	}
}
