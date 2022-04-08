package pakke1;

public class Rute {
	
	private int verdi;
	private int egenskap;
	private int x;
	private int y;
	
	public Rute(int verdi, int egenskap, int x, int y) {
		this.verdi = verdi;
		this.egenskap = egenskap;
		this.x = x;
		this.y = y;
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}

	public int getEgenskap() {
		return egenskap;
	}

	public void setEgenskap(int egenskap) {
		this.egenskap = egenskap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
