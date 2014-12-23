package com.ami.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
/**
 * 
 * @author Amit (it requires for the Basic Auth)
 *
 */
public class OptionsFilter implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
	    String method = containerRequest.getMethod();
	    containerRequest.getPath(true);
	    if(method.equals("OPTIONS")) {
	        throw new WebApplicationException(Status.OK);
	    }
	    return containerRequest;
	}
}
