package com.ami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.common.OperationResult;
import com.ami.common.OperationResultState;
import com.ami.creational.ILogger;
import com.ami.creational.LoggerManager;
import com.ami.dto.CategoryDTO;
import com.ami.enums.LogLevel;
import com.ami.exceptions.CustomException;
import com.ami.model.Category;
import com.ami.model.Status;
import com.ami.services.CategoryServices;

/*
 *  controller class for categories
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices;

	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(CategoryController.class.getName());

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(value=HttpStatus.CREATED , reason="category Added")
	public @ResponseBody
	ResponseEntity<OperationResult<String>> createCategory(@RequestBody CategoryDTO category) 
	{
		/* Create result object to send back the status of adding to the consumer */
		OperationResultState state = new OperationResultState();
		OperationResult<String> response = new OperationResult<String>();
		response.setOperationResultState(state);
		
		logger.logMessage(LogLevel.INFO,"CategoryController called ");
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			Category categoryDao=null;
			if(categoryServices.validateCategory(category))
			{
			    categoryDao = new Category();
				categoryDao.setCatId(category.getCatguid());
				categoryDao.setCategoryName(category.getCatName());
				categoryDao.setDesc(category.getCatDesc());
				categoryServices.addCategory(categoryDao);
				state.setSuccess(true);
				state.setDetailedMessage("Successfully added category");
				return new ResponseEntity<OperationResult<String>>(response, responseHeaders, HttpStatus.CREATED);
			}
			else
			{
				state.setSuccess(false);
				//TODO :-> change the msg
				state.setDetailedMessage("given data is not passed at server side validation");
				return new ResponseEntity<OperationResult<String>>(response, responseHeaders, HttpStatus.BAD_REQUEST);
			}
		}catch(CustomException e)
		{
			e.printStackTrace();
			logger.logException(LogLevel.ERROR, "exception occured while creating a category", e);
			/* Set failure status to the REST response object */
			state.setSuccess(false);
			state.setDetailedMessage(e.getMessage());
			response.setOperationResultState(state);
			return new ResponseEntity<OperationResult<String>>(response, responseHeaders, HttpStatus.BAD_REQUEST);
			
		}
		catch (Exception e) {
			 e.printStackTrace();
			 
			 logger.logException(LogLevel.ERROR, "exception occured while creating a category", e);
			 
			 /* Set failure status to the REST response object */
					state.setSuccess(false);
					state.setDetailedMessage(e.getMessage());
					response.setOperationResultState(state);
					return new ResponseEntity<OperationResult<String>>(response, responseHeaders, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
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

	}

}
