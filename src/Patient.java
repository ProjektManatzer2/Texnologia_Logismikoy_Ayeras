import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;

public class Patient implements Serializable {
	
	
	 
	private static final long serialVersionUID = 737501913632927252L;
	private String first;		//ои пяытес тяеис апотекоу та йуяиотеяа стоивеиа тоу асхемг сто сустгла, дем лпояеи ма упаянеи асхемгс выяис аута.
	private String last;
	private String amka;//йкеиди стг басг.
	private String astheneies;		
	private String allergies;		//та упокоипа пеяиевоум стоивеиа та опоиа сулпкгяымоум ои вягстес йаи апеийомеифомтаи се FRAMES.	
	private String egxeirhseis;
	private String farmaka;
	private String genikaSxolia;
	private String kardiologiko;
	private String paragontes;
	private String paratiriseis;
	private String sxoliaEksetasewn; 
	private PatientDataTransferObject pdto; //еды упаявоум та пкеом басийа стоивеиа тоу вягстг поу летажеяомтаи стг басг
	
	public PatientDataTransferObject getPdto() {
		return pdto;
	}
	
	public Patient(String amka, String first,String last){
		this.first=first;
		this.last=last;
		this.amka=amka;
		this.pdto=new PatientDataTransferObject(amka); 
	}
	
	
	
	
	public void save_Patient_in_DB(boolean exists){ //апохуйеуеи том асхемг стг басг дедолемым
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
			File file = new File("temporaryPatient.bin");				//апохуйеуеи то аявеио тоу асхемг стг басг
			FileOutputStream fout = new FileOutputStream(file);			//дглиоуяцомтас ема TEMPORARY.
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
	
	
	//Жоятымеи то аявеио тоу асхемг апо тг басг дедолемым
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

		os.close();
		oss.close();
		}
		return mary;
		
		} catch (Exception e ){
			e.printStackTrace();
				 System.out.println("Arxeio Exception");
				 	return null;
		}
	}	
	

	//елжамифеи ема аявеио енетасеым(PICTURE FILE) поу епикецетаи апо то вягтсг
	public void loadEksetasi(int id) {


		Connection conn=null;
		try{
			conn=User.getConnection();
		}catch(Exception e){
			System.out.println("Couldnt connect to database");
		
		}
		
		try{
		PreparedStatement statement = conn.prepareStatement("SELECT file FROM Eksetaseis where id="+id+" and AMKA = '"+this.amka+"'");
		ResultSet result = statement.executeQuery();
		
			File file = new File("testing.jpg"); //ваягм апкотгтас то йахе аявеио поу йатебафетаи амтийахгста то TESTING.
		while (result.next()) {						//пио пяайтийо ха гтам ма дглиоуяце╨таи ема пкгяес амтицяажо ле том титко тоу аявеио се йапоио жайеко
													//йати поу лпояеи ма цимеи ле лийяес аккацес стом йыдийа тгс леходоу аутгс. то паяатгягсале сто текос йаи 
													//ежосым дем епгяеафетаи г кеитоуяцийотгта йаи бяисйоласте стгм пяытг ейдосг апожасисале ма то ажгсоуле етси.
			
			InputStream in = result.getBinaryStream(1); 
			OutputStream fos = new FileOutputStream(file);
			int c = 0;
			while ((c = in.read()) > -1) {
				fos.write(c);		//лесы STREAM цяажетаи ема амтицяажо тоу аявеиоу йаи стг сумевеиа
			}
			fos.close();
			in.close();
		}
	
									
		String imagePath=file.getAbsolutePath();//амоицетаи.
		Desktop desktop=Desktop.getDesktop();
		desktop.open(new File(imagePath));
		
		
		
		} catch (Exception e ){
			e.printStackTrace();
				 System.out.println("Arxeio Exception");
				 e.printStackTrace();
		}
		
	}
	

	//O вягстгс епикцеи ема аявеио апо том упокоцистг тоу йаи то амебафеи стг басг.
	public void uploadExsetasi(User user) throws Exception {
		
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
			FileInputStream inputStream = new FileInputStream(file);
			String sql = " INSERT INTO Eksetaseis (AMKA,file,Title,username) VALUES (?,?,?,?) ";
			PreparedStatement sQLstatement = User.getConnection().prepareStatement(sql);

			sQLstatement.setString(1, this.amka);
			sQLstatement.setBinaryStream(2, (InputStream)inputStream,(int)file.length());
			sQLstatement.setString(3,file.getName());	
			sQLstatement.setString(4,user.getUser_name());
			  
			sQLstatement.executeUpdate();
			
			
		
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

	public void setFirst(String text) {
		this.first=text;	
	}
	
	public void setLast(String text) {
		this.last=text;	
	}


	public String getAmka() {
		return amka;
	}

	public void setAmka(String amka) {
		this.amka = amka;
	}

	public String getAstheneies() {
		return astheneies;
	}	

	public String getAllergies() {
		return allergies;
	}

	

	public void setEgxeirhseis(String s) {
		this.egxeirhseis=s;
	}
	

	public void setAllergies(String s) {
		this.allergies=s;
	}
	

	public void setAstheneies(String s) {
		this.astheneies=s;
	}
	

	public void setGenikaSxolia(String s) {
		this.genikaSxolia=s;
	}
	

	public void setFarmaka(String s) {
		this.farmaka=s;
	}
	

	public void setKardiologiko(String s) {
		this.kardiologiko=s;
	}

	public void setParatiriseis(String s) {
		this.paratiriseis=s;
	}
	public String getParatiriseis(){
		return paratiriseis;
	}
	
	public void setParagontes(String s) {
		this.paragontes=s;
	}
	

	public String getEgxeirhseis() {
		return egxeirhseis;
	}
	
	public String getFarmaka() {
		return farmaka;
	}

	public String getGenikaSxolia() {
		return genikaSxolia;
	}

	public String getKardiologiko() {
		return kardiologiko;
	}

	public String getParagontes() {
		return paragontes;
	}

	public String getSxoliaEks() {
		return sxoliaEksetasewn;
	}

	public void setSxoliaEks(String sxoliaEks) {
		this.sxoliaEksetasewn = sxoliaEks;
	}

}