import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frameParaxwrhshs {

	private JTextField amkaField;
	private JTextField usernameField;
	private JFrame frame;
	private Secretary user;

	
	
	public frameParaxwrhshs(Secretary user) {
		initialize(user);
	}

		
	private void initialize(Secretary user) {
		this.user=user;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 168);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Παράδοση στοιχείων");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.paraxwrhsh(usernameField.getText(),amkaField.getText());
				user.diagrafiAitimatos(usernameField.getText(),amkaField.getText());
				try{
					Connection conn=User.getConnection();
					
					String query = "select username from Users where type = 3";
					PreparedStatement statement = conn.prepareStatement(query);
					ResultSet res = statement.executeQuery();
					while(res.next()){
						Secretary S = (Secretary)User.loadUser(res.getString("username"));
						if(S.diagrafiAitimatos(usernameField.getText(),amkaField.getText()))
						S.save_User_in_DB(true);					
					}
					JOptionPane.showMessageDialog(null,"Τα στοιχεία έχουν αποσταλθεί (Ανανεώστε την αρχική σελίδα σας για να δείτε τον καινούργιο συνολικό αριθμό αιτημάτων )","ΑΠΟΣΤΟΛΗ ΕΠΙΤΥΧΗΣ",JOptionPane.INFORMATION_MESSAGE);
					
			
				}catch(Exception exception){
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}

				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(10, 97, 253, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton_1.setBounds(307, 103, 117, 19);
		frame.getContentPane().add(btnNewButton_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(10, 33, 181, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 8, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAmka = new JLabel("amka");
		lblAmka.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmka.setBounds(275, 8, 125, 14);
		frame.getContentPane().add(lblAmka);
		
		amkaField = new JTextField();
		amkaField.setColumns(10);
		amkaField.setBounds(243, 33, 181, 19);
		frame.getContentPane().add(amkaField);
		frame.setVisible(true);
	}

}
