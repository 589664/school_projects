package no.hvl.dat110.broker.multithread_and_buffer;

import no.hvl.dat110.common.Logger;

public class BrokerServer extends Thread {

	private static int BROKER_DEFAULTPORT = 8080;
	
	public static void main(String[] args) {
		
		int port = BROKER_DEFAULTPORT;
		
		if (args != null) {
			if (args.length > 0) {
				port = Integer.parseInt(args[0]);
			}
		}
			
		Logger.log("Broker server : " + port);
		
		Storage storage = new Storage();
		BrokerThread broker = new BrokerThread(storage,port);
		
		// start broker threads
		broker.start();
		
		Logger.log("Broker server stopping ... ");
		
	}

}
