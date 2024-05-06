package deliverySystem.controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import deliverySystem.models.admin.RestaurantClass;
import deliverySystem.models.admin.RestaurantEditModel;
import deliverySystem.models.admin.RestaurantModel;
import deliverySystem.views.admin.RestaurantEditView;
import deliverySystem.views.admin.RestaurantView;


public class RestaurantController implements ActionListener {

	private RestaurantModel model;
	private RestaurantView view;

	public RestaurantController(RestaurantModel model, RestaurantView view) {

		this.model = model;
		this.view = view;

//		the text fields of the group
		view.getTxt_restaurantname().addActionListener(this);
		view.getTxt_restaurantaddress().addActionListener(this);
		view.getTxtphonenum().addActionListener(this);
		view.getTxtdeliveryarea().addActionListener(this);
		view.getDeliveryAreaList();
		view.getListModel();
//		all the combo box based on each day open and close
		view.getComboBoxSU1().addActionListener(this);
		view.getComboBoxSU2().addActionListener(this);
		view.getComboBoxSU3().addActionListener(this);
		view.getComboBoxSU4().addActionListener(this);
		view.getComboBoxMO1().addActionListener(this);
		view.getComboBoxMO2().addActionListener(this);
		view.getComboBoxMO3().addActionListener(this);
		view.getComboBoxMO4().addActionListener(this);
		view.getComboBoxTU1().addActionListener(this);
		view.getComboBoxTU2().addActionListener(this);
		view.getComboBoxTU3().addActionListener(this);
		view.getComboBoxTU4().addActionListener(this);
		view.getComboBoxWE1().addActionListener(this);
		view.getComboBoxWE2().addActionListener(this);
		view.getComboBoxWE3().addActionListener(this);
		view.getComboBoxWE4().addActionListener(this);
		view.getComboBoxTH1().addActionListener(this);
		view.getComboBoxTH2().addActionListener(this);
		view.getComboBoxTH3().addActionListener(this);
		view.getComboBoxTH4().addActionListener(this);
		view.getComboBoxFR1().addActionListener(this);
		view.getComboBoxFR2().addActionListener(this);
		view.getComboBoxFR3().addActionListener(this);
		view.getComboBoxFR4().addActionListener(this);
		view.getComboBoxSA1().addActionListener(this);
		view.getComboBoxSA2().addActionListener(this);
		view.getComboBoxSA3().addActionListener(this);
		view.getComboBoxSA4().addActionListener(this);
//		all the buttons
		view.getBtnSave().addActionListener(this);
		view.getBtnmodifytimes().addActionListener(this);
		view.getBtnAddDeliveryArea().addActionListener(this);
		view.getBtnDeleteDeliveryArea().addActionListener(this);

//		menu bar
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
//		restaurantaur
		view.getTxt_username().addActionListener(this);
		view.getTxt_password().addActionListener(this);
		view.getTxt_confrimpass().addActionListener(this);

// Key listeners to make sure no numbers are used for the restaurant name
		view.getTxt_restaurantname().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (!Character.isAlphabetic(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		view.getTxtphonenum().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//verify restaurantaur username
//				if(e.getSource() ==  view.getBtnVerifyUser()) {
//					System.out.println("hello");
//					String username = view.getTxt_username().getText();
//					model.checkUsernameExists(username);
					
					
					
//				}
//		Add delivery area button
		if (e.getSource() == view.getBtnAddDeliveryArea()) {
			adddeliveryarea();
		}
		if (e.getSource() == view.getBtnDeleteDeliveryArea()) {
			deletedeliveryarea();
		}
//		the quit function for the menu
		if (e.getSource() == view.getMntmFileQuit()) {
			quit();
		}
		if (e.getSource() == view.getBtnmodifytimes()) {
			modifyalltime();
		}
//		menu connection
		if (e.getSource() == view.getMntmRestaurantCreate()) {
			RestaurantView RV;
			RestaurantModel RM;
			RV = new RestaurantView();
			RM = new RestaurantModel();
			new RestaurantController(RM, RV);
			view.dispose();
			RV.setVisible(true);
		}
		if (e.getSource() == view.getMntmRestaurantEdit()) {
			RestaurantEditView REV;
			RestaurantEditModel REM;
			REV = new RestaurantEditView();
			REM = new RestaurantEditModel();
			new RestaurantEditController(REM, REV);
			view.dispose();
			REV.setVisible(true);
		}
		if (e.getSource() == view.getBtnSave()) {
//		this checks to make sure that restaurant name isn't null 
			if (view.getTxt_restaurantname().getText().length() != 0) {
//				this checks to make sure that restaurant name isn't null 
				if (view.getTxt_restaurantaddress().getText().length() != 0) {

//		this checks to make sure that phone number only has 10 digits
					if (view.getTxtphonenum().getText().length() == 10) {
					if(view.getTxt_password().getText().equals(view.getTxt_confrimpass().getText())) {
						
					
//				this checks to make sure the delivery list isn't empty
						if (view.getListModel().getSize() > 0) {
							String array = view.getListModel().toString();
							array = array.replaceAll("[\\[\\]\\(\\)]", "");

							JFrame frame = new JFrame("Save");
							boolean choice = JOptionPane
									.showConfirmDialog(frame,
											"Restaurant name:" + view.getTxt_restaurantname().getText() + '\n'
													+ "Restaurant Address: " + view.getTxt_restaurantaddress().getText()
													+ '\n' + "Telephone Number: " + view.getTxtphonenum().getText()
													+ '\n' + "Sunday: "
													+ String.valueOf(
															view.getComboBoxSU1().getSelectedItem()
																	+ ":" + view.getComboBoxSU2().getSelectedItem()
																	+ " - " + view.getComboBoxSU3().getSelectedItem()
																	+ ":" + view.getComboBoxSU4().getSelectedItem())
													+ '\n' + "Monday: "
													+ String.valueOf(
															view.getComboBoxMO1().getSelectedItem()
																	+ ":" + view.getComboBoxMO2().getSelectedItem()
																	+ " - " + view.getComboBoxMO3().getSelectedItem()
																	+ ":" + view.getComboBoxMO4().getSelectedItem())
													+ '\n' + "Tuesday: "
													+ String.valueOf(view.getComboBoxTU1().getSelectedItem()
															+ ":" + view.getComboBoxTU2().getSelectedItem() + " - "
															+ view.getComboBoxTU3().getSelectedItem() + ":"
															+ view.getComboBoxTU4().getSelectedItem())
													+ '\n' + "Wednesday: "
													+ String.valueOf(
															view.getComboBoxWE1().getSelectedItem()
																	+ ":" + view.getComboBoxWE2().getSelectedItem()
																	+ " - " + view.getComboBoxWE3().getSelectedItem()
																	+ ":" + view.getComboBoxWE4().getSelectedItem())
													+ '\n' + "Thursday: "
													+ String.valueOf(
															view.getComboBoxTH1().getSelectedItem()
																	+ ":" + view.getComboBoxTH2().getSelectedItem()
																	+ " - " + view.getComboBoxTH3().getSelectedItem()
																	+ ":" + view.getComboBoxTH4().getSelectedItem())
													+ '\n' + "Friday: "
													+ String.valueOf(view.getComboBoxFR1().getSelectedItem() + ":"
															+ view.getComboBoxFR2().getSelectedItem() + " - "
															+ view.getComboBoxFR3().getSelectedItem() + ":"
															+ view.getComboBoxFR4().getSelectedItem())
													+ '\n' + "Saturday: "
													+ String.valueOf(view.getComboBoxSA1().getSelectedItem() + ":"
															+ view.getComboBoxSA2().getSelectedItem() + " - "
															+ view.getComboBoxSA3().getSelectedItem() + ":"
															+ view.getComboBoxSA4().getSelectedItem())
													+ '\n' + "Delivery Area: " + String.valueOf(array) + '\n',
											"Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION;
							if (choice == true) {
								// int number = 1;


								
								if (model.checkUsernameExists(view.getTxt_username().getText()) ==  false) {
									RestaurantClass resto = new RestaurantClass(null,
											view.getTxt_restaurantname().getText(),
											view.getTxt_restaurantaddress().getText(), view.getTxtphonenum().getText(),
											String.valueOf(view.getComboBoxSU1().getSelectedItem()),
											String.valueOf(view.getComboBoxSU2().getSelectedItem()),
											String.valueOf(view.getComboBoxSU3().getSelectedItem()),
											String.valueOf(view.getComboBoxSU4().getSelectedItem()),
											String.valueOf(view.getComboBoxMO1().getSelectedItem()),
											String.valueOf(view.getComboBoxMO2().getSelectedItem()),
											String.valueOf(view.getComboBoxMO3().getSelectedItem()),
											String.valueOf(view.getComboBoxMO4().getSelectedItem()),
											String.valueOf(view.getComboBoxTU1().getSelectedItem()),
											String.valueOf(view.getComboBoxTU2().getSelectedItem()),
											String.valueOf(view.getComboBoxTU3().getSelectedItem()),
											String.valueOf(view.getComboBoxTU4().getSelectedItem()),
											String.valueOf(view.getComboBoxWE1().getSelectedItem()),
											String.valueOf(view.getComboBoxWE2().getSelectedItem()),
											String.valueOf(view.getComboBoxWE3().getSelectedItem()),
											String.valueOf(view.getComboBoxWE4().getSelectedItem()),
											String.valueOf(view.getComboBoxTH1().getSelectedItem()),
											String.valueOf(view.getComboBoxTH2().getSelectedItem()),
											String.valueOf(view.getComboBoxTH3().getSelectedItem()),
											String.valueOf(view.getComboBoxTH4().getSelectedItem()),
											String.valueOf(view.getComboBoxFR1().getSelectedItem()),
											String.valueOf(view.getComboBoxFR2().getSelectedItem()),
											String.valueOf(view.getComboBoxFR3().getSelectedItem()),
											String.valueOf(view.getComboBoxFR4().getSelectedItem()),
											String.valueOf(view.getComboBoxSA1().getSelectedItem()),
											String.valueOf(view.getComboBoxSA2().getSelectedItem()),
											String.valueOf(view.getComboBoxSA3().getSelectedItem()),
											String.valueOf(view.getComboBoxSA4().getSelectedItem()), String.valueOf(array),
											null,null);

									model.addRestaurant(resto);
									String phonenum = view.getTxtphonenum().getText();
									String s = model.findRestaurantById(phonenum);

									
									String username = view.getTxt_username().getText();
									String password = view.getTxt_password().getText();
									model.addRestaurateur(s,username,password);
									
									
									view.getTxt_username().setText("");
									view.getTxt_password().setText("");
									view.getTxt_confrimpass().setText("");
									view.getTxt_restaurantname().setText("");
									view.getTxt_restaurantaddress().setText("");
									view.getTxtphonenum().setText("");
									view.getTxtdeliveryarea().setText("");
									view.getComboBoxSU1().setSelectedIndex(0);
									view.getComboBoxSU2().setSelectedIndex(0);
									view.getComboBoxSU3().setSelectedIndex(0);
									view.getComboBoxSU4().setSelectedIndex(0);
									view.getComboBoxMO1().setSelectedIndex(0);
									view.getComboBoxMO2().setSelectedIndex(0);
									view.getComboBoxMO3().setSelectedIndex(0);
									view.getComboBoxMO4().setSelectedIndex(0);
									view.getComboBoxTU1().setSelectedIndex(0);
									view.getComboBoxTU2().setSelectedIndex(0);
									view.getComboBoxTU3().setSelectedIndex(0);
									view.getComboBoxTU4().setSelectedIndex(0);
									view.getComboBoxWE1().setSelectedIndex(0);
									view.getComboBoxWE2().setSelectedIndex(0);
									view.getComboBoxWE3().setSelectedIndex(0);
									view.getComboBoxWE4().setSelectedIndex(0);
									view.getComboBoxTH1().setSelectedIndex(0);
									view.getComboBoxTH2().setSelectedIndex(0);
									view.getComboBoxTH3().setSelectedIndex(0);
									view.getComboBoxTH4().setSelectedIndex(0);
									view.getComboBoxFR1().setSelectedIndex(0);
									view.getComboBoxFR2().setSelectedIndex(0);
									view.getComboBoxFR3().setSelectedIndex(0);
									view.getComboBoxFR4().setSelectedIndex(0);
									view.getComboBoxSA1().setSelectedIndex(0);
									view.getComboBoxSA2().setSelectedIndex(0);
									view.getComboBoxSA3().setSelectedIndex(0);
									view.getComboBoxSA4().setSelectedIndex(0);
									view.getListModel().removeAllElements();
								}else {
									JOptionPane.showMessageDialog(null, "Username already exists",
											"Error", JOptionPane.ERROR_MESSAGE);
								}
								
									
								

							}
							if (choice == false) {

							}
					

						} else {
							JOptionPane.showMessageDialog(null,
									"You must add at least one location to the delivery area", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Password and password confirmation must be the same", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					} else {
						JOptionPane.showMessageDialog(null, "There can only be 10 digits and no special characters",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Restaurant Address cannot be empty", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Restaurant name cannot be empty", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
				
		}

	}

	public void modifyalltime() {
		view.getComboBoxSU1().setSelectedIndex(2);
		view.getComboBoxSU2().setSelectedIndex(30);
		view.getComboBoxSU3().setSelectedIndex(2);
		view.getComboBoxSU4().setSelectedIndex(30);
		view.getComboBoxMO1().setSelectedIndex(2);
		view.getComboBoxMO2().setSelectedIndex(30);
		view.getComboBoxMO3().setSelectedIndex(2);
		view.getComboBoxMO4().setSelectedIndex(30);
		view.getComboBoxTU1().setSelectedIndex(2);
		view.getComboBoxTU2().setSelectedIndex(30);
		view.getComboBoxTU3().setSelectedIndex(2);
		view.getComboBoxTU4().setSelectedIndex(30);
		view.getComboBoxWE1().setSelectedIndex(2);
		view.getComboBoxWE2().setSelectedIndex(30);
		view.getComboBoxWE3().setSelectedIndex(2);
		view.getComboBoxWE4().setSelectedIndex(30);
		view.getComboBoxTH1().setSelectedIndex(2);
		view.getComboBoxTH2().setSelectedIndex(30);
		view.getComboBoxTH3().setSelectedIndex(2);
		view.getComboBoxTH4().setSelectedIndex(30);
		view.getComboBoxFR1().setSelectedIndex(2);
		view.getComboBoxFR2().setSelectedIndex(30);
		view.getComboBoxFR3().setSelectedIndex(2);
		view.getComboBoxFR4().setSelectedIndex(30);
		view.getComboBoxSA1().setSelectedIndex(2);
		view.getComboBoxSA2().setSelectedIndex(30);
		view.getComboBoxSA3().setSelectedIndex(2);
		view.getComboBoxSA4().setSelectedIndex(30);
	}

	public void adddeliveryarea() {
		if (view.getTxtdeliveryarea().getText().matches("^[A-Z][0-9][A-Z]$")) {

			// Implement logic to add delivery area
			String newItem = view.getTxtdeliveryarea().getText();
			if (!newItem.isEmpty()) {
				if (!view.getListModel().contains(newItem)) {
					int confirm = JOptionPane.showConfirmDialog(null, "Add '" + newItem + "' to the list?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						view.getListModel().addElement(newItem);
						view.getTxtdeliveryarea().setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "The area is already added", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please enter an area to add", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "This postal code is invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deletedeliveryarea() {
		int selectedIndex = view.getDeliveryAreaList().getSelectedIndex();
		if (selectedIndex != -1) {
			int confirm = JOptionPane.showConfirmDialog(null,
					"Remove '" + view.getDeliveryAreaList().getSelectedValue() + "' from the list?", "Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				view.getListModel().remove(selectedIndex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select an area to remove", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void quit() {
		JFrame frame = new JFrame("Close");
		if (JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application", "Quit",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

			System.exit(0);

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

}
