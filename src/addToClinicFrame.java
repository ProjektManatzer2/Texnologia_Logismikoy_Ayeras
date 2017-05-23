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

	public addToClinicFrame(Patient aPatient,Doctor aDoctor,Nurse aNurse) {
	
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Προσθήκη");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String clinic =	(String)comboBox.getSelectedItem();
				try {
					
					int numberClinic=0;
					Connection conn=User.getConnection();
					
					String sql="Select id from clinics where name = '"+clinic+"'";
					PreparedStatement statement = conn.prepareStatement(sql);
					ResultSet result = statement.executeQuery();
					while (result.next()){
						numberClinic = result.getInt("id");
					}
					if(aNurse!=null){
						sql="Update Users set kliniki = ? where username= '"+aNurse.getUser_name()+"'";
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						Clinic c = Clinic.loadClinic(numberClinic);
						
						c.addNurseToClinic(aNurse);
						frame.dispose();
						new SecretaryOffice();
					}
					if(aDoctor!=null){
						sql="Update Users set kliniki = ? where username= '"+aDoctor.getUser_name()+"'";
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						Clinic c = Clinic.loadClinic(numberClinic);
						
						c.addDoctorToClinic(aDoctor);
						frame.dispose();
					}
					if(aPatient!=null){
						sql="Update Patients set kliniki = ? where AMKA= '"+aPatient.getAMKA()+"'";
						System.out.println(sql);
						statement = conn.prepareStatement(sql);
						statement.setInt(1, numberClinic);
						statement.executeUpdate();
						Clinic c = Clinic.loadClinic(numberClinic);
						
						c.addPatientToClinic(aPatient);
						frame.dispose();
						new SecretaryOffice();
					}
					
					
				} catch (Exception e1) {


					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(43, 38, 149, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Πίσω");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice();
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
