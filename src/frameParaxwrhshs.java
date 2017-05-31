import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frameParaxwrhshs {

	private JTextField amkaField;
	private JTextField usernameField;
	private JFrame frame;
	private Secretary xrhsths;

	/*
	 * се ауто то FRAME о упаккгкос цяаллатеиас димеи стоивеиа емос асхемг се ема циатяо/мосгкеутг.
	 */
	
	
	public frameParaxwrhshs(Secretary user) {
		initialize(user);
	}

		
	private void initialize(Secretary user) { 
		xrhsths=user;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 168);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("пАЯэДОСГ СТОИВЕъЫМ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.paraxwrhsh(usernameField.getText(),amkaField.getText()); //о вягстгс димеи ле дийиа тоу леходо стом циатяо/мосгкеутг та стоивеиа
				user.diagrafiAitimatos(usernameField.getText(),amkaField.getText()); //епеита диацяажеи то аитгла апо том еауто тоу
				try{
					Connection conn=User.getConnection();
					
					String query = "select username from Users where type = 3";		//йаи стг сумевеиа апо окоус тоус упокоипоус вягстес тгс цяаллатеиас стоус опоиоус
					PreparedStatement statement = conn.prepareStatement(query);		//паяадохгйе.
					ResultSet res = statement.executeQuery();
					while(res.next()){
						Secretary S = (Secretary)User.loadUser(res.getString("username"));
						if(S.diagrafiAitimatos(usernameField.getText(),amkaField.getText()))
						S.save_User_in_DB(true);					
					}
					JOptionPane.showMessageDialog(null,"тА СТОИВЕъА щВОУМ АПОСТАКХЕъ (аМАМЕЧСТЕ ТГМ АЯВИЙч СЕКъДА САР ЦИА МА ДЕъТЕ ТОМ ЙАИМОЩЯЦИО СУМОКИЙЭ АЯИХЛЭ АИТГЛэТЫМ )","апостокг епитувгс",JOptionPane.INFORMATION_MESSAGE);
					
			
				}catch(Exception exception){
					System.out.println("Couldnt connect to database");
					exception.printStackTrace();
				}

				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(10, 97, 253, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new SecretaryOffice(xrhsths);
			
			}
		});
		btnNewButton_1.setBounds(307, 103, 117, 19);
		frame.getContentPane().add(btnNewButton_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(10, 33, 181, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 8, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAmka = new JLabel("amka");
		lblAmka.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmka.setBounds(275, 8, 125, 14);
		frame.getContentPane().add(lblAmka);
		
		amkaField = new JTextField();
		amkaField.setColumns(10);
		amkaField.setBounds(243, 33, 181, 19);
		frame.getContentPane().add(amkaField);
		frame.setVisible(true);
	}

}
