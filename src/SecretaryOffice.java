import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SecretaryOffice {

	private JFrame frmSecretarysOffice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretaryOffice window = new SecretaryOffice();
					window.frmSecretarysOffice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecretaryOffice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecretarysOffice = new JFrame();
		frmSecretarysOffice.setResizable(false);
		frmSecretarysOffice.setTitle("Secretary's office");
		frmSecretarysOffice.setBounds(100, 100, 600, 400);
		frmSecretarysOffice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecretarysOffice.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BA\u03B1\u03C1\u03C4\u03AD\u03BB\u03B1\u03C2 \u03B1\u03C3\u03B8\u03B5\u03BD\u03BF\u03CD\u03C2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(200, 70, 200, 23);
		frmSecretarysOffice.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
		btnNewButton_1.setBounds(200, 110, 200, 23);
		frmSecretarysOffice.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03AE \u0393\u03B9\u03B1\u03C4\u03C1\u03CE\u03BD");
		btnNewButton_2.setBounds(200, 150, 200, 23);
		frmSecretarysOffice.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD");
		btnNewButton_3.setBounds(200, 190, 200, 23);
		frmSecretarysOffice.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u0391\u03C0\u03BF\u03C3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		btnNewButton_4.setBounds(250, 240, 100, 23);
		frmSecretarysOffice.getContentPane().add(btnNewButton_4);
	}

}
