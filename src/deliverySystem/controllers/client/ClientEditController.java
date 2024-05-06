package deliverySystem.controllers.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import deliverySystem.models.client.Client;
import deliverySystem.models.client.ClientModel;
import deliverySystem.views.client.ClientEditView;

public class ClientEditController {
	private ClientModel model;
	private ClientEditView view;
	private boolean isUsernameAvailable = false;
	private String loggedInUsername;

	public ClientEditController(ClientModel model, ClientEditView view, String loggedInUsername) {
		this.model = model;
		this.view = view;
		this.loggedInUsername = loggedInUsername;

		view.getBtnSave().addActionListener(new SaveBtnListener());
		view.getBtnVerify().addActionListener(new VerifyBtnListener());

		displayCurrentClientInfo();
	}

	private void displayCurrentClientInfo() {
		try {
			Client client = model.getClientByUsername(loggedInUsername);
			if (client != null) {
				view.getTxtUsername().setText(client.getUsername());
				// view.getTxtOldPassword().setText(client.getPassword());
				view.getTxtLastName().setText(client.getLastName());
				view.getTxtFirstName().setText(client.getFirstName());
				view.getTxtAddress().setText(client.getAddress());
				view.getTxtEmail().setText(client.getEmail());
				String phoneNumber = client.getPhoneNumber();
				if (phoneNumber != null && phoneNumber.length() == 10) {
					view.getTxtAreaCode().setText(phoneNumber.substring(0, 3));
					view.getTxtPhonePrefix().setText(phoneNumber.substring(3, 6));
					view.getTxtLineNumber().setText(phoneNumber.substring(6));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(view, "Error fetching client information.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	class SaveBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getTxtUsername().getText();
			String oldPassword = view.getTxtOldPassword().getText();
			String newPassword = view.getTxtNewPassword().getText();
			String confirmPassword = view.getTxtConfirmPassword().getText();
			String lastName = view.getTxtLastName().getText();
			String firstName = view.getTxtFirstName().getText();
			String address = view.getTxtAddress().getText();
			String email = view.getTxtEmail().getText();
			String areaCode = view.getTxtAreaCode().getText();
			String phonePrefix = view.getTxtPhonePrefix().getText();
			String lineNumber = view.getTxtLineNumber().getText();
			String phoneNumber = areaCode + phonePrefix + lineNumber;

			if (username.isEmpty() || newPassword.isEmpty() || lastName.isEmpty() || firstName.isEmpty()
					|| address.isEmpty() || email.isEmpty() || areaCode.isEmpty() || phonePrefix.isEmpty()
					|| lineNumber.isEmpty()) {
				JOptionPane.showMessageDialog(view, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!isUsernameAvailable) {
				JOptionPane.showMessageDialog(view, "Please verify the username first.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (!username.equals(VerifyBtnListener.username)) {
				return;
			}

			if (newPassword.length() < 8) {
				JOptionPane.showMessageDialog(view, "Password must be at least 8 characters long.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
				JOptionPane.showMessageDialog(view, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!areaCode.matches("\\d{3}") && !phonePrefix.matches("\\d{3}") && !lineNumber.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(view, "Invalid phone number format.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!newPassword.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(view, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String message = "Username: " + username + "\n" + "Password: " + newPassword + "\n" + "Last Name: "
					+ lastName + "\n" + "First Name: " + firstName + "\n" + "Address: " + address + "\n" + "Email: "
					+ email + "\n" + "Phone Number: " + phoneNumber + "\n\n"
					+ "Are you sure you want to save this information?";

			int confirmation = JOptionPane.showConfirmDialog(view, message, "Confirm Information",
					JOptionPane.YES_NO_OPTION);
			if (confirmation == JOptionPane.YES_OPTION) {
				Client client = new Client(username, newPassword, lastName, firstName, address, email, phoneNumber);
				model.updateClient(client, loggedInUsername);
			}
		}
	}

	class VerifyBtnListener implements ActionListener {
		public static String username;

		@Override
		public void actionPerformed(ActionEvent e) {
			username = view.getTxtUsername().getText();
			if (model.isUsernameUnique(username, loggedInUsername)) {
				isUsernameAvailable = true;
				JOptionPane.showMessageDialog(view, "Username is available.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				isUsernameAvailable = false;
				JOptionPane.showMessageDialog(view, "Username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
