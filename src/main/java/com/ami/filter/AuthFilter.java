package com.ami.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ami.common.ServiceContext;
import com.ami.common.ServiceLogger;
import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.enums.LogLevel;
import com.ami.services.UserServices;

@Component
public class AuthFilter implements ContainerRequestFilter, ContainerResponseFilter {
	private static final String WWWAuthHeaderVal = "Basic realm=\"insert realm\"";

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			AuthFilter.class.getName());
	@Autowired
	UserServices dataServices;

	@Value("${basic_user_name}")
	private String basicUsername;

	@Value("${basic_user_password}")
	private String basicPassword;

	@Context private HttpServletRequest httpServletRequest;

	private boolean isAuthenticated(String username, String password){
		if(username == null || password == null)
			return false;

		if (username.equalsIgnoreCase(basicUsername) && password.equalsIgnoreCase(basicPassword))
			return true;
		return false;
	}

	@Override
	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
		
		//logger.logMessage(LogLevel.INFO, ServiceLogger.logResponse((ServiceContext)httpServletRequest.getAttribute("servicecontext"), containerResponseContext.getStatus(), "Exit"));
		//logger.logMessage(LogLevel.INFO, ServiceLogger.logServiceTime((ServiceContext)httpServletRequest.getAttribute("servicecontext"), "time taken message"));
		ThreadContext.clearAll();
	}

	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		String reqPath = containerRequestContext.getUriInfo().getPath(); 

		ServiceContext serviceContext = new ServiceContext(httpServletRequest);
	
		//this thread to be removed after service ends else it will lead to memory leak results in perm gen space issue
		ThreadContext.push(serviceContext.getRequestId());
		
		
		httpServletRequest.setAttribute("servicecontext", serviceContext);
		
		logger.logMessage(LogLevel.INFO, ServiceLogger.logRequest((ServiceContext)httpServletRequest.getAttribute("servicecontext"),"Entry"));
		
		if(reqPath.startsWith("api/v1/manage"))
		{
			//Get the authentification passed in HTTP headers parameters
			String authHeaderValue = containerRequestContext.getHeaderString("authorization");

			//If the user does not have the right (does not provide any HTTP Basic Auth)
			if(authHeaderValue == null){
				Response response = Response.status(Status.UNAUTHORIZED).header(HttpHeaders.WWW_AUTHENTICATE, WWWAuthHeaderVal).entity(null).build();
				throw new WebApplicationException(response);
			}

			//lap : loginAndPassword
			String[] lap = BasicAuth.decode(authHeaderValue);

			//If login or password fail
			if(lap == null || lap.length != 2){
				throw new WebApplicationException(Status.UNAUTHORIZED);
			}

			//DATABASE CHECK is below
			Boolean authentificationResult = false;
			try {
				authentificationResult = isAuthenticated(lap[0], lap[1]);
			} catch (Exception e) {
				// TODO use logger
				e.printStackTrace();
			}
			//Our system refuse login and password
			if(authentificationResult == false){
				throw new WebApplicationException(Status.UNAUTHORIZED);
			}

			//TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON YOUR REST SERVICE...
			if(authentificationResult == true){
				System.out.println("passed");
			}
		}
	}
}