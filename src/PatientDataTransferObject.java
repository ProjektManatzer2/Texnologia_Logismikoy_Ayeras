import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDataTransferObject implements Serializable {

	 
	private static final long serialVersionUID = -8472687185815951244L;
	String f_name;
	String ama;
	String date_of_birth;
	String gender;
	String weight;
	String height;
	String address;
	String region;
	String city;
	String post_code;
	String job;
	String insurance_institution;
	String status;
	String taytotita;
	String personal_tel;
	String home_tel;
	String job_tel;
	String fax;
	String email;
	String put_date;
	String comments;
	String amka; //PRIMARY KEY
	
	
	public PatientDataTransferObject(String amka)
	{
		this.amka=amka;
		f_name="NULL";
		date_of_birth="NULL";
		gender="NULL";
		weight="NULL";
		height="NULL";
		address="NULL";
		region="NULL";
		city="NULL";
		post_code="NULL";
		insurance_institution="NULL";
		status="NULL";
		taytotita="NULL";
		personal_tel="NULL";
		home_tel="NULL";
		job_tel="NULL";
		fax="NULL";
		email="NULL";
		comments="NULL";
		put_date="NULL";
		ama="NULL";
	}
	
	public void transferToDatabase(Connection conn)
	{
		try 
			{
			
			
						///APO EDW KATW "META TO UPDATE" PREPEI NA MPEI TO ONOMA TOY PINAKA ASTHENWN!!!!
			String sql = "UPDATE ONOMAPINAKAASTHENWN SET f_name = ?, date_of_birth=?,"
					+ "weight=?,height=?,address=?,region=?,city=?,post_code=?,"
					+ "insurance_institution=?,status=?,"
					+ "taytotita=?,"
					+ " personal_tel=?,home_tel=?,job_tel=?,"
					+ "fax=?,email=?,put_date=?,comments=?,gender=? WHERE amka='" + amka+"'";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, f_name);
			statement.setString(2, date_of_birth);
			statement.setString(3, weight);
			statement.setString(4, height);
			statement.setString(5, address);
			statement.setString(6, region);
			statement.setString(7, city);
			statement.setString(8, post_code);
			statement.setString(9, insurance_institution);
			statement.setString(10, status);
			statement.setString(11, taytotita);
			statement.setString(12, personal_tel);
			statement.setString(13, home_tel);
			statement.setString(14, job_tel);
			statement.setString(15, fax);
			statement.setString(16, email);
			statement.setString(17, put_date);
			statement.setString(18, comments);
			statement.setString(19, gender);
		
			statement.executeUpdate();
			
			

			
			} 
		catch (Exception e)
		{

			System.out.println("UNABLE TO CONNECT TO DATABASE");
			
		}
		
	}
	
	
	
		
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
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
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	
	public String getInsurance_institution() {
		return insurance_institution;
	}
	public void setInsurance_institution(String insurance_institution) {
		this.insurance_institution = insurance_institution;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getPersonal_tel() {
		return personal_tel;
	}
	public void setPersonal_tel(String personal_tel) {
		this.personal_tel = personal_tel;
	}
	public String getHome_tel() {
		return home_tel;
	}
	public void setHome_tel(String home_tel) {
		this.home_tel = home_tel;
	}
	public String getJob_tel() {
		return job_tel;
	}
	public void setJob_tel(String job_tel) {
		this.job_tel = job_tel;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setPutDate(String putDate) {
		this.put_date= putDate;
	}
	
}
