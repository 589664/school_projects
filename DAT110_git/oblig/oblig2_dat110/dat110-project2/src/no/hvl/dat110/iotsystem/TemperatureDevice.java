package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;
	public static String TOPIC = "temperature";

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();


		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker
		
		Client sens = new Client("sensor","localhost",8080);

		sens.connect();
		
		for (int i = 0; i < COUNT; i++) {
			sens.publish(TOPIC, String.valueOf(sn.read()));
		}
		
		sens.disconnect();

		System.out.println("Temperature device stopping ... ");

	}
}
