package deliverySystem.models.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.restaurateur.OrdersClass;



public class viewRestaurantOrderModel {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/deliverysystem";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	private RestaurantClass restaurantClass;
	private managerClass managerClass;
	private OrdersClass ordersClass;
	
	   public managerClass findManagerbyId(String username) {
		   managerClass manager = null;
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	            String query = "SELECT * FROM managers WHERE username = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, username);
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                    	manager = new managerClass(
	                    			resultSet.getString("manager_id"),
	                             	resultSet.getString("username"),
	                            	resultSet.getString("password"),
	                            	resultSet.getString("restaurant_id"),
	                            	resultSet.getString("status")
	         
	                        );
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return manager;
	    }
	   
	   public RestaurantClass findRestaurantbyId(String id) {
	    	RestaurantClass restaurant = null;
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	            String query = "SELECT * FROM restaurants WHERE id = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, id);
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                    	restaurant = new RestaurantClass(
	                    			resultSet.getString("id"),
	                             	resultSet.getString("name"),
	                            	resultSet.getString("address"),
	                            	resultSet.getString("phone_number"),
	                            	resultSet.getString("OpenHourSun"),
	                            	resultSet.getString("OpenMinSun"),
	                            	resultSet.getString("CloseHourSun"),
	                            	resultSet.getString("CloseMinSun"),
	                            	resultSet.getString("OpenHourMon"),
	                            	resultSet.getString("OpenMinMon"),
	                            	resultSet.getString("CloseHourMon"),
	                            	resultSet.getString("CloseMinMon"),
	                            	resultSet.getString("OpenHourTues"),
	                            	resultSet.getString("OpenMinTues"),
	                            	resultSet.getString("CloseHourTues"),
	                            	resultSet.getString("CloseMinTues"),
	                            	resultSet.getString("OpenHourWed"),
	                            	resultSet.getString("OpenMinWed"),
	                            	resultSet.getString("CloseHourWed"),
	                            	resultSet.getString("CloseMinWed"),
	                            	resultSet.getString("OpenHourThurs"),
	                            	resultSet.getString("OpenMinThurs"),
	                            	resultSet.getString("CloseHourThurs"),
	                            	resultSet.getString("CloseMinThurs"),
	                            	resultSet.getString("OpenHourFri"),
	                            	resultSet.getString("OpenMinFri"),
	                            	resultSet.getString("CloseHourFri"),
	                            	resultSet.getString("CloseMinFri"),
	                            	resultSet.getString("OpenHourSat"),
	                            	resultSet.getString("OpenMinSat"),
	                            	resultSet.getString("CloseHourSat"),
	                            	resultSet.getString("CloseMinSat"),
	                            	resultSet.getString("delivery_area"),
	                            	resultSet.getString("status"),
	                            	resultSet.getString("manager_id")
	                        );
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return restaurant;
	    }
	    public List<String> getrestaurant(String manager_id) {
	        List<String> resto_address = new ArrayList();
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	            String query = "SELECT name FROM restaurants WHERE manager_id = " + manager_id;
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                    	resto_address.add(resultSet.getString("name"));
	                    
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return resto_address;
	    }
	    public List<String> getrestaurantOrder(String restaurant_id) {
	        List<String> resto_order= new ArrayList();
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	            String query = "SELECT order_id,delivery_time FROM orders WHERE restaurant_id = " + restaurant_id;
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                    	resto_order.add(resultSet.getString("order_id") +" "+ resultSet.getString("delivery_time"));
	                    
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return resto_order;
	    }
	    public OrdersClass findorderbyId(String id) {
	    	OrdersClass order = null;
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	            String query = "SELECT * FROM orders WHERE order_id = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, id);
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                    	order = new OrdersClass(
	                    			resultSet.getInt("order_id"),
	                             	resultSet.getInt("client_id"),
	                            	resultSet.getInt("restaurant_id"),
	                            	resultSet.getString("status"),
	                            	resultSet.getInt("deliveryman_id"),
	                            	resultSet.getString("delivery_time"),
	                            	resultSet.getString("order_detail"),
	                            	resultSet.getString("delivery_address"),
	                            	resultSet.getString("delivery_postal_code")
	                    			);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }
	    
	
}
