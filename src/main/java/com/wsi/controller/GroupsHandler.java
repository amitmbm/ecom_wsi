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
import com.wsi.entity.Groups;
import com.wsi.enums.LogLevel;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;
import com.wsi.logging.ILogger;
import com.wsi.logging.LoggerManager;
import com.wsi.services.GroupsServices;

//@Component
@Path("/groups")
public class GroupsHandler {

	@Autowired
	GroupsServices groupsServicesImpl;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			GroupsHandler.class.getName());

	// post a group
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response group(Groups groups) {
		logger.logMessage(LogLevel.INFO, "POST Group called ");
		Response response = null;
		ErrorsDTO errorsDTO = null;
		try {
			response = Response.status(Response.Status.CREATED).entity(groupsServicesImpl.CreateGroup(groups)).build();
		} catch (CustomException e) {
			errorsDTO = Utility.createError(ErrorConstants.BAD_REQUEST,e.getMessage());
			response = Response.status(Response.Status.BAD_REQUEST).entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a Group", e);
		} catch (Exception e) {
			errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a group", e);
		}
		logger.logMessage(LogLevel.INFO, "");
		return response;
	}

	// update a group
	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response group(Groups groups, @PathParam("id") String id) {
		logger.logMessage(LogLevel.INFO, "PUT Group called ");
		Response response = null;
		try {
			response = Response.status(Response.Status.OK).entity(groupsServicesImpl.updateGroup(groups, id)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update group failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update group failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while updating a group", e);
		}
		return response;
	}

	// Get group detail
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response group(@PathParam("id") String id) {
		Groups group = null;
		Response response = null;
		try {
			group = groupsServicesImpl
					.getGroupById(id);
			
			response = Response.status(Response.Status.OK)
					.entity(group).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "Get group failed ::",
					re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while Getting a group", e);
		}
		return response;
	}

	// Delete a group
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteGroup(@PathParam("id") String id) {
		Response response = null;
		try {
			groupsServicesImpl.deleteGroup(id);
			response = Response.status(Response.Status.OK)
					.entity("group deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete group failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while deleting a group", e);
		}
		return response;
	}

}
