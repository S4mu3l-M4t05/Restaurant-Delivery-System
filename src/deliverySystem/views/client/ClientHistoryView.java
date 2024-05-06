package deliverySystem.views.client;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import deliverySystem.models.restaurateur.OrdersClass;

public class ClientHistoryView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPane;
	private JPanel headPane;
	private JLabel lblTitle;
	private JLabel lblDeliveryDate;
	private JLabel lblDeliveryTime;
	private JLabel lblPostalCode;
	private JTextField txtDeliveryDate;
	private JTextField txtDeliveryTimeHours;
	private JLabel lblDeliveryTimeHours;
	private JTextField txtDeliveryTimeMinute;
	private JLabel lblDeliveryTimeMinute;
	private JTextField txtPostalCode;
	private JLabel lblOrders;
	private JList<OrdersClass> listOrders;
	private JLabel lblOrder;
	private JList<String> listOrder;

	public ClientHistoryView() {
		setTitle("Food Ordering Sofware");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		mainPane = new JPanel();
		contentPane.add(mainPane, BorderLayout.CENTER);
		mainPane.setLayout(null);

		lblDeliveryDate = new JLabel("Delivery Date:");
		lblDeliveryDate.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDeliveryDate.setBounds(281, 14, 97, 14);
		mainPane.add(lblDeliveryDate);

		lblDeliveryTime = new JLabel("Delivery Time:");
		lblDeliveryTime.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDeliveryTime.setBounds(281, 39, 97, 14);
		mainPane.add(lblDeliveryTime);

		lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPostalCode.setBounds(281, 64, 97, 14);
		mainPane.add(lblPostalCode);

		txtDeliveryDate = new JTextField();
		txtDeliveryDate.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDeliveryDate.setEditable(false);
		txtDeliveryDate.setBounds(388, 11, 97, 20);
		mainPane.add(txtDeliveryDate);
		txtDeliveryDate.setColumns(10);

		txtDeliveryTimeHours = new JTextField();
		txtDeliveryTimeHours.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDeliveryTimeHours.setEditable(false);
		txtDeliveryTimeHours.setBounds(388, 36, 25, 20);
		mainPane.add(txtDeliveryTimeHours);
		txtDeliveryTimeHours.setColumns(10);

		lblDeliveryTimeHours = new JLabel("h");
		lblDeliveryTimeHours.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDeliveryTimeHours.setBounds(415, 39, 14, 14);
		mainPane.add(lblDeliveryTimeHours);

		txtDeliveryTimeMinute = new JTextField();
		txtDeliveryTimeMinute.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDeliveryTimeMinute.setEditable(false);
		txtDeliveryTimeMinute.setBounds(433, 36, 25, 20);
		mainPane.add(txtDeliveryTimeMinute);
		txtDeliveryTimeMinute.setColumns(10);

		lblDeliveryTimeMinute = new JLabel("m");
		lblDeliveryTimeMinute.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDeliveryTimeMinute.setBounds(460, 39, 25, 14);
		mainPane.add(lblDeliveryTimeMinute);

		txtPostalCode = new JTextField();
		txtPostalCode.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPostalCode.setEditable(false);
		txtPostalCode.setBounds(388, 61, 97, 20);
		mainPane.add(txtPostalCode);
		txtPostalCode.setColumns(10);

		lblOrders = new JLabel("Your Orders");
		lblOrders.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrders.setBounds(10, 11, 250, 14);
		mainPane.add(lblOrders);

		listOrders = new JList<OrdersClass>();
		listOrders.setFont(new Font("Dialog", Font.PLAIN, 14));
		listOrders.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listOrders.setBounds(10, 39, 250, 452);
		mainPane.add(listOrders);

		lblOrder = new JLabel("Meal in Order");
		lblOrder.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblOrder.setBounds(299, 106, 186, 23);
		mainPane.add(lblOrder);

		listOrder = new JList<String>();
		listOrder.setFont(new Font("Dialog", Font.PLAIN, 14));
		listOrder.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listOrder.setBounds(299, 131, 285, 225);
		mainPane.add(listOrder);

		headPane = new JPanel();
		contentPane.add(headPane, BorderLayout.NORTH);

		lblTitle = new JLabel("View Order");
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 25));
		headPane.add(lblTitle);
	}

	public JTextField getTxtDeliveryDate() {
		return txtDeliveryDate;
	}

	public void setTxtDeliveryDate(JTextField txtDeliveryDate) {
		this.txtDeliveryDate = txtDeliveryDate;
	}

	public JTextField getTxtDeliveryTimeHours() {
		return txtDeliveryTimeHours;
	}

	public void setTxtDeliveryTimeHours(JTextField txtDeliveryTimeHours) {
		this.txtDeliveryTimeHours = txtDeliveryTimeHours;
	}

	public JTextField getTxtDeliveryTimeMinute() {
		return txtDeliveryTimeMinute;
	}

	public void setTxtDeliveryTimeMinute(JTextField txtDeliveryTimeMinute) {
		this.txtDeliveryTimeMinute = txtDeliveryTimeMinute;
	}

	public JTextField getTxtPostalCode() {
		return txtPostalCode;
	}

	public void setTxtPostalCode(JTextField txtPostalCode) {
		this.txtPostalCode = txtPostalCode;
	}

	public JList<OrdersClass> getListOrders() {
		return listOrders;
	}

	public void setListOrders(JList<OrdersClass> listOrders) {
		this.listOrders = listOrders;
	}

	public JList<String> getListOrder() {
		return listOrder;
	}

	public void setListOrder(JList<String> listOrder) {
		this.listOrder = listOrder;
	}

}
