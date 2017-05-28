import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Secretary extends User implements Serializable{
	
	private JFrame frameAithmatwn;
	private ArrayList<Aithma> aitimata;
	private boolean newAithma;
	private JTextPane textField;

	
	public Secretary(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		aitimata = new ArrayList<Aithma>();
		this.newAithma = false;
		
	}
	
	public void showFrameAithmatwn(){
		frameAithmatwn = new JFrame();
		frameAithmatwn.setBounds(100, 100, 450, 300); 
		frameAithmatwn.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 11, 346, 168);
		frameAithmatwn.getContentPane().add(scrollPane);
		
		textField = new JTextPane();
		textField.setEditable(false);
		scrollPane.setViewportView(textField);
		
		String olaTaAitimata = "";

		for(Aithma aitima:aitimata)
				olaTaAitimata+=aitima.showAitima()+"\n";
		
		
		textField.setText(olaTaAitimata);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(118, 228, 217, 23);
		frameAithmatwn.getContentPane().add(btnNewButton);
		
		frameAithmatwn.setVisible(true);
		
		
	}
	


	public void paraxwrhsh(String username, String amka) {
		Patient pat = Patient.loadPatient(amka);
		User user = User.loadUser(username);
		
		if(user.isGiatros()){
			Doctor doc = (Doctor)user;
			doc.newPatient(amka);
			
		}else{
			Nurse doc = (Nurse)user;
			doc.newPatient(amka);
		}
				
		
		
		
	}

	
	public boolean diagrafiAitimatos(String username, String amka) {
		Iterator<Aithma> iter = aitimata.iterator();
		boolean flag=false;
		while (iter.hasNext()) {
		    Aithma ait = iter.next();
		   
		    	if (ait.getGiatros().getUser_name().equals(username) && ait.getAmka().equals(amka)){
		    		iter.remove();
		    		this.save_User_in_DB(true);
		    		flag = true;
		    	}
		    
		}
		this.newAithma=false;
		return flag;
		
		
		
	}

	@Override
	public boolean hasClinic(){
		return false;
	}

	public void addAithma(Aithma aithma) {
		 aitimata.add(aithma);
		this.newAithma=true;
	}
	
	
	
	
	
	public boolean newAithma(){
		return newAithma;
	}
	
	public void setNewAithma(boolean f){
		this.newAithma=f;
	}
	
	public int plithosAitimatwn(){
		return aitimata.size();
	}


	

}