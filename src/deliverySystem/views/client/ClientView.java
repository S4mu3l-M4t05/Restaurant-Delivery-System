package deliverySystem.views.client;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnFile;
	private JMenuItem mntmDisconnect;
	private JMenuItem mntmQuit;
	private JMenu mnAccount;
	private JMenuItem mntmEditAccount;
	private JMenuItem mntmCloseAccount;
	private JMenu mnOrder;
	private JMenuItem mntmOrderFood;
	private JMenuItem mntmOrderHistory;

	public ClientView() {
		setTitle("Food Ordering Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmDisconnect = new JMenuItem("Disconnect");
		mnFile.add(mntmDisconnect);

		mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);

		mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);

		mntmEditAccount = new JMenuItem("Edit Account");
		mnAccount.add(mntmEditAccount);

		mntmCloseAccount = new JMenuItem("Close Account");
		mnAccount.add(mntmCloseAccount);

		mnOrder = new JMenu("Order");
		menuBar.add(mnOrder);

		mntmOrderFood = new JMenuItem("Order Food");
		mnOrder.add(mntmOrderFood);

		mntmOrderHistory = new JMenuItem("Order History");
		mnOrder.add(mntmOrderHistory);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 47, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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

	public JMenuItem getMntmEditAccount() {
		return mntmEditAccount;
	}

	public void setMntmEditAccount(JMenuItem mntmEditAccount) {
		this.mntmEditAccount = mntmEditAccount;
	}

	public JMenuItem getMntmCloseAccount() {
		return mntmCloseAccount;
	}

	public void setMntmCloseAccount(JMenuItem mntmCloseAccount) {
		this.mntmCloseAccount = mntmCloseAccount;
	}

	public JMenuItem getMntmOrderFood() {
		return mntmOrderFood;
	}

	public void setMntmOrderFood(JMenuItem mntmOrderFood) {
		this.mntmOrderFood = mntmOrderFood;
	}

	public JMenuItem getMntmOrderHistory() {
		return mntmOrderHistory;
	}

	public void setMntmOrderHistory(JMenuItem mntmOrderHistory) {
		this.mntmOrderHistory = mntmOrderHistory;
	}

}
