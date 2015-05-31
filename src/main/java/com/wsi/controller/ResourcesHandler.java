package com.wsi.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.wsi.common.ErrorConstants;
import com.wsi.common.Utility;
import com.wsi.dto.ErrorsDTO;
import com.wsi.dto.ResourcesDTO;
import com.wsi.entity.Resources;
import com.wsi.enums.LogLevel;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;
import com.wsi.logging.ILogger;
import com.wsi.logging.LoggerManager;
import com.wsi.services.ResourcesServices;

@Path("/resources")
public class ResourcesHandler {
	
	@Autowired
	ResourcesServices resourcesServicesImpl;
	
	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			ResourcesHandler.class.getName());
	
	    // post a Resource
		@POST
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Consumes(MediaType.APPLICATION_JSON)
		public Response resource(ResourcesDTO resourcesDTO) {
			logger.logMessage(LogLevel.INFO, "POST Resource called ");
			Response response = null;
			ErrorsDTO errorsDTO = null;
			try {
				Resources resources = resourcesServicesImpl
						.CreateResource(resourcesDTO);
				response = Response.status(Response.Status.CREATED)
						.entity(new ResourcesDTO(resources)).build();
				 logger.logMessage(LogLevel.INFO, "post resource successful");
				
			} catch (CustomException e) {
				errorsDTO = Utility.createError(ErrorConstants.BAD_REQUEST,e.getMessage());
				response = Response.status(Response.Status.BAD_REQUEST).entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while posting a Resource", e);
			} catch (Exception e) {
			    errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while posting a resource", e);
			}
			return response;
		}
		
		// update a resource
		@PUT
		@Path("{id}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Consumes(MediaType.APPLICATION_JSON)
		public Response resource(ResourcesDTO resourcesDTO,
				@PathParam("id") String id) {
			logger.logMessage(LogLevel.INFO, "update Resource called ");
			Response response = null;
			try {
				Resources resources = resourcesServicesImpl.updateResource(
						resourcesDTO, id);
				response = Response.status(Response.Status.OK)
						.entity(new ResourcesDTO(resources)).build();
				logger.logMessage(LogLevel.INFO, "update Resource successful");
			} catch (CustomException e) {
				response = Response.status(Response.Status.BAD_REQUEST)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "update resource failed ::", e);
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" NOT_FOUND error").build();
				logger.logException(LogLevel.ERROR, "update resource failed ::", re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while updating a resource", e);
			}
			return response;
		}
		
		// Get resource detail
		@GET
		@Path("{id}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response resource(@PathParam("id") String id) {
			logger.logMessage(LogLevel.INFO, "get Resource called ");
			Resources resource = null;
			Response response = null;
			try {
				resource = resourcesServicesImpl
						.getResourceById(id);
				response = Response.status(Response.Status.OK)
						.entity(new ResourcesDTO(resource)).build();
				logger.logMessage(LogLevel.INFO, "get Resource successful");
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" NOT_FOUND error").build();
				logger.logException(LogLevel.ERROR, "Get resource failed ::",
						re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while Getting a resource", e);
			}
			return response;
		}
		
		// Delete a resource
		@DELETE
		@Path("{id}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response deleteResource(@PathParam("id") String id) {
			Response response = null;
			logger.logMessage(LogLevel.INFO, "delete Resource called ");
			try {
				resourcesServicesImpl.deleteResource(id);
				response = Response.status(Response.Status.OK)
						.entity("resource deleted successfully").build();
				logger.logMessage(LogLevel.INFO, "delete Resource successful");
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" NOT_FOUND error").build();
				logger.logException(LogLevel.ERROR, "delete resource failed ::", re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while deleting a resource", e);
			}
			return response;
		}


}
