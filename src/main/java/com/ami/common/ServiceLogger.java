package com.ami.common;


public class ServiceLogger {
	public static String logRequest(ServiceContext serviceContext,String message){
		return "Requested Service URL : "+serviceContext.getServiceUrl()+ " , message : "+message;
	}
	
	public static String logResponse(ServiceContext serviceContext, int statusCode  , String message){
		return "Response Service URL : "+serviceContext.getServiceUrl()+ " , message : "+message + " , ResponseCode: "+statusCode;
	}
	
	public static String log(ServiceContext serviceContext, String message){
		return message;
	}
	
	public static String logServiceTime(ServiceContext serviceContext, String message){
		return "Time taken by service URL : "+serviceContext.getServiceUrl() + "  is : "+(System.currentTimeMillis() - serviceContext.getInTime());
	}
}
