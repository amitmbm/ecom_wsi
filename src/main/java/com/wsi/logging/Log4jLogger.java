package com.wsi.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.AbstractLogger;

import com.wsi.enums.LogLevel;

/**
 * Logger using log4j2 library
 * @author (KH1871) Amit Khandelwal
 *
 */
public class Log4jLogger implements ILogger {
	private final String loggerName;
	private LogLevel logLevel;
	private final AbstractLogger logger; 
	private static final String FQCN = Log4jLogger.class.getName();
	

	private Level getLog4jLevel(LogLevel level) {
		switch(level){
		case FATAL:
			return Level.FATAL;
		case DEBUG:
			return Level.DEBUG;
		case ERROR:
			return Level.ERROR;
		case INFO:
			return Level.INFO;
		case WARN:
			return Level.WARN;
		default:
			return Level.INFO;

		}
	}
	public Log4jLogger(String loggerName) {
		this.loggerName=loggerName;
		this.logLevel=LogLevel.INFO;
		logger=(AbstractLogger) LogManager.getLogger(loggerName);		
	}

	@Override
	public void logMessage(LogLevel level, String msg) {		
	  logger.logIfEnabled(FQCN, getLog4jLevel(level), null, msg);
	}

	@Override
	public void setLogLevel(LogLevel level) {		
		logLevel=level;
	}

	@Override
	public void logException(LogLevel level, Exception e) {
		logger.logIfEnabled(FQCN, getLog4jLevel(level), null,"",e);  
	}

	@Override
	public void logException(LogLevel level, String msg,Exception e) {
		logger.logIfEnabled(FQCN, getLog4jLevel(level), null,msg,e);
	}

}
