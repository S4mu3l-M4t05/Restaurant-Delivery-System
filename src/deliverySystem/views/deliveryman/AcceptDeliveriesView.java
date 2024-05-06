package deliverySystem.views.deliveryman;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

public class AcceptDeliveriesView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList deliveryList;
    private JButton selectButton;
    private JTextArea deliveryDetailsBox;
    private JButton completeButton;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;
    
    public AcceptDeliveriesView() {
    	setTitle("Delivery Accept Orders Panel");
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 776, 641);
         contentPane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2d = (Graphics2D) g.create();
	                g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(), Color.decode("#141c26")));
	                g2d.fillRect(0, 0, getWidth(), getHeight());
	                g2d.dispose();
	            }
	        };
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         deliveryList = new JList<Object>();
         deliveryList.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
         deliveryList.setBounds(10, 37, 173, 516);
         contentPane.add(deliveryList);
         
         selectButton = new JButton("Select");
         selectButton.setBackground(new Color(255, 255, 255));
         selectButton.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
         selectButton.setBounds(10, 558, 173, 38);
         contentPane.add(selectButton);
         
         JLabel lblNewLabel = new JLabel("Accept Delivery");
         lblNewLabel.setForeground(new Color(255, 255, 255));
         lblNewLabel.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 22));
         lblNewLabel.setBounds(340, 32, 202, 32);
         contentPane.add(lblNewLabel);
         
         JMenuBar menuBar = new JMenuBar();
         menuBar.setBounds(0, 0, 760, 26);
         contentPane.add(menuBar);
         
         JMenu mnNewMenu = new JMenu("File");
         menuBar.add(mnNewMenu);
         
         mntmNewMenuItem = new JMenuItem("Exit");
         mnNewMenu.add(mntmNewMenuItem);
         
         JMenu mnNewMenu_1 = new JMenu("Delivery");
         menuBar.add(mnNewMenu_1);
         
         mntmNewMenuItem_2 = new JMenuItem("Accept Deliveries");
         mntmNewMenuItem_2.setEnabled(false);
         mnNewMenu_1.add(mntmNewMenuItem_2);
         
         mntmNewMenuItem_3 = new JMenuItem("End Deliveries");
         mnNewMenu_1.add(mntmNewMenuItem_3);
         
         JPanel panel = new JPanel();
         panel.setBackground(Color.decode("#28384d"));
         panel.setBounds(214, 80, 484, 332);
         contentPane.add(panel);
         panel.setLayout(null);
         
         deliveryDetailsBox = new JTextArea();
         deliveryDetailsBox.setBounds(23, 29, 439, 240);
         panel.add(deliveryDetailsBox);
         deliveryDetailsBox.setEditable(false);
         deliveryDetailsBox.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
         
         completeButton = new JButton("Accept");
         completeButton.setBackground(new Color(255, 255, 255));
         completeButton.setBounds(177, 283, 106, 38);
         panel.add(completeButton);
         completeButton.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
    }

   

	  public JMenuItem getMntmNewMenuItem() {
	        return mntmNewMenuItem;
	    }

	    

	    public JMenuItem getMntmNewMenuItem_2() {
	        return mntmNewMenuItem_2;
	    }

	    public JMenuItem getMntmNewMenuItem_3() {
	        return mntmNewMenuItem_3;
	    }



		public JList getDeliveryList() {
			return deliveryList;
		}



		public void setDeliveryList(JList<Object> deliveryList) {
			this.deliveryList = deliveryList;
		}



		public JButton getSelectButton() {
			return selectButton;
		}



		public void setSelectButton(JButton selectButton) {
			this.selectButton = selectButton;
		}



		public JTextArea getDeliveryDetailsBox() {
			return deliveryDetailsBox;
		}



		public void setDeliveryDetailsBox(JTextArea deliveryDetailsBox) {
			this.deliveryDetailsBox = deliveryDetailsBox;
		}



		public JButton getCompleteButton() {
			return completeButton;
		}



		public void setCompleteButton(JButton completeButton) {
			this.completeButton = completeButton;
		}



		public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
			this.mntmNewMenuItem = mntmNewMenuItem;
		}



	



		public void setMntmNewMenuItem_2(JMenuItem mntmNewMenuItem_2) {
			this.mntmNewMenuItem_2 = mntmNewMenuItem_2;
		}



		public void setMntmNewMenuItem_3(JMenuItem mntmNewMenuItem_3) {
			this.mntmNewMenuItem_3 = mntmNewMenuItem_3;
		}
}
