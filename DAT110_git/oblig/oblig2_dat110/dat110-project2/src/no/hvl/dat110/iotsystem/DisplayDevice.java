package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
	public static String TOPIC = "temperature";
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
				
		// create a client object and use it to
		
		// - connect to the broker
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		Client disp = new Client("display","localhost",8080);
		
		disp.connect();
		disp.createTopic(TOPIC);
		disp.subscribe(TOPIC);
		
		for (int i = 0; i < COUNT; i++) {
			disp.receive();
		}
		
		disp.unsubscribe(TOPIC);
		disp.disconnect();
		
		System.out.println("Display stopping ... ");
		
	}
}
