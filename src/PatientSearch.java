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
	 * TRICKY йкасг. се пеяиптысг поу о вягстгс еимаи циатяос г мосгкеутгс елжамифомтаи акка омолата апо аута ам еимаи упаккгкос.
	 * еписгс се пеяиптысг епикоцгс аутым елжамифомтаи акка пяацлата се свесг ле том упаккгко цяаллатеиас.
	 * ауто епитуцваметаи опыс ха доуле ле тгм леходо гаS_CLINIC() г опоиа пяодидеи ам о вягстгс лас евеи йкимийг.
	 * 
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
		
		button = new JButton("пъСЫ");//|г HAS_CLINIC пио сыста ха епяепе ма кецетаи IsNotYpallilos().|
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //еды циметаи о пяытос диавыяислос
				if(!user.hasClinic()){	//ам патгсеи писы йаи евеи йкимийг лпаимеи  сто INTERFACE тоу циатяоу/мосгкеутг
					frame.dispose();
					
					new SecretaryOffice((Secretary)user); //Alliws stin arxikh toy ypallilou
				}
				else{
					frame.dispose();
					new цИАТЯЭР_мОСГКЕУТчР(user);
				}
			}
		});
		button.setBounds(29, 322, 163, 32);
		frame.getContentPane().add(button);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(610, 29, 183, 20);
		searchButton.addActionListener(this);
		frame.getContentPane().add(searchButton);
		
		showButton = new JButton("еЛЖэМИСГ СТОИВЕъЫМ");
		showButton.setBounds(579, 331, 198, 32);
		showButton.addActionListener(this);
		frame.getContentPane().add(showButton);
		
		//2o невыяисла!!!  ам евеи йкимийг бкепеи та енгс омолата
		if(user.hasClinic()){
			Connection conn=null;
			try{
				conn=User.getConnection();	
																													//осоус амгйоуме стгм йкимийг тоу !!!!!
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
								//аккиыс тоу бкепеи окоус!!! (пио йаты олыс ха доуле оти бкепеи поку кицотеяа стоивеиа циа аутоус)
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
			if(!user.hasClinic()){ //се пеяиптысг амафгтгсгс циметаи амафгтгсг ле басг оти епикевхгйе
					
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
						//та апотекеслата патма стом TABLE
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
				
				String selection = (String)comboBox.getSelectedItem();			//ам евеи йкимийг цимтаи амафгтгсг акка памта ломо стгм йкимийг тоу
				String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where "+selection+" like '%"+textFieldSearch.getText()+"%' and "
						+ "clinic = (select kliniki from Users where username='"+user.getUser_name()+"')";	//лесы SQL емтокгс паиямы тгм йкимийг тоу вягстг
				
				
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
			if(!user.hasClinic()){ //3О басийотеяо невыяисла
				try{
					int row = table.getSelectedRow();	
					String amka =  table.getModel().getValueAt(row,2).toString();
					frame.dispose();
					new	VasikaStoixeiaAstheni(amka,(Secretary)user); //ам епикецеи йати апо том упаккгко бкепеи тгм VasikaStoixeiaAstheni. поу пеяиевеи апкес пкгяожояиес
				}
				catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"дЕМ щВЕИ ЕПИКЕЦЕъ ТъПОТА","No row selected",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				try{
				int row = table.getSelectedRow();
				String amka =  table.getModel().getValueAt(row,2).toString();
				frame.dispose();
				Patient p = Patient.loadPatient(amka);	
				new PatientFrame(p,user);	//о циатяос/мосгкеутгс олыс бкепеи йамомийа, том пкгяг жайеко тоу асхемг.
				}catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null,"дЕМ щВЕИ ЕПИКЕЦЕъ ТъПОТА","No row selected",JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
				
		
		}
		//летатяепеи то RESULT поу епистяежетаи се табLE 
		public static TableModel resultSetToTableModel(ResultSet rs) {
	        try {
	            ResultSetMetaData metaData = rs.getMetaData();
	            int numberOfColumns = metaData.getColumnCount();
	            Vector columnNames = new Vector();

	           
	            for (int column = 0; column < numberOfColumns; column++) {
	                columnNames.addElement(metaData.getColumnLabel(column + 1));
	            }

	            
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