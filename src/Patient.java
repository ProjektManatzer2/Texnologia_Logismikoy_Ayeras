import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
				sql = "UPDATE Astheneis SET first=?,last=? where amka='"+this.amka+"'";
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
