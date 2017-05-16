import java.io.Serializable;
import java.sql.Connection;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private HashSet<String> amka_bonusPatients;
	
	
	public Doctor(String user_name, String password,String AMKA,String first,String last) {
		
		super( user_name,  password,  first, last);
		try {
			Connection conn = User.getConnection();
			
			
			
		} catch (Exception e) {
			System.out.println("Failed to connect to database");
		}
		
	}
	
	
	@Override
	public boolean isGiatros() {
		return true;
	}

	
	
	
	
}
