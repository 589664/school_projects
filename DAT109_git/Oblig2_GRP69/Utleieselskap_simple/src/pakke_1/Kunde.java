package pakke_1;

public class Kunde {
	
	private String forN;
	private String etterN;
	private Adresse adresse;
	private Integer tlf;
	
	public Kunde(String forN, String etterN, Adresse adresse, Integer tlf) {
		this.forN = forN;
		this.etterN = etterN;
		this.adresse = adresse;
		this.tlf = tlf;
	}

	public String getForN() {
		return forN;
	}

	public void setForN(String forN) {
		this.forN = forN;
	}

	public String getEtterN() {
		return etterN;
	}

	public void setEtterN(String etterN) {
		this.etterN = etterN;
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

	@Override
	public String toString() {
		return forN + "\n" + etterN + "\n" + tlf + "\n" + adresse.toString();
	}
	
	

}
