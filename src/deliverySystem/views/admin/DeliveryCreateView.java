package deliverySystem.views.admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;

import deliverySystem.models.RoundPanel;
import deliverySystem.views.admin.DeliveryCreateView;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")
public class DeliveryCreateView extends JFrame {

	private JPanel contentPane;
    private JTextField deliveryUserName;
    private JTextField deliveryTelephone;
    private JTextField deliveryPassword;
    private JTextField deliveryAreaInput;
    private JPasswordField deliveryConPassword;
    private JTextField deliveryName;
    private JButton deliveryAddArea;
    private JButton deliveryRemoveArea;
    private JButton checkAvalibity;
    private JCheckBox showPassword;
    private JButton deliveryClearButton;
    private DefaultListModel<String> listModel;
    private JList<String> deliveryAreaList;
    private JButton deliverySaveButton;

    

 
	public DeliveryCreateView() {
		setTitle("New Delivery Man");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 835);
		
	    
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
		
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		
	
		
		
		listModel = new DefaultListModel<>();
		
		ImageIcon icon = new ImageIcon("C:\\Users\\ammal\\Downloads\\delivery-man.png");
        Image image = icon.getImage();

      
       
        Image resizedImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        JPanel panel = new RoundPanel(25);
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(33, 30, 617, 737);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Add new Delivery");
        lblNewLabel.setBounds(210, 27, 210, 27);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1 = new JLabel("User Name");
        lblNewLabel_1.setBounds(53, 135, 100, 14);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        
        JLabel lblNewLabel_1_1 = new JLabel("Telephone Number");
        lblNewLabel_1_1.setBounds(53, 236, 188, 14);
        panel.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        
        JLabel lblNewLabel_1_2 = new JLabel("Delivery Area");
        lblNewLabel_1_2.setBounds(113, 507, 136, 14);
        panel.add(lblNewLabel_1_2);
        lblNewLabel_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        
        JLabel lblNewLabel_1_3 = new JLabel("Password");
        lblNewLabel_1_3.setBounds(53, 309, 100, 14);
        panel.add(lblNewLabel_1_3);
        lblNewLabel_1_3.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        
        JLabel lblNewLabel_1_4 = new JLabel("Confirm Password");
        lblNewLabel_1_4.setBounds(53, 383, 161, 14);
        panel.add(lblNewLabel_1_4);
        lblNewLabel_1_4.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        
        deliveryUserName = new JTextField();
        deliveryUserName.setBounds(53, 160, 223, 30);
        panel.add(deliveryUserName);
        deliveryUserName.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
        deliveryUserName.setColumns(10);
        MaskFormatter formatter;
   		try {
   			formatter = new MaskFormatter("(***)-***-****");
   		 deliveryTelephone = new JFormattedTextField(formatter);
   		} catch (ParseException e) {
   			
   	
   		}
       
        deliveryTelephone.setBounds(53, 261, 223, 30);
        panel.add(deliveryTelephone);
        
           deliveryTelephone.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
           deliveryTelephone.setColumns(10);
           
		deliveryPassword = new JTextField();
		deliveryPassword.setBounds(53, 334, 223, 30);
		panel.add(deliveryPassword);
		deliveryPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		deliveryPassword.setColumns(10);
		
		showPassword = new JCheckBox("Show Password");
		showPassword.setBackground(Color.white);
		showPassword.setBounds(53, 445, 161, 23);
		panel.add(showPassword);
		showPassword.setBackground(new Color(0, 0, 0, 0)); // Transparent background
		
		

			showPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
			deliveryAreaList = new JList<>(listModel);
			deliveryAreaList.setBackground(new Color(204, 204, 204));
			
			deliveryAreaList.setBounds(57, 528, 258, 130);
			panel.add(deliveryAreaList);
			
			deliveryAreaList.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
			
			deliveryAreaInput = new JTextField();
			deliveryAreaInput.setBounds(113, 680, 55, 20);
			panel.add(deliveryAreaInput);
			deliveryAreaInput.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
			deliveryAreaInput.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Area");
			lblNewLabel_2.setBounds(57, 683, 46, 14);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
			
			deliveryAddArea = new JButton("+");
			deliveryAddArea.setBounds(249, 670, 66, 40);
			panel.add(deliveryAddArea);
			
				
					deliveryAddArea.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					// checkAvalibity.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
					 deliveryAddArea.setBackground(Color.decode("#21314F"));
					 deliveryAddArea.setForeground(Color.white);
					 
					  deliveryRemoveArea = new JButton("-");
					  deliveryRemoveArea.setBounds(178, 670, 66, 40);
					  panel.add(deliveryRemoveArea);
					  
					  deliveryRemoveArea.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					  
					  deliveryRemoveArea.setBackground(Color.decode("#21314F"));
					  deliveryRemoveArea.setForeground(Color.white);
					  
					  checkAvalibity = new JButton("Check Avaliabity");
					  checkAvalibity.setBounds(53, 198, 210, 27);
					  panel.add(checkAvalibity);
					  
					  checkAvalibity.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					  
					  
					  
					  
					  
    
