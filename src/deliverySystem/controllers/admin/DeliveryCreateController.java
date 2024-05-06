package deliverySystem.controllers.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import deliverySystem.models.admin.DeliveryManModel;
import deliverySystem.models.deliveryman.DeliveryManClass;
import deliverySystem.views.admin.DeliveryCreateView;

public class DeliveryCreateController implements ActionListener {
    private DeliveryCreateView view;
    private DeliveryManModel model;
    private boolean userExist = false;
    private boolean userChanged = false;
    public DeliveryCreateController(DeliveryCreateView view, DeliveryManModel model) {
        this.view = view;
        this.model = model;

        this.view.getDeliverySaveButton().addActionListener(this);
        this.view.getDeliveryAddArea().addActionListener(this);
        this.view.getDeliveryRemoveArea().addActionListener(this);
        this.view.getCheckAvalibity().addActionListener(this);
        this.view.getDeliveryClearButton().addActionListener(this);
        this.view.getShowPassword().addActionListener(this);
        this.view.getShowPassword().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                view.getShowPassword().setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!view.getShowPassword().isSelected()) {
                    view.getShowPassword().setBackground(new Color(0, 0, 0, 0)); // Set back to transparent if not selected
                }
            }
        });
 
        
        // error
       // this.view.getDeliveryAreaInput().getText().matches("^[a-zA-Z][0-9][a-zA-Z]$");
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            if (sourceButton == view.getDeliverySaveButton()) {
                String errors = "";
                if (view.getDeliveryName().getText().equals("")) {
                    errors += "Name is Empty \n";
                }
                if (view.getDeliveryUserName().getText().equals("")) {
                    errors += "User Name is Empty \n";
                }
                String telephone = view.getDeliveryTelephone().getText().replaceAll("[^0-9]", "");
                if (telephone.isEmpty()) {
                    errors += "Telephone number cannot be empty \n";
                } else if (telephone.length() < 10) {
                    errors += "Telephone number should have at least 10 digits \n";
                }
                if (view.getDeliveryPassword().getText().equals("") || view.getDeliveryPassword().getText().length() < 5) {
                    errors += "Password is Empty or less than 5 \n";
                }
                char[] passwordChars = view.getDeliveryConPassword().getPassword();
                String confirmPassword = new String(passwordChars);

                if (confirmPassword.equals("")) {
                    errors += "Confirm Password is Empty \n";
                }
                if (!view.getDeliveryPassword().getText().equals(confirmPassword)) {
                    errors += "Password Doesn't Match \n";
                }
                if(userChanged==false) {
                	   errors += "Please Check Username Avaliabity";
                }else {
                	if(userExist==true) {
                		  errors += "User Already Exist";
                	}
                }
                if(view.getDeliveryAreaList().getModel().getSize() == 0) {
                	errors +="Delivery Area is Empty";
                }
           
            
                if (errors.equals("")) {
                	if( model.usernameExistsInAnyTable(view.getDeliveryUserName().getText())==false) {
                		int confirmation = JOptionPane.showConfirmDialog(null,
                                "Do you want to add this delivery man?",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);

                        // If the user confirms, proceed with adding the delivery man
                        if (confirmation == JOptionPane.YES_OPTION) {
                            DeliveryManClass deliveryMan = new DeliveryManClass(
                                    view.getDeliveryUserName().getText(),
                                    new String(view.getDeliveryPassword().getText()),
                                    view.getDeliveryName().getText(),
                                    view.getDeliveryTelephone().getText(),
                                    getDeliveryAreaListAsString(view.getDeliveryAreaList()),
                                    "1"
                            );
                            model.addDeliveryMan(deliveryMan);
                            JOptionPane.showMessageDialog(null, "New Delivery Man has been added!", "Delivery Man", JOptionPane.INFORMATION_MESSAGE);
                            view.getDeliveryName().setText("");
                            view.getDeliveryUserName().setText("");
                            view.getDeliveryTelephone().setText("");
                            view.getDeliveryPassword().setText("");
                            view.getDeliveryConPassword().setText("");
                            view.getListModel().clear();
                            view.getDeliveryAreaList().setListData(new String[0]);
                            view.getShowPassword().setSelected(false);
                            view.getDeliveryAreaInput().setText("");
                        }
                             
                	}else {
                	    JOptionPane.showMessageDialog(null, "User Name is taken", "Error", JOptionPane.ERROR_MESSAGE);
                	}
                   
                } else {
                    JOptionPane.showMessageDialog(null, errors, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (sourceButton == view.getDeliveryAddArea()) {
                // Handle add delivery area button action
                handleAddDeliveryArea();
            } else if (sourceButton == view.getDeliveryRemoveArea()) {
                // Handle remove delivery area button action
                handleRemoveDeliveryArea();
            } else if (sourceButton == view.getCheckAvalibity()) {
            	userChanged=true;
            	if( model.usernameExistsInAnyTable(view.getDeliveryUserName().getText())==true) {
            		userExist=true;
            		JOptionPane.showMessageDialog(null, "User name is Taken");
            	}else {
            		userExist=false;
            		JOptionPane.showMessageDialog(null, "User name is OK");
            	}
            } else if (sourceButton == view.getDeliveryClearButton()) {
                // Handle clear button action
                handleClearButton();
            }
        } else if (e.getSource() instanceof JCheckBox) {
            JCheckBox sourceCheckBox = (JCheckBox) e.getSource();
            if (sourceCheckBox == view.getShowPassword()) {
                // Handle show password checkbox action
                handleShowPasswordCheckbox();
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
    private void handleAddDeliveryArea() {
        // Implement logic to add delivery area
        String newItem = view.getDeliveryAreaInput().getText();
        if (!newItem.isEmpty()) {
            if (!view.getListModel().contains(newItem)) {
                int confirm = JOptionPane.showConfirmDialog(null, "Add '" + newItem + "' to the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    view.getListModel().addElement(newItem);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The area is already added", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter an area to add", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleRemoveDeliveryArea() {
        // Implement logic to remove delivery area
        int selectedIndex = view.getDeliveryAreaList().getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Remove '" + view.getDeliveryAreaList().getSelectedValue() + "' from the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                view.getListModel().remove(selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an area to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleClearButton() {
        // Implement logic to clear input fields
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.getDeliveryName().setText("");
            view.getDeliveryUserName().setText("");
            view.getDeliveryTelephone().setText("");
            view.getDeliveryPassword().setText("");
            view.getDeliveryConPassword().setText("");
            view.getListModel().clear();
            view.getDeliveryAreaList().setListData(new String[0]);
            view.getShowPassword().setSelected(false);
            view.getDeliveryAreaInput().setText("");
        }
    }

    private void handleShowPasswordCheckbox() {
        // Implement logic to show/hide password
        if (view.getShowPassword().isSelected()) {
            view.getDeliveryConPassword().setEchoChar((char) 0);
        } else {
            view.getDeliveryConPassword().setEchoChar('\u2022');
        }
    }
}
