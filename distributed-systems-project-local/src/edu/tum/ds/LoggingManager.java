package edu.tum.ds;

import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.*;

/**
 * @author Md.Habibur Rahman
 * 
 */
public final class LoggingManager {

	static HashSet < Logger > loggerList = new HashSet < Logger > ();

	private LoggingManager () {

	}

	public static Logger CreateLogger ( Class claz ) {
		Logger logger = Logger.getLogger ( claz );
		loggerList.add ( logger );
		return logger;
	}

	public static void SetLoggerLevel ( String newLevel ) {
		Level level = Level.toLevel ( newLevel );
		Iterator < Logger > itr = loggerList.iterator ();
		while ( itr.hasNext () ) {
			Logger element = itr.next ();
			element.setLevel ( level );
		}
	}
}
