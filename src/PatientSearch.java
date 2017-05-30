import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class PatientSearch implements ActionListener{

	private JButton showButton;
	private JTextPane textFieldSearch;
	private JButton searchButton ;
	private JButton button;
	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private User user;
	

	public PatientSearch(User u) {
		
		initialize1(u);
		//else
		//initialize();	
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	private  void initialize1(User u) {
		this.user=User.loadUser(u.getUser_name());
		
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 60, 748, 234);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"first", "last","personal_tel","AMKA"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(45, 30, 183, 20);
		frame.getContentPane().add(comboBox);
		
		
		textFieldSearch = new JTextPane();
		textFieldSearch.setBounds(281, 29, 295, 20);
		frame.getContentPane().add(textFieldSearch);
		
		button = new JButton("Πίσω");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!user.hasClinic()){
					frame.dispose();
					new SecretaryOffice((Secretary)user);
				}
				else{
					frame.dispose();
					new Γιατρός_Νοσηλευτής(user);
				}
			}
		});
		button.setBounds(29, 322, 163, 32);
		frame.getContentPane().add(button);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(610, 29, 183, 20);
		searchButton.addActionListener(this);
		frame.getContentPane().add(searchButton);
		
		showButton = new JButton("Εμφάνιση στοιχείων");
		showButton.setBounds(579, 331, 198, 32);
		showButton.addActionListener(this);
		frame.getContentPane().add(showButton);
		
		if(user.hasClinic()){
			Connection conn=null;
			try{
				conn=User.getConnection();
				
				String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where clinic="+user.getDto().getClinic();
				System.out.println(textFieldSearch.getText()); 
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet res = statement.executeQuery();
				
				table.setModel(PatientSearch.resultSetToTableModel(res));
				table.setSelectionBackground(Color.BLUE);
				table.setSelectionForeground(Color.CYAN);
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		else{
			Connection conn=null;
			try{
				conn=User.getConnection();
				
				String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis "; 
				System.out.println(textFieldSearch.getText()); 
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet res = statement.executeQuery();
				
				table.setModel(PatientSearch.resultSetToTableModel(res));
				table.setSelectionBackground(Color.BLUE);
				table.setSelectionForeground(Color.CYAN);
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
		
		frame.setVisible(true);
		
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
		if (e.getSource()==searchButton){
			if(!user.hasClinic()){
					//ANAZHTHSH
					Connection conn=null;
					try{
						conn=User.getConnection();
					}catch(Exception exception){
						System.out.println("Couldnt connect to database");
						exception.printStackTrace();
					}
					
					String selection = (String)comboBox.getSelectedItem();
					String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where "+selection+" like '%"+textFieldSearch.getText()+"%' ";
					
					
					try {
						System.out.println(textFieldSearch.getText()); 
						
						PreparedStatement statement = conn.prepareStatement(query);
						ResultSet res = statement.executeQuery();
						
						table.setModel(resultSetToTableModel(res));
						table.setSelectionBackground(Color.BLUE);
						table.setSelectionForeground(Color.CYAN);
						
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
			}
			else{
				Connection conn=null;
				try{
					conn=User.getConnection();
				}catch(Exception exception){
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}
				
				String selection = (String)comboBox.getSelectedItem();
				String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where "+selection+" like '%"+textFieldSearch.getText()+"%' and "
						+ "clinic = (select kliniki from Users where username='"+user.getUser_name()+"')";
				
				
				try {
					System.out.println(textFieldSearch.getText()); 
					
					PreparedStatement statement = conn.prepareStatement(query);
					ResultSet res = statement.executeQuery();
					
					table.setModel(resultSetToTableModel(res));
					table.setSelectionBackground(Color.BLUE);
					table.setSelectionForeground(Color.CYAN);
					
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
				
				
			}
			
		}
		
		if(e.getSource()==showButton){
			if(!user.hasClinic()){
				try{
					int row = table.getSelectedRow();
					String amka =  table.getModel().getValueAt(row,2).toString();
					frame.dispose();
					new	VasikaStoixeiaAstheni(amka,(Secretary)user);
				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"Δεν έχει επιλεγεί τίποτα","No row selected",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
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
			
		}
				
		
		}

		public static TableModel resultSetToTableModel(ResultSet rs) {
	        try {
	            ResultSetMetaData metaData = rs.getMetaData();
	            int numberOfColumns = metaData.getColumnCount();
	            Vector columnNames = new Vector();

	            // Get the column names
	            for (int column = 0; column < numberOfColumns; column++) {
	                columnNames.addElement(metaData.getColumnLabel(column + 1));
	            }

	            // Get all rows.
	            Vector rows = new Vector();

	            while (rs.next()) {
	                Vector newRow = new Vector();

	                for (int i = 1; i <= numberOfColumns; i++) {
	                    newRow.addElement(rs.getObject(i));
	                }

	                rows.addElement(newRow);
	            }

	            return new UneditableTableModel(rows, columnNames);
	        } catch (Exception e) {
	            e.printStackTrace();

	            return null;
	        }
	    }

}