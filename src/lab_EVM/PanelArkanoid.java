package lab_EVM;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelArkanoid extends JPanel {
	ClassArkanoid arr;
	public PanelArkanoid(ClassArkanoid array) {
		setLayout(null);
		arr = array;
	}
	public void paint(Graphics g)  {
		super.paint(g);		
		arr.drawArray(g, this.getWidth() + 2, this.getHeight());
	}
}
