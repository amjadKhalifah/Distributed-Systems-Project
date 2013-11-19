package edu.tum.ds.server;

	/**
	 * @param args
	 * 
	 * @author Md.Habibur Rahman
	 */
import java.net.BindException;
import java.net.ServerSocket;
import org.apache.log4j.Logger;

import edu.tum.ds.LoggingManager;
import java.io.IOException;
	
	/**
	 * 
	 * @author Md.Habibur Rahman 
	 * code for  the Server socket connection on port implementation.
	 */
	public class Server extends Thread {

		private static Logger logger = LoggingManager.createServerLogger(Server.class);
		
		private int serverPort;
	    private ServerSocket serverSocket;
	    private boolean runningSocket;

	    
	    /**
	     * implement a  Server object which listens to at the given serverPort for connection attempts .
	     * 
	     *  serverPort a serverPort number which the Server is listening to in order to 
	     * 		establish a socket connection to a client. The serverPort number should 
	     * 		will be  generated in the form of  dynamic ports.
	     */
	    public Server(int serverPort){
	        this.serverPort = serverPort;
	        
	    }
	    private boolean initializeServer() {
	    	logger.info("server initilization");
	    	try {
	            serverSocket = new ServerSocket(serverPort);
	            logger.info("Server socket listening on the serverPort: " 
	            		+ serverSocket.getLocalPort());    
	            return true;
	        
	        } catch (IOException e) {
	        	logger.error("Sorry! server socket can not be oppened:");
	            if(e instanceof BindException){
	            	logger.error("the serverPort " + serverPort + " is already bound!");
	            }
	            return false;
	        }
	    }

	    /**
	     * it would not listen at the given serverPort the it will stop serverSocket connection.
	     */
	    public void stopServer(){
	        runningSocket = false;
	        try {
				serverSocket.close();
			} catch (IOException e) {
				logger.error("Error! " +
						"not able to close server socket on the serverPort: " + serverPort, e);
			}
	    }


	    private boolean is_Running() {
	        return this.runningSocket;
	    }
	    
	    
}


