import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private HashSet<String> amka_bonusPatients;
	
	
	public Doctor(String user_name, String password,String AMKA,String first,String last) {
		
		super( user_name,  password,  first, last);
		
	}
			
	@Override
	public boolean isGiatros() {
		return true;
	
	}

	
	
	
	
	
	
	
}
