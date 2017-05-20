import java.io.*;

public class Patient implements Serializable {
	
	
	/**
	 * 
	 */
	protected static final long serialVersionUID = 737501913632927252L;
	protected String first;
	protected String last;
	protected String amka;
	
	
	public Patient(String first,String last,String amka){
		this.first=first;
		this.last=last;
		this.amka=amka;
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
