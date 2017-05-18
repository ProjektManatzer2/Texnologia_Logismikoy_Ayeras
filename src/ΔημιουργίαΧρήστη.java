import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ΔημιουργίαΧρήστη {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ΔημιουργίαΧρήστη window = new ΔημιουργίαΧρήστη();
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
	public ΔημιουργίαΧρήστη() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7 2");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(150, 39, 300, 23);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u0393\u03B9\u03B1\u03C4\u03C1\u03CC\u03C2");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(0, 0, 130, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u0399\u03B1\u03C4\u03C1\u03B9\u03BA\u03CC \u03C0\u03C1\u03BF\u03C3\u03C9\u03C0\u03B9\u03BA\u03CC");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(160, 0, 130, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 94, 60, 23);
		frame.getContentPane().add(lblNewLabel);
	}
}
