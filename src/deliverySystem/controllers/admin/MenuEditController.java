package deliverySystem.controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import deliverySystem.models.admin.MenuModel;
import deliverySystem.views.admin.MenuEditView;

public class MenuEditController {
	private MenuModel model;
	private MenuEditView view;
	private int restaurantId;

	public MenuEditController(MenuModel model, MenuEditView view) {
		this.model = model;
		this.view = view;

		view.getBtnAddItem().addActionListener(new SaveChangesListener());
		view.getBtnSelect().addActionListener(new SelectBtnListener());
		view.getListMenu().addListSelectionListener(new ListMenuListener());

		displayRestaurants();
	}

	private class SaveChangesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getTableRestaurants().getSelectedRow();
			if (selectedRow != -1) {
				int selectedMenuItemIndex = view.getListMenu().getSelectedIndex();
				if (selectedMenuItemIndex != -1) {
					String selectedItem = view.getListMenu().getSelectedValue().toString();
					String[] parts = selectedItem.split(" - \\$");
					String itemName = parts[0];
					double price = Double.parseDouble(parts[1]);

					String newItemName = view.getTxtItemName().getText().trim();
					String priceText = view.getTxtPrice().getText().trim();

					if (newItemName.isEmpty() || priceText.isEmpty()) {
						JOptionPane.showMessageDialog(view, "Item name and price are required.", "Error",
								JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(view, "Price must be a valid number.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					model.updateMenuItem(restaurantId, itemName, newItemName, newPrice);

					List<String> menuItems = model.getMenuItemsForRestaurant(restaurantId);
					displayMenuItems(menuItems);

					JOptionPane.showMessageDialog(view, "Menu item updated successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(view, "Please select a menu item to edit.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(view, "Please select a restaurant.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class SelectBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getTableRestaurants().getSelectedRow();
			if (selectedRow != -1) {
				restaurantId = Integer.parseInt(view.getTableRestaurants().getValueAt(selectedRow, 0).toString());

				List<String> menuItems = model.getMenuItemsForRestaurant(restaurantId);

				displayMenuItems(menuItems);
			} else {
				JOptionPane.showMessageDialog(view, "Please select a restaurant.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class ListMenuListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				String selectedItem = (String) view.getListMenu().getSelectedValue();
				if (selectedItem != null) {
					String[] parts = selectedItem.split(" - \\$");
					String itemName = parts[0];
					double price = Double.parseDouble(parts[1]);

					view.getTxtItemName().setText(itemName);
					view.getTxtPrice().setText(String.valueOf(price));
				}
			}
		}
	}

	private void displayRestaurants() {
		try {
			List<String> restaurants = model.getAllRestaurants();

			JTable table = view.getTableRestaurants();
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

	public void displayMenuItems(List<String> menuItems) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String menuItem : menuItems) {
			listModel.addElement(menuItem);
		}
		view.getListMenu().setModel(listModel);
	}
}
