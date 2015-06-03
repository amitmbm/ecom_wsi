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
import com.wsi.entity.Acls;
import com.wsi.enums.LogLevel;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;
import com.wsi.logging.ILogger;
import com.wsi.logging.LoggerManager;
import com.wsi.services.AclsServices;

@Path("/acls")
public class AclsHandler {

	@Autowired
	AclsServices AclsServicesImpl;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			AclsHandler.class.getName());

	// post a acls
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAcls(Acls acls) {
		logger.logMessage(LogLevel.INFO, "POST Acls called ");
		Response response = null;
		ErrorsDTO errorsDTO = null;
		try {
			response = Response.status(Response.Status.CREATED).entity(AclsServicesImpl.createAcls(acls)).build();
		} catch (CustomException e) {
			errorsDTO = Utility.createError(ErrorConstants.BAD_REQUEST,e.getMessage());
			response = Response.status(Response.Status.BAD_REQUEST).entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a Acls", e);
		} catch (Exception e) {
			errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a acls", e);
		}
		logger.logMessage(LogLevel.INFO, "");
		return response;
	}

	// update a acls
	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAcls(Acls acls, @PathParam("id") String id) {
		logger.logMessage(LogLevel.INFO, "PUT Acls called ");
		Response response = null;
		try {
			response = Response.status(Response.Status.OK).entity(AclsServicesImpl.updateAcls(acls, id)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update acls failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update acls failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while updating a acls", e);
		}
		return response;
	}

	// Get acls detail
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAcls(@PathParam("id") String id) {
		Acls acls = null;
		Response response = null;
		try {
			acls = AclsServicesImpl
					.getAclsById(id);
			
			response = Response.status(Response.Status.OK)
					.entity(acls).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "Get acls failed ::",
					re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while Getting a acls", e);
		}
		return response;
	}

	// Delete a acls
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteAcls(@PathParam("id") String id) {
		Response response = null;
		try {
			AclsServicesImpl.deleteAcls(id);
			response = Response.status(Response.Status.OK)
					.entity("acls deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete acls failed ::", re);
		} catch (Exception e) {
			ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorsDTO).build();
			logger.logException(LogLevel.ERROR,
					"exception occured while deleting a acls", e);
		}
		return response;
	}

}
