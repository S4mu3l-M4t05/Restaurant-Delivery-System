package deliverySystem.controllers.admin;

import deliverySystem.views.admin.DeliveryDeleteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DeliveryDeleteController implements ActionListener {
    private DeliveryDeleteView view;

    public DeliveryDeleteController(DeliveryDeleteView view) {
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {
  
        view.getDeliveryDisable().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            
            if (sourceButton == view.getDeliveryDisable()) {
                handleDisableAction();
            }
        }
    }

 

    private void handleDisableAction() {
        // Implement logic to disable delivery
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to disable the delivery?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Disable the delivery
            JOptionPane.showMessageDialog(null, "Delivery disabled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
