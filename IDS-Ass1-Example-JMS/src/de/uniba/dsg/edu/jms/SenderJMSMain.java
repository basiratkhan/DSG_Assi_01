package de.uniba.dsg.edu.jms;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.dsg.edu.jms.sender.QueueSender;

public class SenderJMSMain {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Invalid usage. Three arguments needed: "
					+ "java SenderJMSMain <hostname> <connFactoryName> <queueName>");
		} else {
			try {

				Hashtable<String, String> contextParams = new Hashtable<>();

				// For use with the File System JNDI Service Provider
				contextParams.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
				// TODO adjust this line if you have not set the storage to
				// "file:///C:/TEMP/JndiStorage"
				contextParams.put(Context.PROVIDER_URL, "file:///D:/TEMP/JmsStorage");

				// Create Context for JNDI lookup
				Context ctx = new InitialContext(contextParams);

				// Create QueueSender (see class implementation)
				QueueSender sender = new QueueSender(ctx, args[1], args[2]);

				System.out.println("Sending some message to Queue " + args[1]);

				sender.sendMessage("Hallo Server!");
				sender.sendMessage("I just want to test whether you handle and display all my packets");
				sender.sendMessage("Seems to work...");
				sender.sendMessage("But what about this really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really, really, really, "
						+ "really, really, really, really, really, really, really long message?");

				// If you are courageous uncomment the following lines:

				// System.out.println("Sending an 'evil' message.");
				// sender.sendAnEvilMessage();

				// To clean the Queue select the Queue in the OpenMQ admin
				// interface and select the action "Purge Messages"

				System.out.println("Finished sending.");

			} catch (NamingException e) {
				System.out.println("JNDI Problem. Check used hostname and/or " + "Glassfish configuration.");
				e.printStackTrace();
			}
		}
	}
}
