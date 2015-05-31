package com.wsi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.wsi.common.ErrorConstants;
import com.wsi.common.Utility;
import com.wsi.dto.ErrorsDTO;
import com.wsi.dto.PostDTO;
import com.wsi.entity.PostAdd;
import com.wsi.enums.LogLevel;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;
import com.wsi.logging.ILogger;
import com.wsi.logging.LoggerManager;
import com.wsi.services.AddServices;

/*
 *  controller class for Adds
 */
@Component
@Path("/api/v1/data/postadd")
@Validated
public class AddController {

	@Autowired
	AddServices dataServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			AddController.class.getName());

	// Post An Add on platform
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAdd(@Valid PostDTO postDTO) {
		Response response = null;
		try {
			PostAdd postAdd = dataServices.postAdd(postDTO);
			response = Response.status(Response.Status.CREATED)
					.entity(new PostDTO(postAdd)).build();

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
			PostAdd postAdd = dataServices.updateAdd(postDTO, addGuid);
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
			ErrorsDTO errorsDTO = Utility.createError(
					ErrorConstants.INTERNAL_SYSTEM_ERROR, e.getMessage());
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
			ErrorsDTO errorsDTO = Utility.createError(
					ErrorConstants.INTERNAL_SYSTEM_ERROR, e.getMessage());
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
			ErrorsDTO errorsDTO = Utility.createError(
					ErrorConstants.INTERNAL_SYSTEM_ERROR, e.getMessage());
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
	public Response getAddsByPriceFilter(@Context UriInfo uriInfo,
			@QueryParam("from") Integer from, @QueryParam("to") Integer to,
			@DefaultValue("ASC") @QueryParam("sort") String sortOrder) {
		System.out.println("lownewprice" + from);
		System.out.println("highprice" + to);
		System.out.println("order" + sortOrder);
		List<PostAdd> addList = null;
		Response response = null;
		if (from != null && to != null) {
			try {
				addList = dataServices.getAddList(from, to);
				// list of Add DTO
				List<PostDTO> listAddDTO = new ArrayList<PostDTO>();
				for (int i = 0; i < addList.size(); i++) {
					PostDTO postDTO = new PostDTO(addList.get(i));
					listAddDTO.add(postDTO);

				}
				GenericEntity<List<PostDTO>> genericEntity = new GenericEntity<List<PostDTO>>(
						listAddDTO) {
				};
				response = Response.status(Response.Status.OK)
						.entity(genericEntity).build();
			} catch (Exception e) {
				response = Response
						.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "Get Categories failed ::",
						e);
			}
		}
		if (from == null
				&& to == null
				&& sortOrder != null
				&& (sortOrder.equalsIgnoreCase("ASC") || sortOrder
						.equalsIgnoreCase("DESC"))) {
			try {
				addList = dataServices.getAddList(sortOrder);
				// list of Add DTO
				List<PostDTO> listAddDTO = new ArrayList<PostDTO>();
				for (int i = 0; i < addList.size(); i++) {
					PostDTO postDTO = new PostDTO(addList.get(i));
					listAddDTO.add(postDTO);

				}
				// GenericEntity<List<PostDTO>> genericEntity = new
				// GenericEntity<List<PostDTO>>(
				// listAddDTO) {
				// };
				response = Response.status(Response.Status.OK)
						.entity(listAddDTO).build();
			} catch (Exception e) {
				response = Response
						.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("error").build();
				logger.logException(LogLevel.ERROR, "Get Categories failed ::",
						e);
			}
		}
		return response;
	}

}
