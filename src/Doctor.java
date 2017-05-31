import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Doctor extends User implements Serializable {



	private static final long serialVersionUID = -8408069154688140529L;
	
	
	
	public Doctor(String user_name, String password,String first,String last) {
		
		super( user_name,  password,  first, last);
		this.amka_bonusPatients= new ArrayList<String>();  	
	}
			
	//���� ������� ������� �� ����� ������� � ������� ������������ ���������.
	@Override	//�� � ������� ����� �������, ������������� �� �������� ��������� ��� ������ �� �������� �� �� ���������.
	public boolean isGiatros() {
		return true;
	
	}

	//��������� ���� ��� ������ ����� ������� ��� �� ������ � ������� �� ���� �������� �� �������� ���.
	public void newPatient(String amka) {
		this.amka_bonusPatients.add(amka);
		this.save_User_in_DB(true);
	}

	
	
}
	
	
	
	
	