					  checkAvalibity.setBackground(Color.decode("#f79372"));
					  
					  checkAvalibity.setForeground(new Color(255, 255, 255));
					  
					          JLabel lblNewLabel_3 = new JLabel("");
					          lblNewLabel_3.setBounds(339, 128, 246, 294);
					          panel.add(lblNewLabel_3);
					          lblNewLabel_3.setIcon(resizedIcon);
					          
					          deliverySaveButton = new JButton("Save ");
					          deliverySaveButton.setBounds(496, 670, 111, 40);
					          panel.add(deliverySaveButton);
					          
					           deliverySaveButton.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					           
					           deliverySaveButton.setBackground(Color.decode("#21314F"));
					           deliverySaveButton.setForeground(Color.white);
					           
					           deliveryClearButton = new JButton("Clear");
					           deliveryClearButton.setBounds(380, 670, 111, 40);
					           panel.add(deliveryClearButton);
					           
					              deliveryClearButton.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					              
					              deliveryClearButton.setBackground(Color.decode("#21314F"));
					              deliveryClearButton.setForeground(Color.white);
					              
					              deliveryConPassword = new JPasswordField();
					              deliveryConPassword.setBounds(53, 408, 223, 30);
					              panel.add(deliveryConPassword);
					              deliveryConPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					              
					              deliveryName = new JTextField();
					              deliveryName.setBounds(53, 90, 223, 30);
					              panel.add(deliveryName);
					              deliveryName.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
					              deliveryName.setColumns(10);
					              
					              JLabel lblNewLabel_1_5 = new JLabel("Name");
					              lblNewLabel_1_5.setBounds(53, 68, 100, 14);
					              panel.add(lblNewLabel_1_5);
					              lblNewLabel_1_5.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
       
	}

	


	public JTextField getDeliveryUserName() {
		return deliveryUserName;
	}


	public void setDeliveryUserName(JTextField deliveryUserName) {
		this.deliveryUserName = deliveryUserName;
	}


	public JTextField getDeliveryTelephone() {
		return deliveryTelephone;
	}


	public void setDeliveryTelephone(JTextField deliveryTelephone) {
		this.deliveryTelephone = deliveryTelephone;
	}


	public JTextField getDeliveryPassword() {
		return deliveryPassword;
	}


	public void setDeliveryPassword(JTextField deliveryPassword) {
		this.deliveryPassword = deliveryPassword;
	}


	public JTextField getDeliveryAreaInput() {
		return deliveryAreaInput;
	}


	public void setDeliveryAreaInput(JTextField deliveryAreaInput) {
		this.deliveryAreaInput = deliveryAreaInput;
	}


	public JPasswordField getDeliveryConPassword() {
		return deliveryConPassword;
	}


	public void setDeliveryConPassword(JPasswordField deliveryConPassword) {
		this.deliveryConPassword = deliveryConPassword;
	}


	public JTextField getDeliveryName() {
		return deliveryName;
	}


	public void setDeliveryName(JTextField deliveryName) {
		this.deliveryName = deliveryName;
	}


	public JButton getDeliveryAddArea() {
		return deliveryAddArea;
	}


	public void setDeliveryAddArea(JButton deliveryAddArea) {
		this.deliveryAddArea = deliveryAddArea;
	}


	public JButton getDeliveryRemoveArea() {
		return deliveryRemoveArea;
	}


	public void setDeliveryRemoveArea(JButton deliveryRemoveArea) {
		this.deliveryRemoveArea = deliveryRemoveArea;
	}


	public JButton getCheckAvalibity() {
		return checkAvalibity;
	}


	public void setCheckAvalibity(JButton checkAvalibity) {
		this.checkAvalibity = checkAvalibity;
	}


	public JCheckBox getShowPassword() {
		return showPassword;
	}


	public void setShowPassword(JCheckBox showPassword) {
		this.showPassword = showPassword;
	}


	public JButton getDeliveryClearButton() {
		return deliveryClearButton;
	}


	public void setDeliveryClearButton(JButton deliveryClearButton) {
		this.deliveryClearButton = deliveryClearButton;
	}


	public DefaultListModel<String> getListModel() {
		return listModel;
	}


	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}


	public JList<String> getDeliveryAreaList() {
		
		return deliveryAreaList;
	}

//	public String AreaList() {
//	    String selectedArea = deliveryAreaList.getSelectedValue();
//	    if (selectedArea != null) {
//	        return selectedArea;
//	    } else {
//	        // If no item is selected, you might want to inform the user or handle it accordingly.
//	        JOptionPane.showMessageDialog(null, "Please select an area from the list.");
//	        return null; // Or you can return an empty string or handle it differently based on your application logic.
//	    }
//	}

	public void setDeliveryAreaList(JList<String> deliveryAreaList) {
		this.deliveryAreaList = deliveryAreaList;
	}


	public JButton getDeliverySaveButton() {
		return deliverySaveButton;
	}


	public void setDeliverySaveButton(JButton deliverySaveButton) {
		this.deliverySaveButton = deliverySaveButton;
	}
}
