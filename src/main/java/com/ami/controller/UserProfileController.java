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
import com.ami.entity.UserProfileId;
import com.ami.enums.LogLevel;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;
import com.ami.services.UserServices;

/*
 * This class is related to CRUD operations on User-profile
 */

@Component
@Path("/userprofile")
public class UserProfileController {
	
	@Autowired
	UserServices dataServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			UserProfileController.class.getName());
	
	// Add a User-profile
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserProfile(UserProfileDTO userProfileDTO) {
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);

			UserProfileId userProfileId = dataServices.addUserProfile(userProfileDTO);
			response = Response.status(Response.Status.CREATED)
					.entity(new UserProfileDTO(userProfileId)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user-profile", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user-profile", e);
		}

		return response;

	}

	
	// update a user-profile
	@PUT
	@Path("{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserProfile(UserProfileDTO userProfileDTO,
			@PathParam("mailid") String mailId) {
		logger.logMessage(LogLevel.INFO, "PUT User-profile called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			UserProfileId userProfileId = dataServices.updateUserProfile(
					userProfileDTO, mailId);
			response = Response.status(Response.Status.OK)
					.entity(new UserProfileDTO(userProfileId)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update user-profile failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update user-profile failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update user-profile failed ::", e);
		}
		return response;
	}
		
		
	// Get a user-profile 
		@GET
		@Path("{mailid}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response getUserProfile(@PathParam("mailid") String mailId) {
			Response response = null;
			try {
				UserProfileId userProfileId = dataServices.getUserProfileByMailId(mailId);
				response = Response.status(Response.Status.OK)
						.entity(new UserProfileDTO(userProfileId)).build();
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" RESOURCE_NOT_FOUND Exception").build();
				logger.logException(LogLevel.ERROR, "Get user-profile failed ::", re);
			} catch (Exception e) {
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "Get user-profile failed ::", e);
			}
			return response;
		}
	
	

	/*@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<User> getUsers() {

		List<User> userList = null;
		try {
			userList = dataServices.getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}*/

	// Delete a User-profile
	@DELETE
	@Path("{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteUserProfile(@PathParam("mailid") String mailId) {
		Response response = null;
		try {
			dataServices.deleteUserProfile(mailId);
			response = Response.status(Response.Status.NO_CONTENT)
					.entity("User-profile deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete user-profile failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Deleted user-profile failed ::", e);
		}
		return response;
	}

}
