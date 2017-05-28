import java.io.Serializable;

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
		return "Ο Γιατρός/Νοσηλευτής με username = "+giatros.getUser_name()+"\nXρειάζεται τα στοιχεία του ασθενή με ΑΜΚΑ = "+this.amka;
	}
 
}
