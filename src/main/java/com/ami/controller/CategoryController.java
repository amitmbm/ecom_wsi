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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.dto.TypeDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.entity.ProductSubCategoryType;
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

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			CategoryController.class.getName());

	// Below are the CRUD operations related to Category
	
	// post a category
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(CategoryDTO categoryDTO) {
		logger.logMessage(LogLevel.INFO, "POST Category called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);

			ProductCategory productCategory = categoryServices
					.addCategory(categoryDTO);
			response = Response.status(Response.Status.CREATED)
					.entity(new CategoryDTO(productCategory)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a category", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"exception occured while posting a category", e);
		}

		return response;
	}

	// Get Category
	@GET
	@Path("/{catguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getCategory(@PathParam("catguid") String catGuid) {
		ProductCategory productCategory = null;
		Response response = null;
		try {
			productCategory = categoryServices.getCategoryById(catGuid);
			response = Response.status(Response.Status.OK)
					.entity(new CategoryDTO(productCategory)).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" RESOURCE_NOT_FOUND Exception").build();
			logger.logException(LogLevel.ERROR, "Get Category failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Get category failed ::", e);
		}
		return response;
	}

	// update a category
	@PUT
	@Path("/{catguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(CategoryDTO categoryDTO,
			@PathParam("catguid") String catGuid) {
		logger.logMessage(LogLevel.INFO, "PUT Category called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			ProductCategory productCategory = categoryServices.updateCategory(
					categoryDTO, catGuid);
			response = Response.status(Response.Status.OK)
					.entity(new CategoryDTO(productCategory)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update category failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "update category failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "update category failed ::", e);
		}
		return response;
	}

	// Delete a Category
	@DELETE
	@Path("/{catguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteCategory(@PathParam("catguid") String catguid) {
		System.out.println("inside delete cat" + catguid);
		Response response = null;
		try {
			categoryServices.deleteCategory(catguid);
			response = Response.status(Response.Status.OK)
					.entity("Category deleted successfully").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "delete Category failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Deleted category failed ::", e);
		}
		return response;
	}

	// Below are the CRUD operations related to Sub-category

	// post a sub-category
	@POST
	@Path("{catguid}/subcategories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSubCategory(SubCategoryDTO subCategoryDTO,
			@PathParam("catguid") String catGuid) {
		logger.logMessage(LogLevel.INFO, "POST Sub-Category called ");
		Response response = null;
		try {
			// TODO
			// categoryServices.validateCategory(subCategoryDTO);

			ProductSubCategory productSubCategory = categoryServices
					.addSubCategory(subCategoryDTO, catGuid);
			response = Response.status(Response.Status.CREATED)
					.entity(new SubCategoryDTO(productSubCategory)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category failed ::", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category failed ::", e);
		}
		return response;
	}

	// Get Sub-Category
	@GET
	@Path("{catguid}/subcategories/{subcatguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getSubCategory(@PathParam("subcatguid") String subCatguid) {
		ProductSubCategory productSubCategory = null;
		Response response = null;
		try {
			productSubCategory = categoryServices
					.getSubCategoryById(subCatguid);
			response = Response.status(Response.Status.OK)
					.entity(new SubCategoryDTO(productSubCategory)).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR, "Get Sub-Category failed ::",
					re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Get Sub-category failed ::", e);
		}
		return response;
	}

	// update a sub-category
	@PUT
	@Path("{catguid}/subcategories/{subcatguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSubCategory(SubCategoryDTO subCategoryDTO,
			@PathParam("subcatguid") String subCatGuid) {
		logger.logMessage(LogLevel.INFO, "PUT Category called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			ProductSubCategory productSubCategory = categoryServices
					.updateSubCategory(subCategoryDTO, subCatGuid);
			response = Response.status(Response.Status.OK)
					.entity(new SubCategoryDTO(productSubCategory)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update sub-category failed ::", e);
		}
		return response;
	}

	// Delete a Sub-Category
	@DELETE
	@Path("{catguid}/subcategories/{subcatguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteSubCategory(@PathParam("subcatguid") String subcatguid) {
		Response response = null;
		try {
			categoryServices.deleteSubCategory(subcatguid);
			response = Response.status(Response.Status.OK)
					.entity("Sub-Category Deleted Successfully::").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR,
					"deleted Sub-Category failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"Deleted Sub-category failed ::", e);
		}
		return response;
	}

	// Get List of All the Category
	/*
	 * @GET
	 * 
	 * @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 * public Response getCategories() { List<ProductCategory> categoryList =
	 * null; Response response = null; try { categoryList =
	 * categoryServices.getCategoryList(); response =
	 * Response.status(Response.Status.OK).entity(categoryList).build();
	 * 
	 * } catch (Exception e) { response =
	 * Response.status(Response.Status.INTERNAL_SERVER_ERROR
	 * ).entity("error").build();
	 * logger.logException(LogLevel.ERROR,"Get Categories failed ::", e); }
	 * 
	 * return response; }
	 */

	// Get list of All the Sub-Categories
	@GET
	@Path("{catguid}/subcategories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getSubCategories() {
		List<ProductSubCategory> subCategoryList = null;
		Response response = null;
		try {
			subCategoryList = categoryServices.getSubCategoryList();
			response = Response.status(Response.Status.OK)
					.entity(subCategoryList).build();

		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR, "Get Sub-Categories failed ::",
					e);
		}

		return response;
	}

	/* Below are the CRUD operations on Sub-category Type */

	// post a sub-category type
	@POST
	@Path("{catguid}/subcategories/{subcatguid}/types")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSubCategoryType(TypeDTO typeDTO,
			@PathParam("subcatguid") String subCatguid) {
		logger.logMessage(LogLevel.INFO, "POST Sub-Category-TYPE called ");
		Response response = null;
		try {
			// TODO
			// categoryServices.validateCategory(subCategoryDTO);

			ProductSubCategoryType productSubCategoryType = categoryServices
					.addSubCategoryType(typeDTO, subCatguid);
			response = Response.status(Response.Status.CREATED)
					.entity(new TypeDTO(productSubCategoryType)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"Add Sub-Category-type failed ::", e);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"Add Sub-Category-type failed ::", e);
		}
		return response;
	}

	// Get Sub-Category-type
	@GET
	@Path("{catguid}/subcategories/{subcatguid}/types/{typeguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getSubCategoryType(@PathParam("typeguid") String typeGuid) {
		ProductSubCategoryType productSubCategoryType = null;
		Response response = null;
		try {
			productSubCategoryType = categoryServices
					.getSubCategoryTypeById(typeGuid);
			response = Response.status(Response.Status.OK)
					.entity(new TypeDTO(productSubCategoryType)).build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR,
					"Get Sub-Category-type failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"Get Sub-category-type failed ::", e);
		}
		return response;
	}

	// update a sub-category-type
	@PUT
	@Path("{catguid}/subcategories/{subcatguid}/types/{typeguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSubCategoryType(TypeDTO typeDTO,
			@PathParam("typeguid") String typeGuid) {
		logger.logMessage(LogLevel.INFO, "PUT Category called ");
		Response response = null;
		try {
			// categoryServices.validateCategory(categoryDTO);
			ProductSubCategoryType productSubCategoryType = categoryServices
					.updateSubCategoryType(typeDTO, typeGuid);
			response = Response.status(Response.Status.OK)
					.entity(new TypeDTO(productSubCategoryType)).build();
		} catch (CustomException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category-type failed ::", e);
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR,
					"update Sub-Category-type failed ::", re);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"update sub-category-type failed ::", e);
		}
		return response;
	}

	// Delete a Sub-Category-type
	@DELETE
	@Path("{catguid}/subcategories/{subcatguid}/types/{typeguid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteSubCategoryType(@PathParam("typeguid") String typeGuid) {
		Response response = null;
		try {
			categoryServices.deleteSubCategoryType(typeGuid);
			response = Response.status(Response.Status.OK)
					.entity("Sub-Category-type Deleted Successfully::").build();
		} catch (ResourceNotFoundException re) {
			response = Response.status(Response.Status.NOT_FOUND)
					.entity(" NOT_FOUND error").build();
			logger.logException(LogLevel.ERROR,
					"deleted Sub-Category-type failed ::", re);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("error").build();
			logger.logException(LogLevel.ERROR,
					"Deleted Sub-category-type failed ::", e);
		}
		return response;
	}

}
