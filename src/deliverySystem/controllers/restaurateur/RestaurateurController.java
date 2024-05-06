package deliverySystem.controllers.restaurateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import deliverySystem.models.restaurateur.RestaurateurModel;

import deliverySystem.models.restaurateur.RestaurateurViewModel;
import deliverySystem.views.restaurateur.AcceptOrderView;
import deliverySystem.views.restaurateur.OrderReadyView;
import deliverySystem.views.restaurateur.RestaurateurView;

public class RestaurateurController implements ActionListener {

    private RestaurateurView view;
    private RestaurateurViewModel model;
   
    public RestaurateurController(RestaurateurView view, RestaurateurViewModel model) {
        this.view = view;
        this.model = model;

        // Add action listeners directly in the controller
        attachListeners();
    }
    private void attachListeners() {
        // File menu - Exit
        view.getExitMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Delivery menu - View Deliveries
        view.getOrderReadyMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderReady();
            }
        });
        view.getAcceptOrderMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptOrder();
            }
        });
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getAcceptOrderMenuItem()) {
            // Handle Accept Order menu item action
            handleAcceptOrder();
        } else if (e.getSource() == view.getOrderReadyMenuItem()) {
            // Handle Order Ready menu item action
            handleOrderReady();
        }
    }

    private void handleAcceptOrder() {
        // Implement logic to handle Accept Order action
        // For example, update model to accept the order
        // model.acceptOrder();
    }

    private void handleOrderReady() {
        // Implement logic to handle Order Ready action
        // For example, update model to mark the order as ready
        // model.markOrderReady();
    }
    private void orderReady() {
    	RestaurateurModel model = new RestaurateurModel();
   	 	OrderReadyView view = new OrderReadyView();
   	 	model.setResturantID(this.model.getResturantID());
        OrderReadyController controller = new OrderReadyController(view, model);
    
        view.setVisible(true);
    }

    private void acceptOrder() {
    	
   	 	RestaurateurModel model = new RestaurateurModel();
   	 	model.setResturantID(this.model.getResturantID());
   	 	System.out.println("HERE : "+model.getResturantID());
   	 	AcceptOrderView view = new AcceptOrderView();
        AcceptOrderController controller = new AcceptOrderController(view, model);
    
        view.setVisible(true);
    }

}
