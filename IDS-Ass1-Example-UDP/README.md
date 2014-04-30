Example Project for UDP Sockets
=================================
This small example shows the steps needed to exchange data using UDP Sockets.

Starting the server
-------------------
First, the server must be started in order to be able to receive any data.

To start the server, run de.uniba.dsg.edu.udp.ServerMain. As the ```main()```-
Method expects one argument, namely the port number to be used to bind the 
socket, use the Eclipse Run Configurations or provide the argument when 
calling the class from the command line.

Example call: 

	```java de.uniba.dsg.edu.udp.ServerMain 12345```


Starting the Sender
-------------------
To start sending Messages run de.uniba.dsg.edu.udp.SenderMain with two arguments (-> Use Eclipse 
Run Configurations!):
```
		args[0] - <hostname>
		args[1] - <port>
```

The sender can be started on the same or another machine in the network.

Example calls:

	```java de.uniba.dsg.edu.udp.SenderMain localhost 12345```

or

	```java de.uniba.dsg.edu.udp.SenderMain 141.13.4.102 12345```

