package pakke_1;

public class Kontor {
	
	private Integer nr;
	private Adresse adresse;
	private Integer tlf;
	
	public Kontor(Integer nr, Adresse adresse, Integer tlf) {
		this.nr = nr;
		this.adresse = adresse;
		this.tlf = tlf;
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

	
}
