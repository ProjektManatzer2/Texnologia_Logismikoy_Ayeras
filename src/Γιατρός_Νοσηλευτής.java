import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Γιατρός_Νοσηλευτής {
	
	private JButton aitimaButton;
	private JButton provoliAsthenwnButton;
	private JFrame frame;
	private User user;
	private JButton disconnectButton;
	
	public Γιατρός_Νοσηλευτής(User u) {
		this.user=u;
		initialize();
	}

	/**
	 * ARXIKH SELIDA TOY NOSHLEUTH KAI TOY GIATROY
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0393\u03B9\u03B1\u03C4\u03C1\u03CC\u03C2/\u039D\u03BF\u03C3\u03B7\u03BB\u03B5\u03C5\u03C4\u03AE\u03C2");
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		provoliAsthenwnButton= new JButton("Προβολή Ασθενών Κλινικής");
		provoliAsthenwnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//AN PATH8EI TO KOYMPI KALEITAI H ANAZHTHSH ASTHENWN, EFOSWN OMWS THA PAREI WS ORISMA XRHSTH GIATRO H NOSHLEYTH THA EMFANISEI MONO AYTOYS TOYS XRHSTES TH KLINIKIS TOYS
			frame.dispose();
			new PatientSearch(user);
			
			}
		});
		provoliAsthenwnButton.setBounds(180, 100, 240, 24);
		frame.getContentPane().add(provoliAsthenwnButton);
		
		aitimaButton = new JButton("Αίτημα Παραχώρησης Δικαιωμάτων");
		aitimaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SE AYTO TO PLHKTRO EMFANIZONTAI OI ASTHENEIS STOYS OPOIOYS MPOREI NA KANEI AITHSH NA PAREI TA STOIXEIA TOYS
				frame.dispose();
				new αίτημα(user);
			}
		});
		aitimaButton.setBounds(180, 150, 240, 24);
		frame.getContentPane().add(aitimaButton);
		
		disconnectButton= new JButton("Αποσύνδεση");
		disconnectButton.setBounds(241, 243, 120, 24);
		frame.getContentPane().add(disconnectButton);
		
		JButton button = new JButton("Εμφάνιση επιπλέον ασθενών");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new FrameOfBonusPatients(user);//KAI EDW OI ASTHENEIS EKTOS KLINIKHS POY MPOREI NA PROBALEI TA STOIXEIA TOYS.
			
			}
		});
		button.setBounds(180, 195, 240, 24);
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}
}
