package deliverySystem.models.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;






public class RestaurantModel {
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/deliverysystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private RestaurantClass restaurantClass;

	
    public void addRestaurant(RestaurantClass restaurantClass) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO restaurants(id,name,address,phone_number,OpenHourSun,OpenMinSun,CloseHourSun,CloseMinSun,OpenHourMon,OpenMinMon,CloseHourMon,CloseMinMon,OpenHourTues,OpenMinTues,CloseHourTues,CloseMinTues,OpenHourWed,OpenMinWed,CloseHourWed,CloseMinWed,OpenHourThurs,OpenMinThurs,CloseHourThurs,CloseMinThurs,OpenHourFri,OpenMinFri,CloseHourFri,CloseMinFri,OpenHourSat,OpenMinSat,CloseHourSat,CloseMinSat,delivery_area,status)VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, restaurantClass.getName());
                statement.setString(2, restaurantClass.getAddress());
                statement.setString(3, restaurantClass.getPhoneNumber());
                
                statement.setString(4, restaurantClass.getOpenningHourSU());
                statement.setString(5, restaurantClass.getOpenningMinSU());
                statement.setString(6, restaurantClass.getClosingHourSU());
                statement.setString(7, restaurantClass.getClosingMinSU());
                
                statement.setString(8, restaurantClass.getOpenningHourMO());
                statement.setString(9, restaurantClass.getOpenningMinMO());
                statement.setString(10, restaurantClass.getClosingHourMO());
                statement.setString(11, restaurantClass.getClosingMinMO());
                
                statement.setString(12, restaurantClass.getOpenningHourTU());
                statement.setString(13, restaurantClass.getOpenningMinTU());
                statement.setString(14, restaurantClass.getClosingHourTU());
                statement.setString(15, restaurantClass.getClosingMinTU());
                
                statement.setString(16, restaurantClass.getOpenningHourWE());
                statement.setString(17, restaurantClass.getOpenningMinWE());
                statement.setString(18, restaurantClass.getClosingHourWE());
                statement.setString(19, restaurantClass.getClosingMinWE());
                
                statement.setString(20, restaurantClass.getOpenningHourTH());
                statement.setString(21, restaurantClass.getOpenningMinTH());
                statement.setString(22, restaurantClass.getClosingHourTH());
                statement.setString(23, restaurantClass.getClosingMinTH());
                
                statement.setString(24, restaurantClass.getOpenningHourFR());
                statement.setString(25, restaurantClass.getOpenningMinFR());
                statement.setString(26, restaurantClass.getClosingHourFR());
                statement.setString(27, restaurantClass.getClosingMinFR());
                
                statement.setString(28, restaurantClass.getOpenningHourSA());
                statement.setString(29, restaurantClass.getOpenningMinSA());
                statement.setString(30, restaurantClass.getClosingHourSA());
                statement.setString(31, restaurantClass.getClosingMinSA());
                
                statement.setString(32, restaurantClass.getDeliveryArea());
                statement.executeUpdate();
                
            	JOptionPane.showMessageDialog(null,"Data Was added Successfully.");
            	statement.close();
            }
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Phone number or address already exist with another restaurant", "Error", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
        }
    }
    public boolean checkUsernameExists(String usernameToCheck) {     
    	boolean usernameExists = false;         
    	try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {   
    		String query = "SELECT username FROM restaurateur WHERE username = ?";            
    		try (PreparedStatement statement = connection.prepareStatement(query)) {                
    			statement.setString(1, usernameToCheck);                 
    			ResultSet resultSet = statement.executeQuery();                
    			if (resultSet.next()) {                     
    				usernameExists = true;                 
    				}             
    			}         
    		} catch (SQLException e) {  
    			JOptionPane.showMessageDialog(null, "An error occurred while checking username existence", "Error", JOptionPane.ERROR_MESSAGE);             e.printStackTrace();   
    			}         
    	return usernameExists;    
    	}
    public static void addRestaurateur(String restaurantId, String username, String password) {
 	   String query = "INSERT INTO restaurateur(restaurant_id,username,password)VALUES(?,?,?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1, restaurantId);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
           System.out.println("Restaurateur added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String findRestaurantById(String phoneNumber) {
        String id = ""; 
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT id FROM restaurants WHERE phone_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, phoneNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        id = resultSet.getString("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id; 
    }
}
