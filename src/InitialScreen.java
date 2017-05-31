import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private JTextField pwdPassword;
	private int type;	//����� ������
	
	/*
	 * ���� ����� �� Frame �������� ��� �������
	 */
	
	public InitialScreen() {
		
		type=0;
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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String			username=txtUsername.getText();
			
				String 			password=pwdPassword.getText();
				User u = db_search(username,password); //� db_search �� � ������� ������ ��� ����, ���������� �� ����� ��� ���� type ��� ��� ���� ��� ������ ���� u.
				
					if(type==3){	//������� �� �� type �������� � ���������� ������
						
						new SecretaryOffice((Secretary)u);
						frmLoginScreen.dispose();
					}
					
					else if (type==2){
						new �������_����������(u);
						frmLoginScreen.dispose();
					}
					
					else if (type==1){
						new �������_����������(u);
						frmLoginScreen.dispose();
					}	
					else{
						JOptionPane.showMessageDialog(null,
							    "����� ����� ������ � �������",
							    "Invalid name or password",
							    JOptionPane.WARNING_MESSAGE);
					}
				
				
				}});
		btnLogin.setBounds(320, 240, 80, 23);

		
		frmLoginScreen.getContentPane().add(btnLogin);
		frmLoginScreen.getContentPane().add(pwdPassword);
		frmLoginScreen.getContentPane().add(lblPassword);
		frmLoginScreen.getContentPane().add(lblUsername);
		frmLoginScreen.getContentPane().add(txtUsername);
		frmLoginScreen.setVisible(true);
		}
	


	private User db_search(String username, String password) {
		Connection conn=null;
		try{
			conn = User.getConnection();
			String sql = "select username from Users where username='"+username+"'";
			
			PreparedStatement statement =conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
				if (result.next()){//A� ������ �� Username ������� �� ���� ���� ����� ������ �� ������� password ��� ������.
					sql="select password from Users where username='"+username+"'";
					 statement =conn.prepareStatement(sql);
					 result = statement.executeQuery();
					
					 String normalPass="";  
					 while (result.next ())
					   normalPass = result.getString ("password");
					   
					if (normalPass.equals(password)){ //�� �� ������� PASSWORD ����� ���� �� ���� ��� ���� ���� 
						
						sql="select type from Users where username='"+username+"'";	//���� ��� ��� ��� ���� ��� ������ ��� �� ������ ��� ������� 
						statement =conn.prepareStatement(sql);					//CONSTRUCTOR
						result = statement.executeQuery();
						while (result.next())
							type=result.getInt("type");
										 
					 switch(type){
					 case 1:
						 Doctor d =(Doctor) User.loadUser(username);
						 
						 return d;
					 case 2: 
						 Nurse n=(Nurse)User.loadUser(username);
					 
						 return n;
					 case 3:
						 Secretary s=(Secretary)User.loadUser(username);
						 return s;
						 
						 default: 
							 return null;
						 
					 }
					}  //AN ��� ������ ������ �� ���� ����� ����� ��� � ������� �ULL, ��� ��� �� ��������������� �������, �� ���������� �� ������
					
				
			}	
				
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;

		}
	}	
	
	

	
}