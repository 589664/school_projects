package pakke1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class NewPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public NewPanel() {
		this.setPreferredSize(new Dimension(1087,727));
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2D = (Graphics2D) g;
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("src\\main\\resources\\background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g2D.drawImage(background, null, 0, 0);
		
		
	}
}
