package de.uniba.dsg.edu.udp;

import java.util.Scanner;

import de.uniba.dsg.edu.udp.server.UdpServer;

public class ServerMain {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out
					.println("Invalid usage. One argument needed: java ServerMain <port>");
		} else {
			try {
				int port = Integer.parseInt(args[0]);

				// Create UdpServer
				UdpServer server = new UdpServer(port);
				// Start the thread
				server.start();

				// And wait for input
				Scanner scanner = new Scanner(System.in);
				System.out.println("Hit Enter to stop the server.");
				scanner.nextLine();
				scanner.close();

				// Shut down the server
				server.stopServer();
			} catch (NumberFormatException e) {
				System.out.println("Portnumber is invalid");
			}
		}
	}
}
