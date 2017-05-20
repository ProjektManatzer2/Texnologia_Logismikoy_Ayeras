import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDataTransferObject implements Serializable {

	String f_name;
	String ama;
	String date_of_birth;
	char gender;
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
	
	
	
	public PatientDataTransferObject()
	{
		f_name="";
		date_of_birth="";
		gender='M';
		weight="";
		height="";
		address="";
		region="";
		city="";
		post_code="";
		insurance_institution="";
		status="";
		taytotita="";
		personal_tel="";
		home_tel="";
		job_tel="";
		fax="";
		email="";
		comments="";
		put_date="";
		ama="";
	}
	
	public void transferToDatabase(String username,Connection conn)
	{
		try 
			{
			
			
			
			String sql = "UPDATE Users SET f_name = ?, date_of_birth=?,"
					+ "weight=?,height=?,address=?,region=?,city=?,post_code=?,"
					+ "insurance_institution=?,status=?,"
					+ "taytotita=?,"
					+ " personal_tel=?,home_tel=?,job_tel=?,"
					+ "fax=?,email=?,put_date=?,comments=?, WHERE username=" + username;
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
		
			statement.executeUpdate();
			
			

			
			} 
		catch (Exception e)
		{

			System.out.println("UNABLE TO CONNECT TO DATABASE");
			
		}
		
	}
	
}
