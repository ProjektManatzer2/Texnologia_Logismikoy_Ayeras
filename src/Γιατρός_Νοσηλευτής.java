import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Γιατρός_Νοσηλευτής {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Γιατρός_Νοσηλευτής window = new Γιατρός_Νοσηλευτής();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Γιατρός_Νοσηλευτής() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0393\u03B9\u03B1\u03C4\u03C1\u03CC\u03C2/\u039D\u03BF\u03C3\u03B7\u03BB\u03B5\u03C5\u03C4\u03AE\u03C2");
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD \u039A\u03BB\u03B9\u03BD\u03B9\u03BA\u03AE\u03C2");
		btnNewButton.setBounds(180, 100, 240, 24);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0391\u03AF\u03C4\u03B7\u03BC\u03B1 \u03A0\u03B1\u03C1\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2 \u0394\u03B9\u03BA\u03B1\u03B9\u03C9\u03BC\u03AC\u03C4\u03C9\u03BD");
		btnNewButton_1.setBounds(180, 150, 240, 24);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0391\u03C0\u03BF\u03C3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		btnNewButton_2.setBounds(240, 230, 120, 24);
		frame.getContentPane().add(btnNewButton_2);
	}
}
