package edu.tum.ds.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientConnection implements Connectable {

	private Socket connection; // connection socket using TCP/IP protocol
	private InputStream input; // input stream generated from the socket to send
								// and receive
	private OutputStream output;

	@Override
	public void connect ( String hostAddress , int port )
			throws ClientConnectionException {

		try {
			if ( ! isConnected () ) {

				this.connection = new Socket ( hostAddress , port );
				this.output = connection.getOutputStream ();
				this.input = connection.getInputStream ();

			} else {
				throw new ClientConnectionException ( " already connected " );
			}
		} catch ( IOException exception ) {
			// handle exception
			exception.printStackTrace ();
			throw new ClientConnectionException (
					"Error in connecting to server" );
		}
	}

	@Override
	public void send ( byte b ) throws ClientConnectionException {

		try {

			output.write ( b );
			output.flush ();

		} catch ( IOException e ) {
			// handle Exception
			throw new ClientConnectionException ( "Error in sending data" );
		}
	}

	@Override
	public void send ( byte [] data ) throws ClientConnectionException {

		try {
			this.output.write ( data );
			this.output.flush ();

		} catch ( IOException exception ) {
			// handle exception
			throw new ClientConnectionException ( "Error in sending data" );
		}

	}

	@Override
	public byte [] receive () throws ClientConnectionException {

		byte [] data = null;
		try {
			data = new byte [ this.connection.getReceiveBufferSize () ];
			input.read ( data );

		} catch ( IOException exception ) {
			// handle exception
			exception.printStackTrace ();
			throw new ClientConnectionException ( "Error in reading data" );
		}

		return data;
	}

	@Override
	public void disconnect () throws ClientConnectionException {

		if ( isConnected () ) {
			try {
				this.connection.close ();
				this.output.close ();
				this.input.close ();

			} catch ( IOException exception ) {
				// handle exception
				throw new ClientConnectionException (
						"Error in closing connection" );
			}
		} else {
			throw new ClientConnectionException ( "Not connected " );
		}

	}

	@Override
	public boolean isConnected () {

		boolean isConnected = false;
		if ( connection != null ) {
			isConnected = ! connection.isClosed ();
		}
		return isConnected;
	}

}
