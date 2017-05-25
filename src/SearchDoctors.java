import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class SearchDoctors implements ActionListener{

	
	private JTextPane textFieldSearch;
	private JButton searchButton ;
	private JButton button;
	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private User user;
	/**
	 * Launch the application.
	 */

	public SearchDoctors(User u) {
		this.user=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	private  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 60, 337, 140);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"first_name", "last_name"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(71, 11, 183, 38);
		frame.getContentPane().add(comboBox);
		
		
		textFieldSearch = new JTextPane();
		textFieldSearch.setBounds(274, 25, 89, 24);
		frame.getContentPane().add(textFieldSearch);
		
		button = new JButton("Πίσω");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice(user);
			}
		});
		button.setBounds(10, 227, 102, 24);
		frame.getContentPane().add(button);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(218, 211, 144, 40);
		searchButton.addActionListener(this);
		frame.getContentPane().add(searchButton);
		
		
		frame.setVisible(true);
		
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
		
				
				Connection conn=null;
				try{
					conn=User.getConnection();
				}catch(Exception exception){
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}
				
				String selection = (String)comboBox.getSelectedItem();
				String query = "select first_name, last_name, eidikothta,kinito from Users where '"+selection+"'=? and type < 3";
				
				
				try {
					PreparedStatement statement = conn.prepareStatement(query);
					statement.setString(1, textFieldSearch.getText());	
					
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
								
				
		
		}




}



/*

	@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					
					Connection conn=null;
					try{
						conn=User.getConnection();
					}catch(Exception e){
						System.out.println("Couldnt connect to database");
						
					}
					String selection = (String)comboBox.getSelectedItem();
					
				String query = "select first_name, last_name, kinito from Users where '"+selection+"'=? ";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, textFieldSearch.getText());
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				pst.close();
				
				} catch(Exception ex) {
				ex.printStackTrace();
				}
				
				} 
		});
*/