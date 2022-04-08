package pakke1;

import java.awt.Dimension;

import javax.swing.JFrame;


public class MyFrame extends JFrame{
	
	NewPanel panel;
	
	public MyFrame() {
		
		panel = new NewPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1110,770));
		
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
}
