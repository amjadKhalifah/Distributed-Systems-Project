package ui;


import org.apache.log4j.Logger;

import edu.tum.ds.EchoClientApplication;
import edu.tum.ds.LoggingManager;


/** This class contain the main function that will be executed when running the jar.
 * @author Amjad
 *
 */
public class Application {

	/**
	 * Entry point of the application, starts the application.
	 * @param args
	 *            : Args passed on startup are ignored.
	 */
	public static void main(String[] args) {
		Logger logger = LoggingManager.getInstance ().createLogger(Application.class);
		logger.info("Starting Application");
		EchoClientApplication echoclientapplication = new EchoClientApplication();
		echoclientapplication.startApplication();
		logger.info("Exiting Application");
		System.out.println("Exiting Application");
				
	}

}
