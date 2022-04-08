package gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * klasse som oppretter bakgrunn
 * @author Maksim
 */
public class Background extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JLabel picLabel;
	
	/**
	 * konstruktor som henter bakgrunnsbilde og setter det som JLabel paa JPanel som blir igjen
	 * lagt til JFrame
	 */
	public Background() {
		JPanel ballArea = new JPanel();
		
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("src\\\\main\\\\resources\\\\background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		picLabel = new JLabel(new ImageIcon(background));
		
		ballArea.add(picLabel);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1100, 770);
		frame.add(ballArea);
		
		frame.setVisible(true);
		
	}

	public JLabel getPicLabel() {
		return picLabel;
	}

	public void setPicLabel(JLabel picLabel) {
		this.picLabel = picLabel;
	}	
	
}
