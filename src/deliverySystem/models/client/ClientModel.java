package deliverySystem.models.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ClientModel {
	private Connection conn;

	public ClientModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliverysystem", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Failed to connect", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public void createClient(Client client) {
		String sql = "INSERT INTO clients (username, password, last_name, first_name, address, email, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, client.getUsername());
			statement.setString(2, client.getPassword());
			statement.setString(3, client.getLastName());
			statement.setString(4, client.getFirstName());
			statement.setString(5, client.getAddress());
			statement.setString(6, client.getEmail());
			statement.setString(7, client.getPhoneNumber());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Client account created successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Client not added to database", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateClient(Client client, String loggedInUsername) {
		String sql = "UPDATE clients SET username=?, password=?, last_name=?, first_name=?, address=?, email=?, phone_number=? WHERE username=?";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, client.getUsername());
			statement.setString(2, client.getPassword());
			statement.setString(3, client.getLastName());
			statement.setString(4, client.getFirstName());
			statement.setString(5, client.getAddress());
			statement.setString(6, client.getEmail());
			statement.setString(7, client.getPhoneNumber());
			statement.setString(8, loggedInUsername);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Client account updated successfully.");
			} else {
				System.out.println("No client account found with the specified username.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed to update client account", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteClient(String username, String newStatus) {
		String sql = "UPDATE clients SET account_status = ? WHERE username = ?";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, newStatus);
			statement.setString(2, username);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Client account deleted successfully.");
			} else {
				System.out.println("No client account found with the specified username.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed to delete client account", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean isUsernameUnique(String username, String currentUsername) {
		String sql = "SELECT COUNT(*) AS count FROM clients WHERE username = ? AND username <> ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, currentUsername);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt("count");
					return count == 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Client getClientByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM clients WHERE username=?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					String password = resultSet.getString("password");
					String lastName = resultSet.getString("last_name");
					String firstName = resultSet.getString("first_name");
					String address = resultSet.getString("address");
					String email = resultSet.getString("email");
					String phoneNumber = resultSet.getString("phone_number");
					return new Client(username, password, lastName, firstName, address, email, phoneNumber);
				}
			}
		}
		return null;
	}
}
