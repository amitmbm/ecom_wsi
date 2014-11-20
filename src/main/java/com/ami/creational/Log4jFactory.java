package com.ami.creational;

/**
 * Logger factory of type Log4j
 * @author (KH1871) Amit Khandelwal
 *
 */
public class Log4jFactory implements ILoggerFactory {

	public ILogger getLogger(String loggerName) {		
		return new Log4jLogger(loggerName);
	}
}
