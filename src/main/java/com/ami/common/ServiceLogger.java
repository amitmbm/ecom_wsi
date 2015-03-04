package com.ami.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceLogger {
	public static String logRequest(ServiceContext serviceContext, HttpServletRequest httpServletRequest ,String message){
		return "Requested Service URL : "+serviceContext.getServiceUrl()+ " , message : "+message ;
	}
	
	public static String logResponse(ServiceContext serviceContext, HttpServletResponse httpServletResponse , String message){
		return "Response Service URL : "+serviceContext.getServiceUrl()+ " , message : "+message + " ,ResponseCode: "+httpServletResponse.getStatus();
	}
	
	public static String log(ServiceContext serviceContext, String message){
		return message;
	}
	
	public static String logServiceTime(ServiceContext serviceContext, String message){
		return "Time taken by service URL : "+serviceContext.getServiceUrl() + "  is : "+(System.currentTimeMillis() - serviceContext.getInTime());
	}
}
