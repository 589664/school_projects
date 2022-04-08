package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		if (data.equals(null) || data.length > 127) {
			throw new UnsupportedOperationException(TODO.constructor("Data er null eller over 127 bytes"));
		}
			
		else {
			this.data = data;
		}
		
	}//constructor

	public byte[] getData() {
		return this.data; 
	}

}
