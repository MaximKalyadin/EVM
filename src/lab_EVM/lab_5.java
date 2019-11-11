package lab_EVM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class lab_5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_5 window = new lab_5();
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
	public lab_5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1122, 846);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setBounds(12, 13, 234, 392);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u044C \u0442\u0430\u0431\u043B\u0438\u0446\u0443");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
				out += lab4_class.out();
				textArea.setText(out);
			}
		});
		button.setBounds(53, 418, 150, 25);
		frame.getContentPane().add(button);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(258, 13, 834, 392);
		frame.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("\u0412\u044B\u0432\u0435\u0441\u0442\u0438 \u0434\u043D\u0444");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
				int k = lab4_class.KOL();
				out += lab4_class.outDnf();
				out += "=";
				out += lab4_class.Outdprom(k);
				out += "=";
				out += lab4_class.dnf();
				textArea_1.setText(out);
			}
		});
		button_1.setBounds(258, 418, 120, 25);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u0412\u044B\u0432\u0435\u0441\u0442\u0438 \u043A\u043D\u0444");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
				int k = lab4_class.Kol();
				out += lab4_class.outKnf();
				out += "=";
				out += lab4_class.Outkprom(k);
				out += "=";
				out += lab4_class.knf();
				textArea_1.setText(out);
				
				
			}
		});
		button_2.setBounds(390, 418, 120, 25);
		frame.getContentPane().add(button_2);
	}
}
