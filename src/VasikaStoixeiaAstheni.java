import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class VasikaStoixeiaAstheni {

	private JFrame frame;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField klinikiField;
	private JTextField endDateField;
	private JTextField roomField;
	private JTextField bornDateField;
	private JTextField dateOfPut;
	private JTextField amkaField;
	private JTextField contactField;
	private Secretary user;
	
	
	VasikaStoixeiaAstheni(String amka,Secretary user) {
		this.user=user;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 622, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����");
		lblNewLabel.setBounds(10, 25, 98, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new PatientSearch(user);
				
			}
		});
		btnNewButton.setBounds(467, 303, 126, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("�������");
		lblNewLabel_1.setBounds(10, 82, 98, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("������� ���������");
		lblNewLabel_2.setBounds(10, 141, 110, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("������� ���������");
		lblNewLabel_3.setBounds(291, 25, 169, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("���������� ��������");
		lblNewLabel_4.setBounds(291, 82, 169, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("���������� ���������");
		lblNewLabel_5.setBounds(291, 141, 169, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("����� ���������");
		lblNewLabel_6.setBounds(10, 198, 98, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel amkaLabel = new JLabel("����");
		amkaLabel.setBounds(291, 198, 169, 30);
		frame.getContentPane().add(amkaLabel);
		
		
		
		
		firstField = new JTextField();
		firstField.setEditable(false);
		firstField.setBounds(102, 30, 152, 20);
		frame.getContentPane().add(firstField);
		firstField.setColumns(10);
		
		
		
		lastField = new JTextField();
		lastField.setEditable(false);
		lastField.setColumns(10);
		lastField.setBounds(104, 87, 152, 20);
		frame.getContentPane().add(lastField);
		
		klinikiField = new JTextField();
		klinikiField.setEditable(false);
		klinikiField.setColumns(10);
		klinikiField.setBounds(118, 146, 138, 20);
		frame.getContentPane().add(klinikiField);
		
		endDateField = new JTextField();
		endDateField.setEditable(false);
		endDateField.setColumns(10);
		endDateField.setBounds(118, 203, 138, 20);
		frame.getContentPane().add(endDateField);
		
		roomField = new JTextField();
		roomField.setEditable(false);
		roomField.setColumns(10);
		roomField.setBounds(434, 30, 152, 20);
		frame.getContentPane().add(roomField);
		
		bornDateField = new JTextField();
		bornDateField.setEditable(false);
		bornDateField.setColumns(10);
		bornDateField.setBounds(441, 87, 152, 20);
		frame.getContentPane().add(bornDateField);
		
		dateOfPut = new JTextField();
		dateOfPut.setEditable(false);
		dateOfPut.setColumns(10);
		dateOfPut.setBounds(441, 146, 152, 20);
		frame.getContentPane().add(dateOfPut);
		
		amkaField = new JTextField();
		amkaField.setEditable(false);
		amkaField.setColumns(10);
		amkaField.setBounds(441, 203, 152, 20);
		frame.getContentPane().add(amkaField);
		
		JLabel label = new JLabel("�����������");
		label.setBounds(10, 277, 98, 22);
		frame.getContentPane().add(label);
		
		contactField = new JTextField();
		contactField.setEditable(false);
		contactField.setColumns(10);
		contactField.setBounds(118, 278, 138, 20);
		frame.getContentPane().add(contactField);
		
		JButton btnNewButton_1 = new JButton("��������/������ ��������");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			new addToClinicFrame(Patient.loadPatient(amka), null, null, (Secretary)user);
			}
		});
		btnNewButton_1.setBounds(19, 316, 321, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		try{
		PreparedStatement statement = User.getConnection().prepareStatement("SELECT first,last,room,AMKA,personal_tel,home_tel,date_of_birth,put_date,clinic  FROM Astheneis where AMKA='"+amka+"'");
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			firstField.setText(result.getString("first"));
			lastField.setText(result.getString("last"));
			roomField.setText(result.getString("room"));
			amkaField.setText(result.getString("AMKA"));
			String proswpiko = result.getString("personal_tel");
			String spiti = result.getString("home_tel");
			if(proswpiko.equals(""))
				contactField.setText(spiti);
			else
				contactField.setText(proswpiko);
		
		
		try{
			int kliniki = result.getInt("clinic");
			Clinic c = Clinic.loadClinic(kliniki);
			String clinicName = c.getName();
			klinikiField.setText(clinicName);
			}
			catch(Exception e){
				e.printStackTrace();
				klinikiField.setText("");
			}
		}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"�������� �������� ��� ����","���������� ��������",JOptionPane.ERROR_MESSAGE);
		}
	frame.setVisible(true);
	
	
	}
}