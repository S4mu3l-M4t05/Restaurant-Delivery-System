package deliverySystem.views.manager;

import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class managerRestaurantEditView extends JFrame {



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
	private JButton btnSave = new JButton("Save");
	private JButton btnmodifytimes = new JButton("Modify all times at once\r\n");
	private JButton btnAddDeliveryArea = new JButton("Add");
	private JButton btnDeleteDeliveryArea = new JButton("Delete");
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JList <String> deliveryAreaList = new JList(listModel);
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenu = new JMenu("New menu");
	private DefaultListModel<String> listModelresto = new DefaultListModel<>();
	private JList restaurant_list = new JList(listModelresto);
	private JPanel panel = new JPanel();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
	private JMenuItem mntmQuit = new JMenuItem("Quit");
	private JMenu mnNewEdit = new JMenu("Edit");
	private JMenuItem mntmRestaurant = new JMenuItem("Restaurant");
	private JMenuItem mntmMenu = new JMenuItem("Menu");
	private JMenu mnOrder = new JMenu("Order");
	private JMenuItem mntmViewrestaurantOrder = new JMenuItem("View restaurants order");







	/**
	 * Create the application.
	 */
	public managerRestaurantEditView() {
		getContentPane().setBackground(Color.decode("#28384d"));
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant Edit");
		this.setBounds(100, 100, 902, 856);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
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
		panel.setBounds(54, 52, 787, 741);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		txt_restaurantname.setEditable(false);
		
		
		txt_restaurantname.setBounds(480, 56, 243, 20);
		panel.add(txt_restaurantname);
		txt_restaurantname.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		txt_restaurantname.setForeground(Color.BLACK);
		txt_restaurantname.setColumns(10);
		txtphonenum.setEditable(false);
		txtphonenum.setBounds(480, 118, 119, 20);
		panel.add(txtphonenum);
		txtphonenum.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		txtphonenum.setColumns(10);
		txtdeliveryarea.setBounds(609, 615, 51, 20);
		panel.add(txtdeliveryarea);
		txtdeliveryarea.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		txtdeliveryarea.setColumns(10);
		txt_restaurantaddress.setEditable(false);
		txt_restaurantaddress.setBounds(480, 87, 243, 20);
		panel.add(txt_restaurantaddress);
		txt_restaurantaddress.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		txt_restaurantaddress.setColumns(10);
		
		
		JLabel lblEdit = new JLabel("Restaurant Edit");
		lblEdit.setForeground(new Color(255, 255, 255));
		lblEdit.setBackground(new Color(255, 255, 255));
		lblEdit.setBounds(393, 20, 302, 25);
		panel.add(lblEdit);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		

		
		JLabel lblrestaurantName = new JLabel("Restaurant Name:");
		lblrestaurantName.setBounds(304, 50, 162, 29);
		panel.add(lblrestaurantName);
		lblrestaurantName.setHorizontalAlignment(SwingConstants.LEFT);
		lblrestaurantName.setForeground(new Color(255, 255, 255));
		lblrestaurantName.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		
		

		
		JLabel lblrestaurantAddress = new JLabel("Restaurant Address:");
		lblrestaurantAddress.setBackground(new Color(255, 255, 255));
		lblrestaurantAddress.setBounds(295, 81, 190, 29);
		panel.add(lblrestaurantAddress);
		lblrestaurantAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblrestaurantAddress.setForeground(new Color(255, 255, 255));
		lblrestaurantAddress.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		
		
	
		
		JLabel lblrestaurantphoneNum = new JLabel("Phone Number:");
		lblrestaurantphoneNum.setBounds(304, 112, 138, 29);
		panel.add(lblrestaurantphoneNum);
		lblrestaurantphoneNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblrestaurantphoneNum.setForeground(new Color(255, 255, 255));
		lblrestaurantphoneNum.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		

	
		
		JLabel lblOpenningtime = new JLabel("Openning Time");
		lblOpenningtime.setForeground(new Color(255, 255, 255));
		lblOpenningtime.setBounds(445, 158, 215, 29);
		panel.add(lblOpenningtime);
		lblOpenningtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenningtime.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(333, 194, 33, 14);
		panel.add(lblDay);
		lblDay.setForeground(new Color(255, 255, 255));
		lblDay.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		
		JLabel lblOpenningTime = new JLabel("Openning Time");
		lblOpenningTime.setBounds(434, 195, 109, 14);
		panel.add(lblOpenningTime);
		lblOpenningTime.setForeground(new Color(255, 255, 255));
		lblOpenningTime.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		
		JLabel lblClosingTime = new JLabel("Closing Time");
		lblClosingTime.setBounds(612, 194, 96, 14);
		panel.add(lblClosingTime);
		lblClosingTime.setForeground(new Color(255, 255, 255));
		lblClosingTime.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		
		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setBounds(333, 223, 51, 14);
		panel.add(lblSunday);
		lblSunday.setForeground(new Color(255, 255, 255));
		lblSunday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSU1.setBounds(434, 220, 62, 22);
		panel.add(comboBoxSU1);
		comboBoxSU1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxSU1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblSUh = new JLabel("h");
		lblSUh.setBounds(505, 224, 20, 14);
		panel.add(lblSUh);
		lblSUh.setForeground(new Color(255, 255, 255));
		lblSUh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSU2.setBounds(528, 220, 51, 22);
		panel.add(comboBoxSU2);
		comboBoxSU2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxSU2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxSU3.setBounds(598, 220, 62, 22);
		panel.add(comboBoxSU3);
		comboBoxSU3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxSU3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblSUh2 = new JLabel("h");
		lblSUh2.setBounds(670, 224, 20, 14);
		panel.add(lblSUh2);
		lblSUh2.setForeground(new Color(255, 255, 255));
		lblSUh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSU4.setBounds(691, 219, 51, 22);
		panel.add(comboBoxSU4);
		comboBoxSU4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxSU4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBounds(333, 256, 51, 14);
		panel.add(lblMonday);
		lblMonday.setForeground(new Color(255, 255, 255));
		lblMonday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxMO1.setBounds(434, 253, 62, 22);
		panel.add(comboBoxMO1);
		comboBoxMO1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxMO1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblMOh = new JLabel("h");
		lblMOh.setBounds(505, 257, 20, 14);
		panel.add(lblMOh);
		lblMOh.setForeground(new Color(255, 255, 255));
		lblMOh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxMO2.setBounds(528, 253, 51, 22);
		panel.add(comboBoxMO2);
		comboBoxMO2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxMO2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxMO3.setBounds(598, 253, 62, 22);
		panel.add(comboBoxMO3);
		comboBoxMO3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxMO3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblMOh2 = new JLabel("h");
		lblMOh2.setBounds(670, 257, 20, 14);
		panel.add(lblMOh2);
		lblMOh2.setForeground(new Color(255, 255, 255));
		lblMOh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxMO4.setBounds(691, 252, 51, 22);
		panel.add(comboBoxMO4);
		comboBoxMO4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxMO4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(333, 290, 72, 14);
		panel.add(lblTuesday);
		lblTuesday.setForeground(new Color(255, 255, 255));
		lblTuesday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTU1.setBounds(434, 286, 62, 22);
		panel.add(comboBoxTU1);
		comboBoxTU1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		

		comboBoxTU1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblTU1 = new JLabel("h");
		lblTU1.setBounds(505, 291, 20, 14);
		panel.add(lblTU1);
		lblTU1.setForeground(new Color(255, 255, 255));
		lblTU1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTU2.setBounds(528, 287, 51, 22);
		panel.add(comboBoxTU2);
		comboBoxTU2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxTU2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxTU3.setBounds(598, 286, 62, 22);
		panel.add(comboBoxTU3);
		comboBoxTU3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxTU3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblTUh2 = new JLabel("h");
		lblTUh2.setBounds(670, 291, 20, 14);
		panel.add(lblTUh2);
		lblTUh2.setForeground(new Color(255, 255, 255));
		lblTUh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTU4.setBounds(691, 287, 51, 22);
		panel.add(comboBoxTU4);
		comboBoxTU4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxTU4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setBounds(333, 320, 72, 14);
		panel.add(lblWednesday);
		lblWednesday.setForeground(new Color(255, 255, 255));
		lblWednesday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxWE1.setBounds(434, 319, 62, 22);
		panel.add(comboBoxWE1);
		comboBoxWE1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxWE1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblWEh = new JLabel("h");
		lblWEh.setBounds(505, 321, 20, 14);
		panel.add(lblWEh);
		lblWEh.setForeground(new Color(255, 255, 255));
		lblWEh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxWE2.setBounds(528, 320, 51, 22);
		panel.add(comboBoxWE2);
		comboBoxWE2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxWE2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxWE3.setBounds(598, 319, 62, 22);
		panel.add(comboBoxWE3);
		comboBoxWE3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxWE3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblWEh2 = new JLabel("h");
		lblWEh2.setBounds(670, 321, 20, 14);
		panel.add(lblWEh2);
		lblWEh2.setForeground(new Color(255, 255, 255));
		lblWEh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxWE4.setBounds(691, 317, 51, 22);
		panel.add(comboBoxWE4);
		comboBoxWE4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxWE4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setBounds(333, 354, 72, 14);
		panel.add(lblThursday);
		lblThursday.setForeground(new Color(255, 255, 255));
		lblThursday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTH1.setBounds(434, 351, 62, 22);
		panel.add(comboBoxTH1);
		comboBoxTH1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxTH1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblTHh = new JLabel("h");
		lblTHh.setBounds(505, 355, 20, 14);
		panel.add(lblTHh);
		lblTHh.setForeground(new Color(255, 255, 255));
		lblTHh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTH2.setBounds(528, 351, 51, 22);
		panel.add(comboBoxTH2);
		comboBoxTH2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		

		comboBoxTH2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxTH3.setBounds(598, 352, 62, 22);
		panel.add(comboBoxTH3);
		comboBoxTH3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxTH3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblTHh2 = new JLabel("h");
		lblTHh2.setBounds(670, 355, 20, 14);
		panel.add(lblTHh2);
		lblTHh2.setForeground(new Color(255, 255, 255));
		lblTHh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxTH4.setBounds(691, 351, 51, 22);
		panel.add(comboBoxTH4);
		comboBoxTH4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxTH4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(333, 387, 72, 14);
		panel.add(lblFriday);
		lblFriday.setForeground(new Color(255, 255, 255));
		lblFriday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxFR1.setBounds(434, 384, 62, 22);
		panel.add(comboBoxFR1);
		comboBoxFR1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxFR1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblFRh = new JLabel("h");
		lblFRh.setBounds(505, 388, 20, 14);
		panel.add(lblFRh);
		lblFRh.setForeground(new Color(255, 255, 255));
		lblFRh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxFR2.setBounds(528, 384, 51, 22);
		panel.add(comboBoxFR2);
		comboBoxFR2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxFR2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxFR3.setBounds(598, 384, 62, 22);
		panel.add(comboBoxFR3);
		comboBoxFR3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxFR3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblFRh2 = new JLabel("h");
		lblFRh2.setBounds(670, 388, 20, 14);
		panel.add(lblFRh2);
		lblFRh2.setForeground(new Color(255, 255, 255));
		lblFRh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxFR4.setBounds(691, 384, 51, 22);
		panel.add(comboBoxFR4);
		comboBoxFR4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxFR4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setBounds(333, 419, 72, 14);
		panel.add(lblSaturday);
		lblSaturday.setForeground(new Color(255, 255, 255));
		lblSaturday.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSA1.setBounds(434, 417, 62, 22);
		panel.add(comboBoxSA1);
		comboBoxSA1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxSA1.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblSAh = new JLabel("h");
		lblSAh.setBounds(505, 420, 20, 14);
		panel.add(lblSAh);
		lblSAh.setForeground(new Color(255, 255, 255));
		lblSAh.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSA2.setBounds(528, 416, 51, 22);
		panel.add(comboBoxSA2);
		comboBoxSA2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxSA2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxSA3.setBounds(598, 417, 62, 22);
		panel.add(comboBoxSA3);
		comboBoxSA3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		comboBoxSA3.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblSAh2 = new JLabel("h");
		lblSAh2.setBounds(670, 420, 20, 14);
		panel.add(lblSAh2);
		lblSAh2.setForeground(new Color(255, 255, 255));
		lblSAh2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 13));
		comboBoxSA4.setBounds(691, 417, 51, 22);
		panel.add(comboBoxSA4);
		comboBoxSA4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		comboBoxSA4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		btnmodifytimes.setBackground(new Color(255, 255, 255));
		
		btnmodifytimes.setBounds(434, 450, 318, 38);
		panel.add(btnmodifytimes);
		btnmodifytimes.setEnabled(false);
		btnmodifytimes.setForeground(Color.decode("#212f40"));
		btnmodifytimes.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 12));
		
		JLabel lblDeliveryArea_1 = new JLabel("Delivery Area");
		lblDeliveryArea_1.setForeground(new Color(255, 255, 255));
		lblDeliveryArea_1.setBounds(480, 499, 215, 29);
		panel.add(lblDeliveryArea_1);
		lblDeliveryArea_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryArea_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		
		JLabel lblDeliveryArea = new JLabel("Delivery Area:");
		lblDeliveryArea.setBounds(480, 609, 134, 29);
		panel.add(lblDeliveryArea);
		lblDeliveryArea.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeliveryArea.setForeground(new Color(255, 255, 255));
		lblDeliveryArea.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		btnAddDeliveryArea.setBackground(new Color(255, 255, 255));
		
		btnAddDeliveryArea.setBounds(636, 646, 106, 29);
		panel.add(btnAddDeliveryArea);
		btnAddDeliveryArea.setForeground(Color.decode("#212f40"));
		btnAddDeliveryArea.setEnabled(false);
		btnAddDeliveryArea.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 12));
		btnDeleteDeliveryArea.setBackground(new Color(255, 255, 255));
		
		btnDeleteDeliveryArea.setBounds(528, 646, 98, 29);
		panel.add(btnDeleteDeliveryArea);
		btnDeleteDeliveryArea.setForeground(Color.decode("#212f40"));
		btnDeleteDeliveryArea.setEnabled(false);
		btnDeleteDeliveryArea.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 12));
		btnSave.setBackground(new Color(255, 255, 255));
		
		btnSave.setBounds(573, 685, 119, 38);
		panel.add(btnSave);
		btnSave.setForeground(Color.decode("#212f40"));
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 12));
		
		
			deliveryAreaList.setBounds(471, 529, 252, 75);
			panel.add(deliveryAreaList);
			deliveryAreaList.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
			
					deliveryAreaList.setVisibleRowCount(4);
					deliveryAreaList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					
					JLabel lblRestaurant = new JLabel("Restaurant");
					lblRestaurant.setForeground(new Color(255, 255, 255));
					
					lblRestaurant.setBackground(new Color(255, 255, 255));
					lblRestaurant.setBounds(53, 14, 215, 29);
					panel.add(lblRestaurant);
					lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
					lblRestaurant.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
					restaurant_list.setBounds(33, 49, 243, 628);
					panel.add(restaurant_list);
					restaurant_list.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		menuBar.setBounds(0, 0, 886, 22);
		this.getContentPane().add(menuBar);
		

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
	
	

	}


	/**
	 * @return the listModelresto
	 */
	public DefaultListModel<String> getListModelresto() {
		return listModelresto;
	}

	/**
	 * @param listModelresto the listModelresto to set
	 */
	public void setListModelresto(DefaultListModel<String> listModelresto) {
		this.listModelresto = listModelresto;
	}

	/**
	 * @return the restaurant_list
	 */
	public JList getRestaurant_list() {
		return restaurant_list;
	}

	/**
	 * @param restaurant_list the restaurant_list to set
	 */
	public void setRestaurant_list(JList restaurant_list) {
		this.restaurant_list = restaurant_list;
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
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
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
