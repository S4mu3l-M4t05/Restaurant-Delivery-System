package deliverySystem.controllers.deliveryman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import deliverySystem.models.deliveryman.EndDeliveriesModel;
import deliverySystem.models.deliveryman.OrderDeliveryModel;
import deliverySystem.models.restaurateur.OrdersClass;
import deliverySystem.views.deliveryman.AcceptDeliveriesView;
import deliverySystem.views.deliveryman.EndDeliveriesView;

public class AcceptDeliveryController {

    private AcceptDeliveriesView view;
    private OrderDeliveryModel model;
    private List<Integer> ordersIDList ;
    public AcceptDeliveryController(AcceptDeliveriesView view, OrderDeliveryModel model) {
        this.view = view;
        this.model = model;

        attachListeners();
        insertData();
    }
    private void insertData() {
    	
   	 List<Integer> clientIds = model.getClientIdsFromOrders();
        
        // Create a DefaultListModel to hold client usernames
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Iterate through client IDs and get usernames
                
        for (int clientId : clientIds) {
            String username = model.getClientName(clientId);
            System.out.println(clientId+"_"+username);
            listModel.addElement(username); 
        }
        ordersIDList=model.getOrdersIDFromOrders();
        System.out.println();
        
        // Set the list model to the JList in the view
        view.getDeliveryList().setModel(listModel);
   }

    private void attachListeners() {
    	view.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  Integer selectedIndex =  view.getDeliveryList().getSelectedIndex();
                  if (selectedIndex != -1) {
                      // Retrieve order ID from selectedIndex (assuming selectedIndex is the order ID)
                      int orderId = selectedIndex;
                     
                      // Call selectOrder
                      OrdersClass selectedOrder = model.selectOrder(view.getDeliveryList().getSelectedValue().toString());
                      
                      
                      // Process the selected order, for example, display its details in a dialog
                      if (selectedOrder != null) {
                    	  String date = selectedOrder.getDeliveryTime();
                    	  String orderDetail ="";
                    	  orderDetail += "Order # : "+selectedOrder.getOrderId()+"\n";
                    	  orderDetail += "Resturant # : "+selectedOrder.getRestaurantId()+"\n";
                    	  orderDetail += "Delivery Address : "+selectedOrder.getAddress()+"\n";
                    	  orderDetail += "Delivery Postal Code : "+selectedOrder.getPostalCode();
                    	  
                    	 
                          view.getDeliveryDetailsBox().setText(orderDetail);
                      } else {
                          JOptionPane.showMessageDialog(view, "Failed to retrieve order details.", "Error", JOptionPane.ERROR_MESSAGE);
                      }
                  } else {
                      JOptionPane.showMessageDialog(view, "Please select an item from the list.", "No item selected", JOptionPane.WARNING_MESSAGE);
                  }
              }
            
            
        });
    	view.getCompleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  if (!view.getDeliveryDetailsBox().getText().equals("")) {
                      int option = JOptionPane.showConfirmDialog(null, "Do you want to Take this order?", "Confirmation", JOptionPane.YES_NO_OPTION);
                      if (option == JOptionPane.YES_OPTION) {
                          int selectedIndex = view.getDeliveryList().getSelectedIndex();
                          if (selectedIndex != -1) { // Check if an item is selected
                        	  OrdersClass selectedOrder = model.selectOrder(view.getDeliveryList().getSelectedValue().toString());
                              model.updateOrderStatus(selectedOrder.getOrderId(), "En Route");
                              
                              model.updateDeliveryManID(selectedOrder.getOrderId(), model.getDMUserName());
                              JOptionPane.showMessageDialog(null, "Order has assigned to you !", "Success", JOptionPane.INFORMATION_MESSAGE);
                              DefaultListModel<String> model = (DefaultListModel<String>) view.getDeliveryList().getModel();
                              model.remove(selectedIndex); 
                              ordersIDList.remove(selectedIndex);
                              view.getDeliveryDetailsBox().setText("");
                           
                          } else {
                              JOptionPane.showMessageDialog(null, "Please select an order to accept.", "Error", JOptionPane.ERROR_MESSAGE);
                          }
                      }
                  }else {
                  	JOptionPane.showMessageDialog(null, "Please Select a Order");
                  }
            }
        });
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
