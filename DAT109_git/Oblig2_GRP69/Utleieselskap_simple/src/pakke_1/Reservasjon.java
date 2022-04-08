package pakke_1;

import java.time.LocalDateTime;

public class Reservasjon {
	
	private LocalDateTime datoF;
	private LocalDateTime datoT;
	private Long kredittkort;
	private String regnr;
	
	public Reservasjon(LocalDateTime datoF, LocalDateTime datoT, Long kredittkort, String regnr) {
		this.datoF = datoF;
		this.datoT = datoT;
		this.kredittkort = kredittkort;
		this.regnr = regnr;
	}

	public LocalDateTime getDatoF() {
		return datoF;
	}

	public void setDatoF(LocalDateTime datoF) {
		this.datoF = datoF;
	}

	public LocalDateTime getDatoT() {
		return datoT;
	}

	public void setDatoT(LocalDateTime datoT) {
		this.datoT = datoT;
	}

	public Long getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(Long kredittkort) {
		this.kredittkort = kredittkort;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	@Override
	public String toString() {
		return regnr + "\n" + datoF + "\n" + datoT + "\n" + kredittkort + "\n";
	}


}
