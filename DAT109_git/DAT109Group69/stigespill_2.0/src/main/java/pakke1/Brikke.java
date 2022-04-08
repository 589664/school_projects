package pakke1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Brikke extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Color color;
	int diameter;
	long delay;
	private int vx;
	private int vy;

	public Brikke(Color color, int xvelocity, int yvelocity) {
		this.color = color;
		diameter = 20;

		vx = xvelocity;
		vy = yvelocity;

		setSize(getPreferredSize());
		setLocation(xvelocity, yvelocity);
		
	}
	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(color);
		g.fillOval(0, 0, 20-1, 20-1);
		g.setColor(Color.black);
		g2.drawOval(0, 0, 20-1, 20-1);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(20, 20);
	}


	public int getVx() {
		return vx;
	}


	public void setVx(int vx) {
		this.vx = vx;
	}


	public int getVy() {
		return vy;
	}


	public void setVy(int vy) {
		this.vy = vy;
	}
	
}

