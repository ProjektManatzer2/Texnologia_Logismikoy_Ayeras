import java.io.*;
import java.sql.*;


public class User implements Serializable{

	protected String user_name;
	protected String password;
	protected String first;
	protected String last;
	protected UserDataTransferObject dto;
	
	
	public User(String user_name, String password, String first, String last) {
		this.user_name = user_name;
		this.password  = password;
		this.last = last;
		this.first = first;
	}
	
	public void save_User_in_DB(boolean exists){
		Connection conn=null;
		
		if(!exists){
			
			try{
				conn=User.getConnection();
				String sql="INSERT INTO Users (username, password, onoma,eponymo) VALUES ("+user_name+","+password+","+first+" , "+last+");";
				
			
			
			}catch(Exception e){
				System.out.println("Problem in database connection");
			}
			
		}
		
		else{
			String sql = "UPDATE Users SET onoma=?,eponymo=? where username="+this.user_name;
			try {
			conn=User.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, first);
			statement.setString(2, last);
			statement.executeUpdate();
			} catch (Exception e) {
				System.out.println("Problem in databse connection");
			}
						
		}
		
		try{
			 this.dto.transferToDatabase(this.user_name,conn);
				
			File file = new File("temp.bin");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);

			oos.close();
			fout.close();
			InputStream inputStream = new FileInputStream(new File(file.getAbsolutePath()));
			String sql = "UPDATE Users set ARXEIO= ? where user_name=" + this.user_name;
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBlob(1, inputStream);
			statement.executeUpdate();
			inputStream.close();
			conn.close();
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
		
		return false;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public UserDataTransferObject getDto() {
		return dto;
	}
	


	
}