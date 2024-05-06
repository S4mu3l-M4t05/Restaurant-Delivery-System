package deliverySystem.controllers.admin;

import deliverySystem.models.admin.DeliveryManModel;
import deliverySystem.models.deliveryman.DeliveryManClass;
import deliverySystem.views.admin.DeliveryEditView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DeliveryEditController implements ActionListener ,ListSelectionListener {
    private DeliveryEditView view;
    private DeliveryManModel model;
    public DeliveryEditController(DeliveryEditView view , DeliveryManModel model) {
        this.view = view;
        this.model=model;
        addActionListeners();
        insertData();
    }

    private void insertData() {
    	DeliveryManModel deliveryManModel = new DeliveryManModel();
        DeliveryEditView deliveryEditView = new DeliveryEditView();
        
        // Call getAllUsernames() method to get all usernames from the model
        List<String> usernames = deliveryManModel.getAllUsernames();
        String[] usernamesArray = usernames.toArray(new String[0]); // Convert List to array
        for (String username : usernamesArray) {
        	view.getDeliveryUsersModel().addElement(username);
        }
      

        

    }
  
    private void addActionListeners() {
        view.getDeliveryClear().addActionListener(this);
        view.getDeliverySave().addActionListener(this);
        view.getDeliveryAddArea().addActionListener(this);
        view.getDeliveryRemoveArea().addActionListener(this);
        view.getDeliveryList().addListSelectionListener(this);
        view.getDeliveryActivation().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            if (sourceButton == view.getDeliveryClear()) {
                handleClearAction();
            } else if (sourceButton == view.getDeliverySave()) {
                handleSaveAction();
            } else if (sourceButton == view.getDeliveryAddArea()) {
                handleAddAreaAction();
            } else if (sourceButton == view.getDeliveryRemoveArea()) {
                handleRemoveAreaAction();
            }
            else if (sourceButton == view.getDeliveryActivation()) {
                handleActivation();
            }
        }
    }
    
    private void handleActivation() {
    	if(view.getDeliveryActivation().getText().equals("Active")) {
    		int choice = JOptionPane.showConfirmDialog(null, "Do you want to activate the user?", "Confirmation", JOptionPane.YES_NO_OPTION);

    		if (choice == JOptionPane.YES_OPTION) {
    			DeliveryManClass deliverymanClass = new DeliveryManClass(view.getDeliveryList().getSelectedValue(), "1");
        		model.changeStatusByUsername(deliverymanClass);
    		    JOptionPane.showMessageDialog(null, "User activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    		    view.getDeliveryActivation().setText("De Active");
    		 	view.getDeliveryName().setEnabled(true);
            	view.getDeliveryTelephone().setEditable(true);
            	view.getDeliveryAreaList().setEnabled(true);
            	view.getDeliveryAreaInput().setEnabled(true);
            	view.getDeliverySave().setEnabled(true);
            	view.getDeliveryClear().setEnabled(true);
            	view.getDeliveryAddArea().setEnabled(true);
            	view.getDeliveryRemoveArea().setEnabled(true);
    		}
    		
    	}else {
    		int choice = JOptionPane.showConfirmDialog(null, "Do you want to De Activate the user?", "Confirmation", JOptionPane.YES_NO_OPTION);

    		if (choice == JOptionPane.YES_OPTION) {
    			DeliveryManClass deliverymanClass = new DeliveryManClass(view.getDeliveryList().getSelectedValue(), "0");
        		model.changeStatusByUsername(deliverymanClass);
    		    JOptionPane.showMessageDialog(null, "User De Activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    		    view.getDeliveryActivation().setText("Active");
    		 	view.getDeliveryActivation().setText("Active");
            	view.getDeliveryName().setEnabled(false);
            	view.getDeliveryTelephone().setEditable(false);
            	view.getDeliveryAreaList().setEnabled(false);
            	view.getDeliveryAreaInput().setEnabled(false);
            	view.getDeliverySave().setEnabled(false);
            	view.getDeliveryClear().setEnabled(false);
            	view.getDeliveryAddArea().setEnabled(false);
            	view.getDeliveryRemoveArea().setEnabled(false);
    		    
    		}
    	}
    }
    private void handleClearAction() {
        // Implement logic to clear fields
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the fields?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.getDeliveryName().setText("");
            view.getDeliveryAreaInput().setText("");
            view.getDeliveryTelephone().setText("");
            
            view.getDeliveryAreaList().setListData(new String[0]);
            view.getDeliveryList().clearSelection();
        }
    }

    private void handleSaveAction() {
        if(view.getDeliveryList().isSelectionEmpty()) {
        	JOptionPane.showMessageDialog(null, "Please Select a Delivery Man", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
        	String errors = "";
        	
        	if(view.getDeliveryName().getText().trim().equals("")) {
        		errors+="Delivery Name is Empty \n";
        	}
        	 String telephone = view.getDeliveryTelephone().getText().replaceAll("[^0-9]", "");
             if (telephone.isEmpty()) {
                 errors += "Telephone number cannot be empty \n";
             }
             
             if (telephone.length() != 10) {
                 errors += "Telephone number is invalid \n";
             }
             if(view.getDeliveryAreaList().getModel().getSize() == 0) {
             	errors +="Delivery Area is Empty";
             }
             if(errors.equals("")) {
            	 int confirmation = JOptionPane.showConfirmDialog(null,
                         "Do you want to Update this delivery man?",
                         "Confirmation",
                         JOptionPane.YES_NO_OPTION);

                 // If the user confirms, proceed with adding the delivery man
                 if (confirmation == JOptionPane.YES_OPTION) {
                     DeliveryManClass deliveryMan = new DeliveryManClass(
                    		 view.getDeliveryList().getSelectedValue(),
                    		 view.getDeliveryName().getText(),view.getDeliveryTelephone().getText(),
                    		 getDeliveryAreaListAsString(view.getDeliveryAreaList()));
            
                     
                     model.updateDeliveryMan(deliveryMan);
                     JOptionPane.showMessageDialog(null, "Delivery Man has been updated", "Delivery Man", JOptionPane.INFORMATION_MESSAGE);
                     view.getDeliveryName().setText("");
                     view.getDeliveryTelephone().setText("");
                     view.getListModel().clear();
                     view.getDeliveryAreaList().setListData(new String[0]);       
                     view.getDeliveryAreaInput().setText("");
            
                     view.getDeliveryList().clearSelection();
                 }
             }else {
            	 JOptionPane.showMessageDialog(null, errors, "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
       
    }
    public static String getDeliveryAreaListAsString(JList<String> deliveryAreaList) {
        StringBuilder stringBuilder = new StringBuilder();
        ListModel<String> model = deliveryAreaList.getModel();
        
        // Iterate through each element in the list
        for (int i = 0; i < model.getSize(); i++) {
            // Append each value to the StringBuilder
            stringBuilder.append(model.getElementAt(i));
            
            // Append comma if it's not the last element
            if (i < model.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        
        return stringBuilder.toString();
    }

    private void handleAddAreaAction() {
        String newArea = view.getDeliveryAreaInput().getText().trim();
        if (!newArea.isEmpty()) {
            if (!view.getListModel().contains(newArea)) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this area: " + newArea + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    view.getListModel().addElement(newArea);
                    view.getDeliveryAreaList().setModel(view.getListModel());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Area already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter an area.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void handleRemoveAreaAction() {
    	System.out.println(view.getListModel().size());
        // Implement logic to remove delivery area
        int selectedIndex = view.getDeliveryAreaList().getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Remove '" + view.getDeliveryAreaList().getSelectedValue() + "' from the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
            	
            	 view.getListModel().remove(selectedIndex); 
            	 view.getDeliveryAreaList().setModel( view.getListModel());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an area to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
        
            int selectedIndex = view.getDeliveryList().getSelectedIndex();
            
            if (selectedIndex != -1) {
                String selectedName = view.getDeliveryList().getSelectedValue();
              
                DeliveryManClass d = model.findDeliveryByUsername(selectedName);
                
                view.setDeliveryName(d.getName());
                view.setDeliveryTelephone(d.getPhoneNumber());
                view.getListModel().clear();
                //view.getListModel().addElement(d.getDeliveryArea());
                
                setDeliveryAreaListFromString(view.getDeliveryAreaList(), d.getDeliveryArea(),view.getListModel());
                
                view.getListModel();
               
                if(d.getStatus().equals("1")) {
                	view.getDeliveryActivation().setText("De Active");
             
                	view.getDeliveryName().setEnabled(true);
                	view.getDeliveryTelephone().setEditable(true);
                	view.getDeliveryAreaList().setEnabled(true);
                	view.getDeliveryAreaInput().setEnabled(true);
                	view.getDeliverySave().setEnabled(true);
                	view.getDeliveryClear().setEnabled(true);
                	view.getDeliveryAddArea().setEnabled(true);
                	view.getDeliveryRemoveArea().setEnabled(true);
                	
                }else {
                	view.getDeliveryActivation().setText("Active");
                	view.getDeliveryName().setEnabled(false);
                	view.getDeliveryTelephone().setEditable(false);
                	view.getDeliveryAreaList().setEnabled(false);
                	view.getDeliveryAreaInput().setEnabled(false);
                	view.getDeliverySave().setEnabled(false);
                	view.getDeliveryClear().setEnabled(false);
                	view.getDeliveryAddArea().setEnabled(false);
                	view.getDeliveryRemoveArea().setEnabled(false);
                }
                
            }
        }
    }
    public static void setDeliveryAreaListFromString(JList<String> deliveryAreaList, String values, DefaultListModel<String> listModel) {
        String[] elements = values.split(", ");
        deliveryAreaList.setListData(elements);
        
        // Clear the existing list model and add elements from the string
        listModel.clear();
        for (String element : elements) {
            listModel.addElement(element);
            
        }
    }

    
}
