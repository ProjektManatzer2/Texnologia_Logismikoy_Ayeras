import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class UneditableTableModel extends DefaultTableModel{
	 
	//Κλάση που βοηθά στη δημιουργία πίνακα του οποίου τα στοιχεία ΔΕΝ είναι επεξεργάσιμα.
	
	public UneditableTableModel(Vector rows, Vector columnNames) {
		super(rows,columnNames);
		
		
	}
	public UneditableTableModel(int rows, int columnNames) {
		super(rows,columnNames);
		
		
	}

		@Override	
	   public boolean isCellEditable(int row, int column) {
	      return false;
	   }
		
	
}


