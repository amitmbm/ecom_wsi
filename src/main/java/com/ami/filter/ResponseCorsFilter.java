package com.ami.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import com.ami.common.ServiceLogger;
import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.enums.LogLevel;

public class ResponseCorsFilter implements ContainerResponseFilter {

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(ResponseCorsFilter.class.getName());
	@Override
	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
		logger.logMessage(LogLevel.INFO, ServiceLogger.log(null, "In ResponseCorsFilter filter method"));
		if(containerResponseContext.getHeaders().get("Access-Control-Allow-Origin")==null)
			containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");

		containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", 
				"origin," +
						"content-type," +
						"accept," +
						"authorization,"+
						"if-modified-since," +
						"pragma," +
				"cache-control");
		containerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		containerResponseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
	}
}