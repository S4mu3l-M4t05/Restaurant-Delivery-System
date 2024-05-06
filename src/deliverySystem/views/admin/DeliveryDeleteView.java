package deliverySystem.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeliveryDeleteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField deliveryName;
	private JTextField deliveryAreaInput;
	private JTextField deliveryTelephone;
	private DefaultListModel<String> listModel;
	private DefaultListModel<String> deliveryUsersModel;
	
	private JList<String> deliveryList;
	private JList<String> deliveryAreaList;

	
	private JButton deliveryClear;
	private JButton deliverySave;
	private JButton deliveryAddArea;
	private JButton deliveryRemoveArea;
	private JButton deliveryDisable;
	private JPanel panel;
	
	public DeliveryDeleteView() {
		setTitle("Delete Delivery Man");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 651);
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
		
	    deliveryList = new JList<String>();
	    deliveryList.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		deliveryList.setBounds(10, 24, 199, 574);
		contentPane.add(deliveryList);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\ammal\\Downloads\\delivery-man (1).png");
        Image image = icon.getImage();

		Image resizedImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		panel = new JPanel();
		panel.setBounds(229, 24, 442, 574);
		contentPane.add(panel);
		panel.setLayout(null);
		JList<String> deliveryAreaList_1 = new JList<>(listModel);
		deliveryAreaList_1.setBounds(40, 276, 280, 130);
		panel.add(deliveryAreaList_1);
		deliveryAreaList_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		deliveryAreaList_1.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Delete Delivery");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(123, 21, 210, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 101, 100, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		
		deliveryName = new JTextField();
		deliveryName.setBounds(40, 126, 223, 27);
		panel.add(deliveryName);
		deliveryName.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		deliveryName.setColumns(10);
		
		deliveryName.setEnabled(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telephone Number");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(40, 176, 184, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		
		deliveryTelephone = new JFormattedTextField((AbstractFormatter) null);
		deliveryTelephone.setBounds(40, 201, 223, 27);
		panel.add(deliveryTelephone);
		deliveryTelephone.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		deliveryTelephone.setColumns(10);
		deliveryTelephone.setEnabled(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Delivery Area");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(40, 252, 145, 14);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		
		deliveryDisable = new JButton("Disable");
		deliveryDisable.setBackground(new Color(255, 255, 255));
		deliveryDisable.setBounds(285, 523, 136, 40);
		panel.add(deliveryDisable);
		deliveryDisable.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		panel.setBackground(Color.decode("#28384d"));
	}

	public JTextField getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(JTextField deliveryName) {
		this.deliveryName = deliveryName;
	}

	public JTextField getDeliveryAreaInput() {
		return deliveryAreaInput;
	}

	public void setDeliveryAreaInput(JTextField deliveryAreaInput) {
		this.deliveryAreaInput = deliveryAreaInput;
	}

	public JTextField getDeliveryTelephone() {
		return deliveryTelephone;
	}

	public void setDeliveryTelephone(JTextField deliveryTelephone) {
		this.deliveryTelephone = deliveryTelephone;
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

	public JButton getDeliveryDisable() {
		return deliveryDisable;
	}

	public void setDeliveryDisable(JButton deliveryDisable) {
		this.deliveryDisable = deliveryDisable;
	}
 
}
