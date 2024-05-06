package deliverySystem.views.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar AdminMenuBar;
	private JMenu mnFile;
	private JMenu mnRestaurant;
	private JMenu mnMenu;
	private JMenu mnDeliveryMan;
	private JMenuItem mntmDisconnect;
	private JMenuItem mntmQuit;
	private JMenuItem mntmRestaurantCreate;
	private JMenuItem mntmRestaurantEdit;
	private JMenuItem mntmMenuCreate;
	private JMenuItem mntmMenuEdit;
	private JMenuItem mntmDeliverymanCreate;
	private JMenuItem mntmDeliverymanEdit;
	private JMenu mnManager;
	private JMenuItem mntmManagerCreate;

	public AdminView() {
		setTitle("Food Ordering Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		AdminMenuBar = new JMenuBar();
		setJMenuBar(AdminMenuBar);

		mnFile = new JMenu("File");
		AdminMenuBar.add(mnFile);

		mntmDisconnect = new JMenuItem("Disconnect");
		mnFile.add(mntmDisconnect);

		mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);

		mnRestaurant = new JMenu("Restaurant");
		AdminMenuBar.add(mnRestaurant);

		mntmRestaurantCreate = new JMenuItem("Create");
		mnRestaurant.add(mntmRestaurantCreate);

		mntmRestaurantEdit = new JMenuItem("Edit/Delete");
		mnRestaurant.add(mntmRestaurantEdit);

		mnMenu = new JMenu("Menu");
		AdminMenuBar.add(mnMenu);

		mntmMenuCreate = new JMenuItem("Create");
		mnMenu.add(mntmMenuCreate);

		mntmMenuEdit = new JMenuItem("Edit/Delete");
		mnMenu.add(mntmMenuEdit);

		mnDeliveryMan = new JMenu("Delivery Man");
		AdminMenuBar.add(mnDeliveryMan);

		mntmDeliverymanCreate = new JMenuItem("Create");
		mnDeliveryMan.add(mntmDeliverymanCreate);

		mntmDeliverymanEdit = new JMenuItem("Edit/Delete");
		mnDeliveryMan.add(mntmDeliverymanEdit);

		mnManager = new JMenu("Manager");
		AdminMenuBar.add(mnManager);

		mntmManagerCreate = new JMenuItem("Create");
		mnManager.add(mntmManagerCreate);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(),
						Color.decode("#141c26")));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public JMenuItem getMntmDisconnect() {
		return mntmDisconnect;
	}

	public void setMntmDisconnect(JMenuItem mntmDisconnect) {
		this.mntmDisconnect = mntmDisconnect;
	}

	public JMenuItem getMntmQuit() {
		return mntmQuit;
	}

	public void setMntmQuit(JMenuItem mntmQuit) {
		this.mntmQuit = mntmQuit;
	}

	public JMenuItem getMntmRestaurantCreate() {
		return mntmRestaurantCreate;
	}

	public void setMntmRestaurantCreate(JMenuItem mntmRestaurantCreate) {
		this.mntmRestaurantCreate = mntmRestaurantCreate;
	}

	public JMenuItem getMntmRestaurantEdit() {
		return mntmRestaurantEdit;
	}

	public void setMntmRestaurantEdit(JMenuItem mntmRestaurantEdit) {
		this.mntmRestaurantEdit = mntmRestaurantEdit;
	}

	public JMenuItem getMntmMenuCreate() {
		return mntmMenuCreate;
	}

	public void setMntmMenuCreate(JMenuItem mntmMenuCreate) {
		this.mntmMenuCreate = mntmMenuCreate;
	}

	public JMenuItem getMntmMenuEdit() {
		return mntmMenuEdit;
	}

	public void setMntmMenuEdit(JMenuItem mntmMenuEdit) {
		this.mntmMenuEdit = mntmMenuEdit;
	}

	public JMenuItem getMntmDeliverymanCreate() {
		return mntmDeliverymanCreate;
	}

	public void setMntmDeliverymanCreate(JMenuItem mntmDeliverymanCreate) {
		this.mntmDeliverymanCreate = mntmDeliverymanCreate;
	}

	public JMenuItem getMntmDeliverymanEdit() {
		return mntmDeliverymanEdit;
	}

	public void setMntmDeliverymanEdit(JMenuItem mntmDeliverymanEdit) {
		this.mntmDeliverymanEdit = mntmDeliverymanEdit;
	}

	public JMenu getMnManager() {
		return mnManager;
	}

	public void setMnManager(JMenu mnManager) {
		this.mnManager = mnManager;
	}

	public JMenuItem getMntmManagerCreate() {
		return mntmManagerCreate;
	}

	public void setMntmManagerCreate(JMenuItem mntmManagerCreate) {
		this.mntmManagerCreate = mntmManagerCreate;
	}

}
