package deliverySystem.models.deliveryman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import deliverySystem.models.restaurateur.OrdersClass;

public class EndDeliveriesModel {
	
	 private Connection connection;
	    private String url = "jdbc:mysql://localhost/deliverysystem";
	    private String username = "root";
	    private String password = "";
	    private String DeliveryManUserName = "";
	   public EndDeliveriesModel() {
	        try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	   public void setDMUserName(String username) {
			DeliveryManUserName=username;
		}
		public String getDMUserName() {
			return DeliveryManUserName;
		}
		
		public OrdersClass selectOrder(String clientUsername) {
		    OrdersClass order = null;
		    int clientId = getClientIdByUsername(clientUsername);
		    if (clientId != -1) { // Ensure clientId is valid
		        String query = "SELECT * FROM orders WHERE client_id = ?";
		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		            statement.setInt(1, clientId);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                int orderId = resultSet.getInt("order_id");
		                int restaurantId = resultSet.getInt("restaurant_id");
		                String status = resultSet.getString("status");
		                String postalCode = resultSet.getString("delivery_postal_code");
		                int deliverymanId = resultSet.getInt("deliveryman_id");
		                String deliveryTime = resultSet.getString("delivery_time");
		                String orderDetail = resultSet.getString("order_detail");
		                String address = resultSet.getString("delivery_address");
		                order = new OrdersClass(orderId, clientId, restaurantId, status, deliverymanId, deliveryTime, orderDetail, postalCode, address);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return order;
		}

		// Method to fetch clientId from client table based on username
		private int getClientIdByUsername(String username) {
		    int clientId = -1; // Default value if client is not found
		    String query = "SELECT client_id FROM clients WHERE username = ?";
		    try (PreparedStatement statement = connection.prepareStatement(query)) {
		        statement.setString(1, username);
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		            clientId = resultSet.getInt("client_id");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return clientId;
		}

    public List<Integer> getClientIdsFromOrders() {
        List<Integer> clientIds = new ArrayList<>();
        String deliveryManUsername = this.DeliveryManUserName;
        
        // Retrieve delivery areas of the deliveryman
        String deliveryAreas = getDeliveryAreas(deliveryManUsername);
        System.out.println(deliveryAreas);
        // If delivery areas are retrieved successfully
        if (deliveryAreas != null && !deliveryAreas.isEmpty()) {
            String[] deliveryAreaArray = deliveryAreas.split(",");
            for (String area : deliveryAreaArray) {
                // Query orders based on each delivery area
                String query = "SELECT client_id FROM orders WHERE status='En Route' AND delivery_postal_code=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, area.trim());
                 
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                    	
                        int clientId = resultSet.getInt("client_id");
                        System.out.println(clientId);
                        clientIds.add(clientId);
                    }
                  
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to retrieve delivery areas for deliveryman: " + deliveryManUsername);
        }
        return clientIds;
    }

    // Retrieve delivery areas of the deliveryman
    private String getDeliveryAreas(String deliveryManUsername) {
        StringBuilder deliveryAreas = new StringBuilder();
        String query = "SELECT delivery_area FROM deliverymen WHERE username=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, deliveryManUsername);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String area = resultSet.getString("delivery_area");
                deliveryAreas.append(area).append(",");
            }
            if (deliveryAreas.length() > 0) {
                // Remove the trailing comma
                deliveryAreas.deleteCharAt(deliveryAreas.length() - 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryAreas.toString();
    }
    public List<Integer> getClientIdsFromOrder() {
    	String deliveryManUsername=this.DeliveryManUserName;
        List<Integer> clientIds = new ArrayList();
        String query = "SELECT client_id FROM orders where status='En Route'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                clientIds.add(clientId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientIds;
    }
    public List<Integer> getClientIdsFromReadyOrders() {
        List<Integer> clientIds = new ArrayList();
        String query = "SELECT client_id FROM orders where status='En Route'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                clientIds.add(clientId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientIds;
    }
    public List<Integer> getOrdersIDFromOrders() {
        List<Integer> orderIds = new ArrayList();
        String query = "SELECT DISTINCT order_id FROM orders where status='En Route'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int orderID = resultSet.getInt("order_id");
                orderIds.add(orderID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderIds;
    }
    public List<Integer> getReadyOrdersIDFromOrders() {
        List<Integer> orderIds = new ArrayList();
        String query = "SELECT DISTINCT order_id FROM orders where status='En Route'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int orderID = resultSet.getInt("order_id");
                orderIds.add(orderID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderIds;
    }
    
    public String getClientPostalCode(int orderId) {
        String postalCode = null;
        String query = "SELECT c.postal_code " +
                       "FROM clients c " +
                       "INNER JOIN orders o ON c.client_id = o.client_id " +
                       "WHERE o.order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                postalCode = resultSet.getString("postal_code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postalCode;
    }
    // Method to get the client's name based on client ID
    public String getClientName(int clientId) {
        String clientName = null;
        String query = "SELECT username FROM clients WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                clientName = resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientName;
    }

  
    // Method to update the status of an order
    public void updateOrderStatus(int orderId, String newStatus) {
        String query = "UPDATE orders SET status = ? WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStatus);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDeliveryManID(int orderId, String newDeliveryManUserName) {
    	Integer DeliveryManId = getDeliveryManIdByUserName(newDeliveryManUserName);
        String query = "UPDATE orders SET deliveryman_id = ? WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, DeliveryManId);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Integer getDeliveryManIdByUserName(String newDeliveryManUserName) {
        String query = "select deliveryman_id from deliverymen WHERE username=? ";
        Integer id =0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newDeliveryManUserName);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("deliveryman_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public  String extractDate(String originalString) {
        String[] parts = originalString.split(" ");
        return parts[0];
    }

    
    public  String extractHour(String originalString) {
        String[] parts = originalString.split(" ");
        String timeString = parts[1];
        String[] timeParts = timeString.split(":");
        return timeParts[0];
    }

    
    public  String extractMinute(String originalString) {
        String[] parts = originalString.split(" ");
        String timeString = parts[1];
        String[] timeParts = timeString.split(":");
        return timeParts[1];
    }
}