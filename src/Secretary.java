import java.sql.Connection;
import java.sql.PreparedStatement;

public class Secretary extends User {
	
	
	
	public Secretary(String user_name, String password,String AMKA,String first,String last) {
		
		super( user_name,  password,  first, last);
		try {
			
			Connection conn = User.getConnection();
			String sql = "UPDATE Users SET type=3 where username="+this.user_name;
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.executeUpdate();
						
		} catch (Exception e) {
			System.out.println("Failed to connect to database");
		}
			
	}

}