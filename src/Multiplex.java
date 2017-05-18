import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Multiplex {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Multiplex window = new Multiplex();
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
	public Multiplex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03A6\u03B1\u03BA\u03AD\u03BB\u03BF\u03C5");
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setBounds(33, 30, 727, 359);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u0393\u03B5\u03BD\u03B9\u03BA\u03AC \u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		lblNewLabel.setBounds(0, 0, 60, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF :");
		lblNewLabel_1.setBounds(0, 30, 60, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		lblNewLabel_2.setBounds(0, 60, 70, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0391\u039C\u039A\u0391 :");
		lblNewLabel_3.setBounds(0, 90, 46, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0391\u039C\u0391 :");
		lblNewLabel_4.setBounds(0, 120, 46, 24);
		panel.add(lblNewLabel_4);
		
		JLabel label = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03AF\u03BF :");
		label.setBounds(0, 150, 46, 24);
		panel.add(label);
		
		JLabel lblNewLabel_5 = new JLabel("\u0397\u03BC. \u0393\u03AD\u03BD\u03BD\u03B7\u03C3\u03B7\u03C2 :");
		lblNewLabel_5.setBounds(0, 180, 80, 24);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(92, 0, 200, 24);
		panel.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 30, 200, 24);
		panel.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 60, 200, 24);
		panel.add(textField_2);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 90, 200, 24);
		panel.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 120, 200, 24);
		panel.add(textField_4);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 150, 200, 24);
		panel.add(textField_5);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 180, 200, 24);
		panel.add(textField_6);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(0, 215, 110, 24);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setEnabled(false);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(182, 215, 110, 24);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setEnabled(false);
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("\u0392\u03AC\u03C1\u03BF\u03C2 :");
		lblNewLabel_6.setBounds(0, 245, 46, 24);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u038E\u03C8\u03BF\u03C2 :");
		lblNewLabel_7.setBounds(0, 275, 46, 24);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u0395\u03C0\u03AC\u03B3\u03B3\u03B5\u03BB\u03BC\u03B1 :");
		lblNewLabel_8.setBounds(0, 305, 60, 24);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u039F\u03B9\u03BA\u03BF\u03B3. \u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 :");
		lblNewLabel_9.setBounds(0, 335, 95, 24);
		panel.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(92, 245, 200, 24);
		panel.add(textField_7);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(92, 275, 200, 24);
		panel.add(textField_8);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(92, 305, 200, 24);
		panel.add(textField_9);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(92, 335, 200, 24);
		panel.add(textField_10);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 :");
		lblNewLabel_10.setBounds(420, 0, 60, 24);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		lblNewLabel_11.setBounds(420, 30, 46, 24);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		lblNewLabel_12.setBounds(420, 60, 46, 24);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("\u03A4\u03B7\u03BB. \u039A\u03B9\u03BD\u03B7\u03C4\u03CC :");
		lblNewLabel_13.setBounds(420, 90, 64, 24);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("\u03A4\u03B7\u03BB. \u039F\u03B9\u03BA\u03AF\u03B1\u03C2 :");
		lblNewLabel_14.setBounds(420, 120, 62, 24);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2:");
		lblNewLabel_15.setBounds(420, 150, 75, 24);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("E-mail :");
		lblNewLabel_16.setBounds(420, 180, 46, 24);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("FAX :");
		lblNewLabel_17.setBounds(420, 210, 46, 24);
		panel.add(lblNewLabel_17);
		
		textField_11 = new JTextField();
		textField_11.setBounds(510, 150, 200, 24);
		panel.add(textField_11);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(510, 120, 200, 24);
		panel.add(textField_12);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(510, 0, 200, 24);
		panel.add(textField_13);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(510, 30, 200, 24);
		panel.add(textField_14);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(510, 60, 200, 24);
		panel.add(textField_15);
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(510, 90, 200, 24);
		panel.add(textField_16);
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(510, 180, 200, 24);
		panel.add(textField_17);
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(510, 210, 200, 24);
		panel.add(textField_18);
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("\u0397\u03BC. \u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE\u03C2 :");
		lblNewLabel_18.setBounds(420, 240, 80, 24);
		panel.add(lblNewLabel_18);
		
		textField_19 = new JTextField();
		textField_19.setBounds(520, 240, 200, 24);
		panel.add(textField_19);
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u0399\u03B1\u03C4\u03C1\u03B9\u03BA\u03CC \u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u0395\u03BE\u03B5\u03C4\u03AC\u03C3\u03B5\u03B9\u03C2", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(181, 83, 360, 161);
		panel_3.add(textPane);
		
		JLabel lblNewLabel_19 = new JLabel("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(320, 50, 80, 24);
		panel_3.add(lblNewLabel_19);
		
		JButton btnNewButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03A0\u03B1\u03C1\u03B1\u03C4\u03AE\u03C1\u03B7\u03C3\u03B7\u03C2");
		btnNewButton.setBounds(281, 266, 160, 23);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton_2.setBounds(350, 410, 100, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
