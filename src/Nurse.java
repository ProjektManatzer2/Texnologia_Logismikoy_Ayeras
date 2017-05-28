import java.io.Serializable;
import java.util.ArrayList;

public class Nurse extends User implements Serializable{



	
	private static final long serialVersionUID = 1387698080150491069L;


		public Nurse(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		amka_bonusPatients= new ArrayList<String>();
		
		}

		public void newPatient(String amka) {
			amka_bonusPatients.add(amka);
			this.save_User_in_DB(true);
		}
		
		public void showBonusPatients(){
			
			
			
		}
	
	
	
}
