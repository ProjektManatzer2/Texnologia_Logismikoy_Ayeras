import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SecretaryOffice extends JFrame implements ActionListener{

	JButton btnAnoigmaKartelas ;
	JButton btnDhmiourgiasXrhsth ;
	JButton btnDoctorSearch ;
	JButton btnPatientSearch;
	JButton btnDisconnect ;
	
	
	
	public SecretaryOffice(){
	
		this.setResizable(false);
		this.setTitle("Secretary's office");
		this.setBounds(100, 100, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		btnAnoigmaKartelas = new JButton("’νοιγμα καρτέλας ασθενούς");
		btnAnoigmaKartelas.setBounds(190, 70, 220, 23);
		btnAnoigmaKartelas.addActionListener(this);
		this.getContentPane().add(btnAnoigmaKartelas);
		
		btnDhmiourgiasXrhsth = new JButton("Δημιουργία Χρήστη");
		btnDhmiourgiasXrhsth.setBounds(190, 110, 220, 23);
		btnDhmiourgiasXrhsth.addActionListener(this);
		this.getContentPane().add(btnDhmiourgiasXrhsth);
		
		btnDoctorSearch = new JButton("Αναζήτηση Γιατρών");
		btnDoctorSearch.setBounds(190, 150, 220, 23);
		btnDoctorSearch.addActionListener(this);
		this.getContentPane().add(btnDoctorSearch);
		
		btnPatientSearch = new JButton("Αναζήτηση Αθενών");
		btnPatientSearch.setBounds(190, 190, 220, 23);
		btnPatientSearch.addActionListener(this);
		this.getContentPane().add(btnPatientSearch);
		
		btnDisconnect = new JButton("Αποσύνδεση");
		btnDisconnect.setBounds(240, 240, 120, 23);
		this.getContentPane().add(btnDisconnect);
		this.setVisible(true);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnDhmiourgiasXrhsth){
			System.out.println("NAI RE PAOKARA");
			this.dispose();
			new ΔημιουργίαΧρήστη();
		}
		if (e.getSource()==btnDoctorSearch){
			this.dispose();
			new SearchDoctors();
		}
		
	}

}
