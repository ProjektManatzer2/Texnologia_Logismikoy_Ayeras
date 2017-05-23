import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private HashSet<String> amka_bonusPatients;
	
	
	public Doctor(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		amka_bonusPatients= new HashSet<String>();	
	}
			
	@Override
	public boolean isGiatros() {
		return true;
	
	}

	
	public void aitimaStoixeiwn(Patient pat){
		try{
			Connection conn = User.getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT arxeio FROM users where type=3");
			ResultSet result = statement.executeQuery();
			ArrayList<String> krepa = new ArrayList<String>();
	
		
		}catch(Exception e){
			
			System.out.println("Failed to connect to database!");	
		}
	}
	
	
	
	
	
}
