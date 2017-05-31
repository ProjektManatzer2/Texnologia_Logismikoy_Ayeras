import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClinicCreateFrame {

	private JFrame frame;
	private JTextField nameField;
	private JTextField textField;
	private Secretary user;
	
	public ClinicCreateFrame(Secretary u) { //лОМО щМАР ВЯчСТГР ТГР ЦЯАЛЛАТЕъАР ДГЛИОУЯЦЕъ ЙКИМИЙч.
		//аПОТЕКЕъ БщБАИА СПэМИО ЖАИМЭЛЕМО СТА МОСОЙОЛЕъО Г ДГЛИОУЯЦъА МщАР ЙКМИЙчР
		this.user=u;
		initialize();
		}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("╪МОЛА йКИМИЙчР"); 
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(51, 71, 172, 49);
		frame.getContentPane().add(label);
		
		nameField = new JTextField(); //омола йкимийгс лпаимеи еды
		nameField.setBounds(244, 79, 172, 36);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel label_1 = new JLabel("а/а йКИМИЙчР");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(51, 169, 172, 49);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10); 				//тевт FIELD ле то иD тгс йкимийгс
		textField.setBounds(244, 177, 172, 36);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("йАТАВЧЯГСГ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					if(!(nameField.getText().trim().replaceAll(" ","").equals(""))){ //екецвос ам сулпкгяыхгйе то омола
						try{
							Connection conn = User.getConnection();
							int aa = Integer.parseInt(textField.getText()); //летатяопг аяихлоу се INT.
							if(!(nameExists(nameField.getText(),conn) || numberExists(aa,conn))){ //екецвос упаянгс омолатос 
								Clinic c =new Clinic(aa,nameField.getText(),conn);				//йаи аяихлоу стг басг.
								c.saveClinic();    //ам ови г йкмийг дглиоуяцеитаи ле то дыслемо омола йаи ID йаи апохуйеуетаи
								frame.dispose();
								new SecretaryOffice(user);	//епеита о вягстгс епистяежеи стгм аявийг TOY.
							}
				
							
						}
						catch(NumberFormatException e){		//г PARSE INT AN EXEI KENO H KATI POY DEN EINAI ARITHMOS
							JOptionPane.showMessageDialog(null,	//жеямеи то пяоцяалла сто  CATCH поу емглеяымеи том вягстг.
								    "тО ПКАъСИО а/а йКИМИЙчР ПЯщПЕИ МА ПЕЯИщВЕИ АЯИХЛЭ", 
								    "кахос аяихлос",
								    JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception e){
											
						e.printStackTrace(); //се пеяиптысг поу г басг дем апойяиметаи емглеяыметаи о вягстгс.
						JOptionPane.showMessageDialog(null,
							    "аПОТУВъА СЩМДЕСГР СТГ БэСГ",
							    "Failed to connect",
							    JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, //ам дем евеи  сулпкгяыхеи омола тоте елжамифетаи 
							    "сУЛПКГЯЧСТЕ ТО ЭМОЛА ТГР ЙКИМИЙчР", //емглеяытийо лумгла
							    "No name",
							    JOptionPane.INFORMATION_MESSAGE);
					}
			
			}

			private boolean numberExists(int aa, Connection conn) throws Exception {
				/*
				 * ам упаявеи то ID ежосым апотекеи йкеиди ха упаявеи ломо лиа жояа.
				   аяа диатяевоуле тг басг, йаи ам бяехеи есты йаи ема ID
				 * KOINыс ам то RESULT дем еимаи йемо тоте сглаимеи оти йати бяехгйе стг басг аяа то
				 * ID KAI г йкимийг упаявоум.
				 * тоте епистяежоуле тRUE аккиыс
				 * FALSE
				 */
					
					String sql = "Select id from clinics where id = ?";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, aa);
					ResultSet result =statement.executeQuery();
					int i=0;
					while(result.next())
						i++;
					
					if (i>0){
						JOptionPane.showMessageDialog(null,
							    "о аЩНЫМ АЯИХЛЭР УПэЯВЕИ чДГ СТИР ЙКИМИЙщР",
							    " A/A already exists",
							    JOptionPane.WARNING_MESSAGE);
						return true;
					}
						else
						return false;
				
			}

			private boolean nameExists(String text, Connection conn) throws SQLException {
				/*
				 * г коцийг укопоигсгс еимаи айяибыс г идиа ле тгм паяапамы сумаятгсг
				 */
				
				
				String sql = "Select name from clinics where name = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1,text );
				ResultSet result =statement.executeQuery();
				int i=0;
				while(result.next())
					i++;
				
				if (i>0){
					JOptionPane.showMessageDialog(null,
						    "тО ЭМОЛА ЙКИМИЙчР УПэЯВЕИ чДГ",
						    "Invalid name",
						    JOptionPane.WARNING_MESSAGE);
					return true;
				}
					else
					return false;
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(389, 298, 121, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("╒ЙУЯО"); //ам патгхеи айуяо тоте йкеимеи то FRAME
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new SecretaryOffice(user);
			}
		});
		btnNewButton_1.setBounds(234, 298, 133, 31);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
