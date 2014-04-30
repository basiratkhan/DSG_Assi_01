package de.uniba.dsg.edu.jms;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.dsg.edu.jms.receiver.QueueReceiver;

public class ReceiverJMSMain {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out
					.println("Invalid usage. Three arguments needed: "
							+ "java ReceiverJMSMain <hostname> <connFactoryName> <queueName>");
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

				// Create QueueReceiver (see class implementation)
				QueueReceiver server = new QueueReceiver(ctx, args[1], args[2]);
				// as QueueReceiver extends Thread, the Thread should be started
				server.start();
				
				// Wait for Input to shutdown the Server properly
				Scanner scanner = new Scanner(System.in);
				System.out.println("Hit Enter to stop the server.");
				scanner.nextLine();
				scanner.close();
				server.stopServer();
			} catch (NamingException e) {
				System.out.println("JNDI Problem. Check used hostname and/or "
						+ "Glassfish configuration.");
				e.printStackTrace();
			}
		}
	}
}
