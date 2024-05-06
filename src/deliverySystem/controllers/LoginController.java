package deliverySystem.controllers;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JOptionPane;
 
import deliverySystem.controllers.admin.AdminController;
import deliverySystem.controllers.client.ClientController;
import deliverySystem.controllers.client.ClientCreateController;
import deliverySystem.controllers.deliveryman.DeliveryManController;
import deliverySystem.controllers.manager.managerFileController;
import deliverySystem.controllers.restaurateur.RestaurateurController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.client.ClientModel;
import deliverySystem.models.deliveryman.DeliveryManPageModel;
import deliverySystem.models.manager.managerFilemodel;
import deliverySystem.models.restaurateur.RestaurateurViewModel;
import deliverySystem.views.LoginView;
import deliverySystem.views.admin.AdminView;
import deliverySystem.views.client.ClientCreateView;
import deliverySystem.views.client.ClientView;
import deliverySystem.views.deliveryman.DeliveryManView;
import deliverySystem.views.manager.managerFileMenu;
import deliverySystem.views.restaurateur.RestaurateurView;
 
public class LoginController {
	private LoginView view;
	private LoginModel model;
 
	public LoginController(LoginView view, LoginModel model) {
		this.view = view;
		this.model = model;
 
		view.getBtnConnect().addActionListener(new ConnectBtnListener());
		view.getBtnQuit().addActionListener(new QuitBtnListener());
		view.getBtnNewClients().addActionListener(new NewClientsBtnListener());
	}
 
	class ConnectBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getTxtUsername().getText();
			String password = new String(view.getTxtPassword().getPassword());
 
			if (validateInputs(username, password)) {
				String role = model.login(username, password);
				if (role != null) {
					redirectToRoleView(role, username);
				} else {
					JOptionPane.showMessageDialog(view, "Incorrect username or password.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
 
		private boolean validateInputs(String username, String password) {
			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Username and password are required.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
	}
 
	class QuitBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
 
	class NewClientsBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientCreateView clientCreateView = new ClientCreateView();
			ClientModel clientModel = new ClientModel();
			new ClientCreateController(clientCreateView, clientModel);
			clientCreateView.setVisible(true);
		}
	}
 
	public static void main(String[] args) {
		LoginView view = new LoginView();
		LoginModel model = new LoginModel();
		new LoginController(view, model);
		view.setVisible(true);
	}
 
	public void redirectToRoleView(String role, String username) {
		if (role != null) {
			switch (role) {
			case "Admin":
				AdminView adminView = new AdminView();
				new AdminController(adminView);
				adminView.setVisible(true);
				break;
			case "Client":
				ClientView clientView = new ClientView();
				ClientModel clientModel = new ClientModel();
				new ClientController(clientView, clientModel, username);
				clientView.setVisible(true);
				break;
			case "Delivery Man":
				DeliveryManView deliveryManView = new DeliveryManView();
				DeliveryManPageModel deliveryManModel = new DeliveryManPageModel();
				deliveryManModel.setDMUserName(username);
				new DeliveryManController(deliveryManView, deliveryManModel);
				deliveryManView.setVisible(true);
				
				break;
			case "Manager":
				managerFileMenu managerView = new managerFileMenu();
				managerFilemodel managerModel = new managerFilemodel();
				new managerFileController(managerModel, managerView, username);
				managerView.setVisible(true);
				break;
			case "Restaurateur":
				RestaurateurView restaurateurView = new RestaurateurView();
				RestaurateurViewModel model = new RestaurateurViewModel();
				model.setResturantID(model.selectRestaurantIdByUsername(username));
	
				RestaurateurController controller =new RestaurateurController(restaurateurView, model);
				restaurateurView.setVisible(true);
				break;
			default:
				System.out.println("Invalid role: " + role);
				break;
			}
			view.dispose();
		}
	}
 
}