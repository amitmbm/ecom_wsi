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
		System.out.println("inaide the fn call");
         
  //       logger.logMessage(LogLevel.FATAL, "FATAL Msg");
         try{
         int a=5/0;
         }
         catch(Exception e)
         {
        	 System.out.println("Exception");
        	 logger.logException(LogLevel.ERROR, "exception came ----------------------", e);
         }
	}	
}




