package deliverySystem.models.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuModel {
	private Connection conn;

	public MenuModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliverysystem", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public List<String> getAllRestaurants() {
		List<String> restaurantDetails = new ArrayList<>();
		String sql = "SELECT id, name FROM restaurants WHERE id IN (SELECT DISTINCT restaurant_id FROM menus)";

		try (PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String restaurantDetail = id + ", " + name;
				restaurantDetails.add(restaurantDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error fetching restaurant details", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return restaurantDetails;
	}

	public List<String> getRestaurantsWithNoMenu() {
		List<String> restaurantDetails = new ArrayList<>();
		String sql = "SELECT id, name FROM restaurants " + "WHERE id NOT IN (SELECT DISTINCT restaurant_id FROM menus)";

		try (PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String restaurantDetail = id + ", " + name;
				restaurantDetails.add(restaurantDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error fetching restaurant details", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return restaurantDetails;
	}

	public List<String> getMenuItemsForRestaurant(int restaurantId) {
		List<String> menuItems = new ArrayList<>();
		String sql = "SELECT item, price FROM menus WHERE restaurant_id = ?";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, restaurantId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String itemName = resultSet.getString("item");
				double price = resultSet.getDouble("price");
				String menuItem = itemName + " - $" + price;
				menuItems.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error fetching menu items.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return menuItems;
	}

	public void saveMenuItems(int restaurantId, List<MenuItem> menuItems) {
		String sql = "INSERT INTO menus (restaurant_id, item, price) VALUES (?, ?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			for (MenuItem menuItem : menuItems) {
				statement.setInt(1, restaurantId);
				statement.setString(2, menuItem.getItemName());
				statement.setDouble(3, menuItem.getPrice());
				statement.addBatch();
			}
			statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMenuItem(int restaurantId, String selectedItem, String newItemName, double newPrice) {
		String sql = "UPDATE menus SET item = ?, price = ? WHERE restaurant_id = ? AND item = ?";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, newItemName);
			statement.setDouble(2, newPrice);
			statement.setInt(3, restaurantId);
			statement.setString(4, selectedItem);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
