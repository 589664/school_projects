package pakke1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		int antallS = Integer.valueOf(JOptionPane.showInputDialog(null, "Hvor mange spillere ønsker du å simulere\nDu kan velge mellom 2 - 4"));
		
		List<Spiller> spillerL = new ArrayList<Spiller>();
		
		JPanel ballArea = new JPanel();
		
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("src\\\\main\\\\resources\\\\background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(background));
		
		if (antallS == 1) {
			Spiller spiller1 = new Spiller("Spiller1", Color.green, new Terning(0), 1, 1, new Brikke(Color.green, 100, 100));
			picLabel.add(spiller1.getBrikke());
			spiller1.getBrikke().setLocation(10, 700);
			spillerL.add(spiller1);
		}
		if (antallS == 2) {
			Spiller spiller1 = new Spiller("Spiller1", Color.green, new Terning(0), 1, 1, new Brikke(Color.green, 100, 100));
			picLabel.add(spiller1.getBrikke());
			spiller1.getBrikke().setLocation(10, 700);
			spillerL.add(spiller1);
			
			Spiller spiller2 = new Spiller("Spiller2", Color.blue, new Terning(0), 1, 1, new Brikke(Color.blue, 100, 100));
			picLabel.add(spiller2.getBrikke());
			spiller2.getBrikke().setLocation(80, 700);
			spillerL.add(spiller2);
		}
		if (antallS == 3) {
			Spiller spiller1 = new Spiller("Spiller1", Color.green, new Terning(0), 1, 1, new Brikke(Color.green, 100, 100));
			picLabel.add(spiller1.getBrikke());
			spiller1.getBrikke().setLocation(10, 700);
			spillerL.add(spiller1);
			
			Spiller spiller2 = new Spiller("Spiller2", Color.blue, new Terning(0), 1, 1, new Brikke(Color.blue, 100, 100));
			picLabel.add(spiller2.getBrikke());
			spiller2.getBrikke().setLocation(80, 700);
			spillerL.add(spiller2);
			
			Spiller spiller3 = new Spiller("Spiller3", Color.red, new Terning(0), 1, 1, new Brikke(Color.red, 100, 100));
			picLabel.add(spiller3.getBrikke());
			spiller3.getBrikke().setLocation(10, 660);
			spillerL.add(spiller3);
			
		}
		if (antallS == 4) {
			Spiller spiller1 = new Spiller("Spiller1", Color.green, new Terning(0), 1, 1, new Brikke(Color.green, 100, 100));
			picLabel.add(spiller1.getBrikke());
			spiller1.getBrikke().setLocation(10, 700);
			spillerL.add(spiller1);
			
			Spiller spiller2 = new Spiller("Spiller2", Color.blue, new Terning(0), 1, 1, new Brikke(Color.blue, 100, 100));
			picLabel.add(spiller2.getBrikke());
			spiller2.getBrikke().setLocation(80, 700);
			spillerL.add(spiller2);
			
			Spiller spiller3 = new Spiller("Spiller3", Color.red, new Terning(0), 1, 1, new Brikke(Color.red, 100, 100));
			picLabel.add(spiller3.getBrikke());
			spiller3.getBrikke().setLocation(10, 660);
			spillerL.add(spiller3);
			
			Spiller spiller4 = new Spiller("Spiller4", Color.cyan, new Terning(0), 1, 1, new Brikke(Color.cyan, 100, 100));
			picLabel.add(spiller4.getBrikke());
			spiller4.getBrikke().setLocation(80, 660);
			spillerL.add(spiller4);
		}
		
		ballArea.add(picLabel);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1100, 770);
		frame.add(ballArea);
		
		frame.setVisible(true);
		
		
		Rute spillet[][] = new Rute [10][10];
		int x = 10;
		int y = 700;
		int verdi = 1;
		
		for (int i = 0; i < spillet.length; i++) {
			
			if (i % 2 == 0) {	
				for (int j = 0; j < spillet.length; j++) {
					spillet[i][j] = new Rute(verdi,0,x,y);
					if(j != 9){
						x += 108;
					}
					verdi++;
				}//indre1
				
			}//if
			
			else {
				for (int j = spillet.length-1; j >= 0; j--) {
					spillet[i][j] = new Rute(verdi,0,x,y);
					if(j != 0){
						x -= 108;
					}
					verdi++;
				}//indre2
			}//else
			
			
			y-=72;
			
		}//ytre
		
		spillet[1][3].setEgenskap(63);
		spillet[8][1].setEgenskap(5);
		spillet[2][7].setEgenskap(54);
		spillet[7][6].setEgenskap(55);
		spillet[7][8].setEgenskap(93);
		
		int hvemsTur = 1;
		
		while(true) {
		
		for (Spiller spiller : spillerL) {
			
			while (spiller.getPosisjon() < 100 && spiller.getNavn().contains(String.valueOf(hvemsTur))) {
				int terning = spiller.getTerning().trillTerning();
				
				if (spiller.getPosisjon() + terning <= 100) {
					
					spiller.setPosisjon(spiller.getPosisjon() + terning);
					for (int i = 0; i < spillet.length; i++) {
						for (int j = 0; j < spillet[0].length; j++) {
							if (spillet[i][j].getVerdi() == spiller.getPosisjon()) {
								
								if (spillet[i][j].getEgenskap() != 0) {
									
									if (spiller.getNavn().endsWith(String.valueOf(1))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX(), spillet[i][j].getY());
										Thread.sleep(500);
										spiller.getBrikke().setLocation(getPos(spillet[i][j].getEgenskap(), spillet));
										hvemsTur = 2;
									}
									if (spiller.getNavn().endsWith(String.valueOf(2))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX() + 70, spillet[i][j].getY());
										Thread.sleep(500);
										spiller.getBrikke().setLocation((int)getPos(spillet[i][j].getEgenskap(), spillet).getX() + 70, (int) getPos(spillet[i][j].getEgenskap(), spillet).getY());
										hvemsTur = 3;
									}
									if (spiller.getNavn().endsWith(String.valueOf(3))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX(), spillet[i][j].getY() - 40);
										Thread.sleep(500);
										spiller.getBrikke().setLocation((int)getPos(spillet[i][j].getEgenskap(), spillet).getX(), (int) getPos(spillet[i][j].getEgenskap(), spillet).getY() - 40);
										hvemsTur = 4;
									}
									if (spiller.getNavn().endsWith(String.valueOf(4))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX() + 70, spillet[i][j].getY() - 40);
										Thread.sleep(500);
										spiller.getBrikke().setLocation((int)getPos(spillet[i][j].getEgenskap(), spillet).getX() + 70, (int) getPos(spillet[i][j].getEgenskap(), spillet).getY() - 40);
										hvemsTur = 1;
									}
									
									spiller.setPosisjon(spillet[i][j].getEgenskap());
								} else {
									
									if (spiller.getNavn().endsWith(String.valueOf(1))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX(), spillet[i][j].getY());
										hvemsTur = 2;
									}
									if (spiller.getNavn().endsWith(String.valueOf(2))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX() + 70, spillet[i][j].getY());
										hvemsTur = 3;
									}
									if (spiller.getNavn().endsWith(String.valueOf(3))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX(), spillet[i][j].getY() - 40);
										hvemsTur = 4;
									}
									if (spiller.getNavn().endsWith(String.valueOf(4))) {
										spiller.getBrikke().setLocation(spillet[i][j].getX() + 70, spillet[i][j].getY() - 40);
										hvemsTur = 1;
									}
									
								}
							}
						}//indre
					}//ytre
				}//if
				
				Thread.sleep(1000);
			}//while
			
		}
			
		}
	}//main
	
	public static Point getPos(int rute, Rute[][] mat) {
		Point punkt = null;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j].getVerdi() == rute) {
					punkt = new Point(mat[i][j].getX(), mat[i][j].getY());
				}
			}
		}
		
		return punkt;
	}
	
}//class




//System.out.println(spillet[xx][yy].getVerdi());
//System.out.println(spillet[xx][yy].getX());
//System.out.println(spillet[xx][yy].getY());
