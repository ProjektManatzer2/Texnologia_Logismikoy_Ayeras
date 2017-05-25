import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patient implements Serializable {
	
	
	 
	private static final long serialVersionUID = 737501913632927252L;
	private String first;
	private String last;
	private String amka;
	private PatientDataTransferObject pdto;
	
	public PatientDataTransferObject getPdto() {
		return pdto;
	}
	
	public Patient(String amka, String first,String last){
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
				sql="INSERT INTO Astheneis (AMKA, first, last) VALUES ('" +amka+ "','" +first+ "','" +last+ "');";
				sQLstatement = conn.prepareStatement(sql);
				sQLstatement.executeUpdate();
				
			
			
			}catch(Exception e){
				System.out.println("Problem in database connection");
				e.printStackTrace();
			}
			
		}
		
		else{
				sql = "UPDATE Astheneis SET first=?,last=? where AMKA='"+this.amka+"'";
				try {
				conn=User.getConnection();
				sQLstatement = conn.prepareStatement(sql);
				
				sQLstatement.setString(1, first);
				sQLstatement.setString(2, last);
				sQLstatement.executeUpdate();
				
				}catch(Exception e){
				e.printStackTrace();
				System.out.println("FUUUCK");
				}
			}
			try{
			File file = new File("temporaryPatient.bin");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);

			oos.close();
			fout.close();
			InputStream inputStream = new FileInputStream(new File(file.getAbsolutePath()));
			sql = "UPDATE Astheneis set patientFile= ? where amka='" + this.amka +"'";
			 
			sQLstatement = conn.prepareStatement(sql);
			sQLstatement.setBlob(1, inputStream);
			sQLstatement.executeUpdate();
			System.out.println("Patient was successfully written");
			inputStream.close();
			this.pdto.transferToDatabase(conn);
			}	
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Problem in file uploading");
		}
			
	}
	
	public static Patient loadPatient(String amka){ 
		Connection conn=null;
		Patient mary=null;
		try{
			conn=User.getConnection();
		}catch(Exception e){
			System.out.println("Couldnt connect to database");
			return null;
		}
		
		try{
		PreparedStatement statement = conn.prepareStatement("SELECT patientFile FROM Astheneis where AMKA='"+amka+"';");
		ResultSet result = statement.executeQuery();
		File file = new File("loaderPatient.bin");
		FileOutputStream os = new FileOutputStream(file);
		if(result.next()){

		InputStream inputStream = result.getBinaryStream("patientFile");
		byte[] buffer = new byte[1024];
		while(inputStream.read(buffer)>0){
			os.write(buffer);
		}
		inputStream.close();
		FileInputStream fis=new FileInputStream(file.getAbsolutePath());
		ObjectInputStream oss =new ObjectInputStream(fis);
		mary = (Patient)oss.readObject();
		System.out.println("Ola kala");
		}
		return mary;
		
		} catch (Exception e ){
			e.printStackTrace();
				 System.out.println("Arxeio Exception");
				 	return null;
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
