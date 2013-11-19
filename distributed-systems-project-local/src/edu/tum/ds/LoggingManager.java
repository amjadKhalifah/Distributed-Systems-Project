package edu.tum.ds;


import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.*;

/**
 * 
 * @author Md.Habibur Rahman
 *
 */
public final class LoggingManager {

	static HashSet<Logger> loggerLists = new HashSet<Logger>();
	
	private LoggingManager(){
		
	}
	
	public static Logger createServerLogger(Class clazz){
		return createLogger(clazz, "logs/server.log");
	}
	
	public static Logger createClientLogger(Class clazz){
		return createLogger(clazz, "logs/client.log");
	}
	
	private static Logger createLogger(Class clazz, String filePath)
	{
		// initialize logger
		Logger logger = Logger.getLogger(clazz);
		String logDir = filePath;
		//String pattern = "%d{ISO8601} %-5p [%t] %c: %m%n";
		String pattern = "%d{ISO8601} %p [%t] %c (%F:%L) - %m%n";
		PatternLayout pLayout = new PatternLayout(pattern);
		FileAppender fa = null;
		try {
			fa = new FileAppender(pLayout, logDir, true );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.addAppender(fa);
		logger.setLevel(Level.ALL);
		loggerLists.add(logger);
		return logger;
	}	
	
	public static void SetLoggerLevel(String newLevel)
	{
		Level level = Level.toLevel(newLevel);
		Iterator<Logger> itr = loggerLists.iterator();
		while(itr.hasNext()) {
	         Logger element = itr.next();
	         element.setLevel(level);
	      }		
	}
}
