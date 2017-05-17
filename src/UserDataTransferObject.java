import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDataTransferObject implements Serializable{

	String patronymo;
	String birth_date;
	char gender;
	String varos;
	String upsos;
	String address;
	String region;
	String city;
	String tk;
	String eidikothta;
	String tameio;
	String family_statement;
	String amka;
	String taytotita;
	String kinito;
	String house_phone;
	String job_phone;
	String fax;
	String email;
	String kliniki;
	String put_date;
	String paratiriseis;
	
	public UserDataTransferObject(){
		patronymo="";
		birth_date="";
		gender='M';
		varos="";
		upsos="";
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
	}
	
	public void transferToDatabase(String username,Connection conn,boolean exists){
		try {
			
			
			if(exists){
			String sql = "UPDATE Users SET patronymo = ?, date_birth=?,"
					+ "varos=?,upsos=?,address=?,region=?,city=?,tk=?,"
					+ "eidikotita=?,tameio=?,family_statement=?,"
					+ "kliniki=?,amka=?,arithmos_taytotitas=?,"
					+ " kinito=?,thlefwno_spitiou=?,thlefwno_ergasias=?,"
					+ "fax=?,email=?,hmeromhnia_eisagwghws=?,paratiriseis=? WHERE username=" + username;
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, patronymo);
			statement.setString(2,birth_date);
			statement.setString(3, varos);
			statement.setString(4, upsos);
			statement.setString(5, address);
			statement.setString(6, region);
			statement.setString(7, city);
			statement.setString(8, tk);
			statement.setString(9, eidikothta);
			statement.setString(10, tameio);
			statement.setString(11, family_statement);
			statement.setString(12, kliniki);
			statement.setString(13, amka);
			statement.setString(14, taytotita);
			statement.setString(15, kinito);
			statement.setString(16, house_phone);
			statement.setString(17, job_phone);
			statement.setString(18, fax);
			statement.setString(19, email);
			statement.setString(20, put_date);
			statement.setString(21, paratiriseis);
			statement.executeUpdate();
			}
			
			else{

				String sql = "UPDATE Users SET patronymo = ?, date_birth=?,"
						+ "varos=?,upsos=?,address=?,region=?,city=?,tk=?,"
						+ "eidikotita=?,tameio=?,family_statement=?,"
						+ "kliniki=?,amka=?,arithmos_taytotitas=?,"
						+ " kinito=?,thlefwno_spitiou=?,thlefwno_ergasias=?,"
						+ "fax=?,email=?,hmeromhnia_eisagwghws=?,paratiriseis=? WHERE username=" + username;
				PreparedStatement statement=conn.prepareStatement(sql);
				statement.setString(1, patronymo);
				statement.setString(2,birth_date);
				statement.setString(3, varos);
				statement.setString(4, upsos);
				statement.setString(5, address);
				statement.setString(6, region);
				statement.setString(7, city);
				statement.setString(8, tk);
				statement.setString(9, eidikothta);
				statement.setString(10, tameio);
				statement.setString(11, family_statement);
				statement.setString(12, kliniki);
				statement.setString(13, amka);
				statement.setString(14, taytotita);
				statement.setString(15, kinito);
				statement.setString(16, house_phone);
				statement.setString(17, job_phone);
				statement.setString(18, fax);
				statement.setString(19, email);
				statement.setString(20, put_date);
				statement.setString(21, paratiriseis);
				statement.executeUpdate();
				
				
				
			}
			
		} catch (Exception e) {

			System.out.println("UNABLE TO CONNECT TO DATABASE");
			
			
		}
		
		
		
		
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getVaros() {
		return varos;
	}
	public void setVaros(String varos) {
		this.varos = varos;
	}
	public String getUpsos() {
		return upsos;
	}
	public void setUpsos(String upsos) {
		this.upsos = upsos;
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
	

}