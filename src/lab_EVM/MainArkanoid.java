package lab_EVM;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
public class MainArkanoid {

	private JFrame frame;
	static ClassArkanoid arrayField;
    private Timer timer;
    int k = 1;
    int i = 46;
	int j = 35;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainArkanoid window = new MainArkanoid();
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
	public MainArkanoid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		arrayField = new ClassArkanoid();
		arrayField.Level();
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panelMain = new PanelArkanoid(arrayField);
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 799, 641);
		frame.getContentPane().add(panelMain);
        panelMain.setFocusable(true);
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (k == 1) {
            		k = arrayField.step3(i, j);
            		if ( k == 1) {
            			i--;
            			j++;
            		}
            		System.out.println(k);
                	//arrayField.print();
                	//System.out.println(i + " " + j);
            		panelMain.repaint();
            	}
            	if (k == 2) {
            		k = arrayField.step4(i, j);
            		if (k == 2) {
            			i--;
            			j--;
            		}
            		System.out.println(k);
                	//arrayField.print();
                	//System.out.println(i + " " + j);
            		panelMain.repaint();
            	}
            	if (k == 3) {
            		k = arrayField.step2(i, j);
            		if ( k == 3) {
            			i++;
            			j--;
            		}
            		System.out.println(k);
                	//arrayField.print();
                	//System.out.println(i + " " + j);
            		panelMain.repaint();
            	}
            	if (k == 4) {
            		k = arrayField.step1(i, j);
            		if (k == 4) {
            			i++;
            			j++;
            		}
            		System.out.println(k);
                	//arrayField.print();
					//System.out.println(i + " " + j);
            		panelMain.repaint();
            	}
            	if (k == 5) {
            		timer.stop();
            		arrayField.Level();
            		panelMain.repaint();
            	}
            }
        };
		
		panelMain.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    	arrayField.Left();
                    	//arrayField.print();
                    	panelMain.repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                    	arrayField.Right();
                    	//arrayField.print();
                    	panelMain.repaint();
                        break;
                    case KeyEvent.VK_ENTER:
                    	Timer timer = new Timer( 100, listener );
                    	timer.start();
                    	break;
                }
            }
        });
		
	}
}
