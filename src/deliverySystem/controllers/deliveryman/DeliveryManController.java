package deliverySystem.controllers.deliveryman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import deliverySystem.models.deliveryman.AcceptDeliveriesModel;
import deliverySystem.models.deliveryman.DeliveryManPageModel;
import deliverySystem.models.deliveryman.EndDeliveriesModel;
import deliverySystem.models.deliveryman.OrderDeliveryModel;

import deliverySystem.views.deliveryman.AcceptDeliveriesView;
import deliverySystem.views.deliveryman.DeliveryManView;
import deliverySystem.views.deliveryman.EndDeliveriesView;


public class DeliveryManController {

    private DeliveryManView view;
    private DeliveryManPageModel model;

    public DeliveryManController(DeliveryManView view, DeliveryManPageModel model) {
        this.view = view;
        this.model = model;

        // Attach action listeners to view components
        attachListeners();
    }

    private void attachListeners() {
        // File menu - Exit
        view.getMntmNewMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

      

        // Delivery menu - Accept Deliveries
        view.getMntmNewMenuItem_2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptDeliveries();
            }
        });

        // Delivery menu - End Deliveries
        view.getMntmNewMenuItem_3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endDeliveries();
            }
        });
    }


    private void acceptDeliveries() {
    	OrderDeliveryModel model = new OrderDeliveryModel();
        AcceptDeliveriesView view = new AcceptDeliveriesView();
        model.setDMUserName(this.model.getDMUserName());
        AcceptDeliveryController controller = new AcceptDeliveryController(view, model);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void endDeliveries() {
    	EndDeliveriesModel model = new EndDeliveriesModel();
    	model.setDMUserName(this.model.getDMUserName());
        EndDeliveriesView view = new EndDeliveriesView();
        EndDeliveryController controller = new EndDeliveryController(view, model);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
