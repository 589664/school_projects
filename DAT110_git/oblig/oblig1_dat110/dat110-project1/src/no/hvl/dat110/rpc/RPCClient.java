package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessagingClient;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection c;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		// connect using the underlying messaging layer connection
		c = msgclient.connect();
	}
	
	public void disconnect() {
		// disconnect/close the underlying messaging connection
		c.close();
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval = null;
		/** 
		Make a remote call on the RPC server by sending an RPC request message
		and receive an RPC reply message
		
		params is the marshalled parameters from the client-stub
				
		The rpcid, params, and return value must be encapsulated/decapsulated
		according to the RPC message format
		*/
		c.send(new Message(RPCUtils.encapsulate(rpcid, params)));
		returnval = RPCUtils.decapsulate(c.receive().getData());
		
		return returnval;
		
	}

}
