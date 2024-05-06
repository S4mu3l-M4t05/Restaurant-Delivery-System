package deliverySystem.views.deliveryman;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ViewDeliveriesView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<Object> deliveryList;
    private JButton selectButton;
    private JTextArea deliveryDetailsBox;
    private JButton completeButton;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;

    /**
     * Create the frame.
     */
    public ViewDeliveriesView() {
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 776, 641);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         deliveryList = new JList<Object>();
         deliveryList.setFont(new Font("Tahoma", Font.PLAIN, 17));
         deliveryList.setBounds(10, 37, 173, 516);
         contentPane.add(deliveryList);
         
         selectButton = new JButton("Select");
         selectButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
         selectButton.setBounds(10, 558, 173, 38);
         contentPane.add(selectButton);
         
         JLabel lblNewLabel = new JLabel("View Delivery");
         lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
         lblNewLabel.setBounds(359, 41, 112, 32);
         contentPane.add(lblNewLabel);
         
         deliveryDetailsBox = new JTextArea();
         deliveryDetailsBox.setEditable(false);
         deliveryDetailsBox.setFont(new Font("Courier New", Font.PLAIN, 17));
         deliveryDetailsBox.setText("Order : #1\r\nResturant : \r\nDelivery Address : \r\nDelivery Postal Code :");
         deliveryDetailsBox.setBounds(221, 84, 439, 240);
         contentPane.add(deliveryDetailsBox);
         
         completeButton = new JButton(".....");
         completeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
         completeButton.setBounds(375, 338, 106, 38);
         contentPane.add(completeButton);
         
         JMenuBar menuBar = new JMenuBar();
         menuBar.setBounds(0, 0, 760, 26);
         contentPane.add(menuBar);
         
         JMenu mnNewMenu = new JMenu("File");
         menuBar.add(mnNewMenu);
         
         mntmNewMenuItem = new JMenuItem("Exit");
         mnNewMenu.add(mntmNewMenuItem);
         
         JMenu mnNewMenu_1 = new JMenu("Delivery");
         menuBar.add(mnNewMenu_1);
         
         mntmNewMenuItem_1 = new JMenuItem("View Deliveries");
         mntmNewMenuItem_1.setEnabled(false);
         mnNewMenu_1.add(mntmNewMenuItem_1);
         
         mntmNewMenuItem_2 = new JMenuItem("Accept Deliveries");
         mnNewMenu_1.add(mntmNewMenuItem_2);
         
         mntmNewMenuItem_3 = new JMenuItem("End Deliveries");
         mnNewMenu_1.add(mntmNewMenuItem_3);
    }

   

	  public JMenuItem getMntmNewMenuItem() {
	        return mntmNewMenuItem;
	    }

	    public JMenuItem getMntmNewMenuItem_1() {
	        return mntmNewMenuItem_1;
	    }

	    public JMenuItem getMntmNewMenuItem_2() {
	        return mntmNewMenuItem_2;
	    }

	    public JMenuItem getMntmNewMenuItem_3() {
	        return mntmNewMenuItem_3;
	    }
    
}
