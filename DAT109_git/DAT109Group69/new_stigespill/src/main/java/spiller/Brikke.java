package spiller;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * klasse som opprette brikke v.h.a JPanel
 * @author Maksim
 */
public class Brikke extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Color color;
	private int diameter;
	private long delay;
	private int vx;
	private int vy;
	private int padding;

	/**
	 * 
	 * @param color
	 * @param xvelocity
	 * @param yvelocity
	 * @param padding
	 */
	public Brikke(Color color, int xvelocity, int yvelocity, int padding) {
		this.color = color;
		diameter = 20;

		vx = xvelocity;
		vy = yvelocity;

		setSize(getPreferredSize());
		setLocation(xvelocity, yvelocity);
		
	}
	
	/**
	 * legger graphics2D til graphics og tegner brikken
	 */
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


	public int getPadding() {
		return padding;
	}


	public void setPadding(int padding) {
		this.padding = padding;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}
	
}

