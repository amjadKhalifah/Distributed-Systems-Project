package edu.tum.ds;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/** This class contain the main function that will be executed when running the jar.
 * @author Amjad
 *
 */
public class Shell {

	/**
	 * Entry point of the application, starts the application.
	 * @param args
	 *            : Args passed on startup are ignored.
	 */
	public static void main(String[] args) {
		Logger logger = LoggingManager.CreateLogger(Shell.class);
		logger.info("Starting Application");
		EchoClientApplication echoclientapplication = new EchoClientApplication();
		echoclientapplication.startApplication();
				
	}

}
