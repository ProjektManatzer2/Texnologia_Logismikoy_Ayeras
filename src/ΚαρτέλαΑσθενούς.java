import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ΚαρτέλαΑσθενούς extends JFrame implements ActionListener{
	
	private JSpinner daySpinner;
	private JRadioButton maleRadio ;
	private JRadioButton femaleRadio;
	private JSpinner monthSpinner;
	private JSpinner yearSpinner ;
	private JTextPane commentsField;
	private JButton nextButton;
	private JButton cancelButton;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private JTextField f_nameField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField varosField;
	private JTextField ypsosField;
	private JTextField addressField;
	private JTextField regionField;
	private JTextField cityField;
	private JTextField tkField;
	private JTextField workField;
	private JTextField tameioField;
	private JTextField katastasiField;
	private JTextField amkaField;
	private JTextField amaField;
	private JTextField taytotitaField;
	private JTextField kinitoField;
	private JTextField houseField;
	private JTextField douleiaField;
	private JTextField faxField;
	private JTextField e_mailField;
	private JLabel textField_19;
	private User user;


	public ΚαρτέλαΑσθενούς(User aUser) {
		this.user=aUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param aUser 
	 */
	private void initialize() {
		this.getContentPane().setEnabled(false);
		this.setResizable(false);
		this.setTitle("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BA\u03B1\u03C1\u03C4\u03AD\u03BB\u03B1\u03C2 \u03B1\u03C3\u03B8\u03B5\u03BD\u03BF\u03CD\u03C2");
		this.setBounds(100, 100, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		lblNewLabel.setBounds(14, 10, 50, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		firstTextField = new JTextField();
		firstTextField.setBounds(74, 10, 170, 20);
		firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
		firstTextField.setColumns(10);
		
		JLabel label = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF :");
		label.setBounds(262, 10, 60, 20);
		
		lastTextField = new JTextField();
		lastTextField.setHorizontalAlignment(SwingConstants.CENTER);
		lastTextField.setBounds(336, 10, 170, 20);
		lastTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(520, 10, 72, 20);
		
		f_nameField = new JTextField();
		f_nameField.setHorizontalAlignment(SwingConstants.CENTER);
		f_nameField.setBounds(604, 10, 170, 20);
		f_nameField.setColumns(10);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(lblNewLabel);
		this.getContentPane().add(firstTextField);
		this.getContentPane().add(label);
		this.getContentPane().add(lastTextField);
		this.getContentPane().add(lblNewLabel_1);
		this.getContentPane().add(f_nameField);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A6\u03CD\u03BB\u03BB\u03BF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(17, 34, 233, 46);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		maleRadio = new JRadioButton("\u0386\u03BD\u03B4\u03C1\u03B1\u03C2");
		maleRadio.setBounds(6, 16, 109, 23);
		panel.add(maleRadio);
		buttonGroup.add(maleRadio);
		maleRadio.setHorizontalAlignment(SwingConstants.CENTER);
		
		femaleRadio = new JRadioButton("\u0393\u03C5\u03BD\u03B1\u03AF\u03BA\u03B1\r\n");
		femaleRadio.setBounds(124, 16, 105, 23);
		panel.add(femaleRadio);
		buttonGroup.add(femaleRadio);
		
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
		yearSpinner.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(1900), null, new Integer(1)));
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
		
		JLabel lblNewLabel_4 = new JLabel("XXXX");
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
		lblNewLabel_9.setBounds(6, 16, 65, 20);
		panel_1.add(lblNewLabel_9);
		
		addressField = new JTextField();
		addressField.setBounds(75, 16, 86, 20);
		panel_1.add(addressField);
		addressField.setHorizontalAlignment(SwingConstants.CENTER);
		addressField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		lblNewLabel_10.setBounds(11, 46, 60, 20);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		
		regionField = new JTextField();
		regionField.setBounds(75, 46, 86, 20);
		panel_1.add(regionField);
		regionField.setHorizontalAlignment(SwingConstants.CENTER);
		regionField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		lblNewLabel_11.setBounds(11, 76, 60, 20);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cityField = new JTextField();
		cityField.setBounds(75, 76, 86, 20);
		panel_1.add(cityField);
		cityField.setHorizontalAlignment(SwingConstants.CENTER);
		cityField.setColumns(10);
		
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
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03B1\u03C3\u03C6\u03B1\u03BB\u03B9\u03C3\u03BC\u03AD\u03BD\u03BF\u03C5 & \u03BB\u03BF\u03B9\u03C0\u03AC \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(202, 89, 578, 133);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("\u0395\u03C0\u03AC\u03B3\u03B3\u03B5\u03BB\u03BC\u03B1 :\r\n");
		lblNewLabel_13.setBounds(11, 18, 105, 20);
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		
		workField = new JTextField();
		workField.setBounds(120, 18, 150, 20);
		panel_2.add(workField);
		workField.setHorizontalAlignment(SwingConstants.CENTER);
		workField.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03AF\u03BF :");
		lblNewLabel_14.setBounds(11, 56, 105, 20);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tameioField = new JTextField();
		tameioField.setBounds(120, 56, 150, 20);
		panel_2.add(tameioField);
		tameioField.setHorizontalAlignment(SwingConstants.CENTER);
		tameioField.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("\u039F\u03B9\u03BA\u03BF\u03B3. \u03BA\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 :\r\n");
		lblNewLabel_15.setBounds(11, 94, 107, 20);
		panel_2.add(lblNewLabel_15);
		
		katastasiField = new JTextField();
		katastasiField.setBounds(120, 94, 150, 20);
		panel_2.add(katastasiField);
		katastasiField.setHorizontalAlignment(SwingConstants.CENTER);
		katastasiField.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("\u0391\u039C\u039A\u0391 :");
		lblNewLabel_16.setBounds(343, 18, 45, 20);
		panel_2.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		
		amkaField = new JTextField();
		amkaField.setBounds(402, 18, 170, 20);
		panel_2.add(amkaField);
		amkaField.setHorizontalAlignment(SwingConstants.CENTER);
		amkaField.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("\u0391\u039C\u0391 :");
		lblNewLabel_17.setBounds(343, 56, 45, 20);
		panel_2.add(lblNewLabel_17);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		
		amaField = new JTextField();
		amaField.setBounds(402, 56, 170, 20);
		panel_2.add(amaField);
		amaField.setHorizontalAlignment(SwingConstants.CENTER);
		amaField.setColumns(10);
		
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
		
		houseField = new JTextField();
		houseField.setBounds(76, 47, 86, 20);
		panel_3.add(houseField);
		houseField.setHorizontalAlignment(SwingConstants.CENTER);
		houseField.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2 :");
		lblNewLabel_21.setBounds(251, 16, 75, 20);
		panel_3.add(lblNewLabel_21);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
		
		douleiaField = new JTextField();
		douleiaField.setBounds(331, 16, 86, 20);
		panel_3.add(douleiaField);
		douleiaField.setHorizontalAlignment(SwingConstants.CENTER);
		douleiaField.setColumns(10);
		
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
		
		e_mailField = new JTextField();
		e_mailField.setBounds(558, 28, 200, 20);
		panel_3.add(e_mailField);
		e_mailField.setHorizontalAlignment(SwingConstants.CENTER);
		e_mailField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 312, 385, 120);
		this.getContentPane().add(scrollPane);
		
		commentsField = new JTextPane();
		commentsField.setText("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2 :");
		scrollPane.setViewportView(commentsField);
		
		textField_19 = new JLabel();
		textField_19.setText("\u0397\u03BC\u03B5\u03C1/\u03BD\u03AF\u03B1 \u03B5\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE\u03C2 :\r\n");
		textField_19.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_19.setBounds(544, 312, 120, 20);
		this.getContentPane().add(textField_19);
		
		nextButton = new JButton("\u0395\u03C0\u03CC\u03BC\u03B5\u03BD\u03BF");
		nextButton.addActionListener(this);
		nextButton.setBounds(695, 437, 89, 23);
		this.getContentPane().add(nextButton);
		
		cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
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
		
		
		if(e.getSource()==nextButton){
			
			Patient P = new Patient(amkaField.getText().trim().replaceAll(" ","").replaceAll("-",""), firstTextField.getText(),lastTextField.getText());
			P.getPdto().setAddress(addressField.getText());
			P.getPdto().setCity(cityField.getText());
			P.getPdto().setEmail(e_mailField.getText().trim());
			P.getPdto().setFax(faxField.getText().trim());
			P.getPdto().setHome_tel(houseField.getText().trim().replaceAll("-","").replaceAll(" ",""));
			P.getPdto().setJob_tel(douleiaField.getText().trim().replaceAll("-","").replaceAll(" ",""));
			P.getPdto().setPersonal_tel(kinitoField.getText().trim().replaceAll("-","").replaceAll(" ",""));
			P.getPdto().setComments(commentsField.getText());
			P.getPdto().setF_name(f_nameField.getText().trim());
			P.getPdto().setRegion(regionField.getText());
			P.getPdto().setInsurance_institution(tameioField.getText().trim());
			P.getPdto().setTaytotita(taytotitaField.getText());
			P.getPdto().setPost_code(tkField.getText().trim());
			P.getPdto().setHeight(ypsosField.getText());
			P.getPdto().setWeight(varosField.getText());
			P.getPdto().setStatus(katastasiField.getText());		
			if(femaleRadio.isSelected())
				P.getPdto().setGender("F");
			else if(maleRadio.isSelected())
				P.getPdto().setGender("M");						
			
			int day=(int) daySpinner.getValue();
			int month = (int)monthSpinner.getValue();
			int year = (int)yearSpinner.getValue();
			
		String date = Integer.toString(day) + "/"+ Integer.toString(month)+ "/"+Integer.toString(year);
		P.getPdto().setDate_of_birth(date);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfPut = new Date();
		System.out.println(dateFormat.format(dateOfPut));
		if(elegxos()){
		P.save_Patient_in_DB(false);
		this.dispose();
		}
			
			
			
			
			
		}
		
		
		
	}

	private boolean elegxos() {
		String arithmos_spiti=houseField.getText().trim().replaceAll("-","").replaceAll(" ","");
		String kinito=kinitoField.getText().trim().replaceAll("-","").replaceAll(" ","");
		String arithmos_ergasia=douleiaField.getText().trim().replaceAll("-","").replaceAll(" ","");;
		String amka=amkaField.getText().trim().replaceAll(" ","").replaceAll("-","");
		int Want_arithmos=0;
		if(firstTextField.getText().replaceAll(" ","").equals("") || lastTextField.getText().replaceAll(" ","").equals("") ){
			JOptionPane.showMessageDialog(null,"Πρέπει να συμπληρωθεί όνομα και επώνυμο","Error Found",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try{
			if(amka.length()!=11 || amkaExists(amka)){
				
				JOptionPane.showMessageDialog(null,"Λάθος ΑΜΚΑ","Error Found",JOptionPane.ERROR_MESSAGE);
				return false;}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Couldn't Connect to Database","Failed to Connect",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
		
		
		if(fakeNumber(arithmos_spiti)||fakeNumber(arithmos_ergasia)||fakeNumber(kinito)){
			JOptionPane.showMessageDialog(null,"Ο αριθμός δεν αντιστοιχεί σε τηλέφωνο","Error Found",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(arithmos_spiti.length()!=10 && arithmos_spiti.length()!=0)
		{ JOptionPane.showMessageDialog(null,"Ο αριθμός δεν αντιστοιχεί σε τηλέφωνο","Error Found",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(arithmos_ergasia.length()!=10 && arithmos_ergasia.length()!=0)
		{  JOptionPane.showMessageDialog(null,"Ο αριθμός δεν αντιστοιχεί σε τηλέφωνο","Error Found",JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		
		if(kinito.length()!=10 && kinito.length()!=0)
		{	JOptionPane.showMessageDialog(null,"Ο αριθμός δεν αντιστοιχεί σε τηλέφωνο","Error Found",JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		
		if(kinito.length()==0 && arithmos_ergasia.length()==0 && arithmos_spiti.length()==0){
			JOptionPane.showMessageDialog(null,"Πρέπει να συμπληρωθεί έστω ένα στοχιείο επικοινωνίας","Error Found",JOptionPane.ERROR_MESSAGE);
			 return false;
		}
				
				
			
						
		return true;		
	}
	
	
	private boolean fakeNumber(String ss) {
		try{
			if(ss.charAt(0) == '2' || (ss.charAt(0)=='6' && ss.charAt(1)=='9'))
				return false;
			
			return true;
			
		}catch(StringIndexOutOfBoundsException e){
			return false;
		}
	}

	private boolean amkaExists(String amka) throws Exception{


			
			Connection conn = User.getConnection();
		
			String sql = "Select amka from Astheneis where amka = '"+amka+"'";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result =statement.executeQuery();
			int i=0;
			while(result.next())		//If result returns something, it means that amka already exists.
				i++;
			if (i>0)
				return true;
			return false;
	
	}	

		
	
}
