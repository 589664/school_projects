package pakke1;

class Terning {
	
	private int verdi;

	public Terning(int verdi) {
		this.verdi = verdi;
	}
	
	public int trillTerning() {
		return (int)(Math.random()*6+1);
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	
}
