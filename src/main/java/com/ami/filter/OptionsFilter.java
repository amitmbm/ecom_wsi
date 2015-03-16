package com.ami.filter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;

/**
 * 
 * @author Amit (it requires for the Basic Auth)
 *
 */
public class OptionsFilter implements ContainerRequestFilter{
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		String method = containerRequestContext.getMethod();
		containerRequestContext.getUriInfo().getPath(true);
		if(method.equals("OPTIONS")) {
			throw new WebApplicationException(Status.OK);
		}	
	}
}
