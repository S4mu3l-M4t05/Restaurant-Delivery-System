package deliverySystem.controllers.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import deliverySystem.controllers.LoginController;
import deliverySystem.models.LoginModel;
import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.manager.managerClass;
import deliverySystem.models.manager.managerMenuEditModel;
import deliverySystem.models.manager.managerRestaurantEditModel;
import deliverySystem.models.manager.viewRestaurantOrderModel;
import deliverySystem.models.restaurateur.OrdersClass;
import deliverySystem.views.LoginView;
import deliverySystem.views.manager.managerMenuEditView;
import deliverySystem.views.manager.managerRestaurantEditView;
import deliverySystem.views.manager.viewRestaurantOrder;



public class viewRestaurantOrderController implements ActionListener,ListSelectionListener{
	private viewRestaurantOrderModel model;
	private viewRestaurantOrder view;
	private String username;

public viewRestaurantOrderController(viewRestaurantOrderModel model, viewRestaurantOrder view, String username) {
	this.model = model;
	this.view = view;
	this.username = username;
	
	view.getMntmDisconnect().addActionListener(this);
	view.getMntmQuit().addActionListener(this);
	view.getMntmRestaurant().addActionListener(this);
	view.getMntmMenu().addActionListener(this);
	view.getMntmViewrestaurantOrder().addActionListener(this);
	view.getTxt_deliverytime().addActionListener(this);
	view.getTxt_hour().addActionListener(this);
	view.getTxt_minute().addActionListener(this);
	view.getTxt_postalcode().addActionListener(this);
	view.getTextArea_mealorder();
	view.getList_restaurant();
	view.getListModelRestaurant();
	view.getListModelRestaurantOrder();
	view.getList_restaurantOrders().addListSelectionListener(this);
	managerClass m = model.findManagerbyId(username);
	RestaurantClass r = model.findRestaurantbyId(m.getRestaurant_id());
	 insertData();
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

@Override
public void valueChanged(ListSelectionEvent e) {
	// TODO Auto-generated method stub
    if (!e.getValueIsAdjusting()) {
        
        int selectedIndex = view.getList_restaurantOrders().getSelectedIndex();

        
        if (selectedIndex != -1) {
            String num	= view.getListModelRestaurantOrder().get(selectedIndex);
            String number = num.substring(0, 2);
          OrdersClass o =  model.findorderbyId(number);
          String deliverytime = o.getDeliveryTime().substring(0,10);
          String hour = o.getDeliveryTime().substring(10,13);
          String minute = o.getDeliveryTime().substring(14,16);
          view.getTxt_deliverytime().setText(deliverytime);
          view.getTxt_hour().setText(hour);
          view.getTxt_minute().setText(minute);
          view.getTxt_postalcode().setText(o.getAddress());
          view.getTextArea_mealorder().setText(o.getOrderDetail());
        	}
        }
}
public void quit() {
	JFrame frame = new JFrame("Close");
	if(JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){

			System.exit(0);
	               
	}
}
private void insertData() {
	viewRestaurantOrderModel viewRestaurantOrderModel = new viewRestaurantOrderModel();
	viewRestaurantOrder viewRestaurantOrder = new viewRestaurantOrder();
	managerClass m = model.findManagerbyId(username);
	RestaurantClass r = model.findRestaurantbyId(m.getRestaurant_id());
	   List<String> restaurants = viewRestaurantOrderModel.getrestaurant(m.getId());
        String[] restaurantArray = restaurants.toArray(new String[0]); // Convert List to array
        for (String restaurant : restaurantArray) {
        	view.getListModelRestaurant().addElement(restaurant);
        }
        System.out.println(r.getId());
        List<String> restaurantorders = viewRestaurantOrderModel.getrestaurantOrder(r.getId());
        String[] restaurantordersArray = restaurantorders.toArray(new String[0]); // Convert List to array
        for (String restaurantss : restaurantordersArray) {
        	view.getListModelRestaurantOrder().addElement(restaurantss);
        }
}
}

