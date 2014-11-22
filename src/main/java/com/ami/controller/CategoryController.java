package com.ami.controller;

import javax.ws.rs.Consumes;
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
import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.enums.LogLevel;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;
import com.ami.services.CategoryServices;

/*
 *  controller class for categories
 */
@Component
@Path("/api/v1/manage/categories")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(CategoryController.class.getName());

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(
			CategoryDTO categoryDTO) 
	{
		logger.logMessage(LogLevel.INFO,"CategoryController called ");
		Response response = null;
		try {
			//categoryServices.validateCategory(categoryDTO);
			
			ProductCategory productCategory = categoryServices.addCategory(categoryDTO);
			response = Response.status(Response.Status.CREATED).entity(new CategoryDTO(productCategory)).build();
		}
		catch(CustomException e)
		{
			response = Response.status(Response.Status.BAD_REQUEST).entity("error").build();
		}
		catch (Exception e) {
			 e.printStackTrace();
			 response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error").build(); 
		}
		return response;
	}

	
	@PUT
	@Path("/{catguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(
			CategoryDTO categoryDTO,
			@PathParam("catguid") String catGuid
			) 
	{
		logger.logMessage(LogLevel.INFO,"CategoryController called ");
		Response response = null;
		try {
			//categoryServices.validateCategory(categoryDTO);
			ProductCategory productCategory = categoryServices.updateCategory(categoryDTO, catGuid);
			response = Response.status(Response.Status.OK).entity(new CategoryDTO(productCategory)).build();
		}
		catch(CustomException e)
		{
			response = Response.status(Response.Status.BAD_REQUEST).entity("error").build();
		}
		catch(ResourceNotFoundException re)
		{
			response = Response.status(Response.Status.NOT_FOUND).entity(" NOT_FOUND error").build();
		}
		catch (Exception e) {
			 e.printStackTrace();
			 response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error").build(); 
		}
		return response;
	}
	
	@POST
	@Path("/{catguid}/subcategories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSubCategory(
			SubCategoryDTO subCategoryDTO,
			@PathParam("catguid") String catGuid
			) 
	{
		logger.logMessage(LogLevel.INFO,"CategoryController called ");
		Response response = null;
		try {
			//categoryServices.validateCategory(subCategoryDTO);
			
			ProductSubCategory productSubCategory = categoryServices.addSubCategory(subCategoryDTO, catGuid);
			response = Response.status(Response.Status.CREATED).entity(new SubCategoryDTO(productSubCategory)).build();
		}
		catch(CustomException e)
		{
			response = Response.status(Response.Status.BAD_REQUEST).entity("error").build();
		}
		catch (Exception e) {
			 e.printStackTrace();
			 response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error").build(); 
		}
		return response;
	}
	
	/*@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	Category getCategory(@PathVariable("id") String id) {
		Category category = null;
		try {
			category = categoryServices.getCategoryById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Category> getCategories() {

		List<Category> categoryList = null;
		try {
			categoryList = categoryServices.getCategoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteCategory(@PathVariable("id") String id) {

		try {
			categoryServices.deleteCategory(id);
			return new Status(1, "Category deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}*/

}
