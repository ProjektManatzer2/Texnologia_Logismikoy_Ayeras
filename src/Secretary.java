import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Secretary extends User implements Serializable{
	
	
	private ArrayList<Aithma> aitimata;
	
	public Secretary(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		aitimata = new ArrayList<Aithma>();
		
		}
	
	private void aitima(ArrayList<Aithma> astheneis){
	//	new AitimaDikaiwmatwn(astheneis);
	
	}
	
	
	@Override
	public boolean hasClinic(){
		return false;
	}

	public void addAithma(Aithma aithma) {
		 aitimata.add(aithma);
		
	}
	
	public int plithosAitimatwn(){
		return aitimata.size();
	}

}