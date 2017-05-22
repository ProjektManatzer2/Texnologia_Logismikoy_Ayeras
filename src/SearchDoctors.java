import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchDoctors {

	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */

	public SearchDoctors() {
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
		
		
		JTextPane textFieldSearch = new JTextPane();
		textFieldSearch.setBounds(274, 25, 89, 24);
		frame.getContentPane().add(textFieldSearch);
		
		JButton button = new JButton("\u03A0\u03AF\u03C3\u03C9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice();
			}
		});
		button.setBounds(165, 211, 102, 24);
		frame.getContentPane().add(button);
		
		textFieldSearch.addKeyListener(new KeyAdapter() {
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
		frame.setVisible(true);
	}
}
