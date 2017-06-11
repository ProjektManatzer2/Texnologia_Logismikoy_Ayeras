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
	private	JButton �������_�������� ;
	private JButton btnAdd;
	private JButton ��������_�������;
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
	private JButton ��������_��������;
	private User user;
	/*
	 * ��� ���������� ��� �� ��������� �������� ��� ������ ���� ��������� ������� �������� ���.
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
		//������������ ���� ��� LABELS ��� UNEDITABLE TEXTFIELDS
		JPanel panel_�������� = new JPanel();
		tabbedPane.addTab("������ ��������", null, panel_��������, null);
		panel_��������.setToolTipText("");
		panel_��������.setLayout(null);
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(28, 39, 86, 20);
		panel_��������.add(label);
		
		FirstName = new JTextField();
		FirstName.setBounds(124, 39, 162, 20);
		panel_��������.add(FirstName);
		FirstName.setColumns(10);
		FirstName.setText(patient.getFirst());
		FirstName.setEditable(false);
		JLabel label_1 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(28, 70, 86, 20);
		panel_��������.add(label_1);
		
		LastName = new JTextField();
		LastName.setBounds(124, 70, 162, 20);
		panel_��������.add(LastName);
		LastName.setColumns(10);
		LastName.setText(patient.getLast());
		LastName.setEditable(false);
		
		JLabel label_2 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(28, 101, 86, 20);
		panel_��������.add(label_2);
		
		FathersName = new JTextField();
		FathersName.setBounds(124, 101, 162, 20);
		FathersName.setEditable(false);
		
		panel_��������.add(FathersName);
		FathersName.setColumns(10);
		FathersName.setText(patient.getPdto().getF_name());
		JLabel label_3 = new JLabel("\u0391.\u039C.\u039A.\u0391");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(28, 132, 86, 20);
		panel_��������.add(label_3);
		
		AMKA = new JTextField();
		AMKA.setBounds(124, 132, 162, 20);
		panel_��������.add(AMKA);
		AMKA.setColumns(10);
		AMKA.setText(patient.getAMKA());
		AMKA.setEditable(false);
		
		JLabel label_4 = new JLabel("\u0391.\u039C.\u0391");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(28, 163, 86, 20);
		panel_��������.add(label_4);
		
		AMA = new JTextField();
		AMA.setBounds(124, 163, 162, 20);
		panel_��������.add(AMA);
		AMA.setColumns(10);
		AMA.setText(patient.getPdto().getAma());
		AMA.setEditable(false);
		
		JLabel label_5 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03B9\u03BF :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(28, 197, 86, 20);
		panel_��������.add(label_5);
		
		Tameio = new JTextField();
		Tameio.setBounds(124, 194, 162, 20);
		panel_��������.add(Tameio);
		Tameio.setColumns(10);
		Tameio.setText(patient.getPdto().getInsurance_institution());
		Tameio.setEditable(false);
		
		JLabel label_6 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0393\u03B5\u03BD. :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(28, 228, 109, 20);
		panel_��������.add(label_6);
		
		Age = new JTextField();
		Age.setEditable(false);
		Age.setBounds(124, 225, 162, 20);
		panel_��������.add(Age);
		Age.setColumns(10);
		Age.setText(patient.getPdto().getDate_of_birth());
		Age.setEditable(false);
		
		JLabel label_8 = new JLabel("\u0392\u03AC\u03C1\u03BF\u03C2 : ");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(28, 256, 86, 20);
		panel_��������.add(label_8);
		
		Weight = new JTextField();
		Weight.setBounds(124, 256, 162, 20);
		panel_��������.add(Weight);
		Weight.setColumns(10);
		Weight.setText(patient.getPdto().getWeight());
		Weight.setEditable(false);
		
		JLabel label_9 = new JLabel("\u038E\u03C8\u03BF\u03C2 :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(28, 287, 86, 20);
		panel_��������.add(label_9);
		
		Height = new JTextField();
		Height.setBounds(124, 287, 162, 20);
		panel_��������.add(Height);
		Height.setColumns(10);
		Height.setText(patient.getPdto().getHeight());
		Height.setEditable(false);
		
		JLabel label_10 = new JLabel("\u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 : ");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(28, 323, 86, 17);
		panel_��������.add(label_10);
		
		Job = new JTextField();
		Job.setBounds(124, 321, 162, 20);
		panel_��������.add(Job);
		Job.setColumns(10);
		Job.setText(patient.getPdto().getJob());
		Job.setEditable(false);
		
		JLabel label_12 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(368, 39, 86, 20);
		panel_��������.add(label_12);
		
		Address = new JTextField();
		Address.setBounds(500, 39, 184, 20);
		panel_��������.add(Address);
		Address.setColumns(10);
		Address.setText(patient.getPdto().getAddress());
		Address.setEditable(false);
		
		JLabel label_13 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(368, 70, 86, 20);
		panel_��������.add(label_13);
		
		State = new JTextField();
		State.setBounds(500, 70, 184, 20);
		panel_��������.add(State);
		State.setColumns(10);
		State.setText(patient.getPdto().getRegion());
		State.setEditable(false);
		
		JLabel label_14 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(368, 101, 86, 20);
		panel_��������.add(label_14);
		
		City = new JTextField();
		City.setBounds(500, 101, 184, 20);
		panel_��������.add(City);
		City.setColumns(10);
		City.setText(patient.getPdto().getCity());
		City.setEditable(false);
		
		JLabel label_15 = new JLabel("\u039A\u03B9\u03BD\u03B7\u03C4\u03CC \u03A4\u03AE\u03BB. : ");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(368, 132, 86, 20);
		panel_��������.add(label_15);
		
		MobileNum = new JTextField();
		MobileNum.setEditable(false);
		MobileNum.setBounds(500, 132, 184, 20);
		panel_��������.add(MobileNum);
		MobileNum.setColumns(10);
		MobileNum.setText(patient.getPdto().getPersonal_tel());
		JLabel label_16 = new JLabel("\u03A3\u03C4\u03B1\u03B8\u03B5\u03C1\u03CC \u03A4\u03AE\u03BB. :");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_16.setBounds(368, 163, 109, 20);
		panel_��������.add(label_16);
		
		HomeNum = new JTextField();
		HomeNum.setEditable(false);
		HomeNum.setBounds(500, 163, 184, 20);
		panel_��������.add(HomeNum);
		HomeNum.setColumns(10);
		HomeNum.setText(patient.getPdto().getHome_tel());
		
		JLabel label_17 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2 :");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(368, 194, 109, 20);
		panel_��������.add(label_17);
		
		JobNum = new JTextField();
		JobNum.setEditable(false);
		JobNum.setBounds(500, 194, 184, 20);
		panel_��������.add(JobNum);
		JobNum.setColumns(10);
		JobNum.setText(patient.getPdto().getJob_tel());
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(368, 225, 109, 20);
		panel_��������.add(lblEmail);
		
		Email = new JTextField();
		Email.setEditable(false);
		Email.setBounds(500, 225, 184, 20);
		panel_��������.add(Email);
		Email.setColumns(10);
		Email.setText(patient.getPdto().getEmail());
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFax.setBounds(368, 253, 109, 20);
		panel_��������.add(lblFax);
		
		Fax = new JTextField();
		Fax.setEditable(false);
		Fax.setBounds(500, 252, 184, 20);
		panel_��������.add(Fax);
		Fax.setColumns(10);
		Fax.setText(patient.getPdto().getFax());
		JLabel lblRoom = new JLabel("\u0394\u03C9\u03BC\u03AC\u03C4\u03B9\u03BF");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoom.setBounds(363, 342, 126, 20);
		panel_��������.add(lblRoom);
		
		room = new JTextField();
		room.setEditable(false);
		room.setBounds(519, 342, 139, 20);
		panel_��������.add(room);
		room.setColumns(10);
		room.setText(patient.getPdto().getRoom());
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //�� ������� �� ������ SAVE ��� �� ����FIELDS ������������ UNEDITABLE KAI 
				FirstName.setEditable(false);			//KAI �������� �������� ��� �� �������� ��� ������ ��� ����.
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
		panel_��������.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton button = new JButton("�����������");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FirstName.setEditable(true); //�� ������� � ������������ � ������� ������ �� ������������ �� �������� ��� ������
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
		panel_��������.add(button);
		
		JButton deleteButton = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE \u0391\u03C0\u03CC \u03C4\u03B7\u03BD \u039A\u03BB\u03B9\u03BD\u03B9\u03BA\u03AE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�� ������� �� ������ ��������� ����������� ��� �������� ��� �� ������������ � �������
				new DeletePatientFromClinicFrame(patient);
			}
		});
		deleteButton.setBounds(10, 460, 223, 23);
		panel_��������.add(deleteButton);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(28, 351, 310, 95);
		panel_��������.add(scrollPane_9);
		
		commentsField = new JTextPane();
		commentsField.setEditable(false);
		commentsField.setText(patient.getPdto().getComments());
		scrollPane_9.setViewportView(commentsField);
					
		//������������ LABEL ��� ����FIELDS ��� �� ������� �������
		JPanel panel_�������_�������� = new JPanel();
		tabbedPane.addTab("������� ��������", null, panel_�������_��������, null);
		panel_�������_��������.setLayout(null);
		
		JLabel label_19 = new JLabel("\u0393\u03B5\u03BD\u03B9\u03BA\u03CC \u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC ");
		label_19.setFont(new Font("Sylfaen", Font.BOLD, 14));
		label_19.setBounds(298, 11, 180, 14);
		panel_�������_��������.add(label_19);
		
		JLabel label_20 = new JLabel("\u039A\u03B1\u03C1\u03B4\u03B9\u03BF\u03BB\u03BF\u03B3\u03B9\u03BA\u03CC \u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC ");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setBounds(10, 151, 136, 14);
		panel_�������_��������.add(label_20);
		
		JLabel label_21 = new JLabel("\u03A0\u03B1\u03C1\u03AC\u03B3\u03BF\u03BD\u03C4\u03B5\u03C2 \u039A\u03B9\u03BD\u03B4\u03CD\u03BD\u03BF\u03C5 ");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setBounds(392, 151, 136, 14);
		panel_�������_��������.add(label_21);
		
		JLabel label_22 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03B1 ");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_22.setBounds(10, 322, 136, 14);
		panel_�������_��������.add(label_22);
		
		JLabel lblNewLabel = new JLabel("\u0391\u03C3\u03B8\u03AD\u03BD\u03B5\u03B9\u03B5\u03C2");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 36, 243, 14);
		panel_�������_��������.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("\u0391\u03BB\u03BB\u03B5\u03C1\u03B3\u03AF\u03B5\u03C2");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(263, 36, 165, 14);
		panel_�������_��������.add(label_7);
		
		JLabel label_11 = new JLabel("\u0395\u03B3\u03C7\u03B5\u03B9\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2/\u039D\u03BF\u03C3\u03B7\u03BB\u03B5\u03AF\u03B5\u03C2");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(438, 36, 153, 14);
		panel_�������_��������.add(label_11);
		
		JLabel label_18 = new JLabel("\u0393\u03B5\u03BD\u03B9\u03BA\u03AC \u03A3\u03C7\u03CC\u03BB\u03B9\u03B1");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(601, 36, 142, 14);
		panel_�������_��������.add(label_18);
		
		JButton button_1 = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������� ����������� � ������� ������ �� ������������ �� �������� ��� ������
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
		panel_�������_��������.add(button_1);
		
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
				// �������� SAVE �������������
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
		panel_�������_��������.add(button_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 61, 243, 79);
		panel_�������_��������.add(scrollPane_2);
		
		astheneies = new JTextPane();
		scrollPane_2.setViewportView(astheneies);
		astheneies.setText(patient.getAstheneies());
		astheneies.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 359, 138);
		panel_�������_��������.add(scrollPane);
		
		KardiologikoIstoriko = new JTextPane();
		scrollPane.setViewportView(KardiologikoIstoriko);
		KardiologikoIstoriko.setText(patient.getKardiologiko());
		KardiologikoIstoriko.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 175, 339, 136);
		panel_�������_��������.add(scrollPane_1);
		
		paragontes = new JTextPane();
		scrollPane_1.setViewportView(paragontes);
		paragontes.setText(patient.getParagontes());
		paragontes.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(263, 61, 165, 79);
		panel_�������_��������.add(scrollPane_3);
		
		allergies = new JTextPane();
		scrollPane_3.setViewportView(allergies);
		allergies.setText(patient.getAllergies());
		allergies.setEditable(false);
		
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(438, 61, 153, 79);
		panel_�������_��������.add(scrollPane_4);
		
		Egxeirhseis = new JTextPane();
		scrollPane_4.setViewportView(Egxeirhseis);
		Egxeirhseis.setText(patient.getEgxeirhseis());
		Egxeirhseis.setEditable(false);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(601, 61, 136, 79);
		panel_�������_��������.add(scrollPane_5);
		
		genikaSxolia = new JTextPane();
		scrollPane_5.setViewportView(genikaSxolia);
		genikaSxolia.setText(patient.getGenikaSxolia());
		genikaSxolia.setEditable(false);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 347, 418, 136);
		panel_�������_��������.add(scrollPane_6);
		
		farmaka = new JTextPane();
		scrollPane_6.setViewportView(farmaka);
		farmaka.setText(patient.getFarmaka());
		farmaka.setEditable(false);
		
		
		//������������ ���������� �������� ���������
		JPanel panel_��������� = new JPanel();
		tabbedPane.addTab("���������", null, panel_���������, null);
		panel_���������.setLayout(null);
		
		�������_�������� = new JButton("������� ��������");
		�������_��������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ //���������� ��� ��� ������ � ������� ��� ���������� ���� ������
					int row = table.getSelectedRow();
					int id  =  Integer.parseInt(table.getModel().getValueAt(row,0).toString());
					patient.loadEksetasi(id);

				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"��� ���� �������� ������","No row selected",JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
			}
		});
		�������_��������.setFont(new Font("Tahoma", Font.BOLD, 11));
		�������_��������.setBounds(104, 306, 146, 39);
		panel_���������.add(�������_��������);
		
		JButton ��������_�������� = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE E\u03BE\u03AD\u03C4\u03B1\u03C3\u03B7\u03C2 ");
		��������_��������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{//�� ��������� ��� � ������� ����� ������� ���� ��� LINE 618 ���� ����� ���� �������� ��������
					int row = table.getSelectedRow();
					int id =  Integer.parseInt(table.getModel().getValueAt(row,0).toString());
					if(!user.isGiatros()){	//�� ��������� ��������� ��������� ��� �� ���� �� ����� ��� ������� ��� �� �� �������		 
											//������� ��� ������ �� ������� ��� �� ���������
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
							JOptionPane.showMessageDialog(null,"��� �������� �� ������� ��������� ����������� ��� ������","Not allowed",JOptionPane.WARNING_MESSAGE);
							
						}
						else{
						query="DELETE FROM Eksetaseis WHERE id="+id;
						PreparedStatement st = User.getConnection().prepareStatement(query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"�� ������ �������� ����������, ��������� ��� �������� ��� �� ������ �� �������","Delete done",JOptionPane.INFORMATION_MESSAGE);
						
						
						}
					}
					
					
					else{
						String query="DELETE FROM Eksetaseis WHERE id="+id;
						PreparedStatement st = User.getConnection().prepareStatement(query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"�� ������ �������� ����������, ��������� ��� �������� ��� �� ������ �� �������","Delete done",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"��� ���� �������� ������","No row selected",JOptionPane.WARNING_MESSAGE);
				
				} catch (Exception e) {

					e.printStackTrace();
				}
				
			
			}
		});
		��������_��������.setFont(new Font("Tahoma", Font.BOLD, 10));
		��������_��������.setBounds(104, 406, 146, 39);
		panel_���������.add(��������_��������);
		
		��������_�������� = new JButton("�������� ��������");
		��������_��������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try { //� ������� �������� ��� ��� ���������� ��� ������ ��� �� �������� ��� �������
					patient.uploadExsetasi(user);
					JOptionPane.showMessageDialog(null,"�� ������ ��������� ���� ���������!(��������� �� ������ ��� �� ����� � ����������)","Adding done",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"�������� ��������","File not uploaded",JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
				
			}
		});
		��������_��������.setFont(new Font("Tahoma", Font.BOLD, 11));
		��������_��������.setBounds(103, 356, 147, 39);
		panel_���������.add(��������_��������);
	
		��������_������� = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03A3\u03C7\u03BF\u03BB\u03AF\u03BF\u03C5 ");
		��������_�������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.isGiatros()){		//�� ��������� ������� �������� ������ ���� ���� ���������
				textPane.setEditable(true);
				btnAdd.setBounds(404, 245, 299, 39);
				��������_�������.setBounds(0, 0, 0, 0);
				patient.save_Patient_in_DB(true);
				}
				else	//� ���������� ������ �� ��������Ϻ���� �� ����� ������ѹ����
					JOptionPane.showMessageDialog(null,"��� ����������� �� ������� ������ ���� ���� ���������,�������� \n�� ��������� ���� ������� ������������"
							+ "��� �� ������� �� ���� ��� ��������","Wrong field",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		��������_�������.setFont(new Font("Tahoma", Font.BOLD, 11));
		��������_�������.setBounds(404, 245, 299, 39);
		panel_���������.add(��������_�������);
		
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
		//��� ������� ������� ��� ������� ��������� ��� ������ ��� TABLE
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
		panel_���������.add(table);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(404, 11, 299, 187);
		panel_���������.add(scrollPane_8);
		
		textPane = new JTextPane();
		scrollPane_8.setViewportView(textPane);
		textPane.setEditable(false);
		textPane.setText(patient.getSxoliaEks());
		
		btnAdd = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//EMFANIZETAI MONO STOYS GIATROYS AFOU PROSTHESOYN SXOLIA, GIA NA PRAGMATOPOIH8EI H EPIKYRWSH TOYS.
				��������_�������.setBounds(404, 245, 299, 39);
				btnAdd.setBounds(0,0,0,0);
				textPane.setEditable(false);
				patient.setSxoliaEks(textPane.getText());
				patient.save_Patient_in_DB(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(404, 245, 299, 39);
		panel_���������.add(btnAdd);
	
		
		JPanel panel_������������ = new JPanel();
		tabbedPane.addTab("������������", null, panel_������������, null);
		panel_������������.setLayout(null);
		
		JLabel label_23 = new JLabel("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2 ");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_23.setBounds(120, 116, 150, 24);
		panel_������������.add(label_23);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(120, 151, 504, 242);
		panel_������������.add(scrollPane_7);
		
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
		panel_������������.add(btnSave_1);
		
		JButton btnNewButton = new JButton("�����������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paratiriseis.setEditable(true);
			}
			
		});
		btnNewButton.setBounds(478, 415, 115, 23);
		panel_������������.add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { //������� �� FRAME ��� ����� ��� ������ ��� ������.
				frame.dispose();
				if(user.isGiatros()){
					new �������_����������((Doctor)user);
				}
				else{
					new �������_����������((Nurse)user);
				}
			}
		});
		
		btnOk.setBounds(679, 530, 89, 23);
		frame.getContentPane().add(btnOk);
		frame.setVisible(true);
	}
}
