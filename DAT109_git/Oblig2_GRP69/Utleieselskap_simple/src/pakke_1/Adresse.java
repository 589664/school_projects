package pakke_1;

public class Adresse {
	
	private String gate;
	private Integer postnr;
	private String postS;
	
	public Adresse(String gate, Integer postnr, String postS) {
		this.gate = gate;
		this.postnr = postnr;
		this.postS = postS;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public Integer getPostnr() {
		return postnr;
	}

	public void setPostnr(Integer postnr) {
		this.postnr = postnr;
	}

	public String getPostS() {
		return postS;
	}

	public void setPostS(String postS) {
		this.postS = postS;
	}

	@Override
	public String toString() {
		return gate + "\n" + postnr + "\n" + postS + "\n";
	}
	
	

}
