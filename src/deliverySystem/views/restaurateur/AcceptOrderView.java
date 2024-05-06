package deliverySystem.views.restaurateur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AcceptOrderView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu orderMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem acceptOrderMenuItem;
    private JMenuItem orderReadyMenuItem;
    private JList list;
    private JButton btnSelect;
    private JButton btnAccept;
    private JTextField deliverydate;
    private JTextField deliveryH;
    private JTextField deliveryPC;
    private JTextField deliveryM;
    private JLabel lblNewLabel;
    private JLabel lblDeliveryTimeddmmyy;
    private JLabel lblDeliveryTime;
    private JLabel lblPostalCode;
    private JLabel lblMealInOrder;
    private JLabel lblH;
    private JLabel lblM;
    private JTextArea Orders;
    private JLabel lblPendingOrders;
    private JPanel panel;

    public AcceptOrderView() {
        setTitle("Accept Order");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 770, 713);
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

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 754, 26);
        contentPane.add(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        orderMenu = new JMenu("Order");
        menuBar.add(orderMenu);

        acceptOrderMenuItem = new JMenuItem("Accept Order");
        acceptOrderMenuItem.setEnabled(false);
        orderMenu.add(acceptOrderMenuItem);

        orderReadyMenuItem = new JMenuItem("Order Ready");
        orderMenu.add(orderReadyMenuItem);

        list = new JList();
        list.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        list.setBounds(10, 85, 200, 520);
        contentPane.add(list);

        btnSelect = new JButton("Select");
        btnSelect.setBackground(new Color(255, 255, 255));
        btnSelect.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        btnSelect.setBounds(10, 616, 200, 40);
        contentPane.add(btnSelect);

        lblNewLabel = new JLabel("Accept Orders");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 22));
        lblNewLabel.setBounds(374, 78, 169, 21);
        contentPane.add(lblNewLabel);

        lblPendingOrders = new JLabel("Pending Orders");
        lblPendingOrders.setForeground(new Color(255, 255, 255));
        lblPendingOrders.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        lblPendingOrders.setBounds(33, 53, 158, 21);
        contentPane.add(lblPendingOrders);
        
        panel = new JPanel();
        panel.setBackground(Color.decode("#28384d"));
        panel.setBounds(238, 109, 450, 469);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblDeliveryTimeddmmyy = new JLabel("Delivery Time(dd/mm/yy)");
        lblDeliveryTimeddmmyy.setForeground(new Color(255, 255, 255));
        lblDeliveryTimeddmmyy.setBounds(23, 22, 240, 21);
        panel.add(lblDeliveryTimeddmmyy);
        lblDeliveryTimeddmmyy.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
                
        deliverydate = new JTextField();
        deliverydate.setBounds(263, 19, 166, 26);
        panel.add(deliverydate);
        deliverydate.setEditable(false);
        deliverydate.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        deliverydate.setColumns(10);
                        
        lblDeliveryTime = new JLabel("Delivery Time");
        lblDeliveryTime.setForeground(new Color(255, 255, 255));
        lblDeliveryTime.setBounds(23, 63, 135, 21);
        panel.add(lblDeliveryTime);
        lblDeliveryTime.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
                                
        lblH = new JLabel("H");
        lblH.setForeground(new Color(255, 255, 255));
        lblH.setBounds(254, 68, 22, 21);
        panel.add(lblH);
        lblH.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
                                       
		   deliveryH = new JTextField();
		    deliveryH.setBounds(283, 63, 41, 26);
		    panel.add(deliveryH);
		    deliveryH.setEditable(false);
		    deliveryH.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		deliveryH.setColumns(10);
                                                
        lblM = new JLabel("M");
        lblM.setForeground(new Color(255, 255, 255));
        lblM.setBounds(356, 66, 22, 21);
        panel.add(lblM);
        lblM.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
                                                        
		deliveryM = new JTextField();
		deliveryM.setBounds(388, 63, 41, 26);
		panel.add(deliveryM);
		deliveryM.setEditable(false);
		deliveryM.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
		deliveryM.setColumns(10);
                                                                
	    deliveryPC = new JTextField();
	    deliveryPC.setBounds(263, 113, 166, 26);
	    panel.add(deliveryPC);
	    deliveryPC.setEditable(false);
	    deliveryPC.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
	    deliveryPC.setColumns(10);

        lblPostalCode = new JLabel("Postal Code");
        lblPostalCode.setForeground(new Color(255, 255, 255));
        lblPostalCode.setBounds(23, 110, 135, 21);
        panel.add(lblPostalCode);
        lblPostalCode.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        
        lblMealInOrder = new JLabel("Meal in order");
        lblMealInOrder.setForeground(new Color(255, 255, 255));
        lblMealInOrder.setBounds(23, 169, 135, 21);
        panel.add(lblMealInOrder);
        lblMealInOrder.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));

        Orders = new JTextArea();
        Orders.setBounds(23, 201, 406, 195);
        panel.add(Orders);
        Orders.setEditable(false);
        Orders.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 17));
        
        btnAccept = new JButton("Accept");
        btnAccept.setBackground(new Color(255, 255, 255));
        btnAccept.setBounds(278, 418, 151, 40);
        panel.add(btnAccept);
        btnAccept.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
}



	

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public JMenu getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(JMenu orderMenu) {
		this.orderMenu = orderMenu;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

	public JMenuItem getAcceptOrderMenuItem() {
		return acceptOrderMenuItem;
	}

	public void setAcceptOrderMenuItem(JMenuItem acceptOrderMenuItem) {
		this.acceptOrderMenuItem = acceptOrderMenuItem;
	}

	public JMenuItem getOrderReadyMenuItem() {
		return orderReadyMenuItem;
	}

	public void setOrderReadyMenuItem(JMenuItem orderReadyMenuItem) {
		this.orderReadyMenuItem = orderReadyMenuItem;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}

	public JTextField getTextField() {
		return deliverydate;
	}

	public void setTextField(JTextField textField) {
		this.deliverydate = textField;
	}

	public JTextField getTextField_1() {
		return deliveryH;
	}

	public void setTextField_1(JTextField textField_1) {
		this.deliveryH = textField_1;
	}

	public JTextField getTextField_2() {
		return deliveryPC;
	}

	public void setTextField_2(JTextField textField_2) {
		this.deliveryPC = textField_2;
	}

	public JTextField getTextField_3() {
		return deliveryM;
	}

	public void setTextField_3(JTextField textField_3) {
		this.deliveryM = textField_3;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblDeliveryTimeddmmyy() {
		return lblDeliveryTimeddmmyy;
	}

	public void setLblDeliveryTimeddmmyy(JLabel lblDeliveryTimeddmmyy) {
		this.lblDeliveryTimeddmmyy = lblDeliveryTimeddmmyy;
	}

	public JLabel getLblDeliveryTime() {
		return lblDeliveryTime;
	}

	public void setLblDeliveryTime(JLabel lblDeliveryTime) {
		this.lblDeliveryTime = lblDeliveryTime;
	}

	public JLabel getLblPostalCode() {
		return lblPostalCode;
	}

	public void setLblPostalCode(JLabel lblPostalCode) {
		this.lblPostalCode = lblPostalCode;
	}

	public JLabel getLblMealInOrder() {
		return lblMealInOrder;
	}

	public void setLblMealInOrder(JLabel lblMealInOrder) {
		this.lblMealInOrder = lblMealInOrder;
	}

	public JLabel getLblH() {
		return lblH;
	}

	public void setLblH(JLabel lblH) {
		this.lblH = lblH;
	}

	public JLabel getLblM() {
		return lblM;
	}

	public void setLblM(JLabel lblM) {
		this.lblM = lblM;
	}

	public JTextArea getTxtrPizzaCola() {
		return Orders;
	}

	public void setTxtrPizzaCola(JTextArea txtrPizzaCola) {
		this.Orders = txtrPizzaCola;
	}

	public JLabel getLblPendingOrders() {
		return lblPendingOrders;
	}

	public void setLblPendingOrders(JLabel lblPendingOrders) {
		this.lblPendingOrders = lblPendingOrders;
	}

	public JTextField getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(JTextField deliverydate) {
		this.deliverydate = deliverydate;
	}

	public JTextField getDeliveryH() {
		return deliveryH;
	}

	public void setDeliveryH(JTextField deliveryH) {
		this.deliveryH = deliveryH;
	}

	public JTextField getDeliveryPC() {
		return deliveryPC;
	}

	public void setDeliveryPC(JTextField deliveryPC) {
		this.deliveryPC = deliveryPC;
	}

	public JTextField getDeliveryM() {
		return deliveryM;
	}

	public void setDeliveryM(JTextField deliveryM) {
		this.deliveryM = deliveryM;
	}

	public JTextArea getOrders() {
		return Orders;
	}

	public void setOrders(JTextArea orders) {
		Orders = orders;
	}

	
	
    
}