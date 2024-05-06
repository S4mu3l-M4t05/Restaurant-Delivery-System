package deliverySystem.models.restaurateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurateurModel {
    private Connection connection;
    private String url = "jdbc:mysql://localhost/deliverysystem";
    private String username = "root";
    private String password = "";
    private Integer restaurantID=0;
    public RestaurateurModel() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setResturantID(Integer id) {
    	this.restaurantID=id;
    }
    public Integer getResturantID() {
    	return this.restaurantID;
    }

    public OrdersClass selectOrder(int orderId) {
        OrdersClass order = null;
        String query = "SELECT * FROM orders WHERE order_id = ? AND restaurant_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            statement.setInt(2, this.restaurantID); // Add the restaurant ID condition
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	int clientId = resultSet.getInt("client_Id");
                int restaurantId = resultSet.getInt("restaurant_Id");
                String status = resultSet.getString("status");
                String postalCode = resultSet.getString("delivery_postal_code");
                int deliverymanId = resultSet.getInt("deliveryman_Id");
                String deliveryTime = resultSet.getString("delivery_Time");
                String orderDetail = resultSet.getString("order_Detail");
                String address = resultSet.getString("delivery_address");
                order = new OrdersClass(orderId, clientId, restaurantId, status, deliverymanId, deliveryTime, orderDetail,postalCode,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    // Method to select an order by order ID
//    public OrdersClass selectOrder(int orderId) {
//        OrdersClass order = null;
//        String query = "SELECT * FROM orders WHERE order_id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, orderId);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//            	int clientId = resultSet.getInt("client_Id");
//                int restaurantId = resultSet.getInt("restaurant_Id");
//                String status = resultSet.getString("status");
//                String postalCode = resultSet.getString("delivery_postal_code");
//                int deliverymanId = resultSet.getInt("deliveryman_Id");
//                String deliveryTime = resultSet.getString("delivery_Time");
//                String orderDetail = resultSet.getString("order_Detail");
//                String address = resultSet.getString("delivery_address");
//                order = new OrdersClass(orderId, clientId, restaurantId, status, deliverymanId, deliveryTime, orderDetail,postalCode,address);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return order;
//    }

//    public List<Integer> getClientIdsFromOrders() {
//        List<Integer> clientIds = new ArrayList();
//        String query = "SELECT client_id FROM orders where status='Pending'";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int clientId = resultSet.getInt("client_id");
//                clientIds.add(clientId);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clientIds;
//    }
    public List<Integer> getClientIdsFromOrders() {
        List<Integer> clientIds = new ArrayList();
        String query = "SELECT client_id FROM orders WHERE status='Pending' AND restaurant_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, this.restaurantID); // Add the restaurant ID condition
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

    public List<Integer> getClientIdsFromAcceptedOrders() {
        List<Integer> clientIds = new ArrayList();
        String query = "SELECT client_id FROM orders where status='Accepted'";
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
        String query = "SELECT DISTINCT order_id FROM orders where status='Pending'";
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
    public List<Integer> getAcceptedOrdersIDFromOrders() {
        List<Integer> orderIds = new ArrayList();
        String query = "SELECT DISTINCT order_id FROM orders where status='Accepted'";
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

