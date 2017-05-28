import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameDiagrafis {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField amkaField;
	private Secretary user;
	
	
	public FrameDiagrafis(Secretary user) {
		initialize(user);
	}

	
	private void initialize(Secretary user) {
		this.user=user;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 168);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Διαγραφή");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.diagrafiAitimatos(usernameField.getText(),amkaField.getText())){
					
					JOptionPane.showMessageDialog(null,"Το αίτημα διαγράφηκε(Ανανεώστε την αρχική σελίδα σας για να δείτε τον συνολικό αριθμό αιτημάτων)","ΔΙΑΓΡΑΦΗ ΕΠΙΤΥΧΗΣ",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Δεν βρέθηκε τέτοιο αίτημα","Not found",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(10, 97, 253, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Πίσω");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
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
