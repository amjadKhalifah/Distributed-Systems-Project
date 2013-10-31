package edu.tum.ds.client;

/**
 * @author IBRAHIM
 * This is an exception to be thrown to the user in case of something 
 * going wrong.
 */
public class ClientConnectionException extends Exception {

	public ClientConnectionException ( String message ) {

		super ( message );
	}

}
