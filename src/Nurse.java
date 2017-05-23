import java.io.Serializable;
import java.util.HashSet;

public class Nurse extends User implements Serializable{



	private HashSet<String> amka_bonusPatients;

		public Nurse(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		amka_bonusPatients= new HashSet<String>();
		
		}
	
	
	
}
