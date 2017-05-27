import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			this.astheneis= new ArrayList<Patient>();
			this.giatroi=new ArrayList<Doctor>();
			this.nosokomoi=new ArrayList<Nurse>();;
			
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
			System.out.println("Clinic was successfully written");
			inputStream.close();
			
			}	
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Problem in file uploading");
		}
			
	}

	public static Clinic loadClinic(int ide) {

		
		Connection conn=null;
		Clinic kiliniki=null;
		try{
			conn=User.getConnection();
		}catch(Exception e){
			System.out.println("Couldnt connect to database");
			return null;
		}
		
		try{
		PreparedStatement statement = conn.prepareStatement("SELECT clinic_file FROM clinics where id='"+ide+"';");
		ResultSet result = statement.executeQuery();
		File file = new File("loaderClinic.bin");
		FileOutputStream os = new FileOutputStream(file);
		if(result.next()){

		InputStream inputStream = result.getBinaryStream("clinic_file");
		byte[] buffer = new byte[1024];
		while(inputStream.read(buffer)>0){
			os.write(buffer);
		}
		inputStream.close();
		FileInputStream fis=new FileInputStream(file.getAbsolutePath());
		ObjectInputStream oss =new ObjectInputStream(fis);
		kiliniki = (Clinic)oss.readObject();
		System.out.println("Ola kala");
		oss.close();
		}
		os.close();
		
		return kiliniki;
		
		} catch (Exception e ){
			e.printStackTrace();
				 System.out.println("Arxeio Exception");
				 	return null;
		}

	}

	public void addNurseToClinic(Nurse aNurse) {
		nosokomoi.add(aNurse);
		this.saveClinic();
	}
	
	public void addDoctorToClinic(Doctor aDoctor) {
		giatroi.add(aDoctor);
		this.saveClinic();
	}
	
	public void addPatientToClinic(Patient aPatient) {	
		astheneis.add(aPatient);
		this.saveClinic();
	}


	public ArrayList<Patient> getAstheneis() {
		return astheneis;
	}

	public ArrayList<Doctor> getGiatroi() {
		return giatroi;
	}

	public ArrayList<Nurse> getNosokomoi() {
		return nosokomoi;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	
	
}
