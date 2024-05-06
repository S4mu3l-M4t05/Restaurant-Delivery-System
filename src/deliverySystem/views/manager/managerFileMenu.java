package deliverySystem.views.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class managerFileMenu extends JFrame {

	JMenuBar menuBar = new JMenuBar();
	JMenu mnFile = new JMenu("File");
	JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
	JMenu mnOrder = new JMenu("Order");
	JMenuItem mntmViewrestaurantOrder = new JMenuItem("View restaurants order");
	JMenu mnNewEdit = new JMenu("Edit");
	JMenuItem mntmRestaurant = new JMenuItem("Restaurant");
	JMenuItem mntmMenu = new JMenuItem("Menu");
	JMenuItem mntmQuit = new JMenuItem("Quit");
	JPanel panel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerFileMenu window = new managerFileMenu();
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
	public managerFileMenu() {
		getContentPane().setBackground(Color.decode("#28384d"));
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Food Ordering Software");
		this.setBounds(100, 100, 898, 611);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setJMenuBar(menuBar);
		
	
		mnFile.setForeground(new Color(0, 0, 0));
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
		mntmDisconnect.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDisconnect.setForeground(new Color(0, 0, 0));
		mnFile.add(mntmDisconnect);
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		mnFile.add(mntmQuit);
		
	
		mnNewEdit.setForeground(new Color(0, 0, 0));
		mnNewEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewEdit);
		
		mntmRestaurant.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmRestaurant);
	
		mntmMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewEdit.add(mntmMenu);
		
	
		mnOrder.setForeground(new Color(0, 0, 0));
		mnOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnOrder);
		mntmViewrestaurantOrder.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		
		mnOrder.add(mntmViewrestaurantOrder);
		this.getContentPane().setLayout(null);
		
	
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
        panel.setBounds(30, 27, 821, 491);
		getContentPane().add(panel);
		
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
	 * @return the mntmNewMenuItem
	 */
	public JMenuItem getMntmNewMenuItem() {
		return mntmDisconnect;
	}

	/**
	 * @param mntmNewMenuItem the mntmNewMenuItem to set
	 */
	public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
		this.mntmDisconnect = mntmNewMenuItem;
	}

	/**
	 * @return the mnOrder
	 */
	public JMenu getMnOrder() {
		return mnOrder;
	}

	/**
	 * @param mnOrder the mnOrder to set
	 */
	public void setMnOrder(JMenu mnOrder) {
		this.mnOrder = mnOrder;
	}

	/**
	 * @return the mntmViewrestaurantOrder
	 */
	public JMenuItem getMntmViewrestaurantOrder() {
		return mntmViewrestaurantOrder;
	}

	/**
	 * @param mntmViewrestaurantOrder the mntmViewrestaurantOrder to set
	 */
	public void setMntmViewrestaurantOrder(JMenuItem mntmViewrestaurantOrder) {
		this.mntmViewrestaurantOrder = mntmViewrestaurantOrder;
	}

	/**
	 * @return the mnNewEdit
	 */
	public JMenu getMnNewEdit() {
		return mnNewEdit;
	}

	/**
	 * @param mnNewEdit the mnNewEdit to set
	 */
	public void setMnNewEdit(JMenu mnNewEdit) {
		this.mnNewEdit = mnNewEdit;
	}

	/**
	 * @return the mntmRestaurant
	 */
	public JMenuItem getMntmRestaurant() {
		return mntmRestaurant;
	}

	/**
	 * @param mntmRestaurant the mntmRestaurant to set
	 */
	public void setMntmRestaurant(JMenuItem mntmRestaurant) {
		this.mntmRestaurant = mntmRestaurant;
	}

	/**
	 * @return the mntmMenu
	 */
	public JMenuItem getMntmMenu() {
		return mntmMenu;
	}

	/**
	 * @param mntmMenu the mntmMenu to set
	 */
	public void setMntmMenu(JMenuItem mntmMenu) {
		this.mntmMenu = mntmMenu;
	}

	/**
	 * @return the mntmDisconnect
	 */
	public JMenuItem getMntmDisconnect() {
		return mntmDisconnect;
	}

	/**
	 * @param mntmDisconnect the mntmDisconnect to set
	 */
	public void setMntmDisconnect(JMenuItem mntmDisconnect) {
		this.mntmDisconnect = mntmDisconnect;
	}

	/**
	 * @return the mntmQuit
	 */
	public JMenuItem getMntmQuit() {
		return mntmQuit;
	}

	/**
	 * @param mntmQuit the mntmQuit to set
	 */
	public void setMntmQuit(JMenuItem mntmQuit) {
		this.mntmQuit = mntmQuit;
	}
}
