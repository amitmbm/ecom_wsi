package com.ami.controller;

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
import org.springframework.stereotype.Component;

import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.dto.UserProfileDTO;
import com.ami.entity.UserProfile;
import com.ami.enums.LogLevel;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;
import com.ami.services.UserServices;

@Component
@Path("/users")
public class UserController {

	@Autowired
	UserServices dataServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			UserController.class.getName());
	
	// Add a user and user-profile
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(UserProfileDTO userProfileProfileDTO) {
		Response response = null;
		try {
			UserProfile userProfileProfile = dataServices.addUser(userProfileProfileDTO);
			response = Response.status(Response.Status.CREATED).entity(new UserProfileDTO(userProfileProfile)).build();

		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a userProfile", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a userProfile", e);
		}
		return response;
	}

	// update a user and userProfile
	@PUT
	@Path("/{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(UserProfileDTO userProfileDTO,
			@PathParam("mailid") String mailId) {
		logger.logMessage(LogLevel.INFO, "PUT User called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			UserProfile userProfile = dataServices.updateUser(
					userProfileDTO, mailId);
			response = Response.status(Response.Status.OK)
					.entity(new UserProfileDTO(userProfile)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update userProfile failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update userProfile failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update userProfile failed ::", e);
		}
		return response;
	}


	// Get a userProfile
	@GET
	@Path("/{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUser(@PathParam("mailid") String mailId) {
		logger.logMessage(LogLevel.INFO, "Get User called ");
		UserProfile userProfile = null;
		Response response = null;
		try {
			userProfile = dataServices.getUserProfileByMailId(mailId);
			response = Response.status(Response.Status.OK)
					.entity(new UserProfileDTO(userProfile)).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" RESOURCE_NOT_FOUND Exception").build();
			logger.logException(LogLevel.ERROR, "Get userProfile failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Get userProfile failed ::", e);
		}
		return response;
	}

	// Delete a user and user-profile
	@DELETE
	@Path("/{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteUser(@PathParam("mailid") String mailId) {
		Response response = null;
		try {
			dataServices.deleteUserProfile(mailId);
			response = Response.status(Response.Status.NO_CONTENT)
					.entity("User-profile deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete userProfile failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Deleted userProfile failed ::", e);
		}
		return response;
	}

}

