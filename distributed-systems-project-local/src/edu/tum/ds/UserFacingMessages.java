package edu.tum.ds;

/**
 * @author Amjad 
 * The class contains all the user facing strings of the application.
 */
public class UserFacingMessages {

	
	public static final String ECHO_PROMPT = "EchoClient> ";
	
	public static final String SPLIT_ON = "\\s+";
	
	public static final String HELP_TEXT = "EchoClient:  The first phase of distributed systems[IN 2259] course project."
			+ "\nUsage:"
			+ "\nConnect <address> <port>: Tries to establish a TCP- connection to the echo server based on the given server address and the port number of the echo service.\n"
			+ "address: Hostname or IP address of the echo server.\nport: The port of the echo service on the respective server.\n"
			+ " Example: connect 192.168.50.1 50000 \n"
			+ "disconnect: Tries to disconnect from the connected server."
			+ "\nsend <message>: Sends a text message to the echo server according to the communication protocol."
			+ "\nmessage: Sequence of ASCII coded characters that correspond to the application specific protocol."
			+ "\nlogLevel <level>: Sets the logger to the specified log level."
			+ "\nlevel: One of the following log4j log levels: (ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF)."
			+ "\nHelp: Prints the help and usage tips."
			+ "\nquit: Tears down the active connection to the server and exits the program execution.";
	
	public static final String GENERAL_ILLIGAL_ARGUMENT = "Please enter a valid command. \n"+ HELP_TEXT;
	
	public static final String ILLIGAL_PARAM_NUMBER = "The number of the command parameters is not as expected, Please use the help command to see an example.";
	
	public static final String ILLIGAL_PARAM = " is not as expected, Please use the help command to see an example.";
	
	public static final String ILLIGAL_PARAM_PORT = "Port number in invalid, Please use the help command to see an example.";
	
	public static final String UN_SUPPORTED_COMMAND = "Unknown command.\n"+ HELP_TEXT;
	
}
