import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClinicCreateFrame {

	private JFrame frame;
	private JTextField nameField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicCreateFrame window = new ClinicCreateFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClinicCreateFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Όνομα Κλινικής");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(51, 71, 172, 49);
		frame.getContentPane().add(label);
		
		nameField = new JTextField();
		nameField.setBounds(244, 79, 172, 36);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel label_1 = new JLabel("Α/Α Κλινικής");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(51, 169, 172, 49);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(244, 177, 172, 36);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Καταχώρηση");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					if(!(nameField.getText().trim().replaceAll(" ","").equals(""))){
						try{
							Connection conn = User.getConnection();
							int aa = Integer.parseInt(textField.getText());
							if(!(nameExists(nameField.getText(),conn) || numberExists(aa,conn))){
								Clinic c =new Clinic(aa,nameField.getText(),conn);
								c.saveClinic();
								frame.dispose();
								new SecretaryOffice();
							}
				
							
						}
						catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null,
								    "Το πλαίσιο Α/Α Κλινικής πρέπει να περιέχει αριθμό",
								    "ΛΑΘΟΣ ΑΡΙΘΜΟΣ",
								    JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception e){
							
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,
							    "Αποτυχία σύνδεσης στη βάση",
							    "Failed to connect",
							    JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null,
							    "Συμπληρώστε το όνομα της κλινικής",
							    "No name",
							    JOptionPane.INFORMATION_MESSAGE);
					}
			
			}

			private boolean numberExists(int aa, Connection conn) throws Exception {
		
					
					String sql = "Select id from clinics where id = ?";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, aa);
					ResultSet result =statement.executeQuery();
					int i=0;
					while(result.next())
						i++;
					
					if (i>0){
						JOptionPane.showMessageDialog(null,
							    "Ο Αύξων αριθμός υπάρχει ήδη στις κλινικές",
							    " A/A already exists",
							    JOptionPane.WARNING_MESSAGE);
						return true;
					}
						else
						return false;
				
			}

			private boolean nameExists(String text, Connection conn) throws SQLException {
				String sql = "Select name from clinics where name = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1,text );
				ResultSet result =statement.executeQuery();
				int i=0;
				while(result.next())
					i++;
				
				if (i>0){
					JOptionPane.showMessageDialog(null,
						    "Το όνομα κλινικής υπάρχει ήδη",
						    "Invalid name",
						    JOptionPane.WARNING_MESSAGE);
					return true;
				}
					else
					return false;
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(389, 298, 121, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("’κυρο");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice();
			}
		});
		btnNewButton_1.setBounds(234, 298, 133, 31);
		frame.getContentPane().add(btnNewButton_1);
	}
}
