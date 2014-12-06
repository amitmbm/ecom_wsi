package com.ami.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.common.ErrorConstants;
import com.ami.common.Utility;
import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.dto.ErrorsDTO;
import com.ami.dto.PostDTO;
import com.ami.entity.PostAdd;
import com.ami.enums.LogLevel;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;
import com.ami.services.AddServices;

/*
 *  controller class for Adds
 */
@Component
@Path("/api/v1/data/postadd")
public class AddController {

	@Autowired
	AddServices dataServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			AddController.class.getName());
	
	// Post An Add on platform
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAdd(PostDTO postDTO) {
		Response response = null;
		try {
			PostAdd postAdd = 	dataServices.postAdd(postDTO);
			response = Response.status(Response.Status.CREATED).entity(new PostDTO(postAdd)).build();

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
	
    	// update a posted-Add
		@PUT
		@Path("{addguid}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateAdd(PostDTO postDTO,
				@PathParam("addguid") String addGuid) {
			logger.logMessage(LogLevel.INFO, "update Add called ");
			Response response = null;
			try {
				// dataServices.validateCategory(postDTO);
				PostAdd postAdd = dataServices.updateAdd(
						postDTO, addGuid);
				response = Response.status(Response.Status.OK)
						.entity(new PostDTO(postAdd)).build();
			} catch (CustomException e) {
				response = Response.status(Response.Status.BAD_REQUEST)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "update category failed ::", e);
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" NOT_FOUND error").build();
				logger.logException(LogLevel.ERROR, "update category failed ::", re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while updating a category", e);
			}
			return response;
		}
		
		// Get an Add
		@GET
		@Path("{addguid}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response getAdd(@PathParam("addguid") String addGuid) {
			PostAdd postAdd = null;
			Response response = null;
			try {
				postAdd = dataServices.getAddById(addGuid);
				response = Response.status(Response.Status.OK)
						.entity(new PostDTO(postAdd)).build();
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" RESOURCE_NOT_FOUND Exception").build();
				logger.logException(LogLevel.ERROR, "Get Category failed ::", re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while getting a category", e);
			}
			return response;
		}
		
		// Delete an Add
		@DELETE
		@Path("{addguid}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response deleteAdd(@PathParam("addguid") String addguid) {
			Response response = null;
			try {
				dataServices.deleteAdd(addguid);
				response = Response.status(Response.Status.OK)
						.entity("Add deleted successfully").build();
			} catch (ResourceNotFoundException re) {
				response = Response.status(Response.Status.NOT_FOUND)
						.entity(" NOT_FOUND error").build();
				logger.logException(LogLevel.ERROR, "delete Add failed ::", re);
			} catch (Exception e) {
				ErrorsDTO errorsDTO = Utility.createError(ErrorConstants.INTERNAL_SYSTEM_ERROR,e.getMessage());
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorsDTO).build();
				logger.logException(LogLevel.ERROR,
						"exception occured while deleting an Add", e);
			}
			return response;
		}
		
		// Get List of All the Adds based on the given price range
		
		  @GET
		  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		  public Response getAddsByPriceFilter(@Context HttpHeaders headers) {
		  
			  String from = headers.getRequestHeader("from").get(0);
			  String to = headers.getRequestHeader("to").get(0);
			  int lowPrice = Integer.parseInt(from);
			  int highPrice = Integer.parseInt(to);
			  System.out.println("lowprice" + lowPrice);
			  System.out.println("highprice" + highPrice);
		  List<PostAdd> addList =  null; 
		  Response response = null; 
		  try { 
			  addList =  dataServices.getAddList(lowPrice , highPrice); 
			  response =  Response.status(Response.Status.OK).entity(addList).build();
		  } catch (Exception e) { 
			  response =  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error").build();
		  logger.logException(LogLevel.ERROR,"Get Categories failed ::", e); 
		  }
		  return response; 
		  }
		 

}
