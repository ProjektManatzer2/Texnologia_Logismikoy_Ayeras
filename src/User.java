import java.io.*;
import java.sql.*;


public class User implements Serializable{

	protected String user_name;
	protected String password;
	protected String first;
	protected String last;
	
	
	
	public User(String user_name, String password, String first, String last,DataTransferObject dto) {
		this.user_name = user_name;
		this.password  = password;
		this.last = last;
		this.first = first;
		
		
	}
	public void save_User(){
		Connection conn = null ;
		try {
			
			conn = User.getConnection();
			
		}
		catch (Exception e) {
			
			System.out.println("Could not connect to database");
						
		}
		
		try{
			
			File file = new File("temp.bin");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.close();
			fout.close();
			
			InputStream inputStream = new FileInputStream(new File(file.getAbsolutePath()));
			 
			String sql = "UPDATE users set arxeiaki = ? where user_name=" + this.user_name;
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBlob(1, inputStream);
			statement.executeUpdate();
			inputStream.close();
		}catch (Exception e){
			
			System.out.println("Problem in file uploading");
		}
		
		
	}

	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			String url = "jdbc:mysql://snf-517490.vm.okeanos.grnet.gr/Ayeras";
									//(IP address)
			String username = "Ayeras";
			String password = "giwrgos";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e ){
			System.out.println(e);
			return null;	
		}
	}
	
	public boolean isGiatros() {
		
		return true;
	}
	

	
}