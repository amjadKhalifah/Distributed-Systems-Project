package edu.tum.ds;

/**
 * @author AMJAD
 * 
 */

public enum EchoClientCommand {

	CONNECT ( "connect" ) , DISCONNECT ( "disconnect" ) , SEND ( "send" ) , LOG_LEVEL (
			"logLevel" ) , HELP ( "help" ) , QUIT ( "quit" ) , UN_SUPPORTED (
			"unSupported" );

	private String commandText;

	/**
	 * Enum constructor to initialize the commandText
	 * 
	 * @param commandText
	 */
	private EchoClientCommand ( String commandText ) {
		this.commandText = commandText;
	}

	/**
	 * @return commandText
	 */
	public String getCommandText () {
		return commandText;
	}

	/**
	 * @param commandText
	 * @return EchoClientCommand appropriate <code>enum</code> for the command
	 */
	public static EchoClientCommand fromString ( String commandText ) {
		if ( commandText != null ) {
			for ( EchoClientCommand command : EchoClientCommand.values () ) {
				if ( commandText.equalsIgnoreCase ( command.commandText ) ) {
					return command;
				}
			}
		}
		return EchoClientCommand.UN_SUPPORTED;
	}

}
