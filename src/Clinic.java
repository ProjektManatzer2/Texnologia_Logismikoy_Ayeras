import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Clinic implements Serializable{


	private static final long serialVersionUID = 4411944799402341685L;
	private ArrayList<Patient> astheneis;
	private ArrayList<Doctor> giatroi;
	private ArrayList<Nurse> nosokomoi;
	private int id;
	private String name;
	
	public Clinic(int id, String name,Connection conn){
		
		
		try{
			this.id=id;
			this.name=name;
			String statement = "INSERT INTO clinics ( id , name ) VALUES (?,?)";
			PreparedStatement posted = conn.prepareStatement(statement);
			
			posted.setInt(1,id);
			posted.setString(2,name);
			posted.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public void saveClinic(){
		try{
			Connection conn = User.getConnection();
			File file = new File("temp.bin");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);

			oos.close();
			fout.close();
			InputStream inputStream = new FileInputStream(new File(file.getAbsolutePath()));
			String sql = "UPDATE clinics set clinic_file = ? where id=?";
			 
			PreparedStatement sQLstatement = conn.prepareStatement(sql);
			sQLstatement.setBlob(1, inputStream);
			sQLstatement.setInt(2, id);
			sQLstatement.executeUpdate();
			System.out.println("User was successfully written");
			inputStream.close();
			
			}	
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Problem in file uploading");
		}
			
	}
}
