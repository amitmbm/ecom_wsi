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
import com.wsi.entity.Permissions;
import com.wsi.enums.LogLevel;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;
import com.wsi.logging.ILogger;
import com.wsi.logging.LoggerManager;
import com.wsi.services.PermissionServices;

@Path("/permissions")
public class PermissionsHandler {
	
	@Autowired
	PermissionServices permissionServicesImpl;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			PermissionsHandler.class.getName());

	// post a permission
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPermission(Permissions permissions) {
		logger.logMessage(LogLevel.INFO, "POST Permission called ");
		Response response = null;
		ErrorsDTO errorsDTO = null;
		try {
			response = Response.status(Response.Status.CREATED).entity(permissionServicesImpl.createPermissions(permissions)).build();
		} catch (CustomException e) {
			errorsDTO = Utility.createError(ErrorConstants.BAD_REQUEST,e.getMessage());
			response = Response.status(Response.Status.BAD_REQUEST).entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a Permission", e);
		} catch (Exception e) {
			errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a permission", e);
		}
		logger.logMessage(LogLevel.INFO, "");
		return response;
	}

	// update a permission
	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePermission(Permissions permissions, @PathParam("id") String id) {
		logger.logMessage(LogLevel.INFO, "PUT Permission called ");
		Response response = null;
		try {
			response = Response.status(Response.Status.OK).entity(permissionServicesImpl.updatePermissions(permissions, id)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update permission failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update permission failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while updating a permission", e);
		}
		return response;
	}

	// Get permission detail
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getPermission(@PathParam("id") String id) {
		Permissions permission = null;
		Response response = null;
		try {
			permission = permissionServicesImpl
					.getPermissionsById(id);
			
			response = Response.status(Response.Status.OK)
					.entity(permission).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "Get permission failed ::",
					re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while Getting a permission", e);
		}
		return response;
	}

	// Delete a permission
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deletePermission(@PathParam("id") String id) {
		Response response = null;
		try {
			permissionServicesImpl.deletePermissions(id);
			response = Response.status(Response.Status.OK)
					.entity("permission deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete permission failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while deleting a permission", e);
		}
		return response;
	}


}
