package pakke1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "utleieselskap")
public class Kunde {
	
	@Id
	private Integer tlf;
	
	private String forN;
	private String etterN;
	private String adresse;

	public Kunde() {
	}

	public Kunde(Integer tlf, String forN, String etterN, String adresse) {
		this.tlf = tlf;
		this.forN = forN;
		this.etterN = etterN;
		this.adresse = adresse;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}//class
