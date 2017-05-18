import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class AitimaDikaiwmatwn {

	private JFrame frame;
	private JTextField OnomaGiatroy;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	
	
	public AitimaDikaiwmatwn(Doctor dc, ArrayList<Patient> pt) {
		initialize(dc, pt);
	}

	 
	private void initialize(Doctor dc, ArrayList<Patient> patients) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 424, 62);
		frame.getContentPane().add(scrollPane);
		
		OnomaGiatroy = new JTextField("O Γιατρός "+ dc.getFirst() +" "+dc.getLast() +"-> UserName = "+dc.getUser_name());
		scrollPane.setViewportView(OnomaGiatroy);
		OnomaGiatroy.setColumns(10);
		String onomataAsthenwn="Χρειάζεται τον φάκελο του/της/των:  ";
		for(Patient pt:patients)
			onomataAsthenwn+= "\n"+pt.getFirst()+" "+pt.getLast()+" Mε AMKA  "+pt.getAMKA();
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 120, 349, 141);
		frame.getContentPane().add(scrollPane_1);
	
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setText(onomataAsthenwn);
		frame.setVisible(true);
	}
}
