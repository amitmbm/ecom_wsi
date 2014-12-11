package com.ami.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.ami.common.AuthentificationThirdParty;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthFilter implements ContainerRequestFilter {
    /**
     * Apply the filter : check input request, validate or not with user auth
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // for manage apis , which starts with api/v1/manage/*
        String path = containerRequest.getPath(true);
    
       if((method.equals("GET")||method.equals("POST")||method.equals("PUT")||method.equals("DELETE")) && path.contains("api/v1/manage/")){
        	 //Get the authentification passed in HTTP headers parameters
            String auth = containerRequest.getHeaderValue("authorization");
     
            //If the user does not have the right (does not provide any HTTP Basic Auth)
            if(auth == null){
                throw new WebApplicationException(Status.UNAUTHORIZED);
            }
     
            //lap : loginAndPassword
            String[] lap = BasicAuth.decode(auth);
     
            //If login or password fail
            if(lap == null || lap.length != 2){
                throw new WebApplicationException(Status.UNAUTHORIZED);
            }
     
            //DO YOUR DATABASE CHECK HERE (replace that line behind)...
           Boolean authentificationResult =  AuthentificationThirdParty.authentification(lap[0], lap[1]);
     
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

	
}