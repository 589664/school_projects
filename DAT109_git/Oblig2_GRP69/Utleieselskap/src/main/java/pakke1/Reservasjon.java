package pakke1;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "utleieselskap")
public class Reservasjon {

	@Id
	private Integer id;
	
	private LocalDateTime datofra;
	private LocalDateTime datotil;
	private Float kredittkort;
	private String regnr;
	
	public Reservasjon() {
	}

	public Reservasjon(Integer id, LocalDateTime datofra, LocalDateTime datotil, Float kredittkort, String regnr) {
		this.id = id;
		this.datofra = datofra;
		this.datotil = datotil;
		this.kredittkort = kredittkort;
		this.regnr = regnr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDatofra() {
		return datofra;
	}

	public void setDatofra(LocalDateTime datofra) {
		this.datofra = datofra;
	}

	public LocalDateTime getDatotil() {
		return datotil;
	}

	public void setDatotil(LocalDateTime datotil) {
		this.datotil = datotil;
	}

	public Float getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(Float kredittkort) {
		this.kredittkort = kredittkort;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}
	
}
