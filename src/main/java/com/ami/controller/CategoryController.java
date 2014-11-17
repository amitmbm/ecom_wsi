package com.ami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.model.Category;
import com.ami.model.Status;
import com.ami.services.CategoryServices;

/*
 *  controller class for categories modify
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices;

//	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status createCategory(@RequestBody Category category) {
		try {
			categoryServices.addCategory(category);
			return new Status(1, "Category added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	Category getCategory(@PathVariable("id") long id) {
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
	Status deleteCategory(@PathVariable("id") long id) {

		try {
			categoryServices.deleteCategory(id);
			return new Status(1, "Category deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

}
