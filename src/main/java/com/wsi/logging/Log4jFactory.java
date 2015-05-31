package com.wsi.logging;

/**
 * Logger factory of type Log4j
 * @author (KH1871) Amit Khandelwal
 *
 */
public enum Log4jFactory implements ILoggerFactory {
	INSTANCE;

	@Override
	public ILogger getLogger(String loggerName) {
		// TODO Auto-generated method stub
		return new Log4jLogger(loggerName);
	}
}
