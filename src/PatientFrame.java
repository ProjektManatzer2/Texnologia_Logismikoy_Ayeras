import java.awt.Color;
import java.awt.Desktop;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class PatientFrame {
	
	private JTextPane commentsField;
	private	JButton Προβολή_Εξέτασης ;
	private JButton btnAdd;
	private JButton Προσθήκη_Σχολίου;
	private JTextPane Paratiriseis;
	private JTextPane Egxeirhseis;
	private JTextPane farmaka;
	private JTextPane genikaSxolia;
	private JTextPane paragontes;
	private JTextPane allergies;
	private JTextPane KardiologikoIstoriko;
	private JTextPane astheneies;
	private Patient patient;
	private JFrame frame;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField FathersName;
	private JTextField AMKA;
	private JTextField AMA;
	private JTextField Tameio;
	private JTextField Weight;
	private JTextField Height;
	private JTextField Job;
	private JTextField Address;
	private JTextField State;
	private JTextField City;
	private JTextField MobileNum;
	private JTextField HomeNum;
	private JTextField JobNum;
	private JTextField Email;
	private JTextField Fax;
	private JTextField Age;
	private JTextField room;
	private JTable table;
	private JTextPane textPane;
	private JButton Προσθήκη_Εξέτασης;
	private User user;
	/*
	 * ΕΔΩ ΒΡΙΣΚΟΝΤΑΙ ΟΛΑ ΤΑ ΕΥΑΙΣΘΗΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΑΣΘΕΝΗ ΟΠΩΣ ΕΞΕΤΑΣΕΙΣ ΙΑΤΡΙΚΟ ΙΣΤΟΡΙΚΟ ΚΛΠ.
	 */
	

	public PatientFrame(Patient patient,User user) {
		
		this.patient = patient;
		this.user=user;
		initialize(patient);
	}

	
	 private void initialize(Patient patient) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 758, 522);
		frame.getContentPane().add(tabbedPane);
		//ΑΡΧΙΚΟΠΟΙΗΣΗ ΟΛΩΝ ΤΩΝ LABELS ΚΑΙ UNEDITABLE TEXTFIELDS
		JPanel panel_Στοιχεία = new JPanel();
		tabbedPane.addTab("Βασικά Στοιχεία", null, panel_Στοιχεία, null);
		panel_Στοιχεία.setToolTipText("");
		panel_Στοιχεία.setLayout(null);
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(28, 39, 86, 20);
		panel_Στοιχεία.add(label);
		
		FirstName = new JTextField();
		FirstName.setBounds(124, 39, 162, 20);
		panel_Στοιχεία.add(FirstName);
		FirstName.setColumns(10);
		FirstName.setText(patient.getFirst());
		FirstName.setEditable(false);
		JLabel label_1 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(28, 70, 86, 20);
		panel_Στοιχεία.add(label_1);
		
		LastName = new JTextField();
		LastName.setBounds(124, 70, 162, 20);
		panel_Στοιχεία.add(LastName);
		LastName.setColumns(10);
		LastName.setText(patient.getLast());
		LastName.setEditable(false);
		
		JLabel label_2 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(28, 101, 86, 20);
		panel_Στοιχεία.add(label_2);
		
		FathersName = new JTextField();
		FathersName.setBounds(124, 101, 162, 20);
		FathersName.setEditable(false);
		
		panel_Στοιχεία.add(FathersName);
		FathersName.setColumns(10);
		FathersName.setText(patient.getPdto().getF_name());
		JLabel label_3 = new JLabel("\u0391.\u039C.\u039A.\u0391");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(28, 132, 86, 20);
		panel_Στοιχεία.add(label_3);
		
		AMKA = new JTextField();
		AMKA.setBounds(124, 132, 162, 20);
		panel_Στοιχεία.add(AMKA);
		AMKA.setColumns(10);
		AMKA.setText(patient.getAMKA());
		AMKA.setEditable(false);
		
		JLabel label_4 = new JLabel("\u0391.\u039C.\u0391");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(28, 163, 86, 20);
		panel_Στοιχεία.add(label_4);
		
		AMA = new JTextField();
		AMA.setBounds(124, 163, 162, 20);
		panel_Στοιχεία.add(AMA);
		AMA.setColumns(10);
		AMA.setText(patient.getPdto().getAma());
		AMA.setEditable(false);
		
		JLabel label_5 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03B9\u03BF :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(28, 197, 86, 20);
		panel_Στοιχεία.add(label_5);
		
		Tameio = new JTextField();
		Tameio.setBounds(124, 194, 162, 20);
		panel_Στοιχεία.add(Tameio);
		Tameio.setColumns(10);
		Tameio.setText(patient.getPdto().getInsurance_institution());
		Tameio.setEditable(false);
		
		JLabel label_6 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0393\u03B5\u03BD. :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(28, 228, 109, 20);
		panel_Στοιχεία.add(label_6);
		
		Age = new JTextField();
		Age.setEditable(false);
		Age.setBounds(124, 225, 162, 20);
		panel_Στοιχεία.add(Age);
		Age.setColumns(10);
		Age.setText(patient.getPdto().getDate_of_birth());
		Age.setEditable(false);
		
		JLabel label_8 = new JLabel("\u0392\u03AC\u03C1\u03BF\u03C2 : ");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(28, 256, 86, 20);
		panel_Στοιχεία.add(label_8);
		
		Weight = new JTextField();
		Weight.setBounds(124, 256, 162, 20);
		panel_Στοιχεία.add(Weight);
		Weight.setColumns(10);
		Weight.setText(patient.getPdto().getWeight());
		Weight.setEditable(false);
		
		JLabel label_9 = new JLabel("\u038E\u03C8\u03BF\u03C2 :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(28, 287, 86, 20);
		panel_Στοιχεία.add(label_9);
		
		Height = new JTextField();
		Height.setBounds(124, 287, 162, 20);
		panel_Στοιχεία.add(Height);
		Height.setColumns(10);
		Height.setText(patient.getPdto().getHeight());
		Height.setEditable(false);
		
		JLabel label_10 = new JLabel("\u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 : ");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(28, 323, 86, 17);
		panel_Στοιχεία.add(label_10);
		
		Job = new JTextField();
		Job.setBounds(124, 321, 162, 20);
		panel_Στοιχεία.add(Job);
		Job.setColumns(10);
		Job.setText(patient.getPdto().getJob());
		Job.setEditable(false);
		
		JLabel label_12 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(368, 39, 86, 20);
		panel_Στοιχεία.add(label_12);
		
		Address = new JTextField();
		Address.setBounds(500, 39, 184, 20);
		panel_Στοιχεία.add(Address);
		Address.setColumns(10);
		Address.setText(patient.getPdto().getAddress());
		Address.setEditable(false);
		
		JLabel label_13 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(368, 70, 86, 20);
		panel_Στοιχεία.add(label_13);
		
		State = new JTextField();
		State.setBounds(500, 70, 184, 20);
		panel_Στοιχεία.add(State);
		State.setColumns(10);
		State.setText(patient.getPdto().getRegion());
		State.setEditable(false);
		
		JLabel label_14 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(368, 101, 86, 20);
		panel_Στοιχεία.add(label_14);
		
		City = new JTextField();
		City.setBounds(500, 101, 184, 20);
		panel_Στοιχεία.add(City);
		City.setColumns(10);
		City.setText(patient.getPdto().getCity());
		City.setEditable(false);
		
		JLabel label_15 = new JLabel("\u039A\u03B9\u03BD\u03B7\u03C4\u03CC \u03A4\u03AE\u03BB. : ");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(368, 132, 86, 20);
		panel_Στοιχεία.add(label_15);
		
		MobileNum = new JTextField();
		MobileNum.setEditable(false);
		MobileNum.setBounds(500, 132, 184, 20);
		panel_Στοιχεία.add(MobileNum);
		MobileNum.setColumns(10);
		MobileNum.setText(patient.getPdto().getPersonal_tel());
		JLabel label_16 = new JLabel("\u03A3\u03C4\u03B1\u03B8\u03B5\u03C1\u03CC \u03A4\u03AE\u03BB. :");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_16.setBounds(368, 163, 109, 20);
		panel_Στοιχεία.add(label_16);
		
		HomeNum = new JTextField();
		HomeNum.setEditable(false);
		HomeNum.setBounds(500, 163, 184, 20);
		panel_Στοιχεία.add(HomeNum);
		HomeNum.setColumns(10);
		HomeNum.setText(patient.getPdto().getHome_tel());
		
		JLabel label_17 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2 :");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(368, 194, 109, 20);
		panel_Στοιχεία.add(label_17);
		
		JobNum = new JTextField();
		JobNum.setEditable(false);
		JobNum.setBounds(500, 194, 184, 20);
		panel_Στοιχεία.add(JobNum);
		JobNum.setColumns(10);
		JobNum.setText(patient.getPdto().getJob_tel());
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(368, 225, 109, 20);
		panel_Στοιχεία.add(lblEmail);
		
		Email = new JTextField();
		Email.setEditable(false);
		Email.setBounds(500, 225, 184, 20);
		panel_Στοιχεία.add(Email);
		Email.setColumns(10);
		Email.setText(patient.getPdto().getEmail());
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFax.setBounds(368, 253, 109, 20);
		panel_Στοιχεία.add(lblFax);
		
		Fax = new JTextField();
		Fax.setEditable(false);
		Fax.setBounds(500, 252, 184, 20);
		panel_Στοιχεία.add(Fax);
		Fax.setColumns(10);
		Fax.setText(patient.getPdto().getFax());
		JLabel lblRoom = new JLabel("\u0394\u03C9\u03BC\u03AC\u03C4\u03B9\u03BF");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoom.setBounds(363, 342, 126, 20);
		panel_Στοιχεία.add(lblRoom);
		
		room = new JTextField();
		room.setEditable(false);
		room.setBounds(519, 342, 139, 20);
		panel_Στοιχεία.add(room);
		room.setColumns(10);
		room.setText(patient.getPdto().getRoom());
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //ΑΝ ΠΑΤΗΘΕΙ ΤΟ ΚΟΥΜΠΙ SAVE ΟΛΑ ΤΑ ΤΕΧΤFIELDS ΞΑΝΑΓΙΝΟΝΤΑΙ UNEDITABLE KAI 
				FirstName.setEditable(false);			//KAI ΠΑΡΑΚΑΤΩ ΣΩΖΟΝΤΑΙ ΟΛΑ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΧΡΗΣΤΗ ΣΤΗ ΒΑΣΗ.
				LastName.setEditable(false);
				FathersName.setEditable(false);
				AMA.setEditable(false);
				Tameio.setEditable(false);
				Weight.setEditable(false);
				Height.setEditable(false);
				Job.setEditable(false);
				Address.setEditable(false);
				State.setEditable(false);
				City.setEditable(false);
				MobileNum.setEditable(false);
				HomeNum.setEditable(false);
				JobNum.setEditable(false);
				Email.setEditable(false);
				Fax.setEditable(false);
				Age.setEditable(false);
				room.setEditable(false);
				
				patient.getPdto().setAddress(Address.getText());
				patient.getPdto().setAma(AMA.getText());
				patient.getPdto().setInsurance_institution(Tameio.getText());
				patient.getPdto().setWeight(Weight.getText());
				patient.getPdto().setCity(City.getText());
				patient.getPdto().setDate_of_birth(Age.getText());
				patient.getPdto().setEmail(Email.getText());
				patient.getPdto().setF_name(FathersName.getText());
				patient.getPdto().setRegion(State.getText());
				patient.getPdto().setCity(City.getText());
				patient.getPdto().setPersonal_tel(MobileNum.getText());
				patient.getPdto().setHome_tel(HomeNum.getText());
				patient.getPdto().setJob_tel(JobNum.getText());
				patient.getPdto().setEmail(Email.getText());
				patient.getPdto().setFax(Fax.getText());
				patient.getPdto().setDate_of_birth(Age.getText());
				patient.getPdto().setRoom(room.getText());
				patient.getPdto().setAddress(Address.getText());
				patient.getPdto().setWeight(Weight.getText());
				patient.getPdto().setHeight(Height.getText());
				patient.getPdto().setComments(commentsField.getText());
				patient.setFirst(FirstName.getText());
				patient.setLast(LastName.getText());
				patient.save_Patient_in_DB(true);
			}
		});
		btnSave.setBounds(559, 418, 99, 32);
		panel_Στοιχεία.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button = new JButton("Επεξεργασία");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FirstName.setEditable(true); //ΑΝ ΠΑΤΗΘΕΙ Η ΕΠΕΞΕΡΓΙΑΣΙΑ Ο ΧΡΗΣΤΗΣ ΜΠΟΡΕΙ ΝΑ ΕΠΕΞΕΡΓΑΣΤΕΙ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΧΡΗΣΤΗ
				LastName.setEditable(true);
				FathersName.setEditable(true);
				AMA.setEditable(true);
				Tameio.setEditable(true);
				Weight.setEditable(true);
				Height.setEditable(true);
				Job.setEditable(true);
				Address.setEditable(true);
				State.setEditable(true);
				City.setEditable(true);
				MobileNum.setEditable(true);
				HomeNum.setEditable(true);
				JobNum.setEditable(true);
				Email.setEditable(true);
				Fax.setEditable(true);
				Age.setEditable(true);
				room.setEditable(true);
				commentsField.setEditable(true);		
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(431, 418, 99, 32);
		panel_Στοιχεία.add(button);
		
		JButton deleteButton = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE \u0391\u03C0\u03CC \u03C4\u03B7\u03BD \u039A\u03BB\u03B9\u03BD\u03B9\u03BA\u03AE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ΑΝ ΠΑΤΗΘΕΙ ΤΟ ΚΟΥΜΠΙ ΔΙΑΓΡΑΦΗΣ ΕΜΦΑΝΙΖΕΤΑΙ ΝΕΟ ΠΑΡΑΘΥΡΟ ΓΙΑ ΝΑ ΕΠΙΒΕΒΑΙΩΣΕΙ Ο ΧΡΗΣΤΗΣ
				new DeletePatientFromClinicFrame(patient);
			}
		});
		deleteButton.setBounds(10, 460, 223, 23);
		panel_Στοιχεία.add(deleteButton);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(28, 351, 310, 95);
		panel_Στοιχεία.add(scrollPane_9);
		
		commentsField = new JTextPane();
		commentsField.setEditable(false);
		commentsField.setText(patient.getPdto().getComments());
		scrollPane_9.setViewportView(commentsField);
					
		//ΑΡΧΙΚΟΠΟΙΗΣΗ LABEL ΚΑΙ ΤΕΧΤFIELDS ΓΙΑ ΤΗ ΔΕΥΤΕΡΗ ΚΑΡΤΕΛΑ
		JPanel panel_Ιατρικό_Ιστορικό = new JPanel();
		tabbedPane.addTab("Ιατρικό Ιστορικό", null, panel_Ιατρικό_Ιστορικό, null);
		panel_Ιατρικό_Ιστορικό.setLayout(null);
		
		JLabel label_19 = new JLabel("\u0393\u03B5\u03BD\u03B9\u03BA\u03CC \u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC ");
		label_19.setFont(new Font("Sylfaen", Font.BOLD, 14));
		label_19.setBounds(298, 11, 180, 14);
		panel_Ιατρικό_Ιστορικό.add(label_19);
		
		JLabel label_20 = new JLabel("\u039A\u03B1\u03C1\u03B4\u03B9\u03BF\u03BB\u03BF\u03B3\u03B9\u03BA\u03CC \u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC ");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setBounds(10, 151, 136, 14);
		panel_Ιατρικό_Ιστορικό.add(label_20);
		
		JLabel label_21 = new JLabel("\u03A0\u03B1\u03C1\u03AC\u03B3\u03BF\u03BD\u03C4\u03B5\u03C2 \u039A\u03B9\u03BD\u03B4\u03CD\u03BD\u03BF\u03C5 ");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setBounds(392, 151, 136, 14);
		panel_Ιατρικό_Ιστορικό.add(label_21);
		
		JLabel label_22 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03B1 ");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_22.setBounds(10, 322, 136, 14);
		panel_Ιατρικό_Ιστορικό.add(label_22);
		
		JLabel lblNewLabel = new JLabel("\u0391\u03C3\u03B8\u03AD\u03BD\u03B5\u03B9\u03B5\u03C2");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 36, 243, 14);
		panel_Ιατρικό_Ιστορικό.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("\u0391\u03BB\u03BB\u03B5\u03C1\u03B3\u03AF\u03B5\u03C2");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(263, 36, 165, 14);
		panel_Ιατρικό_Ιστορικό.add(label_7);
		
		JLabel label_11 = new JLabel("\u0395\u03B3\u03C7\u03B5\u03B9\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2/\u039D\u03BF\u03C3\u03B7\u03BB\u03B5\u03AF\u03B5\u03C2");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(438, 36, 153, 14);
		panel_Ιατρικό_Ιστορικό.add(label_11);
		
		JLabel label_18 = new JLabel("\u0393\u03B5\u03BD\u03B9\u03BA\u03AC \u03A3\u03C7\u03CC\u03BB\u03B9\u03B1");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(601, 36, 142, 14);
		panel_Ιατρικό_Ιστορικό.add(label_18);
		
		JButton button_1 = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ΠΑΤΩΝΤΑΣ ΕΠΕΞΕΡΓΑΣΙΑ Ο ΧΡΗΣΤΗΣ ΜΠΟΡΕΙ ΝΑ ΕΠΕΞΕΡΓΑΣΤΕΙ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΑΣΘΕΝΗ
				allergies.setEditable(true);
				astheneies.setEditable(true);
				KardiologikoIstoriko.setEditable(true);
				paragontes.setEditable(true);
				genikaSxolia.setEditable(true);
				farmaka.setEditable(true);
				Egxeirhseis.setEditable(true);
				commentsField.setEditable(true);
				
			
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(438, 392, 99, 32);
		panel_Ιατρικό_Ιστορικό.add(button_1);
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				allergies.setEditable(false);
				astheneies.setEditable(false);
				KardiologikoIstoriko.setEditable(false);
				paragontes.setEditable(false);
				genikaSxolia.setEditable(false);
				farmaka.setEditable(false);
				Egxeirhseis.setEditable(false);
				// ΠΑΤΩΝΤΑΣ SAVE ΑΠΟΘΥΚΕΥΟΝΤΑΙ
				patient.setAllergies(allergies.getText());
				patient.setAstheneies(astheneies.getText());
				patient.setFarmaka(farmaka.getText());
				patient.setEgxeirhseis(Egxeirhseis.getText());
				patient.setKardiologiko(KardiologikoIstoriko.getText());
				patient.setGenikaSxolia(genikaSxolia.getText());
				patient.setParagontes(paragontes.getText());
				patient.save_Patient_in_DB(true);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_2.setBounds(566, 392, 99, 32);
		panel_Ιατρικό_Ιστορικό.add(button_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 61, 243, 79);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_2);
		
		astheneies = new JTextPane();
		scrollPane_2.setViewportView(astheneies);
		astheneies.setText(patient.getAstheneies());
		astheneies.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 359, 138);
		panel_Ιατρικό_Ιστορικό.add(scrollPane);
		
		KardiologikoIstoriko = new JTextPane();
		scrollPane.setViewportView(KardiologikoIstoriko);
		KardiologikoIstoriko.setText(patient.getKardiologiko());
		KardiologikoIstoriko.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 175, 339, 136);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_1);
		
		paragontes = new JTextPane();
		scrollPane_1.setViewportView(paragontes);
		paragontes.setText(patient.getParagontes());
		paragontes.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(263, 61, 165, 79);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_3);
		
		allergies = new JTextPane();
		scrollPane_3.setViewportView(allergies);
		allergies.setText(patient.getAllergies());
		allergies.setEditable(false);
		
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(438, 61, 153, 79);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_4);
		
		Egxeirhseis = new JTextPane();
		scrollPane_4.setViewportView(Egxeirhseis);
		Egxeirhseis.setText(patient.getEgxeirhseis());
		Egxeirhseis.setEditable(false);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(601, 61, 136, 79);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_5);
		
		genikaSxolia = new JTextPane();
		scrollPane_5.setViewportView(genikaSxolia);
		genikaSxolia.setText(patient.getGenikaSxolia());
		genikaSxolia.setEditable(false);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 347, 418, 136);
		panel_Ιατρικό_Ιστορικό.add(scrollPane_6);
		
		farmaka = new JTextPane();
		scrollPane_6.setViewportView(farmaka);
		farmaka.setText(patient.getFarmaka());
		farmaka.setEditable(false);
		
		
		//ΑΡΧΙΚΟΠΟΙΗΣΗ ΜΕΤΑΒΛΗΤΩΝ ΚΑΡΤΕΛΑΣ ΕΞΕΤΑΣΕΩΝ
		JPanel panel_Εξετάσεις = new JPanel();
		tabbedPane.addTab("Εξετάσεις", null, panel_Εξετάσεις, null);
		panel_Εξετάσεις.setLayout(null);
		
		Προβολή_Εξέτασης = new JButton("Προβολή Εξέτασης");
		Προβολή_Εξέτασης.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ //ΔΙΑΛΕΓΕΤΑΙ ΑΠΟ ΤΟΝ ΠΙΝΑΚΑ Η ΕΞΕΤΑΣΗ ΚΑΙ ΦΟΡΤΩΝΕΤΑΙ ΣΤΟΝ ΧΡΗΣΤΗ
					int row = table.getSelectedRow();
					int id  =  Integer.parseInt(table.getModel().getValueAt(row,0).toString());
					patient.loadEksetasi(id);

				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"Δεν έχει επιλεγεί τίποτα","No row selected",JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
			}
		});
		Προβολή_Εξέτασης.setFont(new Font("Tahoma", Font.BOLD, 11));
		Προβολή_Εξέτασης.setBounds(104, 306, 146, 39);
		panel_Εξετάσεις.add(Προβολή_Εξέτασης);
		
		JButton Διαγραφή_Εξέτασης = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE E\u03BE\u03AD\u03C4\u03B1\u03C3\u03B7\u03C2 ");
		Διαγραφή_Εξέτασης.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{//ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ Ο ΧΡΗΣΤΗΣ ΕΙΝΑΙ ΓΙΑΤΡΟΣ ΠΑΕΙ ΣΤΟ LINE 618 ΟΠΟΥ ΚΑΝΕΙ ΑΠΛΑ ΔΙΑΓΡΑΦΗ ΕΞΕΤΑΣΗΣ
					int row = table.getSelectedRow();
					int id =  Integer.parseInt(table.getModel().getValueAt(row,0).toString());
					if(!user.isGiatros()){	//ΣΕ ΠΕΡΙΠΤΩΣΗ ΝΟΣΗΛΕΥΤΗ ΠΑΙΡΝΟΥΜΕ ΑΠΟ ΤΗ ΒΑΣΗ ΤΗ ΣΕΙΡΑ ΤΟΥ ΑΡΧΕΙΟΥ ΚΑΙ ΑΝ ΤΟ ΑΝΕΒΑΣΕ		 
											//ΓΙΑΤΡΟΣ ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΣΒΗΣΤΕΙ ΑΠΟ ΤΟ ΝΟΣΗΛΕΥΤΗ
						String query = "select username from Eksetaseis where id="+id;
						String username="";
						PreparedStatement statement = User.getConnection().prepareStatement(query);
						ResultSet res = statement.executeQuery();
						while(res.next())
							{
							username=res.getString("username");
							}
						User u = User.loadUser(username);
						if(u.isGiatros()){
							JOptionPane.showMessageDialog(null,"Δεν μπορείτε να σβήσετε εξετάσεις αναρτημένες από γιατρό","Not allowed",JOptionPane.WARNING_MESSAGE);
							
						}
						else{
						query="DELETE FROM Eksetaseis WHERE id="+id;
						PreparedStatement st = User.getConnection().prepareStatement(query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Το αρχείο εξέτασης διαγράφηκε, ανανεώστε την καρτέλτα για να φανούν οι αλλαγές","Delete done",JOptionPane.INFORMATION_MESSAGE);
						
						
						}
					}
					
					
					else{
						String query="DELETE FROM Eksetaseis WHERE id="+id;
						PreparedStatement st = User.getConnection().prepareStatement(query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Το αρχείο εξέτασης διαγράφηκε, ανανεώστε την καρτέλτα για να φανούν οι αλλαγές","Delete done",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"Δεν έχει επιλεγεί τίποτα","No row selected",JOptionPane.WARNING_MESSAGE);
				
				} catch (Exception e) {

					e.printStackTrace();
				}
				
			
			}
		});
		Διαγραφή_Εξέτασης.setFont(new Font("Tahoma", Font.BOLD, 10));
		Διαγραφή_Εξέτασης.setBounds(104, 406, 146, 39);
		panel_Εξετάσεις.add(Διαγραφή_Εξέτασης);
		
		Προσθήκη_Εξέτασης = new JButton("Προσθήκη Εξέτασης");
		Προσθήκη_Εξέτασης.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try { //Ο ΧΡΗΣΤΗΣ ΔΙΑΛΕΓΕΙ ΑΠΟ ΤΟΝ ΥΠΟΛΟΓΙΣΤΗ ΕΝΑ ΑΡΕΧΙΟ ΚΑΙ ΤΟ ΑΝΕΒΑΖΕΙ ΣΤΟ ΣΥΣΤΗΜΑ
					patient.uploadExsetasi(user);
					JOptionPane.showMessageDialog(null,"Το αρχείο εξετάσεων έχει αναρτηθεί!(Ανανεώστε τη σελίδα για να φανεί η καταχώρηση)","Adding done",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Πρόβλημα σύνδεσης","File not uploaded",JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
				
			}
		});
		Προσθήκη_Εξέτασης.setFont(new Font("Tahoma", Font.BOLD, 11));
		Προσθήκη_Εξέτασης.setBounds(103, 356, 147, 39);
		panel_Εξετάσεις.add(Προσθήκη_Εξέτασης);
	
		Προσθήκη_Σχολίου = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03A3\u03C7\u03BF\u03BB\u03AF\u03BF\u03C5 ");
		Προσθήκη_Σχολίου.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.isGiatros()){		//ΣΕ ΠΕΡΙΠΤΩΣΗ ΓΙΑΤΡΟΥ ΓΡΑΦΕΤΑΙ ΣΧΟΛΙΟ ΠΑΝΩ ΣΤΙΣ ΕΞΕΤΑΣΕΙΣ
				textPane.setEditable(true);
				btnAdd.setBounds(404, 245, 299, 39);
				Προσθήκη_Σχολίου.setBounds(0, 0, 0, 0);
				patient.save_Patient_in_DB(true);
				}
				else	//Ο ΝΟΣΗΛΕΥΤΗΣ ΜΠΟΡΕΙ ΝΑ ΧΡΗΣΗΜΟΠΟΊΗΣΕΙ ΤΟ ΠΕΔΙΟ ΠΑΡΑΤΗΡΉΣΕΩΝ
					JOptionPane.showMessageDialog(null,"Δεν επιτρέπεται να γράψετε σχόλιο πάνω στις εξετάσεις,μπορείτε \nνα μεταβείτε στην καρτέλα παρατηρήσεις"
							+ "για να γράψετε τη δική σας διάγνωση","Wrong field",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		Προσθήκη_Σχολίου.setFont(new Font("Tahoma", Font.BOLD, 11));
		Προσθήκη_Σχολίου.setBounds(404, 245, 299, 39);
		panel_Εξετάσεις.add(Προσθήκη_Σχολίου);
		
		table = new JTable();
		table.setBounds(23, 33, 299, 248);
		table.setShowGrid(true);
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		table.setGridColor(Color.BLACK);
		Connection conn=null;
		try{
			conn=User.getConnection();
		}catch(Exception exception){
			System.out.println("Couldnt connect to database");
			exception.printStackTrace();
		}
		//ΕΔΩ ΓΙΝΕΤΑΙ ΦΟΡΤΩΣΗ ΤΩΝ ΑΡΧΕΙΩΝ ΕΞΕΤΑΣΕΩΝ ΤΟΥ ΑΣΘΕΝΗ ΣΤΟ TABLE
		String query = "select id,Title from Eksetaseis where AMKA='"+patient.getAmka()+"'";
					
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			table.setModel(PatientSearch.resultSetToTableModel(res));
			table.setSelectionBackground(Color.gray);
			table.setSelectionForeground(Color.black);
			
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		panel_Εξετάσεις.add(table);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(404, 11, 299, 187);
		panel_Εξετάσεις.add(scrollPane_8);
		
		textPane = new JTextPane();
		scrollPane_8.setViewportView(textPane);
		textPane.setEditable(false);
		textPane.setText(patient.getSxoliaEks());
		
		btnAdd = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//EMFANIZETAI MONO STOYS GIATROYS AFOU PROSTHESOYN SXOLIA, GIA NA PRAGMATOPOIH8EI H EPIKYRWSH TOYS.
				Προσθήκη_Σχολίου.setBounds(404, 245, 299, 39);
				btnAdd.setBounds(0,0,0,0);
				textPane.setEditable(false);
				patient.setSxoliaEks(textPane.getText());
				patient.save_Patient_in_DB(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(404, 245, 299, 39);
		panel_Εξετάσεις.add(btnAdd);
	
		
		JPanel panel_Παρατηρήσεις = new JPanel();
		tabbedPane.addTab("Παρατηρήσεις", null, panel_Παρατηρήσεις, null);
		panel_Παρατηρήσεις.setLayout(null);
		
		JLabel label_23 = new JLabel("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2 ");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_23.setBounds(120, 116, 150, 24);
		panel_Παρατηρήσεις.add(label_23);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(120, 151, 504, 242);
		panel_Παρατηρήσεις.add(scrollPane_7);
		
		Paratiriseis = new JTextPane();
		scrollPane_7.setViewportView(Paratiriseis);
		Paratiriseis.setEditable(false);
		Paratiriseis.setText(patient.getParatiriseis());
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.setParatiriseis(Paratiriseis.getText());
				patient.save_Patient_in_DB(true);
				Paratiriseis.setEditable(false);
			}
		});
		btnSave_1.setBounds(628, 415, 89, 23);
		panel_Παρατηρήσεις.add(btnSave_1);
		
		JButton btnNewButton = new JButton("Επεξεργασία");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paratiriseis.setEditable(true);
			}
			
		});
		btnNewButton.setBounds(478, 415, 115, 23);
		panel_Παρατηρήσεις.add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { //ΚΛΕΙΝΕΙ ΤΟ FRAME ΚΑΙ ΚΑΛΕΙ ΤΗΝ ΑΡΧΙΚΗ ΤΟΥ ΧΡΗΣΤΗ.
				frame.dispose();
				if(user.isGiatros()){
					new Γιατρός_Νοσηλευτής((Doctor)user);
				}
				else{
					new Γιατρός_Νοσηλευτής((Nurse)user);
				}
			}
		});
		
		btnOk.setBounds(679, 530, 89, 23);
		frame.getContentPane().add(btnOk);
		frame.setVisible(true);
	}
}
