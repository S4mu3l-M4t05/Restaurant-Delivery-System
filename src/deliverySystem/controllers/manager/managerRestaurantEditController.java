package deliverySystem.controllers.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
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
import deliverySystem.views.LoginView;
import deliverySystem.views.manager.managerMenuEditView;
import deliverySystem.views.manager.managerRestaurantEditView;
import deliverySystem.views.manager.viewRestaurantOrder;

public class managerRestaurantEditController implements ActionListener, ListSelectionListener {
	private managerRestaurantEditModel model;
	private managerRestaurantEditView view;
	private String username;
	String array;

	public managerRestaurantEditController(managerRestaurantEditModel model, managerRestaurantEditView view,
			String username) {
		this.model = model;
		this.view = view;
		this.username = username;
//		the textfields of the group
		view.getTxt_restaurantname().addActionListener(this);
		view.getTxt_restaurantaddress().addActionListener(this);
		view.getTxtphonenum().addActionListener(this);
		view.getTxtdeliveryarea().addActionListener(this);
		view.getDeliveryAreaList();
		view.getListModel();
		view.getRestaurant_list().addListSelectionListener(this);
		view.getListModelresto();
//		all the combobox based on each day open and close
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

//		menubar
		view.getMntmDisconnect().addActionListener(this);
		view.getMntmQuit().addActionListener(this);
		view.getMntmRestaurant().addActionListener(this);
		view.getMntmMenu().addActionListener(this);
		view.getMntmViewrestaurantOrder().addActionListener(this);
		insertData();
		view.getBtnSave().setEnabled(false);
		view.getBtnmodifytimes().setEnabled(false);
		view.getBtnAddDeliveryArea().setEnabled(false);
		view.getBtnDeleteDeliveryArea().setEnabled(false);
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
		if (e.getSource() == view.getMntmQuit()) {
			quit();
		}

		if (e.getSource() == view.getBtnmodifytimes()) {
			modifyalltime();
		}
		if (e.getSource() == view.getBtnAddDeliveryArea()) {
			adddeliveryarea();
		}
		if (e.getSource() == view.getBtnDeleteDeliveryArea()) {
			deletedeliveryarea();
		}
		if (e.getSource() == view.getMntmDisconnect()) {
			view.dispose();
			LoginView view = new LoginView();
			LoginModel model = new LoginModel();
			new LoginController(view, model);
			view.setVisible(true);
		}
		if (e.getSource() == view.getMntmRestaurant()) {
			managerRestaurantEditView managerRestaurantEditView = new managerRestaurantEditView();
			managerRestaurantEditModel managerRestaurantEditModel = new managerRestaurantEditModel();
			new managerRestaurantEditController(managerRestaurantEditModel, managerRestaurantEditView, username);
			view.dispose();
			managerRestaurantEditView.setVisible(true);
		}
		if (e.getSource() == view.getMntmMenu()) {
			managerMenuEditModel managerMenuEditModel = new managerMenuEditModel();
			managerMenuEditView managerMenuEditView = new managerMenuEditView();
			new managerMenuEditController(managerMenuEditModel, managerMenuEditView, username);
			view.dispose();
			managerMenuEditView.setVisible(true);
		}
		if (e.getSource() == view.getMntmViewrestaurantOrder()) {
			viewRestaurantOrder viewRestaurantOrder = new viewRestaurantOrder();
			viewRestaurantOrderModel viewRestaurantOrderModel = new viewRestaurantOrderModel();
			new viewRestaurantOrderController(viewRestaurantOrderModel, viewRestaurantOrder, username);
			view.dispose();
			viewRestaurantOrder.setVisible(true);
		}
		if (e.getSource() == view.getBtnSave()) {
			if (view.getTxt_restaurantname().getText().length() != 0) {
//				this checks to make sure that restuarant name isn't null 
				if (view.getTxt_restaurantaddress().getText().length() != 0) {

//		this checks to make sure that phonenumber only has 10 digits
					if (view.getTxtphonenum().getText().length() == 10) {
//				this checks to make sure the delivery list isn't empty
						if (view.getListModel().getSize() > 0) {
							array = view.getListModel().toString();
							array = array.replaceAll("[\\[\\]\\(\\)]", "");

							JFrame frame = new JFrame("Save");
							boolean choice = JOptionPane
									.showConfirmDialog(frame,
											"Are you sure you want to Update this Restaurant" + '\n'
													+ "Restaurant name:" + view.getTxt_restaurantname().getText() + '\n'
													+ "Restaurant Address: " + view.getTxt_restaurantaddress().getText()
													+ '\n' + "Telephone Number: " + view.getTxtphonenum().getText()
													+ '\n' + "Sunday: "
													+ String.valueOf(
															view.getComboBoxSU1().getSelectedItem()
																	+ ":" + view.getComboBoxSU2().getSelectedItem()
																	+ " - " + view.getComboBoxSU3().getSelectedItem()
																	+ ":" + view.getComboBoxSU4().getSelectedItem())
													+ '\n' + "Monday: "
													+ String.valueOf(view.getComboBoxMO1().getSelectedItem() + ":"
															+ view.getComboBoxMO2().getSelectedItem() + " - "
															+ view.getComboBoxMO3().getSelectedItem() + ":"
															+ view.getComboBoxMO4().getSelectedItem())
													+ '\n' + "Tuesday: "
													+ String.valueOf(
															view.getComboBoxTU1().getSelectedItem()
																	+ ":" + view.getComboBoxTU2().getSelectedItem()
																	+ " - " + view.getComboBoxTU3().getSelectedItem()
																	+ ":" + view.getComboBoxTU4().getSelectedItem())
													+ '\n' + "Wednesday: "
													+ String.valueOf(view.getComboBoxWE1().getSelectedItem() + ":"
															+ view.getComboBoxWE2().getSelectedItem() + " - "
															+ view.getComboBoxWE3().getSelectedItem() + ":"
															+ view.getComboBoxWE4().getSelectedItem())
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
								update();
								view.getListModelresto().clear();
								insertData();
								view.getBtnSave().setEnabled(false);
								view.getBtnmodifytimes().setEnabled(false);
								view.getBtnAddDeliveryArea().setEnabled(false);
								view.getBtnDeleteDeliveryArea().setEnabled(false);
							}
							if (choice == false) {

							}

						} else {
							JOptionPane.showMessageDialog(null,
									"You must add at least one location to the delivery area", "Error",
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (!e.getValueIsAdjusting()) {

			int selectedIndex = view.getRestaurant_list().getSelectedIndex();
//	            JOptionPane.showMessageDialog(null, selectedIndex, "Error", JOptionPane.ERROR_MESSAGE);

			if (selectedIndex != -1) {

				String num = view.getListModelresto().get(selectedIndex);
				String number = num.substring(0, 2);

				RestaurantClass r = model.findRestaurantbyId(number);

				view.getTxt_restaurantname().setText(r.getName());
				view.getTxt_restaurantaddress().setText(r.getAddress());
				view.getTxtphonenum().setText(r.getPhoneNumber());
				view.getComboBoxSU1().setSelectedItem(r.getOpenningHourSU());
				view.getComboBoxSU2().setSelectedItem(r.getOpenningMinSU());
				view.getComboBoxSU3().setSelectedItem(r.getClosingHourSU());
				view.getComboBoxSU4().setSelectedItem(r.getClosingMinSU());
				view.getComboBoxMO1().setSelectedItem(r.getOpenningHourMO());
				view.getComboBoxMO2().setSelectedItem(r.getOpenningMinMO());
				view.getComboBoxMO3().setSelectedItem(r.getClosingHourMO());
				view.getComboBoxMO4().setSelectedItem(r.getClosingMinMO());
				view.getComboBoxTU1().setSelectedItem(r.getOpenningHourTU());
				view.getComboBoxTU2().setSelectedItem(r.getOpenningMinTU());
				view.getComboBoxTU3().setSelectedItem(r.getClosingHourTU());
				view.getComboBoxTU4().setSelectedItem(r.getClosingMinTU());
				view.getComboBoxWE1().setSelectedItem(r.getOpenningHourWE());
				view.getComboBoxWE2().setSelectedItem(r.getOpenningMinWE());
				view.getComboBoxWE3().setSelectedItem(r.getClosingHourWE());
				view.getComboBoxWE4().setSelectedItem(r.getClosingMinWE());
				view.getComboBoxTH1().setSelectedItem(r.getOpenningHourTH());
				view.getComboBoxTH2().setSelectedItem(r.getOpenningMinTH());
				view.getComboBoxTH3().setSelectedItem(r.getClosingHourTH());
				view.getComboBoxTH4().setSelectedItem(r.getClosingMinTH());
				view.getComboBoxFR1().setSelectedItem(r.getOpenningHourFR());
				view.getComboBoxFR2().setSelectedItem(r.getOpenningMinFR());
				view.getComboBoxFR3().setSelectedItem(r.getClosingHourFR());
				view.getComboBoxFR4().setSelectedItem(r.getClosingMinFR());
				view.getComboBoxSA1().setSelectedItem(r.getOpenningHourSA());
				view.getComboBoxSA2().setSelectedItem(r.getOpenningMinSA());
				view.getComboBoxSA3().setSelectedItem(r.getClosingHourSA());
				view.getComboBoxSA4().setSelectedItem(r.getClosingMinSA());
				view.getListModel().clear();
				view.getListModel().addElement(r.getDeliveryArea());

				setDeliveryAreaListFromString(view.getDeliveryAreaList(), r.getDeliveryArea(), view.getListModel());
				view.getListModel();

				view.getBtnSave().setEnabled(true);
				view.getBtnmodifytimes().setEnabled(true);
				view.getBtnAddDeliveryArea().setEnabled(true);
				view.getBtnDeleteDeliveryArea().setEnabled(true);
			}
		}
	}

	public void update() {
		array = view.getListModel().toString();
		array = array.replaceAll("[\\[\\]\\(\\)]", "");
		int selectedIndex = view.getRestaurant_list().getSelectedIndex();
		String num = view.getListModelresto().get(selectedIndex);
		String number = num.substring(0, 2);
		RestaurantClass resto = new RestaurantClass(null, view.getTxt_restaurantname().getText(),
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
				String.valueOf(view.getComboBoxSA4().getSelectedItem()), String.valueOf(array), null, null);

		model.updateRestaurant(resto, number);
		JOptionPane.showMessageDialog(null, "Restaurant has been updated", "Restaurant",
				JOptionPane.INFORMATION_MESSAGE);

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
		view.getDeliveryAreaList().clearSelection();
		view.getListModel().clear();
		view.getDeliveryAreaList().setListData(new String[0]);
	}

	public void quit() {
		JFrame frame = new JFrame("Close");
		if (JOptionPane.showConfirmDialog(frame, "Confirm you want to close the application", "Quit",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

			System.exit(0);

		}

	}

	private void insertData() {
		managerRestaurantEditModel managerRestaurantEditModel = new managerRestaurantEditModel();
		managerRestaurantEditView managerRestaurantEditView = new managerRestaurantEditView();
		managerClass m = model.findManagerbyId(username);
		RestaurantClass r = model.findRestaurantbyId(m.getRestaurant_id());
		List<String> restaurants = managerRestaurantEditModel.getrestaurant(m.getId());
		String[] restaurantArray = restaurants.toArray(new String[0]); // Convert List to array
		for (String restaurant : restaurantArray) {
			view.getListModelresto().addElement(restaurant);
		}
	}

	public void adddeliveryarea() {
		if (view.getTxtdeliveryarea().getText().matches("^[A-Z][0-9][A-Z]$")) {
			String newArea = view.getTxtdeliveryarea().getText();
			if (!newArea.isEmpty()) {
				if (!view.getListModel().contains(newArea)) {
					int choice = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to add this area: " + newArea + "?", "Confirmation",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						view.getListModel().addElement(newArea);
						view.getDeliveryAreaList().setModel(view.getListModel());
						view.getTxtdeliveryarea().setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Area already exists.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please enter an area.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "This postal code is invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deletedeliveryarea() {

		// Implement logic to remove delivery area
		int selectedIndex = view.getDeliveryAreaList().getSelectedIndex();
		if (selectedIndex != -1) {
			int confirm = JOptionPane.showConfirmDialog(null,
					"Remove '" + view.getDeliveryAreaList().getSelectedValue() + "' from the list?", "Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {

				view.getListModel().remove(selectedIndex);
				view.getDeliveryAreaList().setModel(view.getListModel());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select an area to remove", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void setDeliveryAreaListFromString(JList<String> deliveryAreaList, String values,
			DefaultListModel<String> listModel) {
		String[] elements = values.split(", ");
		deliveryAreaList.setListData(elements);

		listModel.clear();
		for (String element : elements) {
			listModel.addElement(element);
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
}
