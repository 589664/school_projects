package brett;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import gui.Background;
import spiller.Brikke;
import spiller.Spiller;
import spiller.Terning;

/**
 * klasse som oppretter brettet og setter igong spillet
 * @author Maksim
 */
public class Brett {
	
	private int antallS;
	private Rute spillet[][];
	private List<Spiller> spillerL;
	private Background bakgrunn;
	
	/**
	 * 
	 * @param antallS -> antallspillere
	 * @throws InterruptedException
	 */
	public Brett(int antallS) throws InterruptedException {
		this.antallS = antallS;
		
		spillet = new Rute [10][10];
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
		
		//setter egenskaper
		spillet[1][3].setEgenskap(63);
		spillet[8][1].setEgenskap(5);
		spillet[2][7].setEgenskap(54);
		spillet[7][6].setEgenskap(55);
		spillet[7][8].setEgenskap(93);
	}
	
	/**
	 * lager matrise med ruter som har koordinater x og y og visse egenskaper for
	 * stige og slange
	 * @param antallS
	 * @throws InterruptedException
	 */
	public void spill(int antallS) throws InterruptedException{
		
		spillerL = new ArrayList<Spiller>();
		List<Color> farger = Arrays.asList(
				Color.green,
				Color.cyan,
				Color.magenta,
				Color.pink
				);
		
		bakgrunn = new Background();
		
		int padding = 0;
		
		for (int i = 0; i < antallS; i++) {
			
			Brikke brikke = new Brikke(farger.get(i), 20, 20, 0);
			
			if (i == 0) {
				brikke.setLocation(10, 700);
				bakgrunn.getPicLabel().add(brikke);
			}
			
			else {
				bakgrunn.getPicLabel().add(brikke);
				brikke.setLocation(10 + padding, 700);
				brikke.setPadding(padding);
			}
			
			spillerL.add(new Spiller("Spiller" + i, new Terning(1), 1, brikke, false));
			padding += 25;
		}
		
		boolean ferdig = false;
		int antall6 = 0;
		int terning = 0;
		
		while (!ferdig) {
			
			for (Spiller spiller : spillerL) {
				
				do {
					if (antall6 == 3) {
						spiller.setLaast(true);
						spiller.setPosisjon(1);
						setPos(1, spiller);
						terning = 0;
					}
					else {
						terning = spiller.getTerning().trillTerning();
						
						if (spiller.isLaast() && terning == 6) {
							spiller.setLaast(false);
						}
						
						if (spiller.getPosisjon() + terning <= 100 && !spiller.isLaast()) {
							if (spiller.getPosisjon() + terning == 100) {
								ferdig = true;
								spiller.setPosisjon(spiller.getPosisjon() + terning);
								setPos(spiller.getPosisjon(), spiller);
								JOptionPane.showMessageDialog(null, spiller.getNavn() + " har vunnet!");
							} 
							else {
								spiller.setPosisjon(spiller.getPosisjon() + terning);
								setPos(spiller.getPosisjon(), spiller);
							}
							antall6++;
						}
					}
					
				} while (terning == 6 && !ferdig);
				
				//resette terning
				terning = 0;
				
				antall6 = 0;
				
			}//for each end
			
		}//while end
		
	}//spill end
	
	/**
	 * gitt spiller og rute flytter det spiller sin brikke til gitt rute
	 * @param rute
	 * @param spiller
	 * @throws InterruptedException
	 */
	public void setPos(int rute, Spiller spiller) throws InterruptedException {
		
		for (int i = 0; i < spillet.length; i++) {
			for (int j = 0; j < spillet.length; j++) {
				if (spillet[i][j].getVerdi() == rute) {
					if (spillet[i][j].getEgenskap() != 0) {
						spiller.getBrikke().setLocation(spillet[i][j].getX() + spiller.getBrikke().getPadding(), spillet[i][j].getY());
						Thread.sleep(600);
						setPos(spillet[i][j].getEgenskap(), spiller);
						spiller.setPosisjon(spillet[i][j].getEgenskap());
					} 
					else {
						spiller.getBrikke().setLocation(spillet[i][j].getX() + spiller.getBrikke().getPadding(), spillet[i][j].getY());
					}
				}
			}
		}
	}//setPos end
	
	public int getAntallS() {
		return antallS;
	}

	public void setAntallS(int antallS) {
		this.antallS = antallS;
	}

}
