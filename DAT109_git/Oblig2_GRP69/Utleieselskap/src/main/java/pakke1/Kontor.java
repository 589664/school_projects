package pakke1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "utleieselskap")
public class Kontor {
	
	@Id
	private Integer kontorNR;
	
	private Integer tlf;
	private String adresse;
	private Integer selskapID;
	
	public Kontor() {
	}

	public Kontor(Integer kontornr, Integer tlf, String adresse, Integer selskapsid) {
		this.kontorNR = kontornr;
		this.tlf = tlf;
		this.adresse = adresse;
		this.selskapID = selskapsid;
	}

	public Integer getKontornr() {
		return kontorNR;
	}

	public void setKontornr(Integer kontornr) {
		this.kontorNR = kontornr;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getSelskapsid() {
		return selskapID;
	}

	public void setSelskapsid(Integer selskapsid) {
		this.selskapID = selskapsid;
	}

}
