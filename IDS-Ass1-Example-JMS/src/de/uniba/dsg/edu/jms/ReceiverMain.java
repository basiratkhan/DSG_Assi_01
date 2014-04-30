package de.uniba.dsg.edu.jms;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.dsg.edu.jms.receiver.QueueReceiver;

public class ReceiverMain {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out
					.println("Invalid usage. Two argument needed: java ServerMain *connFactoryName* *queueName*");
		} else {
			try {
				Context ctx = new InitialContext();
				QueueReceiver server = new QueueReceiver(ctx, args[0], args[1]);
				server.start();

				Scanner scanner = new Scanner(System.in);
				System.out.println("Hit Enter to stop the server.");
				scanner.nextLine();
				scanner.close();
				server.stopServer();
			} catch (NamingException e) {
				System.out.println("JNDI Problem. Check used hostname and/or "
						+ "Glassfish configuration.");
			}
		}
	}
}
