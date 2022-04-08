package spiller;

/**
 * klasse som oppretter spiller
 * @author Maksim
 */
public class Spiller {
	
	private String navn;
	private Terning terning;
	private int posisjon;
	private Brikke brikke;
	private boolean laast;
	
	public Spiller() {
	}
	
	/**
	 * 
	 * @param navn
	 * @param terning
	 * @param posisjon
	 * @param brikke
	 * @param laast
	 */
	public Spiller(String navn, Terning terning, int posisjon, Brikke brikke, boolean laast) {
		this.navn = navn;
		this.terning = terning;
		this.posisjon = posisjon;
		this.brikke = brikke;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Terning getTerning() {
		return terning;
	}

	public void setTerning(Terning terning) {
		this.terning = terning;
	}

	public int getPosisjon() {
		return posisjon;
	}

	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}

	public boolean isLaast() {
		return laast;
	}

	public void setLaast(boolean laast) {
		this.laast = laast;
	}
	
	
	
}
