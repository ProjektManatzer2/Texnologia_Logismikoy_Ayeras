import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ΔημιουργίαΧρήστη extends JFrame implements ActionListener{

	 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField usernameField;
	private JTextField passwordField;
	JButton okButton;
	JButton cancelButton;
	public ΔημιουργίαΧρήστη() {

		this.setResizable(false);
		this.setTitle("Δημιουργία χρήστη");
		this.setBounds(100, 100, 600, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(74, 37, 456, 23);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Γιατρός");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(6, 0, 130, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Υπάλληλος Γραμματείας");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(285, 0, 171, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Νοσηλευτής");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(174, 0, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 95, 116, 23);
		this.getContentPane().add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(186, 96, 257, 20);
		this.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(74, 153, 93, 23);
		this.getContentPane().add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(186, 154, 252, 20);
		this.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(483, 274, 101, 37);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		okButton = new JButton("OK");
		okButton.setBounds(367, 274, 101, 37);
		okButton.addActionListener(this);
		getContentPane().add(okButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		  if(event.getSource() == okButton){
			  
		  
    
			if(elegxos()){
				
			}else{
				JOptionPane.showMessageDialog(null,
					    "Συμπληρώστε όλα τα στοιχεία",
					    "Ελλιπείς στοιχεία",
					    JOptionPane.ERROR_MESSAGE);
				
			}
			
			}
		  if(event.getSource() == cancelButton){
			  this.dispose();
			  new SecretaryOffice();
		  }
				
	}
	

	private boolean elegxos() {
		
		return false;
	}
}
