package deliverySystem.controllers.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import deliverySystem.controllers.LoginController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.manager.managerMenuEditModel;
import deliverySystem.models.manager.managerRestaurantEditModel;
import deliverySystem.models.manager.viewRestaurantOrderModel;
import deliverySystem.views.LoginView;
import deliverySystem.views.manager.managerMenuEditView;
import deliverySystem.views.manager.managerRestaurantEditView;
import deliverySystem.views.manager.viewRestaurantOrder;

public class managerMenuEditController implements ActionListener, ListSelectionListener {
	private managerMenuEditModel model;
	private managerMenuEditView view;
	private String username;
	private String selectedItemName;

	public managerMenuEditController(managerMenuEditModel model, managerMenuEditView view, String username) {
		this.model = model;
		this.view = view;
		this.username = username;

		view.getMntmDisconnect().addActionListener(this);
		view.getMntmQuit().addActionListener(this);
		view.getMntmRestaurant().addActionListener(this);
		view.getMntmMenu().addActionListener(this);
		view.getMntmViewrestaurantOrder().addActionListener(this);
		view.getBtnAddItem().addActionListener(this);
		view.getListMenu().addListSelectionListener(this);

		String managerRestaurant = model.getManagerRestaurant(username);
		DefaultListModel<String> restaurantListModel = new DefaultListModel<>();
		restaurantListModel.addElement(managerRestaurant);
		view.getListRestaurant().setModel(restaurantListModel);
		view.getListRestaurant().addListSelectionListener(this);
		view.getListMenu().addListSelectionListener(this);

		displayManagerMenu();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting() && e.getSource() == view.getListMenu()
				&& view.getListMenu().getSelectedValue() != null) {
			String selectedMenuItem = (String) view.getListMenu().getSelectedValue();

			if (selectedMenuItem.contains(" - ")) {
				String[] parts = selectedMenuItem.split(" - ");
				selectedItemName = parts[0];
				double selectedItemPrice = Double.parseDouble(parts[1].substring(1));

				view.getTxtItemName().setText(selectedItemName);
				view.getTxtPrice().setText(String.valueOf(selectedItemPrice));
			} else {
				selectedItemName = "";
				view.getTxtItemName().setText("");
				view.getTxtPrice().setText("");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getBtnAddItem()) {
			String newItemName = view.getTxtItemName().getText().trim();
			String priceText = view.getTxtPrice().getText().trim();

			if (newItemName.isEmpty() || priceText.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double newPrice;
			try {
				newPrice = Double.parseDouble(priceText);
				if (newPrice < 0) {
					JOptionPane.showMessageDialog(view, "Price cannot be negative.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(view, "Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String managerRestaurant = model.getManagerRestaurant(username);
			int restaurantId = model.getRestaurantId(managerRestaurant);

			model.updateMenuItem(restaurantId, selectedItemName, newItemName, newPrice);
			displayManagerMenu();
		}
		if (e.getSource() == view.getMntmQuit()) {
			quit();
		}
		if (e.getSource() == view.getMntmDisconnect()) {
			view.dispose();
			LoginView view = new LoginView();
			LoginModel model = new LoginModel();
			new LoginController(view, model);
			view.setVisible(true);
		}
		if (e.getSource() == view.getMntmRestaurant()) {
			managerRestaurantEditView managerRestaurantEditView = new managerRestaurantEditView();
			managerRestaurantEditModel managerRestaurantEditModel = new managerRestaurantEditModel();
			new managerRestaurantEditController(managerRestaurantEditModel, managerRestaurantEditView, username);
			view.dispose();
			managerRestaurantEditView.setVisible(true);
		}
		if (e.getSource() == view.getMntmMenu()) {
			managerMenuEditModel managerMenuEditModel = new managerMenuEditModel();
			managerMenuEditView managerMenuEditView = new managerMenuEditView();
			new managerMenuEditController(managerMenuEditModel, managerMenuEditView, username);
			view.dispose();
			managerMenuEditView.setVisible(true);
		}
		if (e.getSource() == view.getMntmViewrestaurantOrder()) {
			viewRestaurantOrder viewRestaurantOrder = new viewRestaurantOrder();
			viewRestaurantOrderModel viewRestaurantOrderModel = new viewRestaurantOrderModel();
			new viewRestaurantOrderController(viewRestaurantOrderModel, viewRestaurantOrder, username);
			view.dispose();
			viewRestaurantOrder.setVisible(true);
		}
	}

	public void quit() {
		JFrame frame = new JFrame("Close");
		if (JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application", "Quit",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

			System.exit(0);

		}
	}

	private void displayManagerMenu() {
		String managerRestaurant = model.getManagerRestaurant(username);
		int restaurantId = model.getRestaurantId(managerRestaurant);
		List<String> menuItems = model.getMenuItemsForRestaurant(restaurantId);
		DefaultListModel<String> menuListModel = new DefaultListModel<>();
		for (String menuItem : menuItems) {
			menuListModel.addElement(menuItem);
		}
		view.getListMenu().setModel(menuListModel);
	}

}
