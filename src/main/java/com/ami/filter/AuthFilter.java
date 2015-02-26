package com.ami.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.NDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ami.services.UserServices;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Component
public class AuthFilter implements ContainerRequestFilter {
	private static final String WWWAuthHeaderVal = "Basic realm=\"insert realm\"";
	
	@Autowired
	UserServices dataServices;
	
	@Value("${basic_user_name}")
	private String basicUsername;
	
	@Value("${basic_user_password}")
	private String basicPassword;
	
	
	/**
     * Apply the filter : check input request, validate or not with user auth
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
        // for manage apis , which starts with api/v1/manage/*
        String reqPath = containerRequest.getPath(); 
        NDC.push("amit");
       if(reqPath.startsWith("api/v1/manage"))
       {
        	 //Get the authentification passed in HTTP headers parameters
            String auth = containerRequest.getHeaderValue("authorization");
     
            //If the user does not have the right (does not provide any HTTP Basic Auth)
            if(auth == null){
            	Response response = Response.status(Status.UNAUTHORIZED).header(HttpHeaders.WWW_AUTHENTICATE, WWWAuthHeaderVal).entity(null).build();
            	throw new WebApplicationException(response);
            }
     
            //lap : loginAndPassword
            String[] lap = BasicAuth.decode(auth);
     
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
        return containerRequest;
       
    }

    private boolean isAuthenticated(String username, String password){
    	if(username == null || password == null)
    		return false;
    	
    	if (username.equalsIgnoreCase(basicUsername) && password.equalsIgnoreCase(basicPassword))
    		return true;
    	return false;
    }
    
	
}