import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private JButton okButton;
	private JButton cancelButton;
	private JRadioButton doctorButton;
	private JRadioButton secretaryButton;
	private JRadioButton nurseButton;
	
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
		
		doctorButton = new JRadioButton("Γιατρός");
		doctorButton.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(doctorButton);
		doctorButton.setBounds(6, 0, 130, 23);
		panel.add(doctorButton);
		
		secretaryButton = new JRadioButton("Υπάλληλος Γραμματείας");
		secretaryButton.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(secretaryButton);
		secretaryButton.setBounds(285, 0, 171, 23);
		panel.add(secretaryButton);
		
		nurseButton = new JRadioButton("Νοσηλευτής");
		buttonGroup.add(nurseButton);
		nurseButton.setBounds(174, 0, 109, 23);
		panel.add(nurseButton);
		
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
		
		 secretaryButton.addActionListener(this);
		 doctorButton.addActionListener(this);
		 nurseButton.addActionListener(this);
		
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
      //EPILOGH TOY OK
	  if(event.getSource() == okButton){
			  
			  		 
			if(elegxos()){
				if(doctorButton.isSelected()){ //New frame proorismeno gia dhmiourgia giatroy.
					this.dispose();
					 new ΔημιουργείαΧρήστη(usernameField.getText().trim(),passwordField.getText().trim(),1);
				}
				else if(nurseButton.isSelected()){ //New frame proorismeno gia dhmiourgia Noshleuti.
					this.dispose();
					 new ΔημιουργείαΧρήστη(usernameField.getText().trim(),passwordField.getText().trim(),2);
					 
				}
				else{  //New frame proorismeno gia dhmiourgia ypallilou grammateias.
					this.dispose(); 
					new ΔημιουργείαΧρήστη(usernameField.getText().trim(),passwordField.getText().trim(),3);
				
				}
			}
			
				
			
	 }
	//EPILOGH TOY CANCEL		
	 if(event.getSource() == cancelButton){
			  this.dispose();
			  new SecretaryOffice();
		  }
				
	}
	
	
	private boolean elegxos() {
		if(usernameField.getText().trim().equals("") || passwordField.getText().trim().equals(""))
			{JOptionPane.showMessageDialog(null,
			    "Συμπληρώστε όλα τα στοιχεία",
			    "Ελλιπείς στοιχεία",
			    JOptionPane.ERROR_MESSAGE);
			return false;
			}
		
		if(usernameExists(usernameField.getText().trim())){
			JOptionPane.showMessageDialog(null,
				    "Username Exists",
				    "Invalid Username",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (doctorButton.isSelected() || nurseButton.isSelected() || secretaryButton.isSelected())
		return true;
		
		else
			{		JOptionPane.showMessageDialog(null,
				    "Συμπληρώστε όλα τα στοιχεία",
				    "Ελλιπείς στοιχεία",
				    JOptionPane.ERROR_MESSAGE);
			return false;
			}
	}

	private boolean usernameExists(String trim) {

		try {
			Connection conn = User.getConnection();
		
			String sql = "Select username from Users where username = '"+trim+"'";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result =statement.executeQuery();
			int i=0;
			while(result.next())
				i++;
			if (i>0)
				return true;
			
			
			
			return false;
		} catch (Exception e) {
			System.out.println("Failed to connect");
			e.printStackTrace();
			return true;
		}
		
	}
}
