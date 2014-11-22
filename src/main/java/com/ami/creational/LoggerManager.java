package com.ami.creational;

 /**
  *  Factory Manager to create various types of log factory .
  *  Right now it supports log4JFactory only. 
  * @author KH1871
  *
  */

public class LoggerManager
{
 public static ILoggerFactory getLoggerFactory() {
		return Log4jFactory.INSTANCE;
	}
}
