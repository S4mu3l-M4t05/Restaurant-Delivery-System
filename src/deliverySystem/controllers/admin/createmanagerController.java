package deliverySystem.controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.admin.RestaurantEditModel;
import deliverySystem.models.admin.RestaurantModel;
import deliverySystem.models.admin.createmanagerModel;
import deliverySystem.models.manager.managerClass;
import deliverySystem.views.admin.RestaurantEditView;
import deliverySystem.views.admin.RestaurantView;
import deliverySystem.views.admin.createmanagerView;
 
public class createmanagerController implements ActionListener,ListSelectionListener {
	private createmanagerModel model;
	private createmanagerView view;
	private String num0;

public createmanagerController(createmanagerModel model,createmanagerView view) {
		

		this.model = model;
		this.view = view;
		
		  insertData();
		view.getTxt_username().addActionListener(this);
		view.getTxt_password().addActionListener(this);
		view.getBtnSave().addActionListener(this);
		view.getTxt_confirmpassword().addActionListener(this);
		view.getListModelresto();
		view.getListrestaurant().addListSelectionListener(this);;
//		menubar
		view.getMntmFileDisconnect().addActionListener(this);
		view.getMntmFileQuit().addActionListener(this);
		view.getMntmMenuCreate().addActionListener(this);
		view.getMntmMenuDelete().addActionListener(this);
		view.getMntmMenuEdit().addActionListener(this);
		view.getMntmRestaurantCreate().addActionListener(this);
		view.getMntmRestaurantEdit().addActionListener(this);
		view.getMntmCreateDeliveryGuy().addActionListener(this);
		view.getMntmEditDeliveryGuy().addActionListener(this);
		view.getMntmDeleteDeliveryGuy().addActionListener(this);
	 

	}


@Override
public void valueChanged(ListSelectionEvent e) {
	// TODO Auto-generated method stub
	if (!e.getValueIsAdjusting()) {
        
        int selectedIndex = view.getListrestaurant().getSelectedIndex();
        if (selectedIndex != -1) {
            String num	= view.getListModelresto().get(selectedIndex);
            String number = num.substring(0, 2);
            
            num0 = number; 
            view.getBtnSave().setEnabled(true);
        }
	}
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == view.getMntmRestaurantCreate()) {
		RestaurantView RV;
		RestaurantModel RM;
		RestaurantController RC;
		RV = new RestaurantView();
		RM = new RestaurantModel();
		RC = new RestaurantController(RM,RV);	
		view.dispose();
		RV.setVisible(true);
	}
	if(e.getSource() == view.getMntmRestaurantEdit()) {
		view.dispose();
		RestaurantEditView REV;
		RestaurantEditModel REM;
		RestaurantEditController REC;
		REV = new RestaurantEditView();
		REM = new RestaurantEditModel();
		REC = new RestaurantEditController(REM,REV);	
		REV.setVisible(true);
}
	if(e.getSource() == view.getMntmCreateManager()) {
		createmanagerView CMV;
		createmanagerModel CMM;
		createmanagerController CMC;
		CMV = new createmanagerView();
		CMM = new createmanagerModel();
		CMC = new createmanagerController(CMM,CMV);	
		view.dispose();
		CMV.setVisible(true);
	}
	if(e.getSource() == view.getMntmFileQuit()) {
		quit();
	}
	
	if (view.getBtnSave() ==  e.getSource()) {
		String username = view.getTxt_username().getText();
		String password = view.getTxt_password().getText();
		String confirmedPassword = view.getTxt_confirmpassword().getText();
		
		if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
			JOptionPane.showMessageDialog(view, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
			
		}else {
			if(password.length() < 8) {
				JOptionPane.showMessageDialog(view, "Password must be atleast 8 characters .", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(!password.equals(confirmedPassword) ) {
					JOptionPane.showMessageDialog(view, "Confirm password and password must be the same.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					JFrame frame = new JFrame("Save");
					boolean choice = JOptionPane.showConfirmDialog(
							frame,"Username:" + view.getTxt_username().getText()+'\n'+
							"Password: " + view.getTxt_password().getText()+'\n',"Save",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION;
					
					if(choice == true ) {
				
						
							managerClass manager = new managerClass(null,view.getTxt_username().getText(),view.getTxt_password().getText(),num0,null);
							
							model.addManager(manager);
							
						
							String name = view.getTxt_username().getText();
						
							
							managerClass m = model.findManagerbyId(name);
							 RestaurantClass r =  model.findRestaurantbyId(num0);
						
							RestaurantClass resto = new RestaurantClass(null,r.getName(),r.getAddress(),r.getPhoneNumber(),
									r.getOpenningHourSU(),r.getOpenningMinSU(),r.getClosingHourSU(),r.getClosingMinSU(),
									r.getOpenningHourMO(),r.getOpenningMinMO(),r.getClosingHourMO(),r.getClosingMinMO(),
									r.getOpenningHourTU(),r.getOpenningMinTU(),r.getClosingHourTU(),r.getClosingMinTU(),
									r.getOpenningHourWE(),r.getOpenningMinWE(),r.getClosingHourWE(),r.getClosingMinWE(),
									r.getOpenningHourTH(),r.getOpenningMinTH(),r.getClosingHourTH(),r.getClosingMinTH(),
									r.getOpenningHourFR(),r.getOpenningMinFR(),r.getClosingHourFR(),r.getClosingMinFR(),
									r.getOpenningHourSA(),r.getOpenningMinSA(),r.getClosingHourSA(),r.getClosingMinSA(),
									r.getDeliveryArea(),null,m.getId());
							
						    
						     model.updateRestaurant(resto,m.getRestaurant_id());
						    
							view.getTxt_username().setText("");
							view.getTxt_password().setText("");
							view.getTxt_confirmpassword().setText("");
							 view.getListModelresto().clear();
							  insertData();
							   view.getBtnSave().setEnabled(false);
					}
					if(choice == false ) {
						
					}
			
						
		
				
					
					view.getTxt_username().setText("");
					view.getTxt_password().setText("");
					view.getTxt_confirmpassword().setText("");
				}
				
			}

		}
	}

	}
private void insertData() {
	createmanagerModel createmanagerModel = new createmanagerModel();
	createmanagerView createmanagerView = new createmanagerView();
	
	   List<String> restaurants = createmanagerModel.getallrestaurantsandaddress();
        String[] restaurantArray = restaurants.toArray(new String[0]); // Convert List to array
        for (String restaurant : restaurantArray) {
        	view.getListModelresto().addElement(restaurant);
        }
      
}
public void quit() {
	JFrame frame = new JFrame("Close");
	if(JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){

			System.exit(0);
	               
}
}


}
