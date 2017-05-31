import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addToClinicFrame {

	private JFrame frame;
	private JComboBox comboBox;
	private Secretary xrhsths; // User using the programm
	//This frame adds a doctor,a nurse or a patient into a clinic
	
	public addToClinicFrame(Patient aPatient,Doctor aDoctor,Nurse aNurse, Secretary user) {
		//Except user, only one parameter has value, the other two must be null, when you call it.
		this.xrhsths=user;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Προσθήκη");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String clinic =	(String)comboBox.getSelectedItem(); //ComboBox with the names of the clinics.
				try {
					
					int numberClinic=0;
					Connection conn=User.getConnection();
					
					String sql="Select id from clinics where name = '"+clinic+"'"; 
					PreparedStatement statement = conn.prepareStatement(sql);
					ResultSet result = statement.executeQuery();	//GETS THE NUMBER (ID) OF THE SELECTED CLINIC
					while (result.next()){
						numberClinic = result.getInt("id");
					}
					if(aNurse!=null){  //AND ACCORDING TO WHAT KIND OF PARAMETERS ARE PUT IN, SETS THE User's(patient's)  clinic id 
						sql="Update Users set kliniki = ? where username= '"+aNurse.getUser_name()+"'"; //equal to the id.
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						
						frame.dispose();
						new SecretaryOffice(user);
					}
					if(aDoctor!=null){
						sql="Update Users set kliniki = ? where username= '"+aDoctor.getUser_name()+"'";
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						
						
						new SecretaryOffice(user);
						frame.dispose();
					}
					if(aPatient!=null){
						sql="Update Astheneis set clinic= ? where AMKA= '"+aPatient.getAMKA()+"'";
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						
						frame.dispose();
						new SecretaryOffice(xrhsths);
					}
					
					
				} catch (Exception e1) {


					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(43, 38, 149, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Πίσω"); //Closes the frame
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice(user);	//Back to secretary Interface
			}
		});
		btnNewButton_1.setBounds(112, 141, 315, 32);
		frame.getContentPane().add(btnNewButton_1);
		String sql="Select id,name from clinics";
		Connection conn;
		try {
			conn = User.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			comboBox = new JComboBox();
			fillComboBox(comboBox,conn);
			
			
			comboBox.setBounds(269, 38, 222, 32);
			frame.getContentPane().add(comboBox);
			
		} catch (Exception e) {
		
			
		}
		frame.setVisible(true);
	}

	//This private method, fills the comboBox with the clinic names
	private void fillComboBox(JComboBox comboBox,Connection conn) {
		
		try {
			
			String query ="Select * from clinics";	
			PreparedStatement statement1 = conn.prepareStatement(query);
			ResultSet result = statement1.executeQuery();
			
			while(result.next()){
				comboBox.addItem(result.getString("name"));
				
			}
			
			statement1.close();
		
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		

		
		
	}
}
