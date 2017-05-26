import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class UneditableTableModel extends DefaultTableModel{
	 
	
		public UneditableTableModel(Vector rows, Vector columnNames) {
			super(rows,columnNames);
			
			
	}

		@Override	
	   public boolean isCellEditable(int row, int column) {
	      return false;
	   }
		
	
}


