import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;

public class SearchDoctors implements ActionListener{

	private JButton showButton;
	private JTextPane textFieldSearch;
	private JButton searchButton ;
	private JButton button;
	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private Secretary user;
	/**
	 * Launch the application.
	 */

	public SearchDoctors(Secretary u) {
		this.user=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	private  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 411);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 60, 748, 234);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"first_name", "last_name","eidikotita","username"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(194, 29, 193, 20);
		frame.getContentPane().add(comboBox);
		
		
		textFieldSearch = new JTextPane();
		textFieldSearch.setCaretColor(Color.black);
		
		textFieldSearch.setBounds(410, 29, 183, 20);
		frame.getContentPane().add(textFieldSearch);
		
		button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice(user);
			}
		});
		button.setBounds(29, 322, 163, 32);
		frame.getContentPane().add(button);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(603, 29, 174, 20);
		searchButton.addActionListener(this);
		frame.getContentPane().add(searchButton);
		
		Connection conn=null;
		try{
			conn=User.getConnection();
		
			String query = "select first_name as onoma, last_name as eponymo, eidikotita,username,kinito from Users where type<3";
			
			
			System.out.println(textFieldSearch.getText()); 
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			table.setModel(PatientSearch.resultSetToTableModel(res));
			table.setSelectionBackground(Color.RED);
			table.setSelectionForeground(Color.WHITE);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}

		
		
		
		
		
		
		showButton = new JButton("�������� ���������");
		showButton.setBounds(594, 314, 183, 49);
		showButton.addActionListener(this);
		frame.getContentPane().add(showButton);
		
		
		frame.setVisible(true);
		
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==searchButton){
					//ANAZHTHSH
					Connection conn=null;
					try{
						conn=User.getConnection();
					}catch(Exception exception){
						System.out.println("Couldnt connect to database");
						exception.printStackTrace();
					}
					
					String selection = (String)comboBox.getSelectedItem();
					String query = "select first_name as onoma, last_name as eponymo, eidikotita,username,kinito from Users where "+selection+" like '%"+textFieldSearch.getText()+"%' and type < 3";
					
					
					try {
						System.out.println(textFieldSearch.getText()); 
						
						PreparedStatement statement = conn.prepareStatement(query);
						ResultSet res = statement.executeQuery();
						
						table.setModel(PatientSearch.resultSetToTableModel(res));
						table.setSelectionBackground(Color.RED);
						table.setSelectionForeground(Color.WHITE);
						
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
			}
		
		
			if(e.getSource()==showButton){
				int row = table.getSelectedRow();
				String username =  table.getModel().getValueAt(row,3).toString();
				frame.dispose();	
				new ��������������Frame(username,user);
			}
					
		
		}
}