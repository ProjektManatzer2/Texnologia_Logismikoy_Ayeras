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
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;

public class VasikaStoixeiaAstheni {

	private JTextPane paratiriseisField ;
	private JFrame frame;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField klinikiField;
	private JTextField roomField;
	private JTextField bornDateField;
	private JTextField dateOfPut;
	private JTextField amkaField;
	private JTextField contactField;
	private Secretary user;
	private JTextField outField;
	private JScrollPane scrollPane;
	
	/*
	 * Αυτό το φρέιμ αποτελεί το ΤΙ ΒΛΕΠΕΙ ένας χρήστης γραμματείας από τον Patient
	 * Όλα τα στοιχεία του γράφονται στα αντίστοιχα παραπάνω πλαίσια.
	 */
	VasikaStoixeiaAstheni(String amka,Secretary user) { //ΑΜΚΑ ασθενή, user = χρήστης που βλέπει τα στοιχεία του φρέιμ.
		this.user=user;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 622, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Όνομα");
		lblNewLabel.setBounds(10, 25, 98, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Επιστροφή στην αρχική
				frame.dispose();
				new PatientSearch(user);
				
			}
		});
		btnNewButton.setBounds(467, 303, 126, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Επώνυμο");
		lblNewLabel_1.setBounds(10, 82, 98, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Κλινική Νοσηλείας");
		lblNewLabel_2.setBounds(10, 141, 110, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Δωμάτιο Νοσηλείας");
		lblNewLabel_3.setBounds(291, 25, 169, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ημερομηνία Γέννησης");
		lblNewLabel_4.setBounds(291, 82, 169, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ημερομηνία Εισαγωγής");
		lblNewLabel_5.setBounds(291, 141, 169, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel amkaLabel = new JLabel("ΑΜΚΑ");
		amkaLabel.setBounds(291, 198, 169, 30);
		frame.getContentPane().add(amkaLabel);
		
		
		//ΓΕΜΙΣΜΑ FRAME  ΜΕ ΤΑ ΠΕΔΙΑ
		
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
		
		JLabel label = new JLabel("Επικοινωνία");
		label.setBounds(8, 198, 98, 22);
		frame.getContentPane().add(label);
		
		contactField = new JTextField();
		contactField.setEditable(false);
		contactField.setColumns(10);
		contactField.setBounds(116, 199, 138, 20);
		frame.getContentPane().add(contactField);
		
		JButton btnNewButton_1 = new JButton("Προσθήκη/Αλλαγή Κλινικής");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			new addToClinicFrame(Patient.loadPatient(amka), null, null, (Secretary)user); //ΕΔΩ ΠΡΟΣΘΕΤΟΥΝ ΤΟΝ ΑΣΘΕΝΗ ΣΕ ΚΛΙΝΙΚΙ
			}																				//ΚΑΛΟΝΤΑΣ ΜΕ ΤΟΝ ΣΩΣΤΟ ΤΡΟΠΟ ΤΗΝ ΚΛΑΣΗ addToClinicFrame
		});
		btnNewButton_1.setBounds(19, 316, 321, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("Ημερομηνία εξαγωγής");
		label_1.setBounds(291, 255, 169, 22);
		frame.getContentPane().add(label_1);
		
		outField = new JTextField();
		outField.setEditable(false);
		outField.setColumns(10);
		outField.setBounds(441, 260, 152, 20);
		frame.getContentPane().add(outField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 247, 70);
		frame.getContentPane().add(scrollPane);
		
		paratiriseisField = new JTextPane();
		scrollPane.setViewportView(paratiriseisField);
		paratiriseisField.setBackground(Color.WHITE);
		paratiriseisField.setEditable(false);
		
		try{
		PreparedStatement statement = User.getConnection().prepareStatement("SELECT first,last,room,AMKA,personal_tel,home_tel,date_of_birth,put_date,clinic,dateOut,job_tel,comments FROM Astheneis where AMKA='"+amka+"'");
		ResultSet result = statement.executeQuery();
		
		while(result.next()){ //  ΓΕΜΙΣΜΑ ΠΕΔΙΩΝ ΜΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΧΡΗΣΤΗ
			outField.setText(result.getString("dateOut"));
			firstField.setText(result.getString("first"));
			lastField.setText(result.getString("last"));
			roomField.setText(result.getString("room"));
			amkaField.setText(result.getString("AMKA"));
			dateOfPut.setText(result.getString("put_date"));
			bornDateField.setText(result.getString("date_of_birth"));
			paratiriseisField.setText(result.getString("comments"));
			String proswpiko = result.getString("personal_tel");
			String spiti = result.getString("home_tel");
			if(proswpiko.equals("") && !spiti.equals(""))
				contactField.setText(spiti);
			else if(!proswpiko.equals(""))
				contactField.setText(proswpiko);
			else
				contactField.setText(result.getString("job_tel"));
		
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
			JOptionPane.showMessageDialog(null,"Αδυναμία Σύνδεσης στη βάση","Λανθασμένα στοιχεία",JOptionPane.ERROR_MESSAGE);
		}
	frame.setVisible(true);
	
	
	}
}
