package no.hvl.dat110.broker.multithread_and_buffer;

import no.hvl.dat110.common.Logger;
import no.hvl.dat110.common.Stopable;
import no.hvl.dat110.messages.CreateTopicMsg;
import no.hvl.dat110.messages.DeleteTopicMsg;
import no.hvl.dat110.messages.DisconnectMsg;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.MessageType;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.messages.SubscribeMsg;
import no.hvl.dat110.messages.UnsubscribeMsg;

public class DispatcherThread extends Stopable {

	private Storage str;
	private ClientSession ses;

	public DispatcherThread(Storage storage, ClientSession session) {
		super("Dispatcher");
		this.str = storage;
		this.ses = session;
	}

	@Override
	public void doProcess() {

		Logger.lg(".");
		
		Message msg = null;
		
		msg = ses.receive();
		
		if (msg != null) {
			dispatch(msg);
		}
	}

	public void dispatch(Message msg) {

		MessageType type = msg.getType();

		// invoke the appropriate handler method
		switch (type) {

		case DISCONNECT:
			onDisconnect((DisconnectMsg) msg);
			break;

		case CREATETOPIC:
			onCreateTopic((CreateTopicMsg) msg);
			break;

		case DELETETOPIC:
			onDeleteTopic((DeleteTopicMsg) msg);
			break;

		case SUBSCRIBE:
			onSubscribe((SubscribeMsg) msg);
			break;

		case UNSUBSCRIBE:
			onUnsubscribe((UnsubscribeMsg) msg);
			break;

		case PUBLISH:
			onPublish((PublishMsg) msg);
			break;

		default:
			Logger.log("broker dispatch - unhandled message type");
			break;

		}
	}

	// called by dispatch upon receiving a disconnect message
	public void onDisconnect(DisconnectMsg msg) {

		String user = msg.getUser();

		Logger.log("onDisconnect:" + msg.toString());

		str.removeClientSession(user);
		
		//stop thread for session
		this.doStop();

	}

	public void onCreateTopic(CreateTopicMsg msg) {

		Logger.log("onCreateTopic:" + msg.toString());

		// create the topic in the broker storage
		// the topic is contained in the create topic message

		str.createTopic(msg.getTopic());

	}

	public void onDeleteTopic(DeleteTopicMsg msg) {

		Logger.log("onDeleteTopic:" + msg.toString());

		// delete the topic from the broker storage
		// the topic is contained in the delete topic message
		
		str.deleteTopic(msg.getTopic());
	}

	public void onSubscribe(SubscribeMsg msg) {

		Logger.log("onSubscribe:" + msg.toString());

		// subscribe user to the topic
		// user and topic is contained in the subscribe message
		
		str.addSubscriber(msg.getUser(), msg.getTopic());
	}

	public void onUnsubscribe(UnsubscribeMsg msg) {

		Logger.log("onUnsubscribe:" + msg.toString());

		// unsubscribe user to the topic
		// user and topic is contained in the unsubscribe message
		
		str.removeSubscriber(msg.getUser(), msg.getTopic());
	}

	public void onPublish(PublishMsg msg) {

		Logger.log("onPublish:" + msg.toString());

		// publish the message to clients subscribed to the topic
		// topic and message is contained in the subscribe message
		// messages must be sent used the corresponding client session objects
		
		str.getSubscribers(msg.getTopic()).forEach(x -> 
		{
			ClientSession ses = str.getSession(x);
			if (ses != null) {
				ses.send(msg);
			} else {
				if (str.getMsgOffline(x) == null) {
					str.createMsgSet(x);
				} 
				str.addMsgOffline(x, msg);
			}
		});

	}//onPublish end
}
