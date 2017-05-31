import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private static final long serialVersionUID = -8408069154688140529L;
	
	
	
	public Doctor(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		this.amka_bonusPatients= new ArrayList<String>();  	
	}
			
	//Πολύ χρήσιμη μέθοδος με αυτήν γίνεται ο έλεγχος επεξεργασίας στοιχείων.
	@Override	//Αν ο χρήστης ειναι γιατρός, επεξεργάζεται τα στοιχεία εξετάσεων του χρήστη σε αντίθεση με το νοσηλευτή.
	public boolean isGiatros() {
		return true;
	
	}

	//Προσθετει έναν νέο ασθενή εκτός κλινική για να μπορεί ο γιατρός να έχει πρόσβαση τα στοιχεία του.
	public void newPatient(String amka) {
		this.amka_bonusPatients.add(amka);
		this.save_User_in_DB(true);
	}

	
	
}
	
	
	
	
	

