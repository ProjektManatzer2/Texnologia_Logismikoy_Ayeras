import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDataTransferObject implements Serializable{

	private static final long serialVersionUID = -8433207208407555152L;
	private String username;
	private String patronymo;
	private String birth_date;
	private String gender;
	private String address;
	private String region;
	private String city;
	private String tk;
	private String eidikothta;
	private String tameio;
	private String family_statement;
	private String amka;
	private String taytotita;
	private String kinito;
	private String house_phone;
	private String job_phone;
	private String fax;
	private String email;
	private String kliniki;
	private String put_date;
	private String paratiriseis;
	private int type;
		
	public UserDataTransferObject(String username){
		this.username=username;
		patronymo="";
		birth_date="";
		gender="";
		address="";
		region="";
		city="";
		tk="";
		eidikothta="";
		tameio="";
		family_statement="";
		amka="";
		taytotita="";
		kinito="";
		house_phone="";
		job_phone="";
		fax="";
		email="";
		paratiriseis="";
		kliniki="";
		put_date="";
		type=0;
	}
	
	public void transferToDatabase(Connection conn){
		try {
			
			
			
			String sql = "UPDATE Users SET partonymo = ?, date_birth=?,"
					+ "address=?,region=?,city=?,tk=?,"
					+ "eidikotita=?,tameio=?,family_statement=?,"
					+ "kliniki=?,amka=?,arithmos_taytotitas=?,"
					+ " kinito=?,thlefwno_spitiou=?,thlefwno_ergasias=?,"
					+ "fax=?,email=?,hmeromhnia_eisagwghs=?,paratiriseis=?,type=?,gender=? WHERE username='" + username+"'";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, patronymo);
			statement.setString(2, birth_date);
			statement.setString(3, address);
			statement.setString(4, region);
			statement.setString(5, city);
			statement.setString(6, tk);
			statement.setString(7, eidikothta);
			statement.setString(8, tameio);
			statement.setString(9, family_statement);
			statement.setString(10, kliniki);
			statement.setString(11, amka);
			statement.setString(12, taytotita);
			statement.setString(13, kinito);
			statement.setString(14, house_phone);
			statement.setString(15, job_phone);
			statement.setString(16, fax);
			statement.setString(17, email);
			statement.setString(18, put_date);
			statement.setString(19, paratiriseis);
			statement.setInt(20, type);
			statement.setString(21, gender);
			statement.executeUpdate();
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("UNABLE TO CONNECT TO DATABASE");
			
			
		}
		
		
		
		
	}
	
	

	
	public int getType() {
		return type;
	}
	public void setType(int f) {
		this.type=f;
	}
		
	public String getPatronymo() {
		return patronymo;
	}
	public void setPatronymo(String patronymo) {
		this.patronymo = patronymo;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getEidikothta() {
		return eidikothta;
	}
	public void setEidikothta(String eidikothta) {
		this.eidikothta = eidikothta;
	}
	public String getTameio() {
		return tameio;
	}
	public void setTameio(String tameio) {
		this.tameio = tameio;
	}
	public String getFamily_statement() {
		return family_statement;
	}
	public void setFamily_statement(String family_statement) {
		this.family_statement = family_statement;
	}
	public String getAmka() {
		return amka;
	}
	public void setAmka(String amka) {
		this.amka = amka;
	}
	public String getTaytotita() {
		return taytotita;
	}
	public void setTaytotita(String taytotita) {
		this.taytotita = taytotita;
	}
	public String getKinito() {
		return kinito;
	}
	public void setKinito(String kinito) {
		this.kinito = kinito;
	}
	public String getHouse_phone() {
		return house_phone;
	}
	public void setHouse_phone(String house_phone) {
		this.house_phone = house_phone;
	}
	public String getJob_phone() {
		return job_phone;
	}
	public void setJob_phone(String job_phone) {
		this.job_phone = job_phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParatiriseis() {
		return paratiriseis;
	}
	public void setParatiriseis(String paratiriseis) {
		this.paratiriseis = paratiriseis;
	}
	public void setPutDate(String putDate) {
		this.put_date= putDate;
	}
	

}