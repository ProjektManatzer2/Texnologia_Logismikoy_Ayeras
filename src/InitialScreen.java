import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		boolean flag = false;
		int id;
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
		btnLogin.setBounds(320, 240, 80, 23);

		
		frmLoginScreen.getContentPane().add(btnLogin);
		frmLoginScreen.getContentPane().add(pwdPassword);
		frmLoginScreen.getContentPane().add(lblPassword);
		frmLoginScreen.getContentPane().add(lblUsername);
		frmLoginScreen.getContentPane().add(txtUsername);
		while(flag==false){
			
			ButtonListener e = new ButtonListener(txtUsername,pwdPassword,flag,id);
			btnLogin.addActionListener(e);
			}
			if (flag==true)
				{
				frmLoginScreen.setVisible(false);
				if(id==0)
					SecretaryOfficeFream();
				else if (id==1)
					DoctorFrame();
				else if (id==2)
					Γιατρός_Νοσηλευτής();
					
	}
}


class ButtonListener implements ActionListener {
	boolean flag;
	JTextField username; 
	JPasswordField password;
	int id;
	
	public ButtonListener(JTextField name, JPasswordField pwdPassword,boolean flag , int id) {

		this.username = name;
		password = pwdPassword;
		this.flag=flag;
		this.id=id;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		boolean flag0 = false;
	
		
		String textField = username.getText();
			userSearch(name,flag0);
		
		
			
		
	
	
			if(flag0==false)
			JOptionPane.showMessageDialog(null, "User " + textField.toString() + " Not Found");


}
	}