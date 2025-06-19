package deel_automation.util;

import org.apache.log4j.Logger;

import deel_automation.listeners.LogListener;

public class LoggerUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LogListener.class);


	public static void log(String message) {
		logger.info(message);
	}

	public static Logger getLogger() {
		return logger;
	}
}
