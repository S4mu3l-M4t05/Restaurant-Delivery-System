package deliverySystem.models.restaurateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurateurViewModel {
	 private Connection connection;
	    private String url = "jdbc:mysql://localhost/deliverysystem";
	    private String username = "root";
	    private String password = "";
	    private Integer restaurantID=0;
	    public RestaurateurViewModel() {
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
	    
	    public Integer selectRestaurantIdByUsername(String username) {
	        Integer restaurantId = null;
	        String query = "SELECT restaurant_id FROM restaurateur WHERE username = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, username);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                restaurantId = resultSet.getInt("restaurant_id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return restaurantId;
	    }

}
