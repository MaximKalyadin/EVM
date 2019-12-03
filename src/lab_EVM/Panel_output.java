package lab_EVM;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Panel_output extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		lab4_class.Draw(g);
	}
}
