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
	 * �� ���� �� frame ������������ �� �������� �������� ����� ��� �������� ��� ������� 
	 * ����� ������� ���� ��� �������� ��� �������� ����. �� frame ���� ������� �� ����
	 * ��������� amkaBonusPatients ��� �������/��������� ��� ��������� �� �������� �������
	 * �� �� ���������� ���� ���� ���� ���������. 
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
		
		 showButton = new JButton("�������� ���������");
		 showButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		try{
					int row = table.getSelectedRow();
					String amka =  table.getModel().getValueAt(row,2).toString();
					frame.dispose();
					Patient p = Patient.loadPatient(amka); //��� FRAME ����� ��� ���������� �� ��������. ������� �� �� ����� ���������� �������
					new PatientFrame(p,user);	//� �������� ��� ��������� ��� ��� �������� ��� PATIENTFRAME.
					}catch(ArrayIndexOutOfBoundsException ex){
						JOptionPane.showMessageDialog(null,"��� ���� �������� ������","No row selected",JOptionPane.WARNING_MESSAGE);
					}
		 	
		 	
		 	}
		 });
		showButton.setBounds(498, 364, 198, 32);
		frame.getContentPane().add(showButton);
		
		JButton backButton = new JButton("����");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new �������_����������(user);
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
			
			ArrayList<String> taAmka=user.getAmka_bonusPatients();//��������� �� ����� ��� ���� ��� ��� ������
			String query2 = "AMKA = ";	//������������ ���� �� STRING
			
			for(String s : taAmka){ //������ ����������� ��� �� ���� ��� �������� ��� ���� ����� SQL ENTO�� ������� "OR AMKA=s1 OR AMKA=s2 KLP..."
				query2+=s+" or AMKA = ";
				
			}
			String finalQuery="";	
			for(int i = 0 ; i < query2.length()-11; i++){ //��� ������ QUERY ���� ��������� �� ��������� "or amka = " ��� ��� �������� ��������� ��� ������.
				finalQuery+=query2.charAt(i);
			}
			
			String query = "select first as onoma, last as eponymo, AMKA, personal_tel from Astheneis where ";
			query+=finalQuery;

			System.out.println(query);
			
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			table.setModel(PatientSearch.resultSetToTableModel(res)); //������������ ��� TABLE �� �������� ��� ������� ��� ����� ���� ���� ��� ����� ��� ������.
			table.setSelectionBackground(Color.BLUE);
			table.setSelectionForeground(Color.CYAN);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
	
		
		
		
		
		
		frame.setVisible(true);
	
	
	
	}
}
