package edu.tum.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import edu.tum.ds.client.ClientConnection;
import edu.tum.ds.client.Connectable;

public class EchoClientApplication {

	private Connectable connection;
	
	
	public EchoClientApplication() {
		this.connection = new ClientConnection();
	}

	/**
	 *  The main function is to start application
	 * that interacts with the user within the defined protocol.
	 * 
	 * @param args
	 *            : Args passed on startup are ignored.
	 */
	public void startApplication() {
		Logger logger = LoggingManager.CreateLogger(EchoClientApplication.class);
		
		// initialize buffer reader to read user input.
		BufferedReader cons = new BufferedReader(new InputStreamReader(
				System.in));
		logger.debug("Input Stream Reader created");
		// the flag to stop shell interaction
		boolean quit = false;
		while (!quit) {
			System.out.print(UserFacingMessages.ECHO_PROMPT);
			String input;
			String[] tokens;
			try {
				input = cons.readLine();
				tokens = input.trim().split(UserFacingMessages.SPLIT_ON);
				// user input was split as tokens.
				// safety check
				if (tokens == null || tokens.length == 0) {
					throw new IllegalArgumentException(
							UserFacingMessages.GENERAL_ILLIGAL_ARGUMENT);
				}

				// start parsing the tokens
				EchoClientCommand command = EchoClientCommand
						.fromString(tokens[0]);
				ValidationUtil validationUtil = ValidationUtil.getInstance();
				switch (command) {
				case CONNECT:
					if (validationUtil.isValidConnectionParams(tokens)) {
						connection.connect(tokens[1], Integer.parseInt(tokens[2]));						
						logger.info( new String (connection.receive()));
					}
					break;
				case DISCONNECT:		
					connection.disconnect();
					logger.info("Connection closed.");
					break;
				case SEND:
					if (validationUtil.isValidMessage(tokens)) {

						connection.send(input.trim().substring(4).concat("\n").getBytes());	
						connection.send(UserFacingMessages.END_OF_MESSAGE);
						logger.info("Message sent to echo server: '"+ input.trim().substring(4)+"'.");						
						logger.info("Message received from echo server: '"+ connection.receive() +"'.");						
					}
					break;
				case LOG_LEVEL:
					if (validationUtil.isValidLogLevel(tokens)) {
						LoggingManager.SetLoggerLevel(tokens[1]);
						logger.info("Log Level Set to"+ tokens[1]);
					}
					break;
				case HELP:
					System.out.println(UserFacingMessages.HELP_TEXT);
					logger.info("Help Text provided to user.");
					break;

				case UN_SUPPORTED:
					System.out.println(UserFacingMessages.UN_SUPPORTED_COMMAND);
					logger.warn("User entered unsupported command.");
					break;

				case QUIT:
					connection.disconnect(); 
					quit = true;
					logger.debug("Quit program based on user request.");
					break;

				default:
					break;
				}

			} catch (Exception e) {
				// report issue to user
				System.out.println(e.getMessage());
				logger.error("Exception:"+e);

			}

		}

	}

}
