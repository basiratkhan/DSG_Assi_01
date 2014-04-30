package de.uniba.dsg.edu.udp.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class UdpSender {
	
	private int port;
	private String hostname;
	
	public UdpSender(String hostname, int port) {
		this.port = port;
		this.hostname = hostname;
	}
	
	public void sendMessage(String msg) {
		System.out.println("\t [Sender]: Trying to send message '"+msg+"'");
		// try-with-resources - automatically closes the socket sock
		try (DatagramSocket sock = new DatagramSocket(null)) {
			// create address of recipient
			SocketAddress serverAddress = new InetSocketAddress(hostname, port);

			// create packet
			byte[] messageData = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(messageData,
					messageData.length, serverAddress);

			// send packet
			sock.send(packet);
		} catch (IOException e) {
			// dummy exception handling
			e.printStackTrace();
		}

	}

}
