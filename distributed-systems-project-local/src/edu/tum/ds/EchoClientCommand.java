package edu.tum.ds;

public enum EchoClientCommand {

	CONNECT("connect"), DISCONNECT("disconnect"), 
	SEND("send"), LOG_LEVEL("logLevel"),
	HELP ("help"), QUIT("quit"), 
	UN_SUPPORTED("unSupported");

	private String commandText;

	private EchoClientCommand(String commandText) {
		this.commandText = commandText;
	}

	public String getCommandText() {
		return commandText;
	}

	public static EchoClientCommand fromString(String commandText) {
		if (commandText != null) {
			for (EchoClientCommand command : EchoClientCommand.values()) {
				if (commandText.equalsIgnoreCase(command.commandText)) {
					return command;
				}
			}
		}
		return EchoClientCommand.UN_SUPPORTED;
	}


}
