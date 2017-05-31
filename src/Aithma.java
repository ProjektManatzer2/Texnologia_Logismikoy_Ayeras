import java.io.Serializable;


//��������� �����������, ��� ��� ���������� ���������� ��� ��������� ��� ��������
//���� ��������� ����������� ���� ��� ���� ��������� ��� Aithma ��� �������� ��� showAitima ������������ ��
//����������� ��� �� ���� ���� ��������.

public class Aithma implements Serializable {

	private static final long serialVersionUID = 7105237476130660880L;
	private User giatros;
	private String amka;
	
	public Aithma(User user,String amka){
		this.giatros=user; this.amka=amka;
	}

	public User getGiatros() {
		return giatros;
	}
 

	public String getAmka() {
		return amka;
	}
	
	public String showAitima(){
		return "� �������/���������� �� username = "+giatros.getUser_name()+"\nX��������� �� �������� ��� ������ �� ���� = "+this.amka;
	}
 
}
