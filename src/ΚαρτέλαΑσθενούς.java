import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ΚαρτέλαΑσθενούς extends JFrame{


	private JTextField txtOKargasEinai;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField;
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
	private JLabel textField_19;
	private JTextField textField_20;



	public ΚαρτέλαΑσθενούς() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.getContentPane().setEnabled(false);
		this.setResizable(false);
		this.setTitle("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BA\u03B1\u03C1\u03C4\u03AD\u03BB\u03B1\u03C2 \u03B1\u03C3\u03B8\u03B5\u03BD\u03BF\u03CD\u03C2");
		this.setBounds(100, 100, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 :");
		lblNewLabel.setBounds(14, 10, 50, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtOKargasEinai = new JTextField();
		txtOKargasEinai.setBounds(74, 10, 170, 20);
		txtOKargasEinai.setHorizontalAlignment(SwingConstants.CENTER);
		txtOKargasEinai.setColumns(10);
		
		JLabel label = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF :");
		label.setBounds(262, 10, 60, 20);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(336, 10, 170, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u03A0\u03B1\u03C4\u03C1\u03CE\u03BD\u03C5\u03BC\u03BF :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(520, 10, 72, 20);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(604, 10, 170, 20);
		textField_2.setColumns(10);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(lblNewLabel);
		this.getContentPane().add(txtOKargasEinai);
		this.getContentPane().add(label);
		this.getContentPane().add(textField_1);
		this.getContentPane().add(lblNewLabel_1);
		this.getContentPane().add(textField_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A6\u03CD\u03BB\u03BB\u03BF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(17, 34, 233, 46);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u0386\u03BD\u03B4\u03C1\u03B1\u03C2");
		rdbtnNewRadioButton.setBounds(6, 16, 109, 23);
		panel.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u0393\u03C5\u03BD\u03B1\u03AF\u03BA\u03B1\r\n");
		rdbtnNewRadioButton_1.setBounds(124, 16, 105, 23);
		panel.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		JLabel label_1 = new JLabel("\u0397\u03BC. \u0393\u03AD\u03BD\u03BD\u03B7\u03C3\u03B7\u03C2 :\r\n");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(262, 50, 75, 20);
		this.getContentPane().add(label_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_1.setBounds(346, 60, 35, 20);
		this.getContentPane().add(spinner_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setBounds(390, 60, 35, 20);
		this.getContentPane().add(spinner);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(1900), null, new Integer(1)));
		spinner_2.setBounds(434, 60, 60, 20);
		this.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u0397\u0397\r\n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(346, 41, 35, 20);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u039C\u039C\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(390, 41, 35, 20);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u03A7\u03A7\u03A7\u03A7");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(434, 41, 60, 14);
		this.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u0392\u03AC\u03C1\u03BF\u03C2 :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(560, 41, 46, 14);
		this.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u038E\u03C8\u03BF\u03C2 :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(560, 66, 46, 14);
		this.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(616, 41, 100, 20);
		this.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(616, 60, 100, 20);
		this.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("(K.g)");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(716, 41, 46, 20);
		this.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("(c.m)\r\n");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(716, 60, 46, 20);
		this.getContentPane().add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03BA\u03B1\u03C4\u03BF\u03B9\u03BA\u03AF\u03B1\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(17, 90, 172, 133);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 :\r\n");
		lblNewLabel_9.setBounds(6, 16, 65, 20);
		panel_1.add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(75, 16, 86, 20);
		panel_1.add(textField_5);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE :");
		lblNewLabel_10.setBounds(11, 46, 60, 20);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_6 = new JTextField();
		textField_6.setBounds(75, 46, 86, 20);
		panel_1.add(textField_6);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u03A0\u03CC\u03BB\u03B7 :");
		lblNewLabel_11.setBounds(11, 76, 60, 20);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_7 = new JTextField();
		textField_7.setBounds(75, 76, 86, 20);
		panel_1.add(textField_7);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("\u03A4.\u039A :\r\n");
		lblNewLabel_12.setBounds(25, 106, 46, 20);
		panel_1.add(lblNewLabel_12);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(75, 106, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03B1\u03C3\u03C6\u03B1\u03BB\u03B9\u03C3\u03BC\u03AD\u03BD\u03BF\u03C5 & \u03BB\u03BF\u03B9\u03C0\u03AC \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(202, 89, 578, 133);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("\u0395\u03C0\u03AC\u03B3\u03B3\u03B5\u03BB\u03BC\u03B1 :\r\n");
		lblNewLabel_13.setBounds(11, 18, 105, 20);
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_8 = new JTextField();
		textField_8.setBounds(120, 18, 150, 20);
		panel_2.add(textField_8);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("\u03A4\u03B1\u03BC\u03B5\u03AF\u03BF :");
		lblNewLabel_14.setBounds(11, 56, 105, 20);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_9 = new JTextField();
		textField_9.setBounds(120, 56, 150, 20);
		panel_2.add(textField_9);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("\u039F\u03B9\u03BA\u03BF\u03B3. \u03BA\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 :\r\n");
		lblNewLabel_15.setBounds(11, 94, 107, 20);
		panel_2.add(lblNewLabel_15);
		
		textField_10 = new JTextField();
		textField_10.setBounds(120, 94, 150, 20);
		panel_2.add(textField_10);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("\u0391\u039C\u039A\u0391 :");
		lblNewLabel_16.setBounds(343, 18, 45, 20);
		panel_2.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_11 = new JTextField();
		textField_11.setBounds(402, 18, 170, 20);
		panel_2.add(textField_11);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("\u0391\u039C\u0391 :");
		lblNewLabel_17.setBounds(343, 56, 45, 20);
		panel_2.add(lblNewLabel_17);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_12 = new JTextField();
		textField_12.setBounds(402, 56, 170, 20);
		panel_2.add(textField_12);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("\u0391.\u03A4 :\r\n");
		lblNewLabel_18.setBounds(343, 94, 45, 20);
		panel_2.add(lblNewLabel_18);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_13 = new JTextField();
		textField_13.setBounds(402, 94, 170, 20);
		panel_2.add(textField_13);
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03B5\u03C0\u03B9\u03BA\u03BF\u03B9\u03BD\u03C9\u03BD\u03AF\u03B1\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(17, 227, 764, 74);
		this.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("\u039A\u03B9\u03BD\u03B7\u03C4\u03CC :");
		lblNewLabel_19.setBounds(6, 16, 65, 20);
		panel_3.add(lblNewLabel_19);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_14 = new JTextField();
		textField_14.setBounds(76, 16, 86, 20);
		panel_3.add(textField_14);
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("\u03A4\u03B7\u03BB. \u039F\u03B9\u03BA\u03AF\u03B1\u03C2 :");
		lblNewLabel_20.setBounds(7, 47, 65, 20);
		panel_3.add(lblNewLabel_20);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_15 = new JTextField();
		textField_15.setBounds(76, 47, 86, 20);
		panel_3.add(textField_15);
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("\u03A4\u03B7\u03BB. \u0395\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2 :");
		lblNewLabel_21.setBounds(251, 16, 75, 20);
		panel_3.add(lblNewLabel_21);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_16 = new JTextField();
		textField_16.setBounds(331, 16, 86, 20);
		panel_3.add(textField_16);
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setBounds(251, 47, 75, 20);
		panel_3.add(lblFax);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_17 = new JTextField();
		textField_17.setBounds(331, 47, 86, 20);
		panel_3.add(textField_17);
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("E-MAIL:\r\n");
		lblNewLabel_22.setBounds(508, 28, 45, 20);
		panel_3.add(lblNewLabel_22);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_18 = new JTextField();
		textField_18.setBounds(558, 28, 200, 20);
		panel_3.add(textField_18);
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 312, 385, 120);
		this.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2 :");
		scrollPane.setViewportView(textPane);
		
		textField_19 = new JLabel();
		textField_19.setText("\u0397\u03BC\u03B5\u03C1/\u03BD\u03AF\u03B1 \u03B5\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE\u03C2 :\r\n");
		textField_19.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_19.setBounds(544, 312, 120, 20);
		this.getContentPane().add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setBounds(670, 312, 110, 20);
		this.getContentPane().add(textField_20);
		textField_20.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0395\u03C0\u03CC\u03BC\u03B5\u03BD\u03BF");
		btnNewButton.setBounds(695, 437, 89, 23);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		btnNewButton_1.setBounds(596, 437, 89, 23);
		this.getContentPane().add(btnNewButton_1);
		
		this.setVisible(true);
	}
}
