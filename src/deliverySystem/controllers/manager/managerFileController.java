package deliverySystem.controllers.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import deliverySystem.controllers.LoginController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.manager.managerFilemodel;
import deliverySystem.models.manager.managerMenuEditModel;
import deliverySystem.models.manager.managerRestaurantEditModel;
import deliverySystem.models.manager.viewRestaurantOrderModel;
import deliverySystem.views.LoginView;
import deliverySystem.views.manager.managerFileMenu;
import deliverySystem.views.manager.managerMenuEditView;
import deliverySystem.views.manager.managerRestaurantEditView;
import deliverySystem.views.manager.viewRestaurantOrder;



public class managerFileController implements ActionListener {
	private managerFilemodel model;
	private managerFileMenu view;
	private String username;
	
	public managerFileController(managerFilemodel model, managerFileMenu view, String username) {
		this.model = model;
		this.view = view;
		this.username = username;
		
		view.getMntmDisconnect().addActionListener(this);
		view.getMntmQuit().addActionListener(this);
		view.getMntmRestaurant().addActionListener(this);
		view.getMntmMenu().addActionListener(this);
		view.getMntmViewrestaurantOrder().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() ==  view.getMntmQuit()) {
			quit();
		}
		if (e.getSource() ==  view.getMntmDisconnect()) {
			view.dispose();
			LoginView view = new LoginView();
			LoginModel model = new LoginModel();
			new LoginController(view, model);
			view.setVisible(true);
		}
		if (e.getSource() ==  view.getMntmRestaurant()) {
			managerRestaurantEditView managerRestaurantEditView = new managerRestaurantEditView();
			managerRestaurantEditModel managerRestaurantEditModel = new managerRestaurantEditModel();
			 new managerRestaurantEditController(managerRestaurantEditModel,managerRestaurantEditView,username);
			 view.dispose();
			 managerRestaurantEditView.setVisible(true);
		}
		if (e.getSource() ==  view.getMntmMenu()) {
			 managerMenuEditModel managerMenuEditModel = new managerMenuEditModel();
				managerMenuEditView managerMenuEditView = new managerMenuEditView();
				new managerMenuEditController(managerMenuEditModel,managerMenuEditView,username);
				 view.dispose();
				managerMenuEditView.setVisible(true);
		}
		if (e.getSource() ==  view.getMntmViewrestaurantOrder()) {
		viewRestaurantOrder viewRestaurantOrder = new viewRestaurantOrder();
		viewRestaurantOrderModel viewRestaurantOrderModel = new viewRestaurantOrderModel();
		 new viewRestaurantOrderController(viewRestaurantOrderModel,viewRestaurantOrder,username);
		 view.dispose();
		 viewRestaurantOrder.setVisible(true);
		}

		
	}
	
	public void quit() {
		JFrame frame = new JFrame("Close");
		if(JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){

				System.exit(0);
		               
		}
	}
}

