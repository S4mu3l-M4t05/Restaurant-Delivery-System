package deliverySystem.views.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class createmanagerView extends JFrame {

	private JTextField txt_username = new JTextField();
	private JTextField txt_password = new JTextField();
	private JButton btnSave = new JButton("Save");
	private JPanel panel;
	private JTextField txt_confirmpassword = new JTextField();
	private DefaultListModel<String> listModelresto = new DefaultListModel<>();
	private JList listrestaurant = new JList(listModelresto);
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmFileDisconnect = new JMenuItem("Disconnect");
	private JMenuItem mntmFileQuit = new JMenuItem("Quit");
	private JMenu mnRestaurant = new JMenu("Restaurant");
	private JMenuItem mntmRestaurantCreate = new JMenuItem("Create");
	private JMenuItem mntmRestaurantEdit = new JMenuItem("Edit");
	private JMenu mnMenu = new JMenu("Menu");
	private JMenuItem mntmMenuCreate = new JMenuItem("Create");
	private JMenuItem mntmMenuEdit = new JMenuItem("Edit");
	private JMenuItem mntmMenuDelete = new JMenuItem("Delete");
	private JMenu mnDeliveryMan = new JMenu("Delivery Man");
	private JMenuItem mntmCreateDeliveryGuy = new JMenuItem("Create");
	private JMenuItem mntmEditDeliveryGuy = new JMenuItem("Edit");
	private JMenuItem mntmDeleteDeliveryGuy = new JMenuItem("Delete");
	private final JMenu mnManager = new JMenu("Manager");
	private final JMenuItem mntmCreateManager = new JMenuItem("Create Manager");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createmanagerView window = new createmanagerView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createmanagerView() {
		setResizable(false);
		getContentPane().setBackground(Color.decode("#28384d"));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Create Restaurant");
		this.setBounds(100, 100, 1121, 481);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
//		this.setBackground(Color.decode("#212f40"));
		
		panel=new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(), Color.decode("#141c26")));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
    	panel.setBounds(34, 52, 1037, 363);
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(439, 79, 102, 29);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCreateManager = new JLabel("Create Manager");
		lblCreateManager.setForeground(new Color(255, 255, 255));
		lblCreateManager.setBounds(551, 23, 252, 29);
		panel.add(lblCreateManager);
		lblCreateManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateManager.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(439, 128, 102, 29);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		txt_username.setBounds(551, 85, 243, 20);
		panel.add(txt_username);
		txt_username.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
		
		txt_username.setForeground(new Color(0, 0, 0));
		txt_username.setColumns(10);
		txt_password.setBounds(551, 134, 243, 20);
		panel.add(txt_password);
		txt_password.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		
	
		txt_password.setColumns(10);
		btnSave.setEnabled(false);
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setForeground(Color.decode("#212f40"));
		btnSave.setBounds(596, 225, 119, 38);
		panel.add(btnSave);
		
		btnSave.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 12));
		
		txt_confirmpassword = new JTextField();
		txt_confirmpassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 11));
		txt_confirmpassword.setColumns(10);
		txt_confirmpassword.setBounds(551, 180, 243, 20);
		panel.add(txt_confirmpassword);
		
		JLabel lblPasswordConfirmation = new JLabel("Password Confirmation:");
		lblPasswordConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordConfirmation.setForeground(Color.WHITE);
		lblPasswordConfirmation.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 17));
		lblPasswordConfirmation.setBounds(288, 174, 275, 29);
		panel.add(lblPasswordConfirmation);
		
	
		listrestaurant.setBounds(33, 51, 264, 288);
		panel.add(listrestaurant);
		
		JLabel lbrestaurant = new JLabel("Restaurant");
		lbrestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lbrestaurant.setForeground(Color.WHITE);
		lbrestaurant.setFont(new Font("JetBrains Mono NL SemiBold", Font.BOLD, 20));
		lbrestaurant.setBounds(45, 11, 252, 29);
		panel.add(lbrestaurant);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1105, 22);
		getContentPane().add(menuBar);
		
	
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
	
		mntmFileDisconnect.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmFileDisconnect);
		
		
		mntmFileQuit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmFileQuit);
		

		mnRestaurant.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRestaurant);
		
		
		mntmRestaurantCreate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRestaurant.add(mntmRestaurantCreate);
		
	
		mntmRestaurantEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRestaurant.add(mntmRestaurantEdit);
		
	
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnMenu);
		

		mntmMenuCreate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnMenu.add(mntmMenuCreate);
		

		mntmMenuEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnMenu.add(mntmMenuEdit);
		
	
		mntmMenuDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnMenu.add(mntmMenuDelete);
		
		
		mnDeliveryMan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnDeliveryMan);
		

		mntmCreateDeliveryGuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDeliveryMan.add(mntmCreateDeliveryGuy);
		
		
		mntmEditDeliveryGuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDeliveryMan.add(mntmEditDeliveryGuy);
		
		
		mntmDeleteDeliveryGuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDeliveryMan.add(mntmDeleteDeliveryGuy);
		
	
		
		mnManager.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		menuBar.add(mnManager);
		mntmCreateManager.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		mnManager.add(mntmCreateManager);
		
	
	
		
		
	
	}




	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * @return the mnFile
	 */
	public JMenu getMnFile() {
		return mnFile;
	}

	/**
	 * @param mnFile the mnFile to set
	 */
	public void setMnFile(JMenu mnFile) {
		this.mnFile = mnFile;
	}

	/**
	 * @return the mntmFileDisconnect
	 */
	public JMenuItem getMntmFileDisconnect() {
		return mntmFileDisconnect;
	}

	/**
	 * @param mntmFileDisconnect the mntmFileDisconnect to set
	 */
	public void setMntmFileDisconnect(JMenuItem mntmFileDisconnect) {
		this.mntmFileDisconnect = mntmFileDisconnect;
	}

	/**
	 * @return the mntmFileQuit
	 */
	public JMenuItem getMntmFileQuit() {
		return mntmFileQuit;
	}

	/**
	 * @param mntmFileQuit the mntmFileQuit to set
	 */
	public void setMntmFileQuit(JMenuItem mntmFileQuit) {
		this.mntmFileQuit = mntmFileQuit;
	}

	/**
	 * @return the mnRestaurant
	 */
	public JMenu getMnRestaurant() {
		return mnRestaurant;
	}

	/**
	 * @param mnRestaurant the mnRestaurant to set
	 */
	public void setMnRestaurant(JMenu mnRestaurant) {
		this.mnRestaurant = mnRestaurant;
	}

	/**
	 * @return the mntmRestaurantCreate
	 */
	public JMenuItem getMntmRestaurantCreate() {
		return mntmRestaurantCreate;
	}

	/**
	 * @param mntmRestaurantCreate the mntmRestaurantCreate to set
	 */
	public void setMntmRestaurantCreate(JMenuItem mntmRestaurantCreate) {
		this.mntmRestaurantCreate = mntmRestaurantCreate;
	}

	/**
	 * @return the mntmRestaurantEdit
	 */
	public JMenuItem getMntmRestaurantEdit() {
		return mntmRestaurantEdit;
	}

	/**
	 * @param mntmRestaurantEdit the mntmRestaurantEdit to set
	 */
	public void setMntmRestaurantEdit(JMenuItem mntmRestaurantEdit) {
		this.mntmRestaurantEdit = mntmRestaurantEdit;
	}

	/**
	 * @return the mnMenu
	 */
	public JMenu getMnMenu() {
		return mnMenu;
	}

	/**
	 * @param mnMenu the mnMenu to set
	 */
	public void setMnMenu(JMenu mnMenu) {
		this.mnMenu = mnMenu;
	}

	/**
	 * @return the mntmMenuCreate
	 */
	public JMenuItem getMntmMenuCreate() {
		return mntmMenuCreate;
	}

	/**
	 * @param mntmMenuCreate the mntmMenuCreate to set
	 */
	public void setMntmMenuCreate(JMenuItem mntmMenuCreate) {
		this.mntmMenuCreate = mntmMenuCreate;
	}

	/**
	 * @return the mntmMenuEdit
	 */
	public JMenuItem getMntmMenuEdit() {
		return mntmMenuEdit;
	}

	/**
	 * @param mntmMenuEdit the mntmMenuEdit to set
	 */
	public void setMntmMenuEdit(JMenuItem mntmMenuEdit) {
		this.mntmMenuEdit = mntmMenuEdit;
	}

	/**
	 * @return the mntmMenuDelete
	 */
	public JMenuItem getMntmMenuDelete() {
		return mntmMenuDelete;
	}

	/**
	 * @param mntmMenuDelete the mntmMenuDelete to set
	 */
	public void setMntmMenuDelete(JMenuItem mntmMenuDelete) {
		this.mntmMenuDelete = mntmMenuDelete;
	}

	/**
	 * @return the mnDeliveryMan
	 */
	public JMenu getMnDeliveryMan() {
		return mnDeliveryMan;
	}

	/**
	 * @param mnDeliveryMan the mnDeliveryMan to set
	 */
	public void setMnDeliveryMan(JMenu mnDeliveryMan) {
		this.mnDeliveryMan = mnDeliveryMan;
	}

	/**
	 * @return the mntmCreateDeliveryGuy
	 */
	public JMenuItem getMntmCreateDeliveryGuy() {
		return mntmCreateDeliveryGuy;
	}

	/**
	 * @param mntmCreateDeliveryGuy the mntmCreateDeliveryGuy to set
	 */
	public void setMntmCreateDeliveryGuy(JMenuItem mntmCreateDeliveryGuy) {
		this.mntmCreateDeliveryGuy = mntmCreateDeliveryGuy;
	}

	/**
	 * @return the mntmEditDeliveryGuy
	 */
	public JMenuItem getMntmEditDeliveryGuy() {
		return mntmEditDeliveryGuy;
	}

	/**
	 * @param mntmEditDeliveryGuy the mntmEditDeliveryGuy to set
	 */
	public void setMntmEditDeliveryGuy(JMenuItem mntmEditDeliveryGuy) {
		this.mntmEditDeliveryGuy = mntmEditDeliveryGuy;
	}

	/**
	 * @return the mntmDeleteDeliveryGuy
	 */
	public JMenuItem getMntmDeleteDeliveryGuy() {
		return mntmDeleteDeliveryGuy;
	}

	/**
	 * @param mntmDeleteDeliveryGuy the mntmDeleteDeliveryGuy to set
	 */
	public void setMntmDeleteDeliveryGuy(JMenuItem mntmDeleteDeliveryGuy) {
		this.mntmDeleteDeliveryGuy = mntmDeleteDeliveryGuy;
	}

	/**
	 * @return the mnManager
	 */
	public JMenu getMnManager() {
		return mnManager;
	}

	/**
	 * @return the mntmCreateManager
	 */
	public JMenuItem getMntmCreateManager() {
		return mntmCreateManager;
	}

	/**
	 * @return the listModelresto
	 */
	public DefaultListModel<String> getListModelresto() {
		return listModelresto;
	}

	/**
	 * @param listModelresto the listModelresto to set
	 */
	public void setListModelresto(DefaultListModel<String> listModelresto) {
		this.listModelresto = listModelresto;
	}

	/**
	 * @return the listrestaurant
	 */
	public JList getListrestaurant() {
		return listrestaurant;
	}

	/**
	 * @param listrestaurant the listrestaurant to set
	 */
	public void setListrestaurant(JList listrestaurant) {
		this.listrestaurant = listrestaurant;
	}

	/**
	 * @return the txt_username
	 */
	public JTextField getTxt_username() {
		return txt_username;
	}

	/**
	 * @param txt_username the txt_username to set
	 */
	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}

	/**
	 * @return the txt_password
	 */
	public JTextField getTxt_password() {
		return txt_password;
	}

	/**
	 * @param txt_password the txt_password to set
	 */
	public void setTxt_password(JTextField txt_password) {
		this.txt_password = txt_password;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	/**
	 * @return the txt_confirmpassword
	 */
	public JTextField getTxt_confirmpassword() {
		return txt_confirmpassword;
	}

	/**
	 * @param txt_confirmpassword the txt_confirmpassword to set
	 */
	public void setTxt_confirmpassword(JTextField txt_confirmpassword) {
		this.txt_confirmpassword = txt_confirmpassword;
	}
}
