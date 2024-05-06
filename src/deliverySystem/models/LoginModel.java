package deliverySystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginModel {
	private Connection conn;

	public LoginModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliverysystem", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public String login(String username, String password) {
	    String role = null;

	    try {
	        String query = "SELECT role FROM (\r\n"
	                + "    SELECT 'Admin' AS role FROM admins WHERE username = ? AND password = ? AND status = 'Active'\r\n"
	                + "    UNION ALL\r\n"
	                + "    SELECT 'Client' AS role FROM clients WHERE username = ? AND password = ? AND account_status = 'Active'\r\n"
	                + "    UNION ALL\r\n"
	                + "    SELECT 'Delivery Man' AS role FROM deliverymen WHERE username = ? AND password = ? AND status = 1\r\n"
	                + "    UNION ALL\r\n"
	                + "    SELECT 'Manager' AS role FROM managers WHERE username = ? AND password = ? AND status = 1\r\n"
	                + "    UNION ALL\r\n"
	                + "    SELECT 'Restaurateur' AS role FROM restaurateur WHERE username = ? AND password = ?\n"
	                + ") AS roles LIMIT 1;";
	        PreparedStatement statement = conn.prepareStatement(query);
	        for (int i = 1; i <= 9; i++) {
	            statement.setString(i, username);
	            statement.setString(++i, password);
	        }

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            role = resultSet.getString("role");
	        }

	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return role;
	}

}