package deliverySystem.models.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import deliverySystem.models.admin.MenuItem;
import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.restaurateur.OrdersClass;

public class OrderModel {
	private Connection conn;

	public OrderModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliverysystem", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public void createOrder(OrdersClass order) {
		String sql = "INSERT INTO orders (client_id, restaurant_id, status, deliveryman_id, delivery_time, order_detail, delivery_postal_code, delivery_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, order.getClientId());
			statement.setInt(2, order.getRestaurantId());
			statement.setString(3, order.getStatus());
			statement.setInt(4, order.getDeliverymanId());
			statement.setString(5, order.getDeliveryTime());
			statement.setString(6, order.getOrderDetail());
			statement.setString(7, order.getPostalCode());
			statement.setString(8, order.getAddress());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Order created successfully.");
			} else {
				System.out.println("Failed to create order.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RestaurantClass> getAllRestaurants() {
		List<RestaurantClass> restaurants = new ArrayList<>();
		String sql = "SELECT * FROM restaurants WHERE id IN (SELECT DISTINCT restaurant_id FROM menus) AND status = 1";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				RestaurantClass restaurant = new RestaurantClass(id, name);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurants;
	}

	public RestaurantClass getRestaurantByName(String name) {
		String sql = "SELECT * FROM restaurants WHERE name = ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String id = resultSet.getString("id");
				return new RestaurantClass(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MenuItem> getMenuForRestaurant(RestaurantClass restaurant) {
		List<MenuItem> menuItems = new ArrayList<>();
		String sql = "SELECT * FROM menus WHERE restaurant_id = ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, restaurant.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String itemName = resultSet.getString("item");
				double price = resultSet.getDouble("price");
				menuItems.add(new MenuItem(itemName, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}

	public MenuItem getMenuItemByIndex(int index, RestaurantClass restaurant) {
		List<MenuItem> menuItems = getMenuForRestaurant(restaurant);
		if (index >= 0 && index < menuItems.size()) {
			return menuItems.get(index);
		}
		return null;
	}

	public String getClientIdByUsername(String loggedInUsername) {
		String sql = "SELECT client_id FROM clients WHERE username = ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, loggedInUsername);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("client_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<OrdersClass> getClientOrders(String loggedInUsername) {
	    List<OrdersClass> orders = new ArrayList<>();
	    String sql = "SELECT * FROM orders WHERE client_id = ?";

	    try (PreparedStatement statement = conn.prepareStatement(sql)) {
	    	int clientId = Integer.parseInt(getClientIdByUsername(loggedInUsername));
	        statement.setInt(1, clientId);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int orderId = resultSet.getInt("order_id");
	            int restaurantId = resultSet.getInt("restaurant_id");
	            String status = resultSet.getString("status");
	            int deliverymanId = resultSet.getInt("deliveryman_id");
	            String deliveryTime = resultSet.getString("delivery_time");
	            String orderDetail = resultSet.getString("order_detail");
	            String postalCode = resultSet.getString("delivery_postal_code");
	            String address = resultSet.getString("delivery_address");

	            OrdersClass order = new OrdersClass(orderId, clientId, restaurantId, status, deliverymanId, deliveryTime, orderDetail, postalCode, address);
	            orders.add(order);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return orders;
	}

}
