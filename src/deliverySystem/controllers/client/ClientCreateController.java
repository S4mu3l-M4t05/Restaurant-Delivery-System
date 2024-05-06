package deliverySystem.controllers.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import deliverySystem.models.client.Client;
import deliverySystem.models.client.ClientModel;
import deliverySystem.views.client.ClientCreateView;

public class ClientCreateController {
	private ClientCreateView view;
	private ClientModel model;
	private boolean isUsernameAvailable = false;

	public ClientCreateController(ClientCreateView view, ClientModel model) {
		this.view = view;
		this.model = model;

		view.getBtnSave().addActionListener(new SaveBtnListener());
		view.getBtnVerify().addActionListener(new VerifyBtnListener());
	}

	class SaveBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getTxtUsername().getText();
			String password = view.getTxtPassword().getText();
			String confirmedPassword = view.getTxtConfirmPassword().getText();
			String lastName = view.getTxtLastName().getText();
			String firstName = view.getTxtFirstName().getText();
			String address = view.getTxtAddress().getText();
			String email = view.getTxtEmail().getText();
			String areaCode = view.getTxtAreaCode().getText();
			String phonePrefix = view.getTxtPhonePrefix().getText();
			String lineNumber = view.getTxtLineNumber().getText();

			// Validate the input fields
			if (username.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty()
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

			if (password.length() < 8) {
				JOptionPane.showMessageDialog(view, "Password must be at least 8 characters long.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!password.equals(confirmedPassword)) {
				JOptionPane.showMessageDialog(view, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
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
			String phoneNumber = areaCode + phonePrefix + lineNumber;
			String message = "Username: " + username + "\n" + "Password: " + password + "\n" + "Last Name: " + lastName
					+ "\n" + "First Name: " + firstName + "\n" + "Address: " + address + "\n" + "Email: " + email + "\n"
					+ "Phone Number: " + phoneNumber + "\n\n" + "Are you sure you want to save this information?";

			// Show confirmation dialog
			int confirmation = JOptionPane.showConfirmDialog(view, message, "Confirm Information",
					JOptionPane.YES_NO_OPTION);
			if (confirmation == JOptionPane.YES_OPTION) {

				Client client = new Client(username, password, lastName, firstName, address, email, phoneNumber);
				model.createClient(client);
			}

		}
	}

	class VerifyBtnListener implements ActionListener {
		public static String username;

		@Override
		public void actionPerformed(ActionEvent e) {
			username = view.getTxtUsername().getText();
			if (model.isUsernameUnique(username, null)) {
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
