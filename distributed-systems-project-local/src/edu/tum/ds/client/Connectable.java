/**
 * This interface is the basic skelton for the client
 * part. it defines the main methods that is essential
 * in every connection.
 * 
 * @author Ibrahim Alzant
 * 
 */

package edu.tum.ds.client;

public interface Connectable {

	/**
	 * Constructs a Socket with a specific host address and port number and
	 * after that starts a connection with TCP/IP protocol with a ServerSocket.
	 * 
	 * @param hostAddress
	 *            The address for the server. null value is not allowed.
	 * @param port
	 *            The port for the host.
	 * @throws ClientConnectionException
	 *             if there is error in the underlying connection.
	 * @see java.net.Socket
	 */
	public abstract void connect ( String hostAddress , int port )
			throws ClientConnectionException;

	/**
	 * Sends array of <code>byte</code> using the <code>OuputStream</code> that
	 * generated from the connection <code>Socket</code>.
	 * <p>
	 * This method will block the connection till the message is sent or an
	 * exception will be thrown.
	 * 
	 * 
	 * @param message
	 *            array of <code>byte</code> to be send through the connection
	 *            <code>OutputStream</code>.
	 * @throws <code>ClientConnectionException</code> if there is error in the
	 *         underlying connection.
	 * @see java.io.OutputStream
	 */
	public abstract void send ( byte [] data ) throws ClientConnectionException;

	/**
	 * Sends <code>byte</code> using the <code>OuputStream</code> that generated
	 * from the connection <code>Socket</code>.
	 * <p>
	 * This method will block the connection till the message is sent or an
	 * exception will be thrown.
	 * 
	 * 
	 * @param message
	 *            <code>byte</code> to be send through the connection
	 *            <code>OutputStream</code>.
	 * @throws <code>ClientConnectionException</code> if there is error in the
	 *         underlying connection.
	 * @see java.io.OutputStream
	 */
	public abstract void send ( byte data ) throws ClientConnectionException;

	/**
	 * Receives message of bytes using the <code>InputStream</code> that
	 * generated from the connection <code>Socket</code>.
	 * <p>
	 * This method will block the connection till the message is received or an
	 * error will happen.
	 * 
	 * @return array of <code>byte</code> sent form the server.
	 * @throws <code>ClientConnectionException</code> if there is error in the
	 *         underlying connection.
	 * @see java.io.InputStream
	 */
	public abstract byte [] receive () throws ClientConnectionException;

	/**
	 * Checks if the connection still alive or disconnected.
	 * 
	 * @return <code>boolean</code> indicates whether the connection is still
	 *         alive or not.
	 */
	public abstract boolean isConnected ();

	/**
	 * Disconnect the connection with the server.
	 * 
	 * @throws <code>ClientConnectionException</code> if there is error in the
	 *         underlying connection.
	 */
	public abstract void disconnect () throws ClientConnectionException;

}