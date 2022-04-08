package pakke_1;

public class Selskap {
	
	private String navn;
	private Integer tlf;
	private Adresse adresse;
	
	public Selskap(String navn, Integer tlf, Adresse adresse) {
		this.navn = navn;
		this.tlf = tlf;
		this.adresse = adresse;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
