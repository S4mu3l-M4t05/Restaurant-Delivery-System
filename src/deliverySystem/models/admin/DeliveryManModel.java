package deliverySystem.models.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import deliverySystem.models.deliveryman.DeliveryManClass;

public class DeliveryManModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/deliverysystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private DeliveryManClass deliverymanClass;

    public DeliveryManModel() {
        this.deliverymanClass = new DeliveryManClass("", "", "", "", "", ""); // Initialize with default values or provide your own logic
    }

    public void setDeliveryMan(DeliveryManClass deliverymanClass) {
        this.deliverymanClass = deliverymanClass;
    }

    public void addDeliveryMan(DeliveryManClass deliverymanClass) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO deliverymen (username, password, name, phone_number, delivery_area, status) VALUES (?, ?, ?, ?, ?, 1)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, deliverymanClass.getUsername());
                statement.setString(2, deliverymanClass.getPassword());
                statement.setString(3, deliverymanClass.getName());
                statement.setString(4, deliverymanClass.getPhoneNumber());
                statement.setString(5, deliverymanClass.getDeliveryArea());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryMan(DeliveryManClass deliverymanClass) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE deliverymen SET name = ?, phone_number = ?, delivery_area = ? WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, deliverymanClass.getName());
                statement.setString(2, deliverymanClass.getPhoneNumber());
                statement.setString(3, deliverymanClass.getDeliveryArea());
                statement.setString(4, deliverymanClass.getUsername());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeliveryMan() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE deliveryman SET status = 0 WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, deliverymanClass.getUsername());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT username FROM deliverymen";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        usernames.add(resultSet.getString("username"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usernames;
    }
    public DeliveryManClass findDeliveryByUsername(String username) {
        DeliveryManClass deliveryman = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM deliverymen WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        deliveryman = new DeliveryManClass(
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("name"),
                                resultSet.getString("phone_number"),
                                resultSet.getString("delivery_area"),
                                resultSet.getString("status")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryman;
    }

    public void changeStatusByUsername(DeliveryManClass deliveryMan) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE deliverymen SET status = ? WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, deliveryMan.getStatus());
                statement.setString(2, deliveryMan.getUsername());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean usernameExistsInAnyTable(String username) {
        if (usernameExistsInTable(username, "admins") || usernameExistsInTable(username, "clients") || usernameExistsInTable(username, "deliverymen")) {
            return true;
        }
        return false;
    }

    private boolean usernameExistsInTable(String username, String tableName) {
        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;    
    }
}
