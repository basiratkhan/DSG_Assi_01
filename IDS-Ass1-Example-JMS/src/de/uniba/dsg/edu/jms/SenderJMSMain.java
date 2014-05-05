package de.uniba.dsg.edu.jms;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.dsg.edu.jms.sender.QueueSender;

public class SenderJMSMain {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out
					.println("Invalid usage. Three arguments needed: "
							+ "java SenderJMSMain <hostname> <connFactoryName> <queueName>");
		} else {
			try {

				// Set the host to be used for JNDI lookups - properties will be
				// read by new InitialContext()
				System.setProperty("org.omg.CORBA.ORBInitialHost", args[0]);
				// Port is by default 3700 (if you have not changed Glassfish
				// Config)
				System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

				// Create Context for JNDI lookup
				Context ctx = new InitialContext();

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

				// to 'fix' the queue run the console command:
				// asadmin flush-jmsdest --desttype queue IdsExampleQueue

				System.out.println("Finished sending.");

			} catch (NamingException e) {
				System.out.println("JNDI Problem. Check used hostname and/or "
						+ "Glassfish configuration.");
				e.printStackTrace();
			}
		}
	}
}
