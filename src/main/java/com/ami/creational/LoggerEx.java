package com.ami.creational;

import com.ami.enums.LogLevel;

/**
 * logger example 
 * @author KH1871
 *
 */
class LoggerEx {
	
	public static ILogger logger = LoggerManager.getLoggerFactory().getLogger(LoggerEx.class.getName());
	public static void main(String args[])
	{
         
         logger.logMessage(LogLevel.FATAL, "FATAL Msg");
         try{
         int a=5/0;
         }
         catch(Exception e)
         {
        	 logger.logException(LogLevel.ERROR, "exception came", e);
         }
	}	
}




