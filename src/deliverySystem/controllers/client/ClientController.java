package deliverySystem.controllers.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import deliverySystem.controllers.LoginController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.client.ClientModel;
import deliverySystem.models.client.OrderModel;
import deliverySystem.views.LoginView;
import deliverySystem.views.client.ClientEditView;
import deliverySystem.views.client.ClientHistoryView;
import deliverySystem.views.client.ClientOrderView;
import deliverySystem.views.client.ClientView;

public class ClientController {
	private final ClientView view;
	private ClientModel model;
	private String loggedInUsername;

	public ClientController(ClientView view, ClientModel model, String loggedInUsername) {
		this.view = view;
		this.model = model;
		this.loggedInUsername = loggedInUsername;

		// Add action listeners to menu items
		view.getMntmDisconnect().addActionListener(new DisconnectMntmListener());
		view.getMntmQuit().addActionListener(new QuitMntmListener());
		view.getMntmEditAccount().addActionListener(new EditAccountMntmListener());
		view.getMntmCloseAccount().addActionListener(new CloseAccountMntmListener());
		view.getMntmOrderFood().addActionListener(new OrderFoodMntmListener());
		view.getMntmOrderHistory().addActionListener(new OrderHistoryMntmListener());
	}

	class DisconnectMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Disconnecting...");
			LoginView loginView = new LoginView();
			LoginModel loginModel = new LoginModel();
			new LoginController(loginView, loginModel);
			loginView.setVisible(true);
			view.dispose();
		}
	}

	class QuitMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class EditAccountMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientEditView clientEditView = new ClientEditView();
			ClientModel clientModel = new ClientModel();
			new ClientEditController(clientModel, clientEditView, loggedInUsername);
			clientEditView.setVisible(true);
		}
	}

	class CloseAccountMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to close your account?",
					"Confirm Account Closure", JOptionPane.YES_NO_OPTION);
			if (confirmation == JOptionPane.YES_OPTION) {
				System.out.println("Disconnecting...");
				model.deleteClient(loggedInUsername, "Closed");
				LoginView loginView = new LoginView();
				LoginModel loginModel = new LoginModel();
				new LoginController(loginView, loginModel);
				loginView.setVisible(true);
				view.dispose();
			}
		}
	}

	class OrderFoodMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientOrderView clientOrderView = new ClientOrderView();
			OrderModel orderModel = new OrderModel();
			new ClientOrderController(clientOrderView, orderModel, loggedInUsername);
			clientOrderView.setVisible(true);
		}
	}

	class OrderHistoryMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientHistoryView clientHistoryView = new ClientHistoryView();
			OrderModel orderModel = new OrderModel();
			new ClientHistoryController(clientHistoryView, orderModel, loggedInUsername);
			clientHistoryView.setVisible(true);
		}
	}
}
