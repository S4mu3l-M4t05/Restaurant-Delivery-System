package deliverySystem.models.admin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantEditModel{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/deliverysystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private RestaurantClass restaurantClass;
    
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
    public void changeStatusbyID(RestaurantClass restaurantClass,String id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE restaurants SET name = ?, address = ?, phone_number = ?, OpenHourSun = ?,OpenMinSun = ?,CloseHourSun = ?,CloseMinSun = ?, OpenHourMon= ?,OpenMinMon = ?,CloseHourMon = ?,CloseMinMon = ?,OpenHourTues = ?,OpenMinTues = ?,CloseHourTues = ?,CloseMinTues = ?,OpenHourWed = ?,OpenMinWed = ?,CloseHourWed = ?,CloseMinWed = ?, OpenHourThurs = ?,OpenMinThurs = ?,CloseHourThurs = ?,CloseMinThurs = ?,OpenHourFri = ?,OpenMinFri = ?,CloseHourFri = ?,CloseMinFri = ?,OpenHourSat = ?,OpenMinSat = ?,CloseHourSat = ?,CloseMinSat = ?,delivery_area = ?, status = 0 WHERE id = " + id;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, restaurantClass.getName());
                statement.setString(2, restaurantClass.getAddress());
                statement.setString(3, restaurantClass.getPhoneNumber());
                statement.setString(4, restaurantClass.getOpenningHourSU());
                statement.setString(5, restaurantClass.getOpenningMinSU());
                statement.setString(6, restaurantClass.getClosingHourSU());
                statement.setString(7, restaurantClass.getClosingMinSU());
                statement.setString(8, restaurantClass.getOpenningHourMO());
                statement.setString(9, restaurantClass.getOpenningHourMO());
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
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        	}
        }
    
    public void updateRestaurant(RestaurantClass restaurantClass,String id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE restaurants SET name = ?, address = ?, phone_number = ?, OpenHourSun = ?,OpenMinSun = ?,CloseHourSun = ?,CloseMinSun = ?, OpenHourMon= ?,OpenMinMon = ?,CloseHourMon = ?,CloseMinMon = ?,OpenHourTues = ?,OpenMinTues = ?,CloseHourTues = ?,CloseMinTues = ?,OpenHourWed = ?,OpenMinWed = ?,CloseHourWed = ?,CloseMinWed = ?, OpenHourThurs = ?,OpenMinThurs = ?,CloseHourThurs = ?,CloseMinThurs = ?,OpenHourFri = ?,OpenMinFri = ?,CloseHourFri = ?,CloseMinFri = ?,OpenHourSat = ?,OpenMinSat = ?,CloseHourSat = ?,CloseMinSat = ?,delivery_area = ? WHERE id = " + id;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, restaurantClass.getName());
                statement.setString(2, restaurantClass.getAddress());
                statement.setString(3, restaurantClass.getPhoneNumber());
                statement.setString(4, restaurantClass.getOpenningHourSU());
                statement.setString(5, restaurantClass.getOpenningMinSU());
                statement.setString(6, restaurantClass.getClosingHourSU());
                statement.setString(7, restaurantClass.getClosingMinSU());
                statement.setString(8, restaurantClass.getOpenningHourMO());
                statement.setString(9, restaurantClass.getOpenningHourMO());
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
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getallrestaurantsandaddress() {
        List<String> resto_address = new ArrayList();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT id,name,address FROM restaurants WHERE status = 1";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                    	resto_address.add(resultSet.getString("id") +" "+ resultSet.getString("name")+" "+ resultSet.getString("address"));
                    
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resto_address;
    }

    
}
