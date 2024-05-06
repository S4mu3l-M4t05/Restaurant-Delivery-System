package deliverySystem.views.admin;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.ParseException;

import javax.print.attribute.AttributeSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeliveryEditView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField deliveryName;
	private JTextField deliveryAreaInput;
	private JTextField deliveryTelephone;
	private JTextField deliveryTelephone_1;
	private DefaultListModel<String> listModel;
	private DefaultListModel<String> deliveryUsersModel;
	
	private JList<String> deliveryList;
	private JList<String> deliveryAreaList;

	
	private JButton deliveryClear;
	private JButton deliverySave;
	private JButton deliveryAddArea;
	private JButton deliveryRemoveArea;
	private JButton deliveryActivation;
	private JPanel panel;


	public DeliveryEditView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 731);
		contentPane  = new JPanel() {
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
		
		
	     deliveryUsersModel = new DefaultListModel<>();
		 deliveryList = new JList<>(deliveryUsersModel);
		 deliveryList.setBackground(new Color(255, 255, 255));
	
	
		
		
		
	
		deliveryList.setBounds(10, 24, 199, 661);
		contentPane.add(deliveryList);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\ammal\\Downloads\\delivery-man (1).png");
        Image image = icon.getImage();

		Image resizedImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
		
		 deliveryTelephone = new JFormattedTextField((AbstractFormatter) null);
		
		
		listModel = new DefaultListModel<>();
		
		panel = new JPanel();
		panel.setBackground(Color.decode("#28384d"));
		panel.setBounds(218, 24, 484, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		deliveryName = new JTextField();
		deliveryName.setBounds(30, 103, 223, 30);
		panel.add(deliveryName);
		deliveryName.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		deliveryName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(30, 78, 100, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1 = new JLabel("Telephone Number");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(30, 156, 187, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		 MaskFormatter formatter;
			try {
				formatter = new MaskFormatter("(***)-***-****");
				deliveryTelephone = new JFormattedTextField(formatter);
			} catch (ParseException e) {
				
		
			}
		
		deliveryTelephone.setBounds(30, 181, 223, 30);
		panel.add(deliveryTelephone);
		deliveryTelephone.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		deliveryTelephone.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Delivery Area");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(98, 241, 136, 14);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		deliveryAreaList = new JList<>(listModel);
		deliveryAreaList.setBounds(30, 266, 280, 130);
		panel.add(deliveryAreaList);
		deliveryAreaList.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		
		deliveryAreaInput = new JTextField();
		deliveryAreaInput.setBounds(88, 408, 66, 20);
		panel.add(deliveryAreaInput);
		
				deliveryAreaInput.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				deliveryAreaInput.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Area");
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setBounds(30, 411, 46, 14);
				panel.add(lblNewLabel_2);
				lblNewLabel_2.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				
				 deliveryAddArea = new JButton("Add");
				 deliveryAddArea.setBackground(new Color(255, 255, 255));
				 deliveryAddArea.setBounds(30, 449, 100, 40);
				 panel.add(deliveryAddArea);
				 
				 	deliveryAddArea.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				 	
				 	deliveryRemoveArea = new JButton("Remove");
				 	deliveryRemoveArea.setBackground(new Color(255, 255, 255));
				 	deliveryRemoveArea.setBounds(140, 449, 100, 40);
				 	panel.add(deliveryRemoveArea);
				 	
				 	
				 	deliveryRemoveArea.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				 	
				 	 deliveryActivation = new JButton("Active");
				 	 deliveryActivation.setBackground(new Color(255, 255, 255));
				 	 deliveryActivation.setBounds(30, 610, 136, 40);
				 	 panel.add(deliveryActivation);
				 	 deliveryActivation.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				 	 
				 	 deliveryClear = new JButton("Clear");
				 	 deliveryClear.setBackground(new Color(255, 255, 255));
				 	 deliveryClear.setBounds(174, 610, 136, 40);
				 	 panel.add(deliveryClear);
				 	 deliveryClear.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				 	 
				 	 deliverySave = new JButton("Update");
				 	 deliverySave.setBackground(new Color(255, 255, 255));
				 	 deliverySave.setBounds(320, 610, 136, 40);
				 	 panel.add(deliverySave);
				 	 deliverySave.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
				 	 
				 	 JLabel lblNewLabel = new JLabel("Edit Delivery");
				 	 lblNewLabel.setBounds(154, 24, 184, 27);
				 	 panel.add(lblNewLabel);
				 	 lblNewLabel.setForeground(new Color(255, 255, 255));
				 	 lblNewLabel.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 23));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	
	public JTextField getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName.setText(deliveryName); 
	}

	public JTextField getDeliveryAreaInput() {
		return deliveryAreaInput;
	}

	public void setDeliveryAreaInput(JTextField deliveryAreaInput) {
		this.deliveryAreaInput = deliveryAreaInput;
	}

	public JTextField getDeliveryTelephone() {
		return deliveryTelephone_1;
	}

	public void setDeliveryTelephone(String deliveryTelephone) {
		this.deliveryTelephone_1.setText(deliveryTelephone);
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public DefaultListModel<String> getDeliveryUsersModel() {
		return deliveryUsersModel;
	}

	public void setDeliveryUsersModel(DefaultListModel<String> deliveryUsersModel) {
		this.deliveryUsersModel = deliveryUsersModel;
	}

	public JList<String> getDeliveryList() {
		return deliveryList;
	}

	public void setDeliveryList(JList<String> deliveryList) {
		this.deliveryList = deliveryList;
	}

	public JList<String> getDeliveryAreaList() {
		return deliveryAreaList;
	}
	
	

	public void setDeliveryAreaList(JList<String> deliveryAreaList) {
		this.deliveryAreaList = deliveryAreaList;
	}

	public JButton getDeliveryClear() {
		return deliveryClear;
	}

	public void setDeliveryClear(JButton deliveryClear) {
		this.deliveryClear = deliveryClear;
	}

	public JButton getDeliverySave() {
		return deliverySave;
	}

	public void setDeliverySave(JButton deliverySave) {
		this.deliverySave = deliverySave;
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


	public JButton getDeliveryActivation() {
		return deliveryActivation;
	}


	public void setDeliveryActivation(JButton deliveryActivation) {
		this.deliveryActivation = deliveryActivation;
	}
	
}
