package com.ami.creational;

/**
 * Abstract Factory interface for getting logger objects
 * @author (KH1871) Amit Khandelwal
 *
 */
public interface ILoggerFactory {
	/**
	 * Get logger object with the given name
	 * @param loggerName - name of the logger
	 * @return ILogger object
	 */
	ILogger getLogger(String loggerName);
}
