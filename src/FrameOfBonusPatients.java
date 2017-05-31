import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameOfBonusPatients {

	private JButton showButton;
	private JButton button;
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private User user;
	/*
	 * Σε αυτό το frame εμφανίζονται οι επιπλέον ασθενείς εκτός της κλινικής του γιατρού 
	 * στους οποίους έχει την πρόσβαση στα στοιχεία τους. Το frame αυτό παίνρει τη δομή
	 * δεδομένων amkaBonusPatients του γιατρού/νοσηλευτή και εμφανίζει τα στοιχεία ασθενών
	 * με τα αντίστοιχα ΑΜΚΑ στην βάση δεδομένων. 
	 */
	
	public FrameOfBonusPatients(User user) {
		initialize(user);
	}

	private void initialize(User user) {
		this.user=user;
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 showButton = new JButton("Εμφάνιση στοιχείων");
		 showButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		try{
					int row = table.getSelectedRow();
					String amka =  table.getModel().getValueAt(row,2).toString();
					frame.dispose();
					Patient p = Patient.loadPatient(amka); //ΣΤΟ FRAME ΕΧΟΥΝ ΗΔΗ ΕΜΦΑΝΙΣΤΕΙ ΟΙ ΑΣΘΕΝΕΙΣ. ΑΝΑΛΟΓΑ ΜΕ ΤΟ ΠΟΙΟΣ ΕΠΙΛΕΓΕΤΑΙ ΓΙΝΕΤΑΙ
					new PatientFrame(p,user);	//Η ΕΜΦΑΝΙΣΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ ΠΟΥ ΥΠΑΡΧΟΥΝ ΣΤΟ PATIENTFRAME.
					}catch(ArrayIndexOutOfBoundsException ex){
						JOptionPane.showMessageDialog(null,"Δεν έχει επιλεγεί τίποτα","No row selected",JOptionPane.WARNING_MESSAGE);
					}
		 	
		 	
		 	}
		 });
		showButton.setBounds(498, 364, 198, 32);
		frame.getContentPane().add(showButton);
		
		JButton backButton = new JButton("ΠΙΣΩ");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Γιατρός_Νοσηλευτής(user);
				frame.dispose();
			}
		});
		backButton.setBounds(77, 364, 163, 32);
		frame.getContentPane().add(backButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 26, 721, 327);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		
		
		Connection conn=null;
		try{
			conn=User.getConnection();
			
			ArrayList<String> taAmka=user.getAmka_bonusPatients();//ΠΑΙΡΝΟΥΜΕ ΤΗ ΛΙΣΤΑ ΤΩΝ ΑΜΚΑ ΑΠΟ ΤΟΝ ΧΡΗΣΤΗ
			String query2 = "AMKA = ";	//ΔΗΜΙΟΥΡΓΟΥΜΕ ΑΥΤΟ ΤΟ STRING
			
			for(String s : taAmka){ //ΕΠΕΙΤΑ ΠΡΟΣΘΕΤΟΥΜΕ ΟΛΑ ΤΑ ΑΜΚΑ ΠΟΥ ΥΠΑΡΧΟΝΕ ΚΑΙ ΑΦΟΥ ΕΙΝΑΙ SQL ENTOΛΗ ΒΑΖΟΥΜΕ "OR AMKA=s1 OR AMKA=s2 KLP..."
				query2+=s+" or AMKA = ";
				
			}
			String finalQuery="";	
			for(int i = 0 ; i < query2.length()-11; i++){ //ΣΤΟ ΤΕΛΙΚΟ QUERY ΑΠΛΑ ΑΦΑΙΡΟΥΜΕ ΤΟ ΤΕΛΕΥΤΑΙΟ "or amka = " ΚΑΙ ΣΤΗ ΣΥΝΕΧΕΙΑ ΕΚΤΕΛΟΥΜΕ ΤΗΝ ΕΝΤΟΛΗ.
				finalQuery+=query2.charAt(i);
			}
			
			String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where ";
			query+=finalQuery;

			System.out.println(query);
			
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			table.setModel(PatientSearch.resultSetToTableModel(res)); //ΕΜΦΑΝΙΖΟΝΤΑΙ ΣΤΟ TABLE ΤΑ ΣΤΟΙΧΕΙΑ ΤΩΝ ΑΣΘΕΝΩΝ ΠΟΥ ΕΧΟΥΝ ΑΜΚΑ ΜΕΣΑ ΣΤΗ ΛΙΣΤΑ ΤΟΥ ΧΡΗΣΤΗ.
			table.setSelectionBackground(Color.BLUE);
			table.setSelectionForeground(Color.CYAN);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
	
		
		
		
		
		
		frame.setVisible(true);
	
	
	
	}
}
