package no.hvl.dat110.broker.multithread_and_buffer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;
	
	//maps user to a set of messages that is written while user is offline
	protected ConcurrentHashMap<String, Set<Message>> msgOffline;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		msgOffline = new ConcurrentHashMap<String, Set<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}
	
	//messege offline methods:
	
	public Set<Message> getMsgOffline(String user) {
		return (msgOffline.get(user));
	}
	
	public void addMsgOffline(String user, Message msg) {
		getMsgOffline(user).add(msg);
	}
	
	public void createMsgSet(String user) {
		msgOffline.put(user, new HashSet<Message>());
	}
	
	public void removeMsgSet(String user) {
		msgOffline.remove(user);
	}
	
	//rest:

	public void addClientSession(String user, Connection connection) {

		// TODO: add corresponding client session to the storage
		
		clients.put(user, new ClientSession(user, connection));
		
	}

	public void removeClientSession(String user) {

		// TODO: remove client session for user from the storage

		clients.remove(user);
		
	}

	public void createTopic(String topic) {

		// TODO: create topic in the storage

//		Set<String> set = new HashSet<String>(getTopics());
//		
//		set.add(topic);
		
		subscriptions.put(topic, new HashSet<String>());
	
	}

	public void deleteTopic(String topic) {

		// TODO: delete topic from the storage

		subscriptions.remove(topic);
		
	}

	public void addSubscriber(String user, String topic) {

		// TODO: add the user as subscriber to the topic
		
//		Set<String> set = new HashSet<String>(getSubscribers(topic));
//		
//		set.add(user);
//		
//		subscriptions.put(topic, set);
		
		getSubscribers(topic).add(user);
		
	}

	public void removeSubscriber(String user, String topic) {

		// TODO: remove the user as subscriber to the topic

		getSubscribers(topic).remove(user);
	}
}
