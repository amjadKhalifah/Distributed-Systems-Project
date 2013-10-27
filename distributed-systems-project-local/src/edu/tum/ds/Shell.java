package edu.tum.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** This class contain the main function that will be executed when running the jar.
 * @author Amjad
 *
 */
public class Shell {

	/**
	 * Entry point of the application, the main function is shell runner 
	 *  that interacts with the user within the defined protocol.
	 * @param args
	 *            : Args passed on startup are ignored.
	 */
	public static void main(String[] args) {
		// initialize buffer reader to read user input. 
		BufferedReader cons = new BufferedReader(new InputStreamReader(
				System.in));
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
					throw new IllegalArgumentException(UserFacingMessages.GENERAL_ILLIGAL_ARGUMENT);
				}

				// start parsing the tokens
				EchoClientCommand command = EchoClientCommand
						.fromString(tokens[0]);
				ValidationUtil validationUtil = ValidationUtil.getInstance();
				switch (command) {
				case CONNECT:
					if (validationUtil.isValidConnectionParams(tokens)) {
						System.out.println("connecting to " + tokens[1] + "--"
								+ tokens[2]);
						System.out.println("Display the result");
					}
					break;
				case DISCONNECT:
					System.out.println("command disconnect");
					break;
				case SEND:
					if (validationUtil.isValidMessage(tokens)) {
						
						System.out.println("send"+input.trim().substring(4));// 4 is the index after 'send'
					}
					break;
				case LOG_LEVEL:
					if (validationUtil.isValidLogLevel(tokens)) {
						//TODO set log level and print the new log level
					System.out.println("command log level set to "+tokens[1] );
					}
					break;
				case HELP:
					System.out.println(UserFacingMessages.HELP_TEXT);
					break;

				case UN_SUPPORTED:
					System.out.println(UserFacingMessages.UN_SUPPORTED_COMMAND);
					break;

				case QUIT:
					System.out.println("command quit");
					// TODO call disconnect
					quit = true;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				// report issue to user
				System.out.println(e.getMessage());
				
			}

		}
		System.out.println("EchoClient exiting..");
	}

}
