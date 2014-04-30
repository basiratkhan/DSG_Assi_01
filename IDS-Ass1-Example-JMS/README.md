Example Project for JMS Usage
=================================
This small example shows the steps needed to exchange data using JMS Message Queues.


Prerequisites
-------------
A Glassfish Application Server must be installed on each system as some - or even: a 
whole bunch of - libraries are needed which are shipped with Glassfish.
To avoid adding all these (~60mb) of libs to the project and the repository they 
need to be referenced locally.
Eclipse and the Project Settings are preconfigured in the DSG lab - but in order to 
execute the project in your own environment, you have to add an "Class Path Variable"
to your eclipse installation:
	- Open the Preferences: Window -> Preferences
	- Navigate to Java -> Build Path -> Classpath Variables
	- Add a Variable named ```GF_HOME``` which points to the Folder where your Glassfish
	  installation can be found (i.e., "D:/servers/glassfish" in the lab).
	- Accept all dialogs.

Configuration of the application server
-----------------------------------------
The Message should be stored in a Queue running in conjunction with the Glassfish Application server.
So first, on one host machine the Glassfish server must be started and configured properly.

In the lab you can just, run the script:

startUpAndConfigureGlassfish.bat

In this script the following steps are performed:
	- The server is startup by the command "asadmin start-domain"
	- The JMS provider is configured: The property ```JMS_DEFAULT_HOST``` is changed to 
	  the hostname of the system in order to enable remote access. (Note: This step
	  can be omitted if all parts of this example will be run on the same machine)
	- A JMS QueueConnectionFactory called ```jms/IdsExampleConnectionFactory``` is created.
	- A JMS Queue called ```jms/IdsExampleQueue``` is created

Filling the Queue
-----------------
Run de.uniba.dsg.edu.jms.SenderJMSMain with the following arguments (-> Use Eclipse 
Run Configurations!):
```
		args[0] - <hostname>
		args[1] - <connFactoryName>
		args[2] - <queueName>
```
So, if you want to fill the demo queue running on your local machine:

	```java SenderJMSMain localhost jms/IdsExampleConnectionFactory jms/IdsExampleQueue```

Receiving Messages
-------------------
Run de.uniba.dsg.edu.jms.ReceiverJMSMain with the following arguments (-> Use Eclipse 
Run Configurations!):
```
		args[0] - <hostname>
		args[1] - <connFactoryName>
		args[2] - <queueName>
```
So, if you want to fill the demo queue running on your local machine:

	```java ReceiverJMSMain localhost jms/IdsExampleConnectionFactory jms/IdsExampleQueue```

