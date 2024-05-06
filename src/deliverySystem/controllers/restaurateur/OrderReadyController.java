package deliverySystem.controllers.restaurateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import deliverySystem.models.restaurateur.OrdersClass;
import deliverySystem.models.restaurateur.RestaurateurModel;

import deliverySystem.views.restaurateur.AcceptOrderView;
import deliverySystem.views.restaurateur.OrderReadyView;

public class OrderReadyController implements ActionListener {

	 private OrderReadyView view;
	 private RestaurateurModel model;
	 private List<Integer> ordersIDList ;
	public OrderReadyController(OrderReadyView view, RestaurateurModel model) {
		  this.view = view;
	        this.model = model;

	        // Add action listeners
	    
	        view.getBtnAccept().addActionListener(this);
	        view.getBtnSelect().addActionListener(this);
	        // Add more listeners if necessary
	        
	        attachListeners();
	        insertData();
	    }

	    private void insertData() {
	    	 List<Integer> clientIds = model.getClientIdsFromAcceptedOrders();
	         
	         // Create a DefaultListModel to hold client usernames
	         DefaultListModel<String> listModel = new DefaultListModel<>();
	    
	         // Iterate through client IDs and get usernames
	         
	         
	         for (int clientId : clientIds) {
	             String username = model.getClientName(clientId);
	             
	          
	             listModel.addElement(username); 
	         }
	         ordersIDList=model.getAcceptedOrdersIDFromOrders();
	         for(int i : ordersIDList) {
	        	 System.out.println(i);
	         }
	         
	         // Set the list model to the JList in the view
	         view.getList().setModel(listModel);
	    }
	    
	    private void attachListeners() {
	    	view.getBtnSelect().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	  Integer selectedIndex =  view.getList().getSelectedIndex();
	                  if (selectedIndex != -1) {
	                      // Retrieve order ID from selectedIndex (assuming selectedIndex is the order ID)
	                      int orderId = selectedIndex;
	                      
	                      // Call selectOrder
	                      OrdersClass selectedOrder = model.selectOrder(ordersIDList.get(orderId));
	                      
	                      // Process the selected order, for example, display its details in a dialog
	                      if (selectedOrder != null) {
	                    	  String date = selectedOrder.getDeliveryTime();
	                          view.getDeliverydate().setText(model.extractDate(date));
	                          view.getDeliveryH().setText(model.extractHour(date));
	                          
	                          view.getDeliveryM().setText(model.extractMinute(date));
	                          view.getDeliveryPC().setText(selectedOrder.getPostalCode());
	                          view.getOrders().setText(selectedOrder.getOrderDetail());
	                      } else {
	                          JOptionPane.showMessageDialog(view, "Failed to retrieve order details.", "Error", JOptionPane.ERROR_MESSAGE);
	                      }
	                  } else {
	                      JOptionPane.showMessageDialog(view, "Please select an item from the list.", "No item selected", JOptionPane.WARNING_MESSAGE);
	                  }
	              }
	            
	        });
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
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == view.getAcceptOrderMenuItem()) {
	            // Handle Accept Order menu item action
	            handleAcceptOrder();
	        } else if (e.getSource() == view.getExitMenuItem()) {
	            // Handle Exit menu item action
	            handleExit();
	        } else if (e.getSource() == view.getBtnAccept()) {
	            // Handle Accept button action
	            handleAcceptButton();
	        }
	        // Handle other actions if necessary
	    }

	    private void handleAcceptOrder() {
	      
	    }

	    private void handleExit() {
	        // Implement logic to handle Exit
	        view.dispose(); // Close the view
	    }

	    private void handleAcceptButton() {
	        if (!view.getDeliverydate().getText().equals("")) {
	            int option = JOptionPane.showConfirmDialog(null, "Do you want to accept the order?", "Confirmation", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                int selectedIndex = view.getList().getSelectedIndex();
	                if (selectedIndex != -1) { // Check if an item is selected
	                    model.updateOrderStatus(ordersIDList.get(selectedIndex), "Ready");
	                    JOptionPane.showMessageDialog(null, "Order Accepted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    DefaultListModel<String> model = (DefaultListModel<String>) view.getList().getModel();
	                    model.remove(selectedIndex); 
	                    ordersIDList.remove(selectedIndex);
	                    view.getDeliverydate().setText("");
	                    view.getDeliveryH().setText("");
	                    view.getDeliveryM().setText("");
	                    view.getDeliveryPC().setText("");
	                    view.getOrders().setText("");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Please select an order to accept.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }else {
	        	JOptionPane.showMessageDialog(null, "Please Select a Order");
	        }
	    }

	}
