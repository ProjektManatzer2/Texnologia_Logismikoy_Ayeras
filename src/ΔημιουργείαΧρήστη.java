import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class ΔημιουργείαΧρήστη extends JFrame implements ActionListener {
	
	private JSpinner monthSpinner;
	private JSpinner yearSpinner;
	private JSpinner daySpinner;
	private JRadioButton maleField;
	private JRadioButton femaleField;
	private JTextPane commentsField; 
	private JButton okButton ;
	private JButton cancelButton;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField patronymoField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField varosField;
	private JTextField ypsosField;
	private JTextField dieuthinsiField;
	private JTextField perioxiField;
	private JTextField poliField;
	private JTextField tkField;
	private JTextField eidikotitaField;
	private JTextField tameioField;
	private JTextField oikogeneiaField;
	private JTextField klinikiField;
	private JTextField amkaField;
	private JTextField taytotitaField;
	private JTextField kinitoField;
	private JTextField homeField;
	private JTextField thlErgasiaField;
	private JTextField faxField;
	private JTextField emailField;
	private String username;
	private String password;
	private int type;
	User user;
	public ΔημιουργείαΧρήστη(String username, String password, int i, User user) {
		this.user=user;
		this.username=username;
		this.password=password;
		this.type=i;
		
		this.getContentPane().setEnabled(false);
		this.setResizable(false);
		this.setTitle("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7");
		this.setBounds(100, 100, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		lblNewLabel.setBounds(14, 10, 50, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(74, 10, 170, 20);
		firstNameField.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameField.setColumns(10);
		
		JLabel label = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF :");
		label.setBounds(262, 10, 60, 20);
		
		lastNameField = new JTextField();
		lastNameField.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameField.setBounds(336, 10, 170, 20);
		lastNameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(520, 10, 70, 20);
		
		patronymoField = new JTextField();
		patronymoField.setHorizontalAlignment(SwingConstants.CENTER);
		patronymoField.setBounds(604, 10, 170, 20);
		patronymoField.setColumns(10);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(lblNewLabel);
		this.getContentPane().add(firstNameField);
		this.getContentPane().add(label);
		this.getContentPane().add(lastNameField);
		this.getContentPane().add(lblNewLabel_1);
		this.getContentPane().add(patronymoField);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A6\u03CD\u03BB\u03BB\u03BF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(17, 34, 233, 46);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		maleField = new JRadioButton("\u0386\u03BD\u03B4\u03C1\u03B1\u03C2");
		maleField.setBounds(6, 16, 109, 23);
		panel.add(maleField);
		buttonGroup.add(maleField);
		maleField.setHorizontalAlignment(SwingConstants.CENTER);
		maleField.addActionListener(this);
		femaleField = new JRadioButton("\u0393\u03C5\u03BD\u03B1\u03AF\u03BA\u03B1\r\n");
		femaleField.setBounds(124, 16, 105, 23);
		panel.add(femaleField);
		femaleField.addActionListener(this);
		buttonGroup.add(femaleField);
		
		JLabel label_1 = new JLabel("\u0397\u03BC. \u0393\u03AD\u03BD\u03BD\u03B7\u03C3\u03B7\u03C2 :\r\n");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(262, 50, 75, 20);
		this.getContentPane().add(label_1);
		
		daySpinner = new JSpinner();
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		daySpinner.setBounds(346, 60, 35, 20);
		this.getContentPane().add(daySpinner);
		
		monthSpinner = new JSpinner();
		monthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		monthSpinner.setBounds(390, 60, 35, 20);
		this.getContentPane().add(monthSpinner);
		
		yearSpinner = new JSpinner();
		yearSpinner.setModel(new SpinnerNumberModel(new Integer(1900), new Integer(1900), null, new Integer(1)));
		yearSpinner.setBounds(434, 60, 60, 20);
		this.getContentPane().add(yearSpinner);
		
		JLabel lblNewLabel_2 = new JLabel("\u0397\u0397\r\n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(346, 41, 35, 20);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u039C\u039C\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(390, 41, 35, 20);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u03A7\u03A7\u03A7\u03A7");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(434, 41, 60, 14);
		this.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u0392\u03AC\u03C1\u03BF\u03C2 :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(560, 41, 46, 14);
		this.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u038E\u03C8\u03BF\u03C2 :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(560, 66, 46, 14);
		this.getContentPane().add(lblNewLabel_6);
		
		varosField = new JTextField();
		varosField.setHorizontalAlignment(SwingConstants.CENTER);
		varosField.setBounds(616, 41, 100, 20);
		this.getContentPane().add(varosField);
		varosField.setColumns(10);
		
		ypsosField = new JTextField();
		ypsosField.setHorizontalAlignment(SwingConstants.CENTER);
		ypsosField.setBounds(616, 60, 100, 20);
		this.getContentPane().add(ypsosField);
		ypsosField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("(K.g)");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(716, 41, 46, 20);
		this.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("(c.m)\r\n");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(716, 60, 46, 20);
		this.getContentPane().add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03BA\u03B1\u03C4\u03BF\u03B9\u03BA\u03AF\u03B1\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(17, 90, 172, 133);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 :\r\n");
		lblNewLabel_9.setBounds(6, 16, 70, 20);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		
		dieuthinsiField = new JTextField();
		dieuthinsiField.setBounds(75, 16, 86, 20);
		panel_1.add(dieuthinsiField);
		dieuthinsiField.setHorizontalAlignment(SwingConstants.CENTER);
		dieuthinsiField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		lblNewLabel_10.setBounds(11, 46, 60, 20);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		
		perioxiField = new JTextField();
		perioxiField.setBounds(75, 46, 86, 20);
		panel_1.add(perioxiField);
		perioxiField.setHorizontalAlignment(SwingConstants.CENTER);
		perioxiField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		lblNewLabel_11.setBounds(11, 76, 60, 20);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		
		poliField = new JTextField();
		poliField.setBounds(75, 76, 86, 20);
		panel_1.add(poliField);
		poliField.setHorizontalAlignment(SwingConstants.CENTER);
		poliField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("\u03A4.\u039A :\r\n");
		lblNewLabel_12.setBounds(25, 106, 46, 20);
		panel_1.add(lblNewLabel_12);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tkField = new JTextField();
		tkField.setHorizontalAlignment(SwingConstants.CENTER);
		tkField.setBounds(75, 106, 86, 20);
		panel_1.add(tkField);
		tkField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(202, 89, 578, 133);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("\u0395\u03B9\u03B4\u03B9\u03BA\u03CC\u03C4\u03B7\u03C4\u03B1 :\r\n");
		lblNewLabel_13.setBounds(6, 18, 105, 20);
		if(type!=3){
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		
		eidikotitaField = new JTextField();
		eidikotitaField.setBounds(115, 18, 150, 20);
		panel_2.add(eidikotitaField);
		eidikotitaField.setHorizontalAlignment(SwingConstants.CENTER);
		eidikotitaField.setColumns(10);
		}
		JLabel lblNewLabel_14 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03AF\u03BF :");
		lblNewLabel_14.setBounds(6, 56, 105, 20);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tameioField = new JTextField();
		tameioField.setBounds(115, 56, 150, 20);
		panel_2.add(tameioField);
		tameioField.setHorizontalAlignment(SwingConstants.CENTER);
		tameioField.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("\u039F\u03B9\u03BA\u03BF\u03B3. \u03BA\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 :\r\n");
		lblNewLabel_15.setBounds(4, 94, 107, 20);
		panel_2.add(lblNewLabel_15);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		
		oikogeneiaField = new JTextField();
		oikogeneiaField.setBounds(115, 94, 150, 20);
		panel_2.add(oikogeneiaField);
		oikogeneiaField.setHorizontalAlignment(SwingConstants.CENTER);
		oikogeneiaField.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("\u039A\u03BB\u03B9\u03BD\u03B9\u03BA\u03AE :");
		lblNewLabel_16.setBounds(343, 18, 50, 20);
		
		JLabel lblNewLabel_17 = new JLabel("\u0391\u039C\u039A\u0391 :");
		lblNewLabel_17.setBounds(343, 56, 45, 20);
		panel_2.add(lblNewLabel_17);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		
		amkaField = new JTextField();
		amkaField.setBounds(402, 56, 170, 20);
		panel_2.add(amkaField);
		amkaField.setHorizontalAlignment(SwingConstants.CENTER);
		amkaField.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("\u0391.\u03A4 :\r\n");
		lblNewLabel_18.setBounds(343, 94, 45, 20);
		panel_2.add(lblNewLabel_18);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		
		taytotitaField = new JTextField();
		taytotitaField.setBounds(402, 94, 170, 20);
		panel_2.add(taytotitaField);
		taytotitaField.setHorizontalAlignment(SwingConstants.CENTER);
		taytotitaField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03B5\u03C0\u03B9\u03BA\u03BF\u03B9\u03BD\u03C9\u03BD\u03AF\u03B1\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(17, 227, 764, 74);
		this.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("\u039A\u03B9\u03BD\u03B7\u03C4\u03CC :");
		lblNewLabel_19.setBounds(6, 16, 65, 20);
		panel_3.add(lblNewLabel_19);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		
		kinitoField = new JTextField();
		kinitoField.setBounds(76, 16, 86, 20);
		panel_3.add(kinitoField);
		kinitoField.setHorizontalAlignment(SwingConstants.CENTER);
		kinitoField.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("\u03A4\u03B7\u03BB. \u039F\u03B9\u03BA\u03AF\u03B1\u03C2 :");
		lblNewLabel_20.setBounds(7, 47, 65, 20);
		panel_3.add(lblNewLabel_20);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		
		homeField = new JTextField();
		homeField.setBounds(76, 47, 86, 20);
		panel_3.add(homeField);
		homeField.setHorizontalAlignment(SwingConstants.CENTER);
		homeField.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2 :");
		lblNewLabel_21.setBounds(251, 16, 75, 20);
		panel_3.add(lblNewLabel_21);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
		
		thlErgasiaField = new JTextField();
		thlErgasiaField.setBounds(331, 16, 86, 20);
		panel_3.add(thlErgasiaField);
		thlErgasiaField.setHorizontalAlignment(SwingConstants.CENTER);
		thlErgasiaField.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setBounds(251, 47, 75, 20);
		panel_3.add(lblFax);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		
		faxField = new JTextField();
		faxField.setBounds(331, 47, 86, 20);
		panel_3.add(faxField);
		faxField.setHorizontalAlignment(SwingConstants.CENTER);
		faxField.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("E-MAIL:\r\n");
		lblNewLabel_22.setBounds(508, 28, 45, 20);
		panel_3.add(lblNewLabel_22);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		
		emailField = new JTextField();
		emailField.setBounds(558, 28, 200, 20);
		panel_3.add(emailField);
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 312, 385, 120);
		this.getContentPane().add(scrollPane);
		
		commentsField = new JTextPane();
		commentsField.setText("Παρατηρήσεις: ");
		scrollPane.setViewportView(commentsField);
		
		okButton = new JButton("OK");
		okButton.setBounds(695, 437, 89, 23);
		okButton.addActionListener(this);
		this.getContentPane().add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(596, 437, 89, 23);
		cancelButton.addActionListener(this);
		this.getContentPane().add(cancelButton);
		
		this.setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelButton){
			this.dispose();
			new ΔημιουργίαΧρήστη(user);
		}	
		if(e.getSource()==okButton){
			if(elegxosStoixeiwn()){
				
				switch (type){
				case 1:
					
					Doctor D = new Doctor(username,password,firstNameField.getText().trim(),lastNameField.getText().trim());
					D.getDto().setAddress(dieuthinsiField.getText());
					D.getDto().setAmka(amkaField.getText().trim());
					D.getDto().setCity(poliField.getText());
					D.getDto().setEidikothta(eidikotitaField.getText().trim());
					D.getDto().setEmail(emailField.getText().trim());
					D.getDto().setFamily_statement(oikogeneiaField.getText());
					D.getDto().setFax(faxField.getText().trim());
					D.getDto().setHouse_phone(homeField.getText().trim());
					D.getDto().setJob_phone(thlErgasiaField.getText().trim());
					D.getDto().setKinito(kinitoField.getText().trim());
					D.getDto().setParatiriseis(commentsField.getText());
					D.getDto().setPatronymo(patronymoField.getText().trim());
					D.getDto().setRegion(perioxiField.getText());
					D.getDto().setTameio(tameioField.getText().trim());
					D.getDto().setTaytotita(taytotitaField.getText());
					D.getDto().setTk(tkField.getText().trim());
					D.getDto().setType(type);
					D.getDto().setUpsos(ypsosField.getText());
					D.getDto().setVaros(varosField.getText());
					D.getDto().setFamily_statement(oikogeneiaField.getText());
						if(femaleField.isSelected())
							D.getDto().setGender("F");
						else if(maleField.isSelected())
							D.getDto().setGender("M");						
						
						int day=(int) daySpinner.getValue();
						int month = (int)monthSpinner.getValue();
						int year = (int)yearSpinner.getValue();
						
					String date = Integer.toString(day) + "/"+ Integer.toString(month)+ "/"+Integer.toString(year);
					D.getDto().setBirth_date(date);
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date dateOfPut = new Date();
					System.out.println(dateFormat.format(dateOfPut));
					D.save_User_in_DB(false);
					System.out.println("TOKANA");

					new addToClinicFrame(null,D,null,user);
					this.dispose();
					
					
					break;
					
					
				case 2: 
					
					Nurse N = new Nurse(username,password,firstNameField.getText().trim(),lastNameField.getText().trim());
					N.getDto().setAddress(dieuthinsiField.getText());
					N.getDto().setAmka(amkaField.getText().trim());
					N.getDto().setCity(poliField.getText());
					N.getDto().setEidikothta(eidikotitaField.getText().trim());
					N.getDto().setEmail(emailField.getText().trim());
					N.getDto().setFamily_statement(oikogeneiaField.getText());
					N.getDto().setFax(faxField.getText().trim());
					N.getDto().setHouse_phone(homeField.getText().trim());
					N.getDto().setJob_phone(thlErgasiaField.getText().trim());
					N.getDto().setKinito(kinitoField.getText().trim());
					N.getDto().setParatiriseis(commentsField.getText());
					N.getDto().setPatronymo(patronymoField.getText().trim());
					N.getDto().setRegion(perioxiField.getText());
					N.getDto().setTameio(tameioField.getText().trim());
					N.getDto().setTaytotita(taytotitaField.getText());
					N.getDto().setTk(tkField.getText().trim());
					N.getDto().setType(type);
					N.getDto().setUpsos(ypsosField.getText());
					N.getDto().setVaros(varosField.getText());
					N.getDto().setFamily_statement(oikogeneiaField.getText());
					if(femaleField.isSelected())
						N.getDto().setGender("F");
					else if(maleField.isSelected())
						N.getDto().setGender("M");						
					
					int day1=(int) daySpinner.getValue();
					int month1 = (int)monthSpinner.getValue();
					int year1 = (int)yearSpinner.getValue();
					
					String date1 = Integer.toString(day1) + "/"+ Integer.toString(month1)+ "/"+Integer.toString(year1);
					N.getDto().setBirth_date(date1);
					DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
					Date dateOfPut1 = new Date();
					System.out.println(dateFormat1.format(dateOfPut1));
					N.save_User_in_DB(false);
					System.out.println("TOKANA");
					new addToClinicFrame(null,null,N,user);
					this.dispose();
					
					break;
					
				default:  

					Secretary S = new Secretary(username,password,firstNameField.getText().trim(),lastNameField.getText().trim());
					S.getDto().setAddress(dieuthinsiField.getText());
					S.getDto().setAmka(amkaField.getText().trim());
					S.getDto().setCity(poliField.getText());
					S.getDto().setEmail(emailField.getText().trim());
					S.getDto().setFamily_statement(oikogeneiaField.getText());
					S.getDto().setFax(faxField.getText().trim());
					S.getDto().setHouse_phone(homeField.getText().trim());
					S.getDto().setJob_phone(thlErgasiaField.getText().trim());
					S.getDto().setKinito(kinitoField.getText().trim());
					S.getDto().setParatiriseis(commentsField.getText());
					S.getDto().setPatronymo(patronymoField.getText().trim());
					S.getDto().setRegion(perioxiField.getText());
					S.getDto().setTameio(tameioField.getText().trim());
					S.getDto().setTaytotita(taytotitaField.getText());
					S.getDto().setTk(tkField.getText().trim());
					S.getDto().setType(type);
					S.getDto().setUpsos(ypsosField.getText());
					S.getDto().setVaros(varosField.getText());
					S.getDto().setFamily_statement(oikogeneiaField.getText());
					if(femaleField.isSelected())
						S.getDto().setGender("F");
					else if(maleField.isSelected())
						S.getDto().setGender("M");						
					
					int day2=(int) daySpinner.getValue();
					int month2 = (int)monthSpinner.getValue();
					int year2 = (int)yearSpinner.getValue();
					
					String date2 = Integer.toString(day2) + "/"+ Integer.toString(month2)+ "/"+Integer.toString(year2);
					S.getDto().setBirth_date(date2);
					DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
					Date dateOfPut2 = new Date();
					System.out.println(dateFormat2.format(dateOfPut2));
					S.save_User_in_DB(false);
					System.out.println("TOKANA");
					
					this.dispose();
					new SecretaryOffice(user);
										
					break;
				}
			}
			
		}	
			
			
	}


	private boolean elegxosStoixeiwn() {
		if(firstNameField.getText().trim().equals("") || lastNameField.getText().trim().equals("") )
		{	warning("Συμπληρώστε ονοματεπώνυμο");
			return false;
		}
		
		if(dieuthinsiField.getText().trim().equals("") && poliField.getText().trim().equals(""))
		{
			warning("Συμπληρώστε στοιχεία κατοικίας");
			return false;
		}
		
		if( characterFound(thlErgasiaField.getText().trim().replaceAll(" ","")) || characterFound(homeField.getText().trim().replaceAll(" ","")) || characterFound(kinitoField.getText().trim().replaceAll(" ","")))
		{
			warning("Aφαιρέστε τις παύλες και τους χαρακτήρες από τους αριθμούς επικοινωνίας");
			return false;
		}
		
		if( fakeNumber(thlErgasiaField.getText().trim().replaceAll(" ","")) || fakeNumber(homeField.getText().trim().replaceAll(" ","")) || fakeNumber(kinitoField.getText().trim().replaceAll(" ","")))
		{
			warning("Ο αριθμός που συμπληρώσατε δεν αντιστοιχεί σε τηλέφωνο");
			return false;
		}
	
		if(thlErgasiaField.getText().trim().equals("") && homeField.getText().trim().equals("") && kinitoField.getText().trim().equals(""))
		{	warning("Πρέπει να συμπληρωθεί έστω ένα στοιχείο επικοινωνίας");
			return false;
		}
		
		if(thlErgasiaField.getText().trim().replaceAll(" ","").length()!=10 && thlErgasiaField.getText().trim().length()!=0)
		{  warning("Τα ψηφία στον αριθμό εργασίας πρέπει να είναι δέκα");
			return false;
		}
		
		if(kinitoField.getText().trim().replaceAll(" ","").length()!=10 && kinitoField.getText().trim().length()!=0)
		{ warning("Τα ψηφία στον αριθμό κινητού πρέπει να είναι δέκα");
			return false;
		}
		
		if(homeField.getText().trim().replaceAll(" ","").length()!=10 && homeField.getText().trim().replaceAll(" ","").length()!=0)
		{ warning("Τα ψηφία στο τηλέφωνο σπιτιού πρέπει να είναι δέκα");
			return false;
		}
				
		return true;}
		
	private boolean fakeNumber(String ss) {
		try{
			if(ss.charAt(0) == '2' || (ss.charAt(0)=='6' && ss.charAt(1)=='9'))
				return false;
			
			return true;
			
		}catch(StringIndexOutOfBoundsException e){
			return false;
		}
		
		
	
	}


	private boolean characterFound(String trim) {
		try{
		for(int i=0; i<trim.length();i++){
			if(trim.charAt(i) > '9' || trim.charAt(i)<'0')
				return true;
			}
		
			return false;
			
		}catch(StringIndexOutOfBoundsException e){
			return false;
		}
		
		
	}


	private void warning(String s){
		JOptionPane.showMessageDialog(null,
				s,
		    "Λανθασμένα στοιχεία",
		    JOptionPane.ERROR_MESSAGE);
	}
		
}

