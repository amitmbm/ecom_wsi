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
import com.ami.dto.UserDTO;
import com.ami.dto.UserProfileDTO;
import com.ami.dto.UserWithProfileDTO;
import com.ami.entity.UserProfileId;
import com.ami.entity.Users;
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

	// Add a User
	/*@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(UserDTO userDTO) {
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);

			Users user = dataServices
					.addUser(userDTO);
			response = Response.status(Response.Status.CREATED)
					.entity(new UserDTO(user)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user", e);
		}

		return response;

	}*/

	
	// update a user
	@PUT
	@Path("/{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(UserDTO userDTO,
			@PathParam("mailid") String mailId) {
		logger.logMessage(LogLevel.INFO, "PUT User called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			Users users = dataServices.updateUser(
					userDTO, mailId);
			response = Response.status(Response.Status.OK)
					.entity(new UserDTO(users)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update user failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update user failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update user failed ::", e);
		}
		return response;
	}
		
		
	// Get a user
		@GET
		@Path("/{mailid}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response getUser(@PathParam("mailid") String mailId) {
			Users user = null;
			Response response = null;
			try {
				user = dataServices.getUserByMailId(mailId);
				response = Response.status(Response.Status.OK)
						.entity(new UserDTO(user)).build();
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" RESOURCE_NOT_FOUND Exception").build();
				logger.logException(LogLevel.ERROR, "Get user failed ::", re);
			} catch (Exception e) {
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "Get user failed ::", e);
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

	// Delete a Category
	@DELETE
	@Path("/{mailid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteUser(@PathParam("mailid") String mailId) {
		Response response = null;
		try {
			dataServices.deleteUser(mailId);
			response = Response.status(Response.Status.NO_CONTENT)
					.entity("Category deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete user failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Deleted user failed ::", e);
		}
		return response;
	}

	@SuppressWarnings("unused")
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(UserWithProfileDTO userWithProfileDTO) {
		Response response = null;
		Response finalResponse = null;
		try {
			// categoryServices.validateCategory(categoryDTO);

			 UserDTO userDTO = new UserDTO();
			 // setting the users from the UserWithProfile Payload.
			 userDTO.setEmailId(userWithProfileDTO.getEmailId());
		     userDTO.setIsRegister((byte) 'N');
		     userDTO.setPasswd("amit");
			Users user = dataServices.addUser(userDTO);
			
			response = Response.status(Response.Status.CREATED).build();
			// calling the userprofile Post method .
			
			Response responseForProfile = addUserProfile(userWithProfileDTO);
			if(response!=null && responseForProfile != null)
			{
				 finalResponse = Response.status(Response.Status.CREATED).build();
			}
				
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user", e);
		}

		return finalResponse;

	}

	
    // Adding the UserProfile from the payload of Users Endpoint
	public Response addUserProfile(UserWithProfileDTO userWithProfileDTO) {
		Response response = null;
		try{
			
		
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setFirstName(userWithProfileDTO.getFirstName());
		userProfileDTO.setLastName(userWithProfileDTO.getLastName());
		userProfileDTO.setPhoneNum(userWithProfileDTO.getPhoneNum());
		userProfileDTO.setUserEmail(userWithProfileDTO.getEmailId());
		
		UserProfileId userProfileId = dataServices.addUserProfile(userProfileDTO);
		
		response = Response.status(Response.Status.CREATED).build(); 
		
		}
		catch(CustomException e)
		{
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user-profile", e);	
		}
		catch(Exception e)
		{
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a user-profile", e);
		}
		
		return response;
	}
	
	
}

