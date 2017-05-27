import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ΣτοιχείαΧρήστηFrame {

	private JTextPane paratiriseis;
	private JFrame frame;
	private JTextField usernameField;
	private JTextField regionField;
	private JTextField firstField;
	private JTextField addressField;
	private JTextField lastFIeld;
	private JTextField mobileField;
	private JTextField eidikotitaField;
	private JTextField date_of_put;
	private JTextField homeField;
	private JTextField fatherField;
	private JTextField dateOfBirthField;
	private JTextField clinicField;
	private JTextField cityField;
	private JTextField faxField;
	private JTextField e_mailField;
	private String username;
	private JTextField tameioField;
	private JTextField taytotitaField;
	private JTextField genderField;
	private JTextField textField;
	

	public ΣτοιχείαΧρήστηFrame(String username) {
		this.username=username;
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 581);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Όνομα χρήστη");
		lblNewLabel.setBounds(51, 23, 80, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Όνομα");
		label.setBounds(51, 56, 80, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Επώνυμο");
		label_1.setBounds(51, 89, 94, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ειδηκότητα");
		label_2.setBounds(51, 295, 94, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Διεύθυνση");
		label_3.setBounds(51, 200, 86, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Περιοχή");
		label_4.setBounds(51, 153, 80, 29);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Κινητό Τηλέφωνο");
		label_5.setBounds(51, 259, 94, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Τηλέφωνο οικίας");
		label_6.setBounds(375, 23, 99, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Πατρώνυμο");
		label_7.setBounds(375, 59, 99, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Ημερομηνία Γέννησης");
		label_8.setBounds(375, 96, 127, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Κλινική");
		label_9.setBounds(375, 143, 46, 14);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Πόλη");
		label_10.setBounds(51, 228, 46, 14);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("E-mail");
		label_11.setBounds(375, 255, 52, 22);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1\u03C2 \u0395\u03BA\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2 \u03C3\u03C4\u03BF \u03C3\u03CD\u03C3\u03C4\u03B7\u03BC\u03B1");
		label_12.setBounds(51, 331, 255, 29);
		frame.getContentPane().add(label_12);
		
		JLabel lblNewLabel_1 = new JLabel("fax");
		lblNewLabel_1.setBounds(375, 230, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Παρατηρήσεις");
		lblNewLabel_2.setBounds(27, 371, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		usernameField.setEditable(false);
		usernameField.setBounds(179, 24, 127, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		regionField = new JTextField();
		regionField.setEditable(false);
		regionField.setColumns(10);
		regionField.setBounds(179, 157, 127, 20);
		frame.getContentPane().add(regionField);
		
		firstField = new JTextField();
		firstField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		firstField.setEditable(false);
		firstField.setColumns(10);
		firstField.setBounds(179, 57, 127, 20);
		frame.getContentPane().add(firstField);
		
		addressField = new JTextField();
		addressField.setEditable(false);
		addressField.setColumns(10);
		addressField.setBounds(147, 197, 159, 20);
		frame.getContentPane().add(addressField);
		
		lastFIeld = new JTextField();
		lastFIeld.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lastFIeld.setEditable(false);
		lastFIeld.setColumns(10);
		lastFIeld.setBounds(179, 88, 127, 20);
		frame.getContentPane().add(lastFIeld);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setColumns(10);
		mobileField.setBounds(179, 256, 127, 20);
		frame.getContentPane().add(mobileField);
		
		eidikotitaField = new JTextField();
		eidikotitaField.setEditable(false);
		eidikotitaField.setColumns(10);
		eidikotitaField.setBounds(179, 292, 127, 20);
		frame.getContentPane().add(eidikotitaField);
		
		date_of_put = new JTextField();
		date_of_put.setEditable(false);
		date_of_put.setColumns(10);
		date_of_put.setBounds(348, 335, 143, 20);
		frame.getContentPane().add(date_of_put);
		
		homeField = new JTextField();
		homeField.setEditable(false);
		homeField.setColumns(10);
		homeField.setBounds(517, 24, 143, 20);
		frame.getContentPane().add(homeField);
		
		fatherField = new JTextField();
		fatherField.setEditable(false);
		fatherField.setColumns(10);
		fatherField.setBounds(517, 60, 143, 20);
		frame.getContentPane().add(fatherField);
		
		dateOfBirthField = new JTextField();
		dateOfBirthField.setEditable(false);
		dateOfBirthField.setColumns(10);
		dateOfBirthField.setBounds(517, 97, 143, 20);
		frame.getContentPane().add(dateOfBirthField);
		
		clinicField = new JTextField();
		clinicField.setEditable(false);
		clinicField.setColumns(10);
		clinicField.setBounds(517, 140, 143, 20);
		frame.getContentPane().add(clinicField);
		
		cityField = new JTextField();
		cityField.setEditable(false);
		cityField.setColumns(10);
		cityField.setBounds(163, 225, 143, 20);
		frame.getContentPane().add(cityField);
		
		faxField = new JTextField();
		faxField.setEditable(false);
		faxField.setColumns(10);
		faxField.setBounds(517, 227, 143, 20);
		frame.getContentPane().add(faxField);
		
		e_mailField = new JTextField();
		e_mailField.setEditable(false);
		e_mailField.setColumns(10);
		e_mailField.setBounds(517, 256, 143, 20);
		frame.getContentPane().add(e_mailField);
		
		JLabel label_13 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03AF\u03BF");
		label_13.setBounds(375, 168, 71, 14);
		frame.getContentPane().add(label_13);
		
		tameioField = new JTextField();
		tameioField.setEditable(false);
		tameioField.setColumns(10);
		tameioField.setBounds(517, 171, 143, 20);
		frame.getContentPane().add(tameioField);
		
		JLabel lblNewLabel_3 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03A4\u03B1\u03C5\u03C4\u03CC\u03C4\u03B7\u03C4\u03B1\u03C2");
		lblNewLabel_3.setBounds(51, 114, 114, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(51, 154, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		taytotitaField = new JTextField();
		taytotitaField.setEditable(false);
		taytotitaField.setColumns(10);
		taytotitaField.setBounds(179, 118, 127, 20);
		frame.getContentPane().add(taytotitaField);
		
		JLabel label_14 = new JLabel("\u03A6\u03CD\u03BB\u03BF");
		label_14.setBounds(375, 295, 52, 14);
		frame.getContentPane().add(label_14);
		
		genderField = new JTextField();
		genderField.setEditable(false);
		genderField.setColumns(10);
		genderField.setBounds(517, 292, 143, 20);
		frame.getContentPane().add(genderField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 371, 511, 93);
		frame.getContentPane().add(scrollPane);
		
		paratiriseis = new JTextPane();
		scrollPane.setViewportView(paratiriseis);
		paratiriseis.setEditable(false);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SearchDoctors(User.loadUser(username));
			}
		});
		btnNewButton.setBounds(517, 476, 143, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Προσθήκη/Αλλαγή κλινικής");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				if(	User.loadUser(username).isGiatros()){
					Doctor d = (Doctor)User.loadUser(username);
					new addToClinicFrame(null,d,null,null);
				}
				else{
					Nurse d = (Nurse)User.loadUser(username);
					new addToClinicFrame(null,null,d,null);
				
				}
				
			}
		});
		btnNewButton_1.setBounds(27, 498, 292, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		
		if(	User.loadUser(username).isGiatros())
			textField.setText("Γιατρός");
		else
			textField.setText("Νοσηλευτής");
		
		textField.setBounds(546, 335, 114, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JButton exit = new JButton("Πίσω");
		
		try{
			PreparedStatement statement = User.getConnection().prepareStatement("SELECT username, first_name, last_name, date_birth, partonymo, address, region, city, tk, eidikotita, tameio, family_statement, kliniki, amka, arithmos_taytotitas, kinito, thlefwno_spitiou,thlefwno_ergasias, fax, email, hmeromhnia_eisagwghs, paratiriseis,  gender  FROM Users where username ='"+username+"'");
			ResultSet result = statement.executeQuery();
			
			
			while(result.next()){
				usernameField.setText(result.getString("username"));
				e_mailField.setText(result.getString("email"));
				firstField.setText(result.getString("first_name"));
				lastFIeld.setText(result.getString("last_name"));
				dateOfBirthField.setText(result.getString("date_birth"));
				fatherField.setText(result.getString("partonymo"));
				regionField.setText(result.getString("region"));
				mobileField.setText(result.getString("kinito"));
				eidikotitaField.setText(result.getString("eidikotita"));
				date_of_put.setText(result.getString("hmeromhnia_eisagwghs"));
				homeField.setText(result.getString("thlefwno_spitiou"));
				paratiriseis.setText(result.getString("paratiriseis"));
				try{
				int kliniki = result.getInt("kliniki");
				Clinic c = Clinic.loadClinic(kliniki);
				String clinicName = c.getName();
				clinicField.setText(clinicName);
				}
				catch(Exception e){
					e.printStackTrace();
					clinicField.setText("");
				}
				
				cityField.setText(result.getString("username"));
				tameioField.setText(result.getString("tameio"));
				taytotitaField.setText(result.getString("arithmos_taytotitas"));
				String fyllo=result.getString("gender");
				
				
				if (fyllo.equals("M"))
					genderField.setText("’ντρας");
				else if(fyllo.equals("F"))
					genderField.setText("Γυναίκα");
				else
					genderField.setText("");
				
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		frame.setVisible(true);
		
		
		
	}
}
