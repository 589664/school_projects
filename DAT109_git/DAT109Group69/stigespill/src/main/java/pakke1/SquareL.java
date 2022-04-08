package pakke1;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

class SquareL extends JLabel {
    
	private static final long serialVersionUID = 1L;
	
	private Color top, bottom;
     
    public SquareL(String s) {
        super(s);
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }
     
    public void setTopcolor(Color c) {
        top = c;
        repaint();
    }
     
    public void setBottomColor(Color c) {
        bottom = c;
        repaint();
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth(), h = this.getHeight();
        g.setColor(top);
        g.fillRect(0, 0, w, h / 2);
        g.setColor(bottom);
        g.fillRect(0, h / 2, w, h / 2);
        g.setColor(Color.black);
        super.paintComponent(g);  // 
    }
}
