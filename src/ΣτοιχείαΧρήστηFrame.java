
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ΣτοιχείαΧρήστηFrame {

	private JFrame frame;
	private JTextField textField;
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
	private JTextField textField_14;
	private JTextField e_mailField;
	private String username;


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
		label.setBounds(51, 96, 80, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Επώνυμο");
		label_1.setBounds(51, 146, 94, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ειδηκότητα");
		label_2.setBounds(51, 295, 94, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Διεύθυνση");
		label_3.setBounds(51, 200, 86, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Περιοχή");
		label_4.setBounds(51, 56, 80, 29);
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
		label_10.setBounds(375, 197, 46, 14);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("E-mail");
		label_11.setBounds(380, 255, 52, 22);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("Ημερομηνίας Εισαγωγής");
		label_12.setBounds(51, 331, 143, 29);
		frame.getContentPane().add(label_12);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(375, 230, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Παρατηρήσεις");
		lblNewLabel_2.setBounds(61, 424, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(215, 421, 345, 84);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setBounds(179, 24, 86, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		regionField = new JTextField();
		regionField.setEditable(false);
		regionField.setColumns(10);
		regionField.setBounds(179, 60, 86, 20);
		frame.getContentPane().add(regionField);
		
		firstField = new JTextField();
		firstField.setEditable(false);
		firstField.setColumns(10);
		firstField.setBounds(179, 97, 86, 20);
		frame.getContentPane().add(firstField);
		
		addressField = new JTextField();
		addressField.setEditable(false);
		addressField.setColumns(10);
		addressField.setBounds(179, 197, 86, 20);
		frame.getContentPane().add(addressField);
		
		lastFIeld = new JTextField();
		lastFIeld.setEditable(false);
		lastFIeld.setColumns(10);
		lastFIeld.setBounds(179, 143, 86, 20);
		frame.getContentPane().add(lastFIeld);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setColumns(10);
		mobileField.setBounds(179, 256, 86, 20);
		frame.getContentPane().add(mobileField);
		
		eidikotitaField = new JTextField();
		eidikotitaField.setEditable(false);
		eidikotitaField.setColumns(10);
		eidikotitaField.setBounds(179, 292, 86, 20);
		frame.getContentPane().add(eidikotitaField);
		
		date_of_put = new JTextField();
		date_of_put.setEditable(false);
		date_of_put.setColumns(10);
		date_of_put.setBounds(179, 335, 86, 20);
		frame.getContentPane().add(date_of_put);
		
		homeField = new JTextField();
		homeField.setEditable(false);
		homeField.setColumns(10);
		homeField.setBounds(517, 24, 86, 20);
		frame.getContentPane().add(homeField);
		
		fatherField = new JTextField();
		fatherField.setEditable(false);
		fatherField.setColumns(10);
		fatherField.setBounds(517, 60, 86, 20);
		frame.getContentPane().add(fatherField);
		
		dateOfBirthField = new JTextField();
		dateOfBirthField.setEditable(false);
		dateOfBirthField.setColumns(10);
		dateOfBirthField.setBounds(517, 97, 86, 20);
		frame.getContentPane().add(dateOfBirthField);
		
		clinicField = new JTextField();
		clinicField.setEditable(false);
		clinicField.setColumns(10);
		clinicField.setBounds(517, 140, 86, 20);
		frame.getContentPane().add(clinicField);
		
		cityField = new JTextField();
		cityField.setEditable(false);
		cityField.setColumns(10);
		cityField.setBounds(517, 194, 86, 20);
		frame.getContentPane().add(cityField);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(517, 227, 86, 20);
		frame.getContentPane().add(textField_14);
		
		e_mailField = new JTextField();
		e_mailField.setEditable(false);
		e_mailField.setColumns(10);
		e_mailField.setBounds(517, 256, 86, 20);
		frame.getContentPane().add(e_mailField);
		JButton exit = new JButton("Πίσω");
		
		try{
			PreparedStatement statement = User.getConnection().prepareStatement("SELECT username, first_name, last_name, date_birth, partonymo, varos, upsos, address, region, city, tk, eidikotita, tameio, family_statement, kliniki, amka, arithmos_taytotitas, kinito, thlefwno_spitiou,thlefwno_ergasias, fax, email, hmeromhnia_eisagwghs, paratiriseis,  gender  FROM Users where username ='"+username+"'");
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
				eidikotitaField.setText(result.getString(""));
				date_of_put.setText(result.getString("hmeromhnia_eisagwghs"));
				homeField.setText(result.getString("thlefwno_spitiou"));
				//clinicField.setText(result.getStr("kliniki"));
				cityField.setText(result.getString("username"));
							
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		frame.setVisible(true);
		
		
		
	}
}
