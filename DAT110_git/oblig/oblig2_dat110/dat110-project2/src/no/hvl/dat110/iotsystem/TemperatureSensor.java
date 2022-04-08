package no.hvl.dat110.iotsystem;

public class TemperatureSensor {

	private static final int RANGE = 20;

	public int read() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long seconds = System.currentTimeMillis();

		double temp = RANGE * Math.sin(seconds / 1000);

		return (int) Math.ceil(temp);
	}
}
