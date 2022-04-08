package pakke1;

import java.awt.*;

public class Spiller {
	
	private String navn;
	private Color farge;
	private Terning terning;
	private int posisjon;
	private boolean tur;
	
	public Spiller() {
	}
	
	public Spiller(String navn, Color farge, Terning terning, int posisjon, boolean tur) {
		this.navn = navn;
		this.farge = farge;
		this.terning = terning;
		this.posisjon = posisjon;
		this.tur = tur;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Color getFarge() {
		return farge;
	}

	public void setFarge(Color farge) {
		this.farge = farge;
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

	public boolean getTur() {
		return tur;
	}

	public void setTur(boolean tur) {
		this.tur = tur;
	}
	
	
}
