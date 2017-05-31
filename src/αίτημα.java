import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class АъТГЛА {

	private JComboBox comboBox;
	private JFrame frame;
	private User user;
	private JTextField searchField;

	private JTable table;
	
/*
 * лесы аутгс тгс йкасгс о циатяос г о мосгкеутгс фгтаеи та стоивеиа емос асхемг том опоио том
 * бягсйеи лсеы тоу COMBOBOX йаи тоу SEARCHFIELD
 */


	
	public АъТГЛА(User user) {
		this.user=user;
		initialize(user);
	}

	private void initialize(User user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"first", "last","AMKA"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(46, 29, 183, 20);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("пъСЫ");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();			//PATONTAS PISW PAEI STHN ARXIKH TOY
				new цИАТЯЭР_мОСГКЕУТчР(user);
			
			}});
		
		
		button.setBounds(34, 315, 163, 32);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("аПОСТОКч АИТчЛАТОР"); //AN патгсеи апостокг
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String amka =  table.getModel().getValueAt(row,2).toString(); //калбаметаи г епикоцг тоу
				
				try{
					Connection conn=User.getConnection();
					String query = "select username from Users where type = 3";	//ажоу евоуле то алйа тоу асхемг
					PreparedStatement statement = conn.prepareStatement(query);
					ResultSet res = statement.executeQuery();
					Aithma aitima = new Aithma(user,amka);	//стекметаи се окоус тоус вягстес тгс цяаллатеиас емглеяысг оти о 
					while(res.next()){						//циатяос аутос фгтаеи та стоивеиа тоу асхемг ле алйа = amka
						Secretary S = (Secretary)User.loadUser(res.getString("username"));
						S.addAithma(aitima); //окои калбамоум то идио аитгла
						S.save_User_in_DB(true);					
					}
					JOptionPane.showMessageDialog(null,		
						    "то аитгла естакг",
						    "MESSAGE SEND",
						    JOptionPane.INFORMATION_MESSAGE);//отам стакхеи то лумгла елжамифетаи г емглеяысг
				
					
				}catch(ArrayIndexOutOfBoundsException ep){		//аккиыс дем евеи епикецеи йати
					JOptionPane.showMessageDialog(null,		
						    "дЕМ щВЕИ ЕПИКЕЦЕъ АСХЕМчР",
						    "NOTHING SELECTED",
						    JOptionPane.WARNING_MESSAGE);
				
				}catch(Exception exception){	//г пяоейуье йапоио хела ле тг басг
					
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}
							
			}
		});
		button_1.setBounds(584, 324, 198, 32);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Search");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
				try{
					conn=User.getConnection();
				}catch(Exception exception){
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}
							//ам патгсеи амафгтгсг тоте амакоца ле то ти епекене сто COMBOBOX 
				String selection = (String)comboBox.getSelectedItem(); //циметаи г амафгтгсг стг басг
				String query = "select first as onoma, last as eponymo, AMKA from Astheneis where "+selection+" like '%"+searchField.getText()+"%' and clinic!="+user.getDto().getClinic();
				
				
				try {
					System.out.println(searchField.getText()); 
					
					PreparedStatement statement = conn.prepareStatement(query);
					ResultSet res = statement.executeQuery();
					//йаи та стоивеиа та паиямеи о TABLE
					table.setModel(resultSetToTableModel(res));
					table.setSelectionBackground(Color.BLUE);
					table.setSelectionForeground(Color.CYAN);
					
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
			
			}
		});
		button_2.setBounds(615, 22, 183, 20);
		frame.getContentPane().add(button_2);
		
		searchField = new JTextField();
		searchField.setBounds(281, 22, 305, 20);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 70, 674, 234);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		Connection conn=null;
		try{		
			conn=User.getConnection();
			//AN DEN GINEI TIPOTA, ARXIKA STO XRHSTH EMFANIZONTAI OLOI OI ASTHENEIS EKTOS THS KLINIKIS TOY MIAS KAI GIA AYTOYS EXEI NOHMA NA ZHTHSEI TA STOIXEIA.
			String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where clinic!="+this.user.getDto().getClinic(); 
			System.out.println(searchField.getText()); 
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

	public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            //DHMIOYRGIA PINAKA MESW TWN APOTELESMATWN TOY RESULT SET
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

