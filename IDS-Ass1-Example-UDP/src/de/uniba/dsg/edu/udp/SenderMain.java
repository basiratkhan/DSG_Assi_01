package de.uniba.dsg.edu.udp;

import de.uniba.dsg.edu.udp.sender.UdpSender;

public class SenderMain {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out
					.println("Invalid usage. Two arguments needed: java SenderMain *hostname* *port*");
		} else {
			try {
				int port = Integer.parseInt(args[1]);
				UdpSender sender = new UdpSender(args[0], port);
				System.out.println("Sending Messages to "+args[0]+":"+port+":");
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
			} catch (NumberFormatException e) {
				System.out.println("Portnumber is invalid");
			}
		}
	}
}
