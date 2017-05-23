import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Patient implements Serializable {
	
	
	/**
	 * 
	 */
	protected static final long serialVersionUID = 737501913632927252L;
	protected String first;
	protected String last;
	protected String amka;
	private PatientDataTransferObject pdto;
	
	public PatientDataTransferObject getPdto() {
		return pdto;
	}
	
	public Patient(String first,String last,String amka){
		this.first=first;
		this.last=last;
		this.amka=amka;
		this.pdto=new PatientDataTransferObject(amka);
	}
	
	
	
	
	public void save_Patient_in_DB(boolean exists){
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
			File file = new File("temp.bin");
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

	public String getFirst() {

		return first;
	}

	public String getLast() {

		return last;
	}

	public String getAMKA() {

		return amka;
	}

}
