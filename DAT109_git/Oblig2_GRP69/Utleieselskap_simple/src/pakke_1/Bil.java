package pakke_1;

public class Bil {
	
	private String regnr;
	private String modell;
	private String farge;
	private String kategori;
	
	public Bil() {
	}

	public Bil(String regnr, String modell, String farge, String kategori) {
		this.regnr = regnr;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
}
