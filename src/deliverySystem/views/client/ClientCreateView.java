package deliverySystem.views.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientCreateView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtAreaCode;
	private JTextField txtPhonePrefix;
	private JTextField txtLineNumber;
	private JPanel headPane;
	private JLabel lbltitle;
	private JPanel mainPane;
	private JPanel formPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JPanel PhoneNumberPane;
	private JButton btnVerify;
	private JPanel footPane;
	private JButton btnSave;

	public ClientCreateView() {
		setType(Type.POPUP);
		setTitle("New Client Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 47, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		headPane = new JPanel();
		headPane.setBackground(new Color(33, 47, 64));
		contentPane.add(headPane, BorderLayout.NORTH);

		lbltitle = new JLabel("Open New Account");
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setFont(new Font("Dialog", Font.PLAIN, 25));
		headPane.add(lbltitle);

		mainPane = new JPanel();
		mainPane.setBackground(new Color(33, 47, 64));
		contentPane.add(mainPane, BorderLayout.CENTER);
		mainPane.setLayout(null);

		formPane = new JPanel();
		formPane.setBackground(new Color(255, 255, 255));
		formPane.setBounds(45, 11, 331, 394);
		mainPane.add(formPane);
		GridBagLayout gbl_formPane = new GridBagLayout();
		gbl_formPane.columnWidths = new int[] { 165, 165, 0 };
		gbl_formPane.rowHeights = new int[] { 49, 49, 49, 49, 49, 49, 49, 49, 0 };
		gbl_formPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_formPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		formPane.setLayout(gbl_formPane);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.BOTH;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		formPane.add(lblUsername, gbc_lblUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		formPane.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		formPane.add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		formPane.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.fill = GridBagConstraints.BOTH;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 0;
		gbc_lblConfirmPassword.gridy = 2;
		formPane.add(lblConfirmPassword, gbc_lblConfirmPassword);

		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtConfirmPassword = new GridBagConstraints();
		gbc_txtConfirmPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConfirmPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtConfirmPassword.gridx = 1;
		gbc_txtConfirmPassword.gridy = 2;
		formPane.add(txtConfirmPassword, gbc_txtConfirmPassword);
		txtConfirmPassword.setColumns(10);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.BOTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 3;
		formPane.add(lblLastName, gbc_lblLastName);

		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.gridx = 1;
		gbc_txtLastName.gridy = 3;
		formPane.add(txtLastName, gbc_txtLastName);
		txtLastName.setColumns(10);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.BOTH;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 4;
		formPane.add(lblFirstName, gbc_lblFirstName);

		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstName.gridx = 1;
		gbc_txtFirstName.gridy = 4;
		formPane.add(txtFirstName, gbc_txtFirstName);
		txtFirstName.setColumns(10);

		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.BOTH;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 5;
		formPane.add(lblAddress, gbc_lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddress.gridx = 1;
		gbc_txtAddress.gridy = 5;
		formPane.add(txtAddress, gbc_txtAddress);
		txtAddress.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		formPane.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		formPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Dialog", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 7;
		formPane.add(lblPhone, gbc_lblPhone);

		PhoneNumberPane = new JPanel();
		PhoneNumberPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_PhoneNumberPane = new GridBagConstraints();
		gbc_PhoneNumberPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_PhoneNumberPane.gridx = 1;
		gbc_PhoneNumberPane.gridy = 7;
		formPane.add(PhoneNumberPane, gbc_PhoneNumberPane);
		PhoneNumberPane.setLayout(new BoxLayout(PhoneNumberPane, BoxLayout.X_AXIS));

		JLabel lblNewLabel_9 = new JLabel(" ( ");
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		PhoneNumberPane.add(lblNewLabel_9);

		txtAreaCode = new JTextField();
		txtAreaCode.setFont(new Font("Dialog", Font.PLAIN, 14));
		PhoneNumberPane.add(txtAreaCode);
		txtAreaCode.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel(" ) ");
		lblNewLabel_10.setBackground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		PhoneNumberPane.add(lblNewLabel_10);

		txtPhonePrefix = new JTextField();
		txtPhonePrefix.setFont(new Font("Dialog", Font.PLAIN, 14));
		PhoneNumberPane.add(txtPhonePrefix);
		txtPhonePrefix.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel(" . ");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		PhoneNumberPane.add(lblNewLabel_11);

		txtLineNumber = new JTextField();
		txtLineNumber.setFont(new Font("Dialog", Font.PLAIN, 14));
		PhoneNumberPane.add(txtLineNumber);
		txtLineNumber.setColumns(10);

		btnVerify = new JButton("Verify");
		btnVerify.setBackground(new Color(255, 255, 255));
		btnVerify.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVerify.setBounds(386, 18, 78, 27);
		mainPane.add(btnVerify);

		footPane = new JPanel();
		footPane.setBackground(new Color(33, 47, 64));
		FlowLayout fl_footPane = (FlowLayout) footPane.getLayout();
		fl_footPane.setAlignment(FlowLayout.TRAILING);
		contentPane.add(footPane, BorderLayout.SOUTH);

		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 14));
		footPane.add(btnSave);
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

	public JPasswordField getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	public void setTxtConfirmPassword(JPasswordField txtConfirmPassword) {
		this.txtConfirmPassword = txtConfirmPassword;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtAreaCode() {
		return txtAreaCode;
	}

	public void setTxtAreaCode(JTextField txtAreaCode) {
		this.txtAreaCode = txtAreaCode;
	}

	public JTextField getTxtPhonePrefix() {
		return txtPhonePrefix;
	}

	public void setTxtPhonePrefix(JTextField txtPhonePrefix) {
		this.txtPhonePrefix = txtPhonePrefix;
	}

	public JTextField getTxtLineNumber() {
		return txtLineNumber;
	}

	public void setTxtLineNumber(JTextField txtLineNumber) {
		this.txtLineNumber = txtLineNumber;
	}

	public JButton getBtnVerify() {
		return btnVerify;
	}

	public void setBtnVerify(JButton btnVerify) {
		this.btnVerify = btnVerify;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

}
