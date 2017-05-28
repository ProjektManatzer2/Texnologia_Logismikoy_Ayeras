import java.io.Serializable;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private static final long serialVersionUID = -8408069154688140529L;
	private HashSet<String> amka_bonusPatients;
	
	
	public Doctor(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		amka_bonusPatients= new HashSet<String>();	
	}
			
	@Override
	public boolean isGiatros() {
		return true;
	
	}

	public void newPatient(String amka) {
		amka_bonusPatients.add(amka);
		this.save_User_in_DB(true);
	}

	
	
}
	
	
	
	
	

