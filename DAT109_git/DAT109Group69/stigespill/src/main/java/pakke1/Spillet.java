package pakke1;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spillet {

	public static void main(String[] args) throws InterruptedException {
		
		int verdi = 1;
		
		Rute spill[][] = new Rute[10][10];
		
		for (int i = 0; i < spill.length; i++) {
			
			for (int j = 0; j < spill.length; j++) {
				spill[i][j] = new Rute(verdi, 0);
				verdi++;
			}//for indre
		}//for ytre
		
		Spillet metode = new Spillet();
		
		Rute spill1[][] = metode.flipTab(spill);
		
		metode.spill(spill1);
		
		
	}//main
	
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JLabel[][] squares;
	
	public void spill(Rute[][] spill) throws InterruptedException {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.setVisible(true);
		
		frame.setLayout(new GridLayout(10,10));
		squares = new JLabel[10][10];
		
		for (int i = 0; i < spill.length; i++) {
			for (int j = 0; j < spill[0].length; j++) {
				SquareL square = new SquareL(String.valueOf(spill[i][j].getVerdi()));
				square.setTopcolor(Color.white);
				square.setBottomColor(Color.white);
				squares[i][j] = square;
				frame.add(square);
			}
		}//ytre
		
		
		Spiller spiller = new Spiller("Spiller1", Color.green, new Terning(0), 1, true);
		Spiller spiller1 = new Spiller("Spiller2", Color.red, new Terning(5), 1, false);
		
		while (spiller.getPosisjon() < 100 && spiller1.getPosisjon() < 100) {
			
			if (spiller.getTur() == true) {
				int terning = spiller.getTerning().trillTerning();
				int gammelpos = spiller.getPosisjon();
				if (spiller.getPosisjon() + terning <= 100) {
					spiller.setPosisjon(spiller.getPosisjon() + terning);
					
					for (int i = 0; i < spill.length; i++) {
						for (int j = 0; j < spill[0].length; j++) {
							if (gammelpos == spill[i][j].getVerdi()) {
								((SquareL) squares[i][j]).setBottomColor(Color.white);
							}
							if (spiller.getPosisjon() == spill[i][j].getVerdi()) {
								((SquareL) squares[i][j]).setBottomColor(spiller.getFarge());
							}
						}//indre
						spiller.setTur(false);
						spiller1.setTur(true);
					}//ytre
				}
			} else {
				int terning1 = spiller1.getTerning().trillTerning();
				int gammelpos1 = spiller1.getPosisjon();
				if (spiller1.getPosisjon() + terning1 <= 100) {
					spiller1.setPosisjon(spiller1.getPosisjon() + terning1);
					
					for (int i = 0; i < spill.length; i++) {
						for (int j = 0; j < spill[0].length; j++) {
							if (gammelpos1 == spill[i][j].getVerdi()) {
								((SquareL) squares[i][j]).setTopcolor(Color.white);
							}
							if (spiller1.getPosisjon() == spill[i][j].getVerdi()) {
								((SquareL) squares[i][j]).setTopcolor(spiller1.getFarge());
							}
						}//indre
						spiller1.setTur(false);
						spiller.setTur(true);
					}//ytre
				}
			}
			
			Thread.sleep(1000);
		}//while
		
	}//spill metode
	
	public Rute[][] flipTab(Rute[][] spill) {
		
		Rute[][] flipped = new Rute[spill.length][spill[0].length];
		
		int r = 0;
		int k = 0;
		
		for (int i = spill.length-1; i >= 0; i--) {
			
			if (i % 2 == 0) {
				for (int j = 0; j < spill.length; j++) {
					flipped[r][k] = spill[i][j];
					k++;
				}
			}
			else {
				for (int j = spill.length-1; j >= 0; j--) {
					flipped[r][k] = spill[i][j];
					k++;
				}
			}
			
			k=0;
			r++;
			
		}//ytre
		
		return flipped;

	}//skrivUt
	
}//class end
