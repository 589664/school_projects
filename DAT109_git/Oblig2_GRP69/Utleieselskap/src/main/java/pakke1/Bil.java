package pakke1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "utleieselskap")
public class Bil {
	
	@Id
	private String regnr;
	
	private String modell;
	private String farge;
	private char kategori;
	
	private Integer kontorNR;
	
	public Bil() {
	}

	public Bil(String regnr, String modell, String farge, char kategori, Integer kontorNR) {
		this.regnr = regnr;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
		this.kontorNR = kontorNR;
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

	public char getKategori() {
		return kategori;
	}

	public void setKategori(char kategori) {
		this.kategori = kategori;
	}

	public Integer getKontorNR() {
		return kontorNR;
	}

	public void setKontorNR(Integer kontorNR) {
		this.kontorNR = kontorNR;
	}
	
}
