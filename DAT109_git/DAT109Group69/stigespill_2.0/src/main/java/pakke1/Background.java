package pakke1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel{

	public Background() {
		this.setPreferredSize(new Dimension(1087,727));
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("src\\main\\resources\\background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g2D.drawImage(background, null, 0, 0);
		
//		g2D.setPaint(Color.blue);
//		g2D.fillOval(10, 700, 20, 20);
//		
//		g2D.setPaint(Color.red);
//		g2D.fillOval(120, 628, 20, 20);
//		
//		g2D.setPaint(Color.green);
//		g2D.fillOval(982, 52, 20, 20);
		
		
		
		
	}
}
