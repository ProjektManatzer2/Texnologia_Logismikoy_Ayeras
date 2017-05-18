import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class InitialScreen {

	private JFrame frmLoginScreen;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialScreen window = new InitialScreen();
					window.frmLoginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginScreen = new JFrame();
		frmLoginScreen.setResizable(false);
		frmLoginScreen.setTitle("Login Screen");
		frmLoginScreen.setBounds(100, 100, 600, 400);
		frmLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(200, 80, 200, 23);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(200, 120, 200, 23);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(200, 160, 200, 23);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(200, 200, 200, 23);
		frmLoginScreen.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(340, 240, 60, 23);
		frmLoginScreen.getContentPane().add(btnLogin);
		frmLoginScreen.getContentPane().add(pwdPassword);
		frmLoginScreen.getContentPane().add(lblPassword);
		frmLoginScreen.getContentPane().add(lblUsername);
		frmLoginScreen.getContentPane().add(txtUsername);
	}
}
