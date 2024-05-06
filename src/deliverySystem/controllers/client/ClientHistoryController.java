package deliverySystem.controllers.client;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import deliverySystem.models.client.OrderModel;
import deliverySystem.models.restaurateur.OrdersClass;
import deliverySystem.views.client.ClientHistoryView;

public class ClientHistoryController {
	private final ClientHistoryView view;
	private final OrderModel model;
	private String loggedInUsername;

	public ClientHistoryController(ClientHistoryView view, OrderModel model, String loggedInUsername) {
		this.view = view;
		this.model = model;
		this.loggedInUsername = loggedInUsername;

		view.getListOrders().addListSelectionListener(new OrderSelectionListener());

		displayOrders();
	}

	class OrderSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				OrdersClass selectedOrder = view.getListOrders().getSelectedValue();
				if (selectedOrder != null) {
					String deliveryTime = selectedOrder.getDeliveryTime();
					String[] dateTimeParts = deliveryTime.split(" ");
					if (dateTimeParts.length == 2) {
						String deliveryDate = dateTimeParts[0];
						view.getTxtDeliveryDate().setText(deliveryDate);
					}
					String[] timeParts = dateTimeParts[1].split(":");
					if (timeParts.length == 3) {
						view.getTxtDeliveryTimeHours().setText(timeParts[0]);
						view.getTxtDeliveryTimeMinute().setText(timeParts[1]);
					}
					view.getTxtPostalCode().setText(selectedOrder.getPostalCode());
					view.getListOrder().setListData(selectedOrder.getOrderDetail().split(";"));
				}
			}
		}
	}

	private void displayOrders() {
		List<OrdersClass> orders = model.getClientOrders(loggedInUsername);

		DefaultListModel<OrdersClass> orderListModel = new DefaultListModel<>();
		for (OrdersClass order : orders) {
			orderListModel.addElement(order);
		}
		view.getListOrders().setModel(orderListModel);
	}
}
