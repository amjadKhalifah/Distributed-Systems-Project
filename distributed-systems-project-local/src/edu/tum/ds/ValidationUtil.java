package edu.tum.ds;

import java.util.Arrays;
import java.util.List;

public class ValidationUtil {

	private static ValidationUtil validationinstance = null;
	public static final List<String> LOG_LEVELS = Arrays.asList("ALL", "DEBUG",
			"INFO", "WARN", "ERROR", "FATAL", "OFF");

	public static ValidationUtil getInstance() {
		if (validationinstance == null) {
			validationinstance = new ValidationUtil();
		}
		return validationinstance;
	}

	private ValidationUtil() {
	}

	public boolean isValidConnectionParams(String[] tokens)
			throws IllegalArgumentException {

		if (tokens == null) {
			throw new IllegalArgumentException(UserFacingMessages.GENERAL_ILLIGAL_ARGUMENT);
		}

		if (tokens.length < 3) {
			throw new IllegalArgumentException(UserFacingMessages.ILLIGAL_PARAM_NUMBER);
		}

		String host = tokens[1];

		if (host == null || host.isEmpty()) {
			throw new IllegalArgumentException("Address"+ UserFacingMessages.ILLIGAL_PARAM);
		}

		String port = tokens[2];

		if (port == null || port.isEmpty() || !isValidPort(port)) {
			throw new IllegalArgumentException("Port"+ UserFacingMessages.ILLIGAL_PARAM);
		}

		return true;
	}

	public boolean isValidMessage(String[] tokens) {
		if (tokens == null) {
			throw new IllegalArgumentException(UserFacingMessages.GENERAL_ILLIGAL_ARGUMENT);
		}

		if (tokens.length < 2) {
			throw new IllegalArgumentException(UserFacingMessages.ILLIGAL_PARAM_NUMBER);
		}

		String message = tokens[1];

		if (message == null || message.isEmpty()) {
			throw new IllegalArgumentException("Message"+ UserFacingMessages.ILLIGAL_PARAM);
		}

		return true;
	}

	public boolean isValidLogLevel(String[] tokens) {
		if (tokens == null) {
			throw new IllegalArgumentException(UserFacingMessages.GENERAL_ILLIGAL_ARGUMENT);
		}

		if (tokens.length < 2) {
			throw new IllegalArgumentException(UserFacingMessages.ILLIGAL_PARAM_NUMBER);
		}

		
		if (!LOG_LEVELS.contains(tokens[1].toUpperCase())) {
			throw new IllegalArgumentException("LogLevel"+ UserFacingMessages.ILLIGAL_PARAM);
		}
		return true;
	}

	private boolean isValidPort(String str) {
		try {
			double d = Double.parseDouble(str);
			if (d > 65535) {// Upper limit of port number
				throw new IllegalArgumentException(UserFacingMessages.ILLIGAL_PARAM_PORT);
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
