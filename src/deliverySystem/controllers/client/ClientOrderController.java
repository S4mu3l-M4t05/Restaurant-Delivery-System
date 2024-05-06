package deliverySystem.controllers.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import deliverySystem.models.admin.MenuItem;
import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.client.OrderModel;
import deliverySystem.models.restaurateur.OrdersClass;
import deliverySystem.views.client.ClientOrderView;

public class ClientOrderController {
	private final ClientOrderView view;
	private final OrderModel model;
	private String loggedInUsername;

	public ClientOrderController(ClientOrderView view, OrderModel model, String loggedInUsername) {
		this.view = view;
		this.model = model;
		this.loggedInUsername = loggedInUsername;

		view.getBtnOrder().addActionListener(new OrderButtonListener());
		view.getBtnAdd().addActionListener(new AddButtonListener());
		view.getBtnDelete().addActionListener(new DeleteButtonListener());
		displayAllRestaurants();
		view.getListRestaurant().addListSelectionListener(new RestaurantListListener());
		view.getListMenu().addListSelectionListener(new MenuListListener());
	}

	class OrderButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedRestaurantName = view.getSelectedRestaurant();
			if (selectedRestaurantName == null) {
				JOptionPane.showMessageDialog(view, "Please select a restaurant", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			RestaurantClass selectedRestaurant = model.getRestaurantByName(selectedRestaurantName);
			if (selectedRestaurant == null) {
				JOptionPane.showMessageDialog(view, "Failed to retrieve restaurant information", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			String deliveryDate = view.getTxtDeliveryDate().getText();
			String deliveryTime = view.getTxtDeliveryTimeHours().getText() + view.getTxtDeliveryTimeMinute().getText();
			String postalCode = view.getTxtPostalCode().getText();

			String address = JOptionPane.showInputDialog(view, "Enter delivery address:");
			if (address == null || address.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Please enter a delivery address", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String clientId = model.getClientIdByUsername(loggedInUsername);

			if (deliveryDate.isEmpty() || deliveryTime.isEmpty() || postalCode.isEmpty() || address.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Please fill in all required fields", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!isValidDateFormat(deliveryDate)) {
				JOptionPane.showMessageDialog(view, "Please enter a valid delivery date (YYYY-MM-DD)", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!isValidTimeFormat(deliveryTime)) {
				JOptionPane.showMessageDialog(view, "Please enter a valid delivery time (HHMM)", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!isValidPostalCode(postalCode)) {
				JOptionPane.showMessageDialog(view, "Please enter a valid postal code", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int parsedClientId = Integer.parseInt(clientId);
			int parsedRestaurantId = Integer.parseInt(selectedRestaurant.getId());
			String deliveryDateTime = deliveryDate + " " + deliveryTime.substring(0, 2) + ":"
					+ deliveryTime.substring(2);
			if (!isDeliveryTimeValid(deliveryDateTime)) {
				JOptionPane.showMessageDialog(view, "Delivery time should be at least an hour after the current time",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			ListModel<String> orderListModel = view.getListOrder().getModel();
			StringBuilder orderDetailsBuilder = new StringBuilder();
			for (int i = 0; i < orderListModel.getSize(); i++) {
				String orderInfo = orderListModel.getElementAt(i);
				orderDetailsBuilder.append(orderInfo).append("\n");
			}
			String orderDetails = orderDetailsBuilder.toString().trim();

			OrdersClass order = new OrdersClass(0, parsedClientId, parsedRestaurantId, "Pending",
					0, deliveryDateTime,
					orderDetails, postalCode, address);
			model.createOrder(order);

			JOptionPane.showMessageDialog(view, "Order created successfully", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		}

		private boolean isValidDateFormat(String date) {
			return date.matches("\\d{4}-\\d{2}-\\d{2}");
		}

		private boolean isValidTimeFormat(String time) {
			return time.matches("\\d{4}");
		}

		private boolean isValidPostalCode(String postalCode) {
			return postalCode.matches("[A-Za-z]\\d[A-Za-z]\\s*|\\d[A-Za-z]\\d\\s*");
		}

		private boolean isDeliveryTimeValid(String deliveryDateTime) {
			LocalDateTime currentTime = LocalDateTime.now();

			LocalDateTime deliveryTime = LocalDateTime.parse(deliveryDateTime,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

			return deliveryTime.isAfter(currentTime.plusHours(1));
		}
	}

	class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedMenuItemName = view.getTxtMeal().getText();
			double selectedMenuItemPrice = Double.parseDouble(view.getTxtPrice().getText());

			int quantity = Integer.parseInt(view.getTxtQuantity().getText());

			if (quantity > 10) {
				JOptionPane.showMessageDialog(view, "Maximum quantity allowed is 10", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			double totalPrice = selectedMenuItemPrice * quantity;

			ListModel<String> orderListModel = view.getListOrder().getModel();
			DefaultListModel<String> newOrderListModel;
			if (orderListModel instanceof DefaultListModel) {
				newOrderListModel = (DefaultListModel<String>) orderListModel;
			} else {
				newOrderListModel = new DefaultListModel<>();
			}

			String orderInfo = String.format("%s - Quantity: %d - Total: $%.2f", selectedMenuItemName, quantity,
					totalPrice);
			newOrderListModel.addElement(orderInfo);
			view.getListOrder().setModel(newOrderListModel);

			view.getTxtQuantity().setText("");
			calculateAndDisplaySubtotal();
		}
	}

	class DeleteButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedIndex = view.getListOrder().getSelectedIndex();

			if (selectedIndex != -1) {
				DefaultListModel<String> orderListModel = (DefaultListModel<String>) view.getListOrder().getModel();
				orderListModel.remove(selectedIndex);
			} else {
				JOptionPane.showMessageDialog(view, "Please select a row to delete", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			calculateAndDisplaySubtotal();
		}
	}

	class RestaurantListListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				String selectedRestaurantName = view.getSelectedRestaurant();
				if (selectedRestaurantName != null) {
					RestaurantClass selectedRestaurant = model.getRestaurantByName(selectedRestaurantName);
					if (selectedRestaurant != null) {
						displayMenuForRestaurant(selectedRestaurant);
					} else {
						JOptionPane.showMessageDialog(view, "Failed to retrieve restaurant information", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	class MenuListListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				int selectedIndex = view.getListMenu().getSelectedIndex();

				String selectedRestaurantName = view.getSelectedRestaurant();
				RestaurantClass selectedRestaurant = model.getRestaurantByName(selectedRestaurantName);

				MenuItem selectedMenuItem = model.getMenuItemByIndex(selectedIndex, selectedRestaurant);

				if (selectedMenuItem != null) {
					view.getTxtMeal().setText(selectedMenuItem.getItemName());
					view.getTxtPrice().setText(String.valueOf(selectedMenuItem.getPrice()));
				}
			}
		}
	}

	private void displayAllRestaurants() {
		List<RestaurantClass> restaurants = model.getAllRestaurants();
		view.setListRestaurantData(restaurants);
	}

	private void displayMenuForRestaurant(RestaurantClass restaurant) {
		List<MenuItem> menu = model.getMenuForRestaurant(restaurant);
		view.setListMenuData(menu);
	}

	private void calculateAndDisplaySubtotal() {
		double subtotal = 0.0;
		DefaultListModel<String> orderListModel = (DefaultListModel<String>) view.getListOrder().getModel();
		for (int i = 0; i < orderListModel.size(); i++) {
			String orderInfo = orderListModel.getElementAt(i);
			String[] parts = orderInfo.split(" - Total: \\$");
			double totalPrice = Double.parseDouble(parts[1]);
			subtotal += totalPrice;
		}
		view.getTxtTotal().setText(String.format("%.2f", subtotal));
	}
}
