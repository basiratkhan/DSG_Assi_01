package de.uniba.dsg.edu.jms;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.dsg.edu.jms.sender.QueueSender;

public class SenderMainBak {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out
					.println("Invalid usage. Two arguments needed: java SenderMain *connFactoryName* *queueName*");
		} else {
			try {
				Context ctx = new InitialContext();
				QueueSender sender = new QueueSender(ctx, args[0], args[1]);
				System.out.println("Sending some message to Queue "+args[1]);
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

			} catch (NamingException e) {
				System.out
						.println("JNDI Naming exception, check jndi.properties file and message broker configuration!");
				e.printStackTrace();
			}
		}
	}
}
