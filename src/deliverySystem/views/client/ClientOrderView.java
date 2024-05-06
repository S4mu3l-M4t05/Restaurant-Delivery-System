package deliverySystem.views.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import deliverySystem.models.admin.MenuItem;
import deliverySystem.models.admin.RestaurantClass;

public class ClientOrderView extends JFrame {

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
	private JLabel lblRestaurant;
	private JList<String> listRestaurant;
	private JLabel lblMenu;
	private JList<String> listMenu;
	private JLabel lblOrder;
	private JList<String> listOrder;
	private JLabel lblMeal;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JTextField txtMeal;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JButton btnDelete;
	private JButton btnAdd;
	private JLabel lblWarning;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JLabel lbl$;
	private JButton btnOrder;

	public ClientOrderView() {
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
		lblDeliveryDate.setBounds(214, 14, 79, 14);
		mainPane.add(lblDeliveryDate);

		lblDeliveryTime = new JLabel("Delivery Time:");
		lblDeliveryTime.setBounds(214, 39, 79, 14);
		mainPane.add(lblDeliveryTime);

		lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setBounds(214, 64, 79, 14);
		mainPane.add(lblPostalCode);

		txtDeliveryDate = new JTextField();
		txtDeliveryDate.setBounds(303, 11, 86, 20);
		mainPane.add(txtDeliveryDate);
		txtDeliveryDate.setColumns(10);

		txtDeliveryTimeHours = new JTextField();
		txtDeliveryTimeHours.setBounds(303, 36, 25, 20);
		mainPane.add(txtDeliveryTimeHours);
		txtDeliveryTimeHours.setColumns(10);

		lblDeliveryTimeHours = new JLabel("h");
		lblDeliveryTimeHours.setBounds(330, 39, 14, 14);
		mainPane.add(lblDeliveryTimeHours);

		txtDeliveryTimeMinute = new JTextField();
		txtDeliveryTimeMinute.setBounds(348, 36, 25, 20);
		mainPane.add(txtDeliveryTimeMinute);
		txtDeliveryTimeMinute.setColumns(10);

		lblDeliveryTimeMinute = new JLabel("m");
		lblDeliveryTimeMinute.setBounds(375, 39, 25, 14);
		mainPane.add(lblDeliveryTimeMinute);

		txtPostalCode = new JTextField();
		txtPostalCode.setBounds(303, 61, 86, 20);
		mainPane.add(txtPostalCode);
		txtPostalCode.setColumns(10);

		lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setBounds(128, 122, 127, 14);
		mainPane.add(lblRestaurant);

		listRestaurant = new JList<String>();
		listRestaurant.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listRestaurant.setBounds(128, 147, 127, 258);
		mainPane.add(listRestaurant);

		lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(265, 122, 124, 14);
		mainPane.add(lblMenu);

		listMenu = new JList<String>();
		listMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMenu.setBounds(262, 147, 127, 258);
		mainPane.add(listMenu);

		lblOrder = new JLabel("Order");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setBounds(574, 122, 127, 14);
		mainPane.add(lblOrder);

		listOrder = new JList<String>();
		listOrder.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listOrder.setBounds(574, 147, 213, 258);
		mainPane.add(listOrder);

		lblMeal = new JLabel("Meal:");
		lblMeal.setBounds(411, 150, 46, 14);
		mainPane.add(lblMeal);

		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(411, 175, 46, 14);
		mainPane.add(lblPrice);

		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(411, 200, 46, 14);
		mainPane.add(lblQuantity);

		txtMeal = new JTextField();
		txtMeal.setEditable(false);
		txtMeal.setColumns(10);
		txtMeal.setBounds(467, 147, 86, 20);
		mainPane.add(txtMeal);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(467, 172, 86, 20);
		mainPane.add(txtPrice);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(467, 197, 86, 20);
		mainPane.add(txtQuantity);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(464, 382, 89, 23);
		mainPane.add(btnDelete);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(464, 355, 89, 23);
		mainPane.add(btnAdd);

		lblWarning = new JLabel("(Max 10)");
		lblWarning.setBounds(411, 225, 74, 14);
		mainPane.add(lblWarning);

		lblTotal = new JLabel("Subtotal");
		lblTotal.setBounds(330, 416, 59, 14);
		mainPane.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(399, 413, 86, 20);
		mainPane.add(txtTotal);
		txtTotal.setColumns(10);

		lbl$ = new JLabel("$");
		lbl$.setBounds(495, 416, 46, 14);
		mainPane.add(lbl$);

		btnOrder = new JButton("Order");
		btnOrder.setBounds(399, 444, 89, 23);
		mainPane.add(btnOrder);

		headPane = new JPanel();
		contentPane.add(headPane, BorderLayout.NORTH);

		lblTitle = new JLabel("Order Food");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
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

	public JList<String> getListRestaurant() {
		return listRestaurant;
	}

	public void setListRestaurant(JList<String> listRestaurant) {
		this.listRestaurant = listRestaurant;
	}

	public JList<String> getListMenu() {
		return listMenu;
	}

	public void setListMenu(JList<String> listMenu) {
		this.listMenu = listMenu;
	}

	public JList<String> getListOrder() {
		return listOrder;
	}

	public void setListOrder(JList<String> listOrder) {
		this.listOrder = listOrder;
	}

	public JTextField getTxtMeal() {
		return txtMeal;
	}

	public void setTxtMeal(JTextField txtMeal) {
		this.txtMeal = txtMeal;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

	public JTextField getTxtQuantity() {
		return txtQuantity;
	}

	public void setTxtQuantity(JTextField txtQuantity) {
		this.txtQuantity = txtQuantity;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public void setTxtTotal(JTextField txtTotal) {
		this.txtTotal = txtTotal;
	}

	public JButton getBtnOrder() {
		return btnOrder;
	}

	public void setBtnOrder(JButton btnOrder) {
		this.btnOrder = btnOrder;
	}

	public String getSelectedRestaurant() {
		return listRestaurant.getSelectedValue();
	}

	public void setListRestaurantData(List<RestaurantClass> restaurants) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (RestaurantClass restaurant : restaurants) {
			model.addElement(restaurant.getName());
		}
		listRestaurant.setModel(model);
	}

	public void setListMenuData(List<MenuItem> menu) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (MenuItem menuItem : menu) {
			model.addElement(menuItem.toString());
		}
		listMenu.setModel(model);
	}

}
