import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SecretaryOffice extends JFrame implements ActionListener{

	private JButton btnAnoigmaKartelas ;
	private JButton btnDhmiourgiasXrhsth ;
	private JButton btnDoctorSearch ;
	private JButton btnPatientSearch;
	private JButton btnDisconnect ;
	private JButton clinicButton;
	private Secretary user;
	private JTextField textField;
	private JButton showButton;
	private JButton diagrafiButton;
	private JButton paraxwrhshButton;
	/*
	 * Εδώ βρίσκεται η αρχική σελίδα του υπαλλήλου γραμματείας
	 	Όλο το "ζουμί", είναι H ActionListener, ουσιαστικά γεμίζεται το φρέιμ με πλήκτρα και 
	 	το καθένα ανοίγει κάποιο νέο frame.
	 */
	
	public SecretaryOffice(Secretary u){
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		
	
				
		
		this.user=u;
		this.setResizable(false);
		this.setTitle("Secretary's office");
		this.setBounds(100, 100, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		btnAnoigmaKartelas = new JButton("’νοιγμα καρτέλας ασθενούς");
		btnAnoigmaKartelas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAnoigmaKartelas.setBounds(169, 70, 259, 58);
		btnAnoigmaKartelas.addActionListener(this);
		this.getContentPane().add(btnAnoigmaKartelas);
		
		btnDhmiourgiasXrhsth = new JButton("Δημιουργία Χρήστη");
		btnDhmiourgiasXrhsth.setBounds(190, 139, 220, 23);
		btnDhmiourgiasXrhsth.addActionListener(this);
		this.getContentPane().add(btnDhmiourgiasXrhsth);
		
		btnDoctorSearch = new JButton("Αναζήτηση Γιατρών");
		btnDoctorSearch.setBounds(190, 179, 220, 23);
		btnDoctorSearch.addActionListener(this);
		this.getContentPane().add(btnDoctorSearch);
		
		btnPatientSearch = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD");
		btnPatientSearch.setBounds(190, 219, 220, 23);
		btnPatientSearch.addActionListener(this);
		this.getContentPane().add(btnPatientSearch);
		
		btnDisconnect = new JButton("Αποσύνδεση");
		btnDisconnect.addActionListener(this);
		btnDisconnect.setBounds(244, 314, 120, 23);
		this.getContentPane().add(btnDisconnect);
		
		clinicButton = new JButton("Δημιουργία Νέας Κλινικής");
		clinicButton.addActionListener(this);
		clinicButton.setBounds(190, 253, 220, 23);
		getContentPane().add(clinicButton);
		
		JLabel lblNewLabel = new JLabel("Αιτήματα");
		lblNewLabel.setBounds(10, 11, 73, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(73, 8, 67, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		showButton = new JButton("Προβολή");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			user.showFrameAithmatwn();
			}
		});
		showButton.setBounds(10, 36, 130, 23);
		getContentPane().add(showButton);
		
		diagrafiButton = new JButton("Διαγραφή");
		diagrafiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameDiagrafis(user);	
			}
		});
		diagrafiButton.setBounds(10, 70, 130, 23);
		getContentPane().add(diagrafiButton);
		this.setVisible(true);
		
		
				
			
		textField.setText(Integer.toString(user.plithosAitimatwn()));
		
		paraxwrhshButton = new JButton("Παραχώρηση Στοιχείων");
		paraxwrhshButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		paraxwrhshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frameParaxwrhshs(user);
						
			}
		});
		paraxwrhshButton.setBounds(164, 7, 170, 23);
		
		
		
		
		//ΑΝ Ο ΧΡΗΣΤΗΣ ΕΧΕΙ ΚΑΠΟΙΟ ΝΕΟ ΑΙΤΗΜΑ ΕΜΦΑΝΙΖΕΤΑΙ ΕΝΗΜΕΡΩΣΗ
		getContentPane().add(paraxwrhshButton);
		
		if(user.newAithma()){
			user.setNewAithma(eidopoihsh());
			user.save_User_in_DB(true);
		}
		
		
		
		
	}
		
	
	private boolean eidopoihsh() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 217);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		btnNewButton.setBounds(105, 142, 210, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u039D\u0395\u039F \u0391\u0399\u03A4\u0397\u039C\u0391");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(62, 21, 290, 82);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);	
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnDhmiourgiasXrhsth){
			System.out.println("NAI RE PAOKARA");
			this.dispose();
			new ΔημιουργίαΧρήστη(user);
		}
		if (e.getSource()==btnDoctorSearch){
			this.dispose();
			new SearchDoctors(user);
		}
		if(e.getSource()==btnAnoigmaKartelas){
			this.dispose();
			new ΚαρτέλαΑσθενούς(user);
		}
		if(e.getSource()==btnPatientSearch){
			this.dispose();
			new PatientSearch(user);
		}
		if(e.getSource()==clinicButton){
			new ClinicCreateFrame(user);
			this.dispose();
		}if(e.getSource()==btnDisconnect){
			this.dispose();
			new InitialScreen();
		}
	}
}
