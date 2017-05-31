import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class DeletePatientFromClinicFrame {

	private JFrame frame;

	public DeletePatientFromClinicFrame(Patient patient) {
		/*
		 * This frame shows up only when a user has pressed delete button
		 * to a patient.
		 */
	
		JTextPane textPane;
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 158);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("маи");
		btnNewButton.addActionListener(new ActionListener() { //If yes is pressed the patient is deleted.
	
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String sql = "UPDATE Astheneis SET clinic=0 WHERE AMKA='" + patient.getAMKA() +"'";
				try {	//The column clinic of the database becomes zero which means that the patient is not in a clinic.
					PreparedStatement statement=User.getConnection().prepareStatement(sql);
					statement.executeUpdate();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy"); //Then, the date that he left the clinic gets into the
				Date date = new Date();										//patient's information.
				patient.getPdto().setDateOut(dateFormat.format(date));
				patient.save_Patient_in_DB(true);
			}
		});
		btnNewButton.setBounds(237, 86, 150, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("ови");
		button.addActionListener(new ActionListener() { //If no is pressed then the frame is closed
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();}
		});
		button.setBounds(77, 86, 150, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(53, 11, 356, 64);
		frame.getContentPane().add(scrollPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(textPane_1);
		textPane_1.setText("\u0395\u03AF\u03C3\u03C4\u03B5 \u03C3\u03AF\u03B3\u03BF\u03C5\u03C1\u03BF\u03B9 \u03CC\u03C4\u03B9 \u03B8\u03AD\u03BB\u03B5\u03C4\u03B5 \u03BD\u03B1 \u03B4\u03B9\u03B1\u03B3\u03C1\u03AC\u03C8\u03B5\u03C4\u03B5 \u03C4\u03BF \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF \u03C4\u03BF\u03C5 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7;\u03A4\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C4\u03BF\u03C5 \u03B8\u03B1 \u03BC\u03B5\u03C4\u03B1\u03C6\u03B5\u03C1\u03B8\u03BF\u03CD\u03BD \u03C3\u03C4\u03B7 \u03B3\u03C1\u03B1\u03BC\u03BC\u03B1\u03C4\u03B5\u03AF\u03B1.");

		frame.setVisible(true);
	
	}
}
