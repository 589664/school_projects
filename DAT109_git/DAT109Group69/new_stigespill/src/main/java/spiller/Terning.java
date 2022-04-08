package spiller;

/**
 * klasse som oppretter terning med utgangspunkt verdi
 * @author Maksim
 */
public class Terning {
	
	private int verdi;
	
	/**
	 * 
	 * @param verdi
	 * konstruktør
	 */
	public Terning(int verdi) {
		this.verdi = verdi;
	}
	
	/**
	 * metode som generer random verdi fra 1 - 6 og setter terning til det
	 * @return
	 * @throws InterruptedException
	 */
	public int trillTerning() throws InterruptedException {
		Thread.sleep(1000);
		return (int)(Math.random()*6+1);
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	
}
