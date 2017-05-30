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
	
	public FrameOfBonusPatients(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		this.user=user;
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 showButton = new JButton("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03C9\u03BD");
		 showButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		try{
					int row = table.getSelectedRow();
					String amka =  table.getModel().getValueAt(row,2).toString();
					frame.dispose();
					Patient p = Patient.loadPatient(amka);
					new PatientFrame(p,user);
					}catch(ArrayIndexOutOfBoundsException ex){
						JOptionPane.showMessageDialog(null,"Δεν έχει επιλεγεί τίποτα","No row selected",JOptionPane.WARNING_MESSAGE);
					}
		 	
		 	
		 	}
		 });
		showButton.setBounds(498, 364, 198, 32);
		frame.getContentPane().add(showButton);
		
		JButton backButton = new JButton("\u03A0\u03AF\u03C3\u03C9");
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
			
			ArrayList<String> taAmka=user.getAmka_bonusPatients();
			String query2 = "AMKA = ";
			
			for(String s : taAmka){
				query2+=s+" or AMKA = ";
				
			}
			String finalQuery="";
			for(int i = 0 ; i < query2.length()-11; i++){
				finalQuery+=query2.charAt(i);
			}
			
			String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where ";
			query+=finalQuery;

			System.out.println(query);
			
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			table.setModel(PatientSearch.resultSetToTableModel(res));
			table.setSelectionBackground(Color.BLUE);
			table.setSelectionForeground(Color.CYAN);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
	
		
		
		
		
		
		frame.setVisible(true);
	
	
	
	}
}
