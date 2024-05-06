package deliverySystem.controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import deliverySystem.controllers.LoginController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.admin.DeliveryManModel;
import deliverySystem.models.admin.MenuModel;
import deliverySystem.models.admin.RestaurantEditModel;
import deliverySystem.models.admin.RestaurantModel;
import deliverySystem.models.admin.createmanagerModel;
import deliverySystem.views.LoginView;
import deliverySystem.views.admin.AdminView;
import deliverySystem.views.admin.DeliveryCreateView;
import deliverySystem.views.admin.DeliveryEditView;
import deliverySystem.views.admin.MenuCreateView;
import deliverySystem.views.admin.MenuEditView;
import deliverySystem.views.admin.RestaurantEditView;
import deliverySystem.views.admin.RestaurantView;
import deliverySystem.views.admin.createmanagerView;

public class AdminController {
	private AdminView view;

	public AdminController(AdminView view) {
		this.view = view;

		view.getMntmDisconnect().addActionListener(new DisconnectMntmListener());
		view.getMntmQuit().addActionListener(new QuitMntmListener());
		view.getMntmRestaurantCreate().addActionListener(new RestaurantCreateMntmListener());
		view.getMntmRestaurantEdit().addActionListener(new RestaurantEditMntmListener());
		view.getMntmMenuCreate().addActionListener(new MenuCreateMntmListener());
		view.getMntmMenuEdit().addActionListener(new MenuEditMntmListener());
		view.getMntmDeliverymanCreate().addActionListener(new DeliverymanCreateMntmListener());
		view.getMntmDeliverymanEdit().addActionListener(new DeliverymanEditMntmListener());
		view.getMntmManagerCreate().addActionListener(new ManagerCreateMntmListener());
	}

	public static void main(String[] args) {
		AdminView adminView = new AdminView();
		new AdminController(adminView);
		adminView.setVisible(true);
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
	class ManagerCreateMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			createmanagerView createManagerView = new createmanagerView();
			createmanagerModel createmanagerModel = new createmanagerModel();
			new createmanagerController(createmanagerModel, createManagerView);
			createManagerView.setVisible(true);
		}
	}

	class QuitMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class RestaurantCreateMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Creating new restaurant...");
			RestaurantView restaurantView = new RestaurantView();
			RestaurantModel restaurantModel = new RestaurantModel();
			new RestaurantController(restaurantModel, restaurantView);
			restaurantView.setVisible(true);
		}
	}

	class RestaurantEditMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Editing restaurant...");
			RestaurantEditView restaurantEditView = new RestaurantEditView();
			RestaurantEditModel restaurantEditModel = new RestaurantEditModel();
			new RestaurantEditController(restaurantEditModel, restaurantEditView);
			restaurantEditView.setVisible(true);
		}
	}

	class MenuCreateMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Creating new menu...");
			MenuCreateView menuCreateView = new MenuCreateView();
			MenuModel menuModel = new MenuModel();
			new MenuCreateController(menuModel, menuCreateView);
			menuCreateView.setVisible(true);
		}
	}

	class MenuEditMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Editing menu...");
			MenuEditView menuEditView = new MenuEditView();
			MenuModel menuModel = new MenuModel();
			new MenuEditController(menuModel, menuEditView);
			menuEditView.setVisible(true);
		}
	}

	class DeliverymanCreateMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Creating new deliveryman...");
			DeliveryCreateView deliveryCreateView = new DeliveryCreateView();
			DeliveryManModel deliveryManModel = new DeliveryManModel();
			new DeliveryCreateController(deliveryCreateView, deliveryManModel);
			deliveryCreateView.setVisible(true);
		}
	}

	class DeliverymanEditMntmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Editing deliveryman...");
			DeliveryEditView deliveryEditView = new DeliveryEditView();
			DeliveryManModel deliveryManModel = new DeliveryManModel();
			new DeliveryEditController(deliveryEditView, deliveryManModel);
			deliveryEditView.setVisible(true);
		}
	}

}
