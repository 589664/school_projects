package pakke1;

import java.awt.*;

public class Spiller {
	
	private String navn;
	private Color farge;
	private Terning terning;
	private int posisjon;
	private int tur;
	private Brikke brikke;
	
	public Spiller() {
	}
	
	public Spiller(String navn, Color farge, Terning terning, int posisjon, int tur, Brikke brikke) {
		this.navn = navn;
		this.farge = farge;
		this.terning = terning;
		this.posisjon = posisjon;
		this.tur = tur;
		this.brikke = brikke;
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

	public int getTur() {
		return tur;
	}

	public void setTur(int tur) {
		this.tur = tur;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
	
}
