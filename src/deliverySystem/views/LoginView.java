package deliverySystem.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import deliverySystem.models.RoundPanel;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPane;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnConnect;
	private JButton btnQuit ;
	private JButton btnNewClients;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public LoginView() {
		setTitle("User Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 580);
		
		contentPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(), Color.decode("#141c26")));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        } ;
		  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		mainPane = new RoundPanel(20);
		mainPane.setBackground(new Color(255, 255, 255));
		mainPane.setBounds(46, 47, 373, 449);
	
		contentPane.add(mainPane);
		mainPane.setLayout(null);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		lblUsername.setBounds(35, 103, 97, 14);
		mainPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		txtUsername.setBounds(35, 125, 317, 30);
		mainPane.add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		lblPassword.setBounds(35, 174, 97, 14);
		mainPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		txtPassword.setBounds(35, 199, 317, 30);
		mainPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		 btnConnect = new JButton("Connect");
		 btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		btnConnect.setBounds(129, 294, 111, 37);
		mainPane.add(btnConnect);
		
		 btnNewClients = new JButton("New Clients");
		 btnNewClients.setForeground(new Color(255, 255, 255));
		btnNewClients.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 18));
		btnNewClients.setBounds(105, 342, 156, 37);
		mainPane.add(btnNewClients);
		setContentPane(contentPane);
		
		btnConnect.setBackground(Color.decode("#212f40"));
		btnNewClients.setBackground(Color.decode("#212f40"));
		JLabel lblLoginTitle = new JLabel("Delivery System");
		lblLoginTitle.setBounds(87, 35, 201, 27);
		mainPane.add(lblLoginTitle);
		lblLoginTitle.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 22));
		
		 btnQuit = new JButton("Quit");
		 btnQuit.setBounds(157, 390, 56, 37);
		 mainPane.add(btnQuit);
		 btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnQuit.setVisible(false);
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnConnect() {
		return btnConnect;
	}

	public void setBtnConnect(JButton btnConnect) {
		this.btnConnect = btnConnect;
	}

	public JButton getBtnNewClients() {
		return btnNewClients;
	}

	public void setBtnNewClients(JButton btnNewClients) {
		this.btnNewClients = btnNewClients;
	}
}
