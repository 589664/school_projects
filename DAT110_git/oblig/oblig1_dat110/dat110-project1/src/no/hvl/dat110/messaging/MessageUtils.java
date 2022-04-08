package no.hvl.dat110.messaging;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer
		
		//data som ska vera med
		data = message.getData();
		
		//foerste byte lengde
		Integer a = data.length;
		
		//legger size i foerste index
		byte len = a.byteValue();
		segment = new byte [SEGMENTSIZE];
		segment[0] = len;
		
		for (int i = 0; i < data.length; i++) {
			segment[i+1] = data[i];
		}
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		byte[] data;
		
		int len = segment[0];
		
		data = new byte[len];
		
		for (int i = 0; i < len; i++) {
			data[i] = segment[i+1];
		}
		
		message = new Message(data);
		
		return message;
		
	}
	
}
