import java.io.*;
import java.sql.*;


public class User implements Serializable{


	private static final long serialVersionUID = -8889739166956625464L;
	protected String user_name;
	protected String password;
	protected String first;
	protected String last;
	private UserDataTransferObject dto;
	
	
	public UserDataTransferObject getDto() {
		return dto;
	}
	
	public boolean hasClinic() {
		return true;
	}
	
	public boolean equals(User another){
		if(this.user_name.equals(another.getUser_name()))
				return true;
		return false;
		
	}

	public User(String user_name, String password, String first, String last) {
		this.user_name = user_name;
		this.password  = password;
		this.last = last;
		this.first = first;
		this.dto=new UserDataTransferObject(user_name);
	}
	
	public void save_User_in_DB(boolean exists){
		Connection conn=null;
		String sql="";
		PreparedStatement sQLstatement=null;
		if(!exists){
			
			try{
				conn=User.getConnection();
				sql="INSERT INTO Users (username, password, first_name,last_name) VALUES ('"+user_name+"','"+password+"','"+first+"' , '"+last+"');";
				sQLstatement = conn.prepareStatement(sql);
				sQLstatement.executeUpdate();
				
			
			
			}catch(Exception e){
				System.out.println("Problem in database connection");
				e.printStackTrace();
			}
			
		}
		
		else{
				sql = "UPDATE Users SET password=?,first_name=?,last_name=? where username='"+this.user_name+"'";
				try {
				conn=User.getConnection();
				sQLstatement = conn.prepareStatement(sql);
				sQLstatement.setString(1, password);
				sQLstatement.setString(2, first);
				sQLstatement.setString(3, last);
				sQLstatement.executeUpdate();
				
				}catch(Exception e){
				e.printStackTrace();
				System.out.println("FUUUCK");
				}
			}
			try{
			File file = new File("temporaryUser.bin");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);

			oos.close();
			fout.close();
			InputStream inputStream = new FileInputStream(new File(file.getAbsolutePath()));
			sql = "UPDATE Users set arxeio= ? where username='" + this.user_name+"'";
			 
			sQLstatement = conn.prepareStatement(sql);
			sQLstatement.setBlob(1, inputStream);
			sQLstatement.executeUpdate();
			System.out.println("User was successfully written");
			inputStream.close();
			this.dto.transferToDatabase(conn);
			}	
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Problem in file uploading");
		}
			
	}
		

	public static User loadUser(String username){
		Connection conn=null;
		User john=null;
		try{
			conn=getConnection();
		}catch(Exception e){
			System.out.println("Couldnt connect to database");
			return null;
		}
		
		try{
		PreparedStatement statement = conn.prepareStatement("SELECT arxeio FROM Users where username='"+username+"';");
		ResultSet result = statement.executeQuery();
		File file = new File("loaderUser.bin");
		FileOutputStream os = new FileOutputStream(file);
		if(result.next()){

		InputStream inputStream = result.getBinaryStream("arxeio");
		byte[] buffer = new byte[1024];
		while(inputStream.read(buffer)>0){
			os.write(buffer);
		}
		inputStream.close();
		FileInputStream fis=new FileInputStream(file.getAbsolutePath());
		ObjectInputStream oss =new ObjectInputStream(fis);
		john = (User)oss.readObject();
		System.out.println("Ola kala");
		}
		return john;
		
		} catch (Exception e ){
			e.printStackTrace();
				 System.out.println("Arxeio Exception");
				 	return null;
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
	


	
}