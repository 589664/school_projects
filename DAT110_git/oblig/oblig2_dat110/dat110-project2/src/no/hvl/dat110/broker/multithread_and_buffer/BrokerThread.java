package no.hvl.dat110.broker.multithread_and_buffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.hvl.dat110.broker.Broker;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.MessageType;
import no.hvl.dat110.messages.MessageUtils;
import no.hvl.dat110.messagetransport.Connection;

public class BrokerThread extends Broker { 
	
	private Storage str;

	public BrokerThread (Storage str,int port) {
		super(null, port);
		this.str = str;
	}
	
	@Override
	protected void waitConnect(Connection connection) {
				
		Message msg = MessageUtils.receive(connection);
		
		if (msg.getType() == MessageType.CONNECT) {
			
			Logger.log("onConnect:" + msg.toString());
			
			String user = msg.getUser();
			//get user add to storage
			str.addClientSession(user, connection);
			
			if (str.getMsgOffline(user) != null) {
				
				List<Message> revs = new ArrayList<>(str.getMsgOffline(user));
				
				Collections.reverse(revs);
				
				revs.forEach(x -> str.getSession(user).send(x));

				str.removeMsgSet(user);
			}
			
			//creating new dispatcher whenever waitConnect() is called
			//storrage and session from storage (storage is shared between dispatcher threads)
			new DispatcherThread(str, str.getSession(user)).start();
			
		} else {
			System.out.println("Protocol error: first message should be connect");
		}
	}
	
}
