package deliverySystem.controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import deliverySystem.models.admin.Menu;
import deliverySystem.models.admin.MenuItem;
import deliverySystem.models.admin.MenuModel;
import deliverySystem.views.admin.MenuCreateView;

public class MenuCreateController {
	private MenuModel model;
	private MenuCreateView view;
	private Menu menu;

	public MenuCreateController(MenuModel model, MenuCreateView view) {
		this.model = model;
		this.view = view;
		view.getBtnAddItem().addActionListener(new AddItemListener());
		view.getBtnCreateMenu().addActionListener(new CreateMenuListener());
		view.getBtnSelect().addActionListener(new SelectRestaurantListener());

		displayRestaurants();
		menu = new Menu();
	}

	private void displayRestaurants() {
		try {
			List<String> restaurants = model.getRestaurantsWithNoMenu();

			JTable table = view.getTableRestaurant();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			tableModel.setRowCount(0);

			for (String restaurant : restaurants) {
				String[] parts = restaurant.split(",");
				tableModel.addRow(parts);
			}
			table.setModel(tableModel);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(view, "Error fetching restaurants.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	class AddItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String itemName = view.getTxtItemName().getText();
			String priceText = view.getTxtPrice().getText();

			if (itemName.isEmpty() || priceText.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Item name and price are required.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {
				double price = Double.parseDouble(priceText);

				MenuItem menuItem = new MenuItem(itemName, price);

				DefaultListModel<MenuItem> listModel = (DefaultListModel<MenuItem>) view.getListModel();
				listModel.addElement(menuItem);

				view.getListMenu().setModel(listModel);

				menu.addItem(menuItem);

				view.getTxtItemName().setText("");
				view.getTxtPrice().setText("");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(view, "Price must be a valid number.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(view, "Error adding menu item.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class CreateMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (menu.getItems().isEmpty()) {
				JOptionPane.showMessageDialog(view, "No items added to the menu.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int selectedRow = view.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(view, "Please select a restaurant.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int restaurantId = Integer.parseInt(view.getTableRestaurant().getValueAt(selectedRow, 0).toString());
			List<MenuItem> menuItems = menu.getItems();

			model.saveMenuItems(restaurantId, menuItems);
			JOptionPane.showMessageDialog(view, "Menu created successfully.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			DefaultListModel<MenuItem> listModel = (DefaultListModel<MenuItem>) view.getListModel();
			listModel.clear();
			displayRestaurants();
		}
	}

	class SelectRestaurantListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getTableRestaurant().getSelectedRow();
			if (selectedRow != -1) {
				int restaurantId = Integer.parseInt(view.getTableRestaurant().getValueAt(selectedRow, 0).toString());
			} else {
				JOptionPane.showMessageDialog(view, "Please select a restaurant.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
